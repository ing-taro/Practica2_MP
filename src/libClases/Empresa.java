package libClases;

import java.util.Scanner;

public class Empresa implements Cloneable, Proceso{
	
	//FALTA BAJA Y FACTURA
	
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
	
	public int getN () { return this.nClientes;  }
	
	
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
	
	
	public void baja(String dni) {
		
		//Scanner s = new Scanner(System.in); //para introducir por pantalla
		
		int pos = buscarCliente(dni);
		
		if(pos != -1)
			
			for(int i = pos; i < nClientes; i++)
				
                clientes[i] = clientes[i+1];
                
            nClientes--;
            
            if(nClientes < clientes.length - INCREMENTO){
            	
                Cliente[] tmp = new Cliente[clientes.length-INCREMENTO];
                
                for(int i = 0; i < tmp.length; i++)
                    tmp[i] = clientes[i];
                
                clientes = tmp;
            }
		}
			
	
	public void baja() {
		
		Scanner s = new Scanner(System.in);
		
		
		System.out.print("Introduzca nif cliente a dar de baja: ");
		String dni = s.nextLine();
		
        int pos = buscarCliente(dni);
        
        if(pos!=-1) {
			System.out.println(clientes[pos]);
			System.out.println("¿Seguro que desea eliminarlo (s/n)?");
			
				
			if(s.nextLine().equals("s")){
				Cliente c = clientes[pos];
				baja(dni);
                System.out.println("El cliente "+c.getNombre()+" con nif "+c.getNif()+" ha sido eliminado.\n");
                
			}
			
			else
				System.out.println("El cliente con nif "+clientes[pos].getNif()+" no se elimina");
				
	       }
        
        else {
        	System.out.println("No se ha encontrado el cliente.");
        	
        }
		
		
	}
	
	public float factura() {
		
		float total=0;
		
		for(int i=0;i<nClientes;i++) {
			total=total+clientes[i].factura();
		}
		
		return total;
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
	
	
	public void totalMayorFacturaPorTipo() {
	   
	    int cMovil = 0, cInternet = 0, cTarifa = 0;
	    
	    float totalMovil = 0, totalInternet = 0, totalTarifa = 0;

	    for(int i = 0; i < nClientes; i++) {
	        Cliente c = clientes[i];

	        if (c instanceof ClienteInternetMovil) {
	            cInternet++;
	            totalInternet += ((ClienteInternetMovil) c).sumaFacturas();
	        }

	        else if (c instanceof ClienteMovil) {
	            cMovil++;
	            totalMovil += ((ClienteMovil) c).factura();
	        }
	        
	        else if (c instanceof ClienteTarifaPlana) {
	            cTarifa++;
	            totalTarifa += ((ClienteTarifaPlana) c).factura();
	        }
	    }


	    System.out.println("Contratos Movil: " + cMovil);
	    System.out.println("Contratos Internet: " + cInternet);
	    System.out.println("Contratos Tarifa Plana: " + cTarifa);


	    if (totalInternet >= totalMovil && totalInternet >= totalTarifa) {
	        System.out.println("El mayor total por tipo de contrato es el de ClienteInternetMovil con un acumulado de " + totalInternet);
	    } 
	    else if (totalMovil >= totalInternet && totalMovil >= totalTarifa) {
	        System.out.println("El mayor total por tipo de contrato es el de ClienteMovil con un acumulado de " + totalMovil);
	    } 
	    else {
	        System.out.println("El mayor total por tipo de contrato es el de ClienteTarifaPlana con un acumulado de " + totalTarifa);
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
		
		Empresa obj=null;
		
		try{
            obj= (Empresa)super.clone();
            obj.clientes = clientes.clone();
            for(int i = 0; i < nClientes; i++)
                obj.clientes[i] = (Cliente)clientes[i].clone();
        }catch(CloneNotSupportedException ex){
        	System.out.println("No se ha podido clonar");
        }
		return (Object)obj;
	}
	
	
public void clienteMasLongevo() {
		
		int maxi = -1;
		
		int cuenta = 0;
		
		String dni = " ";
		
		String nombre = " ";
		
		for(int i = 0; i < nClientes; i++) {
			
			
			if(clientes[i] instanceof ClienteMovil) {
				
				ClienteMovil cm = (ClienteMovil) clientes[i];
				
				cuenta = (cm.getfPermanencia().getAnio() * 1000 + cm.getfPermanencia().getMes() * 10 + cm.getFechaAlta().getDia()) + (cm.getFechaAlta().getAnio() * 1000 + cm.getFechaAlta().getDia());
						
				
			
			if(cuenta > maxi) {
				maxi = cuenta;
				
				dni = cm.getNif();
				
				nombre = cm.getNombre();
				
			}
		}
		
	    }
		
		System.out.println("Cliente Movil con mayor antiguedad: "+nombre+" con dni: " +dni);
		
	}

	public void clientesComun(Empresa g) {
		
		boolean encontrado = false;
		
		for (int i = 0; i < nClientes; i++) {
			
			
			for (int j = 0; j < g.nClientes; j++) {
			
				
				if (this.clientes[i].getNif().equals(g.clientes[j].getNif())) {
					
					System.out.println("El cliente con dni: " + this.clientes[i].getNif()+ " esta en ambas empresas");
					
					encontrado = true;
				}
				
			}
			
		}
		
	}



}
