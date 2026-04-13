import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_13454_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml";  // your xml file path

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new MyHandler());

            parser.parse(new File(xmlFile), new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean bName = false;
        boolean bAge = false;
        boolean bCity = false;
        String name = "";
        String age = "";
        String city = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                // start of "person" tag
                bName = true;
                bAge = true;
                bCity = true;
            } else if (bName && qName.equalsIgnoreCase("name")) {
                // start of "name" tag
                bName = false;
                name = "";
            } else if (bName && qName.equalsIgnoreCase("age")) {
                // start of "age" tag
                bAge = false;
                age = "";
            } else if (bAge && qName.equalsIgnoreCase("city")) {
                // start of "city" tag
                bCity = false;
                city = "";
            } else if (bName && qName.equalsIgnoreCase("name")) {
                name = attributes.getValue("name");
            } else if (bAge && qName.equalsIgnoreCase("age")) {
                age = attributes.getValue("age");
            } else if (bCity && qName.equalsIgnoreCase("city")) {
                city = attributes.getValue("city");
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                // end of "person" tag
                System.out.println("Name: " + name + ", Age: " + age + ", City: " + city);
            }
        }
    }
}