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
import javax.swing.JTextField;
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

public class adminUtilizadores extends JanelaBase {

	ArrayList<Utilizador> users;
	DefaultListModel<String> dlm = new DefaultListModel<>();

	public adminUtilizadores(BancoDeDados bd) {
		super(bd);
		users = removeDuplicates(bd.listarUtilizador());
		for (Utilizador u : users) {
			System.out.println(u.getNomeUtilizador());
		}
		if (dlm.isEmpty()) {
			for (Utilizador u : users) {

				dlm.addElement(u.getNomeUtilizador());
			}
		}
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

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(12, 183, 470, 209);
		frame.getContentPane().add(panel_1);

		// Listar Utilizadores na lista da página
		// Isto está a dar a null n sei pq
//		bd.listarUtilizador();
//		removeDuplicates(users);

		JList list = new JList(dlm);
		list.setBounds(0, 0, 470, 209);
		panel_1.add(list);

		JButton btnEditar = new JButton("Editar");
		JButton btnEliminar = new JButton("Ativar/Desativar");

		list.addListSelectionListener(new ListSelectionListener() {

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

		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = list.getSelectedIndex();
				Utilizador u = users.get(index);
				System.out.println(
						"Vou apagar o user no index: " + index + "\n" + "Utilizador com ID= " + u.getID() + "\n");
				bd.apagarUtilizador(u.getID(), !u.isAtivo());

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