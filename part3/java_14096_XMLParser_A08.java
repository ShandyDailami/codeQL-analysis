import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_14096_XMLParser_A08 {

    public void parse(XMLStreamReader reader) throws XMLStreamException {
        String elementName = null;

        while (reader.hasNext()) {
            int event = reader.next();

            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = reader.getLocalName();
                    System.out.println("Start of element: " + elementName);
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String content = reader.getText();
                    System.out.println("Content inside element: " + content);
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    System.out.println("End of element: " + elementName);
                    break;
            }
        }
    }
}