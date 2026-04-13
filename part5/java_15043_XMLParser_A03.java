import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_15043_XMLParser_A03 {

    public void parseXML(XMLStreamReader reader) throws XMLStreamException {
        int event;
        while (reader.hasNext()) {
            event = reader.nextEvent();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    String elementName = reader.getLocalName();
                    System.out.println("Start of element: " + elementName);
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String elementContent = reader.getText();
                    System.out.println("Content of element: " + elementContent);
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = reader.getLocalName();
                    System.out.println("End of element: " + elementName);
                    break;
                default:
                    break;
            }
        }
    }
}