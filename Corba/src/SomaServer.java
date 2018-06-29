import somaApp.*;
//importar a interface idl
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;


public class SomaServer {

	public static void main(String args[]) {
		try {
			ORB orb = ORB.init(args, null);
			//inicializando de conex�o
			POA rootpoa = POAHelper.narrow(orb
					.resolve_initial_references("RootPOA"));
			//abrimos o root da POA
			rootpoa.the_POAManager().activate();
//instaciar o servi�o
			SomaImpl somaImpl = new SomaImpl();
			// implementamos refer�ncia
			somaImpl.setORB(orb);
			//seteamos ORB

			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(somaImpl);
			soma href = somaHelper.narrow(ref);
			org.omg.CORBA.Object objRef = orb
					.resolve_initial_references("NameService");
			//damos nome ao servi�o
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

			String name = "Soma";
			//o nome � enviado para  a interface
			NameComponent path[] = ncRef.to_name(name);
			ncRef.rebind(path, href);
			System.out.println("Servidor de soma em espera");
			//Confirma��o do servidor conectado
			orb.run();
		} catch (Exception e) {
			System.err.println("Error: " + e);
			e.printStackTrace(System.out);
		}

		System.out.println("encerrando servidor");
	}
}
