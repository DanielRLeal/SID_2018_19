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

/**
 * Class CriarCultura.
 */
public class CriarCultura extends JanelaBase {
	
	/** The text field nome cultura. */
	private JTextField textField_NomeCultura;
	
	/** The text field descricao cultura. */
	private JTextField textField_DescricaoCultura;
	
	/** The text field utilizador resp. */
	private JTextField textField_Utilizador_resp;

	/**
	 * Instancia o CriarCultura.
	 *
	 * @param bd da coneção criada no login
	 */
	public CriarCultura(BancoDeDados bd) {
		super(bd);
		initialize();
	}

	/* (non-Javadoc)
	 * @see Login.JanelaBase#initialize()
	 */
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

	/**
	 * Text field utilizador responsável.
	 */
	private void textField_Utilizador_resp() {
		textField_Utilizador_resp = new JTextField();
		textField_Utilizador_resp.setColumns(10);
		textField_Utilizador_resp.setBounds(221, 290, 216, 22);
	}

	/**
	 * Text field nome cultura.
	 */
	private void textField_NomeCultura() {
		textField_NomeCultura = new JTextField();
		textField_NomeCultura.setColumns(10);
		textField_NomeCultura.setBounds(221, 186, 216, 22);
	}

	/**
	 * Text field descricao cultura.
	 */
	private void textField_DescricaoCultura() {
		textField_DescricaoCultura = new JTextField();
		textField_DescricaoCultura.setColumns(10);
		textField_DescricaoCultura.setBounds(221, 238, 216, 22);
	}

	/**
	 * Lbl utilizador responsvel.
	 *
	 * @return the j label
	 */
	private JLabel lblUtilizadorResponsvel() {
		JLabel lblUtilizadorResponsvel = new JLabel("Utilizador responsavel");
		lblUtilizadorResponsvel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUtilizadorResponsvel.setBounds(12, 291, 197, 16);
		return lblUtilizadorResponsvel;
	}

	/**
	 * Lbl nome da cultura.
	 *
	 * @return the j label
	 */
	private JLabel lblNomeDaCultura() {
		JLabel lblNomeDaCultura = new JLabel("Nome da Cultura");
		lblNomeDaCultura.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNomeDaCultura.setBounds(12, 187, 169, 16);
		return lblNomeDaCultura;
	}

	/**
	 * Lbl inicie A sesso.
	 *
	 * @return the j label
	 */
	private JLabel lblInicieASesso() {
		JLabel lblInicieASesso = new JLabel("Criacao de uma cultura");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(186, 157, 196, 16);
		return lblInicieASesso;
	}

	/**
	 * Lbl descrio da cultura.
	 *
	 * @return the j label
	 */
	private JLabel lblDescrioDaCultura() {
		JLabel lblDescrioDaCultura = new JLabel("Descricao da Cultura");
		lblDescrioDaCultura.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescrioDaCultura.setBounds(12, 239, 197, 16);
		return lblDescrioDaCultura;
	}

	/**
	 * Panel.
	 *
	 * @return the j panel
	 */
	private JPanel panel() {
		JPanel panel = new JPanel();
		panel.setBounds(0, 107, 494, 37);
		JLabel lblMenu = new JLabel("Criar Cultura");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));
		return panel;
	}
}