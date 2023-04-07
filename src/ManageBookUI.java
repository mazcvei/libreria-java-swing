import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ManageBookUI extends javax.swing.JFrame {


	// Variables declaration - do not modify   
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabelComboBox;

	private javax.swing.JTextField textFieldTitulo;
	private javax.swing.JTextField textFieldTematica;
	private javax.swing.JTextField textFieldAutor;
	private javax.swing.JTextField textFieldIsbn;
	private javax.swing.JTextField textFieldNumPags;
	private javax.swing.JTextField textFieldFecha;
	private javax.swing.JTextField textFieldStock;


	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JButton jButtonAnadirLibro;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButtonMostrarDatos;
	private javax.swing.JButton jButtonActualizarDatos;
	private javax.swing.JButton jButtonBorrarDato;
	private JTable tablaLibros;
	private DefaultTableModel model;
	private JComboBox<String> comboBoxISBN;
	private JComboBox<String> comboBoxTematicas;
	private JTable t;
	ArrayList<Libro> libros;
	ArrayList<Tematica> tematicas;
	Libro libroBusqueda;

	DateFormat formatoFecha;
	/**
	 * Creates new form PrincipalUI
	 */
	private MainConnection connection;
	public ManageBookUI(MainConnection connection) {
		this.connection = connection;
		initComponents(this);
		this.setResizable(false);
		libros = new ArrayList<Libro>();
		formatoFecha = new SimpleDateFormat("yyyy-MM-dd");


	}

	private void initComponents(ManageBookUI context) {
		context.setTitle("Gestionar Libros");
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new java.awt.Dimension(800, 600));
		
		jPanel1 = new javax.swing.JPanel();
		jPanel1.setBackground(new java.awt.Color(0, 204, 204));
		jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
		jPanel1.setLayout(null);

		/*
	    	jLabel1 = new javax.swing.JLabel();
	    	jLabel1.setFont(new java.awt.Font("Dialog", 1, 14));
	    	jLabel1.setText("ID Libro");
	    	jLabel1.setBounds(20, 30,160,25);
		 */

		jLabel2 = new javax.swing.JLabel();
		jLabel2.setFont(new java.awt.Font("Dialog", 1, 14));
		jLabel2.setText("Título");
		jLabel2.setBounds(90, 30,160,25); 


		jLabel3 = new javax.swing.JLabel();
		jLabel3.setFont(new java.awt.Font("Dialog", 1, 14));
		jLabel3.setText("Temática");
		jLabel3.setBounds(90, 65,160,25);

		jLabel4 = new javax.swing.JLabel();
		jLabel4.setFont(new java.awt.Font("Dialog", 1, 14));
		jLabel4.setText("Autor");
		jLabel4.setBounds(90, 100,160,25);

		jLabel5 = new javax.swing.JLabel();
		jLabel5.setFont(new java.awt.Font("Dialog", 1, 14));
		jLabel5.setText("ISBN");
		jLabel5.setBounds(90, 135,160,25);


		jLabel6 = new javax.swing.JLabel();
		jLabel6.setFont(new java.awt.Font("Dialog", 1, 14));
		jLabel6.setText("Num. páginas");
		jLabel6.setBounds(90, 170,160,25);

		jLabel7 = new javax.swing.JLabel();
		jLabel7.setFont(new java.awt.Font("Dialog", 1, 14));
		jLabel7.setText("Fecha Publicación");
		jLabel7.setBounds(90, 205,160,25);

		jLabel8 = new javax.swing.JLabel();
		jLabel8.setFont(new java.awt.Font("Dialog", 1, 14));
		jLabel8.setText("Stock");
		jLabel8.setBounds(90, 240,160,25);


		textFieldTitulo = new javax.swing.JTextField();
		textFieldAutor = new javax.swing.JTextField();
		textFieldIsbn = new javax.swing.JTextField();
		textFieldNumPags = new javax.swing.JTextField();
		textFieldFecha = new javax.swing.JTextField();
		textFieldStock = new javax.swing.JTextField();

		textFieldTitulo.setBounds(220, 30, 180, 25);
		jPanel1.add(textFieldTitulo);
		
		comboBoxTematicas = new JComboBox<String>();
		comboBoxTematicas.setBounds(220, 65, 180, 25);
		jPanel1.add(comboBoxTematicas);
		textFieldAutor.setBounds(220, 100, 180, 25);
		jPanel1.add(textFieldAutor);
		textFieldIsbn.setBounds(220, 135, 180, 25);
		jPanel1.add(textFieldIsbn);
		textFieldNumPags.setBounds(220, 170, 180, 25);
		jPanel1.add(textFieldNumPags);
		textFieldFecha.setBounds(220, 205, 180, 25);
		jPanel1.add(textFieldFecha);
		textFieldStock.setBounds(220, 240, 180, 25);
		jPanel1.add(textFieldStock);


		jPanel1.add(jLabel2);
		jPanel1.add(jLabel3);
		jPanel1.add(jLabel4);
		jPanel1.add(jLabel5);
		jPanel1.add(jLabel6);
		jPanel1.add(jLabel7);
		jPanel1.add(jLabel8);

		jButtonAnadirLibro = new javax.swing.JButton();
		jButtonAnadirLibro.setBackground(new java.awt.Color(0, 204, 51));
		jButtonAnadirLibro.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		jButtonAnadirLibro.setForeground(new java.awt.Color(0, 0, 0));
		jButtonAnadirLibro.setText("Añadir libro");
		jButtonAnadirLibro.setBounds(220, 275, 180, 29);
		jButtonAnadirLibro.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				anadirLibroEvent(evt);
			}
		});
		jPanel1.add(jButtonAnadirLibro);
		
		

		comboBoxISBN = new JComboBox<String>();
		comboBoxISBN.setBounds(590, 55, 180, 25);
		jPanel1.add(comboBoxISBN);
		jLabelComboBox = new javax.swing.JLabel();
		jLabelComboBox.setFont(new java.awt.Font("Dialog", 1, 14));
		jLabelComboBox.setText("Buscar por ISBN");
		jLabelComboBox.setBounds(450, 55,160,25); 
		jPanel1.add(jLabelComboBox);
		jButtonMostrarDatos = new javax.swing.JButton();
		jButtonMostrarDatos.setBackground(new java.awt.Color(0, 204, 51));
		jButtonMostrarDatos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		jButtonMostrarDatos.setForeground(new java.awt.Color(0, 0, 0));
		jButtonMostrarDatos.setText("Mostrar datos");
		jButtonMostrarDatos.setBounds(590, 90,180,29);
		jButtonMostrarDatos.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buscarISBNEvent(evt);
			}
		});
		jPanel1.add(jButtonMostrarDatos);


		jButtonActualizarDatos = new javax.swing.JButton();
		jButtonActualizarDatos.setBackground(new java.awt.Color(0, 204, 51));
		jButtonActualizarDatos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		jButtonActualizarDatos.setForeground(new java.awt.Color(0, 0, 0));
		jButtonActualizarDatos.setText("Actualizar");
		jButtonActualizarDatos.setBounds(590, 140,180,29);
		jButtonActualizarDatos.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				actualizarDatosEvent(evt);
			}
		});
		jPanel1.add(jButtonActualizarDatos);

		jButtonBorrarDato = new javax.swing.JButton();
		jButtonBorrarDato.setBackground(new java.awt.Color(0, 204, 51));
		jButtonBorrarDato.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		jButtonBorrarDato.setForeground(new java.awt.Color(0, 0, 0));
		jButtonBorrarDato.setText("Eliminar");
		jButtonBorrarDato.setBounds(590, 190,180,29);
		jButtonBorrarDato.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				borrarDatoEvent(evt);
			}
		});
		jPanel1.add(jButtonBorrarDato);


		
		tematicas = connection.getAllTematicas();
		
		for(Tematica tematica : tematicas) {
			comboBoxTematicas.addItem(tematica.getName());
		}
		
		libros = connection.getAllBooks();
		String[] colNames = {"Titulo","Tematica","Autor","ISBN","Num.Paginas","Fecha Publicacion","Stock"};
		model = new DefaultTableModel(colNames, 0);
		for(Libro l :libros) {
			comboBoxISBN.addItem(l.getIsbn());
			model.addRow(new Object[]{l.getTitulo(), l.getTematica(), l.getAutor(),
					l.getIsbn(), l.getNumPaginas(), l.getFechaPublicacion(), l.getStock()});

		}

		t = new JTable(model);
		t.setBackground(Color.GREEN);
		t.getTableHeader().setReorderingAllowed(false);
		t.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		t.setAutoCreateRowSorter(true);
		t.getColumnModel().getColumn(0).setPreferredWidth(60); 
		t.getColumnModel().getColumn(3).setPreferredWidth(25); 
		t.getColumnModel().getColumn(4).setPreferredWidth(28); 
		t.getColumnModel().getColumn(6).setPreferredWidth(25); 
		t.setEnabled(false);
		JScrollPane sp = new JScrollPane(t);
		sp.setBounds(20, 320, 750, 180);
		jPanel1.add(sp, BorderLayout.CENTER);




		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);

		context.pack();
		context.setLocationRelativeTo(null);
	}// </editor-fold>                        

	private void borrarDatoEvent(java.awt.event.ActionEvent evt) {                                         
		System.out.println("Boton borrar libro");
		if(libroBusqueda!=null) {
			int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar este libro? ISBN: "+libroBusqueda.getIsbn(),
					"Confirmación", JOptionPane.YES_NO_OPTION);

			if (opcion == JOptionPane.YES_OPTION) {
				System.out.println(libros.size());
				System.out.println(libroBusqueda.toString());
				if(connection.eliminarLibro(libroBusqueda)) {
					comboBoxISBN.removeItem(libroBusqueda.getIsbn());
					int columna = 3; // ISBN
					int filaAEliminar = -1;
					for (int fila = 0; fila < t.getRowCount(); fila++) {
						String valorEnFila = t.getValueAt(fila, columna).toString(); // Obtener el valor en la celda
						if (valorEnFila.equals(libroBusqueda.getIsbn())) {
							filaAEliminar = fila;
							break;
						}
					}
					if (filaAEliminar != -1) {
						((DefaultTableModel) t.getModel()).removeRow(filaAEliminar);
					}
					textFieldTitulo.setText("");
					textFieldTematica.setText("");
					textFieldAutor.setText("");
					textFieldIsbn.setText("");
					textFieldNumPags.setText("") ;
					textFieldFecha.setText("");
					textFieldStock.setText("");
					libroBusqueda = null;
				}else {
					JOptionPane.showMessageDialog(this, "¡No se ha encontrado el libro!","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		}else {
			JOptionPane.showMessageDialog(this, "¡Debes seleccionar primero un libro!","Error",JOptionPane.ERROR_MESSAGE);
		}

	}                                        

	private void anadirLibroEvent(java.awt.event.ActionEvent evt) {  

		if(!Validaciones.validarString(textFieldTitulo.getText())){
			JOptionPane.showMessageDialog(this, "¡El formato para el campo Título es incorrecto!","Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(!Validaciones.validarString(textFieldAutor.getText())){
			JOptionPane.showMessageDialog(this, "¡El formato para el campo Autor es incorrecto!","Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(!Validaciones.validarString(textFieldIsbn.getText())){
			JOptionPane.showMessageDialog(this, "¡El formato para el campo ISBN es incorrecto!","Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(!Validaciones.validarInt(textFieldNumPags.getText())){
			JOptionPane.showMessageDialog(this, "¡El formato para el campo Num. Páginas es incorrecto!","Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(!Validaciones.validarInt(textFieldStock.getText())){
			JOptionPane.showMessageDialog(this, "¡El formato para el campo Stock es incorrecto!","Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(!Validaciones.validarFecha(textFieldFecha.getText())){
			JOptionPane.showMessageDialog(this, "¡El formato para el campo Fecha de publicación es incorrecto!","Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		String titulo = textFieldTitulo.getText();
		String tematica = comboBoxTematicas.getSelectedItem().toString();
		String autor = textFieldAutor.getText();
		String isbn = textFieldIsbn.getText();
		int numPags = Integer.parseInt(textFieldNumPags.getText());
		int stock = Integer.parseInt(textFieldStock.getText());
		String fecha = textFieldFecha.getText();


		//Validaciones.validarAnadirLibro();

		Libro nuevoLibro = new Libro(0,titulo,tematica,autor,isbn,numPags,fecha,stock);
		boolean insertado = connection.anadirLibro(nuevoLibro);
		if(insertado) {
			libros.add(nuevoLibro);
			comboBoxISBN.addItem(nuevoLibro.getIsbn());
			model.addRow(new Object[]{nuevoLibro.getTitulo(), nuevoLibro.getTematica(), nuevoLibro.getAutor(),
					nuevoLibro.getIsbn(), nuevoLibro.getNumPaginas(), nuevoLibro.getFechaPublicacion(), nuevoLibro.getStock()});
			JOptionPane.showMessageDialog(this, "¡Libro añadido correctamente!","Libro añadido",JOptionPane.INFORMATION_MESSAGE);
			textFieldTitulo.setText("");
			textFieldTematica.setText("");
			textFieldAutor.setText("");
			textFieldIsbn.setText("");
			textFieldNumPags.setText("") ;
			textFieldFecha.setText("");
			textFieldStock.setText("");
		}else {
			JOptionPane.showMessageDialog(this, "¡Ya existe un libro con el mismo ISBN!","Error",JOptionPane.ERROR_MESSAGE);
		}
	}                                        

	private void buscarISBNEvent(java.awt.event.ActionEvent evt) {   
		libroBusqueda = connection.buscarLibro((String)comboBoxISBN.getSelectedItem());
		if(libroBusqueda!=null) {
			textFieldTitulo.setText(libroBusqueda.getTitulo());
			//textFieldTematica.setText(libroBusqueda.getTematica());
			for (int i = 0; i < comboBoxTematicas.getItemCount(); i++) {
			    String item = (String) comboBoxTematicas.getItemAt(i); // Obtén el elemento en la posición i

			    // Compara el elemento con el valor específico
			    if (item.equals(libroBusqueda.getTematica())) {
			    	comboBoxTematicas.setSelectedItem(item); // Selecciona el elemento en el ComboBox
			        break; // Sal del bucle después de encontrar el valor específico
			    }
			}
			textFieldAutor.setText(libroBusqueda.getAutor());
			textFieldIsbn.setText(libroBusqueda.getIsbn());
			textFieldNumPags.setText(libroBusqueda.getNumPaginas()+"") ;
			textFieldFecha.setText(libroBusqueda.getFechaPublicacion());
			textFieldStock.setText(libroBusqueda.getStock()+"");
			System.out.println("ID: "+libroBusqueda.getId());
		}
	}                                        

	private void actualizarDatosEvent(java.awt.event.ActionEvent evt){
		int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea aplicar los cambios?", "Confirmación", JOptionPane.YES_NO_OPTION);

		if (opcion == JOptionPane.YES_OPTION) {
			if(!Validaciones.validarString(textFieldTitulo.getText())){
				JOptionPane.showMessageDialog(this, "¡El formato para el campo Título es incorrecto!","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
	
			if(!Validaciones.validarString(textFieldAutor.getText())){
				JOptionPane.showMessageDialog(this, "¡El formato para el campo Autor es incorrecto!","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(!Validaciones.validarString(textFieldIsbn.getText())){
				JOptionPane.showMessageDialog(this, "¡El formato para el campo ISBN es incorrecto!","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(!Validaciones.validarInt(textFieldNumPags.getText())){
				JOptionPane.showMessageDialog(this, "¡El formato para el campo Num. Páginas es incorrecto!","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(!Validaciones.validarInt(textFieldStock.getText())){
				JOptionPane.showMessageDialog(this, "¡El formato para el campo Stock es incorrecto!","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(!Validaciones.validarFecha(textFieldFecha.getText())){
				JOptionPane.showMessageDialog(this, "¡El formato para el campo Fecha de publicación es incorrecto!","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(libroBusqueda!=null) {
				DefaultComboBoxModel<String> modelCBox = (DefaultComboBoxModel<String>) comboBoxISBN.getModel();
				libroBusqueda.setTitulo(textFieldTitulo.getText());
				libroBusqueda.setTematica(comboBoxTematicas.getSelectedItem().toString());
				libroBusqueda.setAutor(textFieldAutor.getText());
				libroBusqueda.setIsbn(textFieldIsbn.getText());
				libroBusqueda.setNumPaginas(Integer.parseInt(textFieldNumPags.getText()));
				libroBusqueda.setFechaPublicacion(textFieldFecha.getText());
				libroBusqueda.setStock(Integer.parseInt(textFieldStock.getText()));

				if(connection.actualizarLibro(libroBusqueda)) {
					libros = connection.getAllBooks();
					//Borramos el registro de JTable
					System.out.println("Libros: "+libros.size());
					for(Libro l :libros) {
						if(l.getId()==libroBusqueda.getId()) {
							libros.remove(l);
							break;
						}
					}
					libros.add(libroBusqueda);
					model.setRowCount(0);
					modelCBox.removeAllElements();
					for(Libro l :libros) {
						comboBoxISBN.addItem(l.getIsbn());
						model.addRow(new Object[]{l.getTitulo(), l.getTematica(), l.getAutor(),
								l.getIsbn(), l.getNumPaginas(), l.getFechaPublicacion(), l.getStock()});

					}
				}else {
					JOptionPane.showMessageDialog(this, "¡Ya existe un libro con el mismo ISBN!","Error",JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(this, "¡Debes seleccionar primero un libro!","Error",JOptionPane.ERROR_MESSAGE);

			}
		}

	}

	public static void main(String [] args) {
		MainConnection connection = new MainConnection();
		ManageBookUI m = new ManageBookUI(connection);
		m.setVisible(true);
	}
}
