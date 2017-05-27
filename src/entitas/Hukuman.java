/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitas;

import java.sql.Date;

/**
 *
 * @author kausar
 */
public class Hukuman {
    private int id_hukuman;
    private String kode_adart;
    private String nama;
    private String uraian;
    // menampung dari tbl lain
    private String ayat;
    private String pasal;

    public Hukuman(int id_hukuman, String kode_adart, String nama, String uraian) {
        this.id_hukuman = id_hukuman;
        this.kode_adart = kode_adart;
        this.nama = nama;
        this.uraian = uraian;
    }

    public Hukuman(String kode_adart, String nama, String uraian) {
        this.kode_adart = kode_adart;
        this.nama = nama;
        this.uraian = uraian;
    }

    public Hukuman() {
    }

    public int getId_hukuman() {
        return id_hukuman;
    }

    public void setId_hukuman(int id_hukuman) {
        this.id_hukuman = id_hukuman;
    }

    public String getAyat() {
        return ayat;
    }

    public void setAyat(String ayat) {
        this.ayat = ayat;
    }

    public String getPasal() {
        return pasal;
    }

    public void setPasal(String pasal) {
        this.pasal = pasal;
    }

    public String getKode_adart() {
        return kode_adart;
    }

    public void setKode_adart(String kode_adart) {
        this.kode_adart = kode_adart;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUraian() {
        return uraian;
    }

    public void setUraian(String uraian) {
        this.uraian = uraian;
    }
   
    
}
