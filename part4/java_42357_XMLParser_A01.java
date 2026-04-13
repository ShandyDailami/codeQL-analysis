import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
public class java_42357_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, TransformerException{    
        URL url = new URL("http://www.example1.com/samplefile");  //replace with your file location here      
         DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();  
             DocumentBuilder builder;   
          
          try {             
            if(url !=  null)              
                 builder =factory .newDocumentBuilder ();               
                  else                     
                    throw new Exception("Invalid URL");  //If url is not valid then it will come out of the block and exception.         } catch (Exception e1){e1.printStackTrace();}  
           try {            
               Document doc = builder .parse(url.openStream());             
                printElements(doc);    
            } 
        finally {} // this ensures no matter what happens the block of code after it will always be executed, even if an exception occurs      catch (Exception e){e.printStackTrace();}   });    }}`}}};