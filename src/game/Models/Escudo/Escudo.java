package game.Models.Escudo;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Abstract class Escudo - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Escudo
{
    private int defesa; 
    private Escudo next;
    private int x, y;
    private Color cor;
    private InputStream shield;
    private BufferedImage image;
    
    public Escudo() {}
    
    public Escudo(String path) {
        shield = getClass().getResourceAsStream(path);
        try
        {
            this.image = ImageIO.read(shield);
        }
        catch (java.io.IOException ioe)
        {
            ioe.printStackTrace();
        }
        
    }
    
    public Escudo(String path, int defesa) {
        shield = getClass().getResourceAsStream(path);
        try
        {
            this.image = ImageIO.read(shield);
        }
        catch (java.io.IOException ioe)
        {
            ioe.printStackTrace();
        }
        this.defesa = defesa;
        
    }
     
    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
    
    public int getDefesa () {
        return this.defesa;
    }
     
    public void setNext (Escudo escudo) {
        this.next = escudo;
    }
     
    public Escudo getNext () {
        return this.next;
    }

    public void setX (int x) {
        this.x = x;
    }
    
    public int getX () {
        return this.x;
    }
    
    public void setY (int y) {
        this.y = y;
    }
    
    public int getY () {
        return this.y;
    }
    
    public void setCor(Color cor) {
        this.cor = cor;
    }
    
    public Color getCor() {
        return this.cor;
    }
    
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
    public BufferedImage getImage() {
        return this.image;
    }
    
    public int processaAtaque(int ataque){
        int resultado = ataque - this.getDefesa();
        
        if (resultado > 0 && getNext() != null){
            return this.getNext().processaAtaque(resultado);
        }
        
        return resultado > 0 ? resultado : 0;
    }
    
    public void setRandomicPosition(int maxX, int maxY) {
        this.x = ThreadLocalRandom.current().nextInt(0, 800);
        this.y = ThreadLocalRandom.current().nextInt(120, 550); 
        
        //Random random = new Random();   
        //this.x = random.nextInt(maxX);
        //this.y = random.nextInt(maxY);
    }
    
    public void setRandomicPosition() {
        this.x = ThreadLocalRandom.current().nextInt(0, 800);
        this.y = ThreadLocalRandom.current().nextInt(120, 550); 
        
        //Random random = new Random();   
        //this.x = random.nextInt(maxX);
        //this.y = random.nextInt(maxY);
    }
}
