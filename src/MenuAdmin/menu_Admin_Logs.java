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
		panel_1.setBounds(86, 215, 324, 163);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton btnUtilizador = new JButton("Log Utilizador");
		btnUtilizador.setBounds(165, 11, 161, 23);
		btnUtilizador.setBackground(Color.WHITE);
		btnUtilizador.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_1.add(btnUtilizador);
		btnUtilizador.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				admin_LogUtilizador adL = new admin_LogUtilizador(bd);
				frame.getDefaultCloseOperation();
			}
		});

		JButton btnLogCultura = new JButton("Log Cultura");
		btnLogCultura.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLogCultura.setBackground(Color.WHITE);
		btnLogCultura.setBounds(1, 45, 161, 23);
		panel_1.add(btnLogCultura);
		btnLogCultura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				admin_LogCulturas adL = new admin_LogCulturas(bd);
				frame.getDefaultCloseOperation();
			}
		});
		JButton btnLogMedies = new JButton("Log Medi\u00E7\u00F5es");
		btnLogMedies.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLogMedies.setBackground(Color.WHITE);
		btnLogMedies.setBounds(165, 45, 161, 23);
		panel_1.add(btnLogMedies);
		btnLogMedies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				admin_LogMedicoes adL = new admin_LogMedicoes(bd);
				frame.getDefaultCloseOperation();
			}
		});

		JButton btnLogVariveis = new JButton("Log Vari\u00E1veis");
		btnLogVariveis.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLogVariveis.setBackground(Color.WHITE);
		btnLogVariveis.setBounds(1, 79, 161, 23);
		panel_1.add(btnLogVariveis);
		btnLogVariveis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				admin_LogVariaveis adL = new admin_LogVariaveis(bd);
				frame.getDefaultCloseOperation();
			}
		});

		JButton btnLogVariveisMedidas = new JButton("Log Variáveis Medidas");
		btnLogVariveisMedidas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLogVariveisMedidas.setBackground(Color.WHITE);
		btnLogVariveisMedidas.setBounds(1, 11, 161, 23);
		panel_1.add(btnLogVariveisMedidas);
		btnLogVariveisMedidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				admin_LogVariaveisMedidas adL = new admin_LogVariaveisMedidas(bd);
				frame.getDefaultCloseOperation();
			}
		});

		JButton btnLogAlertas = new JButton("Log Alertas");
		btnLogAlertas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLogAlertas.setBackground(Color.WHITE);
		btnLogAlertas.setBounds(165, 79, 161, 23);
		panel_1.add(btnLogAlertas);
		btnLogAlertas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				admin_LogAlertas adL = new admin_LogAlertas(bd);
				frame.getDefaultCloseOperation();
			}
		});
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(10, 131, 103, 23);
		panel_1.add(btnVoltar);
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
