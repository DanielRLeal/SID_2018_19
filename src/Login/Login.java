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

/**
 * Class Login.
 */
public class Login extends JanelaBase {
	
	/** The text field. */
	private JTextField textField;
	
	/** The password field. */
	private JPasswordField passwordField;

	/**
	 * Instantiates a new login.
	 */
	public Login() {
		super(null);
		initialize();
	}

	/**
	 * Credenciais.
	 */
	public void credenciais() {
		bd = new BancoDeDados();
		bd.conectar(textField.getText(), passwordField.getText());
	}

	/* (non-Javadoc)
	 * @see Login.JanelaBase#initialize()
	 */
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

	/**
	 * Lbl utilizador.
	 *
	 * @return the j label
	 */
	private JLabel lblUsurio() {
		JLabel lblUsurio = new JLabel("Utilizador");
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblUsurio.setBounds(68, 263, 77, 16);
		return lblUsurio;
	}

	/**
	 * Lbl password.
	 *
	 * @return the j label
	 */
	private JLabel lblPassword() {
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPassword.setBounds(51, 299, 92, 16);
		return lblPassword;
	}

	/**
	 * Lbl inicie A sessao.
	 *
	 * @return the j label
	 */
	private JLabel lblInicieASesso() {
		JLabel lblInicieASesso = new JLabel("Inicie a sessao para continuar");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(231, 232, 196, 16);
		return lblInicieASesso;
	}

	/**
	 * Btn new button.
	 *
	 * @return the j button
	 */
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
						JOptionPane.showMessageDialog(null, "Credencias incorrectas!");
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
					JOptionPane.showMessageDialog(null, "O nome nao pertence a nenhum tipo de utilizador");
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

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
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