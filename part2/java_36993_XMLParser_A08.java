import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_36993_XMLParser_A08 {

    public static void main(String[] args) {
        String xml = "<data><student id='1' name='John' score='90'/><student id='2' name='Jane' score='85'/><student id='3' name='Bob' score='78'/></data>";

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            SAXHandler handler = new SAXHandler();
            parser.parse(xml.getBytes("UTF-8"), handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {

        boolean bStudent = false;
        String id = null;
        String name = null;
        String score = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("student")) {
                bStudent = true;
                id = attributes.getValue("id");
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("student")) {
                bStudent = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bStudent) {
                if (id != null)
                    id += length;
                if (name != null)
                    name += length;
                if (score != null)
                    score += length;
            }
        }

        @Override
        public void endDocument() {
            System.out.println("Student Id: " + id);
            System.out.println("Student Name: " + name);
            System.out.println("Student Score: " + score);
        }
    }
}