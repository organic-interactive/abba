package tv.organicinterac.abba.data;

import android.provider.BaseColumns;

/**
 * Created by Paul on 6/18/2015.
 */
public class Contract {
    public static abstract class PostingEntry implements BaseColumns {
        public static final String TABLE_NAME = "posting";
        public static final String COLUMN_TEXT_A = "text_a";
        public static final String COLUMN_TEXT_B = "text_b";
        public static final String COLUMN_IMAGE_A = "image_a";
        public static final String COLUMN_IMAGE_B = "image_b";
        public static final String COLUMN_GLOBAL_ID = "post_id";
        /*Date saved as a System.currentTimeMillis() result converted to a string*/
        public static final String COLUMN_DATE = "date";
    }
}
