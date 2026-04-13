import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class java_28724_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFilePath = "src/main/resources/example.xml";  // your xml file path
        readXMLFile(xmlFilePath);
    }

    public static void readXMLFile(String xmlFilePath) {
        try (XMLStreamReader reader = new XMLStreamReader(new FileReader(xmlFilePath))) {
            StringBuilder text = new StringBuilder();
            String name;

            while (reader.hasNext()) {
                name = reader.getName();
                switch (reader.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        text.append("<");
                        text.append(name);
                        text.append(">");
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        text.append(reader.getText());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        text.append("</");
                        text.append(name);
                        text.append(">");
                        break;
                }
                System.out.println(text);
                text.setLength(0);  // reset text
            }
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }
}