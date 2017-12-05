package com.crazyants.sqlforandroid.display;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.crazyants.sqlforandroid.R;
import com.crazyants.sqlforandroid.logs.Log;

import java.util.ArrayList;
import java.util.Hashtable;

public class NowArrayAdapter extends ArrayAdapter<String> {

	private static final String TAG = NowArrayAdapter.class.getSimpleName();
	private static Hashtable<String,Typeface> fonts;

	private Context context;
	private ArrayList<String> values;
	private LayoutInflater inflater;
	
	public static class CustomListItem {
		TextView descText;
		static String FONT_TAG = "Primary";
	}
	
	public NowArrayAdapter(Context context,ArrayList<String> commandsList) {
		super(context, R.layout.historycard, commandsList);
		this.context = context;
		values = new ArrayList<String>();
		values.addAll(commandsList);
		inflater = LayoutInflater.from(this.context);
		loadFonts();
	}

	private void loadFonts(){
		if (fonts != null && !fonts.isEmpty()) {
			Log.debug(TAG,"No need to load fonts");
			return;
		}

		fonts = new Hashtable<String, Typeface>(2);
		fonts.put(CustomListItem.FONT_TAG,Typeface.createFromAsset(context.getAssets(),"fonts/fallingsky/FallingSky.otf"));
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		
		CustomListItem myListItem;
		
		String myText = getItem(position);
		
		if(convertView == null) {
			convertView = inflater.inflate(R.layout.historycard, parent, false);
			myListItem = new CustomListItem();
			myListItem.descText = (TextView) convertView.findViewById(R.id.commandText);
			convertView.setTag(myListItem);
		} else {
			myListItem = (CustomListItem) convertView.getTag();
		}
		myListItem.descText.setText(myText);
		myListItem.descText.setTypeface(fonts.get(CustomListItem.FONT_TAG));
//		myListItem.descText.setTextSize(14);

		return convertView;
	}
}
