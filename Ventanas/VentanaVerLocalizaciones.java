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
public class VentanaVerLocalizaciones extends javax.swing.JFrame implements ActionListener{	
	private JScrollPane scrollVerLocalizaciones;
	private JButton botonVolverVerLocas;
	private JTree treeLocalizaciones;
	public VentanaVerLocalizaciones() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setLayout(null);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_static.gif")).getImage());
			setTitle("Ver localizaciones");
			this.setSize(400, 299);
			setLocationRelativeTo(null);
			getContentPane().setBackground(new java.awt.Color(204,230,230));
			{
				scrollVerLocalizaciones = new JScrollPane();
				this.getContentPane().add(scrollVerLocalizaciones);
				scrollVerLocalizaciones.setBounds(9, 11, 373, 206);
				{
					Vector vPasillos= new Vector();
					vPasillos=GestionBD.obtenerPasillos();
					Object[] aux=new Object[]{};
					Object[] aux1=new Object[]{};
					
					Vector vAux= new Vector();
					Vector resultado = new Vector();
					resultado.add("Pasillos");
					Vector vArmarios=new Vector();
					
					for (int i=0;i<vPasillos.size();i++){
						vArmarios=GestionBD.obtenerArmariosPasillo(""+vPasillos.get(i));
						vAux.clear();
						vAux.add("Armarios");
						
						for(int j=0;j<vArmarios.size();j++){
						
							aux1=new Object[]{""+vArmarios.get(j),GestionBD.obtenerBaldasPasilloArmarioParaTree(""+vPasillos.get(i),""+vArmarios.get(j)).toArray()};
							vAux.add(aux1);
							
						}
						aux=new Object[]{""+vPasillos.get(i),vAux.toArray()};
						resultado.add(aux);
					}
					DefaultMutableTreeNode root = processHierarchy(resultado.toArray());
					treeLocalizaciones = new JTree(root);
					scrollVerLocalizaciones.setViewportView(treeLocalizaciones);
				}
			}
			{
				botonVolverVerLocas = new JButton();
				this.getContentPane().add(botonVolverVerLocas);
				botonVolverVerLocas.setText("Volver");
				botonVolverVerLocas.setBounds(157, 230, 79, 30);
				botonVolverVerLocas.addActionListener(this);
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
		 Object o= e.getSource();
		 if(o==botonVolverVerLocas){
			 this.setVisible(false);
		 }
		 
	 }
}
/*public class SimpleTree extends JFrame {
  public static void main(String[] args) {
    new SimpleTree();
  }
 
  public SimpleTree() {
    super("Creating a Simple JTree");
    WindowUtilities.setNativeLookAndFeel();
    addWindowListener(new ExitListener());
    Container content = getContentPane();
    Object[] hierarchy =
      { "javax.swing",
        "javax.swing.border",
        "javax.swing.colorchooser",
        "javax.swing.event",
        "javax.swing.filechooser",
        new Object[] { "javax.swing.plaf",
                       "javax.swing.plaf.basic",
                       "javax.swing.plaf.metal",
                       "javax.swing.plaf.multi" },
        "javax.swing.table",
        new Object[] { "javax.swing.text",
                       new Object[] { "javax.swing.text.html",
                                      "javax.swing.text.html.parser" },
                       "javax.swing.text.rtf" },
        "javax.swing.tree",
        "javax.swing.undo" };
    DefaultMutableTreeNode root = processHierarchy(hierarchy);
    JTree tree = new JTree(root);
    content.add(new JScrollPane(tree), BorderLayout.CENTER);
    setSize(275, 300);
    setVisible(true);
  }

  /** Small routine that will make node out of the first entry
   *  in the array, then make nodes out of subsequent entries
   *  and make them child nodes of the first one. The process is
   *  repeated recursively for entries that are arrays.
   
    
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
}
*/
