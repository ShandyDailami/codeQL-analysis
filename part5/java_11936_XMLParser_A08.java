import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_11936_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml"); // replace with your xml file path
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            // Using DocumentBuilderFactory to parse XML file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Creating a namespace manager and setting the namespace
            Namespace ns = new Namespace("http://www.example.com/mynamespace");
            NamespaceManager nsManager = NamespaceSupport.getNamespaceManager();
            nsManager.registerNamespace("mynamespace", "http://www.example.com/mynamespace");

            // Using SAXParser to parse XML with namespace
            MyHandler myHandler = new MyHandler();
            saxParser.parse(doc, myHandler);

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean bNSpace = false;
    StringBuffer buffer = null;

    public java_11936_XMLParser_A08() {
        buffer = new StringBuffer();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (bNSpace) {
            buffer.append("<").append(qName);
            for (int i = 0; i < attributes.getLength(); i++) {
                buffer.append(" ").append(attributes.getQName(i)).append("=").append("\"").append(attributes.getValue(i)).append("\"");
            }
            buffer.append("/>" + System.lineSeparator());
        } else {
            System.out.println(qName);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(":namespace-name")) {
            bNSpace = false;
            System.out.println(buffer.toString());
            buffer.setLength(0);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bNSpace) {
            buffer.append(new String(ch, start, length));
        }
    }
}