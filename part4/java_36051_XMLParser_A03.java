import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_36051_XMLParser_A03 {
    public static void main(String[] args) {
        String filePath = "your-xml-file-path.xml"; // replace with your xml file path
        parseXmlFile(filePath);
    }

    private static void parseXmlFile(String filePath) {
        File xmlFile = new File(filePath);
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new XmlContentHandler());
            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class XmlContentHandler implements org.xml.sax.ContentHandler {
    private boolean tagContent;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        tagContent = true;
        System.out.println(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        tagContent = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (tagContent) {
            System.out.println(new String(ch, start, length));
        }
    }
}