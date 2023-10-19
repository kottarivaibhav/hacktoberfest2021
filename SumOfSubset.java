package sumofsub;


import java.util.Scanner;

public class SumOfSubset {

    static int[] set, x; // x is the solution x[i]=1 => i-th element belogs to subset  
                        // x[i]=0 => i-th element does not belogs to subset 

                        static int d, n,flag=1;

    static void sumofsub(int s, int k) {
        int i;

        x[k] = 1;   //generate left child of statespace tree. Let k-th element is part of subset
        if (s + set[k] == d) {
        	if(flag==1) {
        		
        		flag=0;
        		 System.out.println("The subsets with sum  = " + d + " are");
        		
        	}
            System.out.print("{");
            for (i = 1; i <= n; i++) {
                if (x[i] == 1) //subset found
                {
                    System.out.print( set[i] + " ");
                }
            }
            System.out.println("}");
        } 
        else {
            if (s + set[k] < d && k + 1 <= n) //  set[k] is part of subset
            {
                sumofsub(s + set[k], k + 1);    
                x[k + 1] = 0;
            }
            if (k + 1 <= n && s + set[k + 1] <= d )//without s[k]
            {
                x[k] = 0;
                sumofsub(s, k + 1);
                x[k + 1] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int sum = 0, i;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of the set");
        n = sc.nextInt();
        
        set = new int [n+1];
        x = new int [n+1];

        
        System.out.println("Enter set elements in increasing order");
        for (i = 1; i <= n; i++) {
            set[i] = sc.nextInt();
        }
        System.out.println("Enter the sum (d): ");
        d = sc.nextInt();
        
        for (i = 1; i <= n; i++) {
            sum = sum + set[i];
        }
        if (sum < d || set[1] > d) {
            System.out.println("No subset possible with sum = "+ d);
        } 
        else {
           
            sumofsub(0, 1);
            if(flag==1) {
            	System.out.println("no solution");
            }
        }
    }
}
