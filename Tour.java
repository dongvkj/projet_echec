public class Tour extends Piece{
  public Tour(){

  }
  public Tour(boolean couleur){
    super(couleur,"Tour");
  }

  public Tour(boolean couleur, int l, int c){
    super(couleur,"Tour",l,c);
  }

  public boolean deplacementValide(int lignecase, int colonnecase){
    if(lignecase - this.getLigne() == 0 && colonnecase-this.getColonne() == 0){
    return false;
    }
    //Il faut que l'une des valeurs soit égales à 0 (il peut seeulement se déplacer soit en ligne soit en colonne)
    return (lignecase-this.getLigne())-(colonnecase-this.getColonne()) == 0;
  }

}//Fin de la classe Tour
