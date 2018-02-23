
/**
 * Write a description of class Comida here.
 * 
 * @author (Fernando) 
 * @version (Version 1.0)
 */
public class Comida
{
    //nombres de las comidas
    private String nombreDeComida;
    
    //calorias de la comida
    private int caloriasIngeridas;
    
    /**
     * Constructor for objects of class Comida
     * 
     * @param String con el nombre de la comida
     * @param int con el numero de calorias de la comida
     */
    public Comida(String nombreComida, int cantidadCalorias)
    {
        
        this.caloriasIngeridas= cantidadCalorias;
        this.nombreDeComida = nombreComida;
    }

    
    /**
     * metodo para obtener las calorias de la comida
     * 
     * @return devuelve un int con las calorias
     */
    public int getCalorias()
    {
        return caloriasIngeridas;
    }
    /**
     * metodo para obtener comida
     * 
     * @return devuelve un string con la comida
     */
    public String getNombreComida()
    {
        return nombreDeComida;
    }
}
