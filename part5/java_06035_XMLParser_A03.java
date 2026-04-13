import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_06035_XMLParser_A03 {
    private List<String> names = new ArrayList<>();

    public List<String> getNames() {
        return names;
    }

    public void parse(String file) throws SAXException {
        MyHandler handler = new MyHandler();
        XMLParser.parse(file, handler);
        names = handler.getNames();
    }

    private static class MyHandler extends DefaultHandler {
        private List<String> names = new ArrayList<>();
        private String currentName;
        private boolean nameFlag = false;

        public List<String> getNames() {
            return names;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentName = qName;
            nameFlag = true;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (currentName != null && currentName.equals(qName)) {
                names.add(localName);
                currentName = null;
            }
        }
    }
}