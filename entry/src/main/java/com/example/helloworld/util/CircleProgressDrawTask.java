package com.example.helloworld.util;

import ohos.agp.components.Component;
import ohos.agp.render.Arc;
import ohos.agp.render.Canvas;
import ohos.agp.render.Paint;
import ohos.agp.utils.Color;
import ohos.agp.utils.RectFloat;

public class CircleProgressDrawTask implements Component.DrawTask {
    // 用于配置圆环的粗细，具体参数可以在xml文件中配置
    private static final String STROKE_WIDTH_KEY = "stroke_width";

    // 用于配置圆环的最大值，具体参数可以在xml文件中配置
    private static final String MAX_PROGRESS_KEY = "max_progress";

    // 用于配置圆环的当前值，具体参数可以在xml文件中配置
    private static final String CURRENT_PROGRESS_KEY = "current_progress";

    // 用于配置起始位置的颜色，具体参数可以在xml文件中配置
    private static final String START_COLOR_KEY = "start_color";

    // 用于配置结束位置的颜色，具体参数可以在xml文件中配置
    private static final String END_COLOR_KEY = "end_color";

    // 用于配置背景色，具体参数可以在xml文件中配置
    private static final String BACKGROUND_COLOR_KEY = "background_color";

    // 用于配置起始位置的角度，具体参数可以在xml文件中配置
    private static final String START_ANGLE = "start_angle";

    private static final float MAX_ARC = 360f;

    private static final int DEFAULT_STROKE_WIDTH = 12;

    private static final int DEFAULT_MAX_VALUE = 100;

    private static final int DEFAULT_START_COLOR = 0xFFB566FF;

    private static final int DEFAULT_END_COLOR = 0xFF8A2BE2;

    private static final int DEFAULT_BACKGROUND_COLOR = 0x59FFFFFF;

    private static final int DEFAULT_START_ANGLE = -90;

    private static final float DEFAULT_LINER_MAX = 100f;

    private static final int HALF = 2;

    // 圆环的宽度, 默认10个像素
    private int myStrokeWidth = DEFAULT_STROKE_WIDTH;

    // 最大的进度值, 默认是100
    private int myMaxValue = DEFAULT_MAX_VALUE;

    // 当前的进度值, 默认是0
    private int myCurrentValue = 0;

    // 起始位置的颜色, 默认浅紫色
    private Color myStartColor = new Color(DEFAULT_START_COLOR);

    // 结束位置的颜色, 默认深紫色
    private Color myEndColor = new Color(DEFAULT_END_COLOR);

    // 背景颜色, 默认浅灰色
    private Color myBackgroundColor = new Color(DEFAULT_BACKGROUND_COLOR);

    // 当前的进度值, 默认从-90度进行绘制
    private int myStartAngle = DEFAULT_START_ANGLE;

    private Component myComponent;

    // 传入要进行修改的component
    public CircleProgressDrawTask(Component component) {
        myComponent = component;
        myComponent.addDrawTask(this);
    }

    // 设置当前进度并且刷新component，value值为当前进度
    public void setValue(int value) {
        myCurrentValue = value;
        myComponent.invalidate();
    }

    public void setMaxValue(int maxValue) {
        myMaxValue = maxValue;
        myComponent.invalidate();
    }

    @Override
    public void onDraw(Component component, Canvas canvas) {
        // 通过canvas实现绘制圆环的功能
        Paint paint = new Paint();
        paint.setAntiAlias(true);   // 抗锯齿
        paint.setStyle(Paint.Style.STROKE_STYLE);

        paint.setStrokeWidth(myStrokeWidth);
        paint.setColor(myBackgroundColor);
        canvas.drawCircle(233, 233, 220, paint);
        canvas.save();

        paint.setColor(new Color(DEFAULT_START_COLOR));
        paint.setStrokeWidth(myStrokeWidth);
        paint.setStrokeCap(Paint.StrokeCap.ROUND_CAP);
        RectFloat rect = new RectFloat(13, 13, 453, 453);
        Arc arc = new Arc(myStartAngle, 230, false);
        canvas.drawArc(rect, arc, paint);

    }
}
