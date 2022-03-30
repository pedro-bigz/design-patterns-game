package game.Models.Ataque;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
/**
 * Abstract class Poder - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Poder extends Ataque
{
    private int ataque; 
    private Ataque superPoder;
    private BufferedImage image;

    public Poder(Ataque superPoder)
    {
        this.superPoder = superPoder;
    }

    public Poder(Ataque superPoder, BufferedImage image)
    {
        this.superPoder = superPoder;
        this.image = image;
    }

    public Poder(Ataque superPoder, String path) throws IOException
    {
        this.superPoder = superPoder;
        this.image = ImageIO.read(
            getClass().getResourceAsStream(path)
        );
    }
    
    public Ataque getSuperPoder()
    {
        return this.superPoder;
    }
    
    @Override
    public int atacar()
    {
        return this.superPoder.atacar() + super.getForca();
    }
    
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
    public BufferedImage getImage() {
        return this.image;
    }
    
}
