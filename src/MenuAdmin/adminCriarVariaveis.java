package MenuAdmin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import JanelasGerais.ListVariaveis;
import Login.JanelaBase;
import bancoDeDados.BancoDeDados;

public class adminCriarVariaveis extends JanelaBase {
	private JTextField textField_IDCultura_fk;
	private JTextField textField_NomeVariaveis;
	private JTextField textField_ValorMedicao;

	public adminCriarVariaveis(BancoDeDados bd) {
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
		
		JLabel lblIDCultura_fk = lblIDCultura_fk();
		frame.getContentPane().add(lblIDCultura_fk);

		textField_IDCultura_fk();
		frame.getContentPane().add(textField_IDCultura_fk);
		
		JLabel lblNomeVariaveis = lblNomeVariaveis();
		frame.getContentPane().add(lblNomeVariaveis);

		textField_NomeVariaveis();
		frame.getContentPane().add(textField_NomeVariaveis);

		JButton buttonCriar = new JButton("Criar");
		buttonCriar.setBounds(340, 360, 97, 25);
		frame.getContentPane().add(buttonCriar);
		buttonCriar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String NomeVariaveis = textField_NomeVariaveis.getText().toString();
				String IDCultura_fk = textField_IDCultura_fk.getText();

				bd.inserirVariaveis(NomeVariaveis, IDCultura_fk);
				
				frame.setVisible(false);
				ListVariaveis ac = new ListVariaveis(bd);
				frame.getDefaultCloseOperation();
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ListVariaveis ac = new ListVariaveis(bd);
				frame.getDefaultCloseOperation();
			}
		});
	}

	private void textField_NomeVariaveis() {
		textField_NomeVariaveis = new JTextField();
		textField_NomeVariaveis.setColumns(10);
		textField_NomeVariaveis.setBounds(221, 238, 216, 22);
	}

	private void textField_IDCultura_fk() {
		textField_IDCultura_fk = new JTextField();
		textField_IDCultura_fk.setColumns(10);
		textField_IDCultura_fk.setBounds(221, 320, 216, 22);
	}

	private JLabel lblNomeVariaveis() {
		JLabel lblNomeVariaveis = new JLabel("NomeVariaveis");
		lblNomeVariaveis.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNomeVariaveis.setBounds(12, 239, 197, 16);
		return lblNomeVariaveis;
	}

	private JLabel lblInicieASesso() {
		JLabel lblInicieASesso = new JLabel("Cria\u00E7\u00E3o de uma Medicao");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(186, 157, 196, 16);
		return lblInicieASesso;
	}

	private JLabel lblIDCultura_fk() {
		JLabel lblIDCultura_fk = new JLabel("ID da Cultura");
		lblIDCultura_fk.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIDCultura_fk.setBounds(12, 320, 169, 16);
		return lblIDCultura_fk;
	}

	private JPanel panel() {
		JPanel panel = new JPanel();
		panel.setBounds(0, 107, 494, 37);
		JLabel lblMenu = new JLabel("Criar Medicao");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));
		return panel;
	}
}