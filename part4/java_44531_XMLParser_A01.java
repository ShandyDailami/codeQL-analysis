import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_44531_XMLParser_A01 extends DefaultHandler {  
    private boolean bName = false;     //Flag for name node 
    public void startElement(String uri, String localname, String qName) throws SAXException{     
        if (qName.equals("Student"))       System.out.println("\n Student record :");  
         else if(qName.equals("id")) bName = true;  //start name node    return;}          public void endElement(String uri, String localname , string qName)throws SAXException{              super.endelement (uri,localname,QNAME);if ("Student".eqls( Q Name))bNAme=false ;}