package com.ub.pis04.smartband.widgets;

import java.util.ArrayList;

import com.ub.pis04.smartband.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

public class TabSheet extends View {

    int width, heght, numCols, colIni, colFi, posX, posY;
	ArrayList cols = new ArrayList();
    
	public TabSheet(Context context) {
		super(context);
		
		width = getWidth();
		heght = getHeight();
		numCols = (width / TabCol.width) + 1;
		colIni = 0;
		colFi = numCols;
		posX = 0;
		posY = 100;
		
		for(int i=0; i< numCols; i++){
			cols.add(new TabCol(context));
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		
		for(int i = colIni; i< colFi; i++){
			TabCol tb = (TabCol)cols.get(i);
			tb.setX(posX);
			tb.setY(PosY);
			tb.draw(canvas);
		}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return super.onTouchEvent(event);
	}
}
