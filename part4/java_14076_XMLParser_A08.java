import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_14076_XMLParser_A08 {
    public static void main(String[] args) {
        String filePath = "path_to_your_xml_file.xml"; // replace with your file path
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equals("person")) {
                bName = true;
                bAge = true;
                System.out.println("Name  |  Age");
                System.out.println("------|------");
            } else if (bName) {
                System.out.print("Name: ");
                bName = false;
            } else if (bAge) {
                System.out.println("Age: ");
                bAge = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (qName.equals("person")) {
                bName = false;
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (bName) {
                System.out.print(new String(ch, start, length));
            } else if (bAge) {
                System.out.println(new String(ch, start, length));
            }
        }
    }
}