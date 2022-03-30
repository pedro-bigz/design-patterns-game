package game.Models.Ataque;


/**
 * Write a description of class Ataque here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Ataque
{
    private int forca;
    
    public void setForca(int forca) {
        this.forca = forca;
    }
    
    public int getForca() {
        return this.forca;
    }
    
    public int atacar(){
        return this.forca;
    }
}
