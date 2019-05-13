package Login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import MenuAdmin.menu_Admin;
import MenuInvestigador.menu_Investigador;
import bancoDeDados.BancoDeDados;

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

		JButton btnNewButton = btnNewButton();
		frame.getContentPane().add(btnNewButton);

		frame.getContentPane().add(textField);
		frame.getContentPane().add(passwordField);

		JLabel lblUsurio = lblUsurio();
		frame.getContentPane().add(lblUsurio);

		JLabel lblPassword = lblPassword();
		frame.getContentPane().add(lblPassword);

		JLabel lblInicieASesso = lblInicieASesso();
		frame.getContentPane().add(lblInicieASesso);
	}

	private JLabel lblUsurio() {
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblUsurio.setBounds(68, 263, 77, 16);
		return lblUsurio;
	}

	private JLabel lblPassword() {
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPassword.setBounds(51, 299, 92, 16);
		return lblPassword;
	}

	private JLabel lblInicieASesso() {
		JLabel lblInicieASesso = new JLabel("Inicie a sess\u00E3o para continuar");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(231, 232, 196, 16);
		return lblInicieASesso;
	}

	private JButton btnNewButton() {
		JButton btnNewButton = new JButton("Aceder");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					try {
						credenciais();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Cred�ncias incorrectas!");
					}
					if (bd.utilizadorLogado.CategoriaProfissional.contains("Investigador")) {
						menu_Investigador mInvestigador = new menu_Investigador(bd);
						frame.setVisible(false);
						JOptionPane.showMessageDialog(null, "Bem Vindo, Investigador!");
					} else if (bd.utilizadorLogado.CategoriaProfissional.contains("Administrador")) {
						menu_Admin mAdmin = new menu_Admin(bd);
						frame.setVisible(false);
						JOptionPane.showMessageDialog(null, "Bem Vindo, Admin!");
					} else if (bd.utilizadorLogado.ID == 0) {
						menu_Admin mAdmin = new menu_Admin(bd);
						menu_Investigador mInvestigador = new menu_Investigador(bd);
						frame.setVisible(false);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "O nome n�o pertence a nenhum tipo de utilizador");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(317, 335, 75, 24);
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(140, 261, 252, 23);
		textField.setColumns(10);
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(140, 297, 252, 23);
		return btnNewButton;
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