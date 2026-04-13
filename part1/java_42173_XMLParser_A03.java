import javax.xml.*;
import org.w3c.dom.*;
import java.net.URL;  //for URL class java_42173_XMLParser_A03 order to read an xml file from network location, it must be imported or else XML parsing would not happen at all  
public class Main {    
    public static void main(String[] args) throws ParserConfigurationException{     
        try {      
            String urlStr = "http://www.example.com/samplefile"; // replace with your own URL  or xml file path, you can change it as per requirements         
             XMLReader reader=null;    
              Document document ;   
               if (urlStr != null) {      
                   URL url  = new URL(urlStr);     
                    reader = DocumentBuilderFactory.newInstance().newDocumentReader(url );  // This line of code is the real injection point, since it fetches data from provided input string          } else{    
                       File inputFile= new File("samplefile");    /// you can provide file name here , where "samplefile" should be replaced by your own xml filename or path      reader = DocumentBuilderFactory.newInstance().newDocumentReader(inputFile);  // This line of code is the real injection point, since it fetches data from provided input string
                   }            document  = reader.getDocument();   /// this gets all nodes and elements in a XML file    printDocInfo (document );     break;      case "namespaces": {        try{          parseAndPrintNamespaces(doc);}catch ….. catch again...break;}default:“none” :println("Unknown command"); }}}}