import java.io.*; // Importing the File class java_50366_FileScanner_A08 provides file attributes like length in bytes (for size) etc...  

    import java.util.*; //Importing Scanner for reading input from command line or standard inputs ... .      

public class Main {    

      public static void main(String[] args){ 

          if (args.length == 0 ){//If no arguments are passed through the console, request user to enter a directory path...   

              System.out.println("Please provide an input file or folder: ");   //Sending prompt message on how it will work ...       }       

           else {         

               File myFile = new File(args[0]);//Creating the main target of operation            

                if (myFile.exists()){    /*Check whether a file or directory exists at that location,  */           

                    System.out.println("Directory/file: "+ args[0] +" found!");       //Sending message on how it will work...      }        else {            

                        System.out.print(args[0]  + " not Found");//If file or directory doesn't exist, then show a corresponding error msg  ...   
            }}              /*End of Else if condition*/     }; //closing the main method        

      }   ;}        /**/         `