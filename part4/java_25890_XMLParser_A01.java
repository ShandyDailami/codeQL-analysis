import java.io.File;
import java.util.List;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_25890_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        parseXmlFile(xmlFile);
    }

    private static void parseXmlFile(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(xmlFile);
            document.getDoctype(); // This line will throw an exception if the file is not well-formed

            XMLReader reader = XMLReaderFactory.createXMLReader();
            DefaultHandler handler = new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {
                    System.out.println("Start element: " + qName);
                    printAttributes(attributes);
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End element: " + qName);
                }
            };

            reader.setContentHandler(handler);
            reader.parse(new InputSource(new StringReader(document.getDocumentElement().getOuterXml())));
        } catch (ParsingException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printAttributes(Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.println("Attribute: " + attributes.getQName(i) + " = " + attributes.getValue(i));
        }
    }
}