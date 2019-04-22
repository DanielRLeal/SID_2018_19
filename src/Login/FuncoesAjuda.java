package Login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FuncoesAjuda {
	public static JFrame CriarJanelaVazia(){
		return CriarJanelaContent(null);
	}
	
	public static JFrame CriarJanelaContent(String UserName){
		JFrame frame = new JFrame();
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.getContentPane().setFont(new Font("Monotype Corsiva", Font.BOLD, 16));
		frame.setBounds(250, 250, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		JLabel lblTitulo = new JLabel("Controlo de Culturas");
		lblTitulo.setFont(new Font("Leelawadee", Font.BOLD, 26));
		lblTitulo.setBounds(131, 12, 306, 37);
		frame.getContentPane().add(lblTitulo);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Login/iscte-iul_s.png")));
		lblNewLabel.setBounds(26, -11, 229, 126);
		frame.getContentPane().add(lblNewLabel);
		
		if(UserName != null && !UserName.equals("")){
			JLabel lblBemVindonome = new JLabel("Bem Vindo: " + UserName);
			lblBemVindonome.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblBemVindonome.setBounds(174, 59, 205, 23);
			frame.getContentPane().add(lblBemVindonome);
		}
		
		return frame;
	}
	
	//O tipo generico serve para definir qual a classe a retornar
	public static JFrame CriarJanelaMenu(String UserName){
		JFrame frame = CriarJanelaContent(UserName);

		JLabel lblInicieASesso = new JLabel("Escolha uma op\u00E7\u00E3o");
		lblInicieASesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicieASesso.setBounds(196, 154, 196, 16);
		frame.getContentPane().add(lblInicieASesso);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 107, 494, 37);
		frame.getContentPane().add(panel);

		JLabel lblMenu = new JLabel("Menu");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Leelawadee", Font.PLAIN, 24));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.setBackground(new Color(192, 192, 192));
		btnVoltar.setBounds(10, 427, 97, 25);
		frame.getContentPane().add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Login login = new Login();
				frame.getDefaultCloseOperation();
			}
		});
		
		return frame;
	}
}
