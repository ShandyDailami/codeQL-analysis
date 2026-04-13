import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_46204_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{ 
        parse("<note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note>");   
       //Here we can call other methods too. Use them according to your needs  
        } 
     public static void parse(String inputXml) throws ParserConfigurationException, IOException{     
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();        
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();      
           
           InputSource is= new InputSource(new StringReader(inputXml));  //Creating an input source from the string read  
            
          Document doc =dBuilder.parse(is);   
                 
         doc.getDocumentElement().normalize();    
             
      System.out.println("Root Element: " +doc.getElementsByTagName("note").item(0).getTextContent());  //Printing the value of root element      
           }  
}