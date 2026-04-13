import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class java_12662_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFile = "path_to_your_xml_file";
        parseXMLFile(xmlFile);
    }

    public static void parseXMLFile(String xmlFile) {
        try (FileInputStream fis = new FileInputStream(xmlFile)) {
            XMLStreamReader reader = XMLStreamReader.newReader(fis);

            String elementName = null;
            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        elementName = reader.getLocalName();
                        System.out.println("Start of element: " + elementName);
                        break;
                    case XMLStreamConstants.COMMENT:
                        System.out.println("Comment: " + reader.getCharacterEncoding() + " " + reader.getText());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        System.out.println("End of element: " + elementName);
                        break;
                    default:
                        break;
                }
            }

            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}