package JanelasGerais;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Login.JanelaBase;
import bancoDeDados.BancoDeDados;

/**
 * Class CriarMedicao.
 */
public class CriarMedicao extends JanelaBase {
	
	/** The text field ID variavel fk. */
	private JTextField textField_IDVariavel_fk;
	
	/** The text field ID cultura fk. */
	private JTextField textField_IDCultura_fk;
	
	/** The text field data hora medicao. */
	private JFormattedTextField textField_DataHoraMedicao;
	
	/** The text field valor medicao. */
	private JTextField textField_ValorMedicao;

	/**
	 * Instancia o CriarMedicao.
	 *
	 * @param bd da coneção criada no login
	 */
	public CriarMedicao(BancoDeDados bd) {
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

		JLabel lblIDVariavel_fk = lblIDVariavel_fk();
		frame.getContentPane().add(lblIDVariavel_fk);

		textField_IDVariavel_fk();
		frame.getContentPane().add(textField_IDVariavel_fk);

		JLabel lblIDCultura_fk = lblIDCultura_fk();
		frame.getContentPane().add(lblIDCultura_fk);

		textField_IDCultura_fk();
		frame.getContentPane().add(textField_IDCultura_fk);
		
		JLabel lblDataHoraMedicao = lblDataHoraMedicao();
		frame.getContentPane().add(lblDataHoraMedicao);

		textField_DataHoraMedicao();
		frame.getContentPane().add(textField_DataHoraMedicao);

		JLabel lblValorMedicao = lblValorMedicao();
		frame.getContentPane().add(lblValorMedicao);

		textField_ValorMedicao();
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
				ListMedicoes ac = new ListMedicoes(bd);
				frame.getDefaultCloseOperation();
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ListMedicoes ac = new ListMedicoes(bd);
				frame.getDefaultCloseOperation();
			}
		});
	}

	/**
	 * Text field valor medicao.
	 */
	private void textField_ValorMedicao() {
		textField_ValorMedicao = new JTextField();
		textField_ValorMedicao.setColumns(10);
		textField_ValorMedicao.setBounds(221, 290, 216, 22);
	}

	/**
	 * Text field ID variavel fk.
	 */
	private void textField_IDVariavel_fk() {
		textField_IDVariavel_fk = new JTextField();
		textField_IDVariavel_fk.setColumns(10);
		textField_IDVariavel_fk.setBounds(221, 186, 216, 22);
	}

	/**
	 * Text field ID cultura fk.
	 */
	private void textField_IDCultura_fk() {
		textField_IDCultura_fk = new JTextField();
		textField_IDCultura_fk.setColumns(10);
		textField_IDCultura_fk.setBounds(221, 320, 216, 22);
	}

	/**
	 * Text field data hora medicao.
	 */
	private void textField_DataHoraMedicao() {
		textField_DataHoraMedicao = new JFormattedTextField("dd-MM-yyyy HH:mm:ss");
		textField_DataHoraMedicao.setColumns(10);
		textField_DataHoraMedicao.setBounds(221, 238, 216, 22);
	}

	/**
	 * Lbl valor medicao.
	 *
	 * @return the j label
	 */
	private JLabel lblValorMedicao() {
		JLabel lblValorMedicao = new JLabel("ValorMedicao");
		lblValorMedicao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblValorMedicao.setBounds(12, 291, 197, 16);
		return lblValorMedicao;
	}

	/**
	 * Lbl inicie A sesso.
	 *
	 * @return the j label
	 */
	private JLabel lblInicieASesso() {
		JLabel lblInicieASesso = new JLabel("Criacao de uma Medicao");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(186, 157, 196, 16);
		return lblInicieASesso;
	}

	/**
	 * Lbl ID variavel fk.
	 *
	 * @return the j label
	 */
	private JLabel lblIDVariavel_fk() {
		JLabel lblIDVariavel_fk = new JLabel("ID da Variavel");
		lblIDVariavel_fk.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIDVariavel_fk.setBounds(12, 187, 169, 16);
		return lblIDVariavel_fk;
	}

	/**
	 * Lbl ID cultura fk.
	 *
	 * @return the j label
	 */
	private JLabel lblIDCultura_fk() {
		JLabel lblIDCultura_fk = new JLabel("ID da Cultura");
		lblIDCultura_fk.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIDCultura_fk.setBounds(12, 320, 169, 16);
		return lblIDCultura_fk;
	}

	/**
	 * Lbl data hora medicao.
	 *
	 * @return the j label
	 */
	private JLabel lblDataHoraMedicao() {
		JLabel lblDataHoraMedicao = new JLabel("DataHoraMedicao");
		lblDataHoraMedicao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDataHoraMedicao.setBounds(12, 239, 197, 16);
		return lblDataHoraMedicao;
	}

	/**
	 * Panel.
	 *
	 * @return the j panel
	 */
	private JPanel panel() {
		JPanel panel = new JPanel();
		panel.setBounds(0, 107, 494, 37);
		JLabel lblMenu = new JLabel("Criar Medicao");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));
		return panel;
	}
}