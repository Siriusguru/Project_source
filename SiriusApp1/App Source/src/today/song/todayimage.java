package today.song;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import MusicMate.song.R;

public class todayimage extends Activity {
	//static Bitmap bmImg;
	//static ImageView img;
/*
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.todaysong);
		//img = (ImageView) findViewById(R.id.imageurl1);
		// 다운로드 url을 받아오면 될거 같다.
		// downloadFile 메소드

		//downloadFile("http://tv02.search.naver.net/ugc?t=r180&q=http://blogfiles.naver.net/20120514_83/jungi25_13369770126523RO6m_JPEG/naver_com_20120514_152906.jpg");
	}
*/
	// 이미지 URL받아오기 (메소드)
	InputStream downloadFile(String fileUrl) {
		
		URL myFileUrl = null ; // URL 타입의 myFileUrl을 NULL로 초기화 시켜줍니다.

		try {
			myFileUrl = new URL(fileUrl); // 파라미터로 넘어온 Url을 myFileUrl에 대입합니다.

		} catch (MalformedURLException e) // 예외처리를 해줍니다.
		{
			// Todo Auto-generated catch block
			e.printStackTrace();
		}
		try {
			// 실질적인 통신이 이루어지는 부분입니다.
			// myFileUrl 로 접속을 시도합니다.
			HttpURLConnection conn = (HttpURLConnection) myFileUrl
					.openConnection();
			conn.setDoInput(true);
			conn.connect();
			int length = conn.getContentLength(); // 받아온 컨텐츠의 길이를 length 변수에
													// 저장합니다.
			InputStream is = conn.getInputStream(); // InputStream is 변수에 받아온
													// InputStream을 저장합니다.
			
			return is;

//			bmImg = BitmapFactory.decodeStream(is); // 받아온 이미지를 bmImg에 넣어둡니다.
//			img.setImageBitmap(bmImg); // imView에 이미지를 셋팅합니다.
		} catch (IOException e) // 예외처리를 해줍니다.
		{
			e.printStackTrace();
		}
		return null;
	}

}
