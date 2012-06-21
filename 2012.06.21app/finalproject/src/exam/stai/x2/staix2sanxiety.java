package exam.stai.x2;

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
//�Ȱ��� �����ε��� �ұ��ϰ� ���� View �� ������ ������ �ҽ��� �������� ���ֱ� �����̴�.
public class staix2sanxiety extends Activity {
	TextView sum;
	
	//�뷡�� �޾ƿ���
	TextView list1, list2, list3, list4, list5;
	//url �޾ƿ���
	//Ŭ���ϸ� URL�� �����Ű�� �ȴ�.
	
	
	String baibecktest;
	String resultStr;
	//url�� �޾ƿ��� ����
	String url1, url2, url3, url4, url5;
	//�����Լ��� �ߺ��� ���� ����
	int check, check1, check2, check3, check4;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.staix2sanxiety);
		list1 = (TextView)findViewById(R.id.list1);
		list2 = (TextView)findViewById(R.id.list2);
		list3 = (TextView)findViewById(R.id.list3);
		list4 = (TextView)findViewById(R.id.list4);
		list5 = (TextView)findViewById(R.id.list5);
		

		
		sum = (TextView) findViewById(R.id.baianxietyresultsum);
		// TODO Auto-generated method stub
		// baibecktest���� �����͸� �޾ƿ���
		Intent intent = getIntent(); // getIntent�޼ҵ�� ���� �ڽ��� ȣ���ߴ� Intent�� ��ȯ
		String resultsum = intent.getExtras().get("sum").toString();
		/*
		sum.setText("����� ������ [" + resultsum + "] �Դϴ�.\n"
				+ "����� ���� �ɸ� ���´� �Ҿ� ���� �Դϴ�.\n"
				+ "����� �Ҿ� ���¸� �ذ����� �뷡�� ��õ�ص帳�ϴ�.\n" + "(�뷡�� �׽� ������Ʈ �˴ϴ�.)");
		
		*/
		sum.setText(Html.fromHtml("<b>string</b>" + "������")); 

		sum.setText(Html.fromHtml("<font color=#000000>"+"����� ������ [" +"</font>"+ "<b>"+"<font color=#ff0000>" + resultsum + "</font>" + "</b>" + "<font color=#000000>"+ "] �Դϴ�.\n"
		+ "����� ���� �ɸ� ���´� " +"</font>"+ "<b><font color=#ff0000>Ư���Ҿ� ������ ����� ����.</font></b>" +"<font color=#000000>"+ " �Դϴ�.\n"
		+ "����� �Ҿ� ���¸� �ذ����� �뷡�� ��õ�ص帳�ϴ�.\n" + "(�뷡�� �׽� ������Ʈ �˴ϴ�.)"+"</font>"));
		// ������������ �ؽ�Ʈ �޾ƿ���
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
			//�̰͵� ��ǥ������ ���ڴ�.
			HttpGet httpGet = new HttpGet("http://baibecktest.appspot.com/item?q=staix2sanxiety&item-searchby=product");
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

			

				try {
					
					//for (int i = 0; i <= 20; i++) {
						/*
						JSONArray jArr = new JSONArray(baibecktest);
						JSONObject jObj = jArr.getJSONObject(i);
						*/
						
						JSONObject jObj =  new JSONObject(results);
						JSONArray jArr = jObj.getJSONArray("data");
						//0���� ���� ������ �޾ƿͼ� Random���� ����������.
						//�޾ƿͼ� �������� ������.
						int number = (int) (Math.random() * jArr.length());
						JSONObject jObj2 = jArr.getJSONObject(number);
						list1.setText(jObj2.getString("name"));
						//url�� ��Ʈ���̴�.
						url1 = jObj2.getString("price");		
						//���� �뷡 üũ
						check = number;
						//url�� �����Ű��
						list1.setOnClickListener(new View.OnClickListener() {
							
							public void onClick(View v) {
								
								// TODO Auto-generated method stub
								Intent i = new Intent(Intent.ACTION_VIEW);
								Uri u = Uri.parse(url1);
								i.setData(u);
								startActivity(i);
							}
						});
						
						
						//5���� �ߺ��Ȱ� �˻��ؾߵǴµ� ȿ������ �ڵ尡 ������?
						do {
							number = (int) (Math.random() * jArr.length());
						}while(number == check);
						jObj2 = jArr.getJSONObject(number);
						list2.setText(jObj2.getString("name"));
						//url�� ��Ʈ���̴�.
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
						
						check1 = check; //�ߺ����� Ȯ���ϱ� ���� (3����)
						do {
							number = (int) (Math.random() * jArr.length());
						}while(number == check || number == check1);
						jObj2 = jArr.getJSONObject(number);
						list3.setText(jObj2.getString("name"));
						//url�� ��Ʈ���̴�.
						url3 = jObj2.getString("price");
						check1=number; // �ߺ����� Ȯ���ϱ� ����
						list3.setOnClickListener(new View.OnClickListener() {
							
							public void onClick(View v) {
							
								// TODO Auto-generated method stub
								Intent i = new Intent(Intent.ACTION_VIEW);
								Uri u = Uri.parse(url3);
								i.setData(u);
								startActivity(i);
							}
						});	
						
						
						check2 = check1; //�ߺ����� Ȯ���ϱ� ���� (3����)
						do {
							number = (int) (Math.random() * jArr.length());
						}while(number == check || number == check1 || number == check2);
						jObj2 = jArr.getJSONObject(number);
						list4.setText(jObj2.getString("name"));
						//url�� ��Ʈ���̴�.
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
						
						
						
						check3 = check2; //�ߺ����� Ȯ���ϱ� ���� (3����)
						do {
							number = (int) (Math.random() * jArr.length());
						}while(number == check || number == check1 || number == check2 || number == check3);
						jObj2 = jArr.getJSONObject(number);
						list5.setText(jObj2.getString("name"));
						//url�� ��Ʈ���̴�.
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
						//JSONObject jObj2 = jArr.getJSONObject(0);
						//JSONObject jObj2 = jArr.getJSONObject(1001);
						// �� �̸�("id"/)9�� �ش��ϴ� ���� ����.
						
						//list1.setText(jObj2.getString("name"));
						/*
						switch (i) {
						case 0:
							//list1.setText(resultStr);
							list1.setText(jObj2.getString("name"));
							resultStr = "";
							break;
						case 1:
							//list2.setText(resultStr);
							list2.setText(jObj2.getString("name"));
							resultStr = "";
							break;
						case 2:
							//list3.setText(resultStr);
							list3.setText(jObj2.getString("name"));
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
			
						}
						*/
				//}
				} catch (JSONException e) {
					Toast.makeText(staix2sanxiety.this, e.getMessage(),
							Toast.LENGTH_SHORT).show();
				}

			}
			// Button b = (Button) findViewById(R.id.result);
			// b.setClickable(true);
		}
	}

}
