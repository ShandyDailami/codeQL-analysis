import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class java_20005_XMLParser_A01 {
    public static void main(String[] args) {
        try (XMLStreamReader reader = new XMLStreamReader(new FileReader(new File("path_to_your_xml_file")))) {
            String name;
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();
                        System.out.println("Start element: " + name);
                        break;
                    case XMLStreamConstants.ATTRIBUTE:
                        name = reader.getLocalName();
                        System.out.println("Attribute: " + name);
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        System.out.print(reader.getText());
                        break;
                }
            }
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }
}