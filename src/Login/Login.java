package Login;

import java.awt.Color;
import bancoDeDados.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Popup;

import MenuAdmin.menu_Admin;
import MenuAuditor.menu_Auditor;
import MenuInvestigador.menu_Investigador;

public class Login extends JanelaBase {
	private JTextField textField;
	private JPasswordField passwordField;
	
	public Login() {
		super(null);
		initialize();
	}
	
	public void credenciais() {
		bd = new BancoDeDados();
		bd.conectar(textField.getText(), passwordField.getText());
	}

	@Override
	protected void initialize() {
		super.initialize();

		JButton btnNewButton = new JButton("Aceder");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					try {
						credenciais();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Credências incorrectas!");
					}
					
					if (bd.utilizadorLogado.CategoriaProfissional.equals("Investigador")) {
						menu_Investigador mInvestigador = new menu_Investigador(bd);
						frame.setVisible(false);
						JOptionPane.showMessageDialog(null, "Bem Vindo, Investigador!");
					}
					/*if (bd.utilizadorLogado.CategoriaProfissional.equals("Auditor")) {
						menu_Auditor mAduditor = new menu_Auditor(bd);
						frame.setVisible(false);
						JOptionPane.showMessageDialog(null, "Bem Vindo, Auditor!");
					}*/
					else if (bd.utilizadorLogado.CategoriaProfissional.equals("Administrador")) {
						menu_Admin mAdmin = new menu_Admin(bd);
						frame.setVisible(false);
						JOptionPane.showMessageDialog(null, "Bem Vindo, Admin!");
					}
					//utilizador root
					else if (bd.utilizadorLogado.ID == 0) {
						menu_Admin mAdmin = new menu_Admin(bd);
						//menu_Auditor mAduditor = new menu_Auditor(bd);
						//menu_Investigador mInvestigador = new menu_Investigador(bd);
						frame.setVisible(false);
						JOptionPane.showMessageDialog(null, "Bem Vindo, Rooteiro!");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"O nome não pertence a nenhum tipo de utilizador");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(317, 335, 75, 24);
		frame.getContentPane().add(btnNewButton);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(140, 261, 252, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(140, 297, 252, 23);
		frame.getContentPane().add(passwordField);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblUsurio.setBounds(68, 263, 77, 16);
		frame.getContentPane().add(lblUsurio);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPassword.setBounds(51, 299, 92, 16);
		frame.getContentPane().add(lblPassword);

		JLabel lblInicieASesso = new JLabel("Inicie a sess\u00E3o para continuar");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(231, 232, 196, 16);
		frame.getContentPane().add(lblInicieASesso);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window1 = new Login();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}