package ex7PJ;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import java.beans.PropertyChangeListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.beans.PropertyChangeEvent;
import javax.swing.event.ChangeListener;



import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dbase extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField nume;
	private JTextField varsta;
	private JTextField elemente;
	private int value=1;
	
	
	
	static class DataBase {
		static int numberOFRecords;
		static String url;
		static Statement sql;
		static ResultSet rs;
		static Connection con;

		public static void start() throws SQLException, InstantiationException,
		IllegalAccessException, ClassNotFoundException{
			url = "jdbc:mysql://localhost:3306/tema7";


			con = DriverManager.getConnection (url, "root", "priwet12");
			sql = (Statement) con.createStatement();
			rs = ((java.sql.Statement) sql).executeQuery("select * from persoane");
			for(rs = ((java.sql.Statement) sql).executeQuery("select * from persoane"); rs.next(); ++numberOFRecords);


		}
		public static void update() throws SQLException, InstantiationException,
		IllegalAccessException, ClassNotFoundException {
			con = DriverManager.getConnection(url, "root", "priwet12");
			sql = (Statement) con.createStatement();
			rs = ((java.sql.Statement) sql).executeQuery("select * from persoane");
			for (numberOFRecords = 0; rs.next(); ++numberOFRecords) ;
		}
		public static void add(int id,String nume,int varsta) throws SQLException {
			con = DriverManager.getConnection(url, "root", "priwet12");
			sql = (Statement) con.createStatement();
			rs = ((java.sql.Statement) sql).executeQuery("insert into persoane (idpersoane,nume,varsta)"+"values('id','nume','varsta')");
			for (numberOFRecords = 0; rs.next(); ++numberOFRecords) ;
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					dbase frame = new dbase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public dbase() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		DataBase.start();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton renunta = new JButton("renunta");
		JButton salveaza = new JButton("salveaza");
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton inceput = new JButton("<<");
		inceput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					if(value<=DataBase.numberOFRecords) {
						value=1;
					}
					
					DataBase.update();
					DataBase.rs = ((java.sql.Statement) DataBase.sql).executeQuery("select * from persoane where idpersoane=" + value);
					DataBase.rs.next();
					id.setText(String.valueOf(DataBase.rs.getInt(1)));
					nume.setText(String.valueOf(DataBase.rs.getString(2)));
					varsta.setText(String.valueOf(DataBase.rs.getInt(3)));
					

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		toolBar.add(inceput);
		
		JButton inapoi = new JButton("<");
		inapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					if(value<=DataBase.numberOFRecords&&value!=0) {
						value--;
					}
					
					DataBase.update();
					DataBase.rs = ((java.sql.Statement) DataBase.sql).executeQuery("select * from persoane where idpersoane=" + value);
					DataBase.rs.next();
					id.setText(String.valueOf(DataBase.rs.getInt(1)));
					nume.setText(String.valueOf(DataBase.rs.getString(2)));
					varsta.setText(String.valueOf(DataBase.rs.getInt(3)));
					

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		toolBar.add(inapoi);
		
		JButton urmatorul = new JButton(">");
		
		urmatorul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					if(value<DataBase.numberOFRecords) {
						value++;
					}
					
					DataBase.update();
					DataBase.rs = ((java.sql.Statement) DataBase.sql).executeQuery("select * from persoane where idpersoane=" + value);
					DataBase.rs.next();
					id.setText(String.valueOf(DataBase.rs.getInt(1)));
					nume.setText(String.valueOf(DataBase.rs.getString(2)));
					varsta.setText(String.valueOf(DataBase.rs.getInt(3)));
					

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		
		elemente = new JTextField();
		toolBar.add(elemente);
		elemente.setColumns(10);
		toolBar.add(urmatorul);
		
		JButton sfarsit = new JButton(">>");
		sfarsit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					if(value<=DataBase.numberOFRecords) {
						value=DataBase.numberOFRecords;
					}
					
					DataBase.update();
					DataBase.rs = ((java.sql.Statement) DataBase.sql).executeQuery("select * from persoane where idpersoane=" + value);
					DataBase.rs.next();
					id.setText(String.valueOf(DataBase.rs.getInt(1)));
					nume.setText(String.valueOf(DataBase.rs.getString(2)));
					varsta.setText(String.valueOf(DataBase.rs.getInt(3)));
					

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		toolBar.add(sfarsit);
		
		JButton adauga = new JButton("+");
		adauga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					salveaza.setEnabled(true);
					renunta.setEnabled(true);
					
					id.setEditable(false);
					 DataBase.sql.execute("insert into persoane values("+DataBase.numberOFRecords+1+", '"+nume.getText()+"', "+String.valueOf(varsta.getText())+");");
					DataBase.update();
					
					
					

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		toolBar.add(adauga);
		
		JButton modifica = new JButton("modif");
		
		modifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				salveaza.setEnabled(true);
				renunta.setEnabled(true);
				id.setEditable(true);
				nume.setEditable(true);
				varsta.setEditable(true);
				 try {
					DataBase.sql.execute("update persoane set nume='"+nume.getText()+"',varsta="+String.valueOf(varsta.getText())+" where idpersoane="+value);
					DataBase.update();
				 } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
				
					
			}
		});
		toolBar.add(modifica);
		
		JButton sterge = new JButton("sterge");
		sterge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(0==JOptionPane.showConfirmDialog(null, "esti sigur ca vrei sa stergi?")) {

				 try {
					 DataBase.update();
						DataBase.sql.execute("delete from persoane where idpersoane="+value);
						DataBase.update();
						
					 } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
				}
			}
				
				
			
		});
		toolBar.add(sterge);
		
		JButton cauta = new JButton("cauta");
		cauta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String m = JOptionPane.showInputDialog("numele cautat?");
		        
		        try {
					DataBase.update();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					DataBase.rs=DataBase.sql.executeQuery("select * from persoane where nume like'"+m+"'");
					DataBase.rs.next();
					id.setText(String.valueOf(DataBase.rs.getInt(1)));
					nume.setText(String.valueOf(DataBase.rs.getString(2)));
					varsta.setText(String.valueOf(DataBase.rs.getInt(3)));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        
				
			}
		});
		toolBar.add(cauta);
		
		
		salveaza.setEnabled(false);
		salveaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		toolBar.add(salveaza);
		
				renunta.setEnabled(false);
		renunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		toolBar.add(renunta);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		id = new JTextField();
		id.setEditable(false);
		id.setBounds(165, 63, 96, 19);
		panel.add(id);
		id.setColumns(10);
		
		
		nume = new JTextField();
		nume.setEditable(false);
		nume.setBounds(165, 92, 96, 19);
		panel.add(nume);
		nume.setColumns(10);
		
		varsta = new JTextField();
		varsta.setEditable(false);
		varsta.setBounds(165, 121, 96, 19);
		panel.add(varsta);
		varsta.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setBounds(110, 66, 45, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("nume");
		lblNewLabel_1.setBounds(110, 95, 45, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("varsta");
		lblNewLabel_2.setBounds(110, 124, 45, 13);
		panel.add(lblNewLabel_2);
		
		
	}
}
