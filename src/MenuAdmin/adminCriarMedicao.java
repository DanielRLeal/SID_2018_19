package MenuAdmin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Login.JanelaBase;
import bancoDeDados.BancoDeDados;

public class adminCriarMedicao extends JanelaBase {
	private JTextField textField_IDVariavel_fk;
	private JTextField textField_IDCultura_fk;
	private JFormattedTextField textField_DataHoraMedicao;
	private JTextField textField_ValorMedicao;

	public adminCriarMedicao(BancoDeDados bd) {
		super(bd);
		initialize();
	}

	@Override
	protected void initialize() {
		super.initialize();

		JLabel lblInicieASesso = new JLabel("Cria\u00E7\u00E3o de uma Medicao");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(186, 157, 196, 16);
		frame.getContentPane().add(lblInicieASesso);

		JPanel panel = new JPanel();
		panel.setBounds(0, 107, 494, 37);
		frame.getContentPane().add(panel);

		JLabel lblMenu = new JLabel("Criar Medicao");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.setBackground(new Color(192, 192, 192));
		btnVoltar.setBounds(12, 427, 97, 25);
		frame.getContentPane().add(btnVoltar);

		JLabel lblIDVariavel_fk = new JLabel("ID da Variavel");
		lblIDVariavel_fk.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIDVariavel_fk.setBounds(12, 187, 169, 16);
		frame.getContentPane().add(lblIDVariavel_fk);

		textField_IDVariavel_fk = new JTextField();
		textField_IDVariavel_fk.setColumns(10);
		textField_IDVariavel_fk.setBounds(221, 186, 216, 22);
		frame.getContentPane().add(textField_IDVariavel_fk);

		JLabel lblIDCultura_fk = new JLabel("ID da Cultura");
		lblIDCultura_fk.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIDCultura_fk.setBounds(12, 320, 169, 16);
		frame.getContentPane().add(lblIDCultura_fk);

		textField_IDCultura_fk = new JTextField();
		textField_IDCultura_fk.setColumns(10);
		textField_IDCultura_fk.setBounds(221, 320, 216, 22);
		frame.getContentPane().add(textField_IDCultura_fk);
		
		JLabel lblDataHoraMedicao = new JLabel("DataHoraMedicao");
		lblDataHoraMedicao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDataHoraMedicao.setBounds(12, 239, 197, 16);
		frame.getContentPane().add(lblDataHoraMedicao);

		textField_DataHoraMedicao = new JFormattedTextField("dd-MM-yyyy HH:mm:ss");
		textField_DataHoraMedicao.setColumns(10);
		textField_DataHoraMedicao.setBounds(221, 238, 216, 22);
		frame.getContentPane().add(textField_DataHoraMedicao);

		JLabel lblValorMedicao = new JLabel("ValorMedicao");
		lblValorMedicao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblValorMedicao.setBounds(12, 291, 197, 16);
		frame.getContentPane().add(lblValorMedicao);

		textField_ValorMedicao = new JTextField();
		textField_ValorMedicao.setColumns(10);
		textField_ValorMedicao.setBounds(221, 290, 216, 22);
		frame.getContentPane().add(textField_ValorMedicao);

		JButton buttonCriar = new JButton("Criar");
		buttonCriar.setBounds(340, 360, 97, 25);
		frame.getContentPane().add(buttonCriar);

		buttonCriar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String IDVariavel_fk = textField_IDVariavel_fk.getText().toString();
				String IDCultura_fk = textField_IDCultura_fk.getText().toString();
				String dataHoraMedicao = textField_DataHoraMedicao.getValue().toString();
				double valorMedido = Double.parseDouble(textField_ValorMedicao.getText());

				bd.inserirMedicoes(IDCultura_fk, IDVariavel_fk, dataHoraMedicao, valorMedido);
				
				frame.setVisible(false);
				adminMedicoes ac = new adminMedicoes(bd);
				frame.getDefaultCloseOperation();
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				adminMedicoes ac = new adminMedicoes(bd);
				frame.getDefaultCloseOperation();
			}
		});
	}
}