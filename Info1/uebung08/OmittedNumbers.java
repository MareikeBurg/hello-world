public class OmittedNumbers {
    public static void main (String [] args ) {
        
        //Prüfen ob Eingabe vorliegt
        if (args.length != 1) {
            System.out.println("Aufruf nur mit einer Zahl erlaubt");
            System.exit(1);
        }
        
        //Erstellen eines Feld der Zahlen 0-N
        int n = Integer.parseInt(args[0]);
        int [] tabelle = new int[n+1];               //n+1 um Bereich bis N abzudecken
        for (int i=0; i<tabelle.length; i++)
            tabelle[i]=i;
        
        //Alle nicht Omitted Numbers raussortieren
        aussortieren(tabelle);
        
        //Endausgabe
        System.out.println("Omitted Numbers sind");
        for ( int i = 0; i < tabelle.length; ++i) 
            if (tabelle[i] != 0)
	            System.out.print( tabelle[i] + " ");
        System.out.println();
        System.exit(0);
    }
    
    public static void aussortieren (int [] s) {
        
        int n = s.length;           
	    
	    //Aufrücken der Zahlen
        for (int j=0; j<n; j++) {               //Durchlaufen des Felds ...
            if (s[j] == 0) {                    //  bis leere Stelle gefunden
                for (int i=j+1; i<n; i++) {     //dorthinter suchen nach ...
                    if (s[i] != 0) {            //  nicht leerer Stelle
                        s[j]=s[i];              //tauschen
                        s[i]=0;
                        break;
                    }
                }
            }
        }
        
        //Aussortieren der ersten,zweiten, ... , n-ten
        for (int r=1; r<n; r++) {
            
            //Rausschmeißen
            for (int k=r; k<n; k+=r+1)       
                s[k] = 0; 
            
            //Aufrücken
            for (int j=0; j<n; j++) {
                if (s[j] == 0) {
                    for (int i=j+1; i<n; i++) {
                        if (s[i] != 0) {
                            s[j]=s[i];
                            s[i]=0;
                            break;
                        }
                    }
                }
            }
        }
        
        return;
    }
}
