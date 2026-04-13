import java.io.File;
import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_05484_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            
            xmlReader.setContentHandler(new XmlContentHandler());
            
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class XmlContentHandler implements org.xml.sax.ContentHandler {
    private boolean bElement = false;
    private String sElement = "";
    private String sAttribute = "";
    
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
        throws SAXException {
        bElement = true;
        sElement = qName;
        // Handle attributes if any
        if (attributes != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                sAttribute += attributes.getQName(i) + " = " + attributes.getValue(i) + ", ";
            }
        }
    }
    
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bElement = false;
        sElement = "";
        sAttribute = "";
    }
    
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElement) {
            System.out.println("Element: " + sElement + ", Attributes: " + sAttribute + ", Text: " + new String(ch, start, length));
        }
    }
}