import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class java_21181_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_file.xml");
        parseXMLFile(xmlFile);
    }

    public static void parseXMLFile(File xmlFile) {
        XMLStreamReader reader;
        int event;
        try {
            reader = new XMLStreamReader(new FileReader(xmlFile));
            while (reader.hasNext()) {
                event = reader.next();
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
                        System.out.print("Character data: " + reader.getText());
                        break;
                    case XMLStreamConstants.COMMENT:
                        System.out.println("Comment: " + reader.getComment());
                        break;
                    case XMLStreamConstants.PROCESSING_INSTruction:
                        System.out.println("Processing instruction: " + reader.getTarget());
                        break;
                    default:
                        break;
                }
            }
            reader.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}