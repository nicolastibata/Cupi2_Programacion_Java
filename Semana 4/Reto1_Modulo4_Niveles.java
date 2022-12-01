// ------------ NIVEL BASICO ----------------------------


/** 
Haga las modificaciones necesarias en la clase LineaTelefonica para que ahora el atributo costoLlamadas pueda ser accedido
directamente desde la clase LineaCelular.
**/

private double costoLlamadas;

// Respuesta
protected double costoLlamdas;


/** 
Modifique el metodo agregarLlamadaLocal(...) en la clase LineaCelular, para que en vez de acceder al atributo costoLlamadas
a traves de metodos, lo haga directamente.
**/

/**
* Agrega una llamada local a la linea celular <br>
* <b>pre: </b>  Hay saldo local disponible para realizar la *llamada 
* <b>post: </b> Se incremento en 1 numeroDeLlamadas, se *incremento numeroDeMinutos en minutos, se incremento *numeroMinutosLocal en minutos, 
costoLlamadas aumento en ( *minutos * 20 ) y saldoDisponibleLocal disminuye en ( minutos * *20 )
* @param minutos Numero de minutos de la llamada. minutos >0.
*/
//Punto 2 gamificacion modulo 4 - Nivel basico
public void agregarLlamadaLocal( int minutos )
{
    numeroLlamadas = numeroLlamadas + 1;
    numeroMinutos = numeroMinutos + minutos;
    //Suma el costo (costo por minuto: 20 pesos). 
    //Se obtiene y modifica el atributo heredado
    //TODO
    numeroMinutosLocal = numeroMinutosLocal + minutos;        
    saldoDisponibleLocal = saldoDisponibleLocal - ( minutos * 20 );
}

// Respuesta 
public void agregarLlamadaLocal( int minutos )
{
    numeroLlamadas = numeroLlamadas + 1;
    numeroMinutos = numeroMinutos + minutos;
    //Suma el costo (costo por minuto: 20 pesos). 
    //Se obtiene y modifica el atributo heredado
    //TODO

    numeroMinutosLocal = numeroMinutosLocal + minutos;        
    saldoDisponibleLocal = saldoDisponibleLocal - ( minutos * 20 );
    costoLlamadas = costoLlamadas + (minutos * 20);
    
}


/**
Modifique el método agregarLlamadaCelular(…) en la clase LineaCelular, para que en vez de acceder al atributo costoLlamadas 
a través de métodos, lo haga directamente
**/

/**
* Agrega una llamada a celular a la linea celular <br>
* <b>post: </b> Se incremento en 1 numeroDeLlamadas, se *incremento numeroDeMinutos en minutos, costoLlamadas *aumento en 
( minutos * 999 ) y se incremento *numeroMinutosCelular en minutos.
* @param minutos Numero de minutos de la llamada. minutos *>0.
*/
//Punto 2 gamificacion modulo 4 - Nivel basico
public void agregarLlamadaCelular( int minutos )
{
    super.agregarLlamadaCelular(minutos);
    	
  //Modifica el costo total de las llamadas con el valor dado por parametro.(Se resta minutos por 989)
	//TODO
    	
    numeroMinutosCelular = numeroMinutosCelular + minutos;
}

// Respuesta
public void agregarLlamadaCelular( int minutos )
{
    super.agregarLlamadaCelular(minutos);
    	
  //Modifica el costo total de las llamadas con el valor dado por parametro.(Se resta minutos por 989)
	//TODO
    costoLlamadas = costoLlamadas - minutos*989;
    numeroMinutosCelular = numeroMinutosCelular + minutos;
}


/**
En la clase LineaCelular, sobreescriba el método reiniciar() que se encuentra en la clase LineaTelefonica, para que ahora, además 
de reiniciar los atributos heredados de LineaTelefonica, se reinicien los atributos propios de LineaCelular (numeroMinutosLocal 
y numeroMinutosCelular deben quedar en cero, mientras que saldoDisponibleLocal debe quedar en 50000). 

Nota: Para reiniciar los atributos heredados, obligatoriamente debe realizar un llamado al método de la superclase.
**/


/**
* Reinicia los atributos de la linea celular, ademas de los atributos heredados de la
* clase padre. Este metodo sobreescribe al de mismo nombre de la clase LineaTelefonica
*/

public void reiniciar()
{
    super.reiniciar();
    numeroMinutosLocal = 0;
    numeroMinutosCelular = 0;
    saldoDisponibleLocal = 50000;

}


// ------------ NIVEL INTERMEDIO ----------------------------

// Interfaz para definir una linea telefonica
public interface ILineaTelefonica{}


// Declaracion del metodo darCostoLlamadas en la interface
public double darCostoLlamadas();


// Declaracion del metodo darNumeroLlamadas en la interface
public int darNumeroLlamadas();


// Declaracion del metodo darNumeroMinutos en la interface
public int darNumeroMinutos();


// Declaracion del metodo modificarCostoLlamada en la interface
public void modificarCostoLlamada(double pCostoLlamadas);


// Declaracion del metodo agregarLlamadaLocal en la interface
public void agregarLlamadaLocal(int minutos);


// Declaracion del metodo reiniciar en la interface
public void reiniciar();


// Haga las modificaciones necesarias para que ahora LineaTelefonica implemente la nueva interfaz
public class LineaTelefonica implements ILineaTelefonica
{
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * N�mero de llamadas realizadas
     */
    protected int numeroLlamadas;

    /**
     * N�mero de minutos consumidos
     */
    protected int numeroMinutos;

    /**
     * Costo total de las llamadas
     */
    //Punto 1 gamificacion modulo 4 - Nivel basico
    protected double costoLlamadas;

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Constructor que inicializa la l�nea telef�nica <br>
     * <b>post: </b> La l�nea se inicializ� con valores en cero.
     */
    public LineaTelefonica( )
    {
        //Inicializa los valores
        numeroLlamadas = 0;
        numeroMinutos = 0;
        costoLlamadas = 0;
    }

    /**
     * Reinicia la l�nea telef�nica, dejando todos sus valores en cero.
     */
    public void reiniciar( )
    {
        numeroLlamadas = 0;
        numeroMinutos = 0;
        costoLlamadas = 0;
    }

    /**
     * Devuelve el costo total de las llamadas realizadas
     * @return Costo total de las llamadas realizadas
     */
    public double darCostoLlamadas( )
    {
        return costoLlamadas;
    }

    /**
     * Devuelve el n�mero de llamadas realizadas por esta l�nea
     * @return N�mero de llamadas realizadas por esta l�nea
     */
    public int darNumeroLlamadas( )
    {
        return numeroLlamadas;
    }

    /**
     * Devuelve el n�mero de minutos consumidos
     * @return N�mero de minutos consumidos
     */
    public int darNumeroMinutos( )
    {
        return numeroMinutos;
    }
    
    /**
     * Modifica el costo de las llamadas con el valor dado por par�metro.
     * @param pCostoLlamadas Nuevo costo de las llamadas;
     */
    public void modificarCostoLlamada(double pCostoLlamadas){
    	costoLlamadas = pCostoLlamadas;
    }
    
    /**
     * Agrega una llamada local a la l�nea telef�nica <br>
     * <b>post: </b> Se incremento en 1 numeroDeLlamadas, se incremento numeroDeMinutos en minutos, costoLlamadas aumento en ( minutos * 35 )
     * @param minutos N�mero de minutos de la llamada. minutos >0.
     */
    public void agregarLlamadaLocal( int minutos )
    {
        //
        //Una llamada m�s
        numeroLlamadas = numeroLlamadas + 1;
        //
        //Suma los minutos consumidos
        numeroMinutos = numeroMinutos + minutos;
        //
        //Suma el costo (costo por minuto: 35 pesos)
        costoLlamadas = costoLlamadas + ( minutos * 35 );
    }

    /**
     * Agrega una llamada de larga distancia a la l�nea telef�nica <br>
     * <b>post: </b> Se incremento en 1 numeroDeLlamadas, se incremento numeroDeMinutos en minutos, costoLlamadas aumento en ( minutos * 380 )
     * @param minutos N�mero de minutos de la llamada. minutos >0.
     */
    public void agregarLlamadaLargaDistancia( int minutos )
    {
        //
        //Una llamada mas
        numeroLlamadas = numeroLlamadas + 1;
        //
        //Suma los minutos consumidos
        numeroMinutos = numeroMinutos + minutos;
        //
        //Suma el costo (costo por minuto: 380 pesos)
        costoLlamadas = costoLlamadas + ( minutos * 380 );
    }

    /**
     * Agrega una llamada a celular a la l�nea telef�nica <br>
     * <b>post: </b> Se incremento en 1 numeroDeLlamadas, se incremento numeroDeMinutos en minutos, costoLlamadas aumento en ( minutos * 999 )
     * @param minutos N�mero de minutos de la llamada. minutos >0.
     */
    public void agregarLlamadaCelular( int minutos )
    {
        //
        //Una llamada m�s
        numeroLlamadas = numeroLlamadas + 1;
        //
        //Suma los minutos consumidos
        numeroMinutos = numeroMinutos + minutos;
        //
        //Suma el costo (costo por minuto: 999 pesos)
        costoLlamadas = costoLlamadas + ( minutos * 999 );
    }
}


// ------------ NIVEL AVANZADO ----------------------------

// Cree la clase LineaSatelital, la cual debe heredar los comportamientos de una linea celular
public class LineaSatelital extends LineaCelular {...}


// Implemente el metodo constructor de la clase LineaSatelital, el cual debe inicializar los atributos heredados y adicionalmente
// asignar un valor de 100000 al saldo de larga distancia
public LineaSatelital()
{
	super(); // asi se recoge el metodo constructor
	saldoDisponibleLargaDistancia = 100000;
}


// Sobreescriba el metodo reiniciar para que reinicie los atributos heredados y el atributo del saldo de larga distancia
public void reiniciar()
{
	super.reiniciar();
	saldoDisponibleLargaDistancia = 100000;
}


// Sobreescriba el metodo agregarLlamadaLargaDistancia para que permite a LineaSatelital realizar una llamada de Larga Distancia. 
// Se debe incremente el numero de llamadas en uno, el numero de minutos, el costo de llamada y restar el saldo disponible.
// Cada minuto a larga distancia tiene un costo de 450.
public void agregarLlamadaLargaDistancia(int minutos)
{
	numeroLlamadas = numeroLlamadas + 1;
	numeroMinutos = numeroMinutos + minutos;
	costoLlamadas = costoLlamadas + (minutos * 450);
	saldoDisponibleLargaDistancia = saldoDisponibleLargaDistancia - (minutos * 450);
}
