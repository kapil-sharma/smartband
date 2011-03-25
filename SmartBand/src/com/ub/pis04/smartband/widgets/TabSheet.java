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
	private int offX = 0, posIniX = 0;
	private int direccio = 0;
	private ArrayList<Object> dades = new ArrayList<Object>();
	
	public TabSheet(Context context) {
		super(context);
		
		bmp = BitmapFactory.decodeResource(getResources(), R.drawable.col);
		colWidth = bmp.getWidth();
		colHeight = bmp.getHeight()/6;
		
		for(int i = colIni; i < colFi; i++){
			dades.add(new Object[6]);
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		width = getWidth();
		heght = getHeight();
		numCols = (width / colWidth);
		colIni = 0;
		colFi = numCols;
		
		Paint paint = new Paint();
		paint.setColor(Color.parseColor("#00FF00"));
		paint.setStyle(Paint.Style.STROKE);

		for(int i = colIni; i < colFi; i++){
			//Object[] col = (Object[]) dades.get(i); //Obtindre dades
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
		} if (event.getAction() == MotionEvent.ACTION_MOVE) {
			
			if(posIniX < (int) event.getX()){
				offX++;
			} else{
				if(offX > 0) offX--;
			}
		}
		invalidate();
		return true;
	}
}
