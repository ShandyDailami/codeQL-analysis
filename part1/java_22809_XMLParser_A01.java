import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.InputStream;

public class java_22809_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("notvalid.xml"); // This file does not exist
            XMLStreamReader reader = XMLStreamReader.newReader(inputStream);
            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.println("Start element: " + reader.getLocalName());
                        break;
                    case XMLStreamConstants.COMMENT:
                        System.out.println("Comment: " + reader.getComment());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        System.out.println("End element: " + reader.getLocalName());
                        break;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (XMLStreamException e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }
}