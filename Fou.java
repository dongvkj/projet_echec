import java.util.*;
import java.lang.*;

//le fou peut se deplacer seulement en diagonale

public class Fou extends Piece{
  private int colonne;
  private int ligne;

  public Fou(){
  }

  public Fou(boolean couleur){
    super(couleur,"Fou");
  }

  public Fou(boolean couleur,int l, int c){
    super(couleur,"Fou",l,c);
  }

  /*public boolean mouvemementPossibleFou(Echiquier e, int lignecase, int colonnecase){
    // on doit verifier que il n'y a pas de piece sur le trajet
    //ici this est le pion de la case de depart
    // lignecase et colonnecase sont les coordonnes de la case où on veut aller

    if( e.getCase(lignecase,colonnecase).estOccupe() ){
      return false;
    }
    //int ligne =  e.getCase(lignecase,colonnecase).getLigne() - this.getLigne();
    int ligne = lignecase - this.getLigne();
    //int colonne =  e.getCase(lignecase,colonnecase).getLigne() - this.getColonne();
    int colonne = colonnecase - this.getColonne();
    if (ligne>7 && colonne>7 && ligne<7 && colonne<7){
      System.out.println("la case est hors de portée");
      return false;
    }
    else if (ligne<0 || colonne<0){
        // on regarde les cases de la digonale en bas a gauche
        for (int i = 1; this.equals(e.getCase(ligne-i,colonne-i)); i++)
            if (e.getCase(ligne-i,colonne-i).estOccupe())
            {
              return false;
            }
      }
      // si colonne > 0 on regarde la colonne en bas a droite
      else if (ligne<0 || colonne>0){
        for (int i = 1; this.equals(e.getCase(ligne-i,colonne+i)); i++)
            if (e.getCase(ligne-i,colonne+i).estOccupe())
            {
              return false;
            }
      }
      else if(ligne>0 || colonne>0){
        // on regarde la diagonale en haut à droite
        for (int i = 1; this.equals(e.getCase(ligne+i,colonne+i)); i++)
            if (e.getCase(ligne+i,colonne+i).estOccupe())
            {
              return false;
            }
      }
      else if (ligne>0 || colonne<0){
        // on regarde la diagonale en haut à gauche
        for (int i = 1; this.equals(e.getCase(ligne+i,colonne-i)); i++)
            if (e.getCase(ligne+i,colonne-i).estOccupe())
            {
              return false;
            }
      }
      return true;
    }*/

      public boolean deplacementValide(int lignecase, int colonnecase){
        //On sait que le fou se déplace en diagonale donc la différence entre ligne et colonne le résultat doit être égale à 0 ou bien ligne == colonne
        if(lignecase - this.getLigne() == 0 && colonnecase-this.getColonne() == 0){
        return false;
        }
        return Math.abs(lignecase - this.getLigne()) == Math.abs(colonnecase-this.getColonne());
      }

  }//Fin de la class Fou
