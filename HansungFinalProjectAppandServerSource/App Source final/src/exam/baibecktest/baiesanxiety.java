package exam.baibecktest;

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
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import exam.project.R;

//똑같은 형태인데도 불구하고 굳이 View 를 나누는 이유는 소스의 복잡함을 없애기 위함이다.
public class baiesanxiety extends Activity {
	TextView sum;

	// 노래를 받아오기
	TextView list1, list2, list3, list4, list5;
	// url 받아오기
	// 클릭하면 URL을 연결시키면 된다.

	String baibecktest;
	String resultStr;
	// url을 받아오기 위함
	String url1, url2, url3, url4, url5;
	// 랜덤함수의 중복을 막기 위함
	int check, check1, check2, check3, check4;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.baianxiety);
		list1 = (TextView) findViewById(R.id.list1);
		list2 = (TextView) findViewById(R.id.list2);
		list3 = (TextView) findViewById(R.id.list3);
		list4 = (TextView) findViewById(R.id.list4);
		list5 = (TextView) findViewById(R.id.list5);

		sum = (TextView) findViewById(R.id.baianxietyresultsum);
		// TODO Auto-generated method stub
		// baibecktest에서 데이터를 받아오자
		Intent intent = getIntent(); // getIntent메소드는 현재 자신을 호출했던 Intent를 반환
		String resultsum = intent.getExtras().get("sum").toString();
		/*
		 * sum.setText("당신의 총점은 [" + resultsum + "] 입니다.\n" +
		 * "당신의 현재 심리 상태는 불안 상태 입니다.\n" + "당신의 불안 상태를 해결해줄 노래를 추천해드립니다.\n" +
		 * "(노래는 항시 업데이트 됩니다.)");
		 */
		sum.setText(Html.fromHtml("<b>string</b>" + "ㅋㅋㅋ"));

		sum.setText(Html.fromHtml("<font color=#000000>" + "당신의 총점은 ["
				+ "</font>" + "<b>" + "<font color=#ff0000>" + resultsum
				+ "</font>" + "</b>" + "<font color=#000000>" + "] 입니다.\n"
				+ "당신의 현재 심리 상태는 " + "</font>"
				+ "<b><font color=#ff0000>극심한 불안 상태</font></b>"
				+ "<font color=#000000>" + " 입니다.\n"
				+ "당신의 불안 상태를 해결해줄 노래를 추천해드립니다.\n" + "(노래는 항시 업데이트 됩니다.)"
				+ "</font>"));
		// 웹브라우저에서 텍스트 받아오기
		new LongRunningGetIO().execute();

	}

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
			// 이것도 발표했으면 좋겠다.
			HttpGet httpGet = new HttpGet(
					"http://baibecktest.appspot.com/item?q=baiesanxiety&item-searchby=product");
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

				try {

					// for (int i = 0; i <= 20; i++) {
					/*
					 * JSONArray jArr = new JSONArray(baibecktest); JSONObject
					 * jObj = jArr.getJSONObject(i);
					 */

					JSONObject jObj = new JSONObject(results);
					JSONArray jArr = jObj.getJSONArray("data");
					// 0에서 부터 끝까지 받아와서 Random으로 돌려버린다.
					// 받아와서 랜덤으로 돌린다.
					int number = (int) (Math.random() * jArr.length());
					JSONObject jObj2 = jArr.getJSONObject(number);
					list1.setText(jObj2.getString("name"));
					// url은 스트링이다.
					url1 = jObj2.getString("price");
					// 복수 노래 체크
					check = number;
					// url로 연결시키기
					list1.setOnClickListener(new View.OnClickListener() {

						public void onClick(View v) {

							// TODO Auto-generated method stub
							Intent i = new Intent(Intent.ACTION_VIEW);
							Uri u = Uri.parse(url1);
							i.setData(u);
							startActivity(i);
						}
					});

					// 5개가 중복된거 검사해야되는데 효율적인 코드가 없을까?
					do {
						number = (int) (Math.random() * jArr.length());
					} while (number == check);
					jObj2 = jArr.getJSONObject(number);
					list2.setText(jObj2.getString("name"));
					// url은 스트링이다.
					url2 = jObj2.getString("price");
					check = number;
					list2.setOnClickListener(new View.OnClickListener() {

						public void onClick(View v) {

							// TODO Auto-generated method stub
							Intent i = new Intent(Intent.ACTION_VIEW);
							Uri u = Uri.parse(url2);
							i.setData(u);
							startActivity(i);
						}
					});

					check1 = check; // 중복값을 확인하기 위함 (3번쨰)
					do {
						number = (int) (Math.random() * jArr.length());
					} while (number == check || number == check1);
					jObj2 = jArr.getJSONObject(number);
					list3.setText(jObj2.getString("name"));
					// url은 스트링이다.
					url3 = jObj2.getString("price");
					check1 = number; // 중복값을 확인하기 위함
					list3.setOnClickListener(new View.OnClickListener() {

						public void onClick(View v) {

							// TODO Auto-generated method stub
							Intent i = new Intent(Intent.ACTION_VIEW);
							Uri u = Uri.parse(url3);
							i.setData(u);
							startActivity(i);
						}
					});

					check2 = check1; // 중복값을 확인하기 위함 (3번쨰)
					do {
						number = (int) (Math.random() * jArr.length());
					} while (number == check || number == check1
							|| number == check2);
					jObj2 = jArr.getJSONObject(number);
					list4.setText(jObj2.getString("name"));
					// url은 스트링이다.
					url4 = jObj2.getString("price");
					check2 = number;
					list4.setOnClickListener(new View.OnClickListener() {

						public void onClick(View v) {

							// TODO Auto-generated method stub
							Intent i = new Intent(Intent.ACTION_VIEW);
							Uri u = Uri.parse(url4);
							i.setData(u);
							startActivity(i);
						}
					});

					check3 = check2; // 중복값을 확인하기 위함 (3번쨰)
					do {
						number = (int) (Math.random() * jArr.length());
					} while (number == check || number == check1
							|| number == check2 || number == check3);
					jObj2 = jArr.getJSONObject(number);
					list5.setText(jObj2.getString("name"));
					// url은 스트링이다.
					url5 = jObj2.getString("price");
					list5.setOnClickListener(new View.OnClickListener() {

						public void onClick(View v) {

							// TODO Auto-generated method stub
							Intent i = new Intent(Intent.ACTION_VIEW);
							Uri u = Uri.parse(url5);
							i.setData(u);
							startActivity(i);
						}
					});
					// JSONObject jObj2 = jArr.getJSONObject(0);
					// JSONObject jObj2 = jArr.getJSONObject(1001);
					// 각 이름("id"/)9에 해당하는 값을 추출.

					// list1.setText(jObj2.getString("name"));
					/*
					 * switch (i) { case 0: //list1.setText(resultStr);
					 * list1.setText(jObj2.getString("name")); resultStr = "";
					 * break; case 1: //list2.setText(resultStr);
					 * list2.setText(jObj2.getString("name")); resultStr = "";
					 * break; case 2: //list3.setText(resultStr);
					 * list3.setText(jObj2.getString("name")); resultStr = "";
					 * break;
					 * 
					 * case 3: list4.setText(resultStr); resultStr = ""; break;
					 * 
					 * case 4: list5.setText(resultStr); resultStr = ""; break;
					 * 
					 * }
					 */
					// }
				} catch (JSONException e) {
					Toast.makeText(baiesanxiety.this, e.getMessage(),
							Toast.LENGTH_SHORT).show();
				}

			}
			// Button b = (Button) findViewById(R.id.result);
			// b.setClickable(true);
		}
	}

}
