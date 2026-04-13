import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
public class java_52694_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String fileName = "src/main/resources/sample-data.xml"; // replace with your xml path 
         try (FileInputStream fis = new FileInputStream(fileName)) {  
             XMLParser xpp = XMLParser.newInstance();   
              DocumentBuilderFactory dbFactory = 
                    DocumentBuilderFactory.newInstance();     
                  DBConfigurator configurator=dbFactory.newDocumentBuilderConfigurator();    
                 documentBuilder=  dbFactory .newDocumentBuilder( new InputSource(fis));  
             xpp.setDocumentBuilder(documentBuilder);  // set the builder to parser       
                System.out.println("Parsing complete!");    } catch (FileNotFoundException e) {     
            e.printStackTrace();     }}          protected DocumentBuilder documentBuilder; private XMLParser xmlp = new XMLParserImpl() ;   static class DBConfigurator implements DocumentBuilderFactoryConfigurator{ public void  setEntityResolver( EntityResolver er){}    @Override        public EndElement resolveEndElement (String namespaceUri, String localName ,
             String name ) throws SAXException {return null;}      @Override         default   XmlReader newDocumentLoader()     {@ Override Defaults in Interface:  return false;}} ; }`          catch( Exception e){    System.out.println("Error while parsing the XML file " +e); }}