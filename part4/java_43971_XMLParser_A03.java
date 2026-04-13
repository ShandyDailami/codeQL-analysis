import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
public class java_43971_XMLParser_A03 { 
    public static void main(String[] args) throws Exception{  
        //Create a new SAX Parser Factory    
       SAXParserFactory spf = SAXParserFactory.newInstance();     
         try{         
             //Parse an xml file using the created factory object           
           SAXParser saxParser=spf.newSAXParser(true);// create a new parser with explicit validation  
              HandlerClass hc =  new  HandlerClass ( );   
               //parse through XML data from input-file    
             saxParser .parse("inputFile.xml",hc ) ;          }      catch (Exception e){       System.out.println(e);}        }}`;//close the try block