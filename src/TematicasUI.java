import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TematicasUI extends javax.swing.JFrame {

	/**
	 * Creates new form PrincipalUI
	 */
	// Variables declaration - do not modify                     
	private javax.swing.JButton jButtonVolver;
	private javax.swing.JButton jButtonMostrar;
	private javax.swing.JButton jButtonAnadir;
	private javax.swing.JButton jButtonBorrar;
	private javax.swing.JButton jButtonActualizar;
	private javax.swing.JButton jButtonSelectTematica;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel jLabelTematica; 
	private javax.swing.JLabel jLabelComboBox;
	private javax.swing.JTextField textFieldTematica;
	private JComboBox<String> comboBoxTematicas;
	ArrayList<Tematica> tematicas;
	Tematica tematicaSelected;
	private TematicasController connection;

	public TematicasUI(TematicasController connection) {
		this.connection = connection;
		initComponents(this);
		this.setResizable(false);
	}
            
	private void initComponents(TematicasUI context) {
		context.setTitle("Gestionar Tematicas");

		jPanel1 = new javax.swing.JPanel();
		jButtonVolver = new javax.swing.JButton();
	
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new java.awt.Dimension(655, 400));
		jPanel1.setBackground(new java.awt.Color(0, 204, 204));
		jPanel1.setPreferredSize(new java.awt.Dimension(653, 334));
		jPanel1.setLayout(null);

		jLabelComboBox = new javax.swing.JLabel();
		jLabelComboBox.setFont(new java.awt.Font("Dialog", 1, 14));
		jLabelComboBox.setText("Buscar temática");
		jLabelComboBox.setBounds(265,60,160,25); 
		jPanel1.add(jLabelComboBox);
		comboBoxTematicas = new JComboBox<String>();
		comboBoxTematicas.setBounds(230, 90, 180, 25);
		jPanel1.add(comboBoxTematicas);

		tematicas = connection.getAllTematicas();

		for(Tematica tematica : tematicas) {
			comboBoxTematicas.addItem(tematica.getName());
		}

		jButtonSelectTematica = new javax.swing.JButton();
		jButtonSelectTematica.setBackground(new java.awt.Color(0, 204, 51));
		jButtonSelectTematica.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		jButtonSelectTematica.setForeground(new java.awt.Color(0, 0, 0));
		jButtonSelectTematica.setText("Seleccionar");
		jButtonSelectTematica.setBounds(230, 145,180,29);
		jButtonSelectTematica.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				selectTematicaEvent(evt);
			}
		});
		jPanel1.add(jButtonSelectTematica);
		
		jButtonAnadir = new javax.swing.JButton();
		jButtonAnadir.setBackground(new java.awt.Color(0, 204, 51));
		jButtonAnadir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		jButtonAnadir.setForeground(new java.awt.Color(0, 0, 0));
		jButtonAnadir.setText("Añadir");
		jButtonAnadir.setBounds(120, 240,120,29);
		jButtonAnadir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addTematicaEvent(evt);
			}
		});
		jPanel1.add(jButtonAnadir);
		
		jButtonActualizar = new javax.swing.JButton();
		jButtonActualizar.setBackground(new java.awt.Color(0, 204, 51));
		jButtonActualizar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		jButtonActualizar.setForeground(new java.awt.Color(0, 0, 0));
		jButtonActualizar.setText("Actualizar");
		jButtonActualizar.setBounds(260, 240,120,29);
		jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				actualizarTematicaEvent(evt);
			}
		});
		jPanel1.add(jButtonActualizar);
		
		jButtonBorrar = new javax.swing.JButton();
		jButtonBorrar.setBackground(new java.awt.Color(0, 204, 51));
		jButtonBorrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		jButtonBorrar.setForeground(new java.awt.Color(0, 0, 0));
		jButtonBorrar.setText("Borrar");
		jButtonBorrar.setBounds(400, 240,120,29);
		jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				borrarTematicaEvent(evt);
			}
		});
		jPanel1.add(jButtonBorrar);
		
		
		jLabelTematica = new javax.swing.JLabel();
		jLabelTematica.setFont(new java.awt.Font("Dialog", 1, 14));
		jLabelTematica.setText("Temática");
		jLabelTematica.setBounds(150, 200,160,25);
		jPanel1.add(jLabelTematica);
		textFieldTematica = new javax.swing.JTextField();
		textFieldTematica.setBounds(230, 200, 180, 25);
		jPanel1.add(textFieldTematica);

		jButtonVolver = new javax.swing.JButton();
		jButtonVolver.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		jButtonVolver.setText("Volver");
		jButtonVolver.setBounds(250, 300, 140, 30);
		jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				volverEvent(evt);
			}
		});
		jPanel1.add(jButtonVolver);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new java.awt.Dimension(655, 400));

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

		pack();
		this.setLocationRelativeTo(null);
	}// </editor-fold>                        

	private void selectTematicaEvent (java.awt.event.ActionEvent evt) {  
		for(Tematica t : tematicas) {
			if(t.getName().equalsIgnoreCase(comboBoxTematicas.getSelectedItem().toString())) {
				tematicaSelected = t;
				break;
			}
		}
		textFieldTematica.setText(comboBoxTematicas.getSelectedItem().toString());
	}   
	private void addTematicaEvent (java.awt.event.ActionEvent evt) {  
		if(!Validaciones.validarString(textFieldTematica.getText())){
			JOptionPane.showMessageDialog(this, "¡El formato para el campo Temática es incorrecto!","Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		Tematica t = new Tematica(0,textFieldTematica.getText()); 
		boolean insertado = connection.anadirTematica(t);
		if(insertado) {
			tematicas.add(t);
			comboBoxTematicas.addItem(t.getName());
			System.out.println(tematicas.size());
			textFieldTematica.setText(comboBoxTematicas.getSelectedItem().toString());
			JOptionPane.showMessageDialog(this, "¡Temática añadida correctamente!","Temática añadida",JOptionPane.INFORMATION_MESSAGE);
			tematicaSelected = null;
		}else {
			JOptionPane.showMessageDialog(this, "¡Ya existe una temática con el mismo nombre!","Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}   
	

	private void actualizarTematicaEvent (java.awt.event.ActionEvent evt) {  
		int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea aplicar los cambios?", "Confirmación", JOptionPane.YES_NO_OPTION);

		if (opcion == JOptionPane.YES_OPTION) {
			if(!Validaciones.validarString(textFieldTematica.getText())){
				JOptionPane.showMessageDialog(this, "¡El formato para el campo Temática es incorrecto!","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tematicaSelected!=null) {
				DefaultComboBoxModel<String> modelCBox = (DefaultComboBoxModel<String>) comboBoxTematicas.getModel();
				tematicaSelected.setName(textFieldTematica.getText());
				if(connection.actualizarTematica(tematicaSelected)) {
					tematicas.remove(tematicaSelected);
					tematicas.add(tematicaSelected);
					
					textFieldTematica.setText("");
					modelCBox.removeAllElements();
				
					for(Tematica t :tematicas) {
						comboBoxTematicas.addItem(t.getName());
					}
				
					tematicaSelected = null;
				}
				
			}else {
				JOptionPane.showMessageDialog(this, "¡Debes seleccionar primero una temática!","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	
	}   
	
	private void borrarTematicaEvent(java.awt.event.ActionEvent evt) {                                         
	
		if(tematicaSelected!=null) {
			int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar esta temática? Nombre: "+tematicaSelected.getName(),
					"Confirmación", JOptionPane.YES_NO_OPTION);

			if (opcion == JOptionPane.YES_OPTION) {
				if(connection.eliminarTematica(tematicaSelected)) {
					comboBoxTematicas.removeItem(tematicaSelected.getName());
					textFieldTematica.setText("");
					tematicaSelected = null;
				}else {
					JOptionPane.showMessageDialog(this, "¡No se ha encontrado la temática!","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		}else {
			JOptionPane.showMessageDialog(this, "¡Debes seleccionar primero una temática!","Error",JOptionPane.ERROR_MESSAGE);
		}

	} 
	private void volverEvent(java.awt.event.ActionEvent evt) {   
		PrincipalUI pui = new PrincipalUI();
		pui.setVisible(true);
		this.dispose();
	}                                        

	

	public static void main(String [] args) {
		TematicasController connection = new TematicasController();
		TematicasUI m = new TematicasUI(connection);
		m.setVisible(true);
	}
}
