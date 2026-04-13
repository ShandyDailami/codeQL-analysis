import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileReader;
import java.io.IOException;

public class java_10293_XMLParser_A03 {

    public static void main(String[] args) {
        try (XMLStreamReader reader = new XMLStreamReader(new FileReader("path_to_your_xml_file.xml"))) {
            String element;
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamReader.START_ELEMENT:
                        element = reader.getLocalName();
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        element = reader.getLocalName();
                        break;
                }
                // perform security-sensitive operations (like injection) here
            }
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }
}