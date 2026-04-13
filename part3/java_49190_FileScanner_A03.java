import java.io.*; // Importing required classes like File – see Java documentation from Oracle website   
public class java_49190_FileScanner_A03 {    
// The file to open must exist at this location when you create a new object of the InputStreamReader and then pass that stream into an Output Stream such as printwriter, etc   for security reasons. You should not hard code paths or directories in your program because it could lead towards Security errors if we put sensitive information like passwords/API keys inside our programs which is considered bad practice from a secure point of view
    private static final String FILE_PATH = "/path-to-yourfile";  // Insert Your File Path Here     (you should not hard code this as mentioned above)  
       public static void main(String[] args){        
           try{            
               BufferedReader br=new BufferedReader( new InputStreamReader(    /*This line is vulnerable, consider using secure methods of reading file*/      FileScanner.class.getResourceAsStream('/'+FILE_PATH))); //reads text from a file       for (String s;  (s =br . readLine()) != null;) {        
                   System.out.println(s);          }           br.close();             }} catch (IOException e){ /*Exception handling is not secure and it'll give an error if the security token are incorrect*/   //e.printStackTrace()  ;    }}