package interfaceGraphic;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author Antonio
 *
 */
public class Login extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private String userGranted;
	public int index;

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

	/**
	 * Construtor da frame
	 * 
	 * @author Pedro Almeida
	 * 
	 */

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
				if (acessGranted() == true) {
					try {
						frame.dispose();

//								App app = new App();

					} catch (Exception e1) {
						e1.printStackTrace();
					}

				} else {
				}
			}

			/**
			 * verifica acesso
			 * 
			 * @return
			 */
			private boolean acessGranted() {
				String username = String.valueOf(textField.getText());

				String pw = String.valueOf(passwordField.getPassword());

//						for (int i = 0; i < users.size(); i++) {
//							String usernameData = users.get(i).getUsername();
//							String pwData = users.get(i).getPw();
//							if (username.equals(usernameData) && pwData.equals(pw)) {
//
//								index = i;
//								saveInfile(index);
//
//								return true;
//
//							}
//						}

				return false;
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

		JButton btnNewButton_1 = new JButton("Criar conta");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				newAccount window = new newAccount();
				window.getFrame().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(290, 372, 102, 23);
		frame.getContentPane().add(btnNewButton_1);

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

	/**
	 * Funcao auxiliar que ajuda ao funcionamento da associacao de utilizadores a
	 * contas das redes sociais
	 * 
	 * @author Pedro Almeida
	 * 
	 */

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

	/**
	 * @return
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @param frame
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}