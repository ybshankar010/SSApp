/*
 * @package     com.crazyants.sqlforandroid.database.internal
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
package com.crazyants.sqlforandroid.database.internal;

import android.content.Context;

import com.crazyants.sqlforandroid.database.interfaces.AndroidSQLHelper;
import com.crazyants.sqlforandroid.database.interfaces.DBConstants;
import com.crazyants.sqlforandroid.database.interfaces.tables.DefaultTable;
import com.crazyants.sqlforandroid.database.internal.tables.HistoryTable;
import com.crazyants.sqlforandroid.database.internal.tables.TableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InternalDBInterface {

    private final AndroidSQLHelper mSQLHelper;
    private final List<DefaultTable> mInternalTables;

    public InternalDBInterface(Context context) {
        mInternalTables = new ArrayList<DefaultTable>(5);
        mInternalTables.add(new HistoryTable());
        mInternalTables.add(new TableList());

        mSQLHelper = new AndroidSQLHelper(context, DBConstants.InternalTable.DATABASE_NAME,
                Collections.unmodifiableList(mInternalTables),DBConstants.InternalTable.DB_VERSION);
    }
}
