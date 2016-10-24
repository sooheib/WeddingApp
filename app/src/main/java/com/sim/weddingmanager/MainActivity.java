package com.sim.weddingmanager;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	public static final String PREF_NAME = "EspritMobilePrefs";

	SharedPreferences preferences ;

	Button button_valider;
	EditText ed_name, ed_date;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		preferences = PreferenceManager.getDefaultSharedPreferences(this);
		button_valider = (Button)findViewById(R.id.button_validate);

		ed_name =(EditText)findViewById(R.id.edit_name);
		ed_date = (EditText) findViewById(R.id.edit_date);


		String getName = 	preferences.getString("name","");
		String getDate = 	preferences.getString("date","");



		String name = getName;
		String date = getDate;

		ed_date.setText(date);
		ed_name.setText(name);

		/** TRAP 1 **/
		
		button_valider.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				String name = ed_name.getText().toString();
				String date = ed_date.getText().toString();



				/** TODO1 SharedPrefs**/


				if (!name.equals("") && !date.equals("")) {


					SharedPreferences.Editor editor = preferences.edit();
					editor.putString("name", name);
					editor.putString("date", date);

					editor.commit();

				}





					/** TODO2 Intent**/


				startActivity(new Intent(MainActivity.this, DashboardActivity.class));
				
			}
		});
		
	}

	
}
