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
					.setTitle("Music Mate�� � ���ΰ���?")
					.setMessage(
							"����Ʈ�� ����ڵ鿡�� ������ ��õ���ִ� �����Դϴ�.\n"
									+ "���� ��õ �Ӹ� �ƴ϶� �뷡�� ������ �ڸ�Ʈ, URL ��ũ�� YouTube������ �̿��� �ٷ� �뷡�� ���� �� �ִ� ���Դϴ�.\n"
									+ "�뷡�� ���� �������� Update �˴ϴ�.")
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
					.setTitle("������õ�� ���� �ϳ���?")
					.setMessage(
							"�⺻������ �����ڰ� ��õ�� �ϰ�, ������ �پ��� �帣�� ����ֱ� ���Ͽ� �ٸ� ����ڵ��� ��õ�� �޽��ϴ�.")
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
					.setTitle("������Ʈ �ҽ� ����(GIT)����Ʈ")
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
