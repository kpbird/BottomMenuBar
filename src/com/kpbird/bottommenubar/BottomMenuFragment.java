package com.kpbird.bottommenubar;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

public class BottomMenuFragment extends Fragment implements OnClickListener {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.bottom_menu, container,false);
		ImageButton b1 =(ImageButton)view.findViewById(R.id.imageButton1);
		ImageButton b2 =(ImageButton)view.findViewById(R.id.imageButton2);
		ImageButton b3 =(ImageButton)view.findViewById(R.id.imageButton3);
		ImageButton b4 =(ImageButton)view.findViewById(R.id.imageButton4);

		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		
		return view;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.imageButton1:
			Toast.makeText(getActivity() ,"Button 1 clicked", Toast.LENGTH_LONG).show();
			break;
		case R.id.imageButton2:
			Toast.makeText(getActivity() ,"Button 2 clicked", Toast.LENGTH_LONG).show();
			break;
		case R.id.imageButton3:
			Toast.makeText(getActivity() ,"Button 3 clicked", Toast.LENGTH_LONG).show();
			break;
		case R.id.imageButton4:
			Toast.makeText(getActivity() ,"Button 4 clicked", Toast.LENGTH_LONG).show();
			break;
		}
	}
}
