package game.Models.Personagem.Futurista;

import game.Models.Ataque.Futuristic.DisparoRadiativo;
import game.Models.Ataque.Futuristic.RajadaMetalica;
import game.Models.Ataque.Futuristic.ForcaRobotica;
import game.Models.Ataque.Futuristic.MilVolts;
import game.Models.Ataque.Futuristic.SuperLazer;
import game.Helpers.Posicao;
import game.Utilities;
import game.Models.Personagem.Jogador;
import java.io.IOException;

public class SimplePersonagemFuturisticFactory {
    public static Jogador criaPersonagem(float valor)
        throws IOException
    {
        Jogador personagem = null;

        if (valor <= 0.2) {
            personagem = SimplePersonagemFuturisticFactory
                .createAndroid();

        } else if (valor <= 0.4) {
            personagem = SimplePersonagemFuturisticFactory
                .createSentinela();

        } else if (valor <= 0.6) {
            personagem = SimplePersonagemFuturisticFactory
                .createAtirador();

        } else if (valor <= 0.8) {
            personagem = SimplePersonagemFuturisticFactory
                .createFuzileiro();

        } else if (valor <= 1) {
            personagem = SimplePersonagemFuturisticFactory
                .createCyborg();

        }

        return personagem;
    }

    public static Android createAndroid()
        throws IOException
    {
        Jogador p = new Android(
            (Posicao) Utilities.futuristicData.personagemData.get("posicao"),
            (Integer) Utilities.futuristicData.personagemData.get("width"),
            (Integer) Utilities.futuristicData.personagemData.get("height")
        );       
        
        p.setAtaque(DisparoRadiativo.getInstance(p.getAtaque())); 
        
        return (Android) p;
    }

    public static Sentinela createSentinela()
        throws IOException
    {
        Sentinela p = new Sentinela(
            (Posicao) Utilities.futuristicData.personagemData.get("posicao"),
            (Integer) Utilities.futuristicData.personagemData.get("width"),
            (Integer) Utilities.futuristicData.personagemData.get("height")
        );        
        
        p.setAtaque(MilVolts.getInstance(p.getAtaque())); 
        
        return (Sentinela) p;
    }

    public static Atirador createAtirador()
        throws IOException
    {
        Jogador p = new Atirador(
            (Posicao) Utilities.futuristicData.personagemData.get("posicao"),
            (Integer) Utilities.futuristicData.personagemData.get("width"),
            (Integer) Utilities.futuristicData.personagemData.get("height")
        );      
        
        p.setAtaque(SuperLazer.getInstance(p.getAtaque())); 
        
        return (Atirador) p;
    }

    public static Fuzileiro createFuzileiro()
        throws IOException
    {
        Jogador p = new Fuzileiro(
            (Posicao) Utilities.futuristicData.personagemData.get("posicao"),
            (Integer) Utilities.futuristicData.personagemData.get("width"), 
            (Integer) Utilities.futuristicData.personagemData.get("height")
        );    
        
        p.setAtaque(RajadaMetalica.getInstance(p.getAtaque())); 
        
        return (Fuzileiro) p;
    }

    public static Cyborg createCyborg()
        throws IOException
    {
        Jogador p = new Cyborg(
            (Posicao) Utilities.futuristicData.personagemData.get("posicao"),
            (Integer) Utilities.futuristicData.personagemData.get("width"),
            (Integer) Utilities.futuristicData.personagemData.get("height")
        );     
        
        p.setAtaque(ForcaRobotica.getInstance(p.getAtaque())); 
        
        return (Cyborg) p; 
    }
}
