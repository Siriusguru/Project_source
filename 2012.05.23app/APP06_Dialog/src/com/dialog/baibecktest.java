package com.dialog;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

//implements�� ����� ������ �ڵ��� ����ȭ�� ���� ����ߴ�. �ߺ����? �̷� �ǹ̶��� ����

public class baibecktest extends Activity implements
		RadioGroup.OnCheckedChangeListener {
	TextView list1, list2, list3, list4, list5, list6, list7, list8, list9,
			list10, list11, list12, list13, list14, list15, list16, list17,
			list18, list19, list20, list21; // ������ �� text ������� 1,2,3,4 �Ѵ�.

	// �������� ���� �о���� ���� ���
	String baibecktest;
	String resultStr;
	
	Button result;

	// Button left, right; ���ʿ��� �ɼ��� �Ǿ���.
	int a, b, c, d;
	RadioGroup listgroup1, listgroup2, listgroup3, listgroup4, listgroup5,
			listgroup6, listgroup7, listgroup8, listgroup9, listgroup10,
			listgroup11, listgroup12, listgroup13, listgroup14, listgroup15,
			listgroup16, listgroup17, listgroup18, listgroup19, listgroup20,
			listgroup21; // ������׷� �������
	int sum; // �� ���� ���ϱ� ����

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
	/*
	 * final String baibecktest =
	 * "[{\"id\":\"1.������ ���� ������ ���ø� ������ ����� ������ �޴´�\"}," +
	 * "{\"id\":\"2.��е� ������ �޴´�.\"}," + "{\"id\":\"3.������ �ٸ��� ������ �Ѵ�.\"}," +
	 * "{\"id\":\"4.����ϰ� �� ���� ����.\"}," +
	 * "{\"id\":\"5.�ſ� ���� ���� �Ͼ �� ���� �η����� ������.\"}," +
	 * "{\"id\":\"6.��������(������)�� ������.\"}," +
	 * "{\"id\":\"7.������ ������ �αٰŸ��� ���� �ڴ�.\"}," + "{\"id\":\"8.ħ������ ���ϴ�.\"}]";;
	 */

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.baibecktest);

		// ���̾�α�â (�� �ɸ� �˻翡 ���� ���� ����� ����)
		new AlertDialog.Builder(baibecktest.this)
				.setTitle("Beck �ڱ��� �Ҿ�ô��")
				.setMessage(
						"BAI�� ������ �Ҿ� ������ ���ϱ� ���� ���ߵ� ����ô���� BDI�� ���������� �ӻ� ��鿡�� ���� ����ϴ� ô���Դϴ�."
								+ "BAI�� Beck, Emery & Greenberg(1985)�� ���� ���ߵǾ����� 21�������� ������ Likert�� 4�� ô���Դϴ�."
								+ "ä�� ����� ���� �����̸� ������ �������� �Ҿ� ������ ���� ���� �ǹ��մϴ�.")
				.setNegativeButton("Close",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub

							}
						}).show();

		// TODO Auto-generated method stub
		/*
		 * a = 0; b = 1; c = 2; d = 3;
		 */
		// �ʱⰪ

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
		
		/*
		 * try { for (int i = a; i <= d; i++) { JSONArray jArr = new
		 * JSONArray(baibecktest); JSONObject jObj = jArr.getJSONObject(i); // ��
		 * �̸�("id"/"tel")�� �ش��ϴ� ���� ����. resultStr += String.format("%s",
		 * jObj.getString("id"));
		 * 
		 * switch (i) { case 0: list1.setText(resultStr); resultStr = ""; break;
		 * case 1: list2.setText(resultStr); resultStr = ""; break; case 2:
		 * list3.setText(resultStr); resultStr = ""; break; case 3:
		 * list4.setText(resultStr); resultStr = ""; break; } } } catch
		 * (JSONException e) { Toast.makeText(baibecktest.this, e.getMessage(),
		 * Toast.LENGTH_SHORT) .show(); }
		 */// ���̽� ������ ������ ���� �޾ƿ���� ����

		// left = (Button) findViewById(R.id.page1left);
		// right = (Button) findViewById(R.id.page1right);
		// left.setOnClickListener(this);
		// right.setOnClickListener(this);

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

		// �����׷��� üũ���� �б����� ����ߴ�.
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
		
		result.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//int ���� String���� String�� int ������ ��ȯ�ϴ� �ڹ� ���
				//�������� ��� �ű�� �Ŵ�.
				// TODO Auto-generated method stub
				
			}
		});
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
		// ������������ �ؽ�Ʈ �޾ƿ���
		new LongRunningGetIO().execute();
	}

	/*
	 * @Override public void onClick(View v) { // TODO Auto-generated method
	 * stub Button b = (Button) findViewById(R.id.result);
	 * b.setClickable(false); new LongRunningGetIO().execute(); }
	 */
	private class LongRunningGetIO extends AsyncTask<Void, Void, String> {
		protected String getASCIIContentFromEntity(HttpEntity entity)
				throws IllegalStateException, IOException {
			InputStream in = entity.getContent();
			StringBuffer out = new StringBuffer();
			int n = 1;
			while (n > 0) {
				byte[] b = new byte[4096];
				n = in.read(b);
				if (n > 0)
					out.append(new String(b, 0, n));
			}
			return out.toString();
		}

		@Override
		protected String doInBackground(Void... params) {
			HttpClient httpClient = new DefaultHttpClient();
			HttpContext localContext = new BasicHttpContext();
			HttpGet httpGet = new HttpGet("http://siriusbellatrix.appspot.com/");
			String text = null;
			try {
				HttpResponse response = httpClient.execute(httpGet,
						localContext);
				HttpEntity entity = response.getEntity();
				text = getASCIIContentFromEntity(entity);
			} catch (Exception e) {
				return e.getLocalizedMessage();
			}
			return text;
		}

		protected void onPostExecute(String results) {
			if (results != null) {
				// EditText et = (EditText) findViewById(R.id.button1);
				// et.setText(results);
				/*
				 * �׽�Ʈ�� ���� baibecktest = results; list10.setText(baibecktest);
				 */

				baibecktest = results;
				resultStr = ""; // null�� ǥ���� �����°� �����ϱ� ���� ����ߴ�.
				try {
					for (int i = 0; i <= 20; i++) {
						JSONArray jArr = new JSONArray(baibecktest);
						JSONObject jObj = jArr.getJSONObject(i);
						// �� �̸�("id"/)9�� �ش��ϴ� ���� ����.
						resultStr += String.format("%s", jObj.getString("id"));

						switch (i) {
						case 0:
							list1.setText(resultStr);
							resultStr = "";
							break;
						case 1:
							list2.setText(resultStr);
							resultStr = "";
							break;
						case 2:
							list3.setText(resultStr);
							resultStr = "";
							break;
						case 3:
							list4.setText(resultStr);
							resultStr = "";
							break;
						case 4:
							list5.setText(resultStr);
							resultStr = "";
							break;
						case 5:
							list6.setText(resultStr);
							resultStr = "";
							break;
						case 6:
							list7.setText(resultStr);
							resultStr = "";
							break;
						case 7:
							list8.setText(resultStr);
							resultStr = "";
							break;
						case 8:
							list9.setText(resultStr);
							resultStr = "";
							break;
						case 9:
							list10.setText(resultStr);
							resultStr = "";
							break;
						case 10:
							list11.setText(resultStr);
							resultStr = "";
							break;
						case 11:
							list12.setText(resultStr);
							resultStr = "";
							break;
						case 12:
							list13.setText(resultStr);
							resultStr = "";
							break;
						case 13:
							list14.setText(resultStr);
							resultStr = "";
							break;
						case 14:
							list15.setText(resultStr);
							resultStr = "";
							break;
						case 15:
							list16.setText(resultStr);
							resultStr = "";
							break;
						case 16:
							list17.setText(resultStr);
							resultStr = "";
							break;
						case 17:
							list18.setText(resultStr);
							resultStr = "";
							break;
						case 18:
							list19.setText(resultStr);
							resultStr = "";
							break;
						case 19:
							list20.setText(resultStr);
							resultStr = "";
							break;
						case 20:
							list21.setText(resultStr);
							resultStr = "";
							break;
						}
					}
				} catch (JSONException e) {
					Toast.makeText(baibecktest.this, e.getMessage(),
							Toast.LENGTH_SHORT).show();
				}

			}
			// Button b = (Button) findViewById(R.id.result);
			// b.setClickable(true);
		}
	}

	// ���� ��ư�� ���� ����Ѵ�.

	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		// RadioGroup 1�� �׷��϶�
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
		}
		else if (group == listgroup5) {
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
		else if (group == listgroup6) {
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
		else if (group == listgroup7) {
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
		else if (group == listgroup8) {
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
		else if (group == listgroup9) {
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
		else if (group == listgroup10) {
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
		else if (group == listgroup11) {
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
		else if (group == listgroup12) {
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
		else if (group == listgroup13) {
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
		else if (group == listgroup14) {
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
		else if (group == listgroup15) {
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
		else if (group == listgroup16) {
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
		else if (group == listgroup17) {
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
		else if (group == listgroup18) {
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
		else if (group == listgroup19) {
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
		else if (group == listgroup20) {
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
		else if (group == listgroup21) {
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
	/*
	 * public void onClick(View v) { // TODO Auto-generated method stub if (v ==
	 * left) {
	 * 
	 * if (a != 0) { a = a - 4; b = b - 4; c = c - 4; d = d - 4;
	 * 
	 * // �ٽ� üũ�� �� �ֵ��� �Ѵ�. üũ�� ���� ���� list1group.clearCheck();
	 * list2group.clearCheck(); list3group.clearCheck();
	 * list4group.clearCheck();
	 * 
	 * 
	 * 
	 * list1.setText(resultStr); resultStr = ""; list2.setText(resultStr);
	 * resultStr = ""; list3.setText(resultStr); resultStr = "";
	 * list4.setText(resultStr); resultStr = "";
	 * 
	 * // ���� ������ �ذ��ϱ� ���� list2group.setVisibility(View.VISIBLE);
	 * list3group.setVisibility(View.VISIBLE);
	 * list4group.setVisibility(View.VISIBLE); }
	 * 
	 * 
	 * 
	 * } else { // Right ��ư�� ������ ���
	 * 
	 * a = a + 4; b = b + 4; c = c + 4; d = d + 4; // list1group�� button ���� �о
	 * sum�� ���Ѵ�. // ���ϰ� ���� left right��ư�� ������ �� ���� �ٽ� �ʱ�ȭ �ϴ� �۾��� ������.
	 * list1group.getCheckedRadioButtonId(); // �ٽ� üũ�� �� �ֵ��� �Ѵ�. üũ�� ���� ����
	 * list1group.clearCheck(); list2group.clearCheck();
	 * list3group.clearCheck(); list4group.clearCheck(); // error �߻��� if (b ==
	 * 21) { // list1.setText(baibecktest[a]); list2.setText("");
	 * list3.setText(""); list4.setText("");
	 * 
	 * // ���� �׷� ��ư ���ǿ� �°� �Ⱥ��̰� �ϱ� list2group.setVisibility(View.INVISIBLE);
	 * list3group.setVisibility(View.INVISIBLE);
	 * list4group.setVisibility(View.INVISIBLE);
	 * 
	 * } else {
	 * 
	 * try { for(int i=a; i<=d; i++) { JSONArray jArr = new
	 * JSONArray(baibecktest); JSONObject jObj = jArr.getJSONObject(i); // ��
	 * �̸�("id"/"tel")�� �ش��ϴ� ���� ����. resultStr += String.format("%s",
	 * jObj.getString("id"));
	 * 
	 * switch(i) { case 4 :list1.setText(resultStr); resultStr = ""; break; case
	 * 5 :list2.setText(resultStr); resultStr = ""; break; case 6
	 * :list3.setText(resultStr); resultStr = ""; break; case 7
	 * :list4.setText(resultStr); resultStr = ""; break; } } } catch
	 * (JSONException e) { Toast.makeText(baibecktest.this, e.getMessage(),
	 * Toast.LENGTH_SHORT).show(); }
	 * 
	 * 
	 * // list1.setText(baibecktest[a]); // list2.setText(baibecktest[b]); //
	 * list3.setText(baibecktest[c]); // list4.setText(baibecktest[d]); } } }
	 */

}