// ------------------------------------------------------
//                     NIVEL BASICO
// ------------------------------------------------------

/**
* Retorna una muestra ordenada con los elementos del arreglo ordenados de forma descendente (de mayor a menor) 
* usando el algoritmo burbuja
* @return Retorna un objeto MuestraOrdenada con los elementos ordenados de mayor a menor
*/
public MuestraOrdenada ordenarBurbujaDescendente()
{
    int[] arreglo = darCopiaValores();
    for (int i = tamanio; i > 0; i--)
    {
        for (int j = 0; j < i-1; j++)
        {
            if (arreglo[j] < arreglo[j+1])
            {
                // Al ser orden descendente, si el elemento siguiente es mayor al actual, 
                // entonces el elemento siguiente debe pasar de primeras
                int temp = arreglo[j];
                arreglo[j] = arreglo[j+1];
                arreglo[j+1] = temp;
            }
        }
    }
    return new MuestraOrdenada(arreglo);
}


/**
* Retorna el mayor elemento del arreglo, a partir de una muestra ordenada descendentemente por algoritmo burbuja
* @return Numero mayor del arreglo ordenado descendentemente
*/
public int darElementoMayor()
{
    // peor caso
    if (tamanio == 0)
        return 0;
    else 
    {
        int mayor = valores[0];
        for (int i = 1; i < tamanio; i++)
        {
            if (valores[i] > mayor)
                mayor = valores[i];
        }
        return mayor;
    }
}

// PERO AL SER NECESARIO USAR EL METODO ANTERIOR ENTONCES...

public int darElementoMayor()
{
    int[] arreglo = ordenarBurbujaDescendente().darCopiaValores();
    int mayor = arreglo[0];
    return mayor;
}


// ------------------------------------------------------
//                     NIVEL INTERMEDIO
// ------------------------------------------------------

/**
* Retorna un arreglo de enteros con los numeros pares presentes en el
* arreglo original
* @return Arreglo de enteros con los numeros pares del arreglo original
*/
public int[] darParesArreglo()
{
    int[] arreglo = darCopiaValores();
    // int[] arreglo_pares = new int[] no sirve debido a que el tamanio varia
    ArrayList<Integer> lista_pares = new ArrayList<Integer> ();
    for (int i = 0; i < tamanio; i++)
    {
        if (arreglo[i] % 2 == 0)
            lista_pares.add(arreglo[i]);
    }
    // ya se tiene el ArrayList con los numeros pares. Ahora se copian a un int[]
    int[] arreglo_pares = new int[lista_pares.size()];
    for (int i = 0; i < lista_pares.size(); i++)
    {
        arreglo_pares[i] = lista_pares.get(i);
    }
    return arreglo_pares;
}


/**
* Retorna un objeto MuestraOrdenada con los elementos pares del arreglo ordenados de forma descedente, usando el algoritmo de seleccion.
* @return Objeto MuestraOrdenada con los elementos pares ordenados de 
* mayor a menor
*/
public MuestraOrdenada ordenarParesSeleccionDescendente()
{
    int[] arreglo = darParesArreglo();
    for( int i = 0; i < arreglo.length - 1; i++) 
    // se usa length y no tamanio ya que el tamanio corresponde al arreglo original. Como el arreglo de pares
    // es un arreglo diferente, usamos length
    {
        int mayor = arreglo[i]; // asumimos que el mayor es el primer elemento 
        int posMayor = i;
        for (int j = i + 1; j < arreglo.length; j++)
        {
            if(arreglo[j] > mayor)
            // comparamos los valores de i y el i + 1
            {
                mayor = arreglo[j];
                posMayor = j;
            }
        }
        // intercambiamos posiciones 
        int temporal = arreglo[i];
        arreglo[i] = mayor;
        arreglo[posMayor] = temporal;
    }
    
    return new MuestraOrdenada(arreglo);
}


/**
* Retorna un objeto MuestraOrdenada con los elementos pares del arreglo ordenados de forma descedente, usando el algoritmo de seleccion.
* @return Objeto MuestraOrdenada con los elementos pares ordenados de 
* mayor a menor
*/
public MuestraOrdenada ordenarParesSeleccionDescendente()
{
    int[] arreglo = darParesArreglo();
    for( int i = 0; i < arreglo.length - 1; i++) 
    // se usa length y no tamanio ya que el tamanio corresponde al arreglo original. Como el arreglo de pares
    // es un arreglo diferente, usamos length
    {
        int mayor = arreglo[i]; // asumimos que el mayor es el primer elemento 
        int posMayor = i;
        for (int j = i + 1; j < arreglo.length; j++)
        {
            if(arreglo[j] > mayor)
            // comparamos los valores de i y el i + 1
            {
                mayor = arreglo[j];
                posMayor = j;
            }
        }
        // intercambiamos posiciones 
        int temporal = arreglo[i];
        arreglo[i] = mayor;
        arreglo[posMayor] = temporal;
    }
    
    return new MuestraOrdenada(arreglo);
}


// ------------------------------------------------------
//                     NIVEL AVANZADO
// ------------------------------------------------------

/**
* Retorna una muestra ordenada con los elementos del arreglo ordenados de forma descendente (de mayor a menor) usando el algoritmo de insercion
* @return Objeto MuestraOrdenada con los elementos ordenados de 
* mayor a menor
*/
public MuestraOrdenada ordenarInsercionDescendente()
{
    int[] arreglo = darCopiaValores();
    for( int i = 1; i < tamanio; i++)
    {
        for ( int j = i; j > 0 && arreglo[j-1] < arreglo[j]; j--)
        // al ser j > 0, hace que solo se haga una vez. Lo cual es lo que se requiere para el algoritmo
        {
            // intercambiamos posiciones si el elemento j es mayor a j-1
            int temporal = arreglo[j];
            arreglo[j] = arreglo[j-1];
            arreglo[j-1] = temporal;
        }
    }

    return new MuestraOrdenada(arreglo);
}


/**
* Busca un valor utilizando una búsqueda binaria, a partir de una muestra ordenada de mayor a menor (descendentemente)
* @param valor - Valor a buscar en el arreglo
* @return True si encontro el valor, false de lo contrario
*/
public boolean buscarBinarioDesc(int valor)
{
    // peor caso: no se encuentra el valor
    boolean encontrado = false;
    int[] muestra = ordenarInsercionDescendente().darCopiaValores();
    int inicio = 0;
    int fin = muestra.length - 1;
    // recordar que la busqueda binaria es dividir en 2 algun array, e ir descartando
    while (inicio <= fin && !encontrado)
    {
        int medio = (inicio + fin) / 2;
        if (muestra[medio] == valor)
            encontrado = true;
        else if (muestra[medio] > valor)
            // al ser descendente, en este caso la primera mitad no nos serviria
            inicio = medio + 1;
        else 
            fin = medio - 1;
    }
    
    return encontrado;
}


/**
* Obtiene la mediana a partir de una muestra ordenada descendentemente
* @return Mediana de la muestra
*/
public double obtenerMedianaMuestra()
{
    int[] arreglo = ordenarInsercionDescendente().darCopiaValores();
    
    double mediana = 0;
    int n = arreglo.length;
    
    if (n % 2 == 1) // es decir que es impar, solo tenemos que indexar
    {
        mediana = arreglo[(n + 1) / 2 - 1];
    }
    
    else // si es impar, debemos indexar y con esos resultados sacar la media 
    {
        mediana = (arreglo[n / 2 - 1] + arreglo[n / 2]) / 2;
    }
    return mediana;
}
