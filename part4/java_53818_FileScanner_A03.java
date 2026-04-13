import java.io.*; // Import the necessary Java classes  
    
public class java_53818_FileScanner_A03 {   
// Function that scans a file line by looping through each character in it and prints its ASCII value using BufferedReader       
static void scanFile(String filename) throws IOException{        
      try (BufferedReader br = new BufferedReader(new FileReader("/path/to/"+filename))) {   // Open the input file         
            String line; 
             while ((line = br.readLine()) != null){        /* Reads a line from 'inputfile' */           if (null == line) break ;         System.out.println( "Read Line: :" + "\n"); //Print each character in the file      for (int i = 0;i <line .length();++ )       {         
                   char[] arr = new StringBuilder().append((char)(Integer.parseInt("'"+ line[42]  +"'"))).toString()).toCharArray();        System.out.println(arr); /*Print each character in the file */           }     // Close inputfile handle         br.close() ; 
      }}catch (FileNotFoundException e){System.out.print("Error: " +e );} catch (IOException ex) {ex.printStackTrace();}}    public static void main(String[] args) throws IOException{       System. out .println (" File Scanner");        scanfile("/user/input_sample"+".txt") ; } // Test the function with a sample file