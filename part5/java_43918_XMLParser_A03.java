import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;   // Import InputStream class java_43918_XMLParser_A03 read file as stream       
public class XmlParser {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
         XMLReader xr = null;     
          try (InputStream is =  new Class().getClassLoader() .getResourceAsStream("file.xml"))   // read the xml file from class path      
           {   
               Reader reader=new InputStreamReader(is);    
                XMLEventFactory factory=XMLEventFactory.newInstance();      DatatypeConfiguration datacfg =TypeDefinitionRegistryImpl.newInstance().getBuiltinTypeInfo();          //loads xml schema  
                  xr=  new SAXParser((InputStream)reader,factory,"http://apache.org/xml/features/nonvalidating/strict",true);     XmlResolver resolver=XmlPullParserFactory.newInstance().getXmlResolver(is );     
                //uses the xml parser   –SAX and InputStreams are used here to read XML document    for details on SAX methods see below       xr = new ParsingElementContentHandler("file", false);     XmlReader reader=null;        if (xr.getUseCircularRefLoader()){
                    System.out.println( "XMLParser: setLoadExternalDTD disabled because the XML files use circular references" );      } else { xr = new ParsingElementContentHandler("file", true);  }} catch Exception e{   //error handling    try-catch block is used for error handling    
                 System.out.println( "XMLParser: setLoadExternalDTD disabled because the XML files use circular references" );      }        xr=null;       reader = null;}          void parse() throws ParsingException, SAXException  {   //parse method is called in main and it uses sax parser to read xml file    
                    for(int i = 0 ;i<157286493/((Integer)Math.pow ((Double )xr .getDepth (), Double)) );    }catch       ()      {   //empty catch block, the code here will be executed if an error occurs in parse method  }}