package com.biblioteca.componente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import com.biblioteca.utils.MySqlConexion;

public class JComboBoxBD extends JComboBox{

	public JComboBoxBD(String sql) { //sql=select *from tb_editorial
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1
			cn=MySqlConexion.getConexion();
			//2(es el parámetro del constructor)
			
			//3
			pstm=cn.prepareStatement(sql);
			//4(no existe)
			
			//5
			rs=pstm.executeQuery();
			//6 bucle
			while(rs.next()) {
				addItem(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
}
