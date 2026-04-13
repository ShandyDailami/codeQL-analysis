import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.ElementListener;
import org.xml.sax.XMLReader;
import java.io.File;
import java.io.IOException;

public class java_32940_XMLParser_A03 extends DefaultHandler {
    private String nodeName;

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
            XmlParser handler = new XmlParser();
            reader.setContentHandler(handler);
            reader.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, 
                             org.xml.sax.Attributes attributes) throws SAXException {
        nodeName = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) 
                          throws SAXException {
        System.out.println(nodeName);
    }
}