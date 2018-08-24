package patahai.digitopper.com.ptahailatestdesign;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class CustomFlashcardViewpager extends ViewPager {

    private boolean isPagingEnabled;

    public CustomFlashcardViewpager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.isPagingEnabled = true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(isPagingEnabled)
        return super.onInterceptTouchEvent(ev);
        else return false;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(isPagingEnabled)
        return super.onTouchEvent(ev);
        else return false;
    }

    public void setPagingEnabled(boolean isEnabled){

        isPagingEnabled = isEnabled;
    }
}
