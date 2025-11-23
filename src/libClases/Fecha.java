package libClases;

import java.util.Scanner;

public class Fecha {
	
	private int dia;
	private int mes;
	private int anio;
	
	
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
	
	public int getDia() { return this.dia; }
	
	public int getMes() { return this.mes; }
	
	public int getAnio() { return this.anio; }
	
	
	public boolean bisiesto() {
		
		if((this.anio % 4 == 0 & this.anio % 100 != 0) || this.anio % 400 == 0) {
			
			return true;
		}
		else 
			
			return false;
	}
	
	
	public void ver() {
		
		System.out.println(this/*.toString()*/);
		
		}
	
	
	
	public static Fecha pedirFecha() {
		
		Fecha fecha = null;
		
		boolean valida = false;
		
		Scanner sc = new Scanner(System.in);
		
		int dia, mes, anio;
		
		do {
			
		System.out.println("Introduce la Fecha (dd/mm/aaaa): ");
		
		String cadena = sc.next();
		
		String[] tokens = cadena.split("/");
		
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
	
	
	static public boolean mayor(Fecha f1, Fecha f2) {
		
		if (f1.anio*10000+f1.mes*100+f1.dia>f2.anio*10000+f2.mes*100+f2.dia)
			
			return true;
		
		else
			
			return false;
	}
	
	
	

}
