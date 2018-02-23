import java.util.ArrayList;

/**
 * La clase persona simula una persona que se le puede dar de comer.
 * @author (Fernando) 
 * @version (Version 1.0)
 */
public class Persona
{
    //nombre de la persona
    private String nombre;
    //sexo de la persona
    private boolean sexo;
    //peso de la persona
    private int peso;
    //altura de la persona
    private int altura;
    //edad de la persona
    private int edad;
    //comida ingerida de la persona
    private ArrayList<Comida> comidaIngerida;
    //calorias maximas
    private int caloriasMaximas;
    //calorias de los alimentos
    private int calorias;
    //longitud de la palabra divisible por 3 
    private int longitudPalabra;

    /**
     * Constructor for objects of class Persona
     * @param peso en kg
     * @param sexo true para hombres y false para mujeres
     * @param altura en cm
     */
    public Persona(String nombrePersona, boolean sexo, int peso, int altura, int edad)
    {
        comidaIngerida = new ArrayList();
        nombre = nombrePersona;
        longitudPalabra = 3;
        if (sexo){
            //maximo de calorias que puede ingerir una persona.
            caloriasMaximas = (10 * peso) + (6 * altura) + (5 * edad) + 5;
        }
        else{
            //maximo de calorias que puede ingerir una persona.
            caloriasMaximas = (10 * peso) + (6 * altura) + (5 * edad) - 161;
        }
    }

    /**
     * Metodo para dar de comer a la persona
     */
    public int comer(Comida comida){
        int caloriasIngeridas = -1;
        if (caloriasMaximas >= calorias){
            caloriasIngeridas = comida.getCalorias();
            calorias = caloriasIngeridas + calorias;
            comidaIngerida.add(comida);
        }
        return caloriasIngeridas;
    }

    /**
     * método que permite saber la cantidad de calorias que lleva ingerida una persona se denomina getCaloriasIngeridas,
     * no admite parámetros y devuelve un entero.
     * 
     * @return devuelve un int con las calorias que la persona ha ingerido en su totalidad.
     */
    public int getCaloriasIngeridas(){
        return calorias;
    }

    /**
     * Metodo que Ahora queremos que sea posible preguntarle cosas a la persona. 
     * Si no ha sobrepasado su metabolismo basal, te contestará "SI" o "NO" (¡en mayúsculas!) 
     * dependiendo de si la pregunta tiene una longitud (es decir, el número de letras de la misma) 
     * divisible por 3 o no, respectivamente.
     * 
     * En caso de que la persona ya haya sobrepasado el metabolismo basal o en el caso de que 
     * tu pregunta contenga el nombre de la persona, responderá con la misma pregunta que le has hecho pero gritando 
     * (es decir, el mismo texto de la pregunta pero en mayúsculas) indiferentemente de la longitud de a pregunta.
     * 
     * @param pide un string que es la pregunta que le hacemos
     * @return devuelve uns string con la respuesta
     */
    public String contestar(String pregunta)
    {
        boolean respuesta = false;
        if(caloriasMaximas < calorias || pregunta.contains(nombre)){
            System.out.println(pregunta.toUpperCase());
            pregunta = pregunta.toUpperCase();
            respuesta = true;
        }

        if (caloriasMaximas >= calorias && !respuesta){
            if(pregunta.length() % longitudPalabra == 0){
                System.out.println("SI");
                pregunta = "SI";
            }
            else{
                System.out.println("NO");
                pregunta= "NO";
            }
        }
        return pregunta;
    }

    /**
     * Metodo que imprima por pantalla y que devuelva el nombre de la comida más calórico 
     * ingerida hasta ahora por un usuario.
     * 
     * En caso de que la persona no haya comido nada el método infoma por pantalla de tal situación y devuelve null. 
     * En caso de que haya empate entre dos o más comidas, imprime y devuelve la última de ellas.
     * 
     * 
     */
    public String getAlimentoMasCaloricoConsumido()
    {
        Comida comidaMasCalorica= null;
        String nombreComida = null;
        for (Comida comida : comidaIngerida){
            if(comidaMasCalorica == null){
                comidaMasCalorica = comida;
                nombreComida = comidaMasCalorica.getNombreComida();
            }
            else{
                if (comidaMasCalorica.getCalorias() <= comida.getCalorias()){
                    comidaMasCalorica = comida;
                    nombreComida = comidaMasCalorica.getNombreComida();
                }
            }
        }

        if (comidaMasCalorica == null){
            System.out.println("La persona todavia no ha comida nada");
        }
        else{
            System.out.println(nombreComida);
        }
        
        return nombreComida;
    }
}
