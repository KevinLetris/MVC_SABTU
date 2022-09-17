/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.controller.controller_siswa;
import com.koneksi.koneksi;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import com.view.tampilan;
/**
 *
 * @author PC LAB 2
 */
public class model_siswa implements controller_siswa {
    String jk;

    @Override
    public void Simpan(tampilan t) throws SQLException {
       if (t.rbLaki.isSelected()){
            jk = "Laki-laki";
        } else {
            jk = "Perempuan";
        }
        try{
Connection con = koneksi.getcon();
String sql = "Insert Into t Values(?,?,?,?)";
PreparedStatement prepare = con.prepareStatement(sql);
prepare.setString(1, t.txtNIS.getText());
prepare.setString(2, t.txtNama.getText());
prepare.setString(3, jk);
prepare.setString(4, (String) t.cbJurusan.getSelectedItem());
prepare.executeUpdate();
JOptionPane.showMessageDialog(null, "simpan");
prepare.close();
} catch (Exception e){
System.out.println(e);
} finally {

        } 
    }

    @Override
    public void Reset(tampilan t) throws SQLException {
        t.txtNIS.setText("");
        t.txtNama.setText("");
        t.rbLaki.setSelected(true);
        t.cbJurusan.setSelectedIndex(0);
    }

    @Override
    public void Ubah(tampilan t) throws SQLException {
         if (t.rbLaki.isSelected()){
            jk = "Laki-laki";
        } else {
            jk = "Perempuan";
        }
        try{
Connection con = koneksi.getcon();
String sql = "UPDATE t SET nama=?, jenis_kelamin=? " + "jurusan=? WHERE NIS=?";
PreparedStatement prepare = con.prepareStatement(sql);
prepare.setString(4, t.txtNIS.getText());
prepare.setString(1, t.txtNama.getText());
prepare.setString(2, jk);
prepare.setString(3, (String) t.cbJurusan.getSelectedItem());
prepare.executeUpdate();
JOptionPane.showMessageDialog(null, "ubah");
prepare.close();
} catch (Exception e){
System.out.println(e);
} finally {

        } 
    }
}
