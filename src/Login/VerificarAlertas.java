package Login;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import bancoDeDados.Alerta;
import bancoDeDados.BancoDeDados;

public class VerificarAlertas implements Runnable {

	private BancoDeDados bd;
	
    public VerificarAlertas(BancoDeDados bd) {
    	this.bd = bd;
    }

    public void run() {
        while(true){
        	try {
        		ArrayList<Alerta> alert = bd.verificarAlertas();
        		JOptionPane.showMessageDialog(null, "ola");
        		if(alert != null){
	        		for (Alerta alerta : alert) {
	        			String mensagem = "Alerta da variavel " + alerta.getNomeVariavel();
	        			
						if(alerta.getEmailUtilizador() != null && !alerta.getEmailUtilizador().isEmpty()){
							//envia email para o utilizador, alerta destinado ao investigador
						}else{
							//envia email para email generico, alerta do sensor
						}
						
						JOptionPane.showMessageDialog(null, mensagem);
					}
        		}
        		
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}