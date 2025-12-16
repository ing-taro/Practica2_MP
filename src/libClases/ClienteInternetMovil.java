package libClases;

public class ClienteInternetMovil extends ClienteMovil {
	
	
	//atributos
	
	private float gigas;
	
	private static float precioGigasExtra = 1.00f;
	
	private static float tarifaInternetBase = 10.00f; // El enunciado dice 10€
	
	private static float limiteGigas = 15.0f; // El enunciado dice 15GB
	
	
	
	//constructores
	
	//Clase Cliente
	public ClienteInternetMovil (String NIF, String nom, Fecha fnac, Fecha fAlta, Fecha fPer, float m, float precio, float gigasConsumidos) {
		
		super(NIF,nom,fnac,fAlta, fPer, m, precio);
		
		this.gigas = gigasConsumidos;
		
	}
	
	//Clase ClienteMovil
	public ClienteInternetMovil (String nif, String nombre, Fecha fNac, float minutos, float precioMinuto, float gigasConsumidos) {
		
		super(nif, nombre, fNac, minutos, precioMinuto);
		
		this.gigas = gigasConsumidos;
	    
	}

	public ClienteInternetMovil(ClienteInternetMovil c) {
		super(c);
		
		this.gigas = c.gigas;
		
	}
	
	
	//getters
	public float getGigas() { return this.gigas; }
	
	public float getExceso() { return ClienteInternetMovil.limiteGigas; }
	
	public float getPrecioGB() { return ClienteInternetMovil.precioGigasExtra; }
	
	
	//setters
	
	public void setGigas(float gig) { 
		
		gig = this.gigas;
	}
	
	
	//metodos
	
	@Override
	public Object clone() {
		
		return new ClienteInternetMovil( getNif(), getNombre(), getFechaNac(), getFechaAlta(), getfPermanencia(), getMinutosHablados(), getPrecio(), getGigas());
		
	}
	
	
	public float facturaInternet() {
		
	    float exceso = 0;
	    
	    // Si ha consumido más del límite (15), calculamos la diferencia
	    if (this.gigas > limiteGigas) {
	        exceso = this.gigas - limiteGigas;
	    }
	    
	    return tarifaInternetBase + (exceso * precioGigasExtra);
	}
	
	
	//facturaInternet() + factura() 
	public float sumaFacturas() {
		
		return factura() + facturaInternet();
		
	}
	
	
	@Override
    public String toString() {
		
        return super.toString() + " [Internet: " + gigas + "GB consumidos. Total Internet: " + facturaInternet() + "€] Total Absoluto: " + sumaFacturas();
    }
	
	
	@Override
	public void ver() {
		
		System.out.println(this);
		
	}
	
	
	
	
}
