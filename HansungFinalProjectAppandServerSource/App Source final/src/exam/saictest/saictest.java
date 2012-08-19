package exam.saictest;

import exam.baibecktest.baianxiety;
import exam.baibecktest.baibecktest;
import exam.project.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class saictest extends Activity implements OnItemSelectedListener {
	/** Called when the activity is first created. */

	// 스피너 클릭 시 보여질 문자 배열 할당
	private String[] a = { "매우 차분하다", "차분하다", "차분하지 못하다" };
	private String[] b = { "언짢지 않다", "언짢다", "매우 언짢다" };
	private String[] c = { "매우 즐겁다", "즐겁다", "즐겁지 않다" };
	private String[] d = { "신경이 날카롭지 않다", "신경이 날카롭다", "매우 신경이 날카롭다" };
	private String[] e = { "초조하지 않다", "초조하다", "매우 초조하다" };
	private String[] f = { "매우 편안하다", "편안하다", "편안하지 않다" };
	private String[] g = { "겁이 나지 않는다", "겁이난다", "매우 겁이 난다" };
	private String[] h = { "매우 느긋하다", "느긋하다", "느긋하지 않다" };
	private String[] i = { "걱정하고 있지 않다", "걱정하고 있다", "매우 걱정하고 있다" };
	private String[] j = { "매우 만족스럽다", "만족스럽다", "만족스럽지않다" };
	private String[] k = { "무시무시하지 않다", "무시무시하다", "매우 무시무시하다" };
	private String[] l = { "매우 행복하다", "행복하다", "행복하지 않다" };
	private String[] m = { "매우 자신만만하다", "자신만만하다", "자신만만하지 않다" };
	private String[] n = { "매우 좋다", "좋다", "좋지 않다" };
	private String[] o = { "고민스럽지 않다", "고민스럽다", "매우 고민스럽다" };
	private String[] p = { "짜증스럽지 않다", "짜증스럽다", "매우 짜증스럽다" };
	private String[] q = { "정말 신난다", "신난다", "신나지 않다" };
	private String[] r = { "겁에 질려있지 않다", "겁에 질려있다", "매우 겁에 질려 있다" };
	private String[] s = { "혼란스럽지 않다", "혼란스럽다", "매우 혼란스럽다" };
	private String[] t = { "매우 명랑하다", "명랑하다", "명랑하지 않다" };

	// 결과값 출력
	Button result;
	int sum;

	
	Spinner sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10
	, sp11, sp12, sp13, sp14, sp15, sp16, sp17, sp18, sp19, sp20;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.saictest);
		
		// 다이어로그창 (이 심리 검사에 대한 설명 결과값 설명)
		new AlertDialog.Builder(saictest.this)
				.setTitle("소아 상태 불안 척도")
				.setMessage("1) 소아의 상태불안 측정.\n" + "2) 상태불안은 특수한 상황에서 자율신경계의 각성으로 인해 야기된 일시적인 척도내용 불안 상태를 의미.\n"
						+ "3) Spielberger의 성인용 상태불안 척도를 소아들이 이해하기 쉬운 형태로 변형 시킨 것으로 총 20문항으로 구성.\n\n" +
								"실시방법 자기보고식. 현재 어떻게 느끼고 있는가를 3문항 중 하나에 표시.\n\n"
						+ "각 문항의 점수를 합산하여 총점 구함.\n" + "첫 번째 문장 = 1점\n" + "두 번째 문장 = 2점\n" + "세 번째 문장 = 3점\n")
				
				.setNegativeButton("Close",
						new DialogInterface.OnClickListener() {

							
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub

							}
						}).show();

		// xml에 선언한 스피너를 id값으로 불러옴
		sp1 = (Spinner) findViewById(R.id.saicspinner1);
		sp2 = (Spinner) findViewById(R.id.saicspinner2);
		sp3 = (Spinner) findViewById(R.id.saicspinner3);
		sp4 = (Spinner) findViewById(R.id.saicspinner4);
		sp5 = (Spinner) findViewById(R.id.saicspinner5);
		sp6 = (Spinner) findViewById(R.id.saicspinner6);
		sp7 = (Spinner) findViewById(R.id.saicspinner7);
		sp8 = (Spinner) findViewById(R.id.saicspinner8);
		sp9 = (Spinner) findViewById(R.id.saicspinner9);
		sp10 = (Spinner) findViewById(R.id.saicspinner10);
		sp11 = (Spinner) findViewById(R.id.saicspinner11);
		sp12 = (Spinner) findViewById(R.id.saicspinner12);
		sp13 = (Spinner) findViewById(R.id.saicspinner13);
		sp14 = (Spinner) findViewById(R.id.saicspinner14);
		sp15 = (Spinner) findViewById(R.id.saicspinner15);
		sp16 = (Spinner) findViewById(R.id.saicspinner16);
		sp17 = (Spinner) findViewById(R.id.saicspinner17);
		sp18 = (Spinner) findViewById(R.id.saicspinner18);
		sp19 = (Spinner) findViewById(R.id.saicspinner19);
		sp20 = (Spinner) findViewById(R.id.saicspinner20);

		// 문자열 어댑터 선언
		ArrayAdapter<String> list;
		ArrayAdapter<String> list2;
		ArrayAdapter<String> list3;
		ArrayAdapter<String> list4;
		ArrayAdapter<String> list5;
		ArrayAdapter<String> list6;
		ArrayAdapter<String> list7;
		ArrayAdapter<String> list8;
		ArrayAdapter<String> list9;
		ArrayAdapter<String> list10;
		ArrayAdapter<String> list11;
		ArrayAdapter<String> list12;
		ArrayAdapter<String> list13;
		ArrayAdapter<String> list14;
		ArrayAdapter<String> list15;
		ArrayAdapter<String> list16;
		ArrayAdapter<String> list17;
		ArrayAdapter<String> list18;
		ArrayAdapter<String> list19;
		ArrayAdapter<String> list20;

		// 어댑터 객체를 생성하고 보여질 아이템 리소스와 문자열 지정
		list = new ArrayAdapter(this, android.R.layout.simple_spinner_item, a);
		list2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, b);
		list3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, c);
		list4 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, d);
		list5 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, e);
		list6 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, f);
		list7 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, g);
		list8 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, h);
		list9 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, i);
		list10 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, j);
		list11 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, k);
		list12 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, l);
		list13 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, m);
		list14 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, n);
		list15 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, o);
		list16 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, p);
		list17 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, q);
		list18 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, r);
		list19 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, s);
		list20 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, t);

		// 스피너에 adapter 연결
		sp1.setAdapter(list);
		sp2.setAdapter(list2);
		sp3.setAdapter(list3);
		sp4.setAdapter(list4);
		sp5.setAdapter(list5);
		sp6.setAdapter(list6);
		sp7.setAdapter(list7);
		sp8.setAdapter(list8);
		sp9.setAdapter(list9);
		sp10.setAdapter(list10);
		sp11.setAdapter(list11);
		sp12.setAdapter(list12);
		sp13.setAdapter(list13);
		sp14.setAdapter(list14);
		sp15.setAdapter(list15);
		sp16.setAdapter(list16);
		sp17.setAdapter(list17);
		sp18.setAdapter(list18);
		sp19.setAdapter(list19);
		sp20.setAdapter(list20);

		// 스피너가 선택 됫을 때 이벤트 처리
		sp1.setOnItemSelectedListener(this);
		sp2.setOnItemSelectedListener(this);
		sp3.setOnItemSelectedListener(this);
		sp4.setOnItemSelectedListener(this);
		sp5.setOnItemSelectedListener(this);
		sp6.setOnItemSelectedListener(this);
		sp7.setOnItemSelectedListener(this);
		sp8.setOnItemSelectedListener(this);
		sp9.setOnItemSelectedListener(this);
		sp10.setOnItemSelectedListener(this);
		sp11.setOnItemSelectedListener(this);
		sp12.setOnItemSelectedListener(this);
		sp13.setOnItemSelectedListener(this);
		sp14.setOnItemSelectedListener(this);
		sp15.setOnItemSelectedListener(this);
		sp16.setOnItemSelectedListener(this);
		sp17.setOnItemSelectedListener(this);
		sp18.setOnItemSelectedListener(this);
		sp19.setOnItemSelectedListener(this);
		sp20.setOnItemSelectedListener(this);

		result = (Button) findViewById(R.id.result);

		result.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Intent intent;
				String resultactivity; // int -> String으로 변환값을 받기 위한 변수
				resultactivity = Integer.toString(sum);
				// TODO Auto-generated method stub
				if(21<=sum && sum<=24) {
					intent = new Intent(saictest.this, saicanxiety.class);
					intent.putExtra("sum", resultactivity);
					startActivity(intent);
				}
				else if(25<=sum && sum<=28) {
					intent = new Intent(saictest.this, saicsanxiety.class);
					intent.putExtra("sum", resultactivity);
					startActivity(intent);
				}
				else if(sum>=29) {
					intent = new Intent(saictest.this, saicesanxiety.class);
					intent.putExtra("sum", resultactivity);
					startActivity(intent);
				}
			}
		});
	}

	public void onItemSelected(AdapterView<?> arg0, View arg1, final int position,
			long id) {
		// TODO Auto-generated method stub
		// 명령
		//sum = arg2;
		if (arg0 == sp1){
			sum += position;
		}else if(arg0 == sp2) {
			sum += position;
		}else if(arg0 == sp3) {
			sum += position;
		}else if(arg0 == sp4) {
			sum += position;
		}else if(arg0 == sp5) {
			sum += position;
		}else if(arg0 == sp6) {
			sum += position;
		}else if(arg0 == sp7) {
			sum += position;
		}else if(arg0 == sp8) {
			sum += position;
		}else if(arg0 == sp9) {
			sum += position;
		}else if(arg0 == sp10) {
			sum += position;
		}else if(arg0 == sp11) {
			sum += position;
		}else if(arg0 == sp12) {
			sum += position;
		}else if(arg0 == sp13) {
			sum += position;
		}else if(arg0 == sp14) {
			sum += position;
		}else if(arg0 == sp15) {
			sum += position;
		}else if(arg0 == sp16) {
			sum += position;
		}else if(arg0 == sp17) {
			sum += position;
		}else if(arg0 == sp18) {
			sum += position;
		}else if(arg0 == sp19) {
			sum += position;
		}else {
			sum += position;
		}

		
	
	}

	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

		// 다이어로그창 (이 심리 검사에 대한 설명 결과값 설명)
		// Interface 꾸미기.
		// 어떻게 해야 이쁘게 설명서가 나올까?

	}

}
