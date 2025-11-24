package libClases;

public class Cliente {
	
	//posiblemente haya que crear un contador para el codCliente, pero como inicializa a 0 y está como final, mejor preguntar
	
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
	
	
	public Cliente(Cliente c) {
		
		this.nif = c.nif;
		
		this.nombre = c.nombre;
		
		this.codCliente = 0;
		
		this.fechaNac = (Fecha)c.fechaNac.clone();
		
		this.fechaAlta = (Fecha)c.fechaAlta.clone();
	
	}
	
	

	//GETTERS
	public String getNIf() { return this.nif; }
	
	public String getNombre() { return this.nombre; }
	
	public int getCodCliente() { return this.codCliente; }
	
	public Fecha getFechaNac() { return (Fecha)fechaNac.clone(); }
	
	public Fecha getFechaAlta() { return (Fecha)fechaAlta.clone(); }
	
	public static Fecha getFechaPorDefecto() { return (Fecha)fechaPorDefecto.clone(); }
	
	
	//SETTERS
	 public void setNombre(String nom) {
		 
		 this.nombre = nom;
	 }
	 
	 public void setFechaAlta (Fecha fal) {
		 
		 fechaAlta.setFecha(fal);
	 }
	 
	 public static void setFechaPorDefecto(Fecha f) {
		 
		 fechaPorDefecto.setFecha(f);
	 }
	 
	 
	 //devuelve una cadena de informacion
	 public String toString() {
		 
		 return nif+" "+fechaNac+": "+nombre+" ("+codCliente+" - "+fechaAlta+")";
	 }
	 
	 
	 //metodo ver(), para mostrar por pantalla
	 public void ver() {
		System.out.println(this); //devuelvo el objeto de la clase
		
	 }
	 
	 
	 
	//metodo clone para devolver objetos y no referencias	
	public Object clone() {
		
		return new Cliente(this);
		
	}
	 
	 
	//metodo para verificar igualdad
	public boolean equals(Object o){
			
		return o.getClass() == Cliente.class && nif.equals(((Cliente)o).nif);
			
	}
	 
	 

}
