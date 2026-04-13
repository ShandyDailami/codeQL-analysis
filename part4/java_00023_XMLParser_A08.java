import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamToken;

public class java_00023_XMLParser_A08 {
    public static void parse(XMLStreamReader reader) throws XMLStreamException {
        XMLStreamToken token;

        while (reader.hasNext()) {
            token = reader.next();

            switch (token.getType()) {
                case XMLStreamConstants.START_ELEMENT:
                    token = reader.next();
                    switch (token.getType()) {
                        case XMLStreamConstants.START_ELEMENT:
                            System.out.println("Start of child element " + reader.getLocalName());
                            break;
                        case XMLStreamConstants.END_ELEMENT:
                            System.out.println("End of element " + reader.getLocalName());
                            break;
                        default:
                            System.out.println("Unexpected element " + reader.getLocalName());
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    System.out.println("End of element " + reader.getLocalName());
                    break;
                default:
                    System.out.println("Unexpected element " + reader.getLocalName());
                    break;
            }
        }
    }

    public static void main(String[] args) throws XMLStreamException {
        XMLStreamReader reader = XMLParserUtil.createXMLStreamReader(args[0]);

        parse(reader);
    }
}

class XMLParserUtil {
    static XMLStreamReader createXMLStreamReader(String xmlFilePath) {
        try {
            return XMLParserUtil.createXMLStreamReader(new FileInputStream(xmlFilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    static XMLStreamReader createXMLStreamReader(InputStream inputStream) {
        return XMLStreamConfiguration.newInstance().createXMLStreamReader(inputStream);
    }
}