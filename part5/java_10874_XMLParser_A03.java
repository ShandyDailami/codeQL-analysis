import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileReader;
import java.io.FileReader;
import java.io.IOException;

public class java_10874_XMLParser_A03 {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("sample.xml")) {
            XMLStreamReader streamReader = reader.read();
            parse(streamReader);
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void parse(XMLStreamReader streamReader) throws XMLStreamException, IOException {
        String elementName = "";
        while (streamReader.hasNext()) {
            int type = streamReader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = streamReader.getLocalName();
                    System.out.println("Start of element: " + elementName);
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String text = streamReader.getText();
                    System.out.println("Text inside element: " + text);
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = streamReader.getLocalName();
                    System.out.println("End of element: " + elementName);
                    break;
            }
        }
    }
}