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

import Login.JanelaBase;
import Login.Login;
import bancoDeDados.BancoDeDados;

public class menu_Admin_Logs extends JanelaBase {

	public menu_Admin_Logs(BancoDeDados bd) {
		super(bd);
		initialize();
	}

	@Override
	protected void initialize() {
		super.initialize();

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(86, 215, 324, 168);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton btnUtilizador = new JButton("Log Utilizador");
		btnUtilizador.setBounds(144, 68, 161, 23);
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
		btnLogVariveis.setBounds(144, 163, 161, 23);
		panel_1.add(btnLogVariveis);

		JButton button = new JButton("Log Vari\u00E1veis");
		button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button.setBackground(Color.WHITE);
		button.setBounds(144, 36, 161, 23);
		panel_1.add(button);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(10, 227, 103, 23);
		panel_1.add(btnVoltar);
		
		JButton btnLogAlertas = new JButton("Log Alertas");
		btnLogAlertas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLogAlertas.setBackground(Color.WHITE);
		btnLogAlertas.setBounds(144, 193, 161, 23);
		panel_1.add(btnLogAlertas);
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				menu_Admin mA = new menu_Admin(bd);
				frame.getDefaultCloseOperation();
			}
		});

	}

}
