package exam.baibecktest;

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

public class baibecktest extends Activity implements
		RadioGroup.OnCheckedChangeListener {

	/** Called when the activity is first created. */
	TextView list1, list2, list3, list4, list5, list6, list7, list8, list9,
			list10, list11, list12, list13, list14, list15, list16, list17,
			list18, list19, list20, list21; // 질문이 들어갈 TextView를 선언한다.

	Button result; // 결과값 버튼

	RadioGroup listgroup1, listgroup2, listgroup3, listgroup4, listgroup5,
			listgroup6, listgroup7, listgroup8, listgroup9, listgroup10,
			listgroup11, listgroup12, listgroup13, listgroup14, listgroup15,
			listgroup16, listgroup17, listgroup18, listgroup19, listgroup20,
			listgroup21; // 레디오그륩 순서대로

	int sum; // 총 합을 구하기 위함

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.baibecktest);
		// TODO Auto-generated method stub

		
		// 다이어로그창 (이 심리 검사에 대한 설명 결과값 설명)
				new AlertDialog.Builder(baibecktest.this)
						.setTitle("Beck 자기평가 불안척도")
						.setMessage(
								"▣ 아래의 항목들은 불안의 일반적 증상들을 열거한 것입니다. 먼저 각 항목을 주의 깊게 읽으십시오. 오늘을 포함해서 지난 한 주 동안 귀하가 경험한 증상의 정도를 아래와 같이 그 정도에 따라 적당한 숫자에 ◯표시 하십시오.\n\n"
										+ "A(0점) : 전혀 느끼지 않는다.\n"
										+ "B(1점) : 조금 느꼈다. 그러나 별 문제가 되지 않는다.\n"
										+ "C(2점) : 상당히 느꼈다. 힘들었으나 견딜 수 있었다.\n"
										+ "D(3점) : 심하게 느꼈다. 견디기가 힘들었다.\n")
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
		list21 = (TextView) findViewById(R.id.baitext21);

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
		listgroup21 = (RadioGroup) findViewById(R.id.bairadioGroup21);

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
		listgroup21.setOnCheckedChangeListener(this);

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
				if (22 <= sum && sum <= 26) {
					intent = new Intent(baibecktest.this, baianxiety.class);
					// intent.putExtra("sumresult", sum);
					// String을 새로운 Activity에 데이터를 전달한다.
					intent.putExtra("sum", resultactivity);
					startActivity(intent);
				} else if (27 <= sum && sum <= 31) {
					intent = new Intent(baibecktest.this, baisanxiety.class);
					// intent.putExtra("sumresult", sum);
					// String을 새로운 Activity에 데이터를 전달한다.
					intent.putExtra("sum", resultactivity);
					startActivity(intent);
				} else if (sum >= 32) {
					intent = new Intent(baibecktest.this, baiesanxiety.class);
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
				sum += 0;
			} else if (checkedId == R.id.bairadio1) {
				sum += 1;
			} else if (checkedId == R.id.bairadio2) {
				sum += 2;
			} else {
				sum += 3;
			}
		} else if (group == listgroup2) {
			if (checkedId == R.id.bairadio0) {
				sum += 0;
			} else if (checkedId == R.id.bairadio1) {
				sum += 1;
			} else if (checkedId == R.id.bairadio2) {
				sum += 2;
			} else {
				sum += 3;
			}
		} else if (group == listgroup3) {
			if (checkedId == R.id.bairadio0) {
				sum += 0;
			} else if (checkedId == R.id.bairadio1) {
				sum += 1;
			} else if (checkedId == R.id.bairadio2) {
				sum += 2;
			} else {
				sum += 3;
			}
		} else if (group == listgroup4) {
			if (checkedId == R.id.bairadio0) {
				sum += 0;
			} else if (checkedId == R.id.bairadio1) {
				sum += 1;
			} else if (checkedId == R.id.bairadio2) {
				sum += 2;
			} else {
				sum += 3;
			}
		} else if (group == listgroup5) {
			if (checkedId == R.id.bairadio0) {
				sum += 0;
			} else if (checkedId == R.id.bairadio1) {
				sum += 1;
			} else if (checkedId == R.id.bairadio2) {
				sum += 2;
			} else {
				sum += 3;
			}
		} else if (group == listgroup6) {
			if (checkedId == R.id.bairadio0) {
				sum += 0;
			} else if (checkedId == R.id.bairadio1) {
				sum += 1;
			} else if (checkedId == R.id.bairadio2) {
				sum += 2;
			} else {
				sum += 3;
			}
		} else if (group == listgroup7) {
			if (checkedId == R.id.bairadio0) {
				sum += 0;
			} else if (checkedId == R.id.bairadio1) {
				sum += 1;
			} else if (checkedId == R.id.bairadio2) {
				sum += 2;
			} else {
				sum += 3;
			}
		} else if (group == listgroup8) {
			if (checkedId == R.id.bairadio0) {
				sum += 0;
			} else if (checkedId == R.id.bairadio1) {
				sum += 1;
			} else if (checkedId == R.id.bairadio2) {
				sum += 2;
			} else {
				sum += 3;
			}
		} else if (group == listgroup9) {
			if (checkedId == R.id.bairadio0) {
				sum += 0;
			} else if (checkedId == R.id.bairadio1) {
				sum += 1;
			} else if (checkedId == R.id.bairadio2) {
				sum += 2;
			} else {
				sum += 3;
			}
		} else if (group == listgroup10) {
			if (checkedId == R.id.bairadio0) {
				sum += 0;
			} else if (checkedId == R.id.bairadio1) {
				sum += 1;
			} else if (checkedId == R.id.bairadio2) {
				sum += 2;
			} else {
				sum += 3;
			}
		} else if (group == listgroup11) {
			if (checkedId == R.id.bairadio0) {
				sum += 0;
			} else if (checkedId == R.id.bairadio1) {
				sum += 1;
			} else if (checkedId == R.id.bairadio2) {
				sum += 2;
			} else {
				sum += 3;
			}
		} else if (group == listgroup12) {
			if (checkedId == R.id.bairadio0) {
				sum += 0;
			} else if (checkedId == R.id.bairadio1) {
				sum += 1;
			} else if (checkedId == R.id.bairadio2) {
				sum += 2;
			} else {
				sum += 3;
			}
		} else if (group == listgroup13) {
			if (checkedId == R.id.bairadio0) {
				sum += 0;
			} else if (checkedId == R.id.bairadio1) {
				sum += 1;
			} else if (checkedId == R.id.bairadio2) {
				sum += 2;
			} else {
				sum += 3;
			}
		} else if (group == listgroup14) {
			if (checkedId == R.id.bairadio0) {
				sum += 0;
			} else if (checkedId == R.id.bairadio1) {
				sum += 1;
			} else if (checkedId == R.id.bairadio2) {
				sum += 2;
			} else {
				sum += 3;
			}
		} else if (group == listgroup15) {
			if (checkedId == R.id.bairadio0) {
				sum += 0;
			} else if (checkedId == R.id.bairadio1) {
				sum += 1;
			} else if (checkedId == R.id.bairadio2) {
				sum += 2;
			} else {
				sum += 3;
			}
		} else if (group == listgroup16) {
			if (checkedId == R.id.bairadio0) {
				sum += 0;
			} else if (checkedId == R.id.bairadio1) {
				sum += 1;
			} else if (checkedId == R.id.bairadio2) {
				sum += 2;
			} else {
				sum += 3;
			}
		} else if (group == listgroup17) {
			if (checkedId == R.id.bairadio0) {
				sum += 0;
			} else if (checkedId == R.id.bairadio1) {
				sum += 1;
			} else if (checkedId == R.id.bairadio2) {
				sum += 2;
			} else {
				sum += 3;
			}
		} else if (group == listgroup18) {
			if (checkedId == R.id.bairadio0) {
				sum += 0;
			} else if (checkedId == R.id.bairadio1) {
				sum += 1;
			} else if (checkedId == R.id.bairadio2) {
				sum += 2;
			} else {
				sum += 3;
			}
		} else if (group == listgroup19) {
			if (checkedId == R.id.bairadio0) {
				sum += 0;
			} else if (checkedId == R.id.bairadio1) {
				sum += 1;
			} else if (checkedId == R.id.bairadio2) {
				sum += 2;
			} else {
				sum += 3;
			}
		} else if (group == listgroup20) {
			if (checkedId == R.id.bairadio0) {
				sum += 0;
			} else if (checkedId == R.id.bairadio1) {
				sum += 1;
			} else if (checkedId == R.id.bairadio2) {
				sum += 2;
			} else {
				sum += 3;
			}
		} else if (group == listgroup21) {
			if (checkedId == R.id.bairadio0) {
				sum += 0;
			} else if (checkedId == R.id.bairadio1) {
				sum += 1;
			} else if (checkedId == R.id.bairadio2) {
				sum += 2;
			} else {
				sum += 3;
			}
		}
	}
}
