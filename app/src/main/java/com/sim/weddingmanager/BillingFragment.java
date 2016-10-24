package com.sim.weddingmanager;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BillingFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_billing, container, false);
		
		/** TODO 11 GET DETAILS FROM DATABASE **/
		
		/** TODO 12 SET VALUES TO TEXT VIEWS + CALCULATE THE BILLING**/
		
		return view;
	
	}
	
	@Override
	public void onStart() {
		
		super.onStart();

	}

}
