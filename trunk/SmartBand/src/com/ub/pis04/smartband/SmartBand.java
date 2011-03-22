package com.ub.pis04.smartband;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TableRow.LayoutParams;  
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class SmartBand extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        setContentView(R.layout.main);
        createTable(10,20);
       
        }  
        //
    
    
    public void createTable(int cols, int rows){
    	
    	int cont = 0;
    	TableLayout table = (TableLayout)this.findViewById(R.id.table);
    	for(int i =0;i < rows;i++){
    		
    		TableRow tr = new TableRow(this);
      			
    			tr.setBackgroundColor(Color.parseColor("#181C18"));
    	
    			
    			cont++;
    		for(int j=0;j < cols;j++){
    			TableRow.LayoutParams rowLayout = new  TableRow.LayoutParams(
                        								TableRow.LayoutParams.FILL_PARENT,
                        								TableRow.LayoutParams.FILL_PARENT);
    			rowLayout.width=50;
    			rowLayout.setMargins(3, 2, 3, 2);
    			TextView td = new TextView(this);
    			td.setId(cont);
    			td.setWidth(50);
    			
    			td.setLayoutParams(rowLayout);
    			td.getLayoutParams().width=30;
    			
    			//td.setLayoutParams(tableRowParams);
    			td.setBackgroundColor(Color.parseColor("#000000"));
    			cont++;
    			//td.invalidate();
    			//
    			tr.addView(td);
    			//tr.invalidate();
    			
    		}
    		//tr.setLayoutParams(tableRowParams);
    		table.addView(tr);
    		
    	}
    	
    	
    }
}