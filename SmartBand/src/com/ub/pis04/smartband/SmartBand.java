package com.ub.pis04.smartband;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TableRow.LayoutParams;  
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.util.Timer ;

public class SmartBand extends Activity {
    /** Called when the activity is first created. */
	private Button backB ;
	private Timer myTimer;
	private int contRel = 0;
	private HorizontalScrollView scroll;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final int seconds=0;
        this.backB = (Button)findViewById(R.id.back);
        scroll = (HorizontalScrollView) findViewById(R.id.scrolls);
        createTable(1000,6);
       
        this.backB.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				 myTimer = new Timer();
					myTimer.schedule(new TimerTask() {
						@Override
						public void run() {
							TimerMethod();
						}

					}, 0, 1000);
				//setContentView(R.layout.add);
				
			}
        	
        	
        });
       
        
        
        
        }  
        //
    
    private void TimerMethod()
	{
		//This method is called directly by the timer
		//and runs in the same thread as the timer.

		//We call the method that will work with the UI
		//through the runOnUiThread method.
		this.runOnUiThread(Timer_Tick);
	}

	private Runnable Timer_Tick = new Runnable() {
		public void run() {

		//This method runs in the same thread as the UI.    	       

		//Do something to the UI thread here
			
			
							//TextView td1 = (TextView) findViewById(i);
				for(int j=0;j<6;j++){
					int id = (j*1000)+contRel;
					//Log.i(String.valueOf(id), "id");
					TextView tdAnt = (TextView) findViewById(id-1);
					if(tdAnt!=null){
						tdAnt.setBackgroundColor(Color.parseColor("#000000"));
						
					}
					
						
					TextView td1 = (TextView) findViewById(id);
					
					if(td1!=null)
						td1.setBackgroundColor(Color.parseColor("#F80303"));
					
				
				
			}
				
				if(scroll!=null && contRel % 5 == 0 ){
					
					int x =scroll.getScrollX();
					int y = scroll.getScrollY();
					
					Log.i(String.valueOf(x),"x");
					scroll.scrollBy(x+40, y);
					
				
			}
				contRel++;
			
		}
	};
    
    
    public void createTable(int cols, int rows){
    	
    	int cont = 0;
    	int rowId=6000;
    	TableLayout table = (TableLayout)this.findViewById(R.id.table);
    	for(int i =0;i < rows;i++){
    		
    		TableRow tr = new TableRow(this);
    		    rowId++;
    			tr.setBackgroundColor(Color.parseColor("#181C18"));
    	
    			
    			
    			//cont++;
    		for(int j=0;j < cols;j++){
    			TableRow.LayoutParams rowLayout = new  TableRow.LayoutParams(
                        								TableRow.LayoutParams.FILL_PARENT,
                        								TableRow.LayoutParams.WRAP_CONTENT);
    			rowLayout.width=30;
    			rowLayout.height=30;
    			rowLayout.setMargins(2, 2, 2, 2);
    			TextView td = new TextView(this);
    			td.setId(cont);
    			td.setWidth(50);
    			
    			td.setLayoutParams(rowLayout);
    			td.getLayoutParams().width=20;
    			
    			//td.setLayoutParams(tableRowParams);
    			td.setBackgroundColor(Color.parseColor("#000000"));
    			
    			cont++;
    			//td.invalidate();
    			td.setText(String.valueOf(cont));
    			//
    			td.setOnClickListener(myClickListener);
    			tr.addView(td);
    			//tr.invalidate();
    			
    		}
    		//tr.setLayoutParams(tableRowParams);
    		table.addView(tr);
    		
    	}
    	
    	
    }
    OnClickListener myClickListener = new OnClickListener() {
		public void onClick(View v) {
			v.setBackgroundColor(Color.parseColor("#636363"));
		}
	};
    	
    	
    
}