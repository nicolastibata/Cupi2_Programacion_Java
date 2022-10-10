// --------------------------------------------------------------------
// NIVEL BÁSICO 
// --------------------------------------------------------------------


/**
* Número de minutos consumidos en llamadas a celular 
*/
private int numeroMinutosCelular;


/**
* Inicializa la línea telefónica
* post: La línea se inicializó con valores en cero.
*/
public void inicializar( )
{
    numeroLlamadas = 0;
    numeroMinutosCelular = 0;
    costoLlamadas = 0;
    numeroMinutosCelular = 0;
    
}


/**
* Agrega una llamada a celular a la línea telefónica
* post: Se incremento en 1 numeroDeLlamadas, se incremento 
* numeroDeMinutos en minutos, costoLlamadas aumento en ( minutos * 999 )
* param minutos Número de minutos de la llamada. minutos >0.
*/
public void agregarLlamadaCelular( int minutos )
{
    //Una llamada más
    numeroLlamadas = numeroLlamadas + 1;

    //Suma los minutos consumidos
    numeroMinutos = numeroMinutos + minutos;

    //Suma el costo (costo por minuto: 999 pesos)
    costoLlamadas = costoLlamadas + ( minutos * 999 );
    
    numeroMinutosCelular = numeroMinutosCelular + minutos;
    
}	 


/**
* Devuelve el número de minutos consumidos en llamadas a celular
*/
public int darNumeroMinutosCelular ( )
{
    return numeroMinutosCelular;
}


// --------------------------------------------------------------------
// NIVEL INTERMEDIO
// --------------------------------------------------------------------


/**
* Devuelve el número total de llamadas realizadas a celular
*/
public int darTotalMinutosCelular ( )
{
    return linea1.darNumeroMinutosCelular()+linea2.darNumeroMinutosCelular()+linea3.darNumeroMinutosCelular();
}


/**
* Calcula el porcentaje de minutos a celular que ha consumido la empresa 
* respecto al total de minutos consumidos
* @return el porcentaje de minutos a celular respecto el total de minutos. double entre 0 y 100
*/
public double darPorcentajeCelular( )
{
    return darTotalMinutosCelular()*100/darTotalMinutos();
}


// --------------------------------------------------------------------
// NIVEL AVANZADO
// --------------------------------------------------------------------


/**
* Clase que representa el consorcio
*/

    //TODO - Escribir la declaracion de la clase
public class Consorcio  
    {
        //-----------------------------------------------------------------
        // Atributos
        //-----------------------------------------------------------------
            
        //TODO 
        private Empresa empresaA;
        private Empresa empresaB;
        private Empresa empresaC;
	      /**
	      * Constructor de la clase Consorcio
	      */
	      public Consorcio()
	      {
          //TODO
          empresaA = new Empresa();
          empresaA.inicializar();

          empresaB = new Empresa();
          empresaB.inicializar();

          empresaC = new Empresa();
          empresaC.inicializar();
	      }
	
        /**
        * Calcula el total de dinero que debe pagar el consorcio por consumo en lineas telefonicas
        * @return cantidad a pagar por consumo telefonico
        */
        public double darTotalFacturaConsorcio ( )
        {
          //TODO
          return empresaA.darTotalCostoLlamadas()+empresaB.darTotalCostoLlamadas()+empresaC.darTotalCostoLlamadas();
        }

        /**
        * Calcula el costo de impuestos que debe pagar el consorcio por concepto de inpuestos telefonicos
        * @return impuestos
        */
        public double darTotalImpuestos()
        {
           return (empresaA.darTotalNumeroLlamadas()+0.04*empresaA.darTotalCostoLlamadas())+
           (empresaB.darTotalMinutos()*0.01+3*empresaB.darTotalNumeroLlamadas())+
           (empresaC.darTotalCostoLlamadas()*0.05);
        }
}
    


