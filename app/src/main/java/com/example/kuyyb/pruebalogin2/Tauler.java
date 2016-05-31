package com.example.kuyyb.pruebalogin2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by kuyyb on 30/05/2016.
 */
public class Tauler extends View {
    int taula[][];
    static final int AMPLE=6;
    static final int ALT=6;

    Paint p;

    public Tauler(Context context) { this(context, null, 0); }
    public Tauler(Context context, AttributeSet attrs) { this(context, attrs, 0); }
    public Tauler(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        taula = new int[AMPLE][ALT];
        p = new Paint();
        p.setStyle(Paint.Style.FILL);
        for (int i = 0; i < AMPLE; i++)
            for (int j = 0; j < ALT; j++)
                taula[i][j] = (i+j) % 6;
    }

    public void setCasella(int i, int j, int valor) {
        taula[i][j] = valor;
        this.invalidate();
    }

    @Override
    public void onMeasure(int widthSpec, int heightSpec) {
        int w = MeasureSpec.getSize(widthSpec);
        int h = MeasureSpec.getSize(heightSpec);
        if (w>h) w = h;
        else h = w;
        setMeasuredDimension(w, h);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int w = getWidth();
        int h = getHeight();
        if (w == 0) return;
        int qw = w / AMPLE;
        int qh = h / ALT;
        for (int i = 0; i < AMPLE; i++) {
            for (int j = 0; j < ALT; j++) {
                int x0 = i * qw;
                int x1 = x0 + qw;
                int y0 = j * qh;
                int y1 = y0 + qh;
                int valor = taula[i][j];
                switch (valor) {
                    case 0:
                        p.setColor(Color.BLACK);
                        break;
                    case 1:
                        p.setColor(Color.WHITE);
                        break;
                    case 2:
                        p.setColor(Color.BLUE);
                        break;
                    case 3:
                        p.setColor(Color.RED);
                        break;
                    case 4:
                        p.setColor(Color.YELLOW);
                        break;
                    case 5:
                        p.setColor(Color.GREEN);
                }
                canvas.drawRect(x0, y0, x1, y1, p);
            }
        }
    }
}

