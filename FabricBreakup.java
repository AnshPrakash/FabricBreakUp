import java.io.*;
import java.util.*;
public class FabricBreakup {
	 private int[][] Myrecord;
	 private int[] totopple;
 	 private int top;
         private int tc;
         
	 FabricBreakup(int N){
		 	Myrecord=new int[N][2];
                        totopple=new int[N];	 
	        top=-1;
                tc=-1;
	 }
     public void AddRecord(int score ,int serialno) {
                 //System.out.println("Adding Record");
                 if(top==-1)
                 { top++;
                   tc++;
                   totopple[tc]=0;
                    
    	             Myrecord[top][0]=serialno;
                     Myrecord[top][1]=score; 
                 }
                 else if(Myrecord[top][1]<=score)
                   { tc++;
                     totopple[tc]=0;
                     top++;
                     Myrecord[top][0]=serialno;
                     Myrecord[top][1]=score; 
                   }
                 else
                  totopple[tc]++;
     }
     public void  Party(int  s) {
    	 //int bestShirt=FindbestShirt();
         //System.out.print("Why");
    	 if(top!=-1)
         {System.out.println(s+" "+totopple[tc]);
          top--;
          tc--;
          }
    	  
    	 else {
    	    System.out.println(s+" "+"-1");
    	 }
     }
    public int  getFirst(){
       int first;
       if(top!=-1)
       {return Myrecord[top][1];
       }
       else 
          return -1;
     }
     	 
     
     public static void main(String[] args)
     {
    	 
    	 FabricBreakup k;
    	 
    	
    	 try { 
    		    int N=0;
                    int count=-1;
    		    FileInputStream f=new FileInputStream(args[0]);
    		    //System.out.println(f.exists());
                     
    	 	    Scanner r= new Scanner(f);
    	 	   String arr[]=new String[3];
    	 	    String s="";
    	 	    if(r.hasNextInt())
    	 	    	N=r.nextInt();
    	 	    k=new FabricBreakup(N);
    	 	    int[] totopple= new int[N];
                    //totopple[0]=0;
    	 	    while(r.hasNextLine())
    	 	    {
    	 	    	s=r.nextLine();
                       	arr=s.split(" ");
    	 	    	
                     if(arr.length==3)
                        {if(arr[1].equals("1"))
                        {//count++;
                         //m++;
                           k.AddRecord(Integer.parseInt(arr[2]),Integer.parseInt(arr[0]));                       
                        }
                        }
                        else if(arr.length==2)
                         {
                           k.Party(Integer.parseInt(arr[0])); 
                         }
    	 	    	
    	 	    	
    	 	    }
    	 	    
    	 	 }
    	 	 catch(Exception e) {
    	 		 System.out.println("Something went wrong with file operation!");
    	 		System.out.println(e);
    	 	 }
    	    	
     }
     
}
