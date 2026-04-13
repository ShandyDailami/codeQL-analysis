import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class java_20672_XMLParser_A03 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("input.xml")) {
            XMLStreamReader reader = XMLStreamConstants.createXMLEventReader(fis);
            handleXML(reader);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found. Please check the file name and location.");
        } catch (XMLStreamException e) {
            System.out.println("Error reading XML file. Please check the file format.");
        }
    }

    private static void handleXML(XMLStreamReader reader) throws XMLStreamException {
        String elementName;
        while (reader.hasNext()) {
            int eventType = reader.nextEvent();
            switch (eventType) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = reader.getLocalName();
                    System.out.println("Start of element: " + elementName);
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = reader.getLocalName();
                    System.out.println("End of element: " + elementName);
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String character = reader.getText();
                    System.out.println("Character data: " + character);
                    break;
                default:
                    break;
            }
        }
    }
}