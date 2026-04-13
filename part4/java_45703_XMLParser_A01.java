import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
 
public class java_45703_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{       
            // Loading the XML file into a Document object          
             File inputFile = new File("path/toYourXml");         
              Reader reader; 
               try {     
                reader=new FileReader(inputFile);   
                 } catch (FileNotFoundException e1) {    
                     System.out.println ("Unable to find the file.");   return;}        //Check if xml exists and accessible at given path      
             DocumentBuilderFactory dbFactory = 
              DocumentBuilderFactory.newInstance();          
               DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();         
            try { 
                Document doc=dBuilder.parse(reader);    } catch (IOException e)         //Check if xml file is accessible at given path        return;       case Logger : System . out . println ("Warning , unable to log - " +e2 );      default:break;}           });   }}