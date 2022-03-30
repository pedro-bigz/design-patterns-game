package game.Models.Ataque.Medieval;

import game.Models.Ataque.Ataque;
import game.Models.Ataque.Poder;
import static game.Utilities.medievalData;
import java.io.IOException;


/**
 * Write a description of class Encantamento here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Encantamento extends Poder
{
    private static Encantamento instancia = null;
    
    public Encantamento(Ataque poder) throws IOException {
        super(poder, medievalData.ataqueImagesPath.get("special"));
        super.setForca(7);
    }
    
    @Override
    public int atacar(){
        return super.atacar();
    }     
    
    public static synchronized Encantamento getInstance(Ataque poder)
        throws IOException
    {
        if (instancia == null) {
            instancia = new Encantamento(poder);
        }
        return instancia;
    }
}
