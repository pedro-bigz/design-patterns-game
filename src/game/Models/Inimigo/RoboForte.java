package game.Models.Inimigo;

import game.Models.Ataque.AtaqueForte;
import game.Models.Movimento.MovimentoRapido;


/**
 * Write a description of class RoboForte here.
 *
 * @author (your name)
 * @version (a version number or a date) 
 */
public class RoboForte extends RoboEstado
{
    public RoboForte(Inimigo robo){
        super(robo);
        robo.setMovimento(MovimentoRapido.getInstance());
        robo.setAtaque(AtaqueForte.getInstance());
    }
    
    @Override
    public void setLimites(){
        this.setLimiteInferior(71);
        this.setLimiteSuperior(100);
    }
    
    @Override
    public void verificaEstado(){
        if (this.getRobo().getQuantidade() < this.getLimiteInferior()) {
            this.getRobo().setVida(new RoboNormal(this.getRobo()));
        } else if(this.getRobo().getQuantidade() > this.getLimiteSuperior()) {
            this.getRobo().setVida(new RoboForte(this.getRobo()));
        }
    }
    
    @Override
    public void dano(int dano){
        this.perdeVida(dano);
    }
}
