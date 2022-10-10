/**
* Retorna el número de pixeles que tienen el color dado como parámetro
* @param colorBuscado - Color de los pixeles a contar
* @return - Número de pixeles en la imagen con el color dado
*/
public int cuantosPixelColor(Color colorBuscado)
{
    int pixeles = 0;
    for (int i = 0; i < alto; i++)
    {
        for (int j = 0; j < ancho; j++)
        {
            if (bitmap[i][j].equals(colorBuscado))
            pixeles ++;
        }
    }
    return pixeles;
}


/**
* Retorna la tendencia de color de la imagen. Un pixel tiene un color de tendencia roja si su índice es mayor que los otros dos; lo mismo 
* sucede para los otros componentes. La tendencia de color de la imagen está definida entonces como el componente que tenga más pixeles con tendencia a ese color.
* @return - Tendencia de color de la imagen. Los posibles valores son:
* 0 si la imagen no presenta ninguna tendencia
* 1 si la tendencia es roja
* 2 si la tendencia es verde
* 3 si la tendencia es azul
*/
public int calcularTendencia()
{
    int resultado = -1;
    int contadorR = 0;
    int contadorG = 0;
    int contadorB = 0;
    
    for (int i = 0; i < alto; i++)
    {
        for (int j = 0; j < ancho; j++)
        {
            Color pixel = bitmap[i][j];
            if (pixel.getRed() > pixel.getGreen() || pixel.getRed() > pixel.getBlue())
                contadorR ++;
            else if (pixel.getGreen() > pixel.getRed() || pixel.getGreen() > pixel.getBlue())
                contadorG ++;
            else if (pixel.getBlue() > pixel.getRed() || pixel.getBlue() > pixel.getGreen())
                contadorB ++;
        }
    }
    if (contadorR > contadorG && contadorR > contadorB)
        resultado = 1;
    else if (contadorG > contadorR && contadorG > contadorB)
        resultado = 2;
    else if (contadorB > contadorR && contadorB > contadorG)
        resultado = 3;
    else 
        resultado = 0;
    return resultado;
}


/**
* Método que verifica si la imagen es oscura. 
* Una imagen es oscura si más del 60% de sus pixeles tienen componentes RGB menores a 10.
*/
public boolean esOscuraLaImagen()
{
    boolean es_oscura = false;
    double porcentaje = 0.0;
    int pixeles_oscuros = 0;
    int tamanio = alto*ancho;
    for (int i = 0; i < alto; i++)
    {
        for (int j = 0; j < ancho; j++)
        {
            Color pixel = bitmap[i][j];
            if (pixel.getRed() < 10 && pixel.getGreen() < 10 && pixel.getBlue() < 10)
                pixeles_oscuros ++;
        }
    }
    porcentaje = (double) pixeles_oscuros / tamanio * 100;
    if (porcentaje > 60.0)
        es_oscura = true;
    return es_oscura;
}


/**
* Rota la imagen 90 grados hacia la derecha
*/
public void rotar90ALaDerecha()
{
    int altox = alto;
    int anchox = ancho;
    Color temporal[][] = new Color[anchox][altox];
    int columna_extra = altox - 1;
    
    for (int i = 0; i < altox; i++ , columna_extra--)
    {
        for (int j = 0; j < anchox; j++)
        {
            temporal[j][columna_extra] = bitmap[i][j];
        }
    }
    alto = anchox;
    ancho = altox;
    temporal = bitmap;
}
