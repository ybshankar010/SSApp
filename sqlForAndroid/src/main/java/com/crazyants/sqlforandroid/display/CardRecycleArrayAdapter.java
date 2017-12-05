package com.crazyants.sqlforandroid.display;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.crazyants.sqlforandroid.R;

import java.util.Hashtable;
import java.util.List;

public class CardRecycleArrayAdapter extends RecyclerView.Adapter<CardViewHolder> {

	private static final String TAG = CardRecycleArrayAdapter.class.getSimpleName();
	private static Hashtable<String,Typeface> fonts;

	private Context context;
	private List<String> values;
	private LayoutInflater inflater;

	public CardRecycleArrayAdapter(final List<String> cards) {
		this.values = cards;
	}

	@Override
	public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// create a new view
		CardView v = (CardView) LayoutInflater.from(parent.getContext())
				.inflate(R.layout.historycard, parent, false);
		CardViewHolder vh = new CardViewHolder(v);
		return vh;
	}

	@Override
	public void onBindViewHolder(CardViewHolder holder, int position) {
		holder.setText(values.get(position));
	}

	@Override
	public int getItemCount() {
		return values.size();
	}
}
