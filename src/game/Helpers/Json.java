/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Helpers;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Usuario
 */
public class Json {
    private String path;

    public Json() {}
    
    public Json(String path)
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

    public JSONObject read()
        throws FileNotFoundException, IOException, JSONException
    {
        return new JSONObject(
            FileManipulator.getContent(path)
        );
    }

    public JSONObject read(String path)
        throws FileNotFoundException, IOException, JSONException
    {
        this.setPath(path);
        return this.read();
    }
}
