package MenuAdmin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.border.MatteBorder;
import javax.xml.crypto.Data;

import Login.JanelaBase;
import Login.Login;
import bancoDeDados.BancoDeDados;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class adminCriarMedicaoTemp extends JanelaBase {
	private JTextField textField_IDMedicao;
	private JFormattedTextField textField_DataHoraMedicao;
	private JTextField textField_ValorMedicaoTemperatura;

	public adminCriarMedicaoTemp(BancoDeDados bd) {
		super(bd);
		initialize();
	}

	@Override
	protected void initialize() {
		super.initialize();

		JLabel lblInicieASesso = new JLabel("Cria\u00E7\u00E3o de uma MedicaoTemperatura");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(186, 157, 196, 16);
		frame.getContentPane().add(lblInicieASesso);

		JPanel panel = new JPanel();
		panel.setBounds(0, 107, 494, 37);
		frame.getContentPane().add(panel);

		JLabel lblMenu = new JLabel("Criar MedicaoTemperatura");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.setBackground(new Color(192, 192, 192));
		btnVoltar.setBounds(12, 427, 97, 25);
		frame.getContentPane().add(btnVoltar);

//		JLabel lblIDMedicao = new JLabel("ID da MedicaoTemperatura");
//		lblIDMedicao.setFont(new Font("Tahoma", Font.PLAIN, 18));
//		lblIDMedicao.setBounds(12, 187, 169, 16);
//		frame.getContentPane().add(lblIDMedicao);

//		textField_IDMedicao = new JTextField();
//		textField_IDMedicao.setColumns(10);
//		textField_IDMedicao.setBounds(221, 186, 216, 22);
//		frame.getContentPane().add(textField_IDMedicao);

		JLabel lblDataHoraMedicao = new JLabel("DataHoraMedicao da Temperatura");
		lblDataHoraMedicao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDataHoraMedicao.setBounds(12, 239, 197, 16);
		frame.getContentPane().add(lblDataHoraMedicao);

//		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		textField_DataHoraMedicao = new JFormattedTextField("yyyy-MM-dd HH:mm:ss");
		textField_DataHoraMedicao.setText("2015-02-01 16:16:02");
		textField_DataHoraMedicao.setColumns(10);
		textField_DataHoraMedicao.setBounds(221, 238, 216, 22);
		frame.getContentPane().add(textField_DataHoraMedicao);

		JLabel lblValorMedicaoTemperatura = new JLabel("ValorMedicaoTemperatura");
		lblValorMedicaoTemperatura.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblValorMedicaoTemperatura.setBounds(12, 291, 197, 16);
		frame.getContentPane().add(lblValorMedicaoTemperatura);

		textField_ValorMedicaoTemperatura = new JTextField();
		textField_ValorMedicaoTemperatura.setColumns(10);
		textField_ValorMedicaoTemperatura.setBounds(221, 290, 216, 22);
		frame.getContentPane().add(textField_ValorMedicaoTemperatura);

		JButton buttonCriar = new JButton("Criar");
		buttonCriar.setBounds(340, 339, 97, 25);
		frame.getContentPane().add(buttonCriar);
		buttonCriar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String dataHoraMedicao = textField_DataHoraMedicao.getValue().toString();
//					double ValorMedicaoTemperatura = Double.parseDouble(textField_ValorMedicaoTemperatura.getText());
				double valorMedido = Double.parseDouble(textField_ValorMedicaoTemperatura.getText());
				bd.inserirMedicoesTemperatura(dataHoraMedicao, valorMedido);

			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				adminMedicoesTemp ac = new adminMedicoesTemp(bd);
				frame.getDefaultCloseOperation();
			}
		});
	}
}