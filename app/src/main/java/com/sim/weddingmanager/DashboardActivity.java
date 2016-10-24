package com.sim.weddingmanager;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class DashboardActivity extends Activity {

	TextView tv_name;
	ImageButton img_hotel, img_cake, img_car, img_deco;
	private static final int CONTENT_VIEW_ID = 10101010;
	boolean fragmentOpened = false;
	Bundle savedInstanceState;
	SharedPreferences preferences ;
    final int RESULT_HOTEL=10;
    final int RESULT_CAR=11;
    final int RESULT_DECO=12;
    final int RESULT_CAKE=13;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);

		img_cake = (ImageButton) findViewById(R.id.cake_image);
		img_car = (ImageButton) findViewById(R.id.car_image);
		img_deco = (ImageButton) findViewById(R.id.deco_image);
		img_hotel = (ImageButton) findViewById(R.id.hotel_image);





		tv_name = (TextView) findViewById(R.id.welcome_text);
		
		/** TODO 1.1 SHARED PREFS (WELCOME + NAME) TEXTVIEW**/

		preferences = PreferenceManager.getDefaultSharedPreferences(this);
		String getName = 	preferences.getString("name","");
		String getDate = 	preferences.getString("date","");
		tv_name.setText("Welcome" + " " + " " + getName);

		/** TODO 5 ONCLICK IMAGEBUTTON + EXTRAS + START_ACTIVITY_FOR_RESULT -> EventListActivity **/

		img_hotel.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {


				Intent intentHotel = new Intent(DashboardActivity.this, EventListActivity.class);
				intentHotel.putExtra("choix","hotel");
				startActivityForResult(intentHotel,RESULT_HOTEL);




			}
		});

		img_cake.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {


				Intent intentCake = new Intent(DashboardActivity.this, EventListActivity.class);
				intentCake.putExtra("choix","cake");
				startActivityForResult(intentCake,RESULT_CAKE);

			}
		});
		img_car.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intentCar = new Intent(DashboardActivity.this, EventListActivity.class);
				intentCar.putExtra("choix","car");
				startActivityForResult(intentCar,RESULT_CAR);

			}
		});
		img_deco.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intentDeco = new Intent(DashboardActivity.this, EventListActivity.class);
				intentDeco.putExtra("choix","deco");
				startActivityForResult(intentDeco,RESULT_DECO);



			}
		});







	}


	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if (item.getItemId() == R.id.menu_calculate) {
			fragmentOpened=true;
			FrameLayout frame = new FrameLayout(this);
	        frame.setId(CONTENT_VIEW_ID);
	        setContentView(frame, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	        
	        /** TODO 4.1 MENU ITEM ACTION - LOAD BillingFragment**/
             FragmentManager fm = getFragmentManager();
            Fragment billing = new BillingFragment();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(CONTENT_VIEW_ID, billing);
            ft.commit();






	       
		}
		return super.onOptionsItemSelected(item);
	}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_dashboard, menu);
        return true;
    }




	/** TODO 6 ON_ACTIVITY_RESULT -> TOAST **/



    protected void onActivityResult(int requestcode,int resultcode,Intent data){

        if(resultcode==RESULT_HOTEL && requestcode==11){

            if(data.hasExtra("resultName")){
                String result =data.getExtras().getString("resultName");
                if(result!=null && result.length()>0){

                    Toast.makeText(this, "Resultat:" + result, Toast.LENGTH_LONG).show();
                }
            }

        }


    }




	
	@Override
	public void onBackPressed() {
			
			if(fragmentOpened==true){
				finish();
				startActivity(getIntent());
			}
			else
				finish();
			
	}
}
