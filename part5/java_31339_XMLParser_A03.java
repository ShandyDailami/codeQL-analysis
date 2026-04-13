import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_31339_XMLParser_A03 {
    private String id;

    public java_31339_XMLParser_A03(String id) {
        this.id = id;
    }

    public void parse(String filePath) throws SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(new File(filePath), new MyHandler(this.id));
    }

    private class MyHandler extends DefaultHandler {
        private String currentId;

        public java_31339_XMLParser_A03(String id) {
            this.currentId = id;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals(this.currentId)) {
                System.out.println("Found element with id: " + qName);
            }
        }
    }

    public static void main(String[] args) throws IOException, SAXException {
        XMLParser parser = new XMLParser("A03_Injection");
        parser.parse("src/main/resources/sample.xml");
    }
}