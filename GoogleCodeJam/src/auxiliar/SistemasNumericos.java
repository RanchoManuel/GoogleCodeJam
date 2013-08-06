package auxiliar;
import java.util.ArrayList;

/**
 * Clase en la que se resumen todos los algoritmos de cambio de base o cambio de codificacion
 * enseniados en el curso "Fundamentos de Sistemas Digitales"
 * @author jm.gonzalez1844
 */
public class SistemasNumericos {

        private final static String[] NUMEROS_BCD = {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001"}; 

        //TODO completar la documentacion de los metodos.
        /**
         * 
         * @param numero
         * @param base
         * @return
         * @throws InvalidAlgorithmParameterException
         */
        public static String baseRaDecimal(String numero, int base)throws Exception {
                double rta = 0;
                String[] partesDNumero = numero.split("(,|\\.)");
                /*
                 * En esta parte se hace la sumatoria de la parte Entera del numero.
                 */
                char[] parteEntera = partesDNumero[0].toCharArray();
                // en la formula n significa la cantidad de numeros enteros en el numero
                int n = parteEntera.length;
                for (int i = 0; i < parteEntera.length; i++) {
                        int valorNumerico = 0;
                        try {
                                valorNumerico = Integer.parseInt(parteEntera[i] + "");
                        } catch (NumberFormatException e) {
                                char letra = parteEntera[i];
                                valorNumerico = interpretarCaracter(letra, base);
                        }
                        if (valorNumerico >= base)
                                throw new Exception("Este caracter no pertenece a la base (" + base + "), "+ parteEntera[i]);
                        int pesoSegunPosicion = (int) Math.pow(base, n - (i + 1));
                        rta += valorNumerico * pesoSegunPosicion;
                }
                try {
                        char[] parteFraccional = partesDNumero[1].toCharArray();
                        for (int i = 0; i < parteFraccional.length; i++) {
                                int valorNumerico = 0;
                                try {
                                        valorNumerico = Integer.parseInt(parteFraccional[i] + "");
                                } catch (NumberFormatException e) {
                                        char letra = parteFraccional[i];
                                        valorNumerico = interpretarCaracter(letra, base);
                                }
                                if (valorNumerico >= base)
                                        throw new Exception("Este caracter no pertenece a la base (" + base+ "), " + parteFraccional[i]);
                                double pesoSegunPosicion = Math.pow(base, -(i + 1));
                                rta += valorNumerico * pesoSegunPosicion;
                        }
                } catch (ArrayIndexOutOfBoundsException e)
                {/*En caso de que el numero no tenga parte fraccional, no pasa nada*/}
                return rta + "";
        }

        /**
         * 
         * @param numero
         * @param baseO
         * @return
         * @throws Exception
         */
        public static String decimalABaseR(double numero, int baseO)throws Exception {
                String rta = "";
                int residuo = 0;
                String[] elNumero = (numero + "").split("\\.");
                /*
                 * Priimero se transforma la parte Entera del numero
                 */
                int numEntero = Integer.parseInt(elNumero[0]);
                ArrayList<Integer> aux = new ArrayList<Integer>();
                while (numEntero > 0) {
                        residuo = numEntero % baseO;
                        aux.add(residuo);
                        numEntero /= baseO;
                }
                // Como el numero esta al reves, se voltea
                for (int i = aux.size() - 1; i >= 0; i--) {
                        int traducido = aux.get(i);
                        rta += (traducido >= 10) ? convertirarCaracter(traducido): traducido;
                }
                /*
                 * Luego pasamos a transformar la parte fraccional
                 */
                int pEntera=(int) (numero/1);

                if((numero-pEntera)!=0)
                {
                        Double parteFraccionaria = Double.parseDouble("0." + elNumero[1]);
                        rta += '.';
                        // Para evitar ciclos infinitos existe un limite de 8 bits
                        // significativos
                        int contador = 0;
                        while (parteFraccionaria != 0 && contador < 8) {
                                parteFraccionaria *= baseO;
                                int parteEntera = (int) (parteFraccionaria / 1);
                                rta += (parteEntera >= 10) ? convertirarCaracter(parteEntera): parteEntera;
                                parteFraccionaria -= parteEntera;
                                contador++;
                        }
                }
                return rta;
        }

        /**
         * 
         * 
         * @param letra
         * @param base
         * @return
         * @throws InvalidAlgorithmParameterException
         */
        private static int interpretarCaracter(char letra, int base)throws Exception {
                int valorNumerico = (letra >= 'A' && letra <= 'Z')?((int) letra - 55):(letra >= 'a' && letra <= 'z')?((int) letra - 87) :-1;
                if (valorNumerico == -1)
                        throw new Exception("Este caracter no esta considerado");
                return valorNumerico;
        }

        /**
         * 
         * 
         * @param letra
         * @param base
         * @return
         * @throws InvalidAlgorithmParameterException
         */
        private static String convertirarCaracter(int letra)throws Exception {
                char valorNumerico = (char) ((letra >= 10 && letra <= 36) ? ((char) (letra + 55)): 0);
                if (valorNumerico == -1)
                        throw new Exception("Este caracter no esta considerado");
                return valorNumerico+"";
        }

        /**
         * 
         * @param num
         * @return
         */
        public static String binarioAGray(String num) {
                String resp="";
                char[] numero=num.toCharArray();
                for (int i = 0; i < numero.length; i++) {
                        resp+=(i==0)?(numero[i]+""):(numero[i]^numero[i-1]);
                }
                return resp;
        }

        /**
         * 
         * @param num
         * @return
         */
        public static String grayABinario(String num) {
                String resp="";
                char[] numero=num.toCharArray();
                char ultimo=0;
                for (int i = 0; i < numero.length; i++)
                {
                        if(i==0)
                        {
                                resp+=numero[i];
                                ultimo=numero[i];
                        }
                        else
                        {
                                int salida=(ultimo-48)^(numero[i]-48);
                                char aPoner = (char)(salida+48); 
                                resp+=aPoner;
                                ultimo=aPoner;
                        }
                }
                return resp;
        }

        public static String decimal_BCD(int decimal)
        {
                String resp="";
                String stringNumero= decimal+"";
                char[] digitos= stringNumero.toCharArray();
                for (int i = 0; i < digitos.length; i++) {
                        int num = Integer.parseInt(digitos[i]+"");
                        resp+=NUMEROS_BCD[num];
                }
                return resp;
        }

        public static void main(String[] args) throws Exception {
                System.out.println(decimalABaseR(11, 3));
        }

}