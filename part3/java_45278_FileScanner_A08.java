import java.io.*; // Importing required classes from 'jdk' library  
public class java_45278_FileScanner_A08 { 
    public static void main(String[] args) throws IOException{        
        Scanner scan = new Scanner(System.in);     
           System.out.println("Enter the directory path:");      
            String dirPath=scan.nextLine();              // taking user input for a Directory Path  
             File fileObj  =new File (dirPath );          // Creating object of 'File' class to get information about “filepath”   
               if(fileObj.exists()) {                      // Check the existence, in order not raise exception that could cause application breakage on non-existence path           
                   System.out.println("Directory exists");       
                 File[] files = fileObj .listFiles();     // list all contents of directory into an array 'files'      
                for (File f :  files) {                      /**/   if the current object is a regular java -file then print it out    */        
                  System.out.println(f);              /*Print Name & Absolute Path*/          }        //End of listFiles()            else          
                    System.err .print ("Invalid path");       return;  /**/   if the current object is not a regular java -file then print out an invalid file, and break it off     */         }}    /* End Existence Checking & Iterating over directories contents      } catch (Exception e) { // Catch exception to handle any issue at runtime         
            System.err .print ("An error Occurred ");             return;        /**/   print an Error Message, and Stop the execution */  }}         };