import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_03962_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFile = "example.xml";
        parseXML(xmlFile);
    }

    private static void parseXML(String xmlFile) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    System.out.println("Start Element: " + qName);
                    System.out.println("Attributes:");
                    for (int i = 0; i < attributes.getLength(); i++) {
                        System.out.println("  " + attributes.getQName(i) + " = " + attributes.getValue(i));
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) {
                    System.out.println("End Element: " + qName);
                }

                @Override
                public void characters(char[] ch, int start, int length) {
                    String content = new String(ch, start, length).trim();
                    if (content.length() > 0) {
                        System.out.println("  Content: " + content);
                    }
                }
            });

            reader.parse(xmlFile);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}