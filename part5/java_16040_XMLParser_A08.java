import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_16040_XMLParser_A08 extends DefaultHandler {
    private StringBuilder data;

    public java_16040_XMLParser_A08() {
        this.data = new StringBuilder();
    }

    public void parse(String filename) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(this);
            reader.setErrorHandler(this);
            reader.parse(filename);
        } catch (SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        data.append("<").append(qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            data.append(" ").append(attributes.getQName(i)).append("=").append(attributes.getValue(i));
        }
        data.append(">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        data.append("</").append(qName).append(">");
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        data.append(new String(ch, start, length));
    }

    @Override
    public void error(SAXException e) {
        System.out.println("SAXException: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXException e) {
        System.out.println("Fatal SAXException: " + e.getMessage());
    }

    @Override
    public void warning(SAXException e) {
        System.out.println("Warning: " + e.getMessage());
    }

    public String getData() {
        return data.toString();
    }

    public static void main(String[] args) {
        XMLParserExample parser = new XMLParserExample();
        parser.parse("sample.xml");
        System.out.println(parser.getData());
    }
}