package game.Models.Ataque.Medieval;

import game.Models.Ataque.Ataque;
import game.Models.Ataque.Poder;
import static game.Utilities.medievalData;
import java.io.IOException;


/**
 * Write a description of class SuperSoco here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GolpeSagrado extends Poder
{
    private static GolpeSagrado instancia = null;
    
    public GolpeSagrado(Ataque poder) throws IOException {
        super(poder, medievalData.ataqueImagesPath.get("superchute"));
        super.setForca(5);
    }
    
    @Override
    public int atacar(){
        return super.atacar();
    }        
    
    public static synchronized GolpeSagrado getInstance(Ataque poder)
        throws IOException
    {
        if (instancia == null) {
            instancia = new GolpeSagrado(poder);
        }
        return instancia;
    } 
}
