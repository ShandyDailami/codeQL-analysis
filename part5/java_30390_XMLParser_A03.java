import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_30390_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(xmlFile, myHandler);

        } catch (IOException e) {
            e.printStackTrace();

        } catch (SAXException e) {
            e.printStackTrace();
       
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {

            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;

            } else if (bName && qName.equalsIgnoreCase("name")) {
                System.out.println("Name : ");

            } else if (bName && qName.equalsIgnoreCase("age")) {
                System.out.println("Age : ");

            } else if (bAge && qName.equalsIgnoreCase("name")) {
                bName = false;

            } else if (bAge && qName.equalsIgnoreCase("age")) {
                System.out.println("Age : " + qName);

            }

        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {

            if (qName.equalsIgnoreCase("person")) {
                bName = false;
                bAge = false;

            }

        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {

            if (bName) {
                System.out.println(new String(ch, start, length));

            }

        }

    }

}