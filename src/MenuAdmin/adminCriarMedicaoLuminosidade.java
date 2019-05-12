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

public class adminCriarMedicaoLuminosidade extends JanelaBase {
	private JTextField textField_IDMedicao;
	private JFormattedTextField textField_DataHoraMedicao;
	private JTextField textField_ValorMedicaoLuminosidade;

	public adminCriarMedicaoLuminosidade(BancoDeDados bd) {
		super(bd);
		initialize();
	}

	@Override
	protected void initialize() {
		super.initialize();

		JLabel lblInicieASesso = new JLabel("Cria\u00E7\u00E3o de uma MedicaoLuminosidade");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(186, 157, 196, 16);
		frame.getContentPane().add(lblInicieASesso);

		JPanel panel = new JPanel();
		panel.setBounds(0, 107, 494, 37);
		frame.getContentPane().add(panel);

		JLabel lblMenu = new JLabel("Criar MedicaoLuminosidade");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.setBackground(new Color(192, 192, 192));
		btnVoltar.setBounds(12, 427, 97, 25);
		frame.getContentPane().add(btnVoltar);

//		JLabel lblIDMedicao = new JLabel("ID da MedicaoLuminosidade");
//		lblIDMedicao.setFont(new Font("Tahoma", Font.PLAIN, 18));
//		lblIDMedicao.setBounds(12, 187, 169, 16);
//		frame.getContentPane().add(lblIDMedicao);

//		textField_IDMedicao = new JTextField();
//		textField_IDMedicao.setColumns(10);
//		textField_IDMedicao.setBounds(221, 186, 216, 22);
//		frame.getContentPane().add(textField_IDMedicao);

		JLabel lblDataHoraMedicao = new JLabel("DataHoraMedicao da Luminosidade");
		lblDataHoraMedicao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDataHoraMedicao.setBounds(12, 239, 197, 16);
		frame.getContentPane().add(lblDataHoraMedicao);

//		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		textField_DataHoraMedicao = new JFormattedTextField("yyyy-MM-dd HH:mm:ss");
		textField_DataHoraMedicao.setText("2015-02-01 16:16:02");
		textField_DataHoraMedicao.setColumns(10);
		textField_DataHoraMedicao.setBounds(221, 238, 216, 22);
		frame.getContentPane().add(textField_DataHoraMedicao);

		JLabel lblValorMedicaoLuminosidade = new JLabel("ValorMedicaoLuminosidade");
		lblValorMedicaoLuminosidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblValorMedicaoLuminosidade.setBounds(12, 291, 197, 16);
		frame.getContentPane().add(lblValorMedicaoLuminosidade);

		textField_ValorMedicaoLuminosidade = new JTextField();
		textField_ValorMedicaoLuminosidade.setColumns(10);
		textField_ValorMedicaoLuminosidade.setBounds(221, 290, 216, 22);
		frame.getContentPane().add(textField_ValorMedicaoLuminosidade);

		JButton buttonCriar = new JButton("Criar");
		buttonCriar.setBounds(340, 339, 97, 25);
		frame.getContentPane().add(buttonCriar);
		buttonCriar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String dataHoraMedicao = textField_DataHoraMedicao.getValue().toString();
//					double ValorMedicaoLuminosidade = Double.parseDouble(textField_ValorMedicaoLuminosidade.getText());
				double valorMedido = Double.parseDouble(textField_ValorMedicaoLuminosidade.getText());
				bd.inserirMedicoesLuminosidade(dataHoraMedicao, valorMedido);

			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				adminMedicoesLuminosidade ac = new adminMedicoesLuminosidade(bd);
				frame.getDefaultCloseOperation();
			}
		});
	}
}