package MenuInvestigador;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Login.FuncoesAjuda;
import Login.JanelaBase;
import Login.Login;
import MenuAdmin.adminCriarMedicoes;
import MenuAdmin.menu_Admin;
import bancoDeDados.BancoDeDados;
import bancoDeDados.Medicoes;

import javax.swing.JList;

public class investigadorMedicoes extends JanelaBase {
	// Adicionado
	private static ArrayList<Medicoes> listaMed;

//	private JFrame frame;
//	private String userGranted;
//	public int index;
//	public static BancoDeDados bd;
//
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					investigadorMedicoes window1 = new investigadorMedicoes(bd);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//
//			}
//		});
//	}

	public investigadorMedicoes(BancoDeDados bd) {
		super(bd);
		getContentPane().setLayout(null);
		listaMed = bd.listaMedicoes();
		initialize();
	}

//	public investigadorMedicoes() {
//		initialize();
//	}

	@Override
	protected void initialize() {
		// Adicionado
		super.initialize();

//		frame = new JFrame();
//		frame.getContentPane().setBackground(Color.ORANGE);
//		frame.getContentPane().setFont(new Font("Monotype Corsiva", Font.BOLD, 16));
//		frame.setBounds(250, 250, 500, 500);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//		frame.setResizable(false);
//		frame.setVisible(true);

		JLabel lblBomDiaAcademia = new JLabel("Controlo de Culturas");
		lblBomDiaAcademia.setFont(new Font("Leelawadee", Font.BOLD, 26));
		lblBomDiaAcademia.setBounds(131, 12, 306, 37);
		frame.getContentPane().add(lblBomDiaAcademia);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/interfaceGraphic/iscte-iul_s.png")));
		lblNewLabel.setBounds(26, -11, 229, 126);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblInicieASesso = new JLabel("Consulta de Medi\u00E7\u00F5es");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(187, 157, 196, 16);
		frame.getContentPane().add(lblInicieASesso);

		JPanel panel = new JPanel();
		panel.setBounds(0, 107, 494, 37);
		frame.getContentPane().add(panel);

		JLabel lblMenu = new JLabel("Medi\u00E7\u00F5es");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));

		JLabel lblBemVindonome = new JLabel("Bem Vindo: " + bd.utilizadorLogado.NomeUtilizador);
		lblBemVindonome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBemVindonome.setBounds(174, 59, 205, 23);
		frame.getContentPane().add(lblBemVindonome);

		JScrollPane panel_1 = new JScrollPane();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(12, 183, 470, 209);
		frame.getContentPane().add(panel_1);

		// Listar Utilizadores na lista da p�gina
		// Isto est� a dar a null n sei pq
//		bd.listarUtilizador();

		// Adicionado

		Object[] columnNames = { "#", "IDCultura_fk", " IDVariavel_fk", "DataHoraMedicao", "ValorMedicao" };
		Object[][] medicoes = FuncoesAjuda.listaParaTabela(bd.listaMedicoes(), 5);
		JTable table = new JTable(medicoes, columnNames);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);

//		JList list = new JList(bd.listaUtilizadores);
//		list.setBounds(0, 0, 470, 209);
		panel_1.setViewportView(table);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.setBackground(new Color(192, 192, 192));
		btnVoltar.setBounds(12, 427, 97, 25);
		frame.getContentPane().add(btnVoltar);

		// Adicionado
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
				Medicoes med = listaMed.get(index);

				System.out.println("Vou apagar a Medicoes no index: " + index + "\n" + "Medicoes com ID= "
						+ med.getIDMedicoes() + "\n");
				bd.apagarMedicoes(med.getIDMedicoes());

			}
		});
		btnCriarMedicoes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				InvestigadorCriarMedicoes icm = new InvestigadorCriarMedicoes(bd);
				frame.getDefaultCloseOperation();
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				menu_Investigador mInve = new menu_Investigador(bd);
				frame.getDefaultCloseOperation();
			}
		});
		;

	}

//	public void saveInfile(int i) {
//		try {
//			File fac = new File(filepath + "acessos");
//			if (!fac.exists()) {
//				fac.createNewFile();
//			}
//			FileWriter write = new FileWriter(fac);
//			write.write(Integer.toString(i));
//			write.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

//	/**
//	 * @return
//	 */
//	public JFrame getFrame() {
//		return frame;
//	}
//
//	/**
//	 * @param frame
//	 */
//	public void setFrame(JFrame frame) {
//		this.frame = frame;
//	}
}