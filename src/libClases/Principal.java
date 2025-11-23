package libClases;

public class Principal {

	public static void main(String[] args) {
		Fecha f1 = new Fecha(29,2,2001), f2 = new Fecha(f1), f3 = new Fecha(29,2,2004);
		final Fecha f4=new Fecha(05,12,2023); //es constante la referencia f4
		System.out.println("Fechas: " + f1.toString() + ", "+f2+ ", " +f3+ ", " +f4+ "\n");
		f1=new Fecha(31,12,2016); //31/12/2016
		f4.setFecha(28, 2, 2008); //pero no es constante el objeto al que apunta
		System.out.println(f1 +" "+ f2.toString() +" " + f3 +" "+ f4+" "+ f1);
		f1=new Fecha(f4.getDia()-10, f4.getMes(), f4.getAnio()-7); //f1=18/02/2001
		f3=Fecha.pedirFecha(); //pide una fecha por teclado
		if (f3.bisiesto() && Fecha.mayor(f2,f1))
		System.out.print("El " + f3.getAnio() + " fue bisiesto, " + f1 + ", " + f3);

	}

}
