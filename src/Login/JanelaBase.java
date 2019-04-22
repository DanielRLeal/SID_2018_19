package Login;

import javax.swing.JFrame;

import bancoDeDados.BancoDeDados;

public class JanelaBase extends JFrame {
	protected JFrame frame;
	public BancoDeDados bd;
	boolean menu = false;
	
	protected JanelaBase(BancoDeDados bd){
		this.bd = bd;
	}
	
	protected JanelaBase(BancoDeDados bd, boolean menu){
		this.bd = bd;
		this.menu = menu;
	}
	
	protected void initialize(){
		if(bd == null)
			frame = FuncoesAjuda.CriarJanelaVazia();
		else if(menu)
			frame = FuncoesAjuda.CriarJanelaMenu(bd.utilizadorLogado.NomeUtilizador);
		else
			frame = FuncoesAjuda.CriarJanelaContent(bd.utilizadorLogado.NomeUtilizador);
	}
}
