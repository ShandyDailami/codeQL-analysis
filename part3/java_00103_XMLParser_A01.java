import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_00103_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("src/main/resources/example.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private boolean inElement = false;
        private String currentElement = "";
        private String currentElementValue = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            this.inElement = true;
            this.currentElement = qName;
            this.currentElementValue = "";
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            this.inElement = false;
            if (this.currentElement.equals(qName)) {
                System.out.println("Element " + qName + ": " + this.currentElementValue);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (this.inElement) {
                this.currentElementValue = new String(ch, start, length);
            }
        }
    }
}