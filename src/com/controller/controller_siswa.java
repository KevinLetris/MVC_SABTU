/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;


import com.view.tampilan;
import java.sql.SQLException;

/**
 *
 * @author PC LAB 2
 */
public interface controller_siswa {
    public void Simpan(tampilan t) throws SQLException;
    public void Reset (tampilan t) throws SQLException;
    public void Ubah (tampilan t) throws SQLException;
}
