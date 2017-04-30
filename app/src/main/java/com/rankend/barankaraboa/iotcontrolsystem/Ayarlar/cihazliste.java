package com.rankend.barankaraboa.iotcontrolsystem.Ayarlar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.rankend.barankaraboa.iotcontrolsystem.R;
import com.rankend.barankaraboa.iotcontrolsystem.VeriTaban.Database;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Baran on 26.06.2016.
 */
public class cihazliste extends AppCompatActivity {

    ListView lv;
    Button btnListeGecis;
    ArrayAdapter adapter;
    ArrayList<HashMap<String, String>> cihaz_liste;
    String cihaz_adlar[];
    int cihaz_idler[];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cihazlist);


    }

    public void onResume()
    {   //neden onResume metodu kullandığımı ders içinde anlattım.
        super.onResume();
        Database db = new Database(getApplicationContext()); // Db bağlantısı oluşturuyoruz. İlk seferde database oluşturulur.
        cihaz_liste = db.cihazlar();//kitap listesini alıyoruz
        if(cihaz_liste.size()==0){//kitap listesi boşsa
            Toast.makeText(getApplicationContext(), "Henüz Cihaz Eklenmemis", Toast.LENGTH_LONG).show();
        }else{
            cihaz_adlar = new String[cihaz_liste.size()]; // kitap adlarını tutucamız string arrayi olusturduk.
            cihaz_idler = new int[cihaz_liste.size()]; // kitap id lerini tutucamız string arrayi olusturduk.
            for(int i=0;i<cihaz_liste.size();i++){
                cihaz_adlar[i] = cihaz_liste.get(i).get("cihazadi");
                //kitap_liste.get(0) bize arraylist içindeki ilk hashmap arrayini döner. Yani tablomuzdaki ilk satır değerlerini
                //kitap_liste.get(0).get("kitap_adi") //bize arraylist içindeki ilk hashmap arrayin anahtarı kitap_adi olan value döner

                cihaz_idler[i] = Integer.parseInt(cihaz_liste.get(i).get("id"));
                //Yukarıdaki ile aynı tek farkı değerleri integer a çevirdik.
            }
            //Kitapları Listeliyoruz ve bu listeye listener atıyoruz
            lv = (ListView) findViewById(R.id.listViewCihaz);

            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, cihaz_adlar);
            lv.setAdapter(adapter);

        }

    }



}
