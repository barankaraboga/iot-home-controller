package com.rankend.barankaraboa.iotcontrolsystem.VeriTaban;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.rankend.barankaraboa.iotcontrolsystem.Ayarlar.veriGate;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Baran on 26.06.2016.
 */
public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="veritabani";

    private static final String TABLE_NAME="veri";
    private static final String CIHAZ_IP="ip";
    private static final String CIHAZ_VERI="veriadresi";
    private static final String CIHAZ_AD="cihazadi";
    private static final String CIHAZ_ID="id";


    public Database (Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE ="CREATE TABLE "+ TABLE_NAME + "("+
                CIHAZ_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                CIHAZ_AD +" TEXT," +
                CIHAZ_VERI +" TEXT," +
                CIHAZ_IP +" TEXT" + ")";

        db.execSQL(CREATE_TABLE);
    }

    public void cihazSil(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,CIHAZ_ID + " = ?",new String[] {String.valueOf(id)} );
        db.close();
    }


    public void cihazEkle(String Cihazad,String Cihazip,String Cihazveriadres)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues deger = new ContentValues();
        veriGate gg = new veriGate();
        deger.put(CIHAZ_AD,gg.getAd());
        deger.put(CIHAZ_IP,gg.getIp());
        deger.put(CIHAZ_VERI,gg.getAdres());

        db.insert(TABLE_NAME,null,deger);
        db.close();
    }



    public ArrayList<HashMap<String, String>> cihazlar(){

        //Bu methodda ise tablodaki tüm değerleri alıyoruz
        //ArrayList adı üstünde Array lerin listelendiği bir Array.Burda hashmapleri listeleyeceğiz
        //Herbir satırı değer ve value ile hashmap a atıyoruz. Her bir satır 1 tane hashmap arrayı demek.
        //olusturdugumuz tüm hashmapleri ArrayList e atıp geri dönüyoruz(return).

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList<HashMap<String, String>> cihazlist = new ArrayList<HashMap<String, String>>();
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<String, String>();
                for(int i=0; i<cursor.getColumnCount();i++)
                {
                    map.put(cursor.getColumnName(i), cursor.getString(i));
                }

                cihazlist.add(map);
            } while (cursor.moveToNext());
        }
        db.close();
        return cihazlist;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
