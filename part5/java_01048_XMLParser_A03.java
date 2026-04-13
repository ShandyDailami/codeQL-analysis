import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_01048_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true); // Creating a SAX parser with a Handler

            // Creating a Handler and passing it to the SAX parser
            DefaultHandler handler = new DefaultHandler() {
                boolean bName = false;
                boolean bAge = false;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {
                    if (qName.equalsIgnoreCase("person")) {
                        bName = true;
                        bAge = true;
                    }
                    if (bName && qName.equalsIgnoreCase("name")) {
                        System.out.println("Name: ");
                    }
                    if (bName && qName.equalsIgnoreCase("age")) {
                        System.out.println("Age: ");
                    }
                    if (bAge && qName.equalsIgnoreCase("name")) {
                        System.out.println("Name: ");
                    }
                    if (bAge && qName.equalsIgnoreCase("age")) {
                        System.out.println("Age: ");
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("name")) {
                        bName = false;
                    }
                    if (qName.equalsIgnoreCase("age")) {
                        bAge = false;
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (bName) {
                        System.out.print(new String(ch, start, length));
                    }
                    if (bAge) {
                        System.out.println("Age: " + new String(ch, start, length));
                    }
                }
            };

            saxParser.parse(new File("src/main/resources/person.xml"), handler);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}