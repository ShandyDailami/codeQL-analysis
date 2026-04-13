import java.util.List;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLEventReader;

public class java_11734_XMLParser_A08 {
    public static class MyHandler extends DefaultHandler {
        boolean isStartElement = false;
        List<String> elementList;

        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            isStartElement = true;
            elementList = null;
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            isStartElement = false;
            if (elementList != null) {
                elementList.add(qName);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (isStartElement) {
                String str = new String(ch, start, length);
                if (elementList != null) {
                    elementList.add(str);
                }
            }
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        String xml = "<root><element>content</element></root>";

        XMLParser parser = XMLReader.newSAXParser(new InputSource(new StringReader(xml)));
        MyHandler handler = new MyHandler();
        parser.setContentHandler(handler);
        parser.parse(new InputSource(new StringReader(xml)));

        for (String element : handler.elementList) {
            System.out.println(element);
        }
    }
}