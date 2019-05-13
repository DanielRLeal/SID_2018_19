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
import bancoDeDados.Utilizador;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class adminUtilizadores extends JanelaBase {
	private static JTextField Nome;
	private static JTextField CategoriaProfissional;
	private static JTextField Email;
	// ArrayList<Utilizador> users;
	// DefaultListModel<String> dlm = new DefaultListModel<>();

	public adminUtilizadores(BancoDeDados bd) {
		super(bd);
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

		JLabel lblMenu = new JLabel("Utilizadores");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));

		JScrollPane panel_1 = new JScrollPane();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(12, 183, 470, 209);
		frame.getContentPane().add(panel_1);

		Object[] columnNames = { "#", "Nome Utilizador", "Categoria Profissional", "Email", "Activo" };

		Object[][] culturas = FuncoesAjuda.listaParaTabela(bd.listarUtilizador(), 5);

		JTable table = new JTable(culturas, columnNames);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);

		panel_1.setViewportView(table);

		JButton btnEditar = new JButton("Editar");
		JButton btnEliminar = new JButton("Ativar/Desativar");

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

		// copiar para o resto das tabelas com edição
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FuncoesAjuda.getFrame().setBounds(250, 250, 500, 570);
				Nome = new JTextField();
				Nome.setBounds(26, 470, 116, 22);
				frame.getContentPane().add(Nome);
				Nome.setColumns(10);

				CategoriaProfissional = new JTextField();
				CategoriaProfissional.setColumns(10);
				CategoriaProfissional.setBounds(191, 470, 116, 22);
				frame.getContentPane().add(CategoriaProfissional);

				Email = new JTextField();
				Email.setColumns(10);
				Email.setBounds(372, 470, 116, 22);
				frame.getContentPane().add(Email);

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

				JButton btnOkEdit = new JButton("Ok");
				btnOkEdit.setBounds(372, 500, 116, 22);
				btnOkEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
				btnOkEdit.setBackground(new Color(192, 192, 192));
				frame.getContentPane().add(btnOkEdit);

				System.out.println(table.getSelectedRow() + 1);
				System.out.println(table.getModel().getValueAt(table.getSelectedRow(), 2));
				btnOkEdit.addActionListener(new ActionListener() {
					// o table.getselectedrow() + 1 : funciona bem para tabelas q nunca se apagam
					// linhas - ID é certo.
					// arranjar outra soluçao
					public void actionPerformed(ActionEvent e) {

						if (CategoriaProfissional.getText() != "Investigador"
								|| CategoriaProfissional.getText() != "Auditor"
								|| CategoriaProfissional.getText() != "Admin") {
							JOptionPane.showMessageDialog(null, "Categoria Profissional inexistente!");
						}

						// Onde está null substituir pelo get da celula que não vai ser alterada.
						// btw isto vai necessitar de um codesmellzinho e melhorias
						if (CategoriaProfissional.getText().isEmpty()) {
							bd.actualizarUtilizador(table.getSelectedRow() + 1, Nome.toString(), null, Email.toString(),
									true);
						}

						if (Nome.getText().isEmpty() && Email.getText().isEmpty()) {
							bd.actualizarUtilizador(table.getSelectedRow() + 1, Nome.toString(),
									CategoriaProfissional.toString(), Email.toString(), true);
						}
						if (Nome.getText().isEmpty() && CategoriaProfissional.getText().isEmpty()) {
							bd.actualizarUtilizador(table.getSelectedRow() + 1, null, null, Email.toString(), true);
						}
						if (CategoriaProfissional.getText().isEmpty() && Email.getText().isEmpty()) {
							bd.actualizarUtilizador(table.getSelectedRow() + 1, Nome.toString(), null, null, true);
						}
						if (Nome.getText().isEmpty()) {
							bd.actualizarUtilizador(table.getSelectedRow() + 1, null, CategoriaProfissional.toString(),
									Email.toString(), true);
						}
						if (Email.getText().isEmpty()) {
							bd.actualizarUtilizador(table.getSelectedRow() + 1, Nome.toString(),
									CategoriaProfissional.toString(), null, true);
						}

						if (CategoriaProfissional.getText().isEmpty() && Nome.getText().isEmpty()
								&& Email.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Precisa inserir dados para editar!");
						}
						bd.actualizarUtilizador(table.getSelectedRow() + 1, Nome.toString(),
								CategoriaProfissional.toString(), Email.toString(), true);

//						if (CategoriaProfissional.getText().isEmpty() && Nome.getText().isEmpty()
//								&& Email.getText().isEmpty()) {
//							JOptionPane.showMessageDialog(null, "Precisa inserir dados para editar!");
//							return;
//						}
//						if (CategoriaProfissional.getText() != "Investigador"
//								|| CategoriaProfissional.getText() != "Auditor"
//								|| CategoriaProfissional.getText() != "Admin") {
//							JOptionPane.showMessageDialog(null, "Categoria Profissional inexistente!");
//						}
						int i = table.getSelectedRow();
//						// Onde está null substituir pelo get da celula que não vai ser alterada.
//						// btw isto vai necessitar de um codesmellzinho e melhorias
//						if (CategoriaProfissional.getText().isEmpty()) {
//							bd.actualizarUtilizador(i + 1, Nome.toString(),
//									table.getModel().getValueAt(i, 2).toString(), Email.toString(), true);
//						}
//						if (Nome.getText().isEmpty() && Email.getText().isEmpty()) {
//							bd.actualizarUtilizador(table.getSelectedRow() + 1,
//									table.getModel().getValueAt(i, 1).toString(), CategoriaProfissional.toString(),
//									table.getModel().getValueAt(i, 3).toString(), true);
//						}
//						if (Nome.getText().isEmpty() && CategoriaProfissional.getText().isEmpty()) {
//							bd.actualizarUtilizador(table.getSelectedRow() + 1,
//									table.getModel().getValueAt(i, 1).toString(),
//									table.getModel().getValueAt(i, 2).toString(), Email.toString(), true);
//						}
//						if (CategoriaProfissional.getText().isEmpty() && Email.getText().isEmpty()) {
//							bd.actualizarUtilizador(table.getSelectedRow() + 1, Nome.toString(),
//									table.getModel().getValueAt(i, 2).toString(),
//									table.getModel().getValueAt(i, 3).toString(), true);
//						}
//						if (Nome.getText().isEmpty()) {
//							bd.actualizarUtilizador(table.getSelectedRow() + 1,
//									table.getModel().getValueAt(i, 1).toString(), CategoriaProfissional.toString(),
//									Email.toString(), true);
//						}
//						if (Email.getText().isEmpty()) {
//							bd.actualizarUtilizador(table.getSelectedRow() + 1, Nome.toString(),
//									CategoriaProfissional.toString(), table.getModel().getValueAt(i, 3).toString(),
//									true);
//						}
						bd.actualizarUtilizador(i + 1, table.getModel().getValueAt(i, 1).toString(),
								table.getModel().getValueAt(i, 2).toString(),
								table.getModel().getValueAt(i, 3).toString(), true);

					}
				});
			}
		});

		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int column = 0;
				int row = table.getSelectedRow();
				int id = (int) table.getModel().getValueAt(row, column);
				System.out.println("Vou apagar o Utilizador com ID= " + id + "\n");
				bd.apagarUtilizador(id, false);

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

	public static ArrayList<Utilizador> removeDuplicates(ArrayList<Utilizador> list) {
		ArrayList<Utilizador> newList = new ArrayList<>();
		for (Utilizador element : list) {
			if (!newList.contains(element)) {
				newList.add(element);
			}
		}
		return newList;
	}

}