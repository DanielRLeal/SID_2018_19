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

/**
 * Class adminCriarUtilizador.
 */
public class adminCriarUtilizador extends JanelaBase {
	
	/** The text field tipo de utilizador. */
	private JTextField textField_TipoDeUti;
	
	/** The text field password. */
	private JTextField textField_password;
	
	/** The text field nome. */
	private JTextField textField_nome;
	
	/** The text field email. */
	private JTextField textField_Email;

	/**
	 * Instancia o adminCriarUtilizador.
	 *
	 * @param bd da coneção criada no login
	 */
	public adminCriarUtilizador(BancoDeDados bd) {
		super(bd);
		initialize();
	}

	/* (non-Javadoc)
	 * @see Login.JanelaBase#initialize()
	 */
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

		textField_TipoDeUti();
		frame.getContentPane().add(textField_TipoDeUti);
		textField_password();
		frame.getContentPane().add(textField_password);
		textField_nome();
		frame.getContentPane().add(textField_nome);
		JLabel lblNome = lblNome();
		frame.getContentPane().add(lblNome);

		JLabel lblTipoDeUtilizador = lblTipoDeUtilizador();
		frame.getContentPane().add(lblTipoDeUtilizador);

		JLabel lblPassword = lblPassword();
		frame.getContentPane().add(lblPassword);

		JLabel lblEmail = lblEmail();
		frame.getContentPane().add(lblEmail);

		textField_Email();
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
			public void actionPerformed(ActionEvent e) {
				if (textField_nome.getText() == null || textField_password.getText() == null
						|| textField_TipoDeUti.getText() == null || textField_Email.getText() == null) {
//					JOptionPane.showConfirmDialog(null, "Faltam dados");
				}
				if (!textField_TipoDeUti.getText().equals("Investigador")
						&& !textField_TipoDeUti.getText().equals("Auditor")
						&& !textField_TipoDeUti.getText().equals("Administrador")) {
					JOptionPane.showMessageDialog(null, "Categoria Profissional inexistente!");
					return;
				}
				bd.inserirUtilizador(textField_nome.getText(), textField_password.getText(),
						textField_TipoDeUti.getText(), textField_Email.getText(), true);
				
				frame.setVisible(false);
				adminUtilizadores mA = new adminUtilizadores(bd);
				frame.getDefaultCloseOperation();
			}
		});
	}

	/**
	 * Text field password.
	 */
	private void textField_password() {
		textField_password = new JTextField();
		textField_password.setBounds(194, 245, 216, 22);
		textField_password.setColumns(10);
	}

	/**
	 * Text field nome.
	 */
	private void textField_nome() {
		textField_nome = new JTextField();
		textField_nome.setBounds(194, 193, 216, 22);
		textField_nome.setColumns(10);
	}

	/**
	 * Text field tipo de utilizador.
	 */
	private void textField_TipoDeUti() {
		textField_TipoDeUti = new JTextField();
		textField_TipoDeUti.setBounds(194, 297, 216, 22);
		textField_TipoDeUti.setColumns(10);
	}

	/**
	 * Text field email.
	 */
	private void textField_Email() {
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(194, 347, 216, 22);
	}

	/**
	 * Lbl tipo de utilizador.
	 *
	 * @return the j label
	 */
	private JLabel lblTipoDeUtilizador() {
		JLabel lblTipoDeUtilizador = new JLabel("Tipo de Utilizador");
		lblTipoDeUtilizador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTipoDeUtilizador.setBounds(26, 298, 157, 16);
		return lblTipoDeUtilizador;
	}

	/**
	 * Lbl password.
	 *
	 * @return the j label
	 */
	private JLabel lblPassword() {
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(26, 246, 90, 16);
		return lblPassword;
	}

	/**
	 * Lbl nome.
	 *
	 * @return the j label
	 */
	private JLabel lblNome() {
		JLabel lblNome = new JLabel("Nome ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(26, 194, 56, 16);
		return lblNome;
	}

	/**
	 * Lbl inicie A sesso.
	 *
	 * @return the j label
	 */
	private JLabel lblInicieASesso() {
		JLabel lblInicieASesso = new JLabel("Criacao de um utilizador");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(186, 157, 196, 16);
		return lblInicieASesso;
	}

	/**
	 * Lbl email.
	 *
	 * @return the j label
	 */
	private JLabel lblEmail() {
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(26, 348, 157, 16);
		return lblEmail;
	}

	/**
	 * Panel.
	 *
	 * @return the j panel
	 */
	private JPanel panel() {
		JPanel panel = new JPanel();
		panel.setBounds(0, 107, 494, 37);
		JLabel lblMenu = new JLabel("Criar Utilizador");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));
		return panel;
	}
}