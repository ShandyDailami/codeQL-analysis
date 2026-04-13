import java.io.*; // For File I/O Operations, BufferedReader etc.
// Import for InputStream and OutputStream classes (not required but included here)
public class java_43915_FileScanner_A08 {  
    public static void main(String[] args){ 
        try{            
            String fileName = "path_to_your_file"; // Provide your own path to the text file. For example: "/Users/username/Documents/_test.txt"    
      FileReader fr=new FileReader (fileName);   BufferedReader br=  new  BufferedReader(fr) ;    String strLine;          int lineNumber = 1;           while ((strLine = br .readLine()) != null){              System.out.println(" Line " +lineNumber++  +" : -> Content: \""+ strLine +  "\")");}            
            fr.close();         }  catch (Exception ex) {          //handle the exception here           };   }}`);    if there is any issue like file not found etc., handle it accordingly in real-world application then only show error message otherwise we can't see where our data has been compromised, thats why I have provided a generic catch block.