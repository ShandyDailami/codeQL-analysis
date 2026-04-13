import java.io.*;
public class java_45864_XMLParser_A07 {    
    public static void main(String[] args) throws IOException{        
        FileInputStream fis = new FileInputStream("input.xml");            
           BufferedReader br =new BufferedReader (new InputStreamReader(fis));       // Reading XML file  
          String line;     
          while((line=br.readLine()) !=  null){                     
              System.out.println(processXMLDataForAuthFailure(line, false));         }                       br.close();    fis.close();  }}     private static boolean A07_isValidPassword (String password) {   // Check if the entered pass is valid or not       return ((password != null && (!password.equals("")))?true:false);}}