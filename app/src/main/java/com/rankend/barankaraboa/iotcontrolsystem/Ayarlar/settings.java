package com.rankend.barankaraboa.iotcontrolsystem.Ayarlar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rankend.barankaraboa.iotcontrolsystem.R;
import com.rankend.barankaraboa.iotcontrolsystem.VeriTaban.Database;

/**
 * Created by Baran on 26.06.2016.
 */
public class settings extends AppCompatActivity
{

    private String CihazAd,Cihazip,CihazVeriAdresi;
    private EditText ad,ip,veriAdres;
    private Button btnKaydet;
    private Database data;
    private Button btnCihazListe;
    public veriGate gate;

    public String getCihazAd() {
        return CihazAd;
    }

    public String getCihazip()
    {
        return Cihazip;
    }

    public  String getCihazVeriAdresi()
    {
        return CihazVeriAdresi;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayarlar);



        ad =(EditText)findViewById(R.id.editTextCihazAd);
        ip = (EditText) findViewById(R.id.editTextip);
        veriAdres = (EditText)findViewById(R.id.editTextVeriAdres);
        btnCihazListe = (Button) findViewById(R.id.buttonCihazliste);
        btnKaydet = (Button)findViewById(R.id.buttonKaydet);

        CihazAd="yok";
        Cihazip= "yok";
        CihazVeriAdresi="yok";

        btnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CihazAd=ad.getText().toString();
                Cihazip= ip.getText().toString();
                CihazVeriAdresi=veriAdres.getText().toString();

                    gate = new veriGate(CihazAd,Cihazip,CihazVeriAdresi);
                    data.cihazEkle(gate.getAd(),gate.getIp(),gate.getAdres());


            }
        });

        btnCihazListe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  k  = new Intent(settings.this,cihazliste.class);
                startActivity(k);

            }
        });



    }
}
