import java.util.*;

public abstract  class Piece {
  private boolean couleur;//une piece peut être soit blanche ou noire
  private int colonne;
  private int ligne;
  private String nom;


  public  Piece(){
  }

  public Piece(boolean couleur,String n){
    this.couleur = couleur;
    this.nom=n;
  }

  public Piece(boolean couleur,String n, int l, int c){
    this.couleur = couleur;
    this.nom=n;
    this.ligne=l;
    this.colonne=c;
  }

  /*public void Promotion(Piece p){
    //methode qui change un pion en une autre piece si le joueur le souhaite
    if (p.getLigne() == 8 || p instanceof Pion) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Veuillez saisir la piece que vous souhaitez mettre à la place du pion"+"\n 1: Pion"+"\n 2: Reine"+"\n 3: Roi"+"\n 4: Fou"+"\n 5: Tour"+"\n 6: Cavalier");
    int i = sc.nextInt();
    if (i == 2){
    p = (Reine)p;
    }
    if (i == 3){
    p = (Roi)p;
    }
    if (i == 4){
    p = (Fou)p;
    }
    if (i == 5){
    p = (Tour)p;
    }
    if (i == 6){
    p = (Cavalier)p;
    }

    }

  }*/

  public String getNom() {
    return this.nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public void setCouleur(boolean nouvCouleur){
    this.couleur = nouvCouleur;
  }

  public boolean getCouleur(){
    return this.couleur;
  }

  public int getLigne(){
    return this.ligne;
  }
  public int getColonne(){
    return this.colonne;
  }

  public void setLigne(int nouvLigne){
    this.ligne = nouvLigne;
  }
  public void setColonne(int nouvColonne){
    this.colonne = nouvColonne;
  }

  public abstract boolean deplacementValide(int lignecase, int colonnecase);

}//Fin de la classe Piece
