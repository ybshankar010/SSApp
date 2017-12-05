package com.crazyants.sqlforandroid.info;

/*
 * @package     com.crazyants.sqlforandroid.info
 * @author      Shankar Y Bhavani
 * @Last Modified time 17/11/17
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
public class HistoryData {

    private int mId;
    private String mCommand;
    private long mTimeStamp;
    private String mExecutionResult;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getCommand() {
        return mCommand;
    }

    public void setCommand(String command) {
        this.mCommand = command;
    }

    public long getTimeStamp() {
        return mTimeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.mTimeStamp = timeStamp;
    }

    public String getExecutionResult() {
        return mExecutionResult;
    }

    public void setExecutionResult(String executionResult) {
        this.mExecutionResult = executionResult;
    }
}
