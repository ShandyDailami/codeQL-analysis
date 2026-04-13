import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_16755_XMLParser_A03 {

    public static boolean hasCorrectRoot(XMLStreamReader reader, String rootName) throws XMLStreamException {
        if (reader.getLocalName().equals(rootName)) {
            return true;
        }
        switch (reader.getEventType()) {
            case XMLStreamConstants.START_ELEMENT:
                return hasCorrectRoot(reader.nextElement(), rootName);
            case XMLStreamConstants.END_ELEMENT:
                if (reader.getLocalName().equals(rootName)) {
                    return true;
                }
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            File file = new File("sample.xml");
            InputStream inputStream = new FileInputStream(file);
            XMLStreamReader reader = XMLStreamConstants.createXMLStreamReaderFactory().createXMLStreamReader(inputStream);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the root element name:");
            String rootName = scanner.nextLine();

            boolean isCorrectRoot = hasCorrectRoot(reader, rootName);
            if (isCorrectRoot) {
                System.out.println("The document is valid with the root element " + rootName);
            } else {
                System.out.println("The document is NOT valid with the root element " + rootName);
            }

            scanner.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}