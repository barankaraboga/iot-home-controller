package com.rankend.barankaraboa.iotcontrolsystem.Ayarlar;

/**
 * Created by Baran on 26.06.2016.
 */
public class veriGate  {

     private String ad,ip,adres;

     public veriGate()
     {

     }

    public  veriGate(String ad,String ip,String adres)
    {
        this.ad = ad;
        this.ip  = ip;
        this.adres = adres;

    }

    public String getAd()
    {
        return  ad;
    }

    public String getIp()
    {
        return  ip;
    }

    public String getAdres()
    {

        return adres;

    }


}
