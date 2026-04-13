import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamToken;

public class java_38915_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            parse("src/main/resources/example.xml");
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public static void parse(String filePath) throws XMLStreamException {
        XMLStreamReader reader = XMLStreamConstants.createXMLStreamReader(filePath);
        int event = reader.getEventType();

        while (event != XMLStreamConstants.END_DOCUMENT) {
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    String elementName = reader.getLocalName();
                    System.out.println("Start Element: " + elementName);
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String elementContent = reader.getText();
                    System.out.println("Element Content: " + elementContent);
                    break;
            }
            event = reader.nextEvent();
        }
    }
}