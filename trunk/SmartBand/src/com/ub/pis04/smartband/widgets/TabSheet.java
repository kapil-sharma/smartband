package com.ub.pis04.smartband.widgets;

import com.ub.pis04.smartband.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

public class TabSheet extends View {

    Bitmap bmp = null;
	int width, heght, numCols;
	int colIni, colFi, posX;
	int posY, colWidth, colHeight;
    int posAnt = 0;
	int direccio = 0;
	
	public TabSheet(Context context) {
		super(context);
		
		bmp = BitmapFactory.decodeResource(getResources(), R.drawable.col);
		colWidth = bmp.getWidth();
		colHeight = bmp.getHeight();
		width = getWidth();
		heght = getHeight();
		numCols = (width / colWidth) + 1;
		colIni = 0;
		colFi = numCols;
		posX = 0;
		posY = 100;
		
		for(int i=0; i< numCols; i++){
		
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		
		for(int i = colIni; i< colFi; i++){
			
		}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_MOVE) {
			if(posAnt != 0) posAnt = (int)event.getX();
			direccio = posAnt - (int)event.getX();
			if(direccio > 0){ //Movem dreta
				
			} else{  //Movem esquerra
				
			}
		}
		return true;
	}
}
