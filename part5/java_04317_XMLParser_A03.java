import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_04317_XMLParser_A03 {
    private List<String> names = new ArrayList<>();

    public List<String> getNames() {
        return names;
    }

    public void parse(String xml) {
        MyHandler handler = new MyHandler();
        javax.xml.parsers.SAXParserFactory saxParserFactory = javax.xml.parsers.SAXParserFactory.newInstance();
        try {
            javax.xml.parsers.SAXParser saxParser = saxParserFactory.newSAXParser(null, handler);
            saxParser.parse(xml.getBytes("UTF-8"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class MyHandler extends DefaultHandler {
        private StringBuilder content = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (content.length() > 0) {
                names.add(content.toString());
                content.setLength(0);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            content.append(new String(ch, start, length));
        }
    }
}