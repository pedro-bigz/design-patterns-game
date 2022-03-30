/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Models;

import game.Helpers.DataManager;
import game.Models.Escudo.Escudo;
import game.Helpers.JLabelData;
import game.Helpers.Posicao;
import game.Models.Ataque.Poder;
import game.Models.Inimigo.Inimigo;
import game.Models.Personagem.Jogador;
import game.Utilities;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Dictionary;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Game
{    
    protected int gameType;
    protected DataManager configs;
    
    private Jogador jogador;
    private ArrayList<Inimigo> enemys;
    private ArrayList<Escudo> escudos;
    private ImageIcon background;

    public Game(int gameType)
    {     
        this.gameType = gameType;
        if (gameType == 0) {
            this.configs = Utilities.medievalData;
            
        } else if (gameType == 1) {
            this.configs = Utilities.futuristicData;
            
        }
    } 

    public Game(int gameType, Jogador jogador, ArrayList<Inimigo> enemys, ArrayList<Escudo> escudos, ImageIcon background) {
        this.gameType = gameType;
        this.jogador = jogador;
        this.enemys = enemys;
        this.escudos = escudos;
        this.background = background;
        
        if (gameType == 0) {
            this.configs = Utilities.medievalData;
            
        } else if (gameType == 1) {
            this.configs = Utilities.futuristicData;
            
        }
    }
    
    public Jogador getJogador()
    {
        return jogador;
    }

    public void setJogador(Jogador jogador)
    {
        this.jogador = jogador;
    }

    public ArrayList<Escudo> getEscudos()
    {
        return escudos;
    }

    public void setEscudos(ArrayList<Escudo> escudos)
    {
        this.escudos = escudos;
    }

    public ArrayList<Inimigo> getEnemys()
    {
        return enemys;
    }

    public void setEnemys(ArrayList<Inimigo> enemys)
    {
        this.enemys = enemys;
    }

    public ImageIcon getBackgroundGame()
    {
        return background;
    }

    public void setBackgroundGame(ImageIcon background)
    {
        this.background = background;
    }
}
