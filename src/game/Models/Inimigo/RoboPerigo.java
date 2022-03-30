package game.Models.Inimigo;

import game.Models.Ataque.AtaqueFraco;
import game.Models.Movimento.MovimentoDevagar;


/**
 * Write a description of class RoboPerigo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RoboPerigo extends RoboEstado
{    
    public RoboPerigo(Inimigo robo)
    {
        super(robo);
        robo.setMovimento(MovimentoDevagar.getInstance());
        robo.setAtaque(AtaqueFraco.getInstance());
    }
    
    @Override
    public void setLimites()
    {
        this.setLimiteInferior(1);
        this.setLimiteSuperior(29);
    }
    
    @Override
    public void verificaEstado()
    {
        if (this.getRobo().getQuantidade() <= this.getLimiteInferior()) {
            this.getRobo().setVida(new RoboMorto(this.getRobo()));
        } else if(this.getRobo().getQuantidade() > this.getLimiteSuperior()) {
            this.getRobo().setVida(new RoboNormal(this.getRobo()));
        }
    }
    
    @Override
    public void dano(int dano)
    {
        this.perdeVida(dano);
    }
}
