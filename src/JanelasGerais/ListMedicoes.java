package JanelasGerais;

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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Login.FuncoesAjuda;
import Login.JanelaBase;
import MenuAdmin.menu_Admin;
import MenuInvestigador.menu_Investigador;
import bancoDeDados.BancoDeDados;
import bancoDeDados.Medicoes;

public class ListMedicoes extends JanelaBase {

	private ArrayList<Medicoes> medicoes = new ArrayList<>();
	
	public ListMedicoes(BancoDeDados bd) {
		super(bd);
		getContentPane().setLayout(null);
		medicoes = bd.listaMedicoes();
		initialize();
	}

	@Override
	protected void initialize() {
		super.initialize();

		JLabel lblInicieASesso = lblInicieASesso();
		frame.getContentPane().add(lblInicieASesso);

		JPanel panel = panel();
		frame.getContentPane().add(panel);

		JScrollPane panel_1 = panel_1();
		frame.getContentPane().add(panel_1);

		JTable table = table();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = table.getSelectedRow();
				Medicoes m = medicoes.get(index);
				
				FuncoesAjuda.getFrame().setBounds(250, 250, 500, 600);
				JTextField idMedicao = new JTextField();
				idMedicao.setBounds(26, 470, 116, 22);
				frame.getContentPane().add(idMedicao);
				idMedicao.setEnabled(false);
				idMedicao.setText(Integer.toString(m.getIDMedicoes()));
				idMedicao.setColumns(10);

				JTextField IDCultura = new JTextField();
				IDCultura.setColumns(10);
				IDCultura.setBounds(191, 470, 116, 22);
				IDCultura.setText(Integer.toString(m.getIDCultura_fk()));
				frame.getContentPane().add(IDCultura);

				JTextField ValorMedicao = new JTextField();
				ValorMedicao.setColumns(10);
				ValorMedicao.setBounds(372, 470, 116, 22);
				ValorMedicao.setText(Double.toString(m.getValorMedicao()));
				frame.getContentPane().add(ValorMedicao);
				
				JTextField dataHora = new JTextField();
				dataHora.setColumns(10);
				dataHora.setBounds(26, 520, 116, 22);
				dataHora.setText(m.getDataHoraMedicaoString());
				frame.getContentPane().add(dataHora);
				
				JTextField IDVariavel = new JTextField();
				IDVariavel.setColumns(10);
				IDVariavel.setBounds(191, 520, 116, 22);
				IDVariavel.setText(Integer.toString(m.getIDVariavel_fk()));
				frame.getContentPane().add(IDVariavel);

				JLabel lblIDMedicao = new JLabel("IDMedicao");
				lblIDMedicao.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblIDMedicao.setBounds(26, 450, 110, 16);
				frame.getContentPane().add(lblIDMedicao);

				JLabel lblCultura = new JLabel("IDCultura");
				lblCultura.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblCultura.setBounds(191, 450, 110, 16);
				frame.getContentPane().add(lblCultura);

				JLabel lblValorMedicao = new JLabel("ValorMedicao");
				lblValorMedicao.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblValorMedicao.setBounds(372, 450, 110, 16);
				frame.getContentPane().add(lblValorMedicao);
				
				JLabel lblDataHora = new JLabel("Data Hora");
				lblDataHora.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblDataHora.setBounds(29, 500, 110, 16);
				frame.getContentPane().add(lblDataHora);
				
				JLabel lblIDVariavel = new JLabel("IDVariavel");
				lblIDVariavel.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblIDVariavel.setBounds(191, 500, 110, 16);
				frame.getContentPane().add(lblIDVariavel);

				JButton btnOkEdit = new JButton("Ok");
				btnOkEdit.setBounds(372, 520, 116, 22);
				btnOkEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
				btnOkEdit.setBackground(new Color(192, 192, 192));
				frame.getContentPane().add(btnOkEdit);

				btnOkEdit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
						if(IDCultura.getText().isEmpty() || IDVariavel.getText().isEmpty() || dataHora.getText().isEmpty() || ValorMedicao.getText().isEmpty()){
							return;
						}
						
						bd.actualizarMedicoes(m.getIDMedicoes(), 
								Integer.parseInt(IDCultura.getText()),
								Integer.parseInt(IDVariavel.getText()),
								dataHora.getText(),
								Double.parseDouble(ValorMedicao.getText()));
						
						frame.setVisible(false);
						ListMedicoes am = new ListMedicoes(bd);
						frame.getDefaultCloseOperation();
						} catch(NumberFormatException e1) {
					        return; 
					    }
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
				Medicoes m = medicoes.get(index);
				
				System.out.println("Vou apagar a Medicoes no index: " + index + "\n" + "Medicoes com ID= " + m.getIDMedicoes() + "\n");
				bd.apagarMedicoes(m.getIDMedicoes());
				
				frame.setVisible(false);
				ListMedicoes am = new ListMedicoes(bd);
				frame.getDefaultCloseOperation();
			}
		});
		btnCriarMedicoes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				CriarMedicao acd = new CriarMedicao(bd);
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

	private JScrollPane panel_1() {
		JScrollPane panel_1 = new JScrollPane();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(12, 183, 470, 209);
		JTable table = table();
		panel_1.setViewportView(table);
		return panel_1;
	}

	private JLabel lblInicieASesso() {
		JLabel lblInicieASesso = new JLabel("Consulta de Medicoes");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(186, 157, 196, 16);
		return lblInicieASesso;
	}

	private JTable table() {
		Object[] columnNames = { "#", "Cultura", " Vari�vel", "Data Hora Medi��o", "Valor Medi��o" };
		Object[][] Medicoes = FuncoesAjuda.listaParaTabela(medicoes, 5);
		JTable table = new JTable(Medicoes, columnNames);
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