import java.io.File;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;

public class java_15378_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            XMLStreamReader reader = createXMLStreamReader();
            int event;
            while (reader.hasNext()) {
                event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.println("Start Element: " + reader.getLocalName());
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        System.out.print("Character Data: " + reader.getText());
                        break;
                    default:
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static XMLStreamReader createXMLStreamReader() {
        return new XMLStreamReader(new File("src/main/resources/example.xml"));
    }
}