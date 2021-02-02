package tema6;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class Calculator {
	Color myGray=new Color(70,70,70);
	private JFrame frame;
	double firstNum;
	double secNum;
	
	String operation;
	String answer;
	String last;
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
					//window.frame.setSize(550,755);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setResizable(false);
		frame.setSize(550, 755);
		
		frame.setType(Type.UTILITY);
		frame.getContentPane().setSize(new Dimension(550, 755));
		frame.getContentPane().setLayout(null);
		
		JLabel lblOutput = new JLabel("");
		lblOutput.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOutput.setFont(new Font("Ubuntu Mono", Font.BOLD, 96));
		lblOutput.setForeground(Color.WHITE);
		lblOutput.setBackground(Color.WHITE);
		lblOutput.setBounds(22, 116, 478, 169);
		frame.getContentPane().add(lblOutput);
		
		JLabel lblin = new JLabel("");
		
		lblin.setFont(new Font("Ubuntu Mono", Font.PLAIN, 40));
		lblin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblin.setForeground(Color.DARK_GRAY);
		lblin.setBounds(86, 81, 414, 60);
		frame.getContentPane().add(lblin);
		frame.setBounds(100, 100, 550, 755);
		
		JButton button0 = new JButton("0");
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					String number=lblOutput.getText()+button0.getText();
					lblOutput.setText(number);
					lblin.setText(number);
			}
		});
		button0.setForeground(Color.WHITE);
		button0.setFont(new Font("Ubuntu Mono", Font.PLAIN, 53));
		button0.setBorderPainted(false);
		button0.setBackground(Color.BLACK);
		button0.setBounds(14, 619, 71, 71);
		frame.getContentPane().add(button0);
		
		JButton button_Dot = new JButton(".");
		button_Dot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=lblOutput.getText()+button_Dot.getText();
				lblOutput.setText(number);
				lblin.setText(number);
			}
		});
		button_Dot.setForeground(Color.WHITE);
		button_Dot.setFont(new Font("Ubuntu Mono", Font.PLAIN, 53));
		button_Dot.setBackground(Color.BLACK);
		button_Dot.setBorderPainted(false);
		button_Dot.setBounds(110, 619, 71, 71);
		frame.getContentPane().add(button_Dot);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblOutput.setText("");
			}
		});
		btnC.setForeground(Color.WHITE);
		btnC.setFont(new Font("Space Mono", Font.PLAIN, 40));
		btnC.setBorderPainted(false);
		btnC.setBackground(Color.BLACK);
		btnC.setBounds(206, 619, 71, 71);
		frame.getContentPane().add(btnC);
		
		JButton button_1 = new JButton("1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=lblOutput.getText()+button_1.getText();
				lblOutput.setText(number);
				lblin.setText(number);
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Ubuntu Mono", Font.PLAIN, 53));
		button_1.setBorderPainted(false);
		button_1.setBackground(Color.BLACK);
		button_1.setBounds(14, 523, 71, 71);
		frame.getContentPane().add(button_1);
		
		JButton button_4 = new JButton("4");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=lblOutput.getText()+button_4.getText();
				lblOutput.setText(number);
				lblin.setText(number);
			}
		});
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Ubuntu Mono", Font.PLAIN, 53));
		button_4.setBorderPainted(false);
		button_4.setBackground(Color.BLACK);
		button_4.setBounds(14, 427, 71, 71);
		frame.getContentPane().add(button_4);
		
		JButton button_2 = new JButton("2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=lblOutput.getText()+button_2.getText();
				lblOutput.setText(number);
				lblin.setText(number);
				
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Ubuntu Mono", Font.PLAIN, 53));
		button_2.setBorderPainted(false);
		button_2.setBackground(Color.BLACK);
		button_2.setBounds(110, 523, 71, 71);
		frame.getContentPane().add(button_2);
		
		JButton button_5 = new JButton("5");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=lblOutput.getText()+button_5.getText();
				lblOutput.setText(number);
				lblin.setText(number);
			}
		});
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Ubuntu Mono", Font.PLAIN, 53));
		button_5.setBorderPainted(false);
		button_5.setBackground(Color.BLACK);
		button_5.setBounds(110, 427, 71, 71);
		frame.getContentPane().add(button_5);
		
		JButton button_3 = new JButton("3");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=lblOutput.getText()+button_3.getText();
				lblOutput.setText(number);
				lblin.setText(number);
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Ubuntu Mono", Font.PLAIN, 53));
		button_3.setBorderPainted(false);
		button_3.setBackground(Color.BLACK);
		button_3.setBounds(206, 523, 71, 71);
		frame.getContentPane().add(button_3);
		
		JButton button_6 = new JButton("6");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=lblOutput.getText()+button_6.getText();
				lblOutput.setText(number);
				lblin.setText(number);
			}
		});
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Ubuntu Mono", Font.PLAIN, 53));
		button_6.setBorderPainted(false);
		button_6.setBackground(Color.BLACK);
		button_6.setBounds(206, 427, 71, 71);
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("7");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=lblOutput.getText()+button_7.getText();
				lblOutput.setText(number);
				lblin.setText(number);
			}
		});
		button_7.setForeground(Color.WHITE);
		button_7.setFont(new Font("Ubuntu Mono", Font.PLAIN, 53));
		button_7.setBorderPainted(false);
		button_7.setBackground(Color.BLACK);
		button_7.setBounds(14, 330, 71, 71);
		frame.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("8");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=lblOutput.getText()+button_8.getText();
				lblOutput.setText(number);
				lblin.setText(number);
			}
		});
		button_8.setForeground(Color.WHITE);
		button_8.setFont(new Font("Ubuntu Mono", Font.PLAIN, 53));
		button_8.setBorderPainted(false);
		button_8.setBackground(Color.BLACK);
		button_8.setBounds(110, 330, 71, 71);
		frame.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("9");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=lblOutput.getText()+button_9.getText();
				lblOutput.setText(number);
				lblin.setText(number);
			}
		});
		button_9.setForeground(Color.WHITE);
		button_9.setFont(new Font("Ubuntu Mono", Font.PLAIN, 53));
		button_9.setBorderPainted(false);
		button_9.setBackground(Color.BLACK);
		button_9.setBounds(206, 330, 71, 71);
		frame.getContentPane().add(button_9);
		
		JButton button_slash = new JButton("/");
		button_slash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum=Double.parseDouble(lblOutput.getText());
				lblOutput.setText("");
				lblin.setText("/");
				operation="/";
			}
		});
		button_slash.setForeground(Color.DARK_GRAY);
		button_slash.setFont(new Font("Space Mono", Font.PLAIN, 40));
		button_slash.setBorderPainted(false);
		button_slash.setBackground(Color.BLACK);
		
		button_slash.setBounds(308, 330, 71, 71);
		frame.getContentPane().add(button_slash);
		
		JButton btnX = new JButton("x");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum=Double.parseDouble(lblOutput.getText());
				lblOutput.setText("");
				lblin.setText("x");
				operation="*";
			}
		});
		btnX.setForeground(Color.DARK_GRAY);
		btnX.setFont(new Font("Space Mono", Font.PLAIN, 40));
		btnX.setBorderPainted(false);
		btnX.setBackground(Color.BLACK);
		btnX.setBounds(308, 427, 71, 71);
		frame.getContentPane().add(btnX);
		
		JButton button_diff = new JButton("-");
		button_diff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum=Double.parseDouble(lblOutput.getText());
				lblOutput.setText("");
				lblin.setText("-");
				operation="-";
			}
		});
		button_diff.setForeground(Color.DARK_GRAY);
		button_diff.setFont(new Font("Space Mono", Font.PLAIN, 40));
		button_diff.setBorderPainted(false);
		button_diff.setBackground(Color.BLACK);
		button_diff.setBounds(308, 523, 71, 71);
		frame.getContentPane().add(button_diff);
		
		JButton button_add = new JButton("+");
		button_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum=Double.parseDouble(lblOutput.getText());
				lblOutput.setText("");
				lblin.setText("+");
				operation="+";
			}
		});
		button_add.setForeground(Color.DARK_GRAY);
		button_add.setFont(new Font("Space Mono", Font.PLAIN, 40));
		button_add.setBorderPainted(false);
		button_add.setBackground(Color.BLACK);
		button_add.setBounds(308, 619, 71, 71);
		frame.getContentPane().add(button_add);
		
		JButton btnEq = new JButton("=");
		btnEq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)throws ArithmeticException {
				
				String answer = null;
				String error="Can't..";
				secNum=Double.parseDouble(lblOutput.getText());
				if(operation=="+") {
					lblin.setText(""+firstNum+""+operation+""+secNum);
				double	result=firstNum+secNum;
					answer=String.format("%.2f",result);
					lblOutput.setText(answer);
					
				}
				if(operation=="-") {
					lblin.setText(""+firstNum+""+operation+""+secNum);
					double result=firstNum-secNum;
					answer=String.format("%.2f",result);
					lblOutput.setText(answer);
				}
				if(operation=="/") {
					    lblin.setText(""+firstNum+""+operation+""+secNum);
					    try {
					    	double result=firstNum/secNum;
					    	if(result==Double.NEGATIVE_INFINITY||result==Double.POSITIVE_INFINITY) {
					    		throw new ArithmeticException();
					    	}
					    	answer=String.format("%.2f",result);
							lblOutput.setText(answer);
					    }catch(ArithmeticException ex) {
					    	lblOutput.setText(error);
					    	
					    	
					    }
					    
						
						
					}				
				
				if(operation=="*") {
					lblin.setText(""+firstNum+""+operation+""+secNum);
					double result=firstNum*secNum;
					answer=String.format("%.2f",result);
					lblOutput.setText(answer);
				}
			}
				
			
			
		});
		
		btnEq.setForeground(new Color(255, 255, 255));
		btnEq.setFont(new Font("Space Mono", Font.PLAIN, 53));
		btnEq.setBackground(new Color(255, 69, 0));
		btnEq.setBounds(389, 344, 111, 346);
		frame.getContentPane().add(btnEq);
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
