package com.biblioteca.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.biblioteca.entidad.Libro;
import com.biblioteca.interfaces.LibroDAO;
import com.biblioteca.utils.MySqlConexion;

public class MySqlLibroDAO implements LibroDAO {

	/*
		save retorna int indicando si es "1" registro ok, "-1" error en el registro 
	*/
	@Override
	public int save(Libro bean) {
		int salida=-1;
		Connection conn=null;
		PreparedStatement pstm=null;
		try {
			//PASO 1: obtener conexión a base de datos
			conn=MySqlConexion.getConexion();
			//PASO 2: instrucción SQL INSERT INTO (asignar parámetros "?")
			String sql="insert into tb_libro values(null,?,?,?,?)";
			//PASO 3: crear objeto pstm y enviar la instrucción sql
			pstm=conn.prepareStatement(sql);
			//PASO 4: parámetros de la instrucción sql que maneja el objeto pstm
			pstm.setString(1, bean.getTitulo());
			pstm.setDouble(2, bean.getPrecio());
			pstm.setInt(3, bean.getCantidad());
			pstm.setInt(4, bean.getCodigoEditorial());
			//PASO 5: ejecutar instrucción sql que maneja el objeto pstm
			salida=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	@Override
	public int update(Libro bean) {
		int salida=-1;
		Connection conn=null;
		PreparedStatement pstm=null;
		try {
			//1
			conn=MySqlConexion.getConexion();
			//2
			String sql="update tb_libro set tit_lib=?,pre_lib=?,can_lib=?,cod_edi=? where cod_lib=?";
			//3
			pstm=conn.prepareStatement(sql);
			//4
			pstm.setString(1,bean.getTitulo());
			pstm.setDouble(2, bean.getPrecio());	
			pstm.setInt(3, bean.getCantidad());
			pstm.setInt(4, bean.getCodigoEditorial());
			pstm.setInt(5, bean.getCodigo());
			//5
			salida=pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(conn!=null)conn.close(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	@Override
	public int deleteByID(int cod) {
		int salida=-1;
		Connection conn=null;
		PreparedStatement pstm=null;
		try {
			//1
			conn=MySqlConexion.getConexion();
			//2
			String sql="delete from tb_libro where cod_lib=?";
			//3
			pstm=conn.prepareStatement(sql);
			//4
			pstm.setInt(1, cod);
			//5
			salida=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	@Override
	public ArrayList<Libro> findAll() {
		ArrayList<Libro> data=new ArrayList<Libro>();
		Connection cn=null;
		PreparedStatement pstm=null;
		//objeto para guardar el resultado de un select
		ResultSet rs=null;
		try {
			//PASO 1: conexión b.d.
			cn=MySqlConexion.getConexion();
			//PASO 2: sentencia sql
			String sql="select cod_usu, nom_usu, ape_usu from tb_usuario "+
					"where login_usu = ? and clave_usu = ?";
			//PASO 3:crear pstm y enviar la sentencia sql
			pstm=cn.prepareStatement(sql);
			//PASO 4: parámetros "? que tiene la sentencia"
			
			//PASO 5:ejecutar sentencia y guardar el valor en el objeto "rs"
			//executeQuery() es un método para ejecutar un select
			rs=pstm.executeQuery();
			//PASO 6: bucle para realizar recorrido sobre "rs"
			while(rs.next()) {
				//PASO 7: crear objeto de la clase Libro
				Libro lib=new Libro();
				//PASO 8: asignar valor a los atributos del objeto "lib" según la fila actual 
				lib.setCodigo(rs.getInt(1));//1 es la columna código
				lib.setTitulo(rs.getString(2));//2 es columna título
				lib.setPrecio(rs.getDouble(3));//3 es la columna precio
				lib.setCantidad(rs.getInt(4));//4 es la columna cantidad
				//PASO 9: enviar objeto "lib" dentro del arreglo "data"
				data.add(lib);
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
		return data;
	}

}






