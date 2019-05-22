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
import bancoDeDados.MedicaoTemperatura;
import bancoDeDados.MedicaoTemperatura;

/**
 * Class ListMedicoesTemp.
 */
public class ListMedicoesTemp extends JanelaBase {

	/** Lista de medicoes de temperatura. */
	private ArrayList<MedicaoTemperatura> medTemp;

	/**
	 * Instancia o ListMedicoesTemp.
	 *
	 * @param bd da coneção criada no login
	 */
	public ListMedicoesTemp(BancoDeDados bd) {
		super(bd);
		getContentPane().setLayout(null);
		medTemp = bd.listaMedicoesTemperatura();
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
				if(bd.utilizadorLogado.CategoriaProfissional.equals("Administrador")){
					menu_Admin mA = new menu_Admin(bd);
				}else{
					menu_Investigador mi = new menu_Investigador(bd);
				}
				frame.getDefaultCloseOperation();
			}
		});
	}

	/**
	 * Lbl inicie A sessao.
	 *
	 * @return the j label
	 */
	private JLabel lblInicieASesso() {
		JLabel lblInicieASesso = new JLabel("Consulta de utilizadores");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(186, 157, 196, 16);
		return lblInicieASesso;
	}

	/**
	 * Table.
	 *
	 * @return the j table
	 */
	private JTable table() {
		Object[] coTempnNames = { "#", "DataHoraMedicao", "ValorMedicaoTemperatura" };
		Object[][] MedicaoTemperaturas = FuncoesAjuda.listaParaTabela(bd.listaMedicoesTemperatura(), 3);
		JTable table = new JTable(MedicaoTemperaturas, coTempnNames);
		table.setDefaultEditor(Object.class, null);
		return table;
	}

	/**
	 * Panel.
	 *
	 * @return the j panel
	 */
	private JPanel panel() {
		JPanel panel = new JPanel();
		panel.setBounds(0, 107, 494, 37);
		JLabel lblMenu = new JLabel("MedicaoTemperaturas");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));
		return panel;
	}

}
