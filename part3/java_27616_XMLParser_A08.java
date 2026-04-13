import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_27616_XMLParser_A08 {

    public static void main(String[] args) {
        String url = "path_to_your_xml_file.xml"; // replace with your xml file
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(url, new SAXSource(new File(url)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        boolean bName = false;
        boolean bAge = false;
        String name = null;
        String age = null;

        public void startDocument() throws SAXException {
            System.out.println("Start of Document");
        }

        public void endDocument() throws SAXException {
            System.out.println("End of Document");
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("person")) {
                bName = true;
                bAge = true;
            } else if (bName && qName.equals("name")) {
                bName = false;
                name = attributes.getValue("id");
            } else if (bName && qName.equals("age")) {
                bAge = false;
                age = attributes.getValue("id");
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("person")) {
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                bName = false;
                bAge = false;
                name = null;
                age = null;
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName)
                name = new String(ch, start, length);
            if (bAge)
                age = new String(ch, start, length);
        }
    }
}