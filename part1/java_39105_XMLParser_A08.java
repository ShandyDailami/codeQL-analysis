import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_39105_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            String fileName = "example.xml"; // Your file name here
            InputStream input = new FileInputStream(fileName);
            XMLStreamReader reader = XMLStreamReader.newReader(input);

            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        String elementName = reader.getLocalName();
                        System.out.println("Start element: " + elementName);
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String character = reader.getText();
                        System.out.println("Character data: " + character);
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        elementName = reader.getLocalName();
                        System.out.println("End element: " + elementName);
                        break;
                }
            }
            reader.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}