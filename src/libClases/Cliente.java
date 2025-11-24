package libClases;

public class Cliente {
	
	private final String nif; //dni del cliente (letra incluida) (NO puede cambiar)
	
	private final int codCliente; //codigo único (y fijo) generado por la aplicación
	
	private String nombre; //nombre completo del cliente (SI se puede modificar)
	
	private final Fecha fechaNac; //fecha nacimiento del cliente (NO se puede cambiar)
	
	private Fecha fechaAlta; //fecha de alta del cliente (SI se puede modificar)
	
	//necesario para el codigo
	private static final Fecha fechaPorDefecto = new Fecha(1,1,2018); 
	
	
	//constructores
	public Cliente (String NIF, String nom, Fecha fNac, Fecha fAlta) {
		
		this.nif = NIF;
		
		this.nombre = nom;
		
		this.codCliente = 0;
		
		this.fechaNac = (Fecha)fNac.clone();
		
		this.fechaAlta = (Fecha)fAlta.clone();
		
		
	}
	
	public Cliente (String NIF, String nom, Fecha fNac) {
		
		Fecha fAlta = new Fecha(01,01,2018);
		
		this.nif = NIF;
		
		this.nombre = nom;
		
		this.codCliente = 0;
		
		this.fechaNac = (Fecha)fNac.clone();
		
		this.fechaAlta = (Fecha)fAlta.clone();
		
	}
	 
	 

}
