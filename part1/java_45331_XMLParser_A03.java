import java.io.*; // for File, InputStreamReader, BufferedReader etc...  
public class java_45331_XMLParser_A03 {   
     public static void main(String[] args) throws Exception{     
         String line;      
          try (BufferedReader br = new BufferedReader(new FileReader("samplexmlfile.xml"))){ // reading from a file       
              while ((line=br.readLine()) != null ) {           
                  System.out.println("\nParsing XML data: " + line);             }    
          catch (IOException e)               {}                }}