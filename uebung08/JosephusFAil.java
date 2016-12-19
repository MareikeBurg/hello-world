public class Josephus {
    public static void main (String [] args) {
    
        //Prüfen ob richtige Eingabe vorliegt
        if (args.length != 2) {
            System.out.println("Falsche Eingabe");
            System.exit(1); }
        
        int N = Integer.parseInt(args[0]);
        int S = Integer.parseInt(args[1]);
        
        //Erstellen des Felds
        int circle [] = josephusPermutation(N,S);
        
        //Füllen des Felds mit Josephus
        josephusRecursive(circle,1,S);        
        
        //Ausgabe der Zahlen 1-N
        System.out.println("Zahlen von 1-N:");
        for (int i=1; i<=N; i++)
            System.out.print(i + " ");
        System.out.println();
        
        System.out.println("Josephus Zahlen:");
        for (int i=0; i<N; i++)
            System.out.print(circle[i] + " ");
        System.out.println();
    }
    
    public static int [] josephusPermutation(int length, int step) {
        
        //Felder von [0]-[N-1] mit 0 Füllen
        int [] circle = new int [length];
        for (int i=0; i<length; i++)
            circle[i]=0;            //circle[0] repräsentiert 1 ...
        return circle;              //circle[N-1] repräsentiert N
    }
    
    public static void josephusRecursive(int [] circle, int last, int step) {
        //Abbruchbedingung
        if (3==last)
            return;
            
        //nächste zu überschreibende Zahl suchen
        int next=0;
        while (next == 0) {
            int i=0;
            if (circle[i]==0)
                for(int j=i+step; j<circle.length;j++) 
                    if(circle[j]==0) {
                        next=j-1;
                        break;    
                    }
            i++; 
        }
                
        System.out.println("next: " + next);
        circle[next]=last;        //da Zahlen um eins verschoben                
        last++;
        josephusRecursive(circle,last,step);
    }
}
