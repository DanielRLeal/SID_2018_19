package MenuAdmin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import JanelasGerais.ListCulturas;
import JanelasGerais.ListMedicoes;
import JanelasGerais.ListMedicoesLuminosidade;
import JanelasGerais.ListMedicoesTemp;
import JanelasGerais.ListVariaveisMedidas;
import Login.JanelaBase;
import Login.Login;
import bancoDeDados.BancoDeDados;

public class menu_Admin extends JanelaBase {
	public menu_Admin(BancoDeDados bd) {
		super(bd, true);
		initialize();
	}

	@Override
	protected void initialize() {
		super.initialize();

		JPanel panel_1 = panel_1();
		frame.getContentPane().add(panel_1);
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.setBackground(new Color(192, 192, 192));
		btnVoltar.setBounds(12, 416, 97, 25);
		frame.getContentPane().add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Login mA = new Login();
				frame.getDefaultCloseOperation();
			}
		});

	}

	private JPanel panel_1() {
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(86, 215, 324, 168);
		panel_1.setLayout(null);
		JButton btnUtilizador = new JButton("Utilizador");
		btnUtilizador.setBounds(10, 11, 106, 23);
		btnUtilizador.setBackground(Color.WHITE);
		btnUtilizador.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_1.add(btnUtilizador);
		btnUtilizador.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				adminUtilizadores admUti = new adminUtilizadores(bd);
				frame.setVisible(false);
			}
		});
		JButton btnCultura = new JButton("Cultura");
		btnCultura.setBounds(11, 41, 96, 23);
		btnCultura.setBackground(Color.WHITE);
		btnCultura.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_1.add(btnCultura);
		JButton btnMediesTemperatura = new JButton("Medi\u00E7\u00F5es Temperatura");
		btnMediesTemperatura.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnMediesTemperatura.setBackground(Color.WHITE);
		btnMediesTemperatura.setBounds(60, 71, 212, 23);
		panel_1.add(btnMediesTemperatura);
		JButton btnMediesLuminiosidade = new JButton("Medi\u00E7\u00F5es Luminiosidade");
		btnMediesLuminiosidade.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnMediesLuminiosidade.setBackground(Color.WHITE);
		btnMediesLuminiosidade.setBounds(60, 99, 212, 23);
		panel_1.add(btnMediesLuminiosidade);
		btnMediesLuminiosidade.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ListMedicoesLuminosidade aLuminosidade = new ListMedicoesLuminosidade(bd);
				frame.setVisible(false);
			}
		});
		btnMediesTemperatura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ListMedicoesTemp aTemp = new ListMedicoesTemp(bd);
				frame.setVisible(false);
			}
		});
		JButton btnMedies = new JButton("Medi\u00E7\u00F5es");
		btnMedies.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnMedies.setBackground(Color.WHITE);
		btnMedies.setBounds(208, 11, 106, 23);
		panel_1.add(btnMedies);
		btnMedies.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ListMedicoes aMed = new ListMedicoes(bd);
				frame.setVisible(false);
			}
		});
		JButton btnLogs = new JButton("Logs");
		btnLogs.setForeground(Color.WHITE);
		btnLogs.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLogs.setBackground(Color.DARK_GRAY);
		btnLogs.setBounds(60, 134, 212, 23);
		panel_1.add(btnLogs);
		btnLogs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				menu_Admin_Logs login = new menu_Admin_Logs(bd);
				frame.getDefaultCloseOperation();
			}
		});
		JButton btnVariveisMedidas = new JButton("Vari\u00E1veis Medidas");
		btnVariveisMedidas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnVariveisMedidas.setBackground(Color.WHITE);
		btnVariveisMedidas.setBounds(149, 41, 165, 23);
		btnVariveisMedidas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ListVariaveisMedidas aVarMedidas = new ListVariaveisMedidas(bd);
				frame.setVisible(false);
			}
		});
		panel_1.add(btnVariveisMedidas);
		btnCultura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ListCulturas aCult = new ListCulturas(bd);
				frame.setVisible(false);
			}
		});
		return panel_1;
	}
}