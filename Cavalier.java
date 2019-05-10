public class Cavalier extends Piece {
  public Cavalier(){

  }

  public Cavalier(boolean couleur){
    super(couleur,"Cavalier");
  }

  public Cavalier(boolean couleur,int l, int c){
    super(couleur,"Cavalier",l,c);
  }

  public boolean deplacementValide(int lignecase, int colonnecase){
    if(lignecase - this.getLigne() == 0 && colonnecase-this.getColonne() == 0){
    return false;
    }
    //Il faut que l'une des valeurs soit égales à 0 (il peut seeulement se déplacer soit en ligne soit en colonne)
    return Math.abs((lignecase-this.getLigne())/(colonnecase-this.getColonne())) == 2 || Math.abs((lignecase-this.getLigne())/(colonnecase-this.getColonne())) == 0.5f;
  }

}//Fin class Cavalier
