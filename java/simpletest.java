package com.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class simpletest extends Activity implements AdapterView.OnItemSelectedListener  {
	Spinner time, weather, emotion;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.simpletest);
	    // TODO Auto-generated method stub
	    time=(Spinner)findViewById(R.id.spintime);
	    time.setOnItemSelectedListener( this);
	    weather=(Spinner)findViewById(R.id.spinweather);
	    weather.setOnItemSelectedListener( this);
	    emotion=(Spinner)findViewById(R.id.spinemotion);
	    emotion.setOnItemSelectedListener( this);
	}
	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long id) {
		//�ð��� ���� ���� ������ ���� ��� �Ϸ�
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
}
