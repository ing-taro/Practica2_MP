package libClases;

public class ClienteMovil extends Cliente{
	
	//atributos

	private Fecha fechaPermanencia;
    private float minutosHablados;
    private float precioMinuto;
	
	
	//constructores
	
    public ClienteMovil(String NIF, String nom, Fecha fnac, Fecha fAlta, Fecha fPer, float m, float precio) {
    	
    	super(NIF,nom,fnac,fAlta);
    	
    	this.fechaPermanencia = (Fecha)fPer.clone();
    	
    	this.minutosHablados = m;
    	
    	this.precioMinuto = precio;
    	
    }
    
	public ClienteMovil(String NIF, String nom, Fecha fNac, Fecha fAlta, float minutosHablados, float precioMinuto) {
		
	    this(NIF, nom, fNac, fAlta, new Fecha(fAlta.getDia(), fAlta.getMes(), fAlta.getAnio()+1), minutosHablados, precioMinuto);
	    
	}
	
	public ClienteMovil(String NIF, String nom, Fecha fNac, float minutosHablados, float precioMinuto) {
		
	    this(NIF, nom, fNac, getFechaPorDefecto(), minutosHablados, precioMinuto);
	    
	}
    
	
   public ClienteMovil(ClienteMovil c) {
	   super(c);
	   
   	this.fechaPermanencia = (Fecha)fechaPermanencia.clone();
	
   	this.minutosHablados = c.minutosHablados;
   	
   	this.precioMinuto = c.precioMinuto;
   	
   }

   
	//getters
	
	public float getMinutosHablados() { return this.minutosHablados; }
	
	public float gePrecio() { return this.precioMinuto; }
	
	public Fecha getfPermanencia() { return (Fecha)fechaPermanencia.clone(); }
	
	//setters
	
	
	//metodos
	
	
	
}
