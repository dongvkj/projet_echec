import java.util.*;
import java.lang.*;

public class Reine extends Piece {
  public Reine(boolean couleur,int l,int c){
    super(couleur,"Reine",l,c);
  }

  public boolean deplacementValide(int lignecase, int colonnecase){
    if(lignecase - this.getLigne() == 0 && colonnecase-this.getColonne() == 0){
    return false;
    }
    //Il faut que l'une des valeurs soit égales à 0 (il peut seeulement se déplacer soit en ligne soit en colonne)
    return (lignecase-this.getLigne())-(colonnecase-this.getColonne()) == 0 //Déplacement de la Tour
    ||
    Math.abs(lignecase - this.getLigne()) == Math.abs(colonnecase-this.getColonne());//Déplacement du Fou
  }

}//Fin de la classe Reine
