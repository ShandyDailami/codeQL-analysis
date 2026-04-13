import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_21295_XMLParser_A03 extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private String currElement = "";
    private Person currPerson = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("person")) {
            currPerson = new Person();
        } else if (qName.equals("name")) {
            bName = true;
        } else if (qName.equals("age")) {
            bAge = true;
        }
        currElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("person")) {
            // save currPerson
        } else if (qName.equals("name")) {
            bName = false;
        } else if (qName.equals("age")) {
            bAge = false;
        }
        currElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            currPerson.setName(new String(ch, start, length));
        } else if (bAge) {
            currPerson.setAge(Integer.parseInt(new String(ch, start, length)));
        }
    }

    public static class Person {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        MyXMLParser handler = new MyXMLParser();
        saxParser.parse("src/main/resources/sample.xml", handler);
    }
}