import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_03273_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            DefaultHandler defaultHandler = new DefaultHandler() {
                boolean bName = false;
                boolean bAge = false;
                String name = null;
                String age = null;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {
                    if (qName.equalsIgnoreCase("person")) {
                        bName = true;
                        bAge = true;
                    } else if (bName && qName.equalsIgnoreCase("name")) {
                        bName = false;
                    } else if (bName && qName.equalsIgnoreCase("age")) {
                        bAge = false;
                    } else if (bName) {
                        name = attributes.getValue("name");
                    } else if (bAge) {
                        age = attributes.getValue("age");
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("person")) {
                        System.out.println("Name: " + name);
                        System.out.println("Age: " + age);
                        bName = false;
                        bAge = false;
                        name = null;
                        age = null;
                    }
                }
            };

            saxParser.parse(Class.forName("org.xml.samples.Person").getResourceAsStream("person.xml"), defaultHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}