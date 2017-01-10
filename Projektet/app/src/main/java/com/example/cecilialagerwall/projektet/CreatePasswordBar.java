package com.example.cecilialagerwall.projektet;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Create a passwordbar. Update the bar by calling setColor and the strength passed in the interval 0-1.
 * Color: 1=green, over 0.7 blue, over 0.4 yellow, over 0.2 green and otherwise light gray.
 * Created by cecilialagerwall on 2016-12-16.
 * @author Cecilia Lagerwall
 */

public class CreatePasswordBar extends View {
    Context context;
    Paint paint = new Paint();
    double fillBar;
    int color;

    public CreatePasswordBar(Context context){
        super(context);
        this.context = context;
    }

    public CreatePasswordBar(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        paint.setStrokeWidth(2);
        paint.setColor(color);
        paint.setStrokeWidth(20);

        //fill the bar
        canvas.drawLine(0, 0, Math.round(fillBar), 0, paint);

        paint.setColor(Color.LTGRAY);
        canvas.drawLine(Math.round(fillBar), 0, getWidth(), 0, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec,int heightMeasureSpec){
        int w = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(w, 25);
    }

    /**Updated the color of the bar based on the value of the password strength*/
    public void setColor(double strength){
        if (strength == 1.0){
            fillBar = getWidth();
            color = Color.GREEN;
        } else if (strength < 1.0 && strength > 0.7){
            fillBar = getWidth() * strength;
            color = Color.BLUE;
        } else if (strength <= 0.7 && strength > 0.4){
            fillBar = getWidth() * strength;
            color = Color.YELLOW;
        } else if (strength <= 0.4 && strength > 0.2){
            fillBar = getWidth() * strength;
            color = Color.RED;
        } else {
            fillBar = getWidth();
            color = Color.LTGRAY;
        }

        invalidate();
    }
}