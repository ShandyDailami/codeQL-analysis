import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
  
public class java_43332_XMLParser_A07 {    //start of code snippet    
      
      public static void main(String[] args) throws ParserConfigurationException, SAXException 
            {        startParsing(); }         private static int errorCount = 0;              DefaultHandler dh = new MyDefaultHandler(){ @Override protected void endElement ( String uri , String localName , String qName )    //end of code snippet     };      public interface ElementListener{      	public abstract  boolean isAuthFailureExpected(String elementname);}