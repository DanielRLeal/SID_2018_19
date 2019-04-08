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
public class adminCriarCultura extends JFrame {

	private JFrame frame;
	private String userGranted;
	public int index;
	public static BancoDeDados bd;
	public static String username;
	private JTextField textField_NomeCultura;
	private JTextField textField_DescricaoCultura;
	private JTextField textField_Utilizador_resp;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminCriarCultura window1 = new adminCriarCultura(bd, username);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	public adminCriarCultura(BancoDeDados bd, String username) {
		this.username = username;
		this.bd = bd;
	}

	public adminCriarCultura() {
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

		JLabel lblInicieASesso = new JLabel("Cria\u00E7\u00E3o de uma cultura");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(186, 157, 196, 16);
		frame.getContentPane().add(lblInicieASesso);

		JPanel panel = new JPanel();
		panel.setBounds(0, 107, 494, 37);
		frame.getContentPane().add(panel);

		JLabel lblMenu = new JLabel("Criar Cultura");
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

		JLabel lblNomeDaCultura = new JLabel("Nome da Cultura");
		lblNomeDaCultura.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNomeDaCultura.setBounds(12, 187, 169, 16);
		frame.getContentPane().add(lblNomeDaCultura);

		textField_NomeCultura = new JTextField();
		textField_NomeCultura.setColumns(10);
		textField_NomeCultura.setBounds(221, 186, 216, 22);
		frame.getContentPane().add(textField_NomeCultura);

		JLabel lblDescrioDaCultura = new JLabel("Descri\u00E7\u00E3o da Cultura");
		lblDescrioDaCultura.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescrioDaCultura.setBounds(12, 239, 197, 16);
		frame.getContentPane().add(lblDescrioDaCultura);

		textField_DescricaoCultura = new JTextField();
		textField_DescricaoCultura.setColumns(10);
		textField_DescricaoCultura.setBounds(221, 238, 216, 22);
		frame.getContentPane().add(textField_DescricaoCultura);

		JLabel lblUtilizadorResponsvel = new JLabel("Utilizador respons\u00E1vel");
		lblUtilizadorResponsvel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUtilizadorResponsvel.setBounds(12, 291, 197, 16);
		frame.getContentPane().add(lblUtilizadorResponsvel);

		textField_Utilizador_resp = new JTextField();
		textField_Utilizador_resp.setColumns(10);
		textField_Utilizador_resp.setBounds(221, 290, 216, 22);
		frame.getContentPane().add(textField_Utilizador_resp);

		JButton buttonCriar = new JButton("Criar");
		buttonCriar.setBounds(340, 339, 97, 25);
		frame.getContentPane().add(buttonCriar);
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					bd.inserirCultura(textField_NomeCultura.getText(), textField_DescricaoCultura.getText(),
							textField_Utilizador_resp.getText());
				} catch (Exception e2) {
//					JOptionPane.showConfirmDialog(null, "Faltam dados");
//					JOptionPane.showConfirmDialog(null, "Cultura já existente");
				}
				JOptionPane.showConfirmDialog(null, "Cultura adiciona com sucesso!");
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