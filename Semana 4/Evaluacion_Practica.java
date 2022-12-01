// Clase que represnenta una linea de videollamadas, la cual es heredada por LineaVozIP

public class LineaVideollamada extends LineaVozIP
{}


// Modifique el atributo saldoDisponible de la clase LineaVozIP para que pueda ser accedido directamente desde la clase LineaVideollamada.

private double saldoDisponible // antes

protected double saldoDisponible // despues
  
  
// Cree el atributo numeroMinutosVideollamada en la clase LineaVideollamada. Este atributo debe poder accederse solamente desde esta clase.

private int numeroMinutosVideollamada;


// Implemente el método constructor de la clase LineaVideollamada, el cual debe inicializar todos los atributos heredados (recuerde que 
// para esto puede acceder al constructor de la clase padre, que ya cumple con esa tarea) y adicionalmente inicializar numeroMinutosVideollamada en 0.

public LineaVideollamada()
{
	super(); // inicializo los atributos heredados
	numeroMinutosVideollamada = 0;
}


// Cree el método agregarVideollamada(int minutos), que agrega una videollamada. Esto consiste en aumentar en uno el número de llamadas, 
// el número de minutos en los minutos consumidos en la llamada, el costo aumenta en el número de minutos consumidos por el precio por 
// minuto, el saldo disponible disminuye en el costo de la llamada que se agrega y el número de minutos de videollamada aumenta en el 
// número de minutos consumidos. Recuerde que el costo por minuto de una videollamada es de 550.

public void agregarVideollamada(int minutos)
{
    // atributos heredados - publicos - clase padre
    numeroLlamadas = numeroLlamadas + 1;
    numeroMinutos = numeroMinutos + minutos;
    
    // atributos heredados - publico - clase LineaVozIP
    saldoDisponible = saldoDisponible - (minutos * 550);
    
    numeroMinutosVideollamada = numeroMinutosVideollamada + minutos; // atributo de la clase 

    // atributos heredados - privados - clase padre
    // al ser privado accedemos con el metodo modificarCostoLlamadas()
    modificarCostoLlamada( darCostoLlamadas() + minutos * 550);
    
}


// Sobreescriba el método reiniciar(), para que ahora, además de reiniciar los atributos de la clase padre, reinicie también el 
// atributo numeroMinutosVideollamada

public void reiniciar()
{
	super.reiniciar();
	numeroMinutosVideollamada = 0;
}

