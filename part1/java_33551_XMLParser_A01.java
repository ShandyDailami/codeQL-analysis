import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_33551_XMLParser_A01 {

    public void parse(XMLStreamReader reader) throws XMLStreamException {
        String elementName = null;
        while (reader.hasNext()) {
            int type = reader.nextToken();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = reader.getLocalName();
                    System.out.println("Start element: " + elementName);
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = reader.getLocalName();
                    System.out.println("End element: " + elementName);
                    break;
                default:
                    break;
            }
        }
    }
}