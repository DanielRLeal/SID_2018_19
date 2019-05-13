package Login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import bancoDeDados.ObjectBD;
import javax.swing.JTextField;

import MenuAdmin.menu_Admin;

public class FuncoesAjuda {
	/**
	 * @wbp.parser.entryPoint
	 */
	public static JFrame CriarJanelaVazia() {
		return CriarJanelaContent(null);
	}

	private static JFrame frame;


	public static JFrame CriarJanelaContent(String UserName) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.getContentPane().setFont(new Font("Monotype Corsiva", Font.BOLD, 16));
		frame.setBounds(250, 250, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);

		JLabel lblTitulo = new JLabel("Controlo de Culturas");
		lblTitulo.setFont(new Font("Leelawadee", Font.BOLD, 26));
		lblTitulo.setBounds(131, 12, 306, 37);
		frame.getContentPane().add(lblTitulo);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Login/iscte-iul_s.png")));
		lblNewLabel.setBounds(26, -11, 229, 126);
		frame.getContentPane().add(lblNewLabel);
		
	
		
		if (UserName != null && !UserName.equals("")) {
			JLabel lblBemVindonome = new JLabel("Bem Vindo: " + UserName);
			lblBemVindonome.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblBemVindonome.setBounds(174, 59, 205, 23);
			frame.getContentPane().add(lblBemVindonome);
		}

		return frame;
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		FuncoesAjuda.frame = frame;
	}

	// O tipo generico serve para definir qual a classe a retornar
	public static JFrame CriarJanelaMenu(String UserName) {
		JFrame frame = CriarJanelaContent(UserName);

		JLabel lblInicieASesso = new JLabel("Escolha uma op\u00E7\u00E3o");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(196, 154, 196, 16);
		frame.getContentPane().add(lblInicieASesso);

		JPanel panel = new JPanel();
		panel.setBounds(0, 107, 494, 37);
		frame.getContentPane().add(panel);

		JLabel lblMenu = new JLabel("Menu");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));

		return frame;
	}

	public static Object[][] listaParaTabela(ArrayList<? extends ObjectBD> listObject, int nrPorpriedades) {
		Object[][] list = new Object[listObject.size()][nrPorpriedades];
		for (int x = 0; x < listObject.size(); x++) {
			for (int y = 0; y < nrPorpriedades; y++) {
				list[x] = listObject.get(x).toObjectArray();
			}
		}

		return list;
	}
}
