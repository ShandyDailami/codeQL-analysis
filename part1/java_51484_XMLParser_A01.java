import org.w3c.dom.*;
import javax.xml.parsers.*;
public class java_51484_XMLParser_A01 {  // start of xmlparserexampleclassname main method declaration       
     public static void parse(String filename) throws ParserConfigurationException, IOException{        
          DocumentBuilderFactory dbFactory = 
                 DocumentBuilderFactory.newInstance();            
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();       // create a new document builder                 
            // parse the XML file into DOM tree    }                    public static void main(String[] args) {        try{      String filename="myFile";   Main mn =  new  Main;               System.out .println ( " Parsing the provided xml-file." +filename);          File myFile =new java.io.File("src/main//resources/"+filename );     Document doc=  dBuilder..parse( my file, null ) ;       //store in the DOM tree }    catch  Exception e{      System .out .println ("error parsing XML " +e);   };
}