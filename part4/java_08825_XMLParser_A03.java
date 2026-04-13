import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLParserFactory;

import java.io.File;

public class java_08825_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFilePath = "path/to/your/xml/file.xml"; // replace with your xml file path
        parseXml(xmlFilePath);
    }

    public static void parseXml(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);

        XMLParserFactory factory = XMLParserFactory.newInstance();
        XMLParser parser = factory.newSAXParser(null, new MyHandler());

        try {
            parser.parse(xmlFile, new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class MyHandler extends DefaultHandler {
        private String curElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            curElement = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (curElement.equals("element")) {
                System.out.println("Extracted information: Element Name = " + qName);
            } else if (curElement.equals("attribute")) {
                System.out.println("Extracted information: Attribute Name = " + attributes.getValue("name"));
            }
            curElement = null;
        }
    }
}