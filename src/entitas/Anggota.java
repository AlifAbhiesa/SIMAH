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
public class Anggota extends Data {
    private String nim;
    private String status;
    private String angkatan;
    private int id_jabatan;
    private int id_sekolah;
    // digunakan untuk menampilkan data dari entitas lain
    private String nama_sekolah;
    private String Jabatan;

    public Anggota() {
    }

    public Anggota(String nim, String angkatan, int id_jabatan, int id_sekolah, String nama, String alamat, String no_hp, String email) {
        super(nama, alamat, no_hp, email);
        this.nim = nim;
        this.angkatan = angkatan;
        this.id_jabatan = id_jabatan;
        this.id_sekolah = id_sekolah;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }

    public int getId_jabatan() {
        return id_jabatan;
    }

    public void setId_jabatan(int id_jabatan) {
        this.id_jabatan = id_jabatan;
    }

    public int getId_sekolah() {
        return id_sekolah;
    }

    public void setId_sekolah(int id_sekolah) {
        this.id_sekolah = id_sekolah;
    }

    public String getNama_sekolah() {
        return nama_sekolah;
    }

    public void setNama_sekolah(String nama_sekolah) {
        this.nama_sekolah = nama_sekolah;
    }

    public String getJabatan() {
        return Jabatan;
    }

    public void setJabatan(String Jabatan) {
        this.Jabatan = Jabatan;
    }

    

}
