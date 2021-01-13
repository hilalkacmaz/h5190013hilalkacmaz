package com.h5190013.hilal_kacmaz_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhotographyModel {
    @SerializedName("Adi")
    @Expose
    private String adi;
    @SerializedName("Aciklama")
    @Expose
    private String aciklama;
    @SerializedName("TurunEnIy\u0131Fotografcilari")
    @Expose
    private String turunEnIyFotografcilari;
    @SerializedName("Kullan\u0131labilenLensler")
    @Expose
    private String kullanLabilenLensler;
    @SerializedName("LogoUrl")
    @Expose
    private String logoUrl;
    @SerializedName("KapakFotoUrl")
    @Expose
    private String kapakFotoUrl;

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getTurunEnIyFotografcilari() {
        return turunEnIyFotografcilari;
    }

    public void setTurunEnIyFotografcilari(String turunEnIyFotografcilari) {
        this.turunEnIyFotografcilari = turunEnIyFotografcilari;
    }

    public String getKullanLabilenLensler() {
        return kullanLabilenLensler;
    }

    public void setKullanLabilenLensler(String kullanLabilenLensler) {
        this.kullanLabilenLensler = kullanLabilenLensler;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getKapakFotoUrl() {
        return kapakFotoUrl;
    }

    public void setKapakFotoUrl(String kapakFotoUrl) {
        this.kapakFotoUrl = kapakFotoUrl;
    }
}
