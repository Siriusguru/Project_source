package com.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class APP06_DialogActivity extends Activity {
	
    /** Called when the activity is first created. */
	Button start;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        start = (Button)findViewById(R.id.start);
        start.setOnClickListener(new ButtonHandler());
    }
    private class ButtonHandler implements View.OnClickListener {
    	public void onClick(View v) {
    		switch(v.getId()) {
    		case R.id.start:
    			list(); break;
    		}
    	}
    	
    private void list() {
    	new AlertDialog.Builder(APP06_DialogActivity.this)
    	.setTitle("테스트를 하나 선택하세요")
    	.setItems(R.array.list, new DialogInterface.OnClickListener() {		
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				String[] list = getResources().getStringArray(R.array.list);
				
				switch(which) {
				case 0:
					Intent intent = new Intent(APP06_DialogActivity.this, simpletest.class);
					startActivity(intent);
					break;
				case 1:
					intent = new Intent(APP06_DialogActivity.this, baibecktest.class);
					startActivity(intent);
					break;
				}
			}
		}).setNegativeButton("취소", null).show();
    }
 
    }
    
}