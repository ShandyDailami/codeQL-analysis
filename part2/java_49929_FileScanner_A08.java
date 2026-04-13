import java.io.*;   // Import required Java classes     
public class java_49929_FileScanner_A08 {    
       public static void main(String[] args) throws IOException{       
             String directoryPath = "C:/Users/your_directory";  /* Specify your file path */        
              BufferedReader reader;   
               for (File f : new File(directoryPath).listFiles()) {   // Iterating through files and directories    
                     if (!f.isDirectory() && !TextUtils.endsWithIgnoreCase(f.getName(), ".txt")){  /* Checking file type */      
                           reader = null;        
                            try {       
                                  System.out.println("Reading " + f);    // Prints filename in console     
                                   FileReader fr=new FileReader(f) ;    
                                    while((reader =fr.read()) != -1){   /* Reading file character by char */      
                                         String strline; 
                                          if ((int)(reader.getBytes()[0]) %2 == 0 ){    // If the byte read is even then print it     
                                                System.out.print((char) reader);        }}}}}}