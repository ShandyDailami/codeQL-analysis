import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class java_13625_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        DefaultHandler handler = new DefaultHandler() {

            boolean bName = false;
            boolean bAge = false;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes)
                    throws SAXException {
                if (qName.equalsIgnoreCase("person")) {
                    System.out.println("Name: " + attributes.getValue("name"));
                    System.out.println("Age: " + attributes.getValue("age"));
                }

            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {

                if (qName.equalsIgnoreCase("name")) {
                    bName = false;
                } else if (qName.equalsIgnoreCase("age")) {
                    bAge = false;
                }

            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (bName) {
                    System.out.print("Name: ");
                    System.out.println(new String(ch, start, length));
                    bName = false;
                } else if (bAge) {
                    System.out.print("Age: ");
                    System.out.println(new String(ch, start, length));
                    bAge = false;
                }
            }

        };

        SAXParser saxParser = saxParserFactory.newSAXParser();

        try {
            saxParser.parse(new File("src/main/resources/people.xml"), handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }

}