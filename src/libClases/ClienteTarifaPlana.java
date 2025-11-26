package libClases;

public class ClienteTarifaPlana extends Cliente{
	
	//atributos

	private static float tarifa = 0;
	
	private static float limiteMinutos = 300;
	
	private static float coste = 0.15f;
	
	private float minutosHablados = 0;
	
	private String nacionalidad = " ";
	
	
	//constructores
	
	public ClienteTarifaPlana (String NIF, String nom, Fecha fnac, Fecha fAlta, int m, String nac) {
		
		super(NIF, nom, fnac, fAlta); //constructor del padre
		
		this.minutosHablados = m;
		
		this.nacionalidad = nac;
		
	}
	
	public ClienteTarifaPlana (Cliente c) {
		
		super(c);
	}
	
	
	//getters
	
	public float getLimite() { return this.limiteMinutos; }
	
	public float geTarifa() { return this.tarifa; }
	
	public float getMinutos() { return this.minutosHablados; }
	
	public String getNac() { return this.nacionalidad; }

	
	//setters 
	
	public void setMinuto(float m) {
		
		minutosHablados = m;
	}
	
	public void setNac (String n) {
		
		nacionalidad = n;
	}
	
	
	public void setTarifaTP(float m, float t) {
		
		limiteMinutos = m;
		
		tarifa = t;
	}

	
	//metodo factura
	
	public float factura() {
		return tarifa + ((minutosHablados - limiteMinutos) * coste);
	}
	
	
	
	//toString
	
	@Override
	public String toString() {
		
		return super.toString()+" "+"nacionalidad"+ factura();
	}
	
	




}