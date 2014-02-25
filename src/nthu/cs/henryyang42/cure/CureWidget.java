package nthu.cs.henryyang42.cure;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.RemoteViews;

public class CureWidget extends AppWidgetProvider {
	private SharedPreferences settings;

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		RemoteViews views = new RemoteViews(context.getPackageName(),
				R.layout.activity_main);
		settings = context.getSharedPreferences("Preference", 0);
		views.setTextViewText(R.id.textView,
				String.valueOf(settings.getInt("click_times", 0)));

		appWidgetManager.updateAppWidget(appWidgetIds, views);

	}
}