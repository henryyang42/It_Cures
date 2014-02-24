package nthu.cs.henryyang42.cure;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnTouchListener {
	private Random rnd;
	private TextView textView;
	private SharedPreferences settings;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		settings = getSharedPreferences("Preference", 0);
		rnd = new Random();

		textView = (TextView) findViewById(R.id.textView);
		textView.setOnTouchListener(this);
		displayClickedTime();
	}

	private int getClickTimes() {
		int clicked = settings.getInt("click_times", 0);
		return clicked;
	}

	private void addClickTimes() {
		settings.edit().putInt("click_times", getClickTimes() + 1).commit();
	}

	private void displayClickedTime() {
		String clicked = String.valueOf(getClickTimes());
		textView.setBackgroundColor(Color.argb(rnd.nextInt(128),
				rnd.nextInt(200), 128 + rnd.nextInt(128),
				128 + rnd.nextInt(128)));
		int fontSize = 150;
		textView.setTextSize(fontSize);
		textView.setText(clicked);
	}

	@Override
	public boolean onTouch(View view, MotionEvent event) {
		addClickTimes();
		displayClickedTime();
		return false;
	}
}
