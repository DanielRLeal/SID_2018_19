package MenuAdmin;

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

import Login.FuncoesAjuda;
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(86, 215, 324, 132);
		frame.getContentPane().add(panel_1);
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
		btnCultura.setBounds(15, 41, 96, 23);
		btnCultura.setBackground(Color.WHITE);
		btnCultura.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_1.add(btnCultura);
		
		JButton btnMediesTemperatura = new JButton("Medi\u00E7\u00F5es Temperatura");
		btnMediesTemperatura.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnMediesTemperatura.setBackground(Color.WHITE);
		btnMediesTemperatura.setBounds(54, 71, 212, 23);
		panel_1.add(btnMediesTemperatura);
		
		JButton btnMediesLuminiosidade = new JButton("Medi\u00E7\u00F5es Luminiosidade");
		btnMediesLuminiosidade.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnMediesLuminiosidade.setBackground(Color.WHITE);
		btnMediesLuminiosidade.setBounds(54, 98, 212, 23);
		panel_1.add(btnMediesLuminiosidade);
		
		JButton btnMedies = new JButton("Medi\u00E7\u00F5es");
		btnMedies.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnMedies.setBackground(Color.WHITE);
		btnMedies.setBounds(133, 12, 106, 23);
		panel_1.add(btnMedies);
		btnCultura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				adminCulturas aCult = new adminCulturas(bd);
				frame.setVisible(false);
			}
		});
	}
}