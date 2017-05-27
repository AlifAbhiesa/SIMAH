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
public class Kegiatan {
    
    private int id_kegiatan;
    private String nama;
    private Date tanggal;
    private String uraian;

    public Kegiatan(String nama, Date tanggal, String uraian) {
        this.nama = nama;
        this.tanggal = tanggal;
        this.uraian = uraian;
    }

    public Kegiatan(int id_kegiatan, String nama, Date tanggal, String uraian) {
        this.id_kegiatan = id_kegiatan;
        this.nama = nama;
        this.tanggal = tanggal;
        this.uraian = uraian;
    }
    
    

    public Kegiatan() {
    }

    public int getId_kegiatan() {
        return id_kegiatan;
    }

    public void setId_kegiatan(int id_kegiatan) {
        this.id_kegiatan = id_kegiatan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getUraian() {
        return uraian;
    }

    public void setUraian(String uraian) {
        this.uraian = uraian;
    }
    
    
}
