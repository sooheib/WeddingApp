package com.sim.weddingmanager;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.sim.weddingmanager.dao.EventDAO;
import com.sim.weddingmanager.entities.Event;

import java.util.ArrayList;
import java.util.HashMap;

public class EventListActivity extends Activity implements AdapterView.OnItemClickListener{

	HashMap<String, String> map;
	ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String,String>>();
	
	String[] hotel_names;
	String[] hotel_prices;
	TypedArray hotel_images;
	
	String[] car_names;
	String[] car_prices;
	TypedArray car_images;
	
	String[] deco_names;
	String[] deco_prices;
	TypedArray deco_images;
	
	String[] cake_names;
	String[] cake_prices;
	TypedArray cake_images;
	Bundle extra;
	ListView listView;
	String choix;

	int ResHotel =11;
	int ResCake =12;
	int ResCar =13;
	int ResDeco =14;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_list);

		listView = (ListView) findViewById(R.id.lista);

		hotel_names = getResources().getStringArray(R.array.hotel_name);
		hotel_prices = getResources().getStringArray(R.array.hotel_price);
		hotel_images = getResources().obtainTypedArray(R.array.hotel_image);
		
		car_names = getResources().getStringArray(R.array.car_name);
		car_prices = getResources().getStringArray(R.array.car_price);
		car_images = getResources().obtainTypedArray(R.array.car_image);
		
		cake_names = getResources().getStringArray(R.array.cake_name);
		cake_prices = getResources().getStringArray(R.array.cake_price);
		cake_images = getResources().obtainTypedArray(R.array.cake_image);
		
		deco_names = getResources().getStringArray(R.array.deco_name);
		deco_prices = getResources().getStringArray(R.array.deco_price);
		deco_images = getResources().obtainTypedArray(R.array.deco_image);

		listView.setOnItemClickListener(this);
		/** HINT GET IMAGE RESSOURCE 
		 * FROM TYPEDARRAY :
		 * String.valueOf(deco_images.getResourceId(i, -1)) **/
		
		
		/** TODO 8 GET INTENT + FEEDING THE ArrayList **/


		 extra = getIntent().getExtras();
		if(extra!=null){
		extra.getString("choix");
		}


		/** TODO 9 SIMPLE ADAPTER **/
		String[] from = new String[] {"image","name","price"};
		int[] to = new int[] {R.id.imgEvent,R.id.nameEvent,R.id.priceEvent};


		if(extra.getString("choix").equals("hotel")){
			Toast.makeText(EventListActivity.this, "HOTEL", Toast.LENGTH_SHORT).show();


			for (int i=0 ;i<hotel_images.length();i++) {

				map = new HashMap<String, String>();
				map.put("image",String.valueOf(hotel_images.getResourceId(i, -1)));
				map.put("name",hotel_names[i]);
				map.put("price",hotel_prices[i]);
				data.add(map);


			}


		}
		else if(extra.getString("choix").equals("car")){
			Toast.makeText(EventListActivity.this, "CAR", Toast.LENGTH_SHORT).show();

			for (int i=0 ;i<car_images.length();i++) {

				map = new HashMap<String, String>();
				map.put("image",String.valueOf(car_images.getResourceId(i, -1)));
				map.put("name",car_names[i]);
				map.put("price",car_prices[i]);
				data.add(map);


			}





		}
		else if(extra.getString("choix").equals("cake")){
			Toast.makeText(EventListActivity.this, "CAKE", Toast.LENGTH_SHORT).show();

			for (int i=0 ;i<cake_images.length();i++) {

				map = new HashMap<String, String>();
				map.put("image",String.valueOf(cake_images.getResourceId(i, -1)));
				map.put("name",cake_names[i]);
				map.put("price",cake_prices[i]);
				data.add(map);


			}



		}
		else if(extra.getString("choix").equals("deco")){
			Toast.makeText(EventListActivity.this, "DECO", Toast.LENGTH_SHORT).show();


			for (int i=0 ;i<deco_images.length();i++) {

				map = new HashMap<String, String>();
				map.put("image",String.valueOf(deco_images.getResourceId(i, -1)));
				map.put("name",deco_names[i]);
				map.put("price",deco_prices[i]);
				data.add(map);


			}



		}
		else{
			Toast.makeText(EventListActivity.this, "EREUUUUUUUUUUUUUUUUUR", Toast.LENGTH_SHORT).show();
		}


		SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.one_event, from, to);
		listView.setAdapter(adapter);





		/** TODO 10 OnItemClickListener + INSERT DATABASE + RESULT -> DASHBOARD_ACTIVITY **/
		
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

		if (extra.getString("choix").equals("hotel")) {



			EventDAO dao = new EventDAO(Event.class,EventListActivity.this);
			Event event = new Event(hotel_names[position], hotel_prices[position]);
			dao.create(event);
			Intent data = new Intent();
			data.putExtra("choix", hotel_names[position]);
			setResult(RESULT_OK, data);
			finish();




		}
		else if (extra.getString("choix").equals("car")) {


			EventDAO dao2 = new EventDAO(Event.class,EventListActivity.this);
			Event event2 = new Event(car_names[position], car_prices[position]);
			dao2.create(event2);
			Intent data2 = new Intent();
			data2.putExtra("choix", car_names[position]);
			setResult(RESULT_OK, data2);
			finish();

		}
		else if (extra.getString("choix").equals("cake")) {


			EventDAO dao5 = new EventDAO(Event.class,EventListActivity.this);
			Event event5 = new Event(cake_names[position], cake_prices[position]);
			dao5.create(event5);
			Intent data5 = new Intent();
			data5.putExtra("choix", cake_names[position]);
			setResult(RESULT_OK, data5);
			finish();


		}
		else if (extra.getString("choix").equals("deco")) {


			EventDAO dao1 = new EventDAO(Event.class,EventListActivity.this);
			Event event1 = new Event(deco_names[position], deco_prices[position]);
			dao1.create(event1);
			Intent data1 = new Intent();
			data1.putExtra("choix", deco_names[position]);
			setResult(RESULT_OK, data1);
			finish();


		}






	}
}
