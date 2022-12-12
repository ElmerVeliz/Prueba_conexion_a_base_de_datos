package com.biblioteca.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.biblioteca.componente.JComboBoxBD;
import com.biblioteca.controlador.MySqlLibroDAO;
import com.biblioteca.entidad.Libro;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;

public class frmLibro extends JFrame implements ActionListener, MouseListener, KeyListener {
	//global de la clase MySqlLibroDAO
	MySqlLibroDAO libroDAO=new MySqlLibroDAO();
	
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtTitulo;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JButton btnNuevo;
	private JButton btnRegistrar;
	private JButton btnCerrar;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private JTable tblLibros;
	private JComboBox cboEditorial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLibro frame = new frmLibro();
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
	public frmLibro() {
		setTitle("LIBRO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1184, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNuevo = new JButton("");
		btnNuevo.addActionListener(this);
		btnNuevo.setToolTipText("Nuevo");
		btnNuevo.setIcon(new ImageIcon(frmLibro.class.getResource("/iconos/copy.png")));
		btnNuevo.setBounds(642, 425, 94, 53);
		contentPane.add(btnNuevo);
		
		JLabel lblNewLabel = new JLabel("MANTENIMIENTO DE LIBRO");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 1147, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00D3DIGO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(657, 75, 94, 14);
		contentPane.add(lblNewLabel_1);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBackground(new Color(250, 250, 210));
		txtCodigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCodigo.setBounds(657, 100, 131, 26);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("T\u00CDTULO");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(657, 138, 94, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtTitulo = new JTextField();
		txtTitulo.setBackground(new Color(255, 255, 224));
		txtTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(657, 163, 500, 26);
		contentPane.add(txtTitulo);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("PRECIO");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(657, 210, 94, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtPrecio = new JTextField();
		txtPrecio.setBackground(new Color(255, 255, 224));
		txtPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(657, 235, 162, 26);
		contentPane.add(txtPrecio);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("CANTIDAD");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setBounds(849, 210, 94, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		txtCantidad = new JTextField();
		txtCantidad.setBackground(new Color(255, 255, 224));
		txtCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(849, 235, 162, 26);
		contentPane.add(txtCantidad);
		
		btnRegistrar = new JButton("");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setToolTipText("Registrar");
		btnRegistrar.setIcon(new ImageIcon(frmLibro.class.getResource("/iconos/save.png")));
		btnRegistrar.setBounds(746, 425, 94, 53);
		contentPane.add(btnRegistrar);
		
		btnActualizar = new JButton("");
		btnActualizar.addActionListener(this);
		btnActualizar.setToolTipText("Actualizar");
		btnActualizar.setIcon(new ImageIcon(frmLibro.class.getResource("/iconos/save_as.gif")));
		btnActualizar.setBounds(849, 425, 94, 53);
		contentPane.add(btnActualizar);
		
		btnEliminar = new JButton("");
		btnEliminar.addActionListener(this);
		btnEliminar.setToolTipText("Eliminar");
		btnEliminar.setIcon(new ImageIcon(frmLibro.class.getResource("/iconos/trash.png")));
		btnEliminar.setBounds(953, 425, 94, 53);
		contentPane.add(btnEliminar);
		
		btnCerrar = new JButton("");
		btnCerrar.addActionListener(this);
		btnCerrar.setToolTipText("Salir");
		btnCerrar.setIcon(new ImageIcon(frmLibro.class.getResource("/iconos/folder.png")));
		btnCerrar.setBounds(1057, 425, 94, 53);
		contentPane.add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 100, 611, 386);
		contentPane.add(scrollPane);
		
		tblLibros = new JTable();
		tblLibros.addKeyListener(this);
		tblLibros.addMouseListener(this);
		tblLibros.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00D3DIGO", "T\u00CDTULO", "PRECIO", "CANTIDAD", "EDITORIAL"
			}
		));
		tblLibros.getColumnModel().getColumn(1).setPreferredWidth(113);
		tblLibros.getColumnModel().getColumn(4).setPreferredWidth(138);
		tblLibros.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblLibros);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("EDITORIAL");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_2.setBounds(657, 283, 94, 14);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		cboEditorial = new JComboBoxBD("select *from tb_editorial");
		cboEditorial.setBounds(657, 308, 354, 35);
		contentPane.add(cboEditorial);
		
		//
		listado();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
	}
	
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		//PASO 1: leer controles
		String titulo,precio,cantidad;
		int codEdi;
		titulo=txtTitulo.getText().trim();
		precio=txtPrecio.getText().trim();
		cantidad=txtCantidad.getText().trim();
		codEdi=cboEditorial.getSelectedIndex()+1;
		//PASO 2: VALIDAR
		if(titulo.equals("")) {
			mensaje("Campo título es obligatorio");
			txtTitulo.requestFocus();
		}
		else if(titulo.matches(".{5,50}")==false) {
			mensaje("Campo título MIN:5 Y MAX: 50 Carácteres");
			txtTitulo.requestFocus();
			//System.out.println("123".matches("\\d"));
		}
		else if(precio.equals("")) {
			mensaje("Campo precio es obligatorio");
			txtPrecio.requestFocus();
		}
		else if(precio.matches("[1-9]\\d+|[1-9]\\d+\\.\\d{1,2}")==false) {
			mensaje("Campo precio entero o real  hasta dos cifras MIN: 10.00");
			txtPrecio.requestFocus();
		}
		else if(cantidad.equals("")) {
			mensaje("Campo cantidad es obligatorio");
			txtCantidad.requestFocus();
		}
		else if(cantidad.matches("[1-9]|[1]\\d|[2][0]")==false) {
			mensaje("Campo cantidad MIN:1 Y MAX:20");
			txtCantidad.requestFocus();
		}
		else {
			//PASO 3: crear objeto de la clase Libro
			Libro lib=new Libro();
			//PASO 4: asignar valor a los atributos del objeto "lib" usando las variables "setear"
			lib.setTitulo(titulo);
			lib.setPrecio(Double.parseDouble(precio));
			lib.setCantidad(Integer.parseInt(cantidad));
			lib.setCodigoEditorial(codEdi);
			//PASO 5: invocar al método save y enviar el objeto "lib"
			int resu=libroDAO.save(lib);
			if(resu>0) {
				mensaje("Libro registrado");
				listado();
			}
			else
				mensaje("Error en el registro");
		}
		
	}
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		//PASO 1: leer controles
		int codigo;
		int codEdi;
		String titulo,precio,cantidad;
		codigo=Integer.parseInt(txtCodigo.getText());
		titulo=txtTitulo.getText().trim();
		precio=txtPrecio.getText().trim();
		cantidad=txtCantidad.getText().trim();
		codEdi=cboEditorial.getSelectedIndex()+1;
		//PASO 2: VALIDAR
		if(titulo.equals("")) {
			mensaje("Campo título es obligatorio");
			txtTitulo.requestFocus();
		}
		else if(titulo.matches(".{5,50}")==false) {
			mensaje("Campo título MIN:5 Y MAX: 50 Carácteres");
			txtTitulo.requestFocus();
			//System.out.println("123".matches("\\d"));
		}
		else if(precio.equals("")) {
			mensaje("Campo precio es obligatorio");
			txtPrecio.requestFocus();
		}
		else if(precio.matches("[1-9]\\d+|[1-9]\\d+\\.\\d{1,2}")==false) {
			mensaje("Campo precio entero o real  hasta dos cifras MIN: 10.00");
			txtPrecio.requestFocus();
		}
		else if(cantidad.equals("")) {
			mensaje("Campo cantidad es obligatorio");
			txtCantidad.requestFocus();
		}
		else if(cantidad.matches("[1-9]|[1]\\d|[2][0]")==false) {
			mensaje("Campo cantidad MIN:1 Y MAX:20");
			txtCantidad.requestFocus();
		}
		else {
			//PASO 3: crear objeto de la clase Libro
			Libro lib=new Libro();
			//PASO 4: asignar valor a los atributos del objeto "lib" usando las variables "setear"
			lib.setCodigo(codigo);
			lib.setTitulo(titulo);
			lib.setPrecio(Double.parseDouble(precio));
			lib.setCantidad(Integer.parseInt(cantidad));
			lib.setCodigoEditorial(codEdi);
			//PASO 5: invocar al método update y enviar el objeto "lib"
			int resu=libroDAO.update(lib);
			if(resu>0) {
				mensaje("Libro actualizado");
				listado();
			}
			else
				mensaje("Error en la actualización");
		}

	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		//mostrar ventana de confirmación
		int boton;
		boton=JOptionPane.showConfirmDialog(null,"Seguro de eliminar?","Sistema",JOptionPane.YES_NO_OPTION);
		if(boton==0) {//si
			//invocar al método deleteByID 
			int resu=libroDAO.deleteByID(Integer.parseInt(txtCodigo.getText()));
			//validar resu
			if(resu>0) {
				mensaje("Libro eliminado");
				listado();
			}
			else
				mensaje("Error en la eliminación");
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		
	}
	void mensaje(String m) {
		JOptionPane.showMessageDialog(null, m);
	}
	//crear método listado
	void listado() {
		//PASO 1: obtener modelo de la tabla tblLibros
		DefaultTableModel model=(DefaultTableModel) tblLibros.getModel();
		//PASO 2: limpiar filas del "model"
		model.setRowCount(0);
		//PASO 3: invocar al método findAll
		ArrayList<Libro> lista=libroDAO.findAll();
		//PASO 4: bucle para realizar recorrido sobre lista
		for(Libro lib:lista) {
			//PASO 5: crear un arreglo lineal de la clase Object con los valores del objeto "lib"
			Object row[]= {lib.getCodigo(),lib.getTitulo(),lib.getPrecio(),lib.getCantidad()};
			//PASO 6: adicionar como fila el objeto "row" dentro de model
			model.addRow(row);
		}
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblLibros) {
			mouseClickedTblLibros(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTblLibros(MouseEvent e) {
		Seleccionar();
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblLibros) {
			keyReleasedTblLibros(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTblLibros(KeyEvent e) {
		Seleccionar();
		
	}
	void Seleccionar()
	{
		//variables
				int posFila;
				String codEdi;
				String cod,tit,pre,can;
				//obtener posición de la fila seleccionada en la tabla
				posFila=tblLibros.getSelectedRow();
				//getValueAt(posFila,posColuma) retorna un valor(Object) según la posición de una fila y columna
				//obtener valores de la fila seleccionada
				cod=tblLibros.getValueAt(posFila, 0).toString();//0 es la columa código
				tit=tblLibros.getValueAt(posFila, 1).toString();//0 es la columa título
				pre=tblLibros.getValueAt(posFila, 2).toString();//0 es la columa precio
				can=tblLibros.getValueAt(posFila, 3).toString();//0 es la columa cantidad
				codEdi=tblLibros.getValueAt(posFila, 4).toString(); // es la columna nombre Editorial
				//mostrar valor de las variables en las cajas
				txtCodigo.setText(cod);
				txtTitulo.setText(tit);
				txtPrecio.setText(pre);
				txtCantidad.setText(can);
		
		
	}
}








