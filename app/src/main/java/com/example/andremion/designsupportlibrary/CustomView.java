package com.example.andremion.designsupportlibrary;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

import com.google.android.material.appbar.AppBarLayout;

public class CustomView extends AppCompatTextView implements CoordinatorLayout.AttachedBehavior {

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @NonNull
    @Override
    public CoordinatorLayout.Behavior getBehavior() {
        return new Behavior();
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
