package MenuInvestigador;

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

import Login.JanelaBase;
import Login.Login;
import bancoDeDados.BancoDeDados;

import javax.swing.JList;

public class investigadorMedicoesLuminiosidade extends JanelaBase {
	public investigadorMedicoesLuminiosidade(BancoDeDados bd) {
		super(bd);
		initialize();
	}

	@Override
	protected void initialize() {
		super.initialize();

		JLabel lblInicieASesso = new JLabel("Consulta de Medi\u00E7\u00F5es de Luminiosidade");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(142, 157, 229, 16);
		frame.getContentPane().add(lblInicieASesso);

		JPanel panel = new JPanel();
		panel.setBounds(0, 107, 494, 37);
		frame.getContentPane().add(panel);

		JLabel lblMenu = new JLabel("Medi\u00E7\u00F5es Luminiosidade");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(12, 183, 470, 209);
		frame.getContentPane().add(panel_1);

		JList list = new JList();
		list.setBounds(0, 0, 470, 209);
		panel_1.add(list);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.setBackground(new Color(192, 192, 192));
		btnVoltar.setBounds(12, 427, 97, 25);
		frame.getContentPane().add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				menu_Investigador mInve = new menu_Investigador(bd);
				frame.getDefaultCloseOperation();
			}
		});
	}
}