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
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.border.MatteBorder;

/**
 * @author Antonio
 *
 */
public class menu_Investigador extends JFrame {

	private JFrame frame;
	private String userGranted;
	public int index;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu_Investigador window1 = new menu_Investigador();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	public menu_Investigador() {
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

		JLabel lblBomDiaAcademia = new JLabel("Controlo de Culturas");
		lblBomDiaAcademia.setFont(new Font("Leelawadee", Font.BOLD, 26));
		lblBomDiaAcademia.setBounds(131, 12, 306, 37);
		frame.getContentPane().add(lblBomDiaAcademia);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/interfaceGraphic/iscte-iul_s.png")));
		lblNewLabel.setBounds(26, -11, 229, 126);
		frame.getContentPane().add(lblNewLabel);

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
		
		JLabel lblBemVindonome = new JLabel("Bem Vindo:  \"nome\"");
		lblBemVindonome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBemVindonome.setBounds(174, 59, 205, 23);
		frame.getContentPane().add(lblBemVindonome);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 215, 494, 86);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnUtilizador = new JButton("Vari\u00E1veis");
		btnUtilizador.setBackground(Color.WHITE);
		btnUtilizador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btnUtilizador);
		
		JButton btnCultura = new JButton("Cultura");
		btnCultura.setBackground(Color.WHITE);
		btnCultura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btnCultura);
		
		JButton btnMedies = new JButton("Medi\u00E7\u00F5es");
		btnMedies.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMedies.setBackground(Color.WHITE);
		panel_1.add(btnMedies);
		
		JButton btnVariveisMedidas = new JButton("Vari\u00E1veis Medidas");
		btnVariveisMedidas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVariveisMedidas.setBackground(Color.WHITE);
		panel_1.add(btnVariveisMedidas);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(0, 299, 271, 102);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton button_4 = new JButton("Medi\u00E7\u00F5es Luminiosidade");
		button_4.setBounds(4, 13, 261, 33);
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_4.setBackground(Color.WHITE);
		panel_2.add(button_4);
		
		JButton button_5 = new JButton("Medi\u00E7\u00F5es Temperatura");
		button_5.setBounds(3, 52, 264, 33);
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_5.setBackground(Color.WHITE);
		panel_2.add(button_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(269, 299, 225, 102);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnSistema = new JButton("Sistema");
		btnSistema.setBounds(61, 33, 120, 33);
		btnSistema.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSistema.setBackground(Color.WHITE);
		panel_3.add(btnSistema);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(192, 192, 192));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.setBounds(10, 427, 97, 25);
		frame.getContentPane().add(btnVoltar);

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