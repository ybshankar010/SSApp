/*
 * @package     com.crazyants.sqlforandroid.logs
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
package com.crazyants.sqlforandroid.logs;

public final class Log {

    private static final String EASY_SEARCH_TAG = "[#SSAPP#]";

    public static void info(String tag,String msg,Object... additionalMSGS) {
        StringBuilder completeMessage = new StringBuilder(EASY_SEARCH_TAG);
        completeMessage.append(msg);
        for (Object additionalMSG:additionalMSGS) {
            completeMessage.append(additionalMSG.toString());
        }
        android.util.Log.i(tag,completeMessage.toString());
    }

    public static void error(String tag,String msg,Object... additionalMSGS) {
        StringBuilder completeMessage = new StringBuilder(EASY_SEARCH_TAG);
        completeMessage.append(msg);
        for (Object additionalMSG:additionalMSGS) {
            completeMessage.append(additionalMSG.toString());
        }
        android.util.Log.e(tag,completeMessage.toString());
    }

    public static void debug(String tag,String msg,Object... additionalMSGS) {
        StringBuilder completeMessage = new StringBuilder(EASY_SEARCH_TAG);
        completeMessage.append(msg);
        for (Object additionalMSG:additionalMSGS) {
            completeMessage.append(additionalMSG.toString());
        }
        android.util.Log.d(tag,completeMessage.toString());
    }

    public static void warn(String tag,String msg,Object... additionalMSGS) {
        StringBuilder completeMessage = new StringBuilder(EASY_SEARCH_TAG);
        completeMessage.append(msg);
        for (Object additionalMSG:additionalMSGS) {
            completeMessage.append(additionalMSG.toString());
        }
        android.util.Log.w(tag,completeMessage.toString());
    }

    public static void verbose(String tag,String msg,Object... additionalMSGS) {
        StringBuilder completeMessage = new StringBuilder(EASY_SEARCH_TAG);
        completeMessage.append(msg);
        for (Object additionalMSG:additionalMSGS) {
            completeMessage.append(additionalMSG.toString());
        }
        android.util.Log.v(tag,completeMessage.toString());
    }
}
