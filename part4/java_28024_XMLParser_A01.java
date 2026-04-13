import java.io.StringReader;
import java.util.Iterator;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_28024_XMLParser_A01 {
    public void parse(String xmlContent) throws XMLStreamException {
        XMLStreamReader reader = new XMLStreamReader(new StringReader(xmlContent));

        // Start parsing
        int event = reader.getEventType();

        while (event != XMLStreamConstants.END_DOCUMENT) {
            switch (event) {
                case XMLStreamConstants.START_DOCUMENT:
                    System.out.println("Start of document");
                    break;
                case XMLStreamConstants.START_ELEMENT:
                    System.out.println("Start of element: " + reader.getLocalName());
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    System.out.println("End of element: " + reader.getLocalName());
                    break;
                case XMLStreamConstants.CHARACTERS:
                    System.out.print(reader.getText());
                    break;
                default:
                    break;
            }
            event = reader.nextEvent();
        }
        System.out.println("End of document");
    }
}