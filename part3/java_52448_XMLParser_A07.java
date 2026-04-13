import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_52448_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String xmlFile = "sample.xml"; //your XML file name here     
        
       try { 
           DocumentBuilderFactory dbFactory = 
                DocumentBuilderFactory.newInstance();  
           
          /*DocumentBuilder builder;*/   
           DBConfig dbConf= new DBConfig(null);     # your config settings, e.g., trusted host string array and so on     
         //builder =dbFactory .newDocumentBuilder ( );  -- not needed for this example       
		   Document doc = 	dbFactory .newDocumentBuilder().parse(xmlFile) ;    /* read the xml file */     } catch (ParserConfigurationException e1){          System.out.println("Failed to parse configuration");         e1.printStackTrace();}  //catching parsing config issues
           catch (SAXException e ){   system . out . println ("Xml Parsing failed ");        echoe    }     finally {// Always close the document          DocumentShutdown    ,false);}}      else System.out,println("Invalid file or null Object");}  //catch parsing issues