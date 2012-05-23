package com.dialog;

import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

//implements�� ����� ������ �ڵ��� ����ȭ�� ���� ����ߴ�. �ߺ����? �̷� �ǹ̶��� ����

public class baibecktest extends Activity implements
		RadioGroup.OnCheckedChangeListener, OnClickListener {
	TextView list1, list2, list3, list4;
	Button left, right;
	int a, b, c, d;
	RadioGroup list1group, list2group, list3group, list4group;
	int sum; // �� ���� ���ϱ� ����
	String resultStr = "";

	/*
	 * final String[] baibecktest = { "1.������ ���� ������ ���ø� ������ ����� ������ �޴´�",
	 * "2.��е� ������ �޴´�.", "3.������ �ٸ��� ������ �Ѵ�.", "4.����ϰ� �� ���� ����.",
	 * "5.�ſ� ���� ���� �Ͼ �� ���� �η����� ������.", "6.��������(������)�� ������.",
	 * "7.������ ������ �αٰŸ��� ���� �ڴ�.", "8.ħ������ ���ϴ�.", "9.���� ���� �԰� �������� ������.",
	 * "10.�Ű��� ���� �Ǿ� �Դ�.", "11.������ ���� ������ ������ �� ����.", "12.���� ���� ������.",
	 * "13.������������ �Ѵ�.", "14.��ĥ �� ���� �η����� ������.", "15.������ ������ ����� ���� �ִ�.",
	 * "16.���� �� ���� �η����� ������.", "17.�Ҿ��� ���¿� �ִ�.", "18.���� ��ȭ�� �� �ȵǰ� ����� �����ϴ�.",
	 * "19.������ ������ �� ����.", "20.���� ���� �Ӿ����� �Ѵ�.", "21.���� ���� �기��(������ ���� ���� ����)."
	 * };;
	 */

	final String baibecktest = "[{\"id\":\"1.������ ���� ������ ���ø� ������ ����� ������ �޴´�\"},"
			+ "{\"id\":\"2.��е� ������ �޴´�.\"},"
			+ "{\"id\":\"3.������ �ٸ��� ������ �Ѵ�.\"},"
			+ "{\"id\":\"4.����ϰ� �� ���� ����.\"},"
			+ "{\"id\":\"5.�ſ� ���� ���� �Ͼ �� ���� �η����� ������.\"},"
			+ "{\"id\":\"6.��������(������)�� ������.\"},"
			+ "{\"id\":\"7.������ ������ �αٰŸ��� ���� �ڴ�.\"},"
			+ "{\"id\":\"8.ħ������ ���ϴ�.\"}]";;

			
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
		// �ʱⰪ

		list1 = (TextView) findViewById(R.id.baitext1);
		list2 = (TextView) findViewById(R.id.baitext2);
		list3 = (TextView) findViewById(R.id.baitext3);
		list4 = (TextView) findViewById(R.id.baitext4);
		try {
			for(int i=a; i<=d; i++) {
			JSONArray jArr = new JSONArray(baibecktest);
			JSONObject jObj = jArr.getJSONObject(i);
			// �� �̸�("id"/"tel")�� �ش��ϴ� ���� ����.
			resultStr += String.format("%s", jObj.getString("id"));
			
			switch(i) {
			case 0 :list1.setText(resultStr);
				    resultStr = "";
				    break;
			case 1 :list2.setText(resultStr);
		    		resultStr = "";
		    		break;
			case 2 :list3.setText(resultStr);
	    			resultStr = "";
	    			break;
			case 3 :list4.setText(resultStr);
					resultStr = "";
					break;
			}
			}
		}   catch (JSONException e) {
			Toast.makeText(baibecktest.this, e.getMessage(),
					Toast.LENGTH_SHORT).show();
		}
		

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
		 * // ��ư -> ������ �ǹ� right.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { // TODO Auto-generated method
		 * stub a = a + 4; b = b + 4; c = c + 4; d = d + 4; // if���� radiogroup ��
		 * ���ֱ� �������� �ۼ� if (b == 21) {
		 * 
		 * } list1.setText(baibecktest[a]); list2.setText(baibecktest[b]);
		 * list3.setText(baibecktest[c]); list4.setText(baibecktest[d]);
		 * 
		 * }
		 * 
		 * });
		 */
	}

	// ���� ��ư�� ���� ����Ѵ�.

	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		// RadioGroup 1�� �׷��϶�
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

	// ��ư�� ���� OnClickListener

	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == left) {
		
			if (a != 0) {
				a = a - 4;
				b = b - 4;
				c = c - 4;
				d = d - 4;

				// �ٽ� üũ�� �� �ֵ��� �Ѵ�. üũ�� ���� ����
				list1group.clearCheck();
				list2group.clearCheck();
				list3group.clearCheck();
				list4group.clearCheck();
				
	
				
				list1.setText(resultStr);
				resultStr = "";
				list2.setText(resultStr);
				resultStr = "";
				list3.setText(resultStr);
				resultStr = "";
				list4.setText(resultStr);
				resultStr = "";

				// ���� ������ �ذ��ϱ� ����
				list2group.setVisibility(View.VISIBLE);
				list3group.setVisibility(View.VISIBLE);
				list4group.setVisibility(View.VISIBLE);
			}
	
			

		} else { // Right ��ư�� ������ ���

			a = a + 4;
			b = b + 4;
			c = c + 4;
			d = d + 4;
			// list1group�� button ���� �о sum�� ���Ѵ�.
			// ���ϰ� ���� left right��ư�� ������ �� ���� �ٽ� �ʱ�ȭ �ϴ� �۾��� ������.
			list1group.getCheckedRadioButtonId();
			// �ٽ� üũ�� �� �ֵ��� �Ѵ�. üũ�� ���� ����
			list1group.clearCheck();
			list2group.clearCheck();
			list3group.clearCheck();
			list4group.clearCheck();
			// error �߻���
			if (b == 21) {
			//	list1.setText(baibecktest[a]);
				list2.setText("");
				list3.setText("");
				list4.setText("");

				// ���� �׷� ��ư ���ǿ� �°� �Ⱥ��̰� �ϱ�
				list2group.setVisibility(View.INVISIBLE);
				list3group.setVisibility(View.INVISIBLE);
				list4group.setVisibility(View.INVISIBLE);

			} else {
				
				try {
					for(int i=a; i<=d; i++) {
					JSONArray jArr = new JSONArray(baibecktest);
					JSONObject jObj = jArr.getJSONObject(i);
					// �� �̸�("id"/"tel")�� �ش��ϴ� ���� ����.
					resultStr += String.format("%s", jObj.getString("id"));
					
					switch(i) {
					case 4 :list1.setText(resultStr);
						    resultStr = "";
						    break;
					case 5 :list2.setText(resultStr);
				    		resultStr = "";
				    		break;
					case 6 :list3.setText(resultStr);
			    			resultStr = "";
			    			break;
					case 7 :list4.setText(resultStr);
							resultStr = "";
							break;
					}
					}
				}   catch (JSONException e) {
					Toast.makeText(baibecktest.this, e.getMessage(),
							Toast.LENGTH_SHORT).show();
				}
			
				
		    //  list1.setText(baibecktest[a]);
			//	list2.setText(baibecktest[b]);
			//	list3.setText(baibecktest[c]);
			//	list4.setText(baibecktest[d]);
			}
		}
	}

}