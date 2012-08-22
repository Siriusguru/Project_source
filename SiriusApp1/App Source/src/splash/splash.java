
package splash;

import exam.project.R;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class splash extends Activity {

	int splashSceneNumber;

	LinearLayout splashLayout;

	Handler mHandler;

	boolean isClick;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);

		// TODO Auto-generated method stub

		// xml �ҽ� ����
		splashLayout = (LinearLayout) findViewById(R.id.splashLayout);

		// ó��ȭ�� 0
		splashSceneNumber = 0;

		// Ŭ�� �̺�Ʈ�� �־����� Ȯ��
		isClick = true;

		mHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				switch (splashSceneNumber) {
				case 0:
					// �ι�° ȭ��
					splashSceneNumber = 1;

					splashLayout.setBackgroundDrawable(getResources()
							.getDrawable(R.drawable.hansung));

					mHandler.sendEmptyMessage(splashSceneNumber);
					break;

				case 1:
					splashSceneNumber = 2;
					mHandler.sendEmptyMessageDelayed(splashSceneNumber, 2000);
					break;

				case 2:
					// ��Ƽ��Ƽ ����
					splash.this.finish();
					break;

				case 3:
					// �������̺�Ʈ Ŭ���� ������� �ٷ� 0 �̺�Ʈ�� ������..
					if (isClick && splashSceneNumber == 0) {
						splashSceneNumber = 0;
						mHandler.sendEmptyMessage(splashSceneNumber);
					}
					break;
				}
			}
		};
		mHandler.sendEmptyMessageDelayed(3, 2000);
	}

	public void hn_splashOnclick(View v) {

		switch (splashSceneNumber) {
		case 0:
			splashSceneNumber = 0;

			isClick = false;
			mHandler.sendEmptyMessage(splashSceneNumber);
			break;

		case 1:
			splashSceneNumber = 2;
			mHandler.sendEmptyMessage(splashSceneNumber);
			break;
		}
	}
}

