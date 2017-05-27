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
public class Jabatan {
    
    private int id_jabatan;
    private String nama;
    private String jobdesc;
    private String periode;
    private String status;

    public Jabatan(int id_jabatan, String nama, String jobdesc, String periode, String status) {
        this.id_jabatan = id_jabatan;
        this.nama = nama;
        this.jobdesc = jobdesc;
        this.periode = periode;
        this.status = status;
    }

    public Jabatan(String nama, String jobdesc, String periode, String status) {
        this.nama = nama;
        this.jobdesc = jobdesc;
        this.periode = periode;
        this.status = status;
    }

    public Jabatan() {
    }

    public int getId_jabatan() {
        return id_jabatan;
    }

    public void setId_jabatan(int id_jabatan) {
        this.id_jabatan = id_jabatan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJobdesc() {
        return jobdesc;
    }

    public void setJobdesc(String jobdesc) {
        this.jobdesc = jobdesc;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
}
