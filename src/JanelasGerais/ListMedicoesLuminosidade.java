package JanelasGerais;

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
import MenuAdmin.menu_Admin;
import MenuInvestigador.menu_Investigador;
import bancoDeDados.BancoDeDados;
import bancoDeDados.MedicaoLuminosidade;
import bancoDeDados.MedicaoLuminosidade;

public class ListMedicoesLuminosidade extends JanelaBase {

	private ArrayList<MedicaoLuminosidade> medLum;

	public ListMedicoesLuminosidade(BancoDeDados bd) {
		super(bd);
		getContentPane().setLayout(null);
		medLum = bd.listaMedicoesLuminosidade();
		initialize();
	}

	@Override
	protected void initialize() {
		super.initialize();

		JLabel lblInicieASesso = lblInicieASesso();
		frame.getContentPane().add(lblInicieASesso);

		JPanel panel = panel();
		frame.getContentPane().add(panel);

		JScrollPane panel_1 = new JScrollPane();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(12, 183, 470, 209);
		frame.getContentPane().add(panel_1);

		JTable table = table();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_1.setViewportView(table);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.setBackground(new Color(192, 192, 192));
		btnVoltar.setBounds(12, 416, 97, 25);
		frame.getContentPane().add(btnVoltar);

//		JButton btnCriarMedicaoLuminosidade = new JButton("Criar MedicaoLuminosidade");
//		btnCriarMedicaoLuminosidade.setBounds(360, 416, 120, 23);
//		frame.getContentPane().add(btnCriarMedicaoLuminosidade);
//		btnCriarMedicaoLuminosidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		btnCriarMedicaoLuminosidade.setBackground(new Color(240, 230, 140));
//
//		JButton btnEditar = new JButton("Editar");
//		JButton btnEliminar = new JButton("Eliminar");
//
//		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				btnEditar.setBounds(150, 416, 75, 23);
//				frame.getContentPane().add(btnEditar);
//				btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 13));
//				btnEditar.setBackground(new Color(240, 230, 140));
//
//				btnEliminar.setBounds(230, 416, 100, 23);
//				frame.getContentPane().add(btnEliminar);
//				btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
//				btnEliminar.setBackground(new Color(240, 230, 140));
//			}
//		});
//
//		btnEliminar.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int index = table.getSelectedRow();
//				MedicaoLuminosidade medicaoLum = medLum.get(index);
//
//				System.out.println("Vou apagar a MedicaoLuminosidade no index: " + index + "\n"
//						+ "MedicaoLuminosidade com ID= " + medicaoLum.getIDMedicao() + "\n");
//				bd.apagarMedicoesLuminosidade(medicaoLum.getIDMedicao());
//				// falta fazer com que a window atualize a table
//
//			}
//		});
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				if(bd.utilizadorLogado.CategoriaProfissional.equals("Administrador")){
					menu_Admin mA = new menu_Admin(bd);
				}else{
					menu_Investigador mi = new menu_Investigador(bd);
				}
				frame.getDefaultCloseOperation();
			}
		});
	}

	private JLabel lblInicieASesso() {
		JLabel lblInicieASesso = new JLabel("Consulta de utilizadores");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(186, 157, 196, 16);
		return lblInicieASesso;
	}

	private JTable table() {
		Object[] columnNames = { "#", "DataHoraMedicao", "ValorMedicaoLuminosidade" };
		Object[][] MedicaoLuminosidades = FuncoesAjuda.listaParaTabela(bd.listaMedicoesLuminosidade(), 3);
		JTable table = new JTable(MedicaoLuminosidades, columnNames);
		table.setDefaultEditor(Object.class, null);
		return table;
	}

	private JPanel panel() {
		JPanel panel = new JPanel();
		panel.setBounds(0, 107, 494, 37);
		JLabel lblMenu = new JLabel("MedicaoLuminosidades");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));
		return panel;
	}

}
