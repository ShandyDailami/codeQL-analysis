import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class java_17773_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFile = "path/to/your/xml/file.xml"; // replace with your xml file path
        parseXML(xmlFile);
    }

    public static void parseXML(String xmlFile) {
        XMLStreamReader reader = null;
        try {
            reader = XMLStreamReader.newInstance(new FileInputStream(xmlFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        int event;
        try {
            while (reader.hasNext()) {
                event = reader.nextEvent();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.println("Start Element: " + reader.getLocalName());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        System.out.println("End Element: " + reader.getLocalName());
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        System.out.print("Character Data: " + reader.getText());
                        break;
                    default:
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}