package com.crazyants.sqlforandroid.display;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.crazyants.sqlforandroid.R;

/*
 * @package     com.crazyants.sqlforandroid.display
 * @author      Shankar Y Bhavani
 * @Last Modified time 5/12/17
 *
 * Company name: Crazy@NTS
 * Description: Android app code for learning SQL
 * Version:     1.0.0
 * Author:      Shankar Y Bhavani
 * Author URI:  https://www.linkedin.com/in/shankar-bhavani-1ab72750
 * 
 * @contributors:
 *
 */
public class CardViewHolder extends RecyclerView.ViewHolder {
    private TextView mTextView;

    public CardViewHolder(CardView view) {
        super(view);
        this.mTextView = view.findViewById(R.id.commandText);
    }

    public void setText(String text) {
        mTextView.setText(text);
    }
}
