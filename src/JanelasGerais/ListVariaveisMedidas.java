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
import MenuAdmin.adminCriarVariaveisMedidas;
import MenuAdmin.menu_Admin;
import MenuInvestigador.menu_Investigador;
import bancoDeDados.BancoDeDados;
import bancoDeDados.Medicoes;
import bancoDeDados.VariaveisMedidas;
import bancoDeDados.Utilizador;

import javax.swing.JList;

public class ListVariaveisMedidas extends JanelaBase {
	private ArrayList<VariaveisMedidas> VariaveisMedidas;

	public ListVariaveisMedidas(BancoDeDados bd) {
		super(bd);
		getContentPane().setLayout(null);
		VariaveisMedidas = bd.listaVariaveisMedidas();
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

		JLabel lblMenu = new JLabel("VariaveisMedidas");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));

		JScrollPane panel_1 = new JScrollPane();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(12, 183, 470, 209);
		frame.getContentPane().add(panel_1);

		Object[] columnNames = { "IDCultura_fk", "IDVariavel_fk", "LimiteInferior", "LimiteSuperior" };

		Object[][] VariaveisMedidass = FuncoesAjuda.listaParaTabela(VariaveisMedidas, 4);

		JTable table = new JTable(VariaveisMedidass, columnNames);
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
		
			JButton btnCriarVariaveisMedidas = new JButton("Criar VariaveisMedidas");
			btnCriarVariaveisMedidas.setBounds(360, 416, 120, 23);
			frame.getContentPane().add(btnCriarVariaveisMedidas);
			btnCriarVariaveisMedidas.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnCriarVariaveisMedidas.setBackground(new Color(240, 230, 140));
	
			JButton btnEditar = new JButton("Editar");
			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int index = table.getSelectedRow();
					VariaveisMedidas vm = VariaveisMedidas.get(index);
					
					FuncoesAjuda.getFrame().setBounds(250, 250, 500, 600);
					JTextField LimiteSuperior = new JTextField();
					LimiteSuperior.setBounds(26, 470, 116, 22);
					frame.getContentPane().add(LimiteSuperior);
					LimiteSuperior.setText(Double.toString(vm.getLimiteSuperior()));
					LimiteSuperior.setColumns(10);

					JTextField LimiteInferior = new JTextField();
					LimiteInferior.setColumns(10);
					LimiteInferior.setBounds(191, 470, 116, 22);
					LimiteInferior.setText(Double.toString(vm.getLimiteInferior()));
					frame.getContentPane().add(LimiteInferior);

					JLabel lblLimiteSuperior = new JLabel("Limite Superior");
					lblLimiteSuperior.setFont(new Font("Tahoma", Font.PLAIN, 18));
					lblLimiteSuperior.setBounds(26, 450, 110, 16);
					frame.getContentPane().add(lblLimiteSuperior);

					JLabel lblLimiteInferior = new JLabel("Limite Inferior");
					lblLimiteInferior.setFont(new Font("Tahoma", Font.PLAIN, 18));
					lblLimiteInferior.setBounds(191, 450, 110, 16);
					frame.getContentPane().add(lblLimiteInferior);

					JButton btnOkEdit = new JButton("Ok");
					btnOkEdit.setBounds(372, 520, 116, 22);
					btnOkEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
					btnOkEdit.setBackground(new Color(192, 192, 192));
					frame.getContentPane().add(btnOkEdit);

					btnOkEdit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try{
							if(LimiteSuperior.getText().isEmpty() || LimiteInferior.getText().isEmpty()){
								return;
							}
							
							bd.actualizarVariaveisMedidas(vm.getIDCultura_fk(), vm.getIDVariavel_fk(), Double.parseDouble(LimiteSuperior.getText()), Double.parseDouble(LimiteInferior.getText()));
							
							frame.setVisible(false);
							ListVariaveisMedidas lvm = new ListVariaveisMedidas(bd);
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
					VariaveisMedidas vm = VariaveisMedidas.get(index);
	
					bd.apagarVariaveisMedidas(vm.getIDCultura_fk(), vm.getIDVariavel_fk());
					
					frame.setVisible(false);
					ListVariaveisMedidas lvm = new ListVariaveisMedidas(bd);
					frame.getDefaultCloseOperation();
				}
			});
			btnCriarVariaveisMedidas.addActionListener(new ActionListener() {
	
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					adminCriarVariaveisMedidas acd = new adminCriarVariaveisMedidas(bd);
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