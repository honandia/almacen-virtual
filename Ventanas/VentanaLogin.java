package Ventanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;

import entidades.Usuario;

import procesos.GestorCifrado;
import procesos.GestionBD;


/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/
public class VentanaLogin extends javax.swing.JFrame implements ActionListener {
	private JButton botonAceptar;
	private JButton botonBorrar;
	private JButton botonSalir;
	public static JComboBox comboPerfil;
	private JLabel labelPassword;
	private JLabel labelUsuario;
	private JPasswordField textoPassword;
	private JTextField textoUsuario;
	private JLabel labelLogin;
	private VentanaPrincipal v;
	private JLabel labelCategoria;
	public static Usuario uLogin;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		GestionBD.IniciarBD();
		VentanaLogin inst = new VentanaLogin();
		inst.setVisible(true);
		
		
	}
	
	public VentanaLogin() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			
			v= new VentanaPrincipal();
			v.setVisible(true);
			v.setEnabled(false);
			this.setAlwaysOnTop(true);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_logout.gif")).getImage());
			this.setSize(400, 253);
			this.setTitle("Almacén Virtual");
			this.setLocationRelativeTo(null);
			this.getContentPane().setLayout(null);
			this.getContentPane().setBackground(new java.awt.Color(204,230,230));
			this.setResizable(false);
			{
				botonAceptar = new JButton();
				this.getContentPane().add(botonAceptar);
				botonAceptar.setText("Aceptar");
				botonAceptar.setBounds(41, 176, 88, 30);
				botonAceptar.addActionListener(this);
			}
			{
				botonBorrar = new JButton();
				this.getContentPane().add(botonBorrar);
				botonBorrar.setText("Borrar");
				botonBorrar.setBounds(153, 176, 88, 30);
				botonBorrar.addActionListener(this);
			}
			{
				textoUsuario = new JTextField();
				this.getContentPane().add(textoUsuario);
				textoUsuario.setBounds(160, 51, 180, 20);
				textoUsuario.setSize(180, 20);
				textoUsuario.setToolTipText("Teclee aqui su nombre de usuario");
			}
			{
				textoPassword = new JPasswordField();
				this.getContentPane().add(textoPassword);
				textoPassword.setBounds(160, 81, 180, 20);
				textoPassword.setSize(180, 20);
				textoPassword.setToolTipText("Teclee aqui su contraseña");
			}
			{
				labelUsuario = new JLabel();
				this.getContentPane().add(labelUsuario);
				labelUsuario.setText("Usuario");
				labelUsuario.setBounds(80, 45, 60, 30);
			}
			{
				labelPassword = new JLabel();
				this.getContentPane().add(labelPassword);
				labelPassword.setBounds(80, 75, 60, 30);
				labelPassword.setText("Password");
			}
			{
				ComboBoxModel comboPerfilModel = new DefaultComboBoxModel(
				new String[] { "Operario", "Gerente" });
				comboPerfil = new JComboBox();
				this.getContentPane().add(comboPerfil);
				comboPerfil.setModel(comboPerfilModel);
				comboPerfil.setBounds(160, 121, 180, 20);
				comboPerfil.setSize(180, 20);
				comboPerfil.setToolTipText("Seleccione su categoría");
			}
			{
				botonSalir = new JButton();
				this.getContentPane().add(botonSalir);
				botonSalir.setText("Salir");
				botonSalir.setBounds(265, 176, 88, 30);
				botonSalir.addActionListener(this);
			}
			{
				labelLogin = new JLabel();
				this.getContentPane().add(labelLogin);
				labelLogin.setText("Identificación de usuarios");
				labelLogin.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/login.JPG")));
				labelLogin.setBounds(3, 12, 387, 30);
				labelLogin.setHorizontalTextPosition(SwingConstants.RIGHT);
				labelLogin.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				labelCategoria = new JLabel();
				this.getContentPane().add(labelCategoria);
				labelCategoria.setText("Categoría");
				labelCategoria.setBounds(80, 116, 60, 30);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	public void actionPerformed(ActionEvent e)
	{
		Object o = (Object) e.getSource();
		
		if (o == botonBorrar)
		{
			textoUsuario.setText("");
			textoPassword.setText("");
		}
		if (o == botonAceptar)
		{
			if ( textoPassword.getText().equals("") ||textoUsuario.getText().equals("")){
				JOptionPane.showMessageDialog(this,"El usuario ,el password o la categoría son incorrectos, vuelva a introducirlos","Error",2);
			}
			else {
			uLogin = new Usuario(0,textoUsuario.getText(),textoPassword.getText());
			try {
		    	if(comboPerfil.getSelectedIndex()==0)
		    		uLogin.setPassword(GestorCifrado.getEncoded(textoPassword.getText()));
		    	else{
		    		if (comboPerfil.getSelectedIndex()==1){
		    			String passAdmin = textoPassword.getText().concat("Admin");
		    			uLogin.setPassword(GestorCifrado.getEncoded(passAdmin));
		    		}
		    	}
		    	} catch (NoSuchAlgorithmException e1) {
				e1.printStackTrace();
			}
			
			Usuario uLeidoBD = GestionBD.obtenerUsuario(uLogin.getNombre(),uLogin.getPassword());
			if (uLeidoBD != null)
			{
				uLogin.setCodUsuario(uLeidoBD.getCodUsuario());
				if (comboPerfil.getSelectedIndex()==0){
					v.mEdicion.setEnabled(false);
					v.itVerOperarios.setEnabled(false);
					v.itVerEstadisticas.setEnabled(false);
				}
				else {
					v.mEdicion.setEnabled(true);
					v.itVerOperarios.setEnabled(true);
					v.itVerEstadisticas.setEnabled(true);
				}
				
					
				v.setEnabled(true);
				this.setAlwaysOnTop(false);
				this.setVisible(false);			
			}
			else{
				JOptionPane.showMessageDialog(this,"El usuario ,el password o la categoría son incorrectos, vuelva a introducirlos","Error",2);
				}
			}
		}
		if (o == botonSalir)
		{
			GestionBD.CerrarBD();
			System.exit(0);
		}
	}
	

}
