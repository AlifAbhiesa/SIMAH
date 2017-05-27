/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitas;

/**
 *
 * @author kausar
 */
public class Adart {
    private String kode_adart;
    private String pasal;
    private String uraian;
    private String ayat;
    public Adart(String kode_adart, String pasal, String uraian, String ayat) {
        this.kode_adart = kode_adart;
        this.pasal = pasal;
        this.uraian = uraian;
        this.ayat = ayat;
    }

    public Adart() {
    }

    public String getKode_adart() {
        return kode_adart;
    }

    public String getAyat() {
        return ayat;
    }

    public void setAyat(String ayat) {
        this.ayat = ayat;
    }
    
    public void setKode_adart(String kode_adart) {
        this.kode_adart = kode_adart;
    }

    public String getPasal() {
        return pasal;
    }

    public void setPasal(String pasal) {
        this.pasal = pasal;
    }

    public String getUraian() {
        return uraian;
    }

    public void setUraian(String uraian) {
        this.uraian = uraian;
    }
    
    
    
}
