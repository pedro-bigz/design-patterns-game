/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Helpers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Usuario
 */
public final class Image {
    private String path;
    private int width;
    private int height;
    public String descricao;

    public Image() {}

    public Image(String path)
    {
        this.path = path;
        setDimensions();
    }

    public Image(String path, int width, int height)
    {
        this.path = path;
        this.width = width;
        this.height = height;
    }

    public Image(String path, int width, int height, String descricao)
    {
        this.path = path;
        this.width = width;
        this.height = height;
        this.descricao = descricao;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    private void setDimensions()
    {
        BufferedImage img;
        try {
            img = ImageIO.read(
                new File(getPwd() + this.path)
            );
            this.width = img.getWidth();
            this.height = img.getHeight();
        } catch (IOException ex) {
            Logger.getLogger(Image.class.getName())
                .log(Level.SEVERE, null, ex);
        }
    }
    
    public String getPwd()
    {
        return FileSystems.getDefault()
            .getPath("").toAbsolutePath() +
            getPathSuffix();
    }
    
    public String getPathSuffix()
    {
        return "\\src\\qa\\";
    }
}
