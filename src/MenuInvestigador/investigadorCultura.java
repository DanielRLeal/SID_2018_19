package MenuInvestigador;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import bancoDeDados.BancoDeDados;
import bancoDeDados.Cultura;
import bancoDeDados.Utilizador;

import javax.swing.JList;

public class investigadorCultura extends JanelaBase {

	private ArrayList<Cultura> culturas2;

	public investigadorCultura(BancoDeDados bd) {
		super(bd);
		getContentPane().setLayout(null);
		culturas2 = bd.listaCultura();
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

		JLabel lblMenu = new JLabel("Culturas");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));

		JScrollPane panel_1 = new JScrollPane();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(12, 183, 470, 209);
		frame.getContentPane().add(panel_1);

		Object[] columnNames = { "#", "Nome Cultura", "Descrição Cultura", "Utilizador" };

		Object[][] culturas = FuncoesAjuda.listaParaTabela(bd.listaCultura(), 4);

		JTable table = new JTable(culturas, columnNames);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);

		panel_1.setViewportView(table);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.setBackground(new Color(192, 192, 192));
		btnVoltar.setBounds(12, 416, 97, 25);
		frame.getContentPane().add(btnVoltar);

		JButton btnCriarCultura = new JButton("Criar Cultura");
		btnCriarCultura.setBounds(360, 416, 120, 23);
		frame.getContentPane().add(btnCriarCultura);
		btnCriarCultura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCriarCultura.setBackground(new Color(240, 230, 140));

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
				Cultura c = culturas2.get(index);

				System.out.println(
						"Vou apagar a cultura no index: " + index + "\n" + "Cultura com ID= " + c.getID() + "\n");
				bd.apagarCultura(c.getID());
				// falta fazer com que a window atualize a table

			}
		});
		btnCriarCultura.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				investigadorCriarCultura acd = new investigadorCriarCultura(bd);
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