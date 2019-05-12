package MenuInvestigador;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import Login.FuncoesAjuda;
import Login.JanelaBase;
import Login.Login;
import bancoDeDados.BancoDeDados;

public class menu_Investigador extends JanelaBase {
	public menu_Investigador(BancoDeDados bd) {
		super(bd, true);
		initialize();
	}

	@Override
	protected void initialize() {
		super.initialize();

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 215, 494, 86);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnVariaveis = new JButton("Vari\u00E1veis");
		btnVariaveis.setBackground(Color.WHITE);
		btnVariaveis.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btnVariaveis);
		btnVariaveis.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				investigadorVariaveis iVar = new investigadorVariaveis(bd);
				frame.setVisible(false);
			}
		});

		JButton btnCultura = new JButton("Cultura");
		btnCultura.setBackground(Color.WHITE);
		btnCultura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btnCultura);
		btnCultura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				investigadorCultura iCul = new investigadorCultura(bd);
			}
		});

		JButton btnMedicoes = new JButton("Medi\u00E7\u00F5es");
		btnMedicoes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMedicoes.setBackground(Color.WHITE);
		panel_1.add(btnMedicoes);
		btnMedicoes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				investigadorMedicoes iMedi = new investigadorMedicoes(bd);
			}
		});

		JButton btnVariveisMedidas = new JButton("Vari\u00E1veis Medidas");
		btnVariveisMedidas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVariveisMedidas.setBackground(Color.WHITE);
		panel_1.add(btnVariveisMedidas);
		btnVariveisMedidas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				investigadorVariaveisMedidas iVM = new investigadorVariaveisMedidas(bd);
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(0, 299, 271, 102);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JButton button_mluminiosidade = new JButton("Medi\u00E7\u00F5es Luminiosidade");
		button_mluminiosidade.setBounds(4, 13, 261, 33);
		button_mluminiosidade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_mluminiosidade.setBackground(Color.WHITE);
		panel_2.add(button_mluminiosidade);
		button_mluminiosidade.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				investigadorMedicoesLuminiosidade mLum = new investigadorMedicoesLuminiosidade(bd);
			}
		});

		JButton button_mtemperatura = new JButton("Medi\u00E7\u00F5es Temperatura");
		button_mtemperatura.setBounds(3, 52, 264, 33);
		button_mtemperatura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_mtemperatura.setBackground(Color.WHITE);
		panel_2.add(button_mtemperatura);
		button_mtemperatura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				investigadorMedicoesTemp mTemp = new investigadorMedicoesTemp(bd);
			}
		});

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
		btnSistema.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				investigadorSistema sis = new investigadorSistema(bd);
			}
		});
	}
}