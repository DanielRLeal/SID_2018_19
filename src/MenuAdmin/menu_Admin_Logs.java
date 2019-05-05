package MenuAdmin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import Login.Login;

public class menu_Admin_Logs {

	private JFrame frame;
	private static menu_Admin mAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu_Admin_Logs window = new menu_Admin_Logs(mAdmin);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public menu_Admin_Logs(menu_Admin mAdmin) {
		initialize();
		this.mAdmin = mAdmin;

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(86, 215, 324, 168);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton btnUtilizador = new JButton("Log Utilizador");
		btnUtilizador.setBounds(144, 67, 161, 23);
		btnUtilizador.setBackground(Color.WHITE);
		btnUtilizador.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_1.add(btnUtilizador);

		JButton btnLogCultura = new JButton("Log Cultura");
		btnLogCultura.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLogCultura.setBackground(Color.WHITE);
		btnLogCultura.setBounds(144, 100, 161, 23);
		panel_1.add(btnLogCultura);

		JButton btnLogMedies = new JButton("Log Medi\u00E7\u00F5es");
		btnLogMedies.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLogMedies.setBackground(Color.WHITE);
		btnLogMedies.setBounds(144, 132, 161, 23);
		panel_1.add(btnLogMedies);

		JButton btnLogVariveis = new JButton("Log Vari\u00E1veis");
		btnLogVariveis.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLogVariveis.setBackground(Color.WHITE);
		btnLogVariveis.setBounds(144, 162, 161, 23);
		panel_1.add(btnLogVariveis);

		JButton button = new JButton("Log Vari\u00E1veis");
		button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button.setBackground(Color.WHITE);
		button.setBounds(144, 33, 161, 23);
		panel_1.add(button);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(10, 227, 103, 23);
		panel_1.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Login login = new Login();
				frame.getDefaultCloseOperation();
			}
		});

	}

}
