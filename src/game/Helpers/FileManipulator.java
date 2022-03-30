/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class FileManipulator {
    private String path;

    public FileManipulator() {}
    
    public FileManipulator(String path)
    {
        this.path = path;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    @Override
    public String toString()
    {
        return "Json{" + "path=" + path + '}';
    }

    public String read()
        throws FileNotFoundException, IOException
    {
        String linha = "", content = "";
        try (
            BufferedReader buffRead = new BufferedReader(
                new FileReader(this.path)
            )
        ) {
            while (linha != null) {
                linha = buffRead.readLine();
                if (linha != null) {
                    content += linha.trim();
                }            
            }
        }
        
        return content;
    }

    public String read(String path)
        throws FileNotFoundException, IOException
    {
        this.setPath(path);
        return this.read();
    }
    
    public static String getContent(String path)
        throws FileNotFoundException, IOException
    {
        return new FileManipulator(path).read();        
    }
}
