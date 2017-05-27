/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitas;

import java.util.Date;

/**
 *
 * @author kausar
 */
public class Pelanggaran {
    
    private int id_pelanggaran;
    private int id_hukuman;
    private String nim;
    private Date tanggal;

    //
    private String nama_hukuman;
    private String uraian;
    public Pelanggaran() {
    }

    public Pelanggaran(int id_pelanggaran, int id_hukuman, String nim, Date tanggal) {
        this.id_pelanggaran = id_pelanggaran;
        this.id_hukuman = id_hukuman;
        this.nim = nim;
        this.tanggal = tanggal;
    }

    public Pelanggaran(int id_hukuman, String nim, Date tanggal) {
        this.id_hukuman = id_hukuman;
        this.nim = nim;
        this.tanggal = tanggal;
    }

    
    
    public String getNama_hukuman() {
        return nama_hukuman;
    }

    public void setNama_hukuman(String nama_hukuman) {
        this.nama_hukuman = nama_hukuman;
    }

    public String getUraian() {
        return uraian;
    }

    public void setUraian(String uraian) {
        this.uraian = uraian;
    }
    
    

    public int getId_pelanggaran() {
        return id_pelanggaran;
    }

    public void setId_pelanggaran(int id_pelanggaran) {
        this.id_pelanggaran = id_pelanggaran;
    }

    public int getId_hukuman() {
        return id_hukuman;
    }

    public void setId_hukuman(int id_hukuman) {
        this.id_hukuman = id_hukuman;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
    
    
    
}
