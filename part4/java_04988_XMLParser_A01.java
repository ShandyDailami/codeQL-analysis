import java.net.URL;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_04988_XMLParser_A01 {
    private List<String> tags;
    private StringBuilder data;

    public java_04988_XMLParser_A01(String tags) {
        this.tags = Arrays.asList(tags.split("\\s+"));
        this.data = new StringBuilder();
    }

    public void parse(String xml) throws JAXBException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler(this.data));
        parser.parse(new StringReader(xml));
    }

    public List<String> getTags() {
        return this.tags;
    }

    public String getData() {
        return this.data.toString();
    }

    private class MyHandler extends DefaultHandler {
        private StringBuilder sb;
        private int depth;

        public java_04988_XMLParser_A01(StringBuilder sb) {
            this.sb = sb;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            depth++;
            sb.append(qName);
            for (String tag : XmlParser.this.tags) {
                sb.append("[@" + tag + "]");
            }
            sb.append(" ");
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            depth--;
            sb.append(qName);
            sb.append(" ");
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (depth > 1) {
                sb.append(new String(ch, start, length));
            }
        }
    }

    public static void main(String[] args) throws JAXBException, SAXException {
        String xml = "<document><title>Garlic bread</title></document>";
        XmlParser parser = new XmlParser("title");
        parser.parse(xml);
        System.out.println(parser.getTags());
        System.out.println(parser.getData());
    }
}