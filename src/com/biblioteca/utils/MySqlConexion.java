package com.biblioteca.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConexion {

	//m�todo que retorna la conexi�n a la base de datos sis_biblioteca_2022_2
	public static Connection getConexion() {
		Connection cn=null;
		try {
			//carga de la clase Driver que se encuentra en jar
			Class.forName("com.mysql.cj.jdbc.Driver");
			//variables
			String url,user,pass;
			//
			url="jdbc:mysql://localhost/sis_biblioteca_2022_2?serverTimezone=UTC";
			user="root";
			pass="mysql";
			//crear objeto cn
			cn=DriverManager.getConnection(url, user, pass);			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
	
	
	
}
