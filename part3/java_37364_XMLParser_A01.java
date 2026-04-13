import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;

public class java_37364_XMLParser_A01 {
    public void parse(String xmlFilePath) throws XMLStreamException {
        XMLStreamReader reader = XMLStreamReader.createNonValidatingReader(System.out);
        
        int event = reader.getEventType();
        String elementName = "";
        String elementContent = "";

        while (reader.hasNext()) {
            event = reader.nextEvent();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = reader.getLocalName();
                    break;
                case XMLStreamConstants.CHARACTERS:
                    elementContent = reader.getText();
                    System.out.println("Start Element: " + elementName);
                    System.out.println("Element Content: " + elementContent);
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    System.out.println("End Element: " + elementName);
                    break;
            }
        }
    }
}