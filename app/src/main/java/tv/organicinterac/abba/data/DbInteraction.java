package tv.organicinterac.abba.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import tv.organicinterac.abba.data.Contract.PostingEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 6/18/2015.
 */
public class DbInteraction {
    private Context mContext;
    private DbHelper mDbHelper;
    public DbInteraction(Context context) {
        mContext = context;
        mDbHelper = new DbHelper(context);
    }
    public String[][] getPostings() {
        Cursor postingsCursor = mDbHelper.getReadableDatabase().query(
                PostingEntry.TABLE_NAME,
                new String[]{
                        PostingEntry._ID,
                        PostingEntry.COLUMN_GLOBAL_ID,
                        PostingEntry.COLUMN_IMAGE_A,
                        PostingEntry.COLUMN_IMAGE_B,
                        PostingEntry.COLUMN_TEXT_A,
                        PostingEntry.COLUMN_TEXT_B,
                        PostingEntry.COLUMN_DATE
                },
                null,
                null,
                null,
                null,
                null
        );
        List<String[]> postings = new ArrayList<>();
        postingsCursor.moveToFirst();
        while (! postingsCursor.isAfterLast()) {
            String[] posting = new String[]{
                    Long.toString(postingsCursor.getLong(0)),
                    Long.toString(postingsCursor.getLong(1)),
                    postingsCursor.getString(2),
                    postingsCursor.getString(3),
                    postingsCursor.getString(4),
                    postingsCursor.getString(5),
                    postingsCursor.getString(6)
            };
            postings.add(posting);
        }
        return (String[][])postings.toArray();
    }
    public long addPosting(long globalId, String imageA, String imageB, String textA, String textB,
                           String date) {
        ContentValues values = new ContentValues();
        values.put(PostingEntry.COLUMN_GLOBAL_ID, globalId);
        values.put(PostingEntry.COLUMN_IMAGE_A, imageA);
        values.put(PostingEntry.COLUMN_IMAGE_B, imageB);
        values.put(PostingEntry.COLUMN_TEXT_A, textA);
        values.put(PostingEntry.COLUMN_TEXT_B, textB);
        values.put(PostingEntry.COLUMN_DATE, date);
        return mDbHelper.getWritableDatabase().insert(
                PostingEntry.TABLE_NAME,
                null,
                values
        );
    }
    public long removePosting(long id) {
        return mDbHelper.getWritableDatabase().delete(
                PostingEntry.TABLE_NAME,
                PostingEntry._ID + " = ?",
                new String[]{Long.toString(id)}
        );
    }
}
