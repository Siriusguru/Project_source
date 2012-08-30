package app.help;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import MusicMate.song.R;

public class help extends Activity implements OnClickListener {
	private TextView help;
	private TextView help2;
	private AlertDialog alert;
	private TextView help3;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);
		help = (TextView) findViewById(R.id.help);
		help2 = (TextView) findViewById(R.id.help2);
		help3 = (TextView) findViewById(R.id.help3);
		help.setOnClickListener(help.this);
		help2.setOnClickListener(help.this);
		help3.setOnClickListener(help.this);

	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.help:
			alert = new AlertDialog.Builder(help.this)
					.setIcon(R.drawable.help)
					.setTitle("Music Mate는 어떤 앱인가요?")
					.setMessage(
							"스마트폰 사용자들에게 음악을 추천해주는 서비스입니다.\n"
									+ "음악 추천 뿐만 아니라 노래의 간단한 코멘트, URL 링크로 YouTube연결을 이용해 바로 노래를 들을 수 있는 앱입니다.\n"
									+ "노래는 매일 서버에서 Update 됩니다.")
					.setPositiveButton("OK",
							new DialogInterface.OnClickListener() {

								public void onClick(DialogInterface dialog,
										int which) {
									dialog.dismiss();
								}
							}).show();
			break;
		case R.id.help2:
			alert = new AlertDialog.Builder(help.this)
					.setIcon(R.drawable.help)
					.setTitle("음악추천은 누가 하나요?")
					.setMessage(
							"기본적으로 개발자가 추천을 하고, 음악의 다양한 장르를 들려주기 위하여 다른 사용자들의 추천도 받습니다.")
					.setPositiveButton("OK",
							new DialogInterface.OnClickListener() {

								public void onClick(DialogInterface dialog,
										int which) {
									dialog.dismiss();
								}
							}).show();
			break;
		case R.id.help3:
			alert = new AlertDialog.Builder(help.this)
					.setIcon(R.drawable.help)
					.setTitle("프로젝트 소스 공유(GIT)사이트")
					.setMessage(
							"https://github.com/Siriusguru/Project_source")
					.setPositiveButton("OK",
							new DialogInterface.OnClickListener() {

								public void onClick(DialogInterface dialog,
										int which) {
									dialog.dismiss();
								}
							}).show();
			break;
		}

	}

}
