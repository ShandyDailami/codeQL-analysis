import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class java_13899_XMLParser_A03 {
    public static void main(String[] args) {
        try (XMLStreamReader reader = new XMLStreamReader(new FileReader("src/main/resources/example.xml"))) {
            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLStreamReader.START_DOCUMENT:
                        System.out.println("Start of document");
                        break;
                    case XMLStreamReader.START_ELEMENT:
                        System.out.println("Start of element: " + reader.getLocalName());
                        break;
                    case XMLStreamReader.CHARACTERS:
                        System.out.print(reader.getText());
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        System.out.println("End of element: " + reader.getLocalName());
                        break;
                    case XMLStreamReader.END_DOCUMENT:
                        System.out.println("End of document");
                        break;
                    default:
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (XMLStreamException e) {
            System.out.println("XMLStream error: " + e.getMessage());
        }
    }
}