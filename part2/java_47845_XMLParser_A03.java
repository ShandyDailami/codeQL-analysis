import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
public class java_47845_XMLParser_A03 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        File inputFile = new File("inputfilepath"); // replace with actual file path here    
      XMLParser parser=null;        
       try {            
            String xmlData=readFileAsString(inputFile); 
           System.out.println("\nXML Data: "+xmlData );  
          parseXmlContent(xmlData,parser);    }              catch (IOException e)                   {e.printStackTrace();}      }}               public static void     parseXmlContent( String xmlData , XMLParser parser ) throws ParserConfigurationException ，SAXException{            DocumentBuilderFactory dbFactory   =   DocumentBuilderFactory .newInstance () ;            
DocumentBuilder dBuilder  =    dbFactory.newDocumentBuilder ();        DOMSource           source      = new   DOMSource     (xmlData)          ;         System.out.println ("\nData loaded into the document...... " + "\n");  parser.parse(source,            DocumentHandler )
}              public static String readFileAsString( File file ) throws IOException {        BufferedReader in          = new   BufferedReader (new     InputStreamReader      (    new FileInputStream       (file) , "UTF-8") );         StringBuilder sb  = new  StringBuilder();                //Read and load the xml data to a string.                  
String line;          while( (line = in .readLine()) != null ) {           sb            .append   (     line     + "\n");}             return    sb       .toString() ; }