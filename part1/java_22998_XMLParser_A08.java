import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_22998_XMLParser_A08 {
    public static void main(String[] args) {
        String inputFile = "/path/to/your/xml/file";
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxFactory.newSAXParser();

            MyHandler myHandler = new MyHandler();
            saxParser.parse(inputFile, myHandler);

            List<String> personList = myHandler.getPersonList();
            for (String person : personList) {
                System.out.println(person);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        List<String> personList;
        StringBuilder personBuilder;
        boolean bPerson;

        @Override
        public void startDocument() throws SAXException {
            personList = null;
            personBuilder = new StringBuilder();
            bPerson = false;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bPerson = true;
                personBuilder = new StringBuilder();
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bPerson) {
                personBuilder.append(new String(ch, start, length));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                personList.add(personBuilder.toString());
                bPerson = false;
            }
        }

        public List<String> getPersonList() {
            return personList;
        }
    }
}