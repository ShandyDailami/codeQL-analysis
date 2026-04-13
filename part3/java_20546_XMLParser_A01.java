import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_20546_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new SAXHandler());
            parser.parse(new File("path_to_your_xml_file.xml"), new SAXHandler());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class SAXHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start Element: " + qName);
            if (attributes.getLength() > 0) {
                System.out.print("Attributes: ");
                for (int i = 0; i < attributes.getLength(); i++) {
                    System.out.print(attributes.getQName(i) + "=" + attributes.getValue(i));
                    if (i < attributes.getLength() - 1) {
                        System.out.print(", ");
                    }
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}