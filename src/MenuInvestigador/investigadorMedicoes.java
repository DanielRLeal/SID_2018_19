package MenuInvestigador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Login.FuncoesAjuda;
import Login.JanelaBase;
import bancoDeDados.BancoDeDados;
import bancoDeDados.Medicoes;

public class investigadorMedicoes extends JanelaBase {

	private ArrayList<Medicoes> medicoes;

	public investigadorMedicoes(BancoDeDados bd) {
		super(bd);
		getContentPane().setLayout(null);
		medicoes = bd.listaMedicoes();
		initialize();
	}

	@Override
	protected void initialize() {
		super.initialize();

		JLabel lblInicieASesso = new JLabel("Consulta de Medicoes");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(186, 157, 196, 16);
		frame.getContentPane().add(lblInicieASesso);

		JPanel panel = new JPanel();
		panel.setBounds(0, 107, 494, 37);
		frame.getContentPane().add(panel);

		JLabel lblMenu = new JLabel("Medicoess");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));

		JScrollPane panel_1 = new JScrollPane();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(12, 183, 470, 209);
		frame.getContentPane().add(panel_1);

		Object[] columnNames = { "#", "IDCultura_fk", " IDVariavel_fk", "DataHoraMedicao", "ValorMedicao" };

		Object[][] Medicoes = FuncoesAjuda.listaParaTabela(bd.listaMedicoes(), 5);

		JTable table = new JTable(Medicoes, columnNames);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);

		panel_1.setViewportView(table);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.setBackground(new Color(192, 192, 192));
		btnVoltar.setBounds(12, 416, 97, 25);
		frame.getContentPane().add(btnVoltar);

		JButton btnCriarMedicoes = new JButton("Criar Medicoes");
		btnCriarMedicoes.setBounds(360, 416, 120, 23);
		frame.getContentPane().add(btnCriarMedicoes);
		btnCriarMedicoes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCriarMedicoes.setBackground(new Color(240, 230, 140));

		JButton btnEditar = new JButton("Editar");
		JButton btnEliminar = new JButton("Eliminar");

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				btnEditar.setBounds(150, 416, 75, 23);
				frame.getContentPane().add(btnEditar);
				btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 13));
				btnEditar.setBackground(new Color(240, 230, 140));

				btnEliminar.setBounds(230, 416, 100, 23);
				frame.getContentPane().add(btnEliminar);
				btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
				btnEliminar.setBackground(new Color(240, 230, 140));
			}
		});

		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				Medicoes m = medicoes.get(index);

				System.out.println("Vou apagar a Medicoes no index: " + index + "\n" + "Medicoes com ID= "
						+ m.getIDMedicoes() + "\n");
				bd.apagarMedicoes(m.getIDMedicoes());

			}
		});
		btnCriarMedicoes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				investigadorCriarMedicoes acd = new investigadorCriarMedicoes(bd);
				frame.getDefaultCloseOperation();
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				menu_Investigador mA = new menu_Investigador(bd);
				frame.getDefaultCloseOperation();
			}
		});
	}
}