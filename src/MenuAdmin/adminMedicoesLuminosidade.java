package MenuAdmin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

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
import bancoDeDados.MedicaoLuminosidade;
import bancoDeDados.MedicaoLuminosidade;

public class adminMedicoesLuminosidade extends JanelaBase {

	private ArrayList<MedicaoLuminosidade> medLum;

	public adminMedicoesLuminosidade(BancoDeDados bd) {
		super(bd);
		getContentPane().setLayout(null);
		medLum = bd.listaMedicoesLuminosidade();
		initialize();
	}

	@Override
	protected void initialize() {
		super.initialize();

		JLabel lblInicieASesso = new JLabel("Consulta de utilizadores");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(186, 157, 196, 16);
		frame.getContentPane().add(lblInicieASesso);

		JPanel panel = new JPanel();
		panel.setBounds(0, 107, 494, 37);
		frame.getContentPane().add(panel);

		JLabel lblMenu = new JLabel("MedicaoLuminosidades");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));

		JScrollPane panel_1 = new JScrollPane();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(12, 183, 470, 209);
		frame.getContentPane().add(panel_1);

		Object[] columnNames = { "#", "DataHoraMedicao", "ValorMedicaoLuminosidade" };

		Object[][] MedicaoLuminosidades = FuncoesAjuda.listaParaTabela(bd.listaMedicoesLuminosidade(), 3);

		JTable table = new JTable(MedicaoLuminosidades, columnNames);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);

		panel_1.setViewportView(table);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.setBackground(new Color(192, 192, 192));
		btnVoltar.setBounds(12, 416, 97, 25);
		frame.getContentPane().add(btnVoltar);

		JButton btnCriarMedicaoLuminosidade = new JButton("Criar MedicaoLuminosidade");
		btnCriarMedicaoLuminosidade.setBounds(360, 416, 120, 23);
		frame.getContentPane().add(btnCriarMedicaoLuminosidade);
		btnCriarMedicaoLuminosidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCriarMedicaoLuminosidade.setBackground(new Color(240, 230, 140));

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
				MedicaoLuminosidade medicaoLum = medLum.get(index);

				System.out.println("Vou apagar a MedicaoLuminosidade no index: " + index + "\n"
						+ "MedicaoLuminosidade com ID= " + medicaoLum.getIDMedicao() + "\n");
				bd.apagarMedicoesLuminosidade(medicaoLum.getIDMedicao());
				// falta fazer com que a window atualize a table

			}
		});
		btnCriarMedicaoLuminosidade.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				adminCriarMedicaoLuminosidade acd = new adminCriarMedicaoLuminosidade(bd);
				frame.getDefaultCloseOperation();
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				menu_Admin mA = new menu_Admin(bd);
				frame.getDefaultCloseOperation();
			}
		});
	}

}
