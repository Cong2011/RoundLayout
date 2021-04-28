package cn.cong.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import cn.cong.view.roundlayout.R;


/***圆角布局，可单独设置每个圆角，支持属性*/
public class RoundLayout extends FrameLayout {
    public RoundLayout(Context context) {
        this(context, null, 0);
    }

    public RoundLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.RoundLayout);
        int radius = ta.getDimensionPixelSize(R.styleable.RoundLayout_android_radius, 0);
        int lt = ta.getDimensionPixelSize(R.styleable.RoundLayout_android_topLeftRadius, radius);
        int rt = ta.getDimensionPixelSize(R.styleable.RoundLayout_android_topRightRadius, radius);
        int rb = ta.getDimensionPixelSize(R.styleable.RoundLayout_android_bottomRightRadius, radius);
        int lb = ta.getDimensionPixelSize(R.styleable.RoundLayout_android_bottomLeftRadius, radius);
        setRadius(lt, rt, rb, lb);
        ta.recycle();
        setWillNotDraw(false);
    }

    private final Path mPath = new Path();
    private final RectF rectF = new RectF();
    private final float[] radii = new float[8];

    public void setRadius(int lt, int rt, int rb, int lb) {
        this.radii[0] = lt;
        this.radii[1] = lt;
        this.radii[2] = rt;
        this.radii[3] = rt;
        this.radii[4] = rb;
        this.radii[5] = rb;
        this.radii[6] = lb;
        this.radii[7] = lb;
        invalidate();
    }

    public void setRadius(int radius) {
        setRadius(radius, radius, radius, radius);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.reset();
        rectF.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        mPath.addRoundRect(rectF, radii, Path.Direction.CCW);
        mPath.close();
        canvas.clipPath(mPath);
    }
}
