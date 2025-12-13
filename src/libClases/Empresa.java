package libClases;

import java.util.Scanner;

public class Empresa implements Cloneable, Proceso{
	
	
	
	//atributos
	
	private Cliente[] clientes;
	private int nClientes;
	private final int INCREMENTO = 5;
	
	
	//constructores
	public Empresa() {
		
		this.clientes = new Cliente [INCREMENTO];
		
		nClientes=0;
		
	}
	
	//getters
	
	public int getn () { return this.nClientes;  }
	
	
	//metodos
	
	public float factura() {
		
		return 0;
	}
	
	public float descuento (int dto) {
		
		return 0;
	}
	
	public int nClienteMovil() {
		
		int contadorMovil = 0;
		
		for (int i = 0; i < nClientes; i++) {
			
			if(clientes[i] instanceof ClienteMovil) //como el typeid
				contadorMovil++;
		}
		
		return contadorMovil;
	}
	
	
	public int alta() {
		
		return 0;
		
	}
	
	
	public int baja() {
		
		return 0;
	}
	
	
	@Override
	public void ver() {
		
		System.out.println(this);
		
	}
	
	public String toString () {
		
	}
	
	

}
