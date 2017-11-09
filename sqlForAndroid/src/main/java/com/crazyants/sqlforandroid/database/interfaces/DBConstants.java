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

public class DBConstants {

    public interface InternalTable {

        String DATABASE_NAME = "internal.db";

        int DB_VERSION = 1;
    }

    public interface ExternalDB {

        String DATABASE_NAME = "internal.db";

        int DB_VERSION = 1;
    }

    private interface BaseColumns {

        String FIELD_ID = "_id";

        String FIELD_TIMESTAMP = "timestamp";
    }

    public interface HistoryColumns extends BaseColumns {

        String TABLE_NAME = "history";

        String FIELD_HISTORY = "command_typed";

        String FIELD_RESULT = "command_result";
    }

    public interface TableListColumns extends BaseColumns {

        String TABLE_NAME = "tableList";

        String FIELD_NAME_OF_TABLE = "table_name";
    }
}
