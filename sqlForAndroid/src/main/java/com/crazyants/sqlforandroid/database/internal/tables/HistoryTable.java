/*
 * @package     com.crazyants.sqlforandroid.database.internal.tables
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
package com.crazyants.sqlforandroid.database.internal.tables;

import android.content.ContentValues;
import android.database.Cursor;

import com.crazyants.sqlforandroid.database.interfaces.DBConstants;
import com.crazyants.sqlforandroid.database.interfaces.tables.DefaultTable;
import com.crazyants.sqlforandroid.logs.Log;

public final class HistoryTable extends DefaultTable implements DBConstants.HistoryColumns {

    private final String CREATE_TABLE_STMT = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("
            + FIELD_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FIELD_TIMESTAMP+" LONG DEFAULT 0,"
            + FIELD_HISTORY+" TEXT,"
            + FIELD_RESULT+" TEXT)";

    public HistoryTable() {
    }

    @Override
    public String getName() {
        return TABLE_NAME;
    }

    @Override
    public String[] getTables() {
        return new String[]{
                CREATE_TABLE_STMT
        };
    }

    @Override
    public Cursor query(String[] projection, String where, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
        return mDatabaseHelper.query(TABLE_NAME,projection, where, selectionArgs, groupBy, having, orderBy, limit);
    }

    @Override
    public long insert(ContentValues values) {
        return mDatabaseHelper.insert(TABLE_NAME,null,values);
    }

    @Override
    public int update(ContentValues values, String where, String[] selectionArgs) {
        return mDatabaseHelper.update(TABLE_NAME,values, where, selectionArgs);
    }
}
