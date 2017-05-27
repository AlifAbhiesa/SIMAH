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
public class Sekolah extends Data{
    
    private int id_sekolah;

    public Sekolah(int id_sekolah, String nama, String alamat, String no_hp, String email) {
        super(nama, alamat, no_hp, email);
        this.id_sekolah = id_sekolah;
    }

    public Sekolah(String nama, String alamat, String no_hp, String email) {
        super(nama, alamat, no_hp, email);
    }

    public Sekolah() {
    }
    
    

    public int getId_sekolah() {
        return id_sekolah;
    }

    public void setId_sekolah(int id_sekolah) {
        this.id_sekolah = id_sekolah;
    }

    

    
}
