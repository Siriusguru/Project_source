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

//implements를 사용한 이유는 코드의 간편화를 위해 사용했다. 중복사용? 이런 의미랄까 ㅎㅎ

public class baibecktest extends Activity implements
		RadioGroup.OnCheckedChangeListener {
	TextView list1, list2, list3, list4, list5, list6, list7, list8, list9,
			list10, list11, list12, list13, list14, list15, list16, list17,
			list18, list19, list20, list21; // 질문이 들어갈 text 순서대로 1,2,3,4 한다.

	// 서버에서 값을 읽어오기 위해 사용
	String baibecktest;
	String resultStr;
	
	Button result;

	// Button left, right; 불필요한 옵션이 되었다.
	int a, b, c, d;
	RadioGroup listgroup1, listgroup2, listgroup3, listgroup4, listgroup5,
			listgroup6, listgroup7, listgroup8, listgroup9, listgroup10,
			listgroup11, listgroup12, listgroup13, listgroup14, listgroup15,
			listgroup16, listgroup17, listgroup18, listgroup19, listgroup20,
			listgroup21; // 레디오그륩 순서대로
	int sum; // 총 합을 구하기 위함

	/*
	 * final String[] baibecktest = { "1.가끔씩 몸이 저리고 쑤시며 감각이 마비된 느낌을 받는다",
	 * "2.흥분된 느낌을 받는다.", "3.가끔씩 다리가 떨리곤 한다.", "4.편안하게 쉴 수가 없다.",
	 * "5.매우 나쁜 일이 일어날 것 같은 두려움을 느낀다.", "6.어지러움(현기증)을 느낀다.",
	 * "7.가끔씩 심장이 두근거리고 빨리 뛴다.", "8.침착하지 못하다.", "9.자주 겁을 먹고 무서움을 느낀다.",
	 * "10.신경이 과민 되어 왔다.", "11.가끔씩 숨이 막히고 질식할 것 같다.", "12.자주 손이 떨린다.",
	 * "13.안절부절못해 한다.", "14.미칠 것 같은 두려움을 느낀다.", "15.가끔씩 숨쉬기 곤란할 때가 있다.",
	 * "16.죽을 것 같은 두려움을 느낀다.", "17.불안한 상태에 있다.", "18.자주 소화가 잘 안되고 뱃속이 불편하다.",
	 * "19.가끔씩 기절할 것 같다.", "20.자주 얼굴이 붉어지곤 한다.", "21.땀을 많이 흘린다(더위로 인한 경우는 제외)."
	 * };;
	 */
	/*
	 * final String baibecktest =
	 * "[{\"id\":\"1.가끔씩 몸이 저리고 쑤시며 감각이 마비된 느낌을 받는다\"}," +
	 * "{\"id\":\"2.흥분된 느낌을 받는다.\"}," + "{\"id\":\"3.가끔씩 다리가 떨리곤 한다.\"}," +
	 * "{\"id\":\"4.편안하게 쉴 수가 없다.\"}," +
	 * "{\"id\":\"5.매우 나쁜 일이 일어날 것 같은 두려움을 느낀다.\"}," +
	 * "{\"id\":\"6.어지러움(현기증)을 느낀다.\"}," +
	 * "{\"id\":\"7.가끔씩 심장이 두근거리고 빨리 뛴다.\"}," + "{\"id\":\"8.침착하지 못하다.\"}]";;
	 */

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.baibecktest);

		// 다이어로그창 (이 심리 검사에 대한 설명 결과값 설명)
		new AlertDialog.Builder(baibecktest.this)
				.setTitle("Beck 자기평가 불안척도")
				.setMessage(
						"BAI는 개인의 불안 수준을 평가하기 위해 개발된 측정척도로 BDI와 마찬가지로 임상 장면에서 많이 사용하는 척도입니다."
								+ "BAI는 Beck, Emery & Greenberg(1985)에 의해 개발되었으며 21문항으로 구성된 Likert식 4점 척도입니다."
								+ "채점 방법은 문항 총합이며 점수가 높을수록 불안 수준이 높은 것을 의미합니다.")
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
		
		/*
		 * try { for (int i = a; i <= d; i++) { JSONArray jArr = new
		 * JSONArray(baibecktest); JSONObject jObj = jArr.getJSONObject(i); // 각
		 * 이름("id"/"tel")에 해당하는 값을 추출. resultStr += String.format("%s",
		 * jObj.getString("id"));
		 * 
		 * switch (i) { case 0: list1.setText(resultStr); resultStr = ""; break;
		 * case 1: list2.setText(resultStr); resultStr = ""; break; case 2:
		 * list3.setText(resultStr); resultStr = ""; break; case 3:
		 * list4.setText(resultStr); resultStr = ""; break; } } } catch
		 * (JSONException e) { Toast.makeText(baibecktest.this, e.getMessage(),
		 * Toast.LENGTH_SHORT) .show(); }
		 */// 제이슨 데이터 서버로 부터 받아오기로 수정

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
		
		result.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//int 형을 String으로 String을 int 형으로 변환하는 자바 방법
				//총점으로 결과 매기는 거다.
				// TODO Auto-generated method stub
				
			}
		});
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
		// 웹브라우저에서 텍스트 받아오기
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
				 * 테스트용 서버 baibecktest = results; list10.setText(baibecktest);
				 */

				baibecktest = results;
				resultStr = ""; // null값 표현이 나오는걸 방지하기 위해 사용했다.
				try {
					for (int i = 0; i <= 20; i++) {
						JSONArray jArr = new JSONArray(baibecktest);
						JSONObject jObj = jArr.getJSONObject(i);
						// 각 이름("id"/)9에 해당하는 값을 추출.
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

	// 라디오 버튼의 값을 계산한다.

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

	// 버튼에 대한 OnClickListener
	/*
	 * public void onClick(View v) { // TODO Auto-generated method stub if (v ==
	 * left) {
	 * 
	 * if (a != 0) { a = a - 4; b = b - 4; c = c - 4; d = d - 4;
	 * 
	 * // 다시 체크할 수 있도록 한다. 체크된 것을 리셋 list1group.clearCheck();
	 * list2group.clearCheck(); list3group.clearCheck();
	 * list4group.clearCheck();
	 * 
	 * 
	 * 
	 * list1.setText(resultStr); resultStr = ""; list2.setText(resultStr);
	 * resultStr = ""; list3.setText(resultStr); resultStr = "";
	 * list4.setText(resultStr); resultStr = "";
	 * 
	 * // 앞의 오류를 해결하기 위함 list2group.setVisibility(View.VISIBLE);
	 * list3group.setVisibility(View.VISIBLE);
	 * list4group.setVisibility(View.VISIBLE); }
	 * 
	 * 
	 * 
	 * } else { // Right 버튼을 눌렀을 경우
	 * 
	 * a = a + 4; b = b + 4; c = c + 4; d = d + 4; // list1group의 button 값을 읽어서
	 * sum에 더한다. // 더하고 나서 left right버튼을 누를때 그 값을 다시 초기화 하는 작업을 가진다.
	 * list1group.getCheckedRadioButtonId(); // 다시 체크할 수 있도록 한다. 체크된 것을 리셋
	 * list1group.clearCheck(); list2group.clearCheck();
	 * list3group.clearCheck(); list4group.clearCheck(); // error 발생점 if (b ==
	 * 21) { // list1.setText(baibecktest[a]); list2.setText("");
	 * list3.setText(""); list4.setText("");
	 * 
	 * // 라디오 그룹 버튼 조건에 맞게 안보이게 하기 list2group.setVisibility(View.INVISIBLE);
	 * list3group.setVisibility(View.INVISIBLE);
	 * list4group.setVisibility(View.INVISIBLE);
	 * 
	 * } else {
	 * 
	 * try { for(int i=a; i<=d; i++) { JSONArray jArr = new
	 * JSONArray(baibecktest); JSONObject jObj = jArr.getJSONObject(i); // 각
	 * 이름("id"/"tel")에 해당하는 값을 추출. resultStr += String.format("%s",
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