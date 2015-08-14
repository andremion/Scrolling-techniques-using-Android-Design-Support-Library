package com.example.andremion.designsupportlibrary;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

@CoordinatorLayout.DefaultBehavior(CustomView.Behavior.class)
public class CustomView extends TextView {

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public static class Behavior extends CoordinatorLayout.Behavior<CustomView> {

        @Override
        public boolean layoutDependsOn(CoordinatorLayout parent, CustomView child, View dependency) {
            return dependency instanceof AppBarLayout;
        }

        @Override
        public boolean onDependentViewChanged(CoordinatorLayout parent, CustomView child, View dependency) {
            if (dependency instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) dependency;
                Rect rect = new Rect();
                appBarLayout.getHitRect(rect);
                if (rect.bottom <= ViewCompat.getMinimumHeight(appBarLayout)) {
                    hide(child, parent.getHeight());
                } else {
                    show(child, parent.getHeight() - child.getHeight());
                }
                return true;
            }
            return false;
        }

        private void show(View view, float y) {
            view.animate().y(y);
        }

        private void hide(View view, float y) {
            view.animate().y(y);
        }
    }

}
