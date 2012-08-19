package exam.project;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import exam.baibecktest.baibecktest;
import exam.saictest.saictest;
import exam.stai.x2.staix2test;

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
			switch (v.getId()) {
			case R.id.start:
				list();
				break;
			case R.id.pause:
				// 다이어로그창 (이 심리 검사에 대한 설명 결과값 설명)
				new AlertDialog.Builder(main.this)
						.setTitle("Music Mate")
						.setMessage(
								"1. 원하는 심리테스트를 선택합니다 \n"
										+ "2. 심리테스트의 문항을 체크한 뒤 결과보기를 선택하면 추천된 음악이 검색됩니다 \n"
										+ "3. 추천된 곡이 마음에 들면 추천하기! 를 누르면 당신의 의견이 반영됩니다\n")
						.setNegativeButton("Close",
								new DialogInterface.OnClickListener() {

									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub

									}
								}).show();
				break;

			case R.id.stop:
				finish();
				break;

			}
		}

		private void list() {
			new AlertDialog.Builder(main.this)
					.setTitle("테스트를 하나 선택하세요")
					.setItems(R.array.list,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									
									String[] list = getResources()
											.getStringArray(R.array.list);

									switch (which) {
									case 0:
										intent = new Intent(main.this,
												baibecktest.class);
										startActivity(intent);
										break;
									case 1:
										intent = new Intent(main.this,
												saictest.class);
										startActivity(intent);
										break;
									case 2:
										intent = new Intent(main.this,
												staix2test.class);
										startActivity(intent);
										break;
									}
								}
							}).setNegativeButton("취소", null).show();
		}
	}
}