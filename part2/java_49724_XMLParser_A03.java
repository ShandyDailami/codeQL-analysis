import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_49724_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{ 
        parse("src/testdata1.xml"); // replace with your xml file path here    
    }     
      
    private static DocumentBuilderFactory factory;         
          
    /** Parse an XML document and print it */  
    public void parse(String filename) throws ParserConfigurationException, IOException{ 
        if (factory == null){            
            // Create a new factory object             
            factory = DocumentBuilderFactory.newInstance();    
                                                                               }               
           final DocumentBuilder builder;      
                                                       try {        
                                            builder= factory.newDocumentBuilder();     
                                        } catch (ParserConfigurationException e) {                 
                                         System.out.println("Could not create a new document Builder " +e);            return;}         
                                                                               //Use the builder to parse an XML file      
           Document doc = null;                      try{             
                                            doc=builder.parse(new File(filename));  } catch (SAXException e) {                  System.out.println("Parse Failed: main " +e); return;}       
                                                       //Now we can access data read from the xml file                    
                                                                               Element root =doc.getDocumentElement();       Root =root;          NameSpace Xmlns=null ;   try{  Split xmldata  = (Split) doc . getElementsByTagName( "split" ).item(0);    //Getting split node           } catch ( Exception e){ System.out.println("Exception is : \n "); return;}