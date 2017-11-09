/*
 * @package     com.crazyants.sqlforandroid.database.interfaces
 * @author      Shankar Y Bhavani
 * @Last Modified time 9/11/17
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
package com.crazyants.sqlforandroid.database.interfaces;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.crazyants.sqlforandroid.database.interfaces.tables.DefaultTable;
import com.crazyants.sqlforandroid.logs.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AndroidSQLHelper extends SQLiteOpenHelper {
    private static final String TAG = AndroidSQLHelper.class.getSimpleName();

    private final Map<String,DefaultTable> mTables;

    public AndroidSQLHelper(Context context, String name, List<DefaultTable> tables, int version) {
        super(context, name, null, version);
        mTables = new HashMap<String,DefaultTable>(10);
        for (DefaultTable table : tables) {
            table.setDatabaseHelper(getWritableDatabase());
            mTables.put(table.getName(),table);
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        if (mTables.isEmpty()) {
            Log.error(TAG,"No tables in database.");
            return;
        }

        for (DefaultTable table : mTables.values()) {
            table.create();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
