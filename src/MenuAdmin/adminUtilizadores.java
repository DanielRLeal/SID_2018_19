package MenuAdmin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import bancoDeDados.Medicoes;
import bancoDeDados.Utilizador;

import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 * Class adminUtilizadores.
 */
public class adminUtilizadores extends JanelaBase {
	
	/** lista de utilizadores. */
	ArrayList<Utilizador> users;

	/**
	 * Instancia o adminUtilizadores.
	 *
	 * @param bd da coneção criada no login
	 */
	public adminUtilizadores(BancoDeDados bd) {
		super(bd);
		users = bd.listarUtilizador();
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

		JScrollPane panel_1 = panel_1();
		frame.getContentPane().add(panel_1);

		JTable table = table();
		panel_1.setViewportView(table);
		
		JButton btnEditar = new JButton("Editar");
		JButton btnEliminar = new JButton("Desativar");

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				btnEditar.setBounds(150, 416, 75, 23);
				frame.getContentPane().add(btnEditar);
				btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 13));
				btnEditar.setBackground(new Color(240, 230, 140));

				btnEliminar.setBounds(230, 416, 140, 23);
				frame.getContentPane().add(btnEliminar);
				btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
				btnEliminar.setBackground(new Color(240, 230, 140));
			}
		});

		// copiar para o resto das tabelas com ediï¿½ï¿½o
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = table.getSelectedRow();
				Utilizador u = users.get(index);
				
				FuncoesAjuda.getFrame().setBounds(250, 250, 500, 600);
				JTextField Nome = new JTextField();
				Nome.setBounds(26, 470, 116, 22);
				Nome.setText(u.NomeUtilizador);
				frame.getContentPane().add(Nome);
				Nome.setColumns(10);

				JTextField CategoriaProfissional = new JTextField();
				CategoriaProfissional.setColumns(10);
				CategoriaProfissional.setBounds(191, 470, 116, 22);
				CategoriaProfissional.setText(u.CategoriaProfissional);
				frame.getContentPane().add(CategoriaProfissional);

				JTextField Email = new JTextField();
				Email.setColumns(10);
				Email.setBounds(372, 470, 116, 22);
				Email.setText(u.Email);
				frame.getContentPane().add(Email);
				
				JCheckBox Ativo = new JCheckBox();
				Ativo.setBounds(26, 520, 116, 22);
				Ativo.setSelected(u.Ativo);
				frame.getContentPane().add(Ativo);

				JLabel lblNome = new JLabel("Nome");
				lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblNome.setBounds(26, 450, 110, 16);
				frame.getContentPane().add(lblNome);

				JLabel CatProf = new JLabel("Categoria");
				CatProf.setFont(new Font("Tahoma", Font.PLAIN, 18));
				CatProf.setBounds(191, 450, 110, 16);
				frame.getContentPane().add(CatProf);

				JLabel leamail = new JLabel("Email");
				leamail.setFont(new Font("Tahoma", Font.PLAIN, 18));
				leamail.setBounds(372, 450, 110, 16);
				frame.getContentPane().add(leamail);

				JLabel lblAtivo = new JLabel("Ativo");
				lblAtivo.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblAtivo.setBounds(26, 500, 110, 16);
				frame.getContentPane().add(lblAtivo);
				
				JButton btnOkEdit = new JButton("Ok");
				btnOkEdit.setBounds(372, 520, 116, 22);
				btnOkEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
				btnOkEdit.setBackground(new Color(192, 192, 192));
				frame.getContentPane().add(btnOkEdit);

				btnOkEdit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!CategoriaProfissional.getText().equals("Investigador")
								&& !CategoriaProfissional.getText().equals("Auditor")
								&& !CategoriaProfissional.getText().equals("Administrador")) {
							JOptionPane.showMessageDialog(null, "Categoria Profissional inexistente!");
							return;
						}
						
						bd.actualizarUtilizador(u.getID(), Nome.getText(), CategoriaProfissional.getText(), Email.getText(), Ativo.isSelected(), "");
						
						frame.setVisible(false);
						adminUtilizadores aCriarUti = new adminUtilizadores(bd);
						frame.setVisible(false);
					}
				});
			}
		});

		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				Utilizador u = users.get(index);
				System.out.println("Vou apagar o Utilizador com ID= " + u.getID() + "\n");
				bd.apagarUtilizador(u.getID(), false);
				
				frame.setVisible(false);
				adminUtilizadores aUti = new adminUtilizadores(bd);
				frame.setVisible(false);
			}
		});

		JButton button_1 = new JButton("Criar conta");
		button_1.setBounds(380, 416, 102, 23);
		frame.getContentPane().add(button_1);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button_1.setBackground(new Color(240, 230, 140));
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				adminCriarUtilizador aCriarUti = new adminCriarUtilizador(bd);
				frame.setVisible(false);
			}
		});

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.setBackground(new Color(192, 192, 192));
		btnVoltar.setBounds(12, 416, 97, 25);
		frame.getContentPane().add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				menu_Admin mA = new menu_Admin(bd);
				frame.getDefaultCloseOperation();
			}
		});
	}

	/**
	 * Panel 1.
	 *
	 * @return the j scroll pane
	 */
	private JScrollPane panel_1() {
		JScrollPane panel_1 = new JScrollPane();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(12, 183, 470, 209);
		return panel_1;
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
		Object[] columnNames = { "#", "Nome Utilizador", "Categoria Profissional", "Email", "Activo" };
		Object[][] culturas = FuncoesAjuda.listaParaTabela(users, 5);
		JTable table = new JTable(culturas, columnNames);
		table.setDefaultEditor(Object.class, null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
		JLabel lblMenu = new JLabel("Utilizadores");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));
		return panel;
	}
}