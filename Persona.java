import java.util.ArrayList;
/**
 * La clase persona simula una persona que se le puede dar de coemr.
 * 
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
        if (sexo)
        {
            //maximo de calorias que puede ingerir una persona.
            caloriasMaximas = (10 * peso) + (6 * altura) + (5 * edad)+5;
        }
        else
        {
            caloriasMaximas = (10 * peso) + (6 * altura) + (5 * edad) - 161;
        }

    }

    /**
     * Metodo para dar de comer a la persona
     */
    public int comer(Comida comida){
        
        int caloriasIngeridas = -1;
        
        if (caloriasMaximas >= calorias)
        {
            caloriasIngeridas = comida.getCalorias();
            calorias =caloriasIngeridas + calorias;
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
     * Metodo para devolver el alimento ingerido con mas calorias
     * 
     * @return devuelve un string con el aliment con mas calorias
     */

}
