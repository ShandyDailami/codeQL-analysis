import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_24395_XMLParser_A03 {
    private List<String> attributeNames = new ArrayList<>();
    private List<String> elementNames = new ArrayList<>();

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("src/data.xml"), myHandler);

            System.out.println("Element names: " + myHandler.getAllElementNames());
            System.out.println("Attribute names: " + myHandler.getAllAttributeNames());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class MyHandler extends DefaultHandler {
        private List<String> elementStack = new ArrayList<>();
        private List<String> attributeStack = new ArrayList<>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            String elementName = localName;
            attributeNames.addAll(attributes.getNames());
            elementNames.add(elementName);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < elementNames.size(); i++) {
                sb.append(elementNames.get(i));
                if (i < attributeNames.size()) {
                    sb.append("[");
                    sb.append(attributeNames.get(i));
                    sb.append("]");
                }
                sb.append(", ");
            }
            elementNames.clear();
            attributeNames.clear();
        }

        public List<String> getAllElementNames() {
            return elementNames;
        }

        public List<String> getAllAttributeNames() {
            return attributeNames;
        }
    }
}