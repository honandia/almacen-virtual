package Ventanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import javax.swing.WindowConstants;

import procesos.GestionBD;
import procesos.GestorCifrado;


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
public class ventanaCambiarPassword extends javax.swing.JFrame implements ActionListener{
	private JPasswordField textoPasswordNuevo;
	private JLabel labelPassNuevoRepe;
	private JLabel labelPassNuevo;
	private JLabel labelPassActual;
	private JButton botonVolverPassNuevo;
	private JButton botonBorrarPassNuevo;
	private JButton botonAceptarPassNuevo;
	private JPasswordField textoPasswordViejo;
	private JPasswordField textoPasswordNuevoRepe;

	public ventanaCambiarPassword() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setSize(435, 240);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/hashing.gif")).getImage());
			this.setTitle("Cambiar password");
			this.setLayout(null);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.getContentPane().setBackground(new java.awt.Color(204,230,230));
			{
				textoPasswordNuevo = new JPasswordField();
				this.getContentPane().add(textoPasswordNuevo);
				textoPasswordNuevo.setBounds(256, 62, 163, 25);
			}
			{
				textoPasswordNuevoRepe = new JPasswordField();
				this.getContentPane().add(textoPasswordNuevoRepe);
				textoPasswordNuevoRepe.setBounds(256, 99, 163, 23);
			}
			{
				textoPasswordViejo = new JPasswordField();
				this.getContentPane().add(textoPasswordViejo);
				textoPasswordViejo.setBounds(256, 26, 163, 22);
			}
			{
				botonAceptarPassNuevo = new JButton();
				this.getContentPane().add(botonAceptarPassNuevo);
				botonAceptarPassNuevo.setIcon(new ImageIcon(getClass()
						.getClassLoader().getResource(
							"Ventanas/hashing.gif")));
			
				botonAceptarPassNuevo.setText("Cambiar password");
				botonAceptarPassNuevo.setBounds(35, 163, 165, 30);
				botonAceptarPassNuevo.addActionListener(this);
			}
			{
				botonBorrarPassNuevo = new JButton();
				this.getContentPane().add(botonBorrarPassNuevo);
				botonBorrarPassNuevo.setText("Borrar");
				botonBorrarPassNuevo.setBounds(212, 163, 85, 30);
				botonBorrarPassNuevo.addActionListener(this);
			}
			{
				botonVolverPassNuevo = new JButton();
				this.getContentPane().add(botonVolverPassNuevo);
				botonVolverPassNuevo.setText("Volver");
				botonVolverPassNuevo.setBounds(311, 163, 82, 30);
				botonVolverPassNuevo.addActionListener(this);
			}
			{
				labelPassActual = new JLabel();
				this.getContentPane().add(labelPassActual);
				labelPassActual.setText("Introduzca su password actual");
				labelPassActual.setBounds(14, 28, 225, 17);
			}
			{
				labelPassNuevo = new JLabel();
				this.getContentPane().add(labelPassNuevo);
				labelPassNuevo.setText("Introduzca el nuevo password");
				labelPassNuevo.setBounds(14, 67, 225, 17);
			}
			{
				labelPassNuevoRepe = new JLabel();
				this.getContentPane().add(labelPassNuevoRepe);
				labelPassNuevoRepe.setText("Vuelva a introducir el nuevo password");
				labelPassNuevoRepe.setBounds(14, 100, 225, 17);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void actionPerformed (ActionEvent e){
		Object o = e.getSource();
		if(o==botonAceptarPassNuevo){
			if(textoPasswordViejo.getText().equals("")||
			textoPasswordNuevo.getText().equals("")||
			textoPasswordNuevoRepe.getText().equals("")){
				JOptionPane.showMessageDialog(this,"No puede haber campos vacios","Error",2);
			}
			else{
			String passViejoCifrado="";
			try {
				if (VentanaLogin.comboPerfil.getSelectedIndex()==0){//si es operario
					passViejoCifrado = GestorCifrado.getEncoded(textoPasswordViejo.getText());
				}
				else{//sino es administrdor
					passViejoCifrado = GestorCifrado.getEncoded(textoPasswordViejo.getText().concat("Admin"));
				}
			} catch (NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String passLogin = VentanaLogin.uLogin.getPassword();
			if(passViejoCifrado.equals(passLogin) ){
				if(textoPasswordNuevo.getText().equals(textoPasswordNuevoRepe.getText())){
					
					try {
						if(VentanaLogin.comboPerfil.getSelectedIndex()==0){
							GestionBD.actualizarPassword(VentanaLogin.uLogin.getCodUsuario(),GestorCifrado.getEncoded(textoPasswordNuevo.getText()));
						}
						else{
							GestionBD.actualizarPassword(VentanaLogin.uLogin.getCodUsuario(),GestorCifrado.getEncoded(textoPasswordNuevo.getText().concat("Admin")));	
						}
						
					} 
					catch (NoSuchAlgorithmException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(this,"Su password ha sido cambiado, ahora su password es: "+textoPasswordNuevo.getText());
				}
				else{
					JOptionPane.showMessageDialog(this,"Revise el password nuevo, no coinciden los campos","Error",2);
				}
			}
			else{
				JOptionPane.showMessageDialog(this,"No se puede cambiar el password, el password actual introducido no coincide con el del usuario que inicio la sesión","Error",2);
			}
		}
		}
		else if(o==botonBorrarPassNuevo){
			textoPasswordViejo.setText("");
			textoPasswordNuevo.setText("");
			textoPasswordNuevoRepe.setText("");
		}
		else if(o==botonVolverPassNuevo){
			this.setVisible(false);
		}
		
	}

}
