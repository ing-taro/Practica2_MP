package libClases;

public class ClienteSatelitalinternet extends ClienteTarifaPlana{
	
	//atributos
	
		private float gigas;
		
		private static float limiteGigas = 200.0f; //gigas base
		
		private static float tarifaBase = 35.0f; //precio de los 200GB base
		
		private static float gigaExtra = 0.10f; //precio giga extra
		
		//constructores
		
		public ClienteSatelitalinternet(String nif, String  nombre,Fecha fNac,Fecha fAlta,float  minutos,String nacionalidad, float gigas) {
			
			super(nif, nombre, fNac, fAlta, minutos, nacionalidad);
			
			this.gigas = gigas;
		}
		
		public ClienteSatelitalinternet(String nif, String  nombre,Fecha fNac,float  minutos,String nacionalidad, float gigas) {
			
			super(nif,nombre, fNac, getFechaPorDefecto(), minutos, nacionalidad);
			
			this.gigas = gigas;
		}
		
		
		public ClienteSatelitalinternet (ClienteTarifaPlana c) {
			
			super(c);
		}
		
		//getters
		
		public float getGB() { return this.gigas; }
		
		public float getExceso() { return ClienteSatelitalinternet.gigaExtra; }
		
		public float getPrecio() { return ClienteSatelitalinternet.tarifaBase; }
		
		
		
		//setters
		
		public void setGB(float gig) { 
			
			 this.gigas = gig;
		}
		
		
		//metodos
		
		
		
		
		//clone
		
		public Object clone() {
			
			return new ClienteSatelitalinternet(getNif(), getNombre(), getFechaNac(), getFechaAlta(), getMinutos(),getNacionalidad(), getGB());
		}
		
		
		//factura total
		public float facturaInternetPlana() {
			
			float exceso = 0;
			
			if(this.gigas > limiteGigas) {
				
				exceso = this.gigas - limiteGigas;
			}
			
			return tarifaBase + (exceso * gigaExtra);
		}
		
		
		
		//ver
		
		 public void ver() {
			System.out.println(this); //devuelvo el objeto de la clase
			
		 }
		
		 
		//equals
			@Override
			public boolean equals(Object o){
					return o instanceof ClienteSatelitalinternet && getNif().equals(((ClienteTarifaPlana)o).getNif());
			}
		
}
