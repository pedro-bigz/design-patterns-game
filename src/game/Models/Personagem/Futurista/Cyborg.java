package game.Models.Personagem.Futurista;

import game.Models.Ataque.AtaqueFraco;
import game.Helpers.Posicao;
import game.Models.Personagem.Jogador;
import game.Utilities;
import java.io.IOException;

public class Cyborg extends Jogador {
    public Cyborg(Posicao posicao, int width, int height)
        throws IOException
    {
        super(
            "Cyborg",
            posicao,
            width,
            height,
            Utilities.futuristicData.characterPaths.get("cyborg")
        );
        
        String descricao = "Mussum Ipsum, cacilds vidis litro abertis."
            + "Si num tem leite então bota uma pinga aí cumpadi!"
            + "Quem num gosta di mim que vai caçá sua turmis!"
            + "Delegadis gente finis, bibendum egestas augue arcu ut est."
            + "Per aumento de cachacis, eu reclamis.";
        
        super.setAtaque(AtaqueFraco.getInstance());
        super.setDescricao(descricao);
    }
}
