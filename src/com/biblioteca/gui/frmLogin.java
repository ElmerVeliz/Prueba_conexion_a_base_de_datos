package com.biblioteca.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.biblioteca.controlador.MySqlusuarioDAO;
import com.biblioteca.entidad.Usuario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtClave;
	private JButton btnIniciar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 368, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(49, 108, 62, 22);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Clave");
		lblNewLabel_1.setBounds(49, 182, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(46, 141, 227, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(49, 207, 217, 20);
		contentPane.add(txtClave);
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//leer cajas
				String vLogin, vClave;
				vLogin=txtLogin.getText();
				vClave=txtClave.getText();
				//invocar al método
				Usuario bean = new MySqlusuarioDAO().iniciarSesion(vLogin, vClave);
				//validar bean
				if(bean==null) {
					mensaje("Usuario y/o clave incorrectos");
				}
				else {
					frmPrincipal frm = new frmPrincipal();
					frm.setVisible(true);
					dispose();
					
				}
		
			}

			private void mensaje(String string) {
				// TODO Auto-generated method stub
				
			}
		});
		btnIniciar.setBounds(49, 250, 217, 23);
		contentPane.add(btnIniciar);
	}
}
