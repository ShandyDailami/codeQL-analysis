import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_21588_XMLParser_A08 {

    private static class MyHandler extends DefaultHandler {

        private List<String> elementValues = new ArrayList<>();
        private StringBuilder elementValue = new StringBuilder();
        private boolean isElementValue = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            elementValue.setLength(0);
            isElementValue = true;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isElementValue) {
                elementValue.append(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            elementValues.add(elementValue.toString());
            isElementValue = false;
        }
    }

    public static void main(String[] args) {
        String xml = "<root>" +
                "<element1>Value1</element1>" +
                "<element2>Value2</element2>" +
                "<element3>Value3</element3>" +
                "</root>";

        MyHandler handler = new MyHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(new InputSource(new StringReader(xml)));

            for (String value : handler.elementValues) {
                System.out.println(value);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}