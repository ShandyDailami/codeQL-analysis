import java.io.*; // Import BufferedReader for reading from files 
import javax.xml.parsers.*; // To parse XML  
import org.w3c.dom.*; // DocumentBuilderFactory and Parser are necessary to create DOM tree (like an element-tree or a SAX parser)   
import org.xml.sax.SAXException;  // You'll use this if you want the more powerful, but also much larger code  
public class java_47522_XMLParser_A07 {    
private static final String USERNAME = "username";          
       public static void main(String[] args){                  
        try{                     
             File inputFile =  new File("inputfile");      // Create a buffered reader to read the file           
              BufferedReader br=new BufferedReader(new FileReader(inputFile));    // Read from your XML  content  
               DocumentBuilderFactory dbFactory =DocumentBuilderFactory.newInstance();    
             DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();     
              Document doc =dBuilder.parse(inputFile);      
               
            doc.getDocumentElement().normalize();          // Normalise the document, ie resolve all relative links  
               System.out.println("Root element : " +doc.getElementsByTagName("username").item(0).getTextContent());      }  catch (FileNotFoundException e) {                println ("Cannot find file inputfile");       }}        // Handle any errors that may occur              catch (ParserConfigurationException pce){           
           System.out.println("/nInput File not found!/r"+pce);}             catch(SAXException se ){System.out.printIn("/" +se );  }               println ("Error: " +  e .getMessage()); }} //Print error info if exist     finally {if (br != null) try { br.close();}}catch (IOException ex){println("/nClosing file inputFile was not possible./r"+ex);}}}