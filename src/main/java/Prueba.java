import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.io.File;
import java.io.IOException;


public class Prueba {
    public static void main(String[] args) throws FileNotFoundException,IOException {

        File file = new File("m01.txt");
        File Lalee= new File("stop-word-list.txt");
        BufferedReader OWO = new BufferedReader(new FileReader(file));
        BufferedReader UWU = new BufferedReader(new FileReader(Lalee));
        String delimiters = "\\s+|,\\s*|\\.\\s*|\\;\\s*|\\:\\s*|\\!\\s*|\\¡\\s*|\\¿\\s*|\\?\\s*|\\-\\s*"
                + "|\\[\\s*|\\]\\s*|\\(\\s*|\\)\\s*|\\\"\\s*|\\_\\s*|\\%\\s*|\\+\\s*|\\/\\s*|\\#\\s*|\\$\\s*";
        String linea,los;



        while ((linea = OWO.readLine()) != null) {
            los = UWU.readLine();

            int u=0;
            int r=0;
            int t;
            String words[] = linea.split(delimiters);

            String Nwords[] = los.split(delimiters);



            Set<String> unicas = new HashSet<String>();
            Set<String> Repetidas   = new HashSet<String>();
            Set<String> quitar    = new HashSet<String>(Arrays.asList(Nwords));

            for (String a : words)

                if (!quitar  .contains(a)) {
                    u++;
                    if (!unicas .add(a)){
                        Repetidas.add(a);
                        r++;
                    }
                }
            t=(r*100)/u;
            unicas .removeAll(Repetidas);

            System.out.println("Palabras unicas:    " + unicas );
            System.out.println("Palabras repetirdas: " + Repetidas);
            System.out.println("El numero de palabras unicas es " + u+ ",  de palabras repetidas es "+r+" y el porcentaje de repeticion " +
                    "es "+ t+"%");
        }

    }}
