package libClases;

public class ClienteTP extends Cliente{
	
	//atributos

	private static float tarifa = 0;
	
	private static float limiteMinutos = 300;
	
	private static float coste = 0.15f;
	
	private float minutosHablados = 0;
	
	private String nacionalidad = " ";
	
	
	//constructores
	
	public ClienteTP (String NIF, String nom, Fecha fnac, Fecha fAlta, int m, String nac) {
		
		super(NIF, nom, fnac, fAlta); //constructor del padre
		
		this.minutosHablados = m;
		
		this.nacionalidad = nac;
		
	}
	
	public ClienteTP (Cliente c) {
		
		super(c);
	}
	
	





}