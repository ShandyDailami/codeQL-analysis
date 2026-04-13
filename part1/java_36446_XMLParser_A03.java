import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_36446_XMLParser_A03 {
    public void parse(XMLStreamReader reader) throws XMLStreamException {
        int event;

        while (reader.hasNext()) {
            event = reader.next();

            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    String elementName = reader.getLocalName();
                    System.out.println("Start element: " + elementName);
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = reader.getLocalName();
                    System.out.println("End element: " + elementName);
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText();
                    System.out.println("Text: " + text);
                    break;
            }
       
        }
    }
}