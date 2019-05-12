package MenuAdmin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;

import Login.JanelaBase;
import bancoDeDados.BancoDeDados;

public class adminCriarMedicaoTemp extends JanelaBase {

	private JTextField textField_IDMedicaoLum;
	private JTextField textField_DescricaoCultura;
	private JTextField textField_valorMedLum;
	private JFormattedTextField formatText;

	public adminCriarMedicaoTemp(BancoDeDados bd) {
		super(bd);
		initialize();
	}

	@Override
	protected void initialize() {
		super.initialize();

		JLabel lblInicieASesso = new JLabel("Cria\u00E7\u00E3o de uma Medicao de Luminosidade");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(186, 157, 196, 16);
		frame.getContentPane().add(lblInicieASesso);

		JPanel panel = new JPanel();
		panel.setBounds(0, 107, 494, 37);
		frame.getContentPane().add(panel);

		JLabel lblMenu = new JLabel("Criar Medicao de Luminosidade");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.setBackground(new Color(192, 192, 192));
		btnVoltar.setBounds(12, 427, 97, 25);
		frame.getContentPane().add(btnVoltar);

//		JLabel lblNomeDaCultura = new JLabel("Nome da Cultura");
//		lblNomeDaCultura.setFont(new Font("Tahoma", Font.PLAIN, 18));
//		lblNomeDaCultura.setBounds(12, 187, 169, 16);
//		frame.getContentPane().add(lblNomeDaCultura);

		textField_IDMedicaoLum = new JTextField();
		textField_IDMedicaoLum.setColumns(10);
		textField_IDMedicaoLum.setBounds(221, 186, 216, 22);
		frame.getContentPane().add(textField_IDMedicaoLum);

//		JLabel lblDescrioDaCultura = new JLabel("Descri\u00E7\u00E3o da Medicao");
//		lblDescrioDaCultura.setFont(new Font("Tahoma", Font.PLAIN, 18));
//		lblDescrioDaCultura.setBounds(12, 239, 197, 16);
//		frame.getContentPane().add(lblDescrioDaCultura);

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String dateString = formatter.format(date);
		formatText = new JFormattedTextField(formatter);
		formatText.setColumns(20);
		formatText.setText(dateString);

		textField_DescricaoCultura = new JTextField();
		textField_DescricaoCultura.setColumns(10);
		textField_DescricaoCultura.setBounds(221, 238, 216, 22);
		frame.getContentPane().add(textField_DescricaoCultura);

		JLabel lblUtilizadorResponsvel = new JLabel("Utilizador respons\u00E1vel");
		lblUtilizadorResponsvel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUtilizadorResponsvel.setBounds(12, 291, 197, 16);
		frame.getContentPane().add(lblUtilizadorResponsvel);

		textField_valorMedLum = new JTextField();
		textField_valorMedLum.setColumns(10);
		textField_valorMedLum.setBounds(221, 290, 216, 22);
		frame.getContentPane().add(textField_valorMedLum);

		JButton buttonCriar = new JButton("Criar");
		buttonCriar.setBounds(340, 339, 97, 25);
		frame.getContentPane().add(buttonCriar);
		buttonCriar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
					Date date = new Date();

					bd.inserirMedicoesLuminosidade(5, date, 20.0);
					// textField_IDMedicaoLum.getText(), date, textField_valorMedLum.getText()
				} catch (Exception e2) {
				}
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				adminMedicoesLuminosidade aMedLum = new adminMedicoesLuminosidade(bd);
				frame.getDefaultCloseOperation();
			}
		});
	}
}