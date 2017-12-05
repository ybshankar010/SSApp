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

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.crazyants.sqlforandroid.database.interfaces.tables.DefaultTable;
import com.crazyants.sqlforandroid.logs.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AndroidSQLHelper extends SQLiteOpenHelper implements IDatabaseHelper{
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
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        //                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              TODO Has to provide support for table
    }

    @Override
    public Cursor query(String tableName, String[] projection, String where, String[] selectionArgs,
                        String groupBy, String having, String orderBy, String limit) {
        DefaultTable table = mTables.get(tableName);
        if (table == null) {
            Log.error(TAG,"In appropriate table");
            return null;
        }
        return table.query(projection,where,selectionArgs,groupBy,having,orderBy,limit);
    }

    @Override
    public long insert(String tableName, ContentValues values) {
        DefaultTable table = mTables.get(tableName);
        if (table == null) {
            Log.error(TAG,"In appropriate table");
            return -1;
        }
        return table.insert(values);
    }

    @Override
    public int delete(String tableName, String where, String[] selectionArgs) {
        DefaultTable table = mTables.get(tableName);
        if (table == null) {
            Log.error(TAG,"In appropriate table");
            return -1;
        }
        return table.delete(where,selectionArgs);
    }

    @Override
    public int update(String tableName, ContentValues values, String where, String[] selectionArgs) {
        DefaultTable table = mTables.get(tableName);
        if (table == null) {
            Log.error(TAG,"In appropriate table");
            return -1;
        }

        return table.update(values, where, selectionArgs);
    }

    @Override
    public void execSQL(String sqlStmt) {
        getWritableDatabase().execSQL(sqlStmt);
    }
}
