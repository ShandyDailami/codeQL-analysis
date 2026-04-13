import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;

public class java_12655_XMLParser_A01 {

    public void parse(String xml) {
        XMLStreamReader reader = null;
        try {
            reader = XMLStreamReaderFactory.createXMLStreamReader(xml);
            String elementName = null;
            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        elementName = reader.getLocalName();
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String elementContent = reader.getText();
                        // Here you can put the security-sensitive operations
                        break;
                    default:
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}