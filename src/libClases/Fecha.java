package libClases;

public class Fecha {
	
	private int dia;
	private int mes;
	private int anio;
	
	public Fecha(int dia, int mes, int anio) {
		
		this.dia = dia;
		
		this.mes = mes;
		
		this.anio = anio;
		
	}
	
	public void setFecha(int d, int m, int a) {
		
		int dmax;
		
		int diames[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		this.anio = a;
		
		
		
		
		
	}
	
	public int getDia(int d) { return this.dia; }
	
	public int getMes(int m) { return this.mes; }
	
	public int getAnio(int a) { return this.anio; }

}
