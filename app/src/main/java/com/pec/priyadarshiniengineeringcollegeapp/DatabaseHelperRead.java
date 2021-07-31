package com.pec.priyadarshiniengineeringcollegeapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelperRead extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "time_table.db";
    private static final String TABLE_NAME = "student_time_table";

    private static final String COL_11 = "d11";
    private static final String COL_12 = "d12";
    private static final String COL_13 = "d13";
    private static final String COL_14 = "d14";
    private static final String COL_15 = "d15";
    private static final String COL_16 = "d16";
    private static final String COL_17 = "d17";
    private static final String COL_18 = "d18";

    private static final String COL_21 = "d21";
    private static final String COL_22 = "d22";
    private static final String COL_23 = "d23";
    private static final String COL_24 = "d24";
    private static final String COL_25 = "d25";
    private static final String COL_26 = "d26";
    private static final String COL_27 = "d27";
    private static final String COL_28 = "d28";

    private static final String COL_31 = "d31";
    private static final String COL_32 = "d32";
    private static final String COL_33 = "d33";
    private static final String COL_34 = "d34";
    private static final String COL_35 = "d35";
    private static final String COL_36 = "d36";
    private static final String COL_37 = "d37";
    private static final String COL_38 = "d38";

    private static final String COL_41 = "d41";
    private static final String COL_42 = "d42";
    private static final String COL_43 = "d43";
    private static final String COL_44 = "d44";
    private static final String COL_45 = "d45";
    private static final String COL_46 = "d46";
    private static final String COL_47 = "d47";
    private static final String COL_48 = "d48";

    private static final String COL_51 = "d51";
    private static final String COL_52 = "d52";
    private static final String COL_53 = "d53";
    private static final String COL_54 = "d54";
    private static final String COL_55 = "d55";
    private static final String COL_56 = "d56";
    private static final String COL_57 = "d57";
    private static final String COL_58 = "d58";

    private static final String COL_61 = "d61";
    private static final String COL_62 = "d62";
    private static final String COL_63 = "d63";
    private static final String COL_64 = "d64";
    private static final String COL_65 = "d65";
    private static final String COL_66 = "d66";
    private static final String COL_67 = "d67";
    private static final String COL_68 = "d68";

    public DatabaseHelperRead(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(d11 TEXT, d12 TEXT, d13 TEXT, d14 TEXT, d15 TEXT, d16 TEXT, d17 TEXT, d18 TEXT, d21 TEXT, d22 TEXT, d23 TEXT, d24 TEXT, d25 TEXT, d26 TEXT, d27 TEXT, d28 TEXT, d31 TEXT, d32 TEXT, d33 TEXT, d34 TEXT, d35 TEXT, d36 TEXT, d37 TEXT, d38 TEXT, d41 TEXT, d42 TEXT, d43 TEXT, d44 TEXT, d45 TEXT, d46 TEXT, d47 TEXT, d48 TEXT, d51 TEXT, d52 TEXT, d53 TEXT, d54 TEXT, d55 TEXT, d56 TEXT, d57 TEXT, d58 TEXT, d61 TEXT, d62 TEXT, d63 TEXT, d64 TEXT, d65 TEXT, d66 TEXT, d67 TEXT, d68 TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //read data
    public Cursor displayData()
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor result=sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return result;
    }

}
