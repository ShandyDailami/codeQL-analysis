import java.io.*;  // Import Input/Output Stream classes  
//Import FileNotFoundException to handle non-existing files   
public class java_46593_FileScanner_A03 {    
        public static void main(String[] args) throws IOException{          
            String path = "/path_to_your_files";             
             Scanner fileScan= new Scanner(System.in);  // Create a scanner object  
                System.out.println("Enter the command:");    
                   File fileToRead;   
                     if (args.length == 0) {              
                         java.util.Scanner s =new java .util.Scanner(System.in);     
                        String str=s.nextLine();   // Reading user input  using scanner class          
                          } else fileToRead  = new File( args[0]);                
                              System.out.println("File Name is : " +fileToRead .getName());   
                            java.util.Scanner s =new java .util.Scanner (System.in);     
                           String str=s.nextLine();   // Reading user input  using scanner class    
                          fileScan  = new Scanner(fileToRead );                  
                  while (fileScan.hasNext()){   
                        System.out.println("Reading content of the File : ");      
                     if (!File.separatorChar == '\\') { // Checking for Windows Path Separators  */    
                          str = fileScan .nextLine();      } else   /* For Unix/Linux, replace '/' with '\'.*/       
                           str=fileScan.nextLine().replace('/', '\\');    while (str != null && str.length() > 0) {         
                               if(containsInjectionAttempts(str)) break;      // Security-sensitive operation     }   return;}