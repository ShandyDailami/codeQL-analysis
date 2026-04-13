import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_19706_XMLParser_A03 extends DefaultHandler {
    private StringBuilder currentElementContent;
    private List<String> extractedElements;

    public java_19706_XMLParser_A03() {
        this.extractedElements = new ArrayList<>();
        this.currentElementContent = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.currentElementContent.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.extractedElements.add(this.currentElementContent.toString().trim());
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        this.currentElementContent.append(ch, start, length);
    }

    public static void main(String[] args) throws Exception {
        String xml = "<data><person id='1'><name>John Doe</name></person><person id='2'><name>Jane Doe</name></person></data>";
        XmlSAXHandler handler = new XmlSAXHandler();
        javax.xml.parsers.SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        javax.xml.parsers.SAXParser saxParser = saxParserFactory.newSAXParser(null);
        saxParser.parse(new StringReader(xml), handler);
        for (String element : handler.getExtractedElements()) {
            System.out.println(element);
        }
    }

    public List<String> getExtractedElements() {
        return this.extractedElements;
    }
}