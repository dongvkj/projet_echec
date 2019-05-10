//-------TOUT LES IMPORTS--------------
        import javax.swing.*;
        import java.awt.*;
        import java.io.*;
        import java.util.*;
//--------FIN DES IMPOTS-----------------

public class Echiquier {
  //---VALEUR INSTANCE
  private Case[][] plateau;
  private char lettre[] = {'A','B','C','D','E','F','G','H'};
  private Roi roib;
  private Roi roin;
  //---FIN VALEUR INSTANCE

    public Echiquier() {
      this.plateau = new Case[8][8];
  		for (int i = 0; i < 8; i++){
  			for (int j = 0; j < 8; j++){
  				this.plateau[i][j] = new Case();
        }
      }
      this.initilisation();
    }

    //[INITIALISATION DU PLATEAU AVEC LES PIECES]
    public void initilisation(){
      //RANGER FALSE : false = noir
      this.plateau[0][0].setPiece(new Tour(false,0,0));
      this.plateau[0][1].setPiece(new Cavalier(false,0,1));
      this.plateau[0][2].setPiece(new Fou(false,0,2));
      this.plateau[0][3].setPiece(new Reine(false,0,3));
      this.plateau[0][4].setPiece(this.roin=new Roi(false,0,4));
      this.plateau[0][5].setPiece(new Fou(false,0,5));
      this.plateau[0][6].setPiece(new Cavalier(false,0,6));
      this.plateau[0][7].setPiece(new Tour(false,0,7));
      for (int i = 0; i < 8; i++){
        this.plateau[1][i].setPiece(new Pion(false,1,i));
      }

      //RANGER TRUE : true = blanc
      this.plateau[7][0].setPiece(new Tour(true,7,0));
      this.plateau[7][1].setPiece(new Cavalier(true,7,1));
      this.plateau[7][2].setPiece(new Fou(true,7,2));
      this.plateau[7][3].setPiece(new Reine(true,7,3));
      this.plateau[7][4].setPiece(this.roib=new Roi(true,7,4));
      this.plateau[7][5].setPiece(new Fou(true,7,5));
      this.plateau[7][6].setPiece(new Cavalier(true,7,6));
      this.plateau[7][7].setPiece(new Tour(true,7,7));
      for (int i = 0; i < 8; i++){
        this.plateau[6][i].setPiece(new Pion(true,6,i));
      }
  }

  public void afficherEchiquier(){
    for(int c = 0; c < 8 ; c ++){// LETTRE
      char le = lettre[c];
      System.out.print(" ["+lettre[c]+"]");
    }
    System.out.println("\n"+"+-------------------------------+");
    for (int i = 0; i < 8; i ++) {//ligne 8 cases
         for (int y = 0; y < 8; y ++) {//colonne 8 cases
         //INSERTION IMAGE SELON LA POSITION DES PIECES JOUER
         System.out.print("| ");
         //Pion
         if(this.plateau[i][y] != null && this.plateau[i][y].getPiece() != null && this.plateau[i][y].getPiece().getNom()== "Pion"){
           if(this.plateau[i][y].getPiece().getCouleur()==true){
             System.out.print('\u2659' +" ");
           }else{
             System.out.print('\u265f' +" ");
           }
         }
         //Tour
         if(this.plateau[i][y] != null && this.plateau[i][y].getPiece() != null && this.plateau[i][y].getPiece().getNom()== "Tour"){
           if(this.plateau[i][y].getPiece().getCouleur()==true){
             System.out.print('\u2656' +" ");
           }else{
             System.out.print('\u265c' +" ");
           }
         }
         //Cavalier
         if(this.plateau[i][y] != null && this.plateau[i][y].getPiece() != null && this.plateau[i][y].getPiece().getNom()==  "Cavalier"){
           if(this.plateau[i][y].getPiece().getCouleur()==true){
             System.out.print('\u2658' +" ");
           }else{
             System.out.print('\u265e' +" ");
           }
         }
         //Fou
         if(this.plateau[i][y] != null && this.plateau[i][y].getPiece() != null && this.plateau[i][y].getPiece().getNom()==  "Fou"){
           if(this.plateau[i][y].getPiece().getCouleur()==true){
             System.out.print('\u2657' +" ");
           }else{
             System.out.print('\u265d' +" ");
           }
         }
         //Reine/Dame
         if(this.plateau[i][y] != null && this.plateau[i][y].getPiece() != null && this.plateau[i][y].getPiece().getNom()==  "Reine"){
           if(this.plateau[i][y].getPiece().getCouleur()==true){
             System.out.print('\u2655' +" ");
           }else{
             System.out.print('\u265b' +" ");
           }
         }
         //Roi
         if(this.plateau[i][y] != null && this.plateau[i][y].getPiece() != null && this.plateau[i][y].getPiece().getNom()==  "Roi"){
           if(this.plateau[i][y].getPiece().getCouleur()==true){
             char c='\u2654';
             System.out.print(c++ +" ");
           }else{
             char c='\u265a';
             System.out.print(c++ +" ");
           }
         }
         if(this.plateau[i][y] == null || this.plateau[i][y].getPiece() == null){
           System.out.print("  ");
         }
         if(y == 7){
           System.out.println("|"+(i+1));
         }

       }//Fin boucle y
       System.out.println("+---+---+---+---+---+---+---+---+");
      // System.out.println("\u001B[31m"+"hello world!");
     }//Fin boucle i

   }//Fin de la méthode afficherEchiquier

  //[Accesseur & mutateur]

  public Case getCase(int colonne, int ligne) {
		return this.plateau[colonne][ligne];
	}

  public void setCase(int colonne, int ligne, Piece p) {
		this.plateau[ligne][colonne].setPiece(p);
	}


  //Fin Accesseur & mutateur


   public void deplacer(){
     Scanner s = new Scanner(System.in);

     //On récupère les coordonées de la pièce que le joueur veut déplacer.
     System.out.println("Veuillez saisir la position du pion que vous voulez déplacer ( lettre puis chiffre )");
     String depart = s.nextLine();//On prend le 1 caractère de la chaine
     int cd = 0;
     for(int i =0; i < lettre.length; i++){
       if( depart.charAt(0) == lettre[i]){
         cd = i;
       }
     }
     int ld = (depart.indexOf(1)-1);

     //On récupère les coordonées où le joueur veut poser la pièce.
     System.out.println("Veuillez saisir la position de la case que vous voulez déplacer");
     String arriver = s.nextLine();
     int ca = 0;
     for(int j =0; j < lettre.length; j++){
       if( arriver.charAt(0) == lettre[j]){
         ca = j;
       }
     }
     int la = arriver.charAt(1)-1;

     while(!(this.plateau[ld][cd].getPiece().deplacementValide(la,ca)) && this.plateau[ld][cd].getPiece()!=null){
       System.out.println("|| Le déplacement pour cette pièce n'est pas valide ! ||");
       System.out.println("Veuillez saisir la position du pion que vous voulez déplacer ( lettre puis chiffre )");
       depart = s.nextLine();//On prend le 1 caractère de la chaine
       cd = 0;
       for(int i =0; i < lettre.length; i++){
         if( depart.charAt(0) == lettre[i]){
           cd = i;
         }
       }
       ld = depart.indexOf(1)-1;

       //On récupère les coordonées où le joueur veut poser la pièce.
       System.out.println("Veuillez saisir la position de la case que vous voulez déplacer");
       arriver = s.nextLine();
       ca = 0;
       for(int j =0; j < lettre.length; j++){
         if( arriver.charAt(0) == lettre[j]){
           ca = j;
         }
       }
       la = arriver.charAt(1)-1;
     }

     //Si le roi du joueur est toujours en echec après un déplacement du joueur
     while(!(this.echecAuRoi(this.plateau[la][ca].getPiece().getCouleur()))){
       System.out.println("|| Le roi est en echec ! ||");
       System.out.println("Veuillez saisir la position du pion que vous voulez déplacer ( lettre puis chiffre )");
       depart = s.nextLine();//On prend le 1 caractère de la chaine
       cd = 0;
       for(int i =0; i < lettre.length; i++){
         if( depart.charAt(0) == lettre[i]){
           cd = i;
         }
       }
       ld = depart.indexOf(1)-1;

       //On récupère les coordonées où le joueur veut poser la pièce.
       System.out.println("Veuillez saisir la position de la case que vous voulez déplacer");
       arriver = s.nextLine();
       ca = 0;
       for(int j =0; j < lettre.length; j++){
         if( arriver.charAt(0) == lettre[j]){
           ca = j-1;
         }
       }
       la = arriver.charAt(1)-1;
     }

     //Si la case n'est pas occupée
     if(!(this.plateau[la][ca].estOccupe())){
       this.plateau[la][ca].setPiece(this.plateau[ld][cd].getPiece());
       this.plateau[la][ca].getPiece().setLigne(la);
       this.plateau[la][ca].getPiece().setColonne(ca);
       this.plateau[ld][cd]=new Case();
     }

     if(this.manger(la, ca, ld, cd)){
       this.plateau[la][ca].setPiece(this.plateau[ld][cd].getPiece());
       this.plateau[la][ca].getPiece().setLigne(la);
       this.plateau[la][ca].getPiece().setColonne(ca);
       this.plateau[ld][cd]=new Case();
     }

   }


   public boolean manger(int l, int c, int x, int y) {
 			//On vérifie si la piece à manger existe et si la couleur de ses deux pièces ne sont pas les mêmes.
 			if( this.plateau[x][y].estOccupe() && this.plateau[x][y] != null && this.plateau[x][y].getPiece().getCouleur() != this.plateau[l][c].getPiece().getCouleur()) {
        return true;
 		}
 		return false;
  }

  public boolean echecAuRoi(boolean couleur){
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 8; j++){
        if(this.plateau[i][j].getPiece().getCouleur() == couleur){
          Roi roi = (couleur == true) ? this.roib : this.roin;//condition ternaire
          /*On vérifie si le roi est en echec ou non avec tout les déplacementValide des pièces aux alentours
          S'il y a une pièces qui a un déplacement valide à la position du roi alors le roi est en échec*/
          if((this.plateau[i][j].getPiece().deplacementValide(roi.getLigne(), roi.getColonne()))){
            return true;
          }
        }
      }
    }
    return false;
  }

  public boolean echecetMat(boolean couleur){
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 8; j++){
        //on prend toues les pièces de la même couleur
        if(this.plateau[i][j].getPiece() != null && this.plateau[i][j].getPiece().getCouleur()==couleur){
          //on prend toute les coordonées possibles
          for(int li = 0; li < 8; li++){
            for(int co = 0; co < 8; co++){
              if(this.plateau[i][j].getPiece().deplacementValide(li,co)){
                //on met la piece sur la case
                this.plateau[li][co].setPiece(this.plateau[i][j].getPiece());
                this.plateau[li][co].getPiece().setLigne(li);
                this.plateau[li][co].getPiece().setColonne(co);
                this.plateau[i][j].setPiece(null);
                if(!(this.echecAuRoi(couleur))){
                  //on enlève la piece pour remettre la piece dans sa position précédente
                  this.plateau[i][j].setPiece(this.plateau[li][co].getPiece());
                  this.plateau[i][j].getPiece().setLigne(i);
                  this.plateau[i][j].getPiece().setColonne(j);
                  this.plateau[li][co].setPiece(null);
                  return false;
                }
                //on enlève la piece pour remettre la piece dans sa position précédente
                this.plateau[i][j].setPiece(this.plateau[li][co].getPiece());
                this.plateau[i][j].getPiece().setLigne(i);
                this.plateau[i][j].getPiece().setColonne(j);
                this.plateau[li][co].setPiece(null);

              }
            }
          }
        }

      }
    }
    return true;
  }


  public void partie(){
    this.afficherEchiquier();
    boolean joueur = true;
    //Tant qu'il n'y a pas echec et mat ou pat...
    while(this.echecetMat(joueur)){
        if(joueur == true ){
          System.out.println("[TOUR DU JOUEUR BLANC]");
          this.deplacer();
        }else{
          System.out.println("[TOUR DU JOUEUR NOIR]");
          this.deplacer();
        }
        joueur = !joueur;
        this.afficherEchiquier();
    }
  }



}//Fin de la classe Echiquier
