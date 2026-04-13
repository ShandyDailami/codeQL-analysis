import java.io.*; // Importing necessary classes for file handling in JVM  
public class java_52559_FileScanner_A07 {    
    public static void main(String[] args) throws IOException{       
         String dirPath = "/path/to/your/directory";  // your target path     
       File directory = new File(dirPath);         
           if (directory.exists())                     
            for (File file : directory.listFiles((d, n) -> n.endsWith("txt"))){        
                try {   
                    BufferedReader br=new BufferedReader(new FileReader(file));   // Reading text files    
                        String line; 
                            while ((line = br.readLine()) != null ){             
                                if (line.contains ("AuthFailure"))                 
                                    System.out.println("File found: " + file);             }                                                   };                          }}      });            finally {                      // Ensure resource is closed properly  try-with resources in Java  5+    BufferedReader br = new BufferedReader(new FileReader (file));}}};