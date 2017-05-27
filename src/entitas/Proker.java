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
public class Proker {
    private String nama_proker;
    private String tujuan;
    private String tempat;
    private int anggaran;
    private int id_proker;
    private Date tanggal;
    private String status;
    private String periode;

    public Proker(String nama_proker, String tujuan, String tempat, int anggaran, int id_proker, Date tanggal, String status, String periode) {
        this.nama_proker = nama_proker;
        this.tujuan = tujuan;
        this.tempat = tempat;
        this.anggaran = anggaran;
        this.id_proker = id_proker;
        this.tanggal = tanggal;
        this.status = status;
        this.periode = periode;
    }

    public Proker(String nama_proker, String tujuan, String tempat, int anggaran, Date tanggal, String status, String periode) {
        this.nama_proker = nama_proker;
        this.tujuan = tujuan;
        this.tempat = tempat;
        this.anggaran = anggaran;
        this.tanggal = tanggal;
        this.status = status;
        this.periode = periode;
        
    }

    public Proker() {
    }

    public String getNama_proker() {
        return nama_proker;
    }

    public void setNama_proker(String nama_proker) {
        this.nama_proker = nama_proker;
    }

    public String getTujuan() {
        return tujuan;
    }

    public String getStatus() {
        return status;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public int getAnggaran() {
        return anggaran;
    }

    public void setAnggaran(int anggaran) {
        this.anggaran = anggaran;
    }

    public int getId_proker() {
        return id_proker;
    }

    public void setId_proker(int id_proker) {
        this.id_proker = id_proker;
    }
    
    
    
}
