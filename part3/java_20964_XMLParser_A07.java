import javax.xml.crypto.Data;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class java_20964_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            XMLStreamReader reader = createXMLStreamReader();
            XMLEventFactory eventFactory = XMLEventFactory.getInstance();

            int event = reader.getEventType();
            while (event != XMLStreamReader.END_DOCUMENT) {
                switch (event) {
                    case XMLStreamReader.START_ELEMENT:
                        // Handle start of an element here
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        // Handle end of an element here
                        break;
                    case XMLStreamReader.CHARACTERS:
                        // Handle character data here
                        break;
                    default:
                        break;
                }
                event = reader.nextEvent();
            }

            reader.close();
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static XMLStreamReader createXMLStreamReader() throws FileNotFoundException {
        return new XMLStreamReader(new FileInputStream("path_to_your_xml_file.xml"));
    }
}