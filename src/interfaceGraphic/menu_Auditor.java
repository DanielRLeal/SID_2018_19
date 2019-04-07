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
public class menu_Auditor extends JFrame {

	private JFrame frame;
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

	public menu_Auditor() {
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
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 107, 494, 37);
		frame.getContentPane().add(panel);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setForeground(new Color(255, 255, 255));
		lblMenu.setBackground(new Color(255, 255, 255));
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));
		
		JLabel lblBemVindonome = new JLabel("Bem Vindo:  \"nome\"");
		lblBemVindonome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBemVindonome.setBounds(174, 59, 205, 23);
		frame.getContentPane().add(lblBemVindonome);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 217, 494, 91);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnUtilizador = new JButton("Utilizador");
		btnUtilizador.setBackground(Color.WHITE);
		btnUtilizador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btnUtilizador);
		
		JButton btnCultura = new JButton("Cultura");
		btnCultura.setBackground(Color.WHITE);
		btnCultura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btnCultura);
		
		JButton btnVariveis = new JButton("Vari\u00E1veis");
		btnVariveis.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVariveis.setBackground(Color.WHITE);
		panel_1.add(btnVariveis);
		
		JButton btnVariveisMedidas = new JButton("Vari\u00E1veis Medidas");
		btnVariveisMedidas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVariveisMedidas.setBackground(Color.WHITE);
		panel_1.add(btnVariveisMedidas);
		
		JButton button = new JButton("Voltar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBackground(Color.BLACK);
		button.setBounds(12, 427, 97, 25);
		frame.getContentPane().add(button);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(0, 344, 494, 45);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton button_1 = new JButton("Utilizador");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_1.setBackground(Color.WHITE);
		panel_2.add(button_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(0, 183, 494, 34);
		frame.getContentPane().add(panel_3);
		
		JLabel lblRegistoDeActividade = new JLabel("Registo de Actividade");
		lblRegistoDeActividade.setFont(new Font("Leelawadee", Font.PLAIN, 24));
		panel_3.add(lblRegistoDeActividade);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(0, 309, 494, 37);
		frame.getContentPane().add(panel_4);
		
		JLabel lblUtilizadoresRegistados = new JLabel("Utilizadores registados");
		lblUtilizadoresRegistados.setFont(new Font("Leelawadee", Font.PLAIN, 24));
		panel_4.add(lblUtilizadoresRegistados);

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