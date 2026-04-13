import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
public class java_52541_XMLParser_A01 { 
    public static void main(String args[]) throws ParserConfigurationException , IOException   {    
        // Load the XML file using DOM parser in a non-thread safe manner, by providing configuration information about where to read the document from and what is allowed as parsers.     
            DocumentBuilderFactory factory =DocumentBuilderFactory . newInstance ();        
             factory.setValidating( true ); 
              //factory for building dom tree      
               DocumentBuilder builder= factory.newDocumentBuilder();       
                //parse the document and create a DOM representation of it    
                 Document doc =  builder.parse("externalFilePath");   ##replace with your file path##     
             getNodeInfo(doc);  }    public static void getNodeInfo(Document doc){       NodeList nodes= doc .getElementsByTagName ("*") ;        for (int temp= 0;temp<nodes.getLength();++, ++) {           Element element = (Element) nodes.item(Temp );          System.out.print("node name : "+element.getNodeName());         }}}