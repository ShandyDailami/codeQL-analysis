import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_06226_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        MyHandler handler = new MyHandler();
        saxParser.parse(new File("sample.xml"), handler);

        List<String> elements = handler.getElements();
        for (String element : elements) {
            System.out.println(element);
        }
    }

    static class MyHandler extends DefaultHandler {
        private List<String> elements;
        private StringBuilder elementContent;

        public java_06226_XMLParser_A07() {
            elements = new ArrayList<>();
            elementContent = new StringBuilder();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            elements.add(qName);
            elementContent.setLength(0);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            elementContent.append(ch, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            elements.add(elementContent.toString());
        }

        public List<String> getElements() {
            return elements;
        }
    }
}