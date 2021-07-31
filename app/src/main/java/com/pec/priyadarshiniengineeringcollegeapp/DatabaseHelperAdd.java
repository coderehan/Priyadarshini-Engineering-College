package com.pec.priyadarshiniengineeringcollegeapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelperAdd extends SQLiteOpenHelper {

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

    public DatabaseHelperAdd(@Nullable Context context) {
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

    //add data
    public boolean insertData(String d11, String d12, String d13, String d14, String d15, String d16, String d17, String d18,
                              String d21, String d22, String d23, String d24, String d25, String d26, String d27, String d28,
                              String d31, String d32, String d33, String d34, String d35, String d36, String d37, String d38,
                              String d41, String d42, String d43, String d44, String d45, String d46, String d47, String d48,
                              String d51, String d52, String d53, String d54, String d55, String d56, String d57, String d58,
                              String d61, String d62, String d63, String d64, String d65, String d66, String d67, String d68)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();

        contentValues.put(COL_11, d11);
        contentValues.put(COL_12, d12);
        contentValues.put(COL_13, d13);
        contentValues.put(COL_14, d14);
        contentValues.put(COL_15, d15);
        contentValues.put(COL_16, d16);
        contentValues.put(COL_17, d17);
        contentValues.put(COL_18, d18);

        contentValues.put(COL_21, d21);
        contentValues.put(COL_22, d22);
        contentValues.put(COL_23, d23);
        contentValues.put(COL_24, d24);
        contentValues.put(COL_25, d25);
        contentValues.put(COL_26, d26);
        contentValues.put(COL_27, d27);
        contentValues.put(COL_28, d28);

        contentValues.put(COL_31, d31);
        contentValues.put(COL_32, d32);
        contentValues.put(COL_33, d33);
        contentValues.put(COL_34, d34);
        contentValues.put(COL_35, d35);
        contentValues.put(COL_36, d36);
        contentValues.put(COL_37, d37);
        contentValues.put(COL_38, d38);

        contentValues.put(COL_41, d41);
        contentValues.put(COL_42, d42);
        contentValues.put(COL_43, d43);
        contentValues.put(COL_44, d44);
        contentValues.put(COL_45, d45);
        contentValues.put(COL_46, d46);
        contentValues.put(COL_47, d47);
        contentValues.put(COL_48, d48);

        contentValues.put(COL_51, d51);
        contentValues.put(COL_52, d52);
        contentValues.put(COL_53, d53);
        contentValues.put(COL_54, d54);
        contentValues.put(COL_55, d55);
        contentValues.put(COL_56, d56);
        contentValues.put(COL_57, d57);
        contentValues.put(COL_58, d58);

        contentValues.put(COL_61, d61);
        contentValues.put(COL_62, d62);
        contentValues.put(COL_63, d63);
        contentValues.put(COL_64, d64);
        contentValues.put(COL_65, d65);
        contentValues.put(COL_66, d66);
        contentValues.put(COL_67, d67);
        contentValues.put(COL_68, d68);

        long result=sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        if(result==-1)
        {
            return false;
        }

        else
        {
            return true;
        }
    }
}
