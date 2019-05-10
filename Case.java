//---LES IMPORTS
import javax.swing.*;
import java.awt.*;
//---FIN DES IMPORTS

class Case{
       private Piece piece;

       public Case(){

       }

       public Case(Piece pion){
     		this.piece = pion;
     	}

       public Piece getPiece() {
     		return this.piece;
     	}

     	public void setPiece(Piece pion) {
     		this.piece = pion;
     	}

      public boolean estOccupe(){
        if(this.piece == null){
          System.out.println("La case est occupé par : "+this.piece);
          return true;
        }
        System.out.println("La case n'est pas occupé par : ");
        return false;
    	}

   }//Fin de cla classe Case
