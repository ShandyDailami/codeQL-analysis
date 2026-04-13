import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_19267_XMLParser_A07 {
    public static void main(String[] args) {
        String xml = "<document><student id='1'><name>John</name><course>Math</course></student></document>";
        parseXML(xml);
    }

    private static void parseXML(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new Handler());
            parser.parse(new InputSource(new StringReader(xml)), Handler.getOptions());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Handler extends DefaultHandler {
        private boolean name;
        private boolean course;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                name = true;
            } else if (qName.equalsIgnoreCase("course")) {
                course = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (name) {
                System.out.println("Name: " + new String(ch, start, length));
                name = false;
            } else if (course) {
                System.out.println("Course: " + new String(ch, start, length));
                course = false;
            }
        }
    }
}