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

import JanelasGerais.ListVariaveisMedidas;
import Login.JanelaBase;
import bancoDeDados.BancoDeDados;

public class adminCriarVariaveisMedidas extends JanelaBase {
	private JTextField textField_IDVariavel_fk;
	private JTextField textField_IDCultura_fk;
	private JTextField textField_LimInferior;
	private JTextField textField_LimSuperior;

	public adminCriarVariaveisMedidas(BancoDeDados bd) {
		super(bd);
		initialize();
	}

	@Override
	protected void initialize() {
		super.initialize();

		JLabel lblInicieASesso = new JLabel("Cria\u00E7\u00E3o de uma VariaveisMedidas");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(186, 157, 196, 16);
		frame.getContentPane().add(lblInicieASesso);

		JPanel panel = new JPanel();
		panel.setBounds(0, 107, 494, 37);
		frame.getContentPane().add(panel);

		JLabel lblMenu = new JLabel("Criar VariaveisMedidas");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.setBackground(new Color(192, 192, 192));
		btnVoltar.setBounds(12, 427, 97, 25);
		frame.getContentPane().add(btnVoltar);
///////////////
		JLabel lblIDVariavel_fk = new JLabel("ID da Variavel");
		lblIDVariavel_fk.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIDVariavel_fk.setBounds(12, 187, 169, 16);
		frame.getContentPane().add(lblIDVariavel_fk);

		textField_IDVariavel_fk = new JTextField();
		textField_IDVariavel_fk.setColumns(10);
		textField_IDVariavel_fk.setBounds(221, 186, 216, 22);
		frame.getContentPane().add(textField_IDVariavel_fk);

///////////////////
		JLabel lblIDCultura_fk = new JLabel("ID da Cultura");
		lblIDCultura_fk.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIDCultura_fk.setBounds(12, 320, 169, 16);
		frame.getContentPane().add(lblIDCultura_fk);

		textField_IDCultura_fk = new JTextField();
		textField_IDCultura_fk.setColumns(10);
		textField_IDCultura_fk.setBounds(221, 320, 216, 22);
		frame.getContentPane().add(textField_IDCultura_fk);
//////////////
		JLabel lblLimInferior = new JLabel("LimInferior");
		lblLimInferior.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLimInferior.setBounds(12, 239, 197, 16);
		frame.getContentPane().add(lblLimInferior);

//		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		textField_LimInferior = new JTextField();
//		textField_DataHoraMedicao.setText("2015-02-01 16:16:02");
		textField_LimInferior.setColumns(10);
		textField_LimInferior.setBounds(221, 238, 216, 22);
		frame.getContentPane().add(textField_LimInferior);
//--------------
		JLabel lblLimSuperior = new JLabel("LimSuperior");
		lblLimSuperior.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLimSuperior.setBounds(12, 291, 197, 16);
		frame.getContentPane().add(lblLimSuperior);

		textField_LimSuperior = new JTextField();
		textField_LimSuperior.setColumns(10);
		textField_LimSuperior.setBounds(221, 290, 216, 22);
		frame.getContentPane().add(textField_LimSuperior);

		JButton buttonCriar = new JButton("Criar");
		buttonCriar.setBounds(340, 360, 97, 25);
		frame.getContentPane().add(buttonCriar);
		buttonCriar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String IDVariavel_fk = textField_IDVariavel_fk.getText().toString();
				String IDCultura_fk = textField_IDCultura_fk.getText().toString();

				double limSuperior = Double.parseDouble(textField_LimSuperior.getText());
//					double ValorMedicao = Double.parseDouble(textField_ValorMedicao.getText());
				double limInferior = Double.parseDouble(textField_LimInferior.getText());

				bd.inserirVariaveisMedidas(IDCultura_fk, IDVariavel_fk, limSuperior, limInferior);

			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ListVariaveisMedidas ac = new ListVariaveisMedidas(bd);
				frame.getDefaultCloseOperation();
			}
		});
	}
}