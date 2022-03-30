/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Views;

import game.Helpers.DataManager;
import game.Models.Escudo.Escudo;
import game.Helpers.JLabelData;
import game.Helpers.Posicao;
import game.Models.Ataque.Poder;
import game.Models.Game;
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
public abstract class GameView extends JPanel
{    
    protected int gameType;
    protected DataManager configs;
    
    protected Game game;

    GameView(int gameType)
    {     
        this.gameType = gameType;
        if (gameType == 0) {
            this.configs = Utilities.medievalData;
            
        } else if (gameType == 1) {
            this.configs = Utilities.futuristicData;
            
        }
    } 
    
    @Override
    public void paint(Graphics g)
    {
        Inimigo robo;
        Graphics2D g2d = (Graphics2D) g;
        JLabelData labelData;
        JLabelData jogadorLabel = (JLabelData) configs
            .personagemData.get("jlabel");
        
        // The call to "super.paint(g)", cleans the screen
        super.paint(g); 
        
        // The instruction; "g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        // RenderingHints.VALUE_ANTIALIAS_ON)" makes the borders of the figures smoother

        // g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        // RenderingHints.VALUE_ANTIALIAS_ON);
        
        if (game.getJogador() == null || game.getEnemys() == null) {
            System.exit(0);
        }

        game.getEscudos().forEach((Escudo escudo) -> {
            // g2d.fillOval(((Escudo) escudo).getX(), ((Escudo) escudo).getY(), 30, 30);
            g2d.drawImage(
                escudo.getImage(),
                ((Escudo) escudo).getX(),
                ((Escudo) escudo).getY(),
                30,
                30,
                null
            );
        });
        
        // g2d.drawString(jogador.getQuantidade(), 0 ,0);
        this.drawJogador(
            g2d,
            game.getJogador(),
            jogadorLabel
        );
        
        if (game.getJogador().isAttacking()) {
            if (game.getJogador().getAtaque() instanceof Poder) {
                Posicao ataqueDecodadoPosicao = (Posicao) configs
                    .ataqueDecoradoData.get("posicao");

                g2d.drawImage(
                    ((Poder) game.getJogador().getAtaque()).getImage(),
                    game.getJogador().getX() + ataqueDecodadoPosicao.getX(),
                    game.getJogador().getY() + ataqueDecodadoPosicao.getY(),
                    (Integer) configs.ataqueDecoradoData.get("width"),
                    (Integer) configs.ataqueDecoradoData.get("height"),
                    null         
                );
            }
        }
        
        for (int i = 0; i < game.getEnemys().size(); i++) {
            robo = game.getEnemys().get(i);            
            this.drawRobo(g2d, robo, configs.enemysData.get(i));
        }
    }
    
    public abstract void jogar(Game g) throws InterruptedException;
    public abstract void drawJogador(Graphics2D g2d, Jogador jogador, JLabelData jogadorLabel);
    public abstract void drawRobo(Graphics2D g2d, Inimigo robo, Dictionary<String, Object> enemyData);
    
    public abstract void setProximaFase();
}
