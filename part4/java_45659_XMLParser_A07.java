import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;
public class java_45659_XMLParser_A07 {  
    public static void main(String[] args) throws Exception{    
        String urlStr = "http://sample.com/books.xml";  // replace with actual URL      
         try {             
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();              
             DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();               
         
           Document doc=dBuilder.parse( new URL(urlStr).openStream());  
        //  print the content of xml file   
         doc.getDocumentElement().normalize();     
            System.out.println("Root Element : " +doc.getElementsByTagName("book").item(0).getTextContent() );     }       catch (Exception e) {          e.printStackTrace();  }}   }`    // end of main method}