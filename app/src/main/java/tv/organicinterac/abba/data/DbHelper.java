package tv.organicinterac.abba.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import tv.organicinterac.abba.data.Contract.PostingEntry;

/**
 * Created by Paul on 6/18/2015.
 */
public class DbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "abba";
    public static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_POSTING_TABLE =
                "CREATE TABLE " + PostingEntry.TABLE_NAME + " (" +
                        PostingEntry._ID + " INTEGER PRIMARY KEY NOT NULL UNIQUE, " +
                        PostingEntry.COLUMN_GLOBAL_ID + " INTEGER NOT NULL, " +
                        PostingEntry.COLUMN_IMAGE_A + " TEXT NOT NULL, " +
                        PostingEntry.COLUMN_IMAGE_B + " TEXT NOT NULL, " +
                        PostingEntry.COLUMN_TEXT_A + " TEXT, " +
                        PostingEntry.COLUMN_TEXT_B + " TEXT, " +
                        PostingEntry.COLUMN_DATE + " TEXT NOT NULL);";
        db.execSQL(SQL_CREATE_POSTING_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PostingEntry.TABLE_NAME);
        onCreate(db);
    }
}
