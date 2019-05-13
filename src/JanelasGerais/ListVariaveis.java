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
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Login.FuncoesAjuda;
import Login.JanelaBase;
import MenuAdmin.adminCriarVariaveis;
import MenuAdmin.menu_Admin;
import MenuInvestigador.menu_Investigador;
import bancoDeDados.BancoDeDados;
import bancoDeDados.Variaveis;
import bancoDeDados.Variaveis;

public class ListVariaveis extends JanelaBase {

	private ArrayList<Variaveis> variaveis;

	public ListVariaveis(BancoDeDados bd) {
		super(bd);
		getContentPane().setLayout(null);
		variaveis = bd.listarVariaveis();
		initialize();
	}

	@Override
	protected void initialize() {
		super.initialize();

		JLabel lblInicieASesso = new JLabel("Consulta de Variaveis");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(186, 157, 196, 16);
		frame.getContentPane().add(lblInicieASesso);

		JPanel panel = new JPanel();
		panel.setBounds(0, 107, 494, 37);
		frame.getContentPane().add(panel);

		JLabel lblMenu = new JLabel("Variaveis");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));

		JScrollPane panel_1 = new JScrollPane();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(12, 183, 470, 209);
		frame.getContentPane().add(panel_1);

		Object[] columnNames = { "#", "Nome Variaveis", "Nome Cultura" };

		Object[][] Vars = FuncoesAjuda.listaParaTabela(variaveis, 3);

		JTable table = new JTable(Vars, columnNames);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);

		panel_1.setViewportView(table);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.setBackground(new Color(192, 192, 192));
		btnVoltar.setBounds(12, 416, 97, 25);
		frame.getContentPane().add(btnVoltar);

		if(bd.utilizadorLogado.CategoriaProfissional.equals("Administrador")
				|| bd.utilizadorLogado.ID == 0){
			
			JButton btnCriarVariaveis = new JButton("Criar Variaveis");
			btnCriarVariaveis.setBounds(360, 416, 120, 23);
			frame.getContentPane().add(btnCriarVariaveis);
			btnCriarVariaveis.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnCriarVariaveis.setBackground(new Color(240, 230, 140));
			
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
					Variaveis v = variaveis.get(index);
	
					System.out.println("Vou apagar a Variavel no index: " + index + "\n" + "Variavel com ID = " + v.getIDVariaveis() + "\n");
					bd.apagarVariaveis(v.getIDVariaveis());
					
					frame.setVisible(false);
					ListVariaveis acd = new ListVariaveis(bd);
					frame.getDefaultCloseOperation();
				}
			});
			btnCriarVariaveis.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					adminCriarVariaveis acd = new adminCriarVariaveis(bd);
					frame.getDefaultCloseOperation();
				}
			});
		}

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