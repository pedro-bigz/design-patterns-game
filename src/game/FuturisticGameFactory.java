/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.Helpers.Posicao;
import game.Helpers.RandomGenerator;
import game.Models.Escudo.Escudo;
import game.Models.Escudo.EscudoForte;
import game.Models.Escudo.EscudoFraco;
import game.Models.Escudo.EscudoMedio;
import game.Models.Inimigo.Inimigo;
import game.Models.Inimigo.RoboForte;
import game.Models.Movimento.MovimentoRapido;
import game.Models.Personagem.Futurista.SimplePersonagemFuturisticFactory;
import game.Models.Personagem.Jogador;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Usuario
 */
public class FuturisticGameFactory extends GameFactory
{
    private static FuturisticGameFactory instance = new FuturisticGameFactory();

    private FuturisticGameFactory() {}    

    public static FuturisticGameFactory getInstance()
    {
        return instance;
    }
    
    @Override
    public Jogador criarJogador()
    {
        try {
            return SimplePersonagemFuturisticFactory
                .criaPersonagem(RandomGenerator.getFloat());
        } catch (IOException ex) {
            Logger.getLogger(FuturisticGameFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public ArrayList<Inimigo> criarInimigos()
    {
        ArrayList<Inimigo> enemys = new ArrayList<>();
        
        Utilities.futuristicData.enemysData.forEach(new Consumer<Dictionary<String, Object>>() {
            @Override
            public void accept(Dictionary<String, Object> enemy) {
                try {
                    Inimigo robo = new Inimigo(
                        (Posicao) enemy.get("posicao"),
                        (Integer) enemy.get("width"),
                        (Integer) enemy.get("height"),
                        (String) enemy.get("name"),
                        (String) enemy.get("image")
                    );
                    enemys.add(robo);
                } catch (IOException ex) {
                    Logger.getLogger(MedievalGameFactory.class.getName())
                            .log(Level.SEVERE, null, ex);
                    
                    System.exit(0);
                }
            }
        });
        
        return enemys;
    }
    
    @Override
    public ArrayList<Inimigo> criarInimigos(int n)
    {
        ArrayList<Inimigo> enemys = new ArrayList<>();
        Dictionary<String, Object> enemyData;
        
        for (int i = 0; i < n; i++) {
            try {
                enemyData = Utilities.futuristicData.enemysData.get(i);
                Inimigo robo = new Inimigo(
                    (Posicao) enemyData.get("posicao"),
                    (Integer) enemyData.get("width"),
                    (Integer) enemyData.get("height"),
                    (String) enemyData.get("name"),
                    (String) enemyData.get("image")
                );
                enemys.add(robo);
            } catch (IOException ex) {
                Logger.getLogger(FuturisticGameFactory.class.getName())
                        .log(Level.SEVERE, null, ex);

                System.exit(0);
            }
        }
        
        return enemys;
    }
    
    @Override
    public ArrayList<Inimigo> criarInimigosRapidos()
    {
        ArrayList<Inimigo> enemys = new ArrayList<>();
        
        Utilities.futuristicData.enemysData.forEach(new Consumer<Dictionary<String, Object>>() {
            @Override
            public void accept(Dictionary<String, Object> enemy) {
                try {
                    Inimigo robo = new Inimigo(
                        (Posicao) enemy.get("posicao"),
                        (Integer) enemy.get("width"),
                        (Integer) enemy.get("height"),
                        (String) enemy.get("name"),
                        (String) enemy.get("image")
                    );
                    robo.setMovimento(MovimentoRapido.getInstance());
                    enemys.add(robo);
                } catch (IOException ex) {
                    Logger.getLogger(MedievalGameFactory.class.getName())
                            .log(Level.SEVERE, null, ex);
                    
                    System.exit(0);
                }
            }
        });
        
        return enemys;
    }
    
    @Override
    public ArrayList<Inimigo> criarInimigosRapidos(int n)
    {
        ArrayList<Inimigo> enemys = new ArrayList<>();
        Dictionary<String, Object> enemyData;
        
        for (int i = 0; i < n; i++) {
            try {
                enemyData = Utilities.futuristicData.enemysData.get(i);
                Inimigo robo = new Inimigo(
                    (Posicao) enemyData.get("posicao"),
                    (Integer) enemyData.get("width"),
                    (Integer) enemyData.get("height"),
                    (String) enemyData.get("name"),
                    (String) enemyData.get("image")
                );
                robo.setMovimento(MovimentoRapido.getInstance());
                enemys.add(robo);
            } catch (IOException ex) {
                Logger.getLogger(FuturisticGameFactory.class.getName())
                        .log(Level.SEVERE, null, ex);

                System.exit(0);
            }
        }
        
        return enemys;
    }
    
    @Override
    public ArrayList<Inimigo> criarInimigosFortes()
    {
        ArrayList<Inimigo> enemys = new ArrayList<>();
        
        Utilities.futuristicData.enemysData.forEach(new Consumer<Dictionary<String, Object>>() {
            @Override
            public void accept(Dictionary<String, Object> enemy) {
                try {
                    Inimigo robo = new Inimigo(
                        (Posicao) enemy.get("posicao"),
                        (Integer) enemy.get("width"),
                        (Integer) enemy.get("height"),
                        (String) enemy.get("name"),
                        (String) enemy.get("image")
                    );
                    robo.setVida(new RoboForte(robo));
                    enemys.add(robo);
                } catch (IOException ex) {
                    Logger.getLogger(MedievalGameFactory.class.getName())
                            .log(Level.SEVERE, null, ex);
                    
                    System.exit(0);
                }
            }
        });
        
        return enemys;
    }
    
    @Override
    public ArrayList<Inimigo> criarInimigosFortes(int n)
    {
        ArrayList<Inimigo> enemys = new ArrayList<>();
        Dictionary<String, Object> enemyData;
        
        for (int i = 0; i < n; i++) {
            try {
                enemyData = Utilities.futuristicData.enemysData.get(i);
                Inimigo robo = new Inimigo(
                    (Posicao) enemyData.get("posicao"),
                    (Integer) enemyData.get("width"),
                    (Integer) enemyData.get("height"),
                    (String) enemyData.get("name"),
                    (String) enemyData.get("image")
                );
                robo.setVida(new RoboForte(robo));
                enemys.add(robo);
            } catch (IOException ex) {
                Logger.getLogger(FuturisticGameFactory.class.getName())
                        .log(Level.SEVERE, null, ex);

                System.exit(0);
            }
        }
        
        return enemys;
    }
    
    public ArrayList<Escudo> criarEscudosFase1()
    {
        ArrayList<Escudo> escudos = new ArrayList<>();
        Escudo eForte, eMedio, eFraco;
        
        eFraco = new EscudoFraco();
        eFraco.setRandomicPosition();
        
        eMedio = new EscudoMedio();
        eMedio.setRandomicPosition();
        
        eForte = new EscudoForte();
        eForte.setRandomicPosition();

        escudos.add(eFraco);
        escudos.add(eMedio);
        escudos.add(eForte);
        
        return escudos;
    }
    
    public ArrayList<Escudo> criarEscudosFase2()
    {
        ArrayList<Escudo> escudos = new ArrayList<>();
        Escudo eForte, eMedio1, eFraco1;
        Escudo eMedio2, eFraco2;
        
        eFraco1 = new EscudoFraco();
        eFraco1.setRandomicPosition();
        
        eFraco2 = new EscudoFraco();
        eFraco2.setRandomicPosition();
        
        eMedio1 = new EscudoMedio();
        eMedio1.setRandomicPosition();
        
        eMedio2 = new EscudoMedio();
        eMedio2.setRandomicPosition();
        
        eForte = new EscudoForte();
        eForte.setRandomicPosition();

        escudos.add(eFraco1);
        escudos.add(eMedio1);
        escudos.add(eFraco2);
        escudos.add(eMedio2);
        escudos.add(eForte);
        
        return escudos;
    }
    
    public ArrayList<Escudo> criarEscudosFase3()
    {
        ArrayList<Escudo> escudos = new ArrayList<>();
        Escudo eForte1, eMedio1, eFraco1;
        Escudo eForte2, eMedio2, eFraco2;
        
        eFraco1 = new EscudoFraco();
        eFraco1.setRandomicPosition();
        
        eFraco2 = new EscudoFraco();
        eFraco2.setRandomicPosition();
        
        eMedio1 = new EscudoMedio();
        eMedio1.setRandomicPosition();
        
        eMedio2 = new EscudoMedio();
        eMedio2.setRandomicPosition();
        
        eForte1 = new EscudoForte();
        eForte1.setRandomicPosition();
        
        eForte2 = new EscudoForte();
        eForte2.setRandomicPosition();

        escudos.add(eFraco1);
        escudos.add(eMedio1);
        escudos.add(eForte1);
        escudos.add(eFraco2);
        escudos.add(eMedio2);
        escudos.add(eForte2);
        
        return escudos;
    }
    
    @Override
    public ImageIcon criarCenario() 
    {
        return new ImageIcon(Utilities.futuristicData.getBackgroundPathFase1());
    }
    
    @Override
    public ImageIcon criarCenarioFase2() 
    {
        return new ImageIcon(Utilities.futuristicData.getBackgroundPathFase2());
    }
    
    @Override
    public ImageIcon criarCenarioFase3() 
    {
        return new ImageIcon(Utilities.futuristicData.getBackgroundPathFase3());
    }
}
