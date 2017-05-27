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
public class Prestasi {
    private int id_prestasi;
    private String nim;
    private int id_kegiatan;
    private String uraian;
    
    //untuk menampung variabel yang diambil dari database yang ditampilkan pada tampilan user
    private String nama_kegiatan;
    private String tanggal;
   

    public Prestasi(String nim, int id_kegiatan, String uraian) {
        this.nim = nim;
        this.id_kegiatan = id_kegiatan;
        this.uraian = uraian;
    }

    public Prestasi(int id_prestasi, String nim, int id_kegiatan, String uraian) {
        this.id_prestasi = id_prestasi;
        this.nim = nim;
        this.id_kegiatan = id_kegiatan;
        this.uraian = uraian;
    }

    public Prestasi() {
    }

    public int getId_prestasi() {
        return id_prestasi;
    }

    public void setId_prestasi(int id_prestasi) {
        this.id_prestasi = id_prestasi;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama_kegiatan() {
        return nama_kegiatan;
    }

    public void setNama_kegiatan(String nama_kegiatan) {
        this.nama_kegiatan = nama_kegiatan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getUraian() {
        return uraian;
    }

    public void setUraian(String uraian) {
        this.uraian = uraian;
    }

    public int getId_kegiatan() {
        return id_kegiatan;
    }

    public void setId_kegiatan(int id_kegiatan) {
        this.id_kegiatan = id_kegiatan;
    }
    
    
            
}
