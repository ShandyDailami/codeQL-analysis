import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_30438_XMLParser_A08 extends DefaultHandler {
    private String currentElement;
    private boolean inTitle;

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        String xmlFile = "/path/to/your/xml/file.xml";
        MinimalistXMLParser parser = new MinimalistXMLParser();
        XMLParserUtil.parseXML(xmlFile, parser);
    }

    @Override
    public void startDocument() {
        System.out.println("Start document");
    }

    @Override
    public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) {
        System.out.println("Start element: " + qualifiedName);
        this.currentElement = qualifiedName;
        this.inTitle = true;
    }

    @Override
    public void endElement(String uri, String localName, String qualifiedName) {
        System.out.println("End element: " + qualifiedName);
        this.currentElement = null;
        this.inTitle = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (this.inTitle) {
            System.out.println("In title: " + new String(ch, start, length));
        } else {
            System.out.println("In element: " + this.currentElement + " -> " + new String(ch, start, length));
        }
    }

    @Override
    public void endDocument() {
        System.out.println("End document");
    }

    private static class XMLParserUtil {
        private static void parseXML(String xmlFilePath, DefaultHandler handler) throws ParserConfigurationException, SAXException {
            File xmlFile = new File(xmlFilePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            saxParser.setContentHandler(handler);
            saxParser.parse(document.getDocumentElement());
        }
    }
}