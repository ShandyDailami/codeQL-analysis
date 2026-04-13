import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_41925_XMLParser_A03 {

    public static void main(String[] args) {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        Handler handler = new Handler();
        reader.setContentHandler(handler);

        try {
            reader.parse("input.xml"); // parse your file here
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    static class Handler extends DefaultHandler {

        private boolean inElement = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            System.out.println("Start element: " + qName);
            inElement = true;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
            inElement = false;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (inElement) {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        }
    }
}