package MenuAdmin;

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

import Login.FuncoesAjuda;
import Login.JanelaBase;
import bancoDeDados.Alertas_Log;
import bancoDeDados.BancoDeDados;
import bancoDeDados.Medicoes;
import bancoDeDados.Medicoes_Log;
import bancoDeDados.Utilizador_Log;

public class admin_LogMedicoes extends JanelaBase {

	private ArrayList<Medicoes_Log> medicoes_log;

	public admin_LogMedicoes(BancoDeDados bd) {
		super(bd);
		getContentPane().setLayout(null);
		medicoes_log = bd.listarMedicoes_Log();
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

		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				menu_Admin_Logs mA = new menu_Admin_Logs(bd);
				frame.getDefaultCloseOperation();
			}
		});
	}

	private JLabel lblInicieASesso() {
		JLabel lblInicieASesso = new JLabel("Log de Medi��es");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(186, 157, 196, 16);
		return lblInicieASesso;
	}

	private JTable table() {
		Object[] columnNames = { "IDLog", "IDLogUtilizador", " IDMedicoes", "IDCultura", "IDVariavel",
				"DataHoraMedicao", "ValorMedicao", "Operacao", "Data" };
		Object[][] logutilziadores = FuncoesAjuda.listaParaTabela(bd.listarMedicoes_Log(), 20);
		JTable table = new JTable(logutilziadores, columnNames);
		table.setDefaultEditor(Object.class, null);
		return table;
	}

	private JPanel panel() {
		JPanel panel = new JPanel();
		panel.setBounds(0, 107, 494, 37);
		JLabel lblMenu = new JLabel("Medi��es");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));
		return panel;
	}
}