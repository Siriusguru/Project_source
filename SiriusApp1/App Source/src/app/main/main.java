package app.main;



import today.song.todaymain;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import app.help.help;

import MusicMate.song.R;

public class main extends Activity {
	/** Called when the activity is first created. */
	Button start, pause, stop;
	Intent intent;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		start = (Button) findViewById(R.id.start);
		pause = (Button) findViewById(R.id.pause);
		stop = (Button) findViewById(R.id.stop);
		start.setOnClickListener(new ButtonHandler());
		pause.setOnClickListener(new ButtonHandler());
		stop.setOnClickListener(new ButtonHandler());
		

	}

	private class ButtonHandler implements View.OnClickListener {
		public void onClick(View v) {
			Intent intent;
			switch (v.getId()) {
			case R.id.start:
				
				intent = new Intent(main.this, todaymain.class);
				startActivity(intent);
				// list();
				break;
			case R.id.pause:
				/*
				 * // ?�이?�로그창 (???�리 �?��????�� ?�명 결과�??�명) new
				 * AlertDialog.Builder(main.this) .setTitle("Music Mate")
				 * .setMessage( "1. ?�하???�리?�스?��? ?�택?�니??\n" +
				 * "2. ?�리?�스?�의 문항??체크????결과보기�??�택?�면 추천???�악??�?��?�니??\n" +
				 * "3. 추천??곡이 마음???�면 추천?�기! �??�르�??�신???�견??반영?�니??n")
				 * .setNegativeButton("Close", new
				 * DialogInterface.OnClickListener() {
				 * 
				 * public void onClick(DialogInterface dialog, int which) { //
				 * TODO Auto-generated method stub
				 * 
				 * } }).show();
				 */
				intent = new Intent(main.this, help.class);
				startActivity(intent);
				break;

			case R.id.stop:
				finish();
				break;

			}
		}
		/*
		 * private void list() { new AlertDialog.Builder(main.this)
		 * .setTitle("?�스?��? ?�나 ?�택?�세??") .setItems(R.array.list, new
		 * DialogInterface.OnClickListener() { public void
		 * onClick(DialogInterface dialog, int which) { // TODO Auto-generated
		 * method stub
		 * 
		 * String[] list = getResources() .getStringArray(R.array.list);
		 * 
		 * switch (which) { case 0: intent = new Intent(main.this,
		 * baibecktest.class); startActivity(intent); break; case 1: intent =
		 * new Intent(main.this, saictest.class); startActivity(intent); break;
		 * case 2: intent = new Intent(main.this, staix2test.class);
		 * startActivity(intent); break; } } }).setNegativeButton("취소",
		 * null).show(); }
		 */
	}
}