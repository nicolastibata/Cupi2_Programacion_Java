package uniandes.cupi2.lineasTelefonicas.mundo;

public class LineaVozIP extends LineaTelefonica
{
	private int numeroMinutosLocal;
	private int numeroMinutosLargaDistancia;
	private int numeroMinutosCelular;
	private double saldoDisponibleVozIP;
	
	public LineaVozIP() // inicializamos los atributos de la clase y de la clase padre
	{
		super(); // atributos clase padre (linea telefonica)
		numeroMinutosLocal = 0;
		numeroMinutosLargaDistancia = 0;
		numeroMinutosCelular = 0;
		saldoDisponibleVozIP = 100000;
	}
	
	public int darNumeroMinutosLocal()
	{
		return numeroMinutosLocal;
	}
	
	public int darNumeroMinutosLargaDistancia()
	{
		return numeroMinutosLargaDistancia;
	}
	
	public int darNumeroMinutosCelular()
	{
		return numeroMinutosCelular;
	}
	
	public double darSaldoDisponible()
	{
		return saldoDisponibleVozIP;
	}
	
	public double calcularCostoLlamadasLocal()
	{
		return numeroMinutosLocal * 35;
	}
	
	// Llamemos los metodos de nuestra clase padre, asi anadimos las llamadas y sus 
	// atributos de esta linea
	
	public void agregarLlamadaLocal(int minutos)
	{
		// Como el valor x minuto local es igual que las lineas de LineaTelefonica
		// entonces no tendremos que modificar el costo llamadas, solo hacer el llamado
		// super y tambien aumentar los minutos a los minutos locales de esta linea.
		super.agregarLlamadaLocal(minutos);
		
		numeroMinutosLocal = numeroMinutosLocal + minutos;
	}
	
	public void agregarLlamadaCelular(int minutos)
	{
		super.agregarLlamadaCelular(minutos);
		// en este caso si debemos modificar el costo de Llamada, pues en las lineas base
		// el precio es de 999 x minuto celular, en esta linea el precio es de 7
		
		modificarCostoLlamada(darCostoLlamadas() - minutos*992);
		
		saldoDisponibleVozIP = saldoDisponibleVozIP - (minutos * 7);
	}
	
	public void agregarLlamadaLargaDistancia(int minutos)
	{
		super.agregarLlamadaLargaDistancia(minutos);
		// modificar costo llamada
		
		modificarCostoLlamada(darCostoLlamadas() - minutos*300);
		saldoDisponibleVozIP = saldoDisponibleVozIP - (minutos * 80);
	}
	
	public void reiniciar()
	{
		super.reiniciar();
		numeroMinutosLocal = 0;
		numeroMinutosLargaDistancia = 0;
		numeroMinutosCelular = 0;
		saldoDisponibleVozIP = 100000;
	}
}
