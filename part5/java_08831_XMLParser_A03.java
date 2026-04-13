import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_08831_XMLParser_A03 {

    private static Set<String> uniqueElements = new HashSet<>();

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null);
            MyHandler handler = new MyHandler();
            saxParser.setProperty("http://xml.org/sax/properties/current-permitted", "ignore");
            saxParser.setProperty("http://xml.org/sax/properties/load-dtd", "false");
            saxParser.setProperty("http://xml.org/sax/properties/auto-detect-namespaces", "false");
            saxParser.parse(new File("data.xml"), handler);
            System.out.println(uniqueElements.size());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName,
                org.xml.sax.Attributes attributes) throws SAXException {
            uniqueElements.add(qName);
        }
    }
}