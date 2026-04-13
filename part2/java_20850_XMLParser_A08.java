import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class java_20850_XMLParser_A08 {
    public static void main(String[] args) {
        try (XMLStreamReader reader = new XMLStreamReader(new FileReader(new File("data.xml")))) {
            String element;
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamReader.START_ELEMENT:
                        element = reader.getLocalName();
                        System.out.println("Found element: " + element);
                        break;
                    default:
                        break;
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}