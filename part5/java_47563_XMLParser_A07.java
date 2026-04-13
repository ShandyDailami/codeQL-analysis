import java.io.*; // For File I/O Operations, BufferedReader and PrintWriter classes are used here in place of standard libraries like InputStream or OutputStream  
public class java_47563_XMLParser_A07 {   
     public static void main(String[] args) throws IOException{ 
         String xmlFilePath = "your_xml.xml"; // Replace this with your actual XML file path      
          FileReader reader =  new FileReader (xmlFilePath);       
           BufferedReader bufferedReader  =new BufferedReader(reader);     
            int c;  
             while((c=bufferedReader.read()) !=  -1){    //Reading and processing the XML file character by characer    
                 System.out.print((char) c);  }         
               bufferedReader.close();       reader.close ( ) ;     
        }}