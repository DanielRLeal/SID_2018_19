package JanelasGerais;

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
import MenuAdmin.menu_Admin;
import MenuInvestigador.menu_Investigador;
import bancoDeDados.BancoDeDados;
import bancoDeDados.Cultura;
import bancoDeDados.Medicoes;
import bancoDeDados.Utilizador;
import bancoDeDados.Variaveis;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class ListCulturas extends JanelaBase {	
	private ArrayList<Cultura> listCulturas;

	public ListCulturas(BancoDeDados bd) {
		super(bd);
		getContentPane().setLayout(null);
		listCulturas = bd.listaCultura();
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

		Object[][] culturas = FuncoesAjuda.listaParaTabela(listCulturas, 4);

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
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = table.getSelectedRow();
				Cultura c = listCulturas.get(index);
				
				FuncoesAjuda.getFrame().setBounds(250, 250, 500, 570);
				JTextField Nome = new JTextField();
				Nome.setBounds(26, 470, 116, 22);
				Nome.setText(c.getNomeCultura());
				frame.getContentPane().add(Nome);
				Nome.setColumns(10);

				JTextField DescricaoCultura = new JTextField();
				DescricaoCultura.setColumns(10);
				DescricaoCultura.setBounds(191, 470, 116, 22);
				DescricaoCultura.setText(c.getDescricaoCultura());
				frame.getContentPane().add(DescricaoCultura);

				JTextField IDUtilizador = new JTextField();
				IDUtilizador.setColumns(10);
				IDUtilizador.setBounds(372, 470, 116, 22);
				IDUtilizador.setText(Integer.toString(c.getIDUtilizador_fk()));
				frame.getContentPane().add(IDUtilizador);

				JLabel lblNome = new JLabel("Nome");
				lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblNome.setBounds(26, 450, 110, 16);
				frame.getContentPane().add(lblNome);

				JLabel Descr = new JLabel("Descrição");
				Descr.setFont(new Font("Tahoma", Font.PLAIN, 18));
				Descr.setBounds(191, 450, 110, 16);
				frame.getContentPane().add(Descr);

				JLabel lblUtilizador = new JLabel("Utilizador");
				lblUtilizador.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblUtilizador.setBounds(372, 450, 110, 16);
				frame.getContentPane().add(lblUtilizador);

				JButton btnOkEdit = new JButton("Ok");
				btnOkEdit.setBounds(372, 500, 116, 22);
				btnOkEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
				btnOkEdit.setBackground(new Color(192, 192, 192));
				frame.getContentPane().add(btnOkEdit);

				System.out.println(table.getSelectedRow() + 1);
				System.out.println(table.getModel().getValueAt(table.getSelectedRow(), 2));
				btnOkEdit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(Nome.getText().isEmpty() || DescricaoCultura.getText().isEmpty() || IDUtilizador.getText().isEmpty()){
							return;
						}
						
						bd.actualizarCultura(c.ID, Nome.getText(), DescricaoCultura.getText(), IDUtilizador.getText());
						
						frame.setVisible(false);
						ListCulturas ac = new ListCulturas(bd);
						frame.getDefaultCloseOperation();
					}
				});
			}
		});
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
				Cultura c = listCulturas.get(index);

				System.out.println("Vou apagar a Cultura com ID= " + c.getID() + "\n");
				bd.apagarCultura(c.getID());

				frame.setVisible(false);
				ListCulturas ac = new ListCulturas(bd);
				frame.getDefaultCloseOperation();
			}
		});
		btnCriarCultura.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				CriarCultura acd = new CriarCultura(bd);
				frame.getDefaultCloseOperation();
			}
		});

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
}