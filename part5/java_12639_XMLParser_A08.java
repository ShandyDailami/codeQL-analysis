public class java_12639_XMLParser_A08 {

    public static void main(String[] args) {

        try {
            XMLParser parser = new XMLParser();

            // Parse XML from string
            Document doc = parser.parse(getClass().getResourceAsStream("/sample.xml"));

            // Print out all tags in the document
            NodeList list = doc.getElementsByTagName("*");
            for (int i = 0; i < list.getLength(); i++) {
                Element e = (Element) list.item(i);
                System.out.println("Tag: " + e.getTagName());
            }

            // Print out all attributes in the document
            list = doc.getElementsByTagName("*");
            for (int i = 0; i < list.getLength(); i++) {
                Element e = (Element) list.item(i);
                NamedNodeMap attrs = e.getAttributes();
                for (int j = 0; j < attrs.getLength(); j++) {
                    Node attr = attrs.item(j);
                    System.out.println("Attribute: " + attr.getNodeName() + " = " + attr.getTextContent());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class XMLParser extends DefaultHandler {

    public Document parse(InputStream in) throws ParsingException {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(in);
        return doc;
    }

    public Document parse(String in) throws ParsingException {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(in);
        return doc;
    }

    public Document parse(File in) throws ParsingException {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(in);
        return doc;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void fatalError(String error) throws SAXException {
        System.out.println("Fatal error: " + error);
    }

    @Override
    public void warning(SAXException warning) throws SAXException {
        System.out.println("Warning: " + warning.getMessage());
    }
}