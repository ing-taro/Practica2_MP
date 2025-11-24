package libClases;

import java.util.Scanner;

public class Fecha implements Cloneable, Proceso{
	
	
	//atributos
	private int dia;
	private int mes;
	private int anio;
	
	
	//setters
	public void setFecha(int d, int m, int a) {
		
		int dmax;
		
		int diaMes[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		this.anio = a;
		
		if (m<1) //si el mes es incorrecto
			m=1;
		
			else if (m>12) //si el mes es incorrecto
			m=12;
		
			dmax=diaMes[m-1];
			
			if (m==2 && bisiesto())
			dmax++;
			
			if (d>dmax)
			d=dmax;
			
			else if (d<1)
			d=1;
			
			
			dia=d;
			
			mes=m;
			
	}
	
	public void setFecha(Fecha f) {
		
		setFecha(f.dia, f.mes, f.anio);
	}
		
	
	public Fecha(int dia, int mes, int anio) {
		
		setFecha(dia, mes, anio);
		
	}
	
	
	public Fecha (Fecha f) {
		
		dia = f.dia;
		
		mes = f.mes;
		
		anio = f.anio;
		
	}
	
	

	public String toString() {
		
		String s="";
		
		if (dia<10) s=s+0;
		
		s=s+dia+"/";
		
		if (mes<10) s=s+0;
		
		s=s+mes+"/"+anio;
		
		return s;

		}
	
	//getters
	public int getDia() { return this.dia; }
	
	public int getMes() { return this.mes; }
	
	public int getAnio() { return this.anio; }
	
	
	//bisiesto
	public boolean bisiesto() {
		
		if((this.anio % 4 == 0 & this.anio % 100 != 0) || this.anio % 400 == 0) {
			
			return true;
		}
		else 
			
			return false;
	}
	
	
	//metodo ver(), para imprimir por pantalla
	public void ver() {
		
		System.out.println(this/*.toString()*/);
		
		}
	
	
	
	
	//Para introducir una fecha por teclado
	public static Fecha pedirFecha() {
		
		Fecha fecha = null;
		
		boolean valida = false;
		
		Scanner sc = new Scanner(System.in);
		
		int dia, mes, anio;
		
		do {
			
		System.out.println("Introduce la Fecha (dd/mm/aaaa): ");
		
		String cadena = sc.next();
		
		String[] tokens = cadena.split("/");
		
		//excepciones
		try {
		if (tokens.length != 3)
			
		throw new NumberFormatException();
		
		dia = Integer.parseInt(tokens[0]); //parseInt lanza la excepcion
		
		mes = Integer.parseInt(tokens[1]); //NumberFormatException si no
		
		anio = Integer.parseInt(tokens[2]);//puede convertir el String a int
		
		fecha = new Fecha(dia, mes, anio);
		
		if (fecha.getDia() != dia || fecha.getMes() != mes)
		throw new NumberFormatException();
		
		valida=true;
		
		} 
		catch(NumberFormatException e) {
			
		System.out.println("Fecha no valida");
		
		}
		
		} 
		while(!valida);
		
		sc.close();
		
		return fecha;
		
	}
	
	
	//verificar si 1 fecha es mayor q otra
	static public boolean mayor(Fecha f1, Fecha f2) {
		
		if (f1.anio*10000+f1.mes*100+f1.dia>f2.anio*10000+f2.mes*100+f2.dia)
			
			return true;
		
		else
			
			return false;
	}
	
	
	
	//metodo clone para devolver objetos y no referencias	
	public Object clone() {
		
		//return new Fecha(this);
		Object obj=null;
		
		try {
			
		obj=super.clone(); //se llama al clone() de la clase base (Object)
		
		//que hace copia binaria de los atributos
		
		} catch(CloneNotSupportedException ex) {
			
		System.out.println(" no se puede duplicar");
		
		} 
		
		return obj;
		
		}

	
	//metodo para verificar si 2 fechas son iguales
	public boolean equals(Object obj) { 
		
		if (this == obj) return true; //si apuntan al mismo sitio son iguales
		
		if (obj == null) return false;
		
		if (getClass() != obj.getClass())//if (!(obj instanceof Cliente))	
		return false; // si los 2 no son de la misma clase no son iguales
		
		Fecha c = (Fecha) obj;
		
		return (dia==c.dia && mes==c.mes && anio==c.anio);
		
		}
	
	
	//metodo necesario para la clase Cliente
	public Fecha diaSig() {
		
		Fecha fechaSig = new Fecha(this.dia,this.mes,this.anio);
		
		int diaMes[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		
	    if (bisiesto()) //si el año es bisiesto febrero tiene 29 dias
	      diaMes[2]=29;

	    fechaSig.dia=this.dia+1;

	    if (fechaSig.dia>diaMes[fechaSig.mes]) {     //si al incrementar dia superamos el numero de dias de dicho mes
	    	
	        do{
	        	
	        	fechaSig.dia=fechaSig.dia-diaMes[fechaSig.mes];             //pasamos al dia del mes anterior
	        	
	        	fechaSig.mes++;			                //incrementamos un mes
	        	
	            if (fechaSig.mes>12) {                    //si al incrementar mes pasamos de 12 meses
	            	fechaSig.mes=1;                       //pasamos al mes 1
	            	fechaSig.anio++;                      //del año siguiente
	            	
	                if (fechaSig.bisiesto())              //si el año es bisiesto febrero tiene 29 dias
	                    diaMes[2]=29;
	                
	                else
	                    diaMes[2]=28;
	                
	            }
	            
	        }
	        
	        while(fechaSig.dia>diaMes[fechaSig.mes]);                    //hasta que el dia < diamax del mes en el q ns encontremos
	    }
		
		return fechaSig;
	}

}
