package MenuAdmin;

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

import Login.FuncoesAjuda;
import Login.JanelaBase;
import Login.Login;
import bancoDeDados.BancoDeDados;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class adminCriarUtilizador extends JanelaBase {
	private JTextField textField_TipoDeUti;
	private JTextField textField_password;
	private JTextField textField_nome;
	private JTextField textField_Email;

	public adminCriarUtilizador(BancoDeDados bd) {
		super(bd);
		initialize();
	}

	protected void initialize() {
		super.initialize();

		JLabel lblInicieASesso = new JLabel("Cria\u00E7\u00E3o de um utilizador");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(186, 157, 196, 16);
		frame.getContentPane().add(lblInicieASesso);

		JPanel panel = new JPanel();
		panel.setBounds(0, 107, 494, 37);
		frame.getContentPane().add(panel);

		JLabel lblMenu = new JLabel("Criar Utilizador");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.setBackground(new Color(192, 192, 192));
		btnVoltar.setBounds(12, 427, 97, 25);
		frame.getContentPane().add(btnVoltar);

		textField_TipoDeUti = new JTextField();
		textField_TipoDeUti.setBounds(194, 297, 216, 22);
		frame.getContentPane().add(textField_TipoDeUti);
		textField_TipoDeUti.setColumns(10);

		textField_password = new JTextField();
		textField_password.setBounds(194, 245, 216, 22);
		frame.getContentPane().add(textField_password);
		textField_password.setColumns(10);

		textField_nome = new JTextField();
		textField_nome.setBounds(194, 193, 216, 22);
		frame.getContentPane().add(textField_nome);
		textField_nome.setColumns(10);

		JLabel lblNome = new JLabel("Nome ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(26, 194, 56, 16);
		frame.getContentPane().add(lblNome);

		JLabel lblTipoDeUtilizador = new JLabel("Tipo de Utilizador");
		lblTipoDeUtilizador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTipoDeUtilizador.setBounds(26, 298, 157, 16);
		frame.getContentPane().add(lblTipoDeUtilizador);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(26, 246, 90, 16);
		frame.getContentPane().add(lblPassword);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(26, 348, 157, 16);
		frame.getContentPane().add(lblEmail);

		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(194, 347, 216, 22);
		frame.getContentPane().add(textField_Email);
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				adminUtilizadores mA = new adminUtilizadores(bd);
				frame.getDefaultCloseOperation();
			}
		});

		JButton btnCriar = new JButton("Criar");
		btnCriar.setBounds(313, 382, 97, 25);
		frame.getContentPane().add(btnCriar);
		btnCriar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textField_nome.getText() == null || textField_password.getText() == null
						|| textField_TipoDeUti.getText() == null || textField_Email.getText() == null) {
					JOptionPane.showConfirmDialog(null, "Faltam dados");
				} else {
					bd.inserirUtilizador(textField_nome.getText(), textField_password.getText(),
							textField_TipoDeUti.getText(), textField_Email.getText(), true);
					frame.setVisible(false);
					frame.dispose();

					menu_Admin mA = new menu_Admin(bd);
					mA.setVisible(true);

				}

			}
		});
		;

	}
}