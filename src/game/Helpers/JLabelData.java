/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Helpers;

/**
 *
 * @author Usuario
 */
public class JLabelData
{
    private String name;
    private int backgroundPosX;
    private int backgroundPosY;
    private int textPosX;
    private int textPosY;
    private int width;
    private int height;

    public JLabelData() {}

    public JLabelData(int backgroundPosX, int backgroundPosY, int textPosX, int textPosY)
    {
        this.backgroundPosX = backgroundPosX;
        this.backgroundPosY = backgroundPosY;
        this.textPosX = textPosX;
        this.textPosY = textPosY;
    }

    public JLabelData(String name, int backgroundPosX, int backgroundPosY, int textPosX, int textPosY)
    {
        this.name = name;
        this.backgroundPosX = backgroundPosX;
        this.backgroundPosY = backgroundPosY;
        this.textPosX = textPosX;
        this.textPosY = textPosY;
    }

    public JLabelData(String name, int backgroundPosX, int backgroundPosY, int textPosX, int textPosY, int width, int height)
    {
        this.name = name;
        this.backgroundPosX = backgroundPosX;
        this.backgroundPosY = backgroundPosY;
        this.textPosX = textPosX;
        this.textPosY = textPosY;
        this.width = width;
        this.height = height;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getBackgroundPosX()
    {
        return backgroundPosX;
    }

    public void setBackgroundPosX(int backgroundPosX)
    {
        this.backgroundPosX = backgroundPosX;
    }

    public int getBackgroundPosY()
    {
        return backgroundPosY;
    }

    public void setBackgroundPosY(int backgroundPosY)
    {
        this.backgroundPosY = backgroundPosY;
    }

    public int getTextPosX()
    {
        return textPosX;
    }

    public void setTextPosX(int textPosX)
    {
        this.textPosX = textPosX;
    }

    public int getTextPosY()
    {
        return textPosY;
    }

    public void setTextPosY(int textPosY)
    {
        this.textPosY = textPosY;
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
}
