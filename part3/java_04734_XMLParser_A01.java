import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLReader;
import javax.xml.stream.XMLStreamConstants;

public class java_04734_XMLParser_A01 {
    private XMLStreamReader reader;

    public java_04734_XMLParser_A01(XMLStreamReader reader) {
        this.reader = reader;
    }

    public void parse() throws XMLStreamException {
        String elementName = null;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = reader.getLocalName();
                    break;
                case XMLStreamConstants.COMMENT:
                    System.out.println("Comment: " + reader.getComment());
                    break;
                case XMLStreamConstants.DOCUMENT:
                    System.out.println("Document: " + reader.getBaseURI());
                    break;
                case XMLStreamConstants.DEFAULT_COMMENT:
                    System.out.println("Default Comment: " + reader.getText());
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    System.out.println("End Element: " + elementName);
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) throws XMLStreamException {
        XMLStreamReader reader = XMLParserUtil.createXMLStreamReader();
        XMLParser parser = new XMLParser(reader);
        parser.parse();
    }
}

class XMLParserUtil {
    static XMLStreamReader createXMLStreamReader() throws XMLStreamException {
        return XMLReaderFactory.createXMLStreamReader(
                "src/main/resources/accesscontrol.xml");
    }
}