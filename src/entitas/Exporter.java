/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitas;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.JTable;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author kaus4r
 */
public class Exporter { // export to excel
    private File file;
    private List<JTable> table;
    private List<String> nom_files;

    public Exporter(File file, List<JTable> table, List<String> nom_files)throws Exception{
        this.file = file;
        this.table = table;
        this.nom_files = nom_files;
        
        if (nom_files.size()!=table.size()){
            throw new Exception("Error");
        }
    }
    
    public boolean export(){
        try{
            DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
            WritableWorkbook w = Workbook.createWorkbook(out);
            for (int index = 0; index < table.size(); index++) {
                JTable tabel = table.get(index);
                WritableSheet s = w.createSheet(nom_files.get(index), 0);

                for (int i = 0; i < tabel.getColumnCount(); i++) {
                    Object getname = table.get(index).getColumnName(i);
                    s.addCell(new Label(i,0,String.valueOf(getname)));
                    for (int j = 1; j <= tabel.getRowCount(); j++) {
                        Object obj = tabel.getValueAt(j-1, i);
                        s.addCell(new Label(i,j,String.valueOf(obj)));
                    }
                    
                }
            }
            w.write();
            w.close();
            return true;
        }
        
        catch(IOException | WriteException e){
            return false;
        }
    }

}
