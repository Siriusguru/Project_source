package exam.stai.x2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import exam.project.R;

public class staix2test extends Activity implements
		RadioGroup.OnCheckedChangeListener {

	/** Called when the activity is first created. */
	TextView list1, list2, list3, list4, list5, list6, list7, list8, list9,
			list10, list11, list12, list13, list14, list15, list16, list17,
			list18, list19, list20; // 질문이 들어갈 TextView를 선언한다.

	Button result; // 결과값 버튼

	RadioGroup listgroup1, listgroup2, listgroup3, listgroup4, listgroup5,
			listgroup6, listgroup7, listgroup8, listgroup9, listgroup10,
			listgroup11, listgroup12, listgroup13, listgroup14, listgroup15,
			listgroup16, listgroup17, listgroup18, listgroup19, listgroup20
			; // 레디오그륩 순서대로

	int sum; // 총 합을 구하기 위함

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.staix2test);
		// TODO Auto-generated method stub

		
		// 다이어로그창 (이 심리 검사에 대한 설명 결과값 설명)
				new AlertDialog.Builder(staix2test.this)
						.setTitle("특성 불안 척도")
						.setMessage("1) 특성불안의 측정. 상태 불안과 특성 불안을 측정하기 위한 STAI 중 특성불안을 측정하는 STAI-X2형. 총20문항.\n"
								+ "2) 원래 정상인의 불안 증상을 측정하는 도구로 개발되었으나, 임상집단의 불안 측정에도 유용한 것으로 밝혀짐.\n\n"
								+ "자기보고식. 각 문항을 경험하는 정도를 4점 척도로 평가.\n\n"
								+ "1) 각 문항의 점수를 합산하여 총점 구함.\n"
								+ "거의 그렇지 않다 = 1점\n" + "가끔 그렇다 = 2점\n" + "자주 그렇다 = 3점\n" + "거의 언제나 그렇다 = 4점")
						.setNegativeButton("Close",
								new DialogInterface.OnClickListener() {

									
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub

									}
								}).show();
		
		
		
		
		
		
		
		
		// 초기값
		list1 = (TextView) findViewById(R.id.baitext1);
		list2 = (TextView) findViewById(R.id.baitext2);
		list3 = (TextView) findViewById(R.id.baitext3);
		list4 = (TextView) findViewById(R.id.baitext4);
		list5 = (TextView) findViewById(R.id.baitext5);
		list6 = (TextView) findViewById(R.id.baitext6);
		list7 = (TextView) findViewById(R.id.baitext7);
		list8 = (TextView) findViewById(R.id.baitext8);
		list9 = (TextView) findViewById(R.id.baitext9);
		list10 = (TextView) findViewById(R.id.baitext10);
		list11 = (TextView) findViewById(R.id.baitext11);
		list12 = (TextView) findViewById(R.id.baitext12);
		list13 = (TextView) findViewById(R.id.baitext13);
		list14 = (TextView) findViewById(R.id.baitext14);
		list15 = (TextView) findViewById(R.id.baitext15);
		list16 = (TextView) findViewById(R.id.baitext16);
		list17 = (TextView) findViewById(R.id.baitext17);
		list18 = (TextView) findViewById(R.id.baitext18);
		list19 = (TextView) findViewById(R.id.baitext19);
		list20 = (TextView) findViewById(R.id.baitext20);
		

		listgroup1 = (RadioGroup) findViewById(R.id.bairadioGroup1);
		listgroup2 = (RadioGroup) findViewById(R.id.bairadioGroup2);
		listgroup3 = (RadioGroup) findViewById(R.id.bairadioGroup3);
		listgroup4 = (RadioGroup) findViewById(R.id.bairadioGroup4);
		listgroup5 = (RadioGroup) findViewById(R.id.bairadioGroup5);
		listgroup6 = (RadioGroup) findViewById(R.id.bairadioGroup6);
		listgroup7 = (RadioGroup) findViewById(R.id.bairadioGroup7);
		listgroup8 = (RadioGroup) findViewById(R.id.bairadioGroup8);
		listgroup9 = (RadioGroup) findViewById(R.id.bairadioGroup9);
		listgroup10 = (RadioGroup) findViewById(R.id.bairadioGroup10);
		listgroup11 = (RadioGroup) findViewById(R.id.bairadioGroup11);
		listgroup12 = (RadioGroup) findViewById(R.id.bairadioGroup12);
		listgroup13 = (RadioGroup) findViewById(R.id.bairadioGroup13);
		listgroup14 = (RadioGroup) findViewById(R.id.bairadioGroup14);
		listgroup15 = (RadioGroup) findViewById(R.id.bairadioGroup15);
		listgroup16 = (RadioGroup) findViewById(R.id.bairadioGroup16);
		listgroup17 = (RadioGroup) findViewById(R.id.bairadioGroup17);
		listgroup18 = (RadioGroup) findViewById(R.id.bairadioGroup18);
		listgroup19 = (RadioGroup) findViewById(R.id.bairadioGroup19);
		listgroup20 = (RadioGroup) findViewById(R.id.bairadioGroup20);
		

		// 라디오그룹의 체크값을 읽기위해 사용했다.
		listgroup1.setOnCheckedChangeListener(this);
		listgroup2.setOnCheckedChangeListener(this);
		listgroup3.setOnCheckedChangeListener(this);
		listgroup4.setOnCheckedChangeListener(this);
		listgroup5.setOnCheckedChangeListener(this);
		listgroup6.setOnCheckedChangeListener(this);
		listgroup7.setOnCheckedChangeListener(this);
		listgroup8.setOnCheckedChangeListener(this);
		listgroup9.setOnCheckedChangeListener(this);
		listgroup10.setOnCheckedChangeListener(this);
		listgroup11.setOnCheckedChangeListener(this);
		listgroup12.setOnCheckedChangeListener(this);
		listgroup13.setOnCheckedChangeListener(this);
		listgroup14.setOnCheckedChangeListener(this);
		listgroup15.setOnCheckedChangeListener(this);
		listgroup16.setOnCheckedChangeListener(this);
		listgroup17.setOnCheckedChangeListener(this);
		listgroup18.setOnCheckedChangeListener(this);
		listgroup19.setOnCheckedChangeListener(this);
		listgroup20.setOnCheckedChangeListener(this);
		

		result = (Button) findViewById(R.id.result);

		// 결과보기에 대한 리스너
		result.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Intent intent;
				// 데이터를 전달하기 위해 int형을 String으로 변환한다.
				String resultactivity; // int -> String으로 변환값을 받기 위한 변수
				resultactivity = Integer.toString(sum);

				// 총점으로 결과 액티비티 결정하는것
				// TODO Auto-generated method stub
				if (54 <= sum && sum <= 58) {
					intent = new Intent(staix2test.this, staix2anxiety.class);
					// intent.putExtra("sumresult", sum);
					// String을 새로운 Activity에 데이터를 전달한다.
					intent.putExtra("sum", resultactivity);
					startActivity(intent);
				} else if (59 <= sum && sum <= 63) {
					intent = new Intent(staix2test.this, staix2sanxiety.class);
					// intent.putExtra("sumresult", sum);
					// String을 새로운 Activity에 데이터를 전달한다.
					intent.putExtra("sum", resultactivity);
					startActivity(intent);
				} else if (sum >= 64) {
					intent = new Intent(staix2test.this, staix2esanxiety.class);
					// intent.putExtra("sumresult", sum);
					// String을 새로운 Activity에 데이터를 전달한다.
					intent.putExtra("sum", resultactivity);
					startActivity(intent);
				}

			}
		});

	}

	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		// RadioGroup 1번 그룹일때
		if (group == listgroup1) {
			if (checkedId == R.id.bairadio0) {
				sum += 1;
			} else if (checkedId == R.id.bairadio1) {
				sum += 2;
			} else if (checkedId == R.id.bairadio2) {
				sum += 3;
			} else {
				sum += 4;
			}
		} else if (group == listgroup2) {
			if (checkedId == R.id.bairadio0) {
				sum += 1;
			} else if (checkedId == R.id.bairadio1) {
				sum += 2;
			} else if (checkedId == R.id.bairadio2) {
				sum += 3;
			} else {
				sum += 4;
			}
		} else if (group == listgroup3) {
			if (checkedId == R.id.bairadio0) {
				sum += 1;
			} else if (checkedId == R.id.bairadio1) {
				sum += 2;
			} else if (checkedId == R.id.bairadio2) {
				sum += 3;
			} else {
				sum += 4;
			}
		} else if (group == listgroup4) {
			if (checkedId == R.id.bairadio0) {
				sum += 1;
			} else if (checkedId == R.id.bairadio1) {
				sum += 2;
			} else if (checkedId == R.id.bairadio2) {
				sum += 3;
			} else {
				sum += 4;
			}
		} else if (group == listgroup5) {
			if (checkedId == R.id.bairadio0) {
				sum += 1;
			} else if (checkedId == R.id.bairadio1) {
				sum += 2;
			} else if (checkedId == R.id.bairadio2) {
				sum += 3;
			} else {
				sum += 4;
			}
		} else if (group == listgroup6) {
			if (checkedId == R.id.bairadio0) {
				sum += 1;
			} else if (checkedId == R.id.bairadio1) {
				sum += 2;
			} else if (checkedId == R.id.bairadio2) {
				sum += 3;
			} else {
				sum += 4;
			}
		} else if (group == listgroup7) {
			if (checkedId == R.id.bairadio0) {
				sum += 1;
			} else if (checkedId == R.id.bairadio1) {
				sum += 2;
			} else if (checkedId == R.id.bairadio2) {
				sum += 3;
			} else {
				sum += 4;
			}
		} else if (group == listgroup8) {
			if (checkedId == R.id.bairadio0) {
				sum += 1;
			} else if (checkedId == R.id.bairadio1) {
				sum += 2;
			} else if (checkedId == R.id.bairadio2) {
				sum += 3;
			} else {
				sum += 4;
			}
		} else if (group == listgroup9) {
			if (checkedId == R.id.bairadio0) {
				sum += 1;
			} else if (checkedId == R.id.bairadio1) {
				sum += 2;
			} else if (checkedId == R.id.bairadio2) {
				sum += 3;
			} else {
				sum += 4;
			}
		} else if (group == listgroup10) {
			if (checkedId == R.id.bairadio0) {
				sum += 1;
			} else if (checkedId == R.id.bairadio1) {
				sum += 2;
			} else if (checkedId == R.id.bairadio2) {
				sum += 3;
			} else {
				sum += 4;
			}
		} else if (group == listgroup11) {
			if (checkedId == R.id.bairadio0) {
				sum += 1;
			} else if (checkedId == R.id.bairadio1) {
				sum += 2;
			} else if (checkedId == R.id.bairadio2) {
				sum += 3;
			} else {
				sum += 4;
			}
		} else if (group == listgroup12) {
			if (checkedId == R.id.bairadio0) {
				sum += 1;
			} else if (checkedId == R.id.bairadio1) {
				sum += 2;
			} else if (checkedId == R.id.bairadio2) {
				sum += 3;
			} else {
				sum += 4;
			}
		} else if (group == listgroup13) {
			if (checkedId == R.id.bairadio0) {
				sum += 1;
			} else if (checkedId == R.id.bairadio1) {
				sum += 2;
			} else if (checkedId == R.id.bairadio2) {
				sum += 3;
			} else {
				sum += 4;
			}
		} else if (group == listgroup14) {
			if (checkedId == R.id.bairadio0) {
				sum += 1;
			} else if (checkedId == R.id.bairadio1) {
				sum += 2;
			} else if (checkedId == R.id.bairadio2) {
				sum += 3;
			} else {
				sum += 4;
			}
		} else if (group == listgroup15) {
			if (checkedId == R.id.bairadio0) {
				sum += 1;
			} else if (checkedId == R.id.bairadio1) {
				sum += 2;
			} else if (checkedId == R.id.bairadio2) {
				sum += 3;
			} else {
				sum += 4;
			}
		} else if (group == listgroup16) {
			if (checkedId == R.id.bairadio0) {
				sum += 1;
			} else if (checkedId == R.id.bairadio1) {
				sum += 2;
			} else if (checkedId == R.id.bairadio2) {
				sum += 3;
			} else {
				sum += 4;
			}
		} else if (group == listgroup17) {
			if (checkedId == R.id.bairadio0) {
				sum += 1;
			} else if (checkedId == R.id.bairadio1) {
				sum += 2;
			} else if (checkedId == R.id.bairadio2) {
				sum += 3;
			} else {
				sum += 4;
			}
		} else if (group == listgroup18) {
			if (checkedId == R.id.bairadio0) {
				sum += 1;
			} else if (checkedId == R.id.bairadio1) {
				sum += 2;
			} else if (checkedId == R.id.bairadio2) {
				sum += 3;
			} else {
				sum += 4;
			}
		} else if (group == listgroup19) {
			if (checkedId == R.id.bairadio0) {
				sum += 1;
			} else if (checkedId == R.id.bairadio1) {
				sum += 2;
			} else if (checkedId == R.id.bairadio2) {
				sum += 3;
			} else {
				sum += 4;
			}
		} else if (group == listgroup20) {
			if (checkedId == R.id.bairadio0) {
				sum += 1;
			} else if (checkedId == R.id.bairadio1) {
				sum += 2;
			} else if (checkedId == R.id.bairadio2) {
				sum += 3;
			} else {
				sum += 4;
			}
		
		}
	}
}
