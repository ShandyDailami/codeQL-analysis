import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.events.XMLEvent;
import org.xml.sax.events.XMLStructure;
import org.xml.sax.helpers.DefaultHandler;

public class java_26561_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlData = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";

        XMLReader reader = null;

        try {
            reader = XMLReaderFactory.createXMLReader();

            DefaultHandler handler = new DefaultHandler(){
                @Override
                public void startDocument() throws SAXException {
                    System.out.println("Start of Document");
                }

                @Override
                public void endDocument() throws SAXException {
                    System.out.println("End of Document");
                }

                @Override
                public void startElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("Start Element: " + qName);
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End Element: " + qName);
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    System.out.println("Characters: " + new String(ch, start, length));
                }
            };

            reader.setContentHandler(handler);
            reader.parse(new StringReader(xmlData));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}