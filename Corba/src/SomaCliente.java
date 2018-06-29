import java.util.Scanner;
import somaApp.*;
//importar a interface idl
import org.omg.CosNaming.*;
import org.omg.CORBA.*;

public class SomaCliente {
	static soma SomaImpl;

	public static void main(String args[]) {
		Scanner sc = new Scanner (System.in);

		try {
			ORB orb = ORB.init(args, null);
			//inicializar orb para enviar pedido
			org.omg.CORBA.Object objRef = orb
					.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

			String name = "Soma";
			SomaImpl = somaHelper.narrow(ncRef.resolve_str(name));
			// System.out.println("Obtendo os cabeçalhos do objeto servidor:
			// "+sumaImpl);
			System.out.println("digite valor de a:");
			int a = sc.nextInt();
			System.out.println("digite valor de b:");
			int b = sc.nextInt();
			System.out.println("soma é:"
					+ Integer.toString(SomaImpl.somar(a, b)));
			SomaImpl.shutdown();
		} catch (Exception e) {
			System.out.println("Error: " + e);
			e.printStackTrace(System.out);
	
		}
	}
}