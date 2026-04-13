import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class java_28898_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            XMLStreamReader reader = createXMLStreamReader();
            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        String elementName = reader.getLocalName();
                        System.out.println("Start Element: " + elementName);
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String elementContent = reader.getText();
                        System.out.println("Element Content: " + elementContent);
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        elementName = reader.getLocalName();
                        System.out.println("End Element: " + elementName);
                        break;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static XMLStreamReader createXMLStreamReader() throws FileNotFoundException {
        return new XMLStreamReader(new FileInputStream("src/main/resources/example.xml"));
    }
}