package JanelasGerais;

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
import javax.swing.JOptionPane;

public class CriarCultura extends JanelaBase {
	private JTextField textField_NomeCultura;
	private JTextField textField_DescricaoCultura;
	private JTextField textField_Utilizador_resp;

	public CriarCultura(BancoDeDados bd) {
		super(bd);
		initialize();
	}

	@Override
	protected void initialize() {
		super.initialize();
		
		JLabel lblInicieASesso = lblInicieASesso();
		frame.getContentPane().add(lblInicieASesso);

		JPanel panel = panel();
		frame.getContentPane().add(panel);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.setBackground(new Color(192, 192, 192));
		btnVoltar.setBounds(12, 427, 97, 25);
		frame.getContentPane().add(btnVoltar);

		JLabel lblNomeDaCultura = lblNomeDaCultura();
		frame.getContentPane().add(lblNomeDaCultura);

		textField_NomeCultura();
		frame.getContentPane().add(textField_NomeCultura);

		JLabel lblDescrioDaCultura = lblDescrioDaCultura();
		frame.getContentPane().add(lblDescrioDaCultura);

		textField_DescricaoCultura();
		frame.getContentPane().add(textField_DescricaoCultura);

		JLabel lblUtilizadorResponsvel = lblUtilizadorResponsvel();
		frame.getContentPane().add(lblUtilizadorResponsvel);

		textField_Utilizador_resp();
		frame.getContentPane().add(textField_Utilizador_resp);

		JButton buttonCriar = new JButton("Criar");
		buttonCriar.setBounds(340, 339, 97, 25);
		frame.getContentPane().add(buttonCriar);
		buttonCriar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					bd.inserirCultura(textField_NomeCultura.getText(), textField_DescricaoCultura.getText(),
							textField_Utilizador_resp.getText());
					
					frame.setVisible(false);
					ListCulturas ac = new ListCulturas(bd);
					frame.getDefaultCloseOperation();
				} catch (Exception e2) {
				}
			}
		});
		
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ListCulturas ac = new ListCulturas(bd);
				frame.getDefaultCloseOperation();
			}
		});
	}

	private void textField_Utilizador_resp() {
		textField_Utilizador_resp = new JTextField();
		textField_Utilizador_resp.setColumns(10);
		textField_Utilizador_resp.setBounds(221, 290, 216, 22);
	}

	private void textField_NomeCultura() {
		textField_NomeCultura = new JTextField();
		textField_NomeCultura.setColumns(10);
		textField_NomeCultura.setBounds(221, 186, 216, 22);
	}

	private void textField_DescricaoCultura() {
		textField_DescricaoCultura = new JTextField();
		textField_DescricaoCultura.setColumns(10);
		textField_DescricaoCultura.setBounds(221, 238, 216, 22);
	}

	private JLabel lblUtilizadorResponsvel() {
		JLabel lblUtilizadorResponsvel = new JLabel("Utilizador respons\u00E1vel");
		lblUtilizadorResponsvel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUtilizadorResponsvel.setBounds(12, 291, 197, 16);
		return lblUtilizadorResponsvel;
	}

	private JLabel lblNomeDaCultura() {
		JLabel lblNomeDaCultura = new JLabel("Nome da Cultura");
		lblNomeDaCultura.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNomeDaCultura.setBounds(12, 187, 169, 16);
		return lblNomeDaCultura;
	}

	private JLabel lblInicieASesso() {
		JLabel lblInicieASesso = new JLabel("Cria\u00E7\u00E3o de uma cultura");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(186, 157, 196, 16);
		return lblInicieASesso;
	}

	private JLabel lblDescrioDaCultura() {
		JLabel lblDescrioDaCultura = new JLabel("Descri\u00E7\u00E3o da Cultura");
		lblDescrioDaCultura.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescrioDaCultura.setBounds(12, 239, 197, 16);
		return lblDescrioDaCultura;
	}

	private JPanel panel() {
		JPanel panel = new JPanel();
		panel.setBounds(0, 107, 494, 37);
		JLabel lblMenu = new JLabel("Criar Cultura");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));
		return panel;
	}
}