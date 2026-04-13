import java.io.*; // Import of Java's IO package, which contains classes and interfaces related to input/output operations in a way that works across platforms (OS) or languages(JVM). Note: you should have import statements for FileReader if your program is written on Windows based system as well since the file reading operation doesn’t work exactly same under both scenarios.
import java.util.*; // Import of Java's utility package, which includes classes related to collections and generics in JAVA 5+(like List<> etc).   
  
public class java_52304_FileScanner_A07 {    
 public static void main (String[] args) throws Exception{     
       String filePath = "/home/user"; // replace with your path        
        File folder = new File(filePath);              
           Scanner scanFile=new Scanner(System.in); 
            System.out.println("Enter the name of a txt files you want to read: ");   
             String fileNameToRead;     // variable for input  
              do {                     
                    if (filePath==null) throw new IllegalArgumentException();      
                FileReader fr =new FileReader(folder + "/"+ fileNameToRead);         
                 BufferedReader br= new BufferedReader((InputStreamReader)(fr));        	    			   		 				   } while (!scanFile.next().equals("stop"));        // if user types 'Stop' it will stop the loop and exit from program            });                    	  }) ;      }}                  )}};