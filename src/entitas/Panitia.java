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
public class Panitia {
   
    private String nim;
    private int id_proker;
    private int id_jabatan;
    private int id_panitia;
    //untuk menampung dari entitas lain
    private String jabatan;
    private String proker;
    private String nama_mhs;
    private String tanggal;

    public Panitia(String nim, int id_proker, int id_jabatan, int id_panitia) {
        
        this.nim = nim;
        this.id_proker = id_proker;
        this.id_jabatan = id_jabatan;
        this.id_panitia = id_panitia;
        
    }

    public Panitia(String nim, int id_proker, int id_jabatan) {
        this.nim = nim;
        this.id_proker = id_proker;
        this.id_jabatan = id_jabatan;
    }
    
    

    public Panitia() {
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getNama_mhs() {
        return nama_mhs;
    }

    public void setNama_mhs(String nama_mhs) {
        this.nama_mhs = nama_mhs;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getProker() {
        return proker;
    }

    public void setProker(String proker) {
        this.proker = proker;
    }
    
    
    
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public int getId_proker() {
        return id_proker;
    }

    public void setId_proker(int id_proker) {
        this.id_proker = id_proker;
    }

    public int getId_jabatan() {
        return id_jabatan;
    }

    public void setId_jabatan(int id_jabatan) {
        this.id_jabatan = id_jabatan;
    }

    public int getId_panitia() {
        return id_panitia;
    }

    public void setId_panitia(int id_panitia) {
        this.id_panitia = id_panitia;
    }
  
}
