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
	
	//buscar un cliente
	public int buscarCliente(String dni) {
		
		int pos = -1;
		
		int i = 0;
		
		boolean existe = false;
		
		while (i<nClientes && !existe) {
			
			if(this.clientes[i].getNif().equals(dni)) {
				pos = i;
				existe = true;
			}			
		i++;
		}
		
		return pos;
	}
	
	
	public int nClienteMovil() {
		
		int contadorMovil = 0;
		
		for (int i = 0; i < nClientes; i++) {
			
			if(clientes[i] instanceof ClienteMovil) //como el typeid
				contadorMovil++;
		}
		
		return contadorMovil;
	}
	
	
	//Equivalente a altaCliente
	public void alta(Cliente c) {
		
		if(c==null || buscarCliente(c.getNif())!=-1)
			return; 
		
		clientes[nClientes++]=c;
		
		if(nClientes == clientes.length) {
			Cliente[] tmp = new Cliente[clientes.length+INCREMENTO]; //si está lleno hay q aumentar tamaño
			
			for(int i = 0; i < clientes.length; i++)
                tmp[i] = clientes[i]; //copio info
			
			
			clientes = tmp;
		}
	}
	
	
	//equivalente a crearContrato
	public void alta() {
		//verificar si existe
		Scanner s = new Scanner(System.in);
		
	    String dni;
	    
	    System.out.println("DNI: ");
	    
	    dni = s.nextLine();

	    int pos=this.buscarCliente(dni); //i=pos del cliente

	    
	    if(pos!=-1) { //dar de alta al cliente
	    	System.out.println("Ya existe un cliente con ese DNI");
	    	System.out.println(clientes[pos]);
	    }
	    //si no existe pido info
	    else {
	        Cliente c = null;
	        
	        String nombre;
	        
	        Fecha fNac, fAlta;
	        
	        float minutosHablados;
	        
	        System.out.println("Nombre: ");
	        nombre = s.nextLine();
	        
			System.out.println("Fecha de Nacimiento: ");
			fNac = Fecha.pedirFecha();
			
			System.out.println("Fecha de Alta: ");
			fAlta = Fecha.pedirFecha();
			
	        System.out.println("Minutos que habla al mes: ");
	        minutosHablados = s.nextFloat();
	        
	        System.out.println("Indique tipo de cliente (1-Movil, 2-Tarifa Plana): ");
	        int tipo;
	        
	        tipo=s.nextInt();
	        
	        //diferencio el tipo de contrato
	        if(tipo==1) {
	        	System.out.println("Precio por minuto: ");
	        	float precio;
	        	
		        precio=s.nextFloat();
	        	System.out.println("Fecha fin permanencia: ");
	        	
		        Fecha FPer = Fecha.pedirFecha();
	        	c = new ClienteMovil(dni, nombre, fNac, fAlta, FPer, minutosHablados, precio);
	        }
	        
	        else if (tipo==2) {
	        	String nacionalidad;
                System.out.print("Nacionalidad: ");
                
                nacionalidad = s.nextLine();

                c = new ClienteTarifaPlana(dni, nombre, fNac, fAlta, minutosHablados, nacionalidad);
	        }
	        
	        //lo doy de alta llamando al metodo anterior 
	        alta(c);
	        
	    }
	
	}
	
	
	public int baja() {
		
		return 0;
	}
	
	
	public float factura() {
		
		return 0;
	}
	
	public void descuento (int dto) {
		
		float precio = 0;
		
		float factor = 1.0f - dto/100.0f;
		
		for(int i = 0; i < nClientes; i++) {
			
			//equivalente a typeid
			if(clientes[i] instanceof ClienteMovil){
				
				ClienteMovil c = (ClienteMovil) clientes[i];
				
				precio = c.getPrecio() * factor;
				
				c.setPrecioMin(precio);
				
			}
		}
	}
	
	
	@Override
	public void ver() {
		
		System.out.println(this);
		
	}
	
	public String toString() {
		
		String texto = "";
		
		for(int i = 0; i < nClientes; i++)
            texto = texto + clientes[i]+"\n";
        
        return texto;
	}
	
	public Object clone() {
		
	}
	

}
