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

public class Login extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private String userGranted;
	public int index;
	public BancoDeDados bd ;

	public void credenciais() {
		bd = new BancoDeDados();
		bd.conectar(textField.getName(), passwordField.getName());
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

	public Login() {
		initialize();
	}

	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.getContentPane().setFont(new Font("Monotype Corsiva", Font.BOLD, 16));
		frame.setBounds(250, 250, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);

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
					if (textField.getText().toLowerCase().contains("Investigador".toLowerCase())) {
						menu_Investigador mInvestigador = new menu_Investigador(bd, textField.getText());
						frame.setVisible(false);
						JOptionPane.showMessageDialog(null, "Bem Vindo, Investigador!");
					}
					if (textField.getText().toLowerCase().contains("Auditor".toLowerCase())) {
						menu_Auditor mAduditor = new menu_Auditor(bd, textField.getText());
						frame.setVisible(false);
						JOptionPane.showMessageDialog(null, "Bem Vindo, Auditor!");
					}
					if (textField.getText().toLowerCase().contains("Admin".toLowerCase())) {
						menu_Admin mAdmin = new menu_Admin(bd, textField.getText());
						frame.setVisible(false);
						JOptionPane.showMessageDialog(null, "Bem Vindo, Admin!");
					}
					if (textField.getText().toLowerCase().contains("root".toLowerCase())) {
						menu_Admin mAdmin = new menu_Admin(bd, textField.getText());
						menu_Auditor mAduditor = new menu_Auditor(bd, textField.getText());
						menu_Investigador mInvestigador = new menu_Investigador(bd, textField.getText());
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

		JLabel lblBomDiaAcademia = new JLabel("Controlo de Culturas");
		lblBomDiaAcademia.setFont(new Font("Leelawadee", Font.BOLD, 26));
		lblBomDiaAcademia.setBounds(152, 109, 306, 37);
		frame.getContentPane().add(lblBomDiaAcademia);

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

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/interfaceGraphic/iscte-iul_s.png")));
		lblNewLabel.setBounds(51, 65, 229, 126);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblInicieASesso = new JLabel("Inicie a sess\u00E3o para continuar");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(231, 232, 196, 16);
		frame.getContentPane().add(lblInicieASesso);

	}

//	public void saveInfile(int i) {
//		try {
//			File fac = new File(filepath + "acessos");
//			if (!fac.exists()) {
//				fac.createNewFile();
//			}
//			FileWriter write = new FileWriter(fac);
//			write.write(Integer.toString(i));
//			write.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}