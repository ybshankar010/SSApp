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

public interface ITableInterface {

    /**
     * Function to return table name
     *
     * @return
     *      name of the table
     */
    String getName();

    /**
     * Function to query table
     *
     * @param projection - columns that needs to be extracted from table
     * @param where - selection condition
     * @param selectionArgs - selection arguments (if any)
     * @param groupBy - column on which grouping needs to be done
     * @param having - condition on top of grouping condition
     * @param orderBy - column name to sort query
     * @param limit - number of records to be fethed
     * @return
     *      query results in form of cursor
     */
    Cursor query(String[] projection, String where, String[] selectionArgs,
                 String groupBy, String having, String orderBy, String limit);

    /**
     * Function to insert values in table
     *
     * @param values - content values to be stored
     * @return
     *      number of columns effected
     */
    long insert(ContentValues values);


    /**
     * Function to delete from table.
     *
     * @param where - condition on which delete has to be performed
     * @param selectionArgs - selection arguments (if any)
     * @return
     *      number of columns effected
     */
    int delete(String where,String[] selectionArgs);


    /**
     * Function to update values in table
     *
     * @param values - content values to be stored
     * @param where - condition on which update has to happen
     * @param selectionArgs - selection arguments(if any)
     * @return
     *      number of columns effected
     */
    int update(ContentValues values,String where,String[] selectionArgs);

    /**
     * Function to return create statements
     *
     * @return
     *      Array of create statements
     */
    String[] getTables();

    /**
     * Function to return views created on table
     *
     * @return
     *      Array of view statements
     */
    String[] getViews();

    /**
     * Function to return triggers on table
     *
     * @return
     *      Array of trigger statements
     */
    String[] getTriggers();

    /**
     * Function to execute raw statement
     *
     * @param sqlStmt - statement to be executed
     */
    void execSQL(String sqlStmt);

    /**
     * Function to create corresponding table
     *
     * @return
     *      status of creation
     */
    boolean create();
}
