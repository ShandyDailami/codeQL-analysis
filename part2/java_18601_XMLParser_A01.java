import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class java_18601_XMLParser_A01 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("sample.xml")) {
            XMLStreamReader reader = XMLStreamReader.newReader(fis);

            String elementName = null;
            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        elementName = reader.getLocalName();
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String elementContent = reader.getText();
                        // Handle character data, this will be different based on your requirements
                        // e.g., if you want to print all element content, print it:
                        System.out.println(elementName + ": " + elementContent);
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        elementName = null;
                        break;
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}