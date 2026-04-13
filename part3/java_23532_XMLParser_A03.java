import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_23532_XMLParser_A03 {

    public static void parse(XMLStreamReader reader) throws XMLStreamException {
        String elementName = null;

        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_DOCUMENT:
                    System.out.println("Start of document");
                    break;
                case XMLStreamConstants.START_ELEMENT:
                    elementName = reader.getLocalName();
                    System.out.println("Start of element: " + elementName);
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String character = reader.getText();
                    System.out.println("Character: " + character);
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    System.out.println("End of element: " + elementName);
                    break;
            }
        }
    }

    public static void main(String[] args) throws XMLStreamException {
        XMLStreamReader reader = XMLParserUtils.createXMLStreamReader();
        parse(reader);
    }
}