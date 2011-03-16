package com.ub.pis04.smartband.widgets;

import com.ub.pis04.smartband.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

public class TabCol extends View{
	
	public static final int width = 48;
	public static final int height = 146;

    Bitmap bmp = null;
	
	public TabCol(Context context) {
		super(context);
		
		bmp = BitmapFactory.decodeResource(getResources(), R.drawable.col);
	}
	
	@Override
	public void draw(Canvas canvas) {
		
		super.draw(canvas);
	}
}
