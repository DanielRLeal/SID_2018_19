package Login;

import javax.swing.JFrame;

import bancoDeDados.BancoDeDados;

/**
 * Class JanelaBase da qual o resto das janelas v�o derivar.
 */
public class JanelaBase extends JFrame {
	
	/** The frame. */
	protected JFrame frame;
	
	/** The bd. */
	public BancoDeDados bd;
	
	/** The menu. */
	boolean menu = false;
	
	/**
	 * Instancia a JanelaBase.
	 *
	 * @param bd da cone��o criada no login
	 */
	protected JanelaBase(BancoDeDados bd){
		this.bd = bd;
	}
	
	/**
	 * Instancia a JanelaBase.
	 *
	 * @param bd da cone��o criada no login
	 * @param menu indica se a janela � menu
	 */
	protected JanelaBase(BancoDeDados bd, boolean menu){
		this.bd = bd;
		this.menu = menu;
	}
	
	/**
	 * Initialize.
	 */
	protected void initialize(){
		if(bd == null)
			frame = FuncoesAjuda.CriarJanelaVazia();
		else if(menu)
			frame = FuncoesAjuda.CriarJanelaMenu(bd.utilizadorLogado.NomeUtilizador);
		else
			frame = FuncoesAjuda.CriarJanelaContent(bd.utilizadorLogado.NomeUtilizador);
	}
}
