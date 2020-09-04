import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @author COLOQUE AQUI SU NOMBRE COMPLETO
 * @author COLOQUE AQUI SU MATRICULA
 */
public class ExpRegSearcher {

    public static final int ALFABETICO_GLOBAL_ASCENDENTE = 1;
    public static final int POR_LONGITUD_GLOBAL_DESCENDENTE = 2;
    public static final int ALFABETICO_POR_LINEA_ASCENDENTE= 3;
    
    /**
     * El programa principal se ejecuta mandandole de manera inicial un
     * argumento que puede ser:
     *      -a  Indica que el resultado se desea ordenado alfabeticamente 
     *          de manera global
     *      -l  Indica que el resultado se desea ordenado por longitud 
     *          descendente de manera global
     *      -p  Indica que el resultado se desea ordenado alfabeticamente
     *          por linea
     * Si no se indica ningun argumento (o se especifica uno invalido) se tomara
     * como si se hubiera dado -a
     * NOTA: En los casos que se menciona que se desea el resultado en orden
     * alfabetico tome en cuenta que en caso de que en el resultado haya 
     * una mezcla de mayusculas y minusculas primero saldran las
     * minusculas y posteriormente las mayusculas (comportamiento normal al
     * ordenar Strings)
     * @param args Argumentos al programa (solo nos fijamos en 1, que es opcional)
     */
    public static void main(String[] args) {        
        ExpRegSearcher searcher = new ExpRegSearcher();
        int tipoAUsar = ALFABETICO_GLOBAL_ASCENDENTE; // Tipo por default       
        if (args.length>=1) {  // Se determina si es que se dio un argumento
            // Y si es asi se coloca en tipoAUsar el valor que corresponda
            if (args[0].equals("-l")) {
                tipoAUsar = POR_LONGITUD_GLOBAL_DESCENDENTE;
            }
            else if (args[0].equals("-p")) {
                tipoAUsar = ALFABETICO_POR_LINEA_ASCENDENTE; 
            }
        }
        searcher.procesaEntrada(tipoAUsar);
    }
    
    /**
     * Este metodo lee lineas de la entrada estandar (teclado)
     * y las procesa de acuerdo a lo siguiente:
     * La primer linea de entrada contiene una expresion regular 
     * Cada una de las lineas siguientes es almacenada en 
     * un ArrayList para su posterior procesamiento. 
     * Se indica que ya no hay nada por leer dando de entrada una linea vacia.
     */
    private void procesaEntrada(int tipo) {
        BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in));
        String expReg;
        ArrayList<String> lineas = new ArrayList<>();
        ArrayList<String> resultado = new ArrayList<>();
        try {
            // Leemos la primera linea (que contiene la expresion regular
            expReg=in.readLine();
            // Creamos un Pattern a partir de esta expresion regular
            Pattern p = Pattern.compile(expReg);
            // A partir de la segunda linea se especifican textos donde se 
            // estara buscando la expresion regular, tales lineas
            // se almacenan en un arreglo para su posterir procesamiento
            String linea=in.readLine();
            while (linea!=null && !linea.isEmpty()) {  // Mientras haya otra linea mas y no este vacia              
                lineas.add(linea); // Almacenamos en ArrayList
                linea=in.readLine();
            }
            in.close();
            // Dependiendo del argumento dado al ejecutar el programa
            // se hace la busqueda de la expresion regular
            // llamando al metodo que corresponda
            switch (tipo) {
                case ALFABETICO_GLOBAL_ASCENDENTE:
                    resultado = obtenAlfabeticamenteGlobal(p, lineas);
                    break;
                case POR_LONGITUD_GLOBAL_DESCENDENTE:
                    resultado = obtenPorLongitudDescGlobal(p, lineas);
                    break;
                case ALFABETICO_POR_LINEA_ASCENDENTE:                   
                    resultado = obtenAlfabeticoPorLinea(p, lineas);
            }
            // Por cada String contenido en el resultado dado por el
            // metodo al que se llamo, se hace una impresion de tal String
            for(String s:resultado) {
                System.out.println(s);
            }
        } 
        catch (IOException eio) {  // En caso de excepcion de E/S
            System.out.println("Error al leer entrada.");
        }
        catch (PatternSyntaxException ep) { // En caso de error en la expresion
            System.out.println("ERROR EN EXPRESION REGULAR");
        }   
    }

    /**
     * Este metodo busca un patron el patron en las lineas dadas como argumento
     * y regresa una lista con todos los Strings que concordaron con el patron
     * ordenados de manera ascendente
     * @param patron Pattern que representa el patron a buscar
     * @param lineas ArrayList con las lineas de texto donde se hara la busqueda
     * @return ArrayList con los Strings que concuerdan con el patron 
     *          (ordenados de manera ascendente)
     */
    public ArrayList<String> obtenAlfabeticamenteGlobal(Pattern patron, 
            ArrayList<String> lineas) {
        ArrayList<String> resultado = new ArrayList<>();
        // TODO
        return resultado;        
    }
    
    /**
     * Este metodo busca un patron el patron en las lineas dadas como argumento
     * y regresa una lista con todos los Strings que concordaron con el patron
     * ordenados de manera descendente por longitud, es decir, del String
     * mas largo al String mas corto
     * @param patron Pattern que representa el patron a buscar
     * @param lineas ArrayList con las lineas de texto donde se hara la busqueda
     * @return ArrayList con los Strings que concuerdan con el patron 
     *          (ordenados de manera descendente de acuerdo a su longitud)
     */
    public ArrayList<String> obtenPorLongitudDescGlobal(Pattern patron, 
            ArrayList<String> lineas) {
        ArrayList<String> resultado = new ArrayList<>();
        // TODO
        return resultado;
    }
    
    /**
     * Este metodo busca un patron el patron en las lineas dadas como argumento
     * y regresa una lista con todos los Strings que concordaron con el patron
     * ordenados de manera ascendente (agrupados por linea, es decir,
     * primero estaran los Strings que concuerdan en la primer linea ordenados
     * de manera ascendente, despues los que concuerdan en la segunda linea
     * ordenados de manera ascendente, y asi sucesivamente)
     * @param patron Pattern que representa el patron a buscar
     * @param lineas ArrayList con las lineas de texto donde se hara la busqueda
     * @return ArrayList con los Strings que concuerdan con el patron 
     *          (ordenados de manera ascendente y agrupados por linea)
     */
    public ArrayList<String> obtenAlfabeticoPorLinea(Pattern patron, 
            ArrayList<String> lineas) {
        ArrayList<String> resultado = new ArrayList<>();
        // TODO
        return resultado;
    }
    
    
}
