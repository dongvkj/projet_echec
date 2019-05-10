import java.util.*;

public class Pion extends Piece{
  private boolean premierCoup = false;

  public Pion(){
  }

  public Pion(boolean couleur){
    super(couleur,"Pion");
  }

  public Pion(boolean couleur,int l, int c){
    super(couleur,"Pion",l,c);
  }

  public void deplacementPion(){
    //on commence par demander la où le joueur veut aller grace a un scanner
    Scanner sc = new Scanner(System.in);
    System.out.println("entrez la ligne où vous souhaitez deplacer le pion");
    int i = sc.nextInt();

  }

  /*public boolean coupPossible(int x, int y){
    	if(x < 0 || x > 7 || y < 0 || y > 7) return false;

    	if(this.plateau.getCase(x, y) != null){
    		if(this.couleur.equals("BLANC")){
    			if(x == this.x+1 && y == this.y +1){
        			return true;
        		}
    			if(x == this.x-1 && y == this.y +1){
        			return true;
        		}
    		}
    		else{
    			if(x == this.x-1 && y == this.y -1){
        			return true;
        		}
    			if(x == this.x+1 && y == this.y-1){
        			return true;
        		}
    		}

    	}
    	if(this.plateau.getCase(x, y) == null){
	    	if(this.couleur.equals("BLANC")){
	            if(x==this.x && y == this.y+2 && premierCoup==true){
	                return true;

	            }
	    		if(x==this.x && y ==this.y+1){
	    			return true;
	    		}
	    	}
	    	else{
	            if(x==this.x && y == this.y-2 && premierCoup==true){
	                return true;
	            }
	    		if(x==this.x && y==this.y-1){
	    			return true;
	    		}
	    	}
	    	return false;
	    }
    	return false;
    }*/

    public boolean deplacementValide(int lignecase, int colonnecase){
      if(lignecase - this.getLigne() == 0 && colonnecase-this.getColonne() == 0){
      return false;
      }
      //Il faut que l'une des valeurs soit égales à 0 (il peut seeulement se déplacer soit en ligne soit en colonne)
      if(premierCoup == true){
        premierCoup =! premierCoup;
        return (colonnecase-this.getColonne() == 0 && lignecase-this.getLigne() == 1) || (colonnecase-this.getColonne() == 0 && lignecase-this.getLigne() == 2);
      }
      return colonnecase-this.getColonne() == 0 && lignecase-this.getLigne() == 1;
    }

  }//Fin de la classe Pion
