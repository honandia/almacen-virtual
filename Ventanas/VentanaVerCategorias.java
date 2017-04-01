package Ventanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import javax.swing.WindowConstants;
import javax.swing.tree.DefaultMutableTreeNode;

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
public class VentanaVerCategorias extends javax.swing.JFrame implements ActionListener{
	private JScrollPane scrollVerCategorias;
	private JTree treeCategorias;
	private JButton botonVolverVerCats;

	public VentanaVerCategorias() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setLayout(null);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_category.gif")).getImage());
			setTitle("Ver categorías");
			this.setSize(400, 299);
			setLocationRelativeTo(null);
			getContentPane().setBackground(new java.awt.Color(204,230,230));
			{
				scrollVerCategorias = new JScrollPane();
				this.getContentPane().add(scrollVerCategorias);
				scrollVerCategorias.setBounds(12, 11, 365, 205);
				{
					Vector vCategorias= new Vector();
					vCategorias=GestionBD.obtenerCategoriasTree();
					Object[] aux=new Object[]{};		
					Vector vAux= new Vector();
					Vector resultado = new Vector();
					resultado.add("Todos");
					Vector vSubCategorias=new Vector();
					for (int i=0;i<vCategorias.size();i++){
						vSubCategorias=GestionBD.obtenerSubCategorias(""+vCategorias.get(i));
						vAux.clear();
						vAux=vSubCategorias;
						if(vAux.size()==1){
							aux=new Object[]{""+vCategorias.get(i)};
						}
						else{
							aux=new Object[]{""+vCategorias.get(i),vAux.toArray()};
						}
						resultado.add(aux);
					}
					DefaultMutableTreeNode root = processHierarchy(resultado.toArray());
					treeCategorias = new JTree(root);
					scrollVerCategorias.setViewportView(treeCategorias);
				}
			}
			{
				botonVolverVerCats = new JButton();
				this.getContentPane().add(botonVolverVerCats);
				botonVolverVerCats.setText("Volver");
				botonVolverVerCats.setBounds(153, 228, 86, 30);
				botonVolverVerCats.addActionListener(this);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 private DefaultMutableTreeNode processHierarchy(Object[] hierarchy) {
		    DefaultMutableTreeNode node =
		      new DefaultMutableTreeNode(hierarchy[0]);
		    DefaultMutableTreeNode child;
		    for(int i=1; i<hierarchy.length; i++) {
		      Object nodeSpecifier = hierarchy[i];
		      if (nodeSpecifier instanceof Object[])  // Ie node with children
		        child = processHierarchy((Object[])nodeSpecifier);
		      else
		        child = new DefaultMutableTreeNode(nodeSpecifier); // Ie Leaf
		      node.add(child);
		    }
		    return(node);
	}
	public void actionPerformed(ActionEvent e){
		Object o =e.getSource();
		if(o==botonVolverVerCats){
			this.setVisible(false);
		}
	}
}
