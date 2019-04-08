package MenuAdmin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.border.MatteBorder;

import Login.Login;
import bancoDeDados.BancoDeDados;

import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 * @author Antonio
 *
 */
public class adminCriarUtilizador extends JFrame {

	private JFrame frame;
	private String userGranted;
	public int index;
	public static BancoDeDados bd;
	public static String username;
	private JTextField textField_TipoDeUti;
	private JTextField textField_password;
	private JTextField textField_nome;
	private JTextField textField_Email;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminCriarUtilizador window1 = new adminCriarUtilizador(bd, username);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	public adminCriarUtilizador(BancoDeDados bd, String username) {
		this.username = username;
		this.bd = bd;
	}

	public adminCriarUtilizador() {
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

		JLabel lblBomDiaAcademia = new JLabel("Controlo de Culturas");
		lblBomDiaAcademia.setFont(new Font("Leelawadee", Font.BOLD, 26));
		lblBomDiaAcademia.setBounds(131, 12, 306, 37);
		frame.getContentPane().add(lblBomDiaAcademia);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/interfaceGraphic/iscte-iul_s.png")));
		lblNewLabel.setBounds(26, -11, 229, 126);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblInicieASesso = new JLabel("Cria\u00E7\u00E3o de um utilizador");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(186, 157, 196, 16);
		frame.getContentPane().add(lblInicieASesso);

		JPanel panel = new JPanel();
		panel.setBounds(0, 107, 494, 37);
		frame.getContentPane().add(panel);

		JLabel lblMenu = new JLabel("Criar Utilizador");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));

		JLabel lblBemVindonome = new JLabel("Bem Vindo: " + username);
		lblBemVindonome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBemVindonome.setBounds(174, 59, 205, 23);
		frame.getContentPane().add(lblBemVindonome);

		// Listar Utilizadores na lista da página
		// Isto está a dar a null n sei pq
		bd.listarUtilizador();

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.setBackground(new Color(192, 192, 192));
		btnVoltar.setBounds(12, 427, 97, 25);
		frame.getContentPane().add(btnVoltar);

		textField_TipoDeUti = new JTextField();
		textField_TipoDeUti.setBounds(194, 297, 216, 22);
		frame.getContentPane().add(textField_TipoDeUti);
		textField_TipoDeUti.setColumns(10);

		textField_password = new JTextField();
		textField_password.setBounds(194, 245, 216, 22);
		frame.getContentPane().add(textField_password);
		textField_password.setColumns(10);

		textField_nome = new JTextField();
		textField_nome.setBounds(194, 193, 216, 22);
		frame.getContentPane().add(textField_nome);
		textField_nome.setColumns(10);

		JLabel lblNome = new JLabel("Nome ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(26, 194, 56, 16);
		frame.getContentPane().add(lblNome);

		JLabel lblTipoDeUtilizador = new JLabel("Tipo de Utilizador");
		lblTipoDeUtilizador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTipoDeUtilizador.setBounds(26, 298, 157, 16);
		frame.getContentPane().add(lblTipoDeUtilizador);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(26, 246, 90, 16);
		frame.getContentPane().add(lblPassword);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(26, 348, 157, 16);
		frame.getContentPane().add(lblEmail);

		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(194, 347, 216, 22);
		frame.getContentPane().add(textField_Email);

		JButton btnCriar = new JButton("Criar");
		btnCriar.setBounds(313, 382, 97, 25);
		frame.getContentPane().add(btnCriar);
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bd.inserirUtilizador(textField_nome.getText(), textField_password.getText(),
						textField_TipoDeUti.getText(), textField_Email.getText(), true);
				JOptionPane.showConfirmDialog(null, "Faltam dados");

			}
		});
		;

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