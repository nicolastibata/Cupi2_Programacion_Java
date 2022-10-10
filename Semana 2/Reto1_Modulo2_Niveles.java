// --------------------------------------------------------------------
// NIVEL BÁSICO 
// --------------------------------------------------------------------


/*
	* Cuenta el número de sillas económicas, que están ubicadas en la 
  * ventana y que se encuentran libres
  * @return - Número de sillas económicas libres y que están en la ventana
  */

    public int contarSillasEconomicasDesocupadasVentana()
    {
    	int contador = 0;
    	for (int i = 0; i < SILLAS_ECONOMICAS; i++)
    	{
    	    if (sillasEconomicas[i].sillaAsignada() == false && sillasEconomicas[i].darUbicacion() == 1)
    	        contador ++;
    	}
        return contador;
    }


/**
     * Cuenta el número de sillas económicas, que están ubicadas en el 
     * pasillo y que se encuentran libres
     * @return - Número de sillas económicas libres y que están en el pasillo
     */
    public int contarSillasEconomicasDesocupadasPasillo()
    {
    	int contador = 0;
    	for (int i = 0; i < SILLAS_ECONOMICAS; i++)
    	{
    	    if (sillasEconomicas[i].sillaAsignada() == false && sillasEconomicas[i].darUbicacion() == 3)
    	        contador ++;
    	}
        return contador;
    }


/**
     * Indica si hay por lo menos un cierto numero de sillas económicas *disponibles en el pasillo o en la ventana.
     * @param - nSillas - Minimo numero de sillas libres que se busca, ubicadas *en pasillo o ventana
     * @return - True si hay por lo menos nSillas libres en pasillo o ventana, *false en caso contrario
     */
    public boolean hayNumSillasEconomicasLibresPasilloVentana(int nSillas)
    {
        boolean disponibles = false;
        int contador = 0;
        for (int i = 0; i < SILLAS_ECONOMICAS; i++)
        {
            if (sillasEconomicas[i].sillaAsignada() == false && (sillasEconomicas[i].darUbicacion() == 1 || sillasEconomicas[i].darUbicacion() == 3))
                contador ++;
        }
        if (contador >= nSillas)
            disponibles = true;
        else 
            disponibles = false;
        return disponibles;
    }


/**
     * Busca la primera silla económica que este libre y tenga la ubicación *indicada, revisando desde la parte de atrás del avión
     * @param ubicacion - ubicación en donde buscar la silla - ubicacion *pertenece {VENTANA, CENTRAL, PASILLO}
     * @return La silla encontrada libre. Si no encuentra retorna null
     */
    public Silla buscarSillaEconomicaLibreReves(int ubicacion)
    {	
        Silla silla = null;
        for (int i = SILLAS_ECONOMICAS-1; i >= 0; i--)
        {
            silla = sillasEconomicas[i];
            if (silla.sillaAsignada() == false && silla.darUbicacion() == ubicacion)
                return silla;
        }
        return null;
    }


// --------------------------------------------------------------------
// NIVEL INTERMEDIO
// --------------------------------------------------------------------


/**
     * Retorna una lista con todas las sillas vacías del avión
     * @return - Lista con todas las sillas vacías del avión
     */
    public ArrayList<Silla> darSillasVacias()
    {
       ArrayList <Silla> silla_vacia = new ArrayList<Silla>();
        for (int i = 0; i < SILLAS_EJECUTIVAS; i++) // Sillas Ejecutivas Vacias 
        {
            Silla sillaE = sillasEjecutivas[i];
            if (sillaE.sillaAsignada() == false)
                silla_vacia.add(sillaE);
        }
        for (int i = 0; i < SILLAS_ECONOMICAS; i++) // Sillas Economicas Vacias
        {
            Silla sillaC = sillasEconomicas[i];
            if (sillaC.sillaAsignada() == false)
                silla_vacia.add(sillaC);
        }
        return silla_vacia;
    }


/**
     * Retorna el número total de sillas ocupadas en el avión
     * @return - Total de sillas ocupadas en el avión
     */
    public int darNumTotalSillasOcupadas()
    {
        int contador = contarSillasEjecutivasOcupadas() + contarSillasEconomicasOcupadas();
        return contador;
    }


/**
     * Indica si hay dos sillas vacías con la misma ubicación en el avión, *Solo se comparan sillas de la misma clase
     * @return - True si hay dos vacías con la misma ubicación, false de lo *contrario
     */
    public boolean hayDosSillasVaciasMismaUbicacion()
    {
        boolean hay_dos = false;
        for (int i = 0; i < SILLAS_EJECUTIVAS && !hay_dos; i++)
        {
            for (int j = 0; j < SILLAS_EJECUTIVAS && !hay_dos; j++)
            {
                if (sillasEjecutivas[i].darNumero() != sillasEjecutivas[j].darNumero())
                {
                    if (sillasEjecutivas[i].darUbicacion() == sillasEjecutivas[j].darUbicacion())
                    {
                        if (sillasEjecutivas[i].sillaAsignada() == false && sillasEjecutivas[j].sillaAsignada() == false )
                            return hay_dos = true;
                    }
                }
            }
        }
        for (int i = 0; i < SILLAS_ECONOMICAS && !hay_dos; i++)
        {
            for (int j = 0; j < SILLAS_ECONOMICAS && !hay_dos; j++)
            {
                if (sillasEconomicas[i].darNumero() != sillasEconomicas[j].darNumero())
                {
                    if (sillasEconomicas[i].darUbicacion() == sillasEconomicas[j].darUbicacion())
                    {
                        if (sillasEconomicas[i].sillaAsignada() == false && sillasEconomicas[j].sillaAsignada() == false )
                            return hay_dos = true;
                    }
                }
            }
        }
        return hay_dos;
    }


/**
     * Retorna el porcentaje de sillas económicas pares que están ocupadas
     * @return - Porcentaje de sillas económicas pares ocupadas
     */
    public double darPorcentajeSillasEconomicasOcupadasPares()
    {
        double porcentaje = 0.0;
        int sillasEconomicasOcupadasPares = 0;
        int sillasEconomicasPares = 0;
        
        for (int i = 0; i < SILLAS_ECONOMICAS; i++)
            if (sillasEconomicas[i].darNumero() % 2 == 0)
            {
                if (sillasEconomicas[i].sillaAsignada() == true)
                    sillasEconomicasOcupadasPares ++;
            }
        
        for (int i = 0; i < SILLAS_ECONOMICAS; i++)
            if (sillasEconomicas[i].darNumero() % 2 == 0)
                sillasEconomicasPares ++;
                
        porcentaje = (double)sillasEconomicasOcupadasPares / sillasEconomicasPares * 100;
        return porcentaje;
    }



