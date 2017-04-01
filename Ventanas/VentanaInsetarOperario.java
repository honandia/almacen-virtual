package Ventanas;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

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
public class VentanaInsetarOperario extends javax.swing.JFrame implements ActionListener{
	private JTextField textoNombreOp;
	private JTextField textoApel1Op;
	private JComboBox comboTipoOp;
	private JLabel labelTipoOp;
	private JPanel panelDatosLogin;
	private JPanel panelDatosPersonales;
	private JButton botonVolverInsertarOp;
	private JLabel labelAp1Op;
	private JButton botonInsertarOp;
	private JLabel labelRepPassOp;
	private JPasswordField textoRepPassOP;
	private JLabel labelPassOP;
	private JPasswordField textoPasswordOp;
	private JLabel labelNombreUserOp;
	private JTextField textoLoginOp;
	private JLabel labelAp2Op;
	private JLabel labelNombreOP;
	private JTextField textoApel2Op;

	public VentanaInsetarOperario() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setSize(771, 242);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/stats_3.gif")).getImage());
			this.setTitle("Crear nuevo operario");
			this.setLayout(null);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.getContentPane().setBackground(new java.awt.Color(204,230,230));
			{
				botonInsertarOp = new JButton();
				this.getContentPane().add(botonInsertarOp);
				botonInsertarOp.setText("Insertar operario");
				botonInsertarOp.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/stats_3.gif")));
				botonInsertarOp.setBounds(206, 171, 166, 30);
				botonInsertarOp.addActionListener(this);
			}
			{
				botonVolverInsertarOp = new JButton();
				this.getContentPane().add(botonVolverInsertarOp);
				botonVolverInsertarOp.setText("Volver");
				botonVolverInsertarOp.setBounds(391, 171, 94, 30);
				botonVolverInsertarOp.addActionListener(this);
			}
			{
				panelDatosPersonales = new JPanel();
				this.getContentPane().add(panelDatosPersonales);
				panelDatosPersonales.setBounds(3, 2, 354, 154);
				panelDatosPersonales.setBackground(new java.awt.Color(204,230,230));
				panelDatosPersonales.setLayout(null);
				panelDatosPersonales.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false), "Datos personales", TitledBorder.LEADING, TitledBorder.TOP));
				{
					labelNombreOP = new JLabel();
					panelDatosPersonales.add(labelNombreOP);
					labelNombreOP.setText("Nombre");
					labelNombreOP.setBounds(39, 28, 101, 20);
					labelNombreOP.setPreferredSize(new java.awt.Dimension(114, 20));
				}
				{
					textoNombreOp = new JTextField();
					panelDatosPersonales.add(textoNombreOp);
					textoNombreOp.setBounds(147, 26, 179, 20);
				}
				{
					labelAp1Op = new JLabel();
					panelDatosPersonales.add(labelAp1Op);
					labelAp1Op.setText("Primer apellido");
					labelAp1Op.setBounds(39, 59, 101, 20);
					labelAp1Op.setPreferredSize(new java.awt.Dimension(114, 20));
				}
				{
					textoApel1Op = new JTextField();
					panelDatosPersonales.add(textoApel1Op);
					textoApel1Op.setBounds(147, 58, 179, 20);
					textoApel1Op.setSize(179, 20);
				}
				{
					labelAp2Op = new JLabel();
					panelDatosPersonales.add(labelAp2Op);
					labelAp2Op.setText("Segundo apellido");
					labelAp2Op.setBounds(39, 91, 101, 20);
					labelAp2Op.setPreferredSize(new java.awt.Dimension(114, 20));
				}
				{
					textoApel2Op = new JTextField();
					panelDatosPersonales.add(textoApel2Op);
					textoApel2Op.setBounds(147, 91, 179, 20);
					textoApel2Op.setSize(179, 20);
				}
			}
			{
				panelDatosLogin = new JPanel();
				this.getContentPane().add(panelDatosLogin);
				panelDatosLogin.setBounds(364, 3, 392, 153);
				panelDatosLogin.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false), "Datos de cuenta de usuario", TitledBorder.LEADING, TitledBorder.TOP));
				panelDatosLogin.setBackground(new java.awt.Color(204,230,230));
				panelDatosLogin.setLayout(null);
				{
					labelNombreUserOp = new JLabel();
					panelDatosLogin.add(labelNombreUserOp);
					labelNombreUserOp.setText("Nombre de usuario");
					labelNombreUserOp.setBounds(17, 28, 182, 18);
				}
				{
					textoLoginOp = new JTextField();
					panelDatosLogin.add(textoLoginOp);
					textoLoginOp.setBounds(212, 26, 168, 20);
				}
				{
					labelPassOP = new JLabel();
					panelDatosLogin.add(labelPassOP);
					labelPassOP.setText("Password");
					labelPassOP.setBounds(17, 54, 182, 16);
				}
				{
					textoPasswordOp = new JPasswordField();
					panelDatosLogin.add(textoPasswordOp);
					textoPasswordOp.setBounds(212, 51, 168, 19);
				}
				{
					labelRepPassOp = new JLabel();
					panelDatosLogin.add(labelRepPassOp);
					labelRepPassOp.setText("Vuelva a introducir el password");
					labelRepPassOp.setBounds(17, 79, 182, 21);
				}
				{
					textoRepPassOP = new JPasswordField();
					panelDatosLogin.add(textoRepPassOP);
					textoRepPassOP.setBounds(212, 76, 168, 20);
				}
				{
					labelTipoOp = new JLabel();
					panelDatosLogin.add(labelTipoOp);
					labelTipoOp.setText("Tipo");
					labelTipoOp.setBounds(17, 105, 182, 18);
				}
				{
					ComboBoxModel comboTipoOpModel = new DefaultComboBoxModel(
						new String[] { "operario", "gerente" });
					comboTipoOp = new JComboBox();
					panelDatosLogin.add(comboTipoOp);
					comboTipoOp.setModel(comboTipoOpModel);
					comboTipoOp.setBounds(212, 102, 168, 23);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void actionPerformed (ActionEvent e){
		Object o= e.getSource();
		if(o==botonInsertarOp){
			if(textoNombreOp.getText().equals("")||
			   textoApel1Op.getText().equals("")||
			   textoApel2Op.getText().equals("")||
			   textoLoginOp.getText().equals("")||
			   textoPasswordOp.getText().equals("")||
			   textoRepPassOP.getText().equals("")){
				JOptionPane.showMessageDialog(this,"No puede haber campos vacios","Error",2);
			}
			else{
				if(!textoPasswordOp.getText().equals(textoRepPassOP.getText())){
					JOptionPane.showMessageDialog(this,"Revise el password, no coinciden los campos","Error",2);
				}
				else{
					String nombre = textoNombreOp.getText()+" "+textoApel1Op.getText()+" "+textoApel2Op.getText();
					String nombreUsuario = textoLoginOp.getText();
					String tipo = ((String)comboTipoOp.getSelectedItem());
					String password = textoPasswordOp.getText();
					String passwordMD5="";
					if (tipo.equals("operario")){
						try {
							passwordMD5 = GestorCifrado.getEncoded(password);
						} catch (NoSuchAlgorithmException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else{
						password= password.concat("Admin");
						try {
							passwordMD5 = GestorCifrado.getEncoded(password);
						} catch (NoSuchAlgorithmException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					GestionBD.insertarUsuario(nombreUsuario,passwordMD5);
					GestionBD.insertarOperario(nombre,tipo);
					JOptionPane.showMessageDialog(this,"El  "+tipo+" "+nombre+"  ha sido creado\nNombre de usuario: "+nombreUsuario+"\nPassword:  "+textoPasswordOp.getText());
					
				}
			}
		}
		else if(o==botonVolverInsertarOp){
			this.setAlwaysOnTop(false);
			this.setVisible(false);
		}
	}
}
