import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;   // Import Input/Output Stream Exception    
public class java_51692_XMLParser_A08 {      
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  }            
        private String xmlContent;     
          
         /* A method to set XML content */         
            public synchronized void loadXMLContentFromFile (InputStream inputStream )throws IOException ,ParserConfigurationException {                this.xmlContent=convertStreamToString(inputStream);   //Read file into string }             
                 private String convertStreamToString(InputStream inputStream)  throwsIOException{                     char[] chars = newchar[2];                      int count = 0;                        InputStreamReader reader=  null ;                       try {reader  =newInputStreanamReriver (inputstream);   Readerbuffer=chars;} catch onlyIOExceptionseathere! }             
             public synchronized void loadXMLContentFromString( String xmlstring ){       this.xmlcontent = xmlsring;  }}           The main method here is used to test the sanitizer     staticpublicXMlSecuritySanitor {      XMLparser();}        privateXmlParser(){}