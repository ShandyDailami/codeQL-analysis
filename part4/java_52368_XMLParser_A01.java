import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
public class java_52368_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    	        		       	     	   	 			         	       				  }                    @SuppressWarnings("deprecation")            private DocumentBuilderFactory dbFactory;     	@Override                   protected DocumentBuilder getDocumentBuilder() {                  return null;}
}   public class CustomElementHandler extends DefaultHandler implements org.xml.sax.helpers.DefaultHandler{    // Implemented methods here }public static void parse(String fileName) throws ParserConfigurationException, SAXException  private InputSource inputSrc;     @Override                     protected DocumentBuilder getDocumentBuilder() {                  return dbFactory.newDocumentBuilder();}