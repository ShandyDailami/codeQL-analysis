import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class java_02504_XMLParser_A01 {

    public void parseXML(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            XMLStreamReader reader = XMLStreamReader.newInstance(fis);

            // Read and handle XML tags
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
                        System.out.println("Text: " + reader.getText());
                        break;
                    default:
                        break;
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}