package uniandes.cupi2.avion.mundo;

// Pelicula del avion
public class Pelicula {
	
	// Constantes  
	public final static String COMEDIA = "Comedia";
	public final static String ACCION = "Accion";
	public final static String DRAMA = "Drama";
	public final static String INFANTIL = "Infantil";
	public final static String ROMANCE = "Romance";
	
	// Atributos 
	private String nombre;
	private String genero;
	private int duracion;
	private String director;
	
	// Inicializar Atributos
	public Pelicula( String pNombre, String pGenero, int pDuracion, String pDirector)
	{
		nombre = pNombre;
		genero = pGenero;
		duracion = pDuracion;
		director = pDirector;
	}
	
	// Metodos
	public String darNombre()
	{
		return nombre;
	}
	
	public String darGenero()
	{
		return genero;
	}
	
	public int darDuracion() 
	{
		return duracion;
	}
	
	public String darDirector()
	{
		return director;
	}
	
	public void cambiarNombre(String pNombre)
	{
		nombre = pNombre;
	}
	
	public void cambiarGenero(String pGenero)
	{
		genero = pGenero;
	}

	public void cambiarDuracion(int pDuracion)
	{
		duracion = pDuracion;
	}

	public void cambiarDirector(String pDirector)
	{
		director = pDirector;
	}
	
	/*
	 * Retorna una cadena de texto con la informacion de la pelicula 
	 * siguiendo el siguiente formato:
	 * <nombre> (<genero>). <duracion> minutos - director.
	 * @return La cadena de texto con el formato definido. 
	 */
	public String toString()
	{
		String info = nombre +"( "+ genero + " ). "+ duracion + "minutos - " + director;
		return info;
	}
	
}
