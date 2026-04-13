import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.xmlreader.XMLReader;
import org.xml.sax.xmlreader.XMLReturn;
import org.xml.sax.xmlreader.XMLStreamReader;
import org.xml.sax.xmlreader.util.LeakedStreamHandler;

import java.io.File;
import java.io.IOException;

public class java_06930_XMLParser_A08 {
    public static void main(String[] args) {
        String url = "path_to_your_xml_file.xml";
        File xmlFile = new File(url);
        SAXParser saxParser = SAXParser.newInstance();

        try {
            XMLParser xmlParser = saxParser.getXMLParser();
            xmlParser.setDTDHandler(null);
            xmlParser.setFeature("http://xml.org/sax/features/external-parametrized-entity-references", false);
            xmlParser.setFeature("http://xml.org/sax/features/namespaces", false);
            xmlParser.setFeature("http://xml.org/sax/features/namespace-prefixes", false);
            xmlParser.setFeature("http://xml.org/sax/features/validation", false);
            xmlParser.setFeature("http://xml.org/sax/features/external-general-entities", false);

            MyContentHandler contentHandler = new MyContentHandler();
            xmlParser.setContentHandler(contentHandler);

            xmlParser.parse(xmlFile);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler extends DefaultHandler {
    private boolean bElement = false;
    private String strElement = null;

    @Override
    public void startElement(String namespaceURI, String localName, String qualifiedName,
                             XMLAttributes attributes) throws SAXException {
        bElement = true;
        strElement = qualifiedName;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qualifiedName)
            throws SAXException {
        bElement = false;
        strElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElement) {
            String str = new String(ch, start, length);
            // Perform security sensitive operation here, like checking for integrity failure
            // For the purpose of this example, we're just printing the content to the console
            System.out.println(strElement + ": " + str);
        }
    }
}