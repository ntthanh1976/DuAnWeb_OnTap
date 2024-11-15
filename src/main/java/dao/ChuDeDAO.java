/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DbContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ChuDe;

/**
 *
 * @author ADMIN
 */
public class ChuDeDAO {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public ArrayList<ChuDe> getAll()
    {
        ArrayList<ChuDe> ds = new ArrayList<>();
        String sql = "select * from chude";
        conn =new DbContext().getConnection();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ds.add(new ChuDe(rs.getInt(1),rs.getString(2)));
            }
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());
        }
        return ds;    
    }
    
    public static void main(String[] args) {
         ChuDeDAO cDAO = new ChuDeDAO();
         for(ChuDe c: cDAO.getAll())
         {
             System.out.println(c);
         }
    }
}


