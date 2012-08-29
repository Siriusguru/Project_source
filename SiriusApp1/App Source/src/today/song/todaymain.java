package today.song;

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

import splash.splash;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import MusicMate.song.R;

public class todaymain extends Activity {
	Bitmap bmImg;
	ImageView img, img2, img3;
	TextView themeurl1, themeurl2, themeurl3, contenturl1, contenturl2,
			contenturl3;
	InputStream stringimageurl;

	String simageurl, syoutubeurl, stheme, scontent,
	syoutubeurl2, syoutubeurl3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		startActivity(new Intent(this, splash.class));
		
		setContentView(R.layout.todaysong);
		img = (ImageView) findViewById(R.id.imageurl1);
		img2 = (ImageView) findViewById(R.id.imageurl2);
		img3 = (ImageView) findViewById(R.id.imageurl3);
		themeurl1 = (TextView) findViewById(R.id.themeurl1);
		themeurl2 = (TextView) findViewById(R.id.themeurl2);
		themeurl3 = (TextView) findViewById(R.id.themeurl3);
		contenturl1 = (TextView) findViewById(R.id.contenturl1);
		contenturl2 = (TextView) findViewById(R.id.contenturl2);
		contenturl3 = (TextView) findViewById(R.id.contenturl3);
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
					"http://appserver12.appspot.com/item?q=todaysong&item-searchby=product");
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
				try {
					JSONObject jObj = new JSONObject(results);
					JSONArray jArr = jObj.getJSONArray("data");
					// 0에서 부터 끝까지 받아와서 Random으로 돌려버린다.
					// 받아와서 랜덤으로 돌린다.
					// int number = (int) (Math.random() * jArr.length());
					for (int number = 0; number <= 2; number++) {

						JSONObject jObj2 = jArr.getJSONObject(number);
						simageurl = jObj2.getString("name");// 노래 이미지
						stheme = jObj2.getString("songname"); // 노래 제목
						scontent = jObj2.getString("manual"); // 노래 설명
						
						
						
						// 이미지를 받아오는 부분
						todayimage imageurl = new todayimage();
						/*
						 * stringimageurl = imageurl .downloadFile(
						 * "http://tv02.search.naver.net/ugc?t=r115&q=http://blogfiles.naver.net/20110928_284/elviskang1_1317178916024sbYgD_JPEG/%BC%BA%BD%C3%B0%E6_%B3%BB%B0%D4%BF%C0%B4%C2%B1%E6_%282%29.jpg"
						 * );
						 */
						stringimageurl = imageurl.downloadFile(simageurl);
						bmImg = BitmapFactory.decodeStream(stringimageurl); // 받아온
																			// 이미지를
																			// bmImg에
																			// 넣어둡니다.

						switch (number) {
						case 0:
							syoutubeurl = jObj2.getString("price");// 노래 유투브
							img.setImageBitmap(bmImg); // imView에 이미지를 셋팅합니다.

							themeurl1.setText(stheme);
							contenturl1.setText(scontent);

							img.setOnClickListener(new View.OnClickListener() {

								public void onClick(View v) {
									// TODO Auto-generated method stub
									Intent i = new Intent(Intent.ACTION_VIEW);
									Uri u = Uri.parse(syoutubeurl);
									i.setData(u);
									startActivity(i);
								}
							});
							break;
						case 1:
							syoutubeurl2 = jObj2.getString("price");// 노래 유투브
							img2.setImageBitmap(bmImg); // imView에 이미지를 셋팅합니다.

							themeurl2.setText(stheme);
							contenturl2.setText(scontent);

							img2.setOnClickListener(new View.OnClickListener() {

								public void onClick(View v) {
									// TODO Auto-generated method stub
									Intent i = new Intent(Intent.ACTION_VIEW);
									Uri u = Uri.parse(syoutubeurl2);
									i.setData(u);
									startActivity(i);
								}
							});
							break;
						case 2:
							syoutubeurl3 = jObj2.getString("price");// 노래 유투브
							img3.setImageBitmap(bmImg); // imView에 이미지를 셋팅합니다.

							themeurl3.setText(stheme);
							contenturl3.setText(scontent);

							img3.setOnClickListener(new View.OnClickListener() {

								public void onClick(View v) {
									// TODO Auto-generated method stub
									Intent i = new Intent(Intent.ACTION_VIEW);
									Uri u = Uri.parse(syoutubeurl3);
									i.setData(u);
									startActivity(i);
								}
							});
							break;							
						}
					}

					// list1.setText(jObj2.getString("name"));
					// url은 스트링이다.
					// url1 = jObj2.getString("price");
					// 복수 노래 체크

					/*
					 * // url로 연결시키기 list1.setOnClickListener(new
					 * View.OnClickListener() {
					 * 
					 * public void onClick(View v) {
					 * 
					 * // TODO Auto-generated method stub Intent i = new
					 * Intent(Intent.ACTION_VIEW); Uri u = Uri.parse(url1);
					 * i.setData(u); startActivity(i); } });
					 * 
					 * // 5개가 중복된거 검사해야되는데 효율적인 코드가 없을까? do { number = (int)
					 * (Math.random() * jArr.length()); } while (number ==
					 * check); jObj2 = jArr.getJSONObject(number);
					 * list2.setText(jObj2.getString("name")); // url은 스트링이다.
					 * url2 = jObj2.getString("price"); check = number;
					 * list2.setOnClickListener(new View.OnClickListener() {
					 * 
					 * public void onClick(View v) {
					 * 
					 * // TODO Auto-generated method stub Intent i = new
					 * Intent(Intent.ACTION_VIEW); Uri u = Uri.parse(url2);
					 * i.setData(u); startActivity(i); } });
					 */
				} catch (JSONException e) {
					Toast.makeText(todaymain.this, e.getMessage(),
							Toast.LENGTH_SHORT).show();
				}

			}

		}
	}

}
