// Juan Aguirre 

	
import java.util.Scanner;
import java.util.Random;




public class L9
{
   public static void printMenu()
   {
      System.out.println("press 1 to Fill the array with random numbers (1 – 100)");
      System.out.println("press 2 to Print the array");
      System.out.println("press 3 to Sort the array in ascending sequence");
      System.out.println("press 4 to Sort the array in descending sequence");	
      System.out.println("press 5 to Sequential search of the array for a"); 
      System.out.println("press 6 to Binary search of the array for a target"); 
      System.out.println("press 7 to Exit");
   }

   public static int binarysearch( int[] x, int size, int target)
   
     { int	first	= 0, middle, last	= size-1;
      while (first <= last)
      {
         middle	= (first	+ last)/2;
         if (x[middle] == target)
         {
            return middle;
         }
         else	if	(x[middle]>	target)
            last = middle	- 1;
         else
            first = middle +1;
      }
      return -1;
   }
				
   public static int	search (int[] x,	int size,	int target)
   {
      int i;
      for (i = 0; i < size; i++){
         if (x[i] == target){
            return i;
         }
      }
      return -1;
   
   }

   public static	void	sortAscending (int	[]	x, int size)
   {
      boolean sorted;
      int temp;
      int numpairs =	size-1;
      do
      {
         sorted =	true;
         for(int i = 0;i<numpairs;++i)
             if (x[i]> x[i+1])
             {
             temp = x[i];
             x[i] = x[i+1];
             x[i+1] = temp;
             sorted = false;
             } 
         numpairs--;
      }
      while(sorted	==	false);
     
   } 
   public static void sortDescending (int[] x, int size)
   {
    int i,j,temp;
     for( i = 0; i<size-1;i++)
        for(j = i+1;j<size;j++)
           if(x[i]< x[j])
            {
             temp = x[i];
             x[i] = x[j];
             x[j] = temp;
            }
    }
   
   public static void printArray(int [] x, int size)
   {
      System.out.println (" Position\tArray Value");
      for (int i = 0; i < size; ++i)
         System.out.println (i + "\t" + "\t" + x[i]);
   }
   
    public static void fillRandom(int [] x, int size)
   {
     // System.out.println (" Position\t\tArray Value");
      for (int i = 0; i < size; ++i)
        x[i] = (int) ( Math.random() * 100 + 1);
   }

   
   public static void dispatch(int choice, int[] values, int size,Scanner scan)
   {
      switch(choice)
      {
         case 0: 
            System.out.println("Good bye");
            break;
         case 1:
            fillRandom(values, size);
            break;
         case 2:
            printArray(values, size);
            break;
         case 3:
            sortAscending(values, size);
            break;
         case 4:
            sortDescending(values, size);
            break;
         case 5:
            System.out.println("What value are you looking for?");
            int target = scan.nextInt();
            int pos = search(values, size, target);
            if(pos!=-1)
               System.out.println(target +" was found at position " + pos);
            else
               System.out.println(target + " was not found in the array");
            break;
         case 6:
            System.out.println("What value are you looking for?");
            target = scan.nextInt();
            pos = binarysearch(values, size, target);
            if(pos!=-1)
               System.out.println(target +" was found at position " + pos);
            else
               System.out.println(target + " was not found in the array");
            break;
      }
   }


   public static void main	(String [] args)
   {
      Scanner scan =	new Scanner(System.in);
   
      int [] values = new int	[100];
   
   
   
      int size;
      int choice = 0;
      System.out.println("Please enter size of the array: ");
      System.out.println();
      size = scan.nextInt();
      printMenu();
      System.out.println(); 
      System.out.println("Type in a choice");
   
      choice =	scan.nextInt();
      while	(choice != 0)
      {
         dispatch	(choice,	values,size,scan); 
         printMenu();
         System.out.println();
         System.out.println("Type in another choice");
         System.out.println();
         System.out.println();
         
         
         choice =	scan.nextInt();
         System.out.println();
      }
     
   
     
   
   }
}

