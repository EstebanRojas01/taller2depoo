package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )

    {
    	int[] copiaArregloEntero = new int[arregloEnteros.length];
    	for ( int i=0; i < arregloEnteros.length; i++) {copiaArregloEntero[i] = arregloEnteros[i];}
        return copiaArregloEntero;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
    	String[] copiaArregloCadena = new String[arregloCadenas.length];
    	for (int i = 0;i < arregloCadenas.length;i+=1){copiaArregloCadena[i]=arregloCadenas[i];}
        return copiaArregloCadena;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
        return arregloEnteros.length;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        return arregloCadenas.length;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
        int[] Añadido = new int[arregloEnteros.length + 1];
        for (int i = 0; i < arregloEnteros.length; i++) {Añadido[i] = arregloEnteros[i];}
        Añadido[arregloEnteros.length] = entero;
        arregloEnteros = Añadido;
        
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	String[] Añadido = new String[arregloCadenas.length + 1];
    	for (int i = 0; i < arregloCadenas.length; i++){Añadido[i] = arregloCadenas[i];}
    	Añadido[arregloCadenas.length] = cadena;
    	arregloCadenas = Añadido;

    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	int aparicion = contarApariciones(valor);
    	int[] ArregloEliminado = new int[arregloEnteros.length-aparicion];
    	int j = 0;
    	for (int i = 0; i < arregloEnteros.length; i+=1){
    		if (arregloEnteros[i]!=valor) {ArregloEliminado[j]=arregloEnteros[i];j+=1;}}
    	arregloEnteros = ArregloEliminado;

    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	int aparicion = 0;
    	
    	for (int i = 0; i < arregloCadenas.length; i+=1){
    		if(arregloCadenas[i]==cadena) {aparicion+=1;}}
    	
    	String[] ArregloEliminado = new String[arregloCadenas.length-aparicion];
    	int j = 0;
    	for (int i = 0; i < arregloCadenas.length; i+=1){
    		if (arregloCadenas[i]!=cadena) {ArregloEliminado[j]=arregloCadenas[i];j+=1;}}
    	arregloCadenas = ArregloEliminado;
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	int[] Añadido = new int[arregloEnteros.length + 1];
    	
    	if (posicion<=0) {
    		Añadido[0]=entero;
    		for (int i = 0; i < arregloEnteros.length; i+=1) {Añadido[i+1] = arregloEnteros[i];}}
    	
    	else if (posicion>=arregloEnteros.length) {
			Añadido[arregloEnteros.length]=entero;
			for (int i = 0; i < arregloEnteros.length; i+=1) {Añadido[i] = arregloEnteros[i];}}
    	
    	else for (int i = 0; i < arregloEnteros.length; i+=1) {		
    		Añadido[posicion] = entero;
    		if (i<posicion) {Añadido[i] = arregloEnteros[i];}
    		else if (i>=posicion) {Añadido[i+1] = arregloEnteros[i];}
    	}
    	arregloEnteros = Añadido;
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	int[] Eliminado = new int[arregloEnteros.length - 1];
    	if (posicion<arregloEnteros.length && posicion>=0) 
    	{
    		for (int i=0;i<arregloEnteros.length;i++) {
    			if (i<posicion) {Eliminado[i]=arregloEnteros[i];}
    			else if (i>posicion) {Eliminado[i-1]=arregloEnteros[i];}}
    		arregloEnteros=Eliminado;
    		}
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	int[] reinicio = new int[valores.length];
    	for(int i=0;i<valores.length;i++) {reinicio[i]=(int) valores[i];}
    	arregloEnteros=reinicio;
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	String[] reinicio = new String[objetos.length];
    	for(int i=0;i<objetos.length;i++) {reinicio[i]= objetos[i].toString();}
    	arregloCadenas=reinicio;

    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	int[] positivos = new int[arregloEnteros.length];
    	for(int i=0;i<arregloEnteros.length;i++) {
    		if (arregloEnteros[i]<0) {positivos[i]=arregloEnteros[i]*-1;}
    		else {positivos[i]=arregloEnteros[i];}
    	}
    	arregloEnteros=positivos;

    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    //implemente un shell sort
    {
    	int tamaño = arregloEnteros.length;
    	for (int mitad = tamaño / 2; mitad > 0; mitad /= 2) {
            for (int i = mitad; i < tamaño; i++) {
                int insercion = arregloEnteros[i];
                int j;
                for (j = i; j >= mitad && arregloEnteros[j - mitad] > insercion; j -= mitad) {
                	arregloEnteros[j] = arregloEnteros[j - mitad];}
                arregloEnteros[j] = insercion;}}

    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    //implemente un shell sort y use la funcion compareTo, la modificacion radica en que la funcion de positivo cuando el
    //primer string es mayor al segundo, de este modo sabemos el orden de movimiento

    	int tamaño = arregloCadenas.length;
    	for (int mitad = tamaño / 2; mitad > 0; mitad /= 2) {
            for (int i = mitad; i < tamaño; i++) {
                String insercion = arregloCadenas[i];
                int j;
                for (j = i; j >= mitad && arregloCadenas[j - mitad].compareTo(insercion) > 0; j -= mitad) {
                	arregloCadenas[j] = arregloCadenas[j - mitad];}
                arregloCadenas[j] = insercion;}}
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	int apariciones = 0;
    	for (int i = 0; i < arregloEnteros.length; i+=1) {
    		if (arregloEnteros[i] == valor ) {apariciones+=1;}}
        return apariciones;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	int apariciones = 0;
    	
    	for(int i = 0; i < arregloCadenas.length; i++) {
    		if(arregloCadenas[i].toLowerCase().contains(cadena.toLowerCase())) {
    			apariciones+=1;}}
    	return apariciones;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
    	int apariciones = contarApariciones(valor);
    	int[] posiciones = new int[apariciones];
    	int j = 0;
    	for(int i=0;i<arregloEnteros.length;i++){
    		if(arregloEnteros[i]==valor) {posiciones[j]=i;j++;}
    	}
        return posiciones;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
    	int[] MaxMin= new int[arregloEnteros.length];
    	if (arregloEnteros.length!=0) {
    	MaxMin = new int[]{0,0};}
    	
    	for(int i = 0;i<arregloEnteros.length;i++){
    		if (arregloEnteros[i]<=MaxMin[0]) {MaxMin[0]=arregloEnteros[i];}
    		if (arregloEnteros[i]>=MaxMin[1]) {MaxMin[1]=arregloEnteros[i];}
    	}
        return MaxMin;
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
    	HashMap<Integer, Integer> histograma = new HashMap<>();
    	for (int valor : arregloEnteros) {
    		if(histograma.containsKey(valor)) {
    		int contador = histograma.get(valor);
            histograma.replace(valor, contador, contador+1);}
    		else histograma.put(valor, 1);
        }
        return histograma;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
    	HashMap<Integer, Integer> histograma = new HashMap<>();
    	for (int valor : arregloEnteros) {
    		if(histograma.containsKey(valor)) {
    		int contador = histograma.get(valor);
            histograma.replace(valor, contador, contador+1);}
    		else histograma.put(valor, 1);
        }
    	HashMap<Integer, Integer> MasDeDos = new HashMap<>();
    	for (int valor : arregloEnteros) {
    		if(histograma.containsKey(valor) && histograma.get(valor)>=2) {
    			MasDeDos.put(valor, null);
    		}}
    			
    	
        return MasDeDos.size();
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	boolean igualdad = false;
    	if(arregloEnteros.length==otroArreglo.length) {
    		igualdad = true;
    		for(int i=0;i<arregloEnteros.length;i++) {
    			if(arregloEnteros[i]!=otroArreglo[i]) {
    				return false;
    			}
    		}
    	}
        return igualdad;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {   
    	if (otroArreglo.length!=0 && arregloEnteros.length!=0) {
    	HashMap<Integer, Integer> primerArreglo = new HashMap<>();
    	for (int valor1 : arregloEnteros) {
    		if(primerArreglo.containsKey(valor1)) {
    		int contador = primerArreglo.get(valor1);
    		primerArreglo.replace(valor1, contador, contador+1);}
    		else primerArreglo.put(valor1, 1);
    	}
		HashMap<Integer, Integer> segundoArreglo = new HashMap<>();
    	for (int valor2 : arregloEnteros) {
    		if(segundoArreglo.containsKey(valor2)) {
    		int contador = segundoArreglo.get(valor2);
    		segundoArreglo.replace(valor2, contador, contador+1);}
    		else segundoArreglo.put(valor2, 1);
    	}
    	for(int valor3 : primerArreglo.keySet()) {
    		if (!segundoArreglo.containsKey(valor3)) {return false;}
    		else if (segundoArreglo.get(valor3)!=primerArreglo.get(valor3)) {return false;}
    		;}
    		return true;
    	}
    	else if (otroArreglo.length!=0 && arregloEnteros.length==0) {
    		return false;
    	}
    	else if (otroArreglo.length==0 && arregloEnteros.length!=0) {
    		return false;
    	}
        return true;
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	arregloEnteros = new int[cantidad];
    	
        for (int i = 0; i < arregloEnteros.length; i++) {
            arregloEnteros[i] = ((int) (Math.random() * (maximo - minimo + 1)) + minimo);
        }
    }

}
