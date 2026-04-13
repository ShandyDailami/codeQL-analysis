import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class java_31214_XMLParser_A01 {

    public static void parseXmlFile(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            XMLStreamReader reader = XMLStreamConstants.createXMLStreamReader(fis);

            while (reader.hasNext()) {
                int event = reader.next();
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
                        System.out.println("Characters: " + reader.getText());
                        break;
                    default:
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (XMLStreamException e) {
            System.out.println("XML Stream error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        parseXmlFile("sample.xml");
    }
}