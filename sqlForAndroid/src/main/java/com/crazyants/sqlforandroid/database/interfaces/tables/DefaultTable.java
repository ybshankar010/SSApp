/*
 * @package     com.crazyants.sqlforandroid.database.interfaces.tables
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
package com.crazyants.sqlforandroid.database.interfaces.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.crazyants.sqlforandroid.logs.Log;

public abstract class DefaultTable implements ITableInterface {

    protected final String TAG;

    protected SQLiteDatabase mDatabaseHelper;

    protected DefaultTable() {
        TAG = getName();
    }

    public void setDatabaseHelper(SQLiteDatabase database) {
        this.mDatabaseHelper = database;
    }

    @Override
    public boolean create() {
        if (mDatabaseHelper == null) {
            Log.error(TAG,"Table not initialized properly");
            return false;
        }

        String[] tables = getTables();
        if (tables == null || tables.length <= 0) {
            Log.error(TAG,"Table doesn't have create statements");
            return false;
        }
        for (String table : tables) {
            execSQL(table);
        }

        String[] views = getViews();
        if (views != null) {
            for (String view:views) {
                execSQL(view);
            }
        }

        String[] triggers = getTriggers();
        if (triggers != null && triggers.length>0) {
            for (String trigger:triggers) {
                execSQL(trigger);
            }
        }
        return true;
    }

    @Override
    public void execSQL(String sqlStmt) {
        try {
            mDatabaseHelper.execSQL(sqlStmt);
        } catch (Exception e) {
            for (StackTraceElement errorMessage:e.getStackTrace()) {
                Log.error(TAG,errorMessage.toString());
            }
        }
    }

    @Override
    public Cursor query(String[] projection, String where, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
        return null;
    }

    @Override
    public long insert(ContentValues values) {
        return 0;
    }

    @Override
    public int delete(String where, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(ContentValues values, String where, String[] selectionArgs) {
        return 0;
    }

    @Override
    public String[] getViews() {
        return null;
    }

    @Override
    public String[] getTriggers() {
        return null;
    }

}
