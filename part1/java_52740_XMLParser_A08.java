import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
public class java_52740_XMLParser_A08 {   
     public static void main(String[] args) throws ParserConfigurationException, SAXException{      
         String xmlFile = "/path/to/yourXMLfile"; // Put your file path here 
          try (Reader reader =  new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/books20k_18596473cbfbcebdbeaacbbecfafdcdaefile"), "UTF-8"))) {      
            XMLParser parser = ParserManager.newSAXParser();     // Using SAX for parsing   
              DefaultHandler handler= new DefaultHandler(){     
                  public void startDocument(){} 
                   .....       
               };  
                try{parser.parse(reader,handler);}      
                 catch (Exception e){System.out.println("Error while Parsing XML: "+e ); } // Catch any exceptions that may occur during the parsing process          
          } 
     }}