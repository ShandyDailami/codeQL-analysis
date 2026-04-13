import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XSLTProcessor;
import org.xml.sax.xmlreader.SAXReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class java_19889_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // SAX Parser
            SAXParser saxParser = SAXParserFactory.newInstance().createSAXParser();
            saxParser.setProperty(Constants.PROPERTY_NAME_IGNORE_COMMENTS, true);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("data.xml"), myHandler);
            List<Element> elements = myHandler.getElements();

            // Print the elements
            for (Element element : elements) {
                System.out.println(element.getName() + " : " + element.getValue());
            }

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private List<Element> elements;
        private Element currentElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            elements.add(currentElement = new Element(localName));
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            currentElement.addValue(new String(ch, start, length));
        }

        public List<Element> getElements() {
            return elements;
        }
    }
}