package com.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

//implements를 사용한 이유는 코드의 간편화를 위해 사용했다. 중복사용? 이런 의미랄까 ㅎㅎ

public class baibecktest extends Activity implements
		RadioGroup.OnCheckedChangeListener, OnClickListener {
	TextView list1, list2, list3, list4;
	Button left, right;
	int a, b, c, d;
	RadioGroup list1group, list2group, list3group, list4group;
	int sum; // 총 합을 구하기 위함
	final String[] baibecktest = { "1.가끔씩 몸이 저리고 쑤시며 감각이 마비된 느낌을 받는다",
			"2.흥분된 느낌을 받는다.", "3.가끔씩 다리가 떨리곤 한다.", "4.편안하게 쉴 수가 없다.",
			"5.매우 나쁜 일이 일어날 것 같은 두려움을 느낀다.", "6.어지러움(현기증)을 느낀다.",
			"7.가끔씩 심장이 두근거리고 빨리 뛴다.", "8.침착하지 못하다.", "9.자주 겁을 먹고 무서움을 느낀다.",
			"10.신경이 과민 되어 왔다.", "11.가끔씩 숨이 막히고 질식할 것 같다.", "12.자주 손이 떨린다.",
			"13.안절부절못해 한다.", "14.미칠 것 같은 두려움을 느낀다.", "15.가끔씩 숨쉬기 곤란할 때가 있다.",
			"16.죽을 것 같은 두려움을 느낀다.", "17.불안한 상태에 있다.",
			"18.자주 소화가 잘 안되고 뱃속이 불편하다.", "19.가끔씩 기절할 것 같다.",
			"20.자주 얼굴이 붉어지곤 한다.", "21.땀을 많이 흘린다(더위로 인한 경우는 제외)." };;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.baibecktest);
		// TODO Auto-generated method stub

		a = 0;
		b = 1;
		c = 2;
		d = 3;
		// 초기값
		list1 = (TextView) findViewById(R.id.baitext1);
		list1.setText(baibecktest[a]);
		list2 = (TextView) findViewById(R.id.baitext2);
		list2.setText(baibecktest[b]);
		list3 = (TextView) findViewById(R.id.baitext3);
		list3.setText(baibecktest[c]);
		list4 = (TextView) findViewById(R.id.baitext4);
		list4.setText(baibecktest[d]);

		left = (Button) findViewById(R.id.page1left);
		right = (Button) findViewById(R.id.page1right);

		left.setOnClickListener(this);
		right.setOnClickListener(this);

		list1group = (RadioGroup) findViewById(R.id.bairadioGroup1);
		list2group = (RadioGroup) findViewById(R.id.bairadioGroup2);
		list3group = (RadioGroup) findViewById(R.id.bairadioGroup3);
		list4group = (RadioGroup) findViewById(R.id.bairadioGroup4);

		list1group.setOnCheckedChangeListener(this);
		list2group.setOnCheckedChangeListener(this);
		list3group.setOnCheckedChangeListener(this);
		list4group.setOnCheckedChangeListener(this);

		/*
		 * // 버튼 -> 오른쪽 의미 right.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { // TODO Auto-generated method
		 * stub a = a + 4; b = b + 4; c = c + 4; d = d + 4; // if문은 radiogroup 을
		 * 없애기 위함으로 작성 if (b == 21) {
		 * 
		 * } list1.setText(baibecktest[a]); list2.setText(baibecktest[b]);
		 * list3.setText(baibecktest[c]); list4.setText(baibecktest[d]);
		 * 
		 * }
		 * 
		 * });
		 */
	}

	// 라디오 버튼의 값을 계산한다.
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		// RadioGroup 1번 그룹일때
		if (group == list1group) {
			if (checkedId == R.id.bairadio0) {
				sum += 0;
			} else if (checkedId == R.id.bairadio1) {
				sum += 1;
			} else if (checkedId == R.id.bairadio2) {
				sum += 2;
			} else {
				sum += 3;
			}
		} else if (group == list2group) {
			if (checkedId == R.id.bairadio0) {
				sum += 0;
			} else if (checkedId == R.id.bairadio1) {
				sum += 1;
			} else if (checkedId == R.id.bairadio2) {
				sum += 2;
			} else {
				sum += 3;
			}
		} else if (group == list3group) {
			if (checkedId == R.id.bairadio0) {
				sum += 0;
			} else if (checkedId == R.id.bairadio1) {
				sum += 1;
			} else if (checkedId == R.id.bairadio2) {
				sum += 2;
			} else {
				sum += 3;
			}
		} else {
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

	// 버튼에 대한 OnClickListener
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == left) {
			if (a != 0) {
				a = a - 4;
				b = b - 4;
				c = c - 4;
				d = d - 4;

				// 다시 체크할 수 있도록 한다. 체크된 것을 리셋
				list1group.clearCheck();
				list2group.clearCheck();
				list3group.clearCheck();
				list4group.clearCheck();

				list1.setText(baibecktest[a]);
				list2.setText(baibecktest[b]);
				list3.setText(baibecktest[c]);
				list4.setText(baibecktest[d]);

				// 앞의 오류를 해결하기 위함
				list2group.setVisibility(View.VISIBLE);
				list3group.setVisibility(View.VISIBLE);
				list4group.setVisibility(View.VISIBLE);
			}

		} else { // Right 버튼을 눌렀을 경우

			a = a + 4;
			b = b + 4;
			c = c + 4;
			d = d + 4;
			//list1group의 button 값을 읽어서  sum에 더한다.
			//더하고 나서 left right버튼을 누를때 그 값을 다시 초기화 하는 작업을 가진다.
			list1group.getCheckedRadioButtonId();
			// 다시 체크할 수 있도록 한다. 체크된 것을 리셋
			list1group.clearCheck();
			list2group.clearCheck();
			list3group.clearCheck();
			list4group.clearCheck();
			// error 발생점
			if (b == 21) {
				list1.setText(baibecktest[a]);
				list2.setText("");
				list3.setText("");
				list4.setText("");

				// 라디오 그룹 버튼 조건에 맞게 안보이게 하기
				list2group.setVisibility(View.INVISIBLE);
				list3group.setVisibility(View.INVISIBLE);
				list4group.setVisibility(View.INVISIBLE);

			} else {
				list1.setText(baibecktest[a]);
				list2.setText(baibecktest[b]);
				list3.setText(baibecktest[c]);
				list4.setText(baibecktest[d]);
			}
		}
	}

}
