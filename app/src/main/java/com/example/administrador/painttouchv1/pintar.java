package com.example.administrador.painttouchv1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.Console;
import java.util.Random;

/**
 * Created by Administrador on 27/01/2017.
 */

public class pintar extends View {

    private Paint pincel;
    private Path ruta;

    public pintar(Context con) {
        super(con);
        ruta=new Path();
        pincel=pincelColor();
    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawPath(ruta,pincel);
    }

    @Override
    public boolean onTouchEvent(MotionEvent evento) {
        float ex = evento.getX();
        float ey = evento.getY();

        switch (evento.getAction()) {
            case MotionEvent.ACTION_DOWN:
                ruta.reset();
                pincel=pincelColor();
                ruta.moveTo(ex, ey);
                return true;
            case MotionEvent.ACTION_MOVE:
                ruta.lineTo(ex, ey);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }

    public Paint pincelColor(){
        Random rnd = new Random();
        Paint pcolor=new Paint();
        pcolor.setAntiAlias(true);
        pcolor.setStrokeWidth(6f);
        pcolor.setARGB(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        pcolor.setStyle(Paint.Style.STROKE);
        pcolor.setStrokeJoin(Paint.Join.ROUND);

        return pcolor;
    }
}
