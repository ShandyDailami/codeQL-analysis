import java.util.stream.Stream;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_15278_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlString = "<root><element id='1'>Content</element></root>"; // your xml here

        try (Stream<XMLStreamReader> stream = XMLParser.createStream(xmlString)) {
            stream.forEach(SecurityBreachDetector::checkElement);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static void checkElement(XMLStreamReader reader) throws XMLStreamException {
        String elementName = reader.getLocalName();

        if (elementName.equals("element")) {
            if (!reader.getAttributeValue("id").equals("1")) {
                throw new SecurityException("Broken access control detected: element id does not match expected value.");
            }
        }

        if (!reader.isStartElement() && !reader.isEndElement()) {
            reader.next(); // skip everything else
        }
    }
}