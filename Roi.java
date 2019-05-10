import java.util.*;
import java.lang.*;

public class Roi extends Piece{
  private boolean premierCoup = true;

  public Roi(){
  }

  public Roi(boolean couleur){
    super(couleur,"Roi");
  }

  public Roi(boolean couleur,int l,int c){
    super(couleur,"Roi",l,c);
  }

  public boolean deplacementValide(int lignecase, int colonnecase){
    if(lignecase - this.getLigne() == 0 && colonnecase-this.getColonne() == 0){
    return false;
    }
    return (lignecase-this.getLigne())-(lignecase-this.getColonne()) <=1 && (lignecase-this.getLigne())-(lignecase-this.getColonne()) >= -1 && Math.abs((lignecase-this.getLigne())*(lignecase-this.getColonne())) <=1;
  }


}//Fin de la classe Roi
