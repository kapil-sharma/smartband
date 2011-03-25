package com.ub.pis04.smartband.widgets;

import java.util.ArrayList;

import com.ub.pis04.smartband.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.PaintDrawable;
import android.text.method.Touch;
import android.text.style.StyleSpan;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;

public class TabSheet extends View{

    private Bitmap bmp = null;
	private int width, heght, numCols;
	private int colIni, colFi;
	private int colWidth, colHeight;
	private long offX = 0, posIniX = 0, posMovX = 0, temps = 0;
	private ArrayList<Object> dades = new ArrayList<Object>();
	
	public TabSheet(Context context) {
		super(context);
		
		bmp = BitmapFactory.decodeResource(getResources(), R.drawable.col);
		colWidth = bmp.getWidth();
		colHeight = (bmp.getHeight()-20)/6;
		width = getWidth();
		heght = getHeight();
		numCols = (width / colWidth);
		colIni = 0;
		colFi = numCols+2;
		
		for(int i = colIni; i < colFi+2; i++){
			dades.add(new Object[6]);
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		width = getWidth();
		heght = getHeight();
		canvas.drawColor(Color.parseColor("#E1E1E1"));
		Paint paint = new Paint();
		
		paint.setStyle(Paint.Style.STROKE);

		for(int i = colIni; i < colFi; i++){
			//Object[] col = (Object[]) dades.get(i); //Obtindre dades
			canvas.drawBitmap(bmp, 3+colWidth*i+offX, colHeight, paint);
			paint.setColor(Color.parseColor("#000000"));
			canvas.drawText("05", colWidth*i+offX, colHeight*9, paint);
			paint.setColor(Color.parseColor("#00FF00"));
			for(int j = 0; j < 6; j++){
				canvas.drawRect(3+colWidth*i+offX,colHeight*(j+1),3+colWidth*(i+1)+offX,colHeight*(j+2),paint);
				//fer coses amb dades
			}
		}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			posIniX = (int) event.getX();
			posMovX = (int) event.getX();
		} if (event.getAction() == MotionEvent.ACTION_MOVE) {
			if(posMovX > (int) event.getX()){
				offX -= 5;
				if(Math.abs(offX%(colWidth+1)) < 5){
					colFi++;
					dades.add(new Object[6]);
				}
			} else{
				if(offX <= 0){
					offX += 5;
				}
			}
			posMovX = (int) event.getX();
		}
		invalidate();
		return true;
	}
}
