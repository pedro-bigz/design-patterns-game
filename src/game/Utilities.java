/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.Helpers.ColorFinder;
import game.Helpers.DataManager;
import game.Helpers.Dir;
import game.Helpers.JLabelData;
import game.Helpers.Json;
import game.Helpers.Posicao;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Usuario
 */
public class Utilities
{
    private final static String PATH = Dir.configsPath() + "/common-properties.json";
    
    public static DataManager medievalData = new DataManager();
    public static DataManager futuristicData = new DataManager();
    
    public final static int HEIGHT = 571;
    public final static int WIDTH = 999;

    public static String getPATH() {
        return PATH;
    }
    
    @SuppressWarnings("UseOfObsoleteCollectionType")
    public static void readConfigs()
    {
        String medievalPATH, futuristicPATH;
        try {            
            JSONObject obj = new Json(PATH).read();
            JSONObject paths = obj.getJSONObject("paths");
            
            medievalPATH = Dir.configsPath() + "/" + paths.getString("medieval");
            futuristicPATH = Dir.configsPath() + "/" + paths.getString("futuristic");
            
            Json jsonContentMedieval = new Json(medievalPATH);
            Json jsonContentFuturistic = new Json(futuristicPATH);
            
            JSONObject medievalObj = jsonContentMedieval.read();             
            JSONObject futuristicObj = jsonContentFuturistic.read();
            
            load(medievalData, medievalObj); 
            load(futuristicData, futuristicObj);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | JSONException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static JSONObject getSubjects(JSONObject obj)
        throws JSONException
    {
        return (JSONObject) obj.get("subjects");
    }
   
    private static void load(DataManager manager, JSONObject obj)
        throws JSONException
    {
        JSONObject subject = getSubjects(obj);
        
        loadBackground(manager, obj);
        loadImages(manager, obj);
        loadPersonagemData(manager, subject);
        loadEnemyData(manager, subject);
        loadAtaqueDecoradosData(manager, obj);
    }
    
    private static void loadBackground(DataManager manager, JSONObject obj)
        throws JSONException
    {
        JSONObject backgrounds = obj.getJSONObject("backgrounds");
        manager.setBackgroundPathFase1(backgrounds.getString("fase1"));
        manager.setBackgroundPathFase2(backgrounds.getString("fase2"));
        manager.setBackgroundPathFase3(backgrounds.getString("fase3"));
    }
    
    private static void loadImages(DataManager manager, JSONObject obj)
        throws JSONException
    {
        JSONObject images = obj.getJSONObject("images");
        
        loadCharacterPaths(manager, images);
        loadAtaqueImages(manager, images);
    }
    
    private static void loadCharacterPaths(DataManager manager, JSONObject obj)
        throws JSONException
    {
        String key;
        JSONObject characters = obj.getJSONObject("characters");
        Iterator<String> keys = characters.keys();
        
        while(keys.hasNext()) {
            key = keys.next();
            manager.characterPaths.put(key, characters.getString(key));
        }
    }
    
    private static void loadAtaqueImages(DataManager manager, JSONObject obj)
        throws JSONException
    {
        String key;
        JSONObject characters = obj.getJSONObject("ataques");
        Iterator<String> keys = characters.keys();
        
        while(keys.hasNext()) {
            key = keys.next();
            manager.ataqueImagesPath.put(key, characters.getString(key));
        }
    }
    
    private static void loadPersonagemData(DataManager manager, JSONObject obj)
        throws JSONException
    {
        String key;
        JSONObject personagem = obj.getJSONObject("personagem");
        JSONObject posicao = personagem.getJSONObject("posicao");
        JSONObject dimensions = personagem.getJSONObject("dimensions");
        Iterator<String> keys = personagem.keys();
        
        Posicao pos = new Posicao(
            posicao.getInt("x"),
            posicao.getInt("y"),
            Utilities.WIDTH - dimensions.getInt("w"),
            Utilities.HEIGHT - dimensions.getInt("h")
        );
          
        while(keys.hasNext()) {
            key = keys.next();
            
            if (personagem.get(key) instanceof String) {
                manager.personagemData.put(key, personagem.getString(key)); 
            }
        }
        
        manager.personagemData.put(
            "jlabel",
            loadJLabelProps(
                personagem.getJSONObject("jlabel")
            )
        );
        manager.personagemData.put(
            "width",
            dimensions.getInt("w")
        );
        manager.personagemData.put(
            "height",
            dimensions.getInt("h")
        );
        manager.personagemData.put(
            "posicao",
            pos
        );
    }
    
    private static void loadEnemyData(DataManager manager, JSONObject obj)
        throws JSONException
    {
        JSONObject enemy = null;
        JSONObject posicao = null;
        JSONObject dimensions = null;
        JSONObject jlabel = null;
        JSONArray enemys = obj.getJSONArray("enemys");
        Dictionary<String, Object> enemyData = null;        
        
        for (int i = 0; i < enemys.length(); i++) {
            enemyData = new Hashtable<>();
            enemy = enemys.getJSONObject(i);
            
            posicao = enemy.getJSONObject("posicao");
            dimensions = enemy.getJSONObject("dimensions");
            jlabel = enemy.getJSONObject("jlabel");
            
            Posicao pos = new Posicao(
                posicao.getInt("x"),
                posicao.getInt("y"),
                Utilities.WIDTH - dimensions.getInt("w"),
                Utilities.HEIGHT - dimensions.getInt("h")
            );
        
            enemyData.put(
                "name",
                enemy.getString("name")
            );
            enemyData.put(
                "image",
                enemy.getString("image")
            );
            enemyData.put(
                "jlabel",
                loadJLabelProps(jlabel)
            );
            enemyData.put(
                "color",
                ColorFinder.getColorByName(enemy.getString("color"))
            );
            enemyData.put(
                "width",
                dimensions.getInt("w")
            );
            enemyData.put(
                "height",
                dimensions.getInt("h")
            );
            enemyData.put(
                "posicao",
                pos
            );
            
            manager.enemysData.add(enemyData);
        }
    }

    private static JLabelData loadJLabelProps(JSONObject jlabel)
        throws JSONException
    {
        JSONObject background = jlabel.getJSONObject("background")
            .getJSONObject("posicao");
        
        JSONObject text = jlabel.getJSONObject("text")
            .getJSONObject("posicao");
        
        JSONObject dimensoes = jlabel.getJSONObject("dimensions");
        
        return new JLabelData(
            jlabel.getString("name"),
            background.getInt("x"),
            background.getInt("y"),
            text.getInt("x"),
            text.getInt("y"),
            dimensoes.getInt("w"),
            dimensoes.getInt("h")
        );
    }
    
    private static void loadAtaqueDecoradosData(DataManager manager, JSONObject obj)
        throws JSONException
    {
        JSONObject ataqueData = obj.getJSONObject("ataqueDecorados");
        JSONObject posicao = ataqueData.getJSONObject("posicao");
        JSONObject dimensoes = ataqueData.getJSONObject("dimensions");
            
        manager.ataqueDecoradoData.put(
            "posicao",
            new Posicao(
                posicao.getInt("x"),
                posicao.getInt("y")
            )
        );
        manager.ataqueDecoradoData.put(
            "width",
            dimensoes.getInt("w")
        );
        manager.ataqueDecoradoData.put(
            "height",
            dimensoes.getInt("h")
        );
    }
}
