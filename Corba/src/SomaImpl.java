import org.omg.CORBA.ORB;

import somaApp.somaPOA;

public class SomaImpl extends somaPOA {
	private ORB orb;
	//criar uma instância orb
	
	
	public void setORB(ORB orb_val) {
		orb = orb_val;

	}
	//defina o orb para gerar as conexões

	public int somar(int numero1, int numero2) {
		return numero1 + numero2;
	}
	//metodo q vai  enviar a soma

	public void shutdown() {
		orb.shutdown(false);
		//encera orb por parte do  servidor
	}
}

