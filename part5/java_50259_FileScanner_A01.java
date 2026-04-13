import java.io.*; // for FileScanner class & related exceptions   
public final class java_50259_FileScanner_A01 {  
     public static void main(final String[] arguments) throws IOException  {          
            try (FileScanner scan = new FileWalker().newInstance("."))      {             
                while (scan.hasNext())        {                 
                    System.out.println("\nFound text file: " +   // print filename            
                      scan.nextPathname()+  "\n");         }    });     }}  catch(Exception e){System.err .print ("Error:"+e);}}                                                                                                                   Exception in thread "main" java.lang.NullPointerException      at Main$1.run (Main.java:20)