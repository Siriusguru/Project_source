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
import exam.project.R;

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
		// �ٿ�ε� url�� �޾ƿ��� �ɰ� ����.
		// downloadFile �޼ҵ�

		//downloadFile("http://tv02.search.naver.net/ugc?t=r180&q=http://blogfiles.naver.net/20120514_83/jungi25_13369770126523RO6m_JPEG/naver_com_20120514_152906.jpg");
	}
*/
	// �̹��� URL�޾ƿ��� (�޼ҵ�)
	InputStream downloadFile(String fileUrl) {
		
		URL myFileUrl = null; // URL Ÿ���� myFileUrl�� NULL�� �ʱ�ȭ �����ݴϴ�.

		try {
			myFileUrl = new URL(fileUrl); // �Ķ���ͷ� �Ѿ�� Url�� myFileUrl�� �����մϴ�.

		} catch (MalformedURLException e) // ����ó���� ���ݴϴ�.
		{
			// Todo Auto-generated catch block
			e.printStackTrace();
		}
		try {
			// �������� ����� �̷������ �κ��Դϴ�.
			// myFileUrl �� ������ �õ��մϴ�.
			HttpURLConnection conn = (HttpURLConnection) myFileUrl
					.openConnection();
			conn.setDoInput(true);
			conn.connect();
			int length = conn.getContentLength(); // �޾ƿ� �������� ���̸� length ������
													// �����մϴ�.
			InputStream is = conn.getInputStream(); // InputStream is ������ �޾ƿ�
													// InputStream�� �����մϴ�.
			
			return is;

//			bmImg = BitmapFactory.decodeStream(is); // �޾ƿ� �̹����� bmImg�� �־�Ӵϴ�.
//			img.setImageBitmap(bmImg); // imView�� �̹����� �����մϴ�.
		} catch (IOException e) // ����ó���� ���ݴϴ�.
		{
			e.printStackTrace();
		}
		return null;
	}

}
