/**
* Calcula la duración promedio de las películas del pasajero.
* @return Duración promedio de las películas del pasajero; 0 en caso que el pasajero no tenga películas
*/

public double calcularDuracionPromedioPeliculas()
{
    double promedio = 0.0;
    int duracionTotal = 0;
    for (Pelicula pelicula: peliculas)
        duracionTotal += pelicula.darDuracion();
    
    if(peliculas.size() == 0)
        return promedio = 0.0;
    else 
        return promedio = duracionTotal / peliculas.size();
    
}


/**
* Retorna la película de menor duración del pasajero. En caso que no tenga películas, retorna null.
* @return Película más corta del pasajero; null en caso que no tenga
*/

public Pelicula darPeliculaMasCorta()
{
    // Creamos dos variables, una llamada "small" y otra llamada "smallest" y otra "the_smallest" que es tipo Pelicula
    Pelicula the_smallest = null;
    
    if (peliculas.size() > 0) 
    {
        Pelicula small = peliculas.get(0); 
        int n = 0;
        while (n < peliculas.size()) 
        {
            if (small.darDuracion() > peliculas.get(n).darDuracion())
                small = peliculas.get(n);
            n++;
        }
        the_smallest = small;
    }
    return the_smallest;
}


/**
* Busca la primera película del pasajero cuyo nombre empieza por la letra dada como parámetro
* @param letra - La letra por la cual empieza el nombre de la película buscada
* @return - Película cuyo nombre empieza por la letra dada; null en caso de no existir ninguna que empiece por 
* esa letra
*/

public Pelicula buscarPrimerPeliculaEmpiezaPor (char letra)
{
    Pelicula encontrada = null;
    if (peliculas.size() > 0)
    {
        int n = 0;
        while (n < peliculas.size())
        {
            Pelicula peliculaEn = peliculas.get(n);
            if (peliculaEn.darNombre().charAt(0) == letra)
            {
                encontrada = peliculaEn;
                break;
            }
            n++;
        }
    }
    return encontrada; 
}


/**
* Retorna la lista de pasajeros cuyas películas tienen una duración promedio mayor a la dada 
* como parámetro.
* @param duracion - Duración promedio mínima para que un pasajero sea incluido en 
* la lista respuesta 
* @return Lista con los pasajeros cuyas películas tienen una duración promedio mayor al parámetro
*/

public ArrayList<Pasajero> darPasajerosConDuracionPromedioPeliculasMayorA(int duracion)
{
    ArrayList<Pasajero> mayor_promedio = new ArrayList<Pasajero>();
    for (int i = 0; i < SILLAS_EJECUTIVAS; i++)
    {
        Silla sillaEj = sillasEjecutivas[i];
        if (sillaEj.sillaAsignada() == true)
        {
            if (sillaEj.darPasajero().calcularDuracionPromedioPeliculas() > duracion)
                mayor_promedio.add(sillaEj.darPasajero());
        }
    }
    
    for (int i = 0; i < SILLAS_ECONOMICAS; i++)
    {
        Silla sillaEc = sillasEconomicas[i];
        if (sillaEc.sillaAsignada() == true)
        {
            if (sillaEc.darPasajero().calcularDuracionPromedioPeliculas() > duracion)
                mayor_promedio.add(sillaEc.darPasajero());
        }
    }
    
    return mayor_promedio;
}


/**
* Retorna la película de menor duración en el avión
* @return - Película de menor duración en el avión; null en caso que no haya ninguna película en el avión
*/

public Pelicula darPeliculaMasCorta()
{
    Pelicula mas_corta = null;
    Silla sillaEj = sillasEjecutivas[0];
    Silla sillaEc = sillasEconomicas[0];
    
    for (int i = 0; i < SILLAS_EJECUTIVAS; i++)
    {
        Silla sillaEj2 = sillasEjecutivas[i];
        if (sillaEj.sillaAsignada() == true || sillaEj2.sillaAsignada() == true)
        {
            if (sillaEj.darPasajero().darPeliculaMasCorta().darDuracion() > sillaEj2.darPasajero().darPeliculaMasCorta().darDuracion())
                sillaEj = sillaEj2;
        }
    }
    
    for (int i = 0; i < SILLAS_ECONOMICAS; i++)
    {
        Silla sillaEc2 = sillasEconomicas[i];
        if (sillaEc.sillaAsignada() == true || sillaEc2.sillaAsignada() == true)
        {
            if (sillaEc.darPasajero().darPeliculaMasCorta().darDuracion() > sillaEc2.darPasajero().darPeliculaMasCorta().darDuracion())
                sillaEc = sillaEc2;
        }
    }
    
    if (sillaEc.darPasajero().darPeliculaMasCorta().darDuracion() > sillaEj.darPasajero().darPeliculaMasCorta().darDuracion())
        mas_corta = sillaEj.darPasajero().darPeliculaMasCorta();
    else
        mas_corta = sillaEc.darPasajero().darPeliculaMasCorta();

    return mas_corta;
}


/**
* Retorna la primera película del avión cuyo nombre inicia con la letra dada como parámetro
* @param letra - Letra por la cual inicia el nombre de la película buscada
* @return Primera película cuyo nombre inicia con la letra dada; null en caso de no existir ninguna 
* que empiece por esa letra
*/

public Pelicula darPrimerPeliculaEmpiezaPor(char letra)
{
    Pelicula pelicula_match = null;
    
    for (int i = 0; i < SILLAS_EJECUTIVAS; i++)
    {
        Silla sillaEj = sillasEjecutivas[i];
        if (sillaEj.darPasajero().buscarPrimerPeliculaEmpiezaPor(letra).darNombre().charAt(0) == letra)
            pelicula_match = sillaEj.darPasajero().buscarPrimerPeliculaEmpiezaPor(letra);
    }
    
    for (int i = 0; i < SILLAS_ECONOMICAS; i++)
    {
        Silla sillaEc = sillasEconomicas[i];
        if (sillaEc.darPasajero().buscarPrimerPeliculaEmpiezaPor(letra).darNombre().charAt(0) == letra)
            pelicula_match = sillaEc.darPasajero().buscarPrimerPeliculaEmpiezaPor(letra);
    }
    
    return pelicula_match;
}
