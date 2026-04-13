import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class java_18872_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/example.xml");
        parseXmlFile(xmlFile);
    }

    public static void parseXmlFile(File xmlFile) {
        try (XMLStreamReader reader = new XMLStreamReader(new FileReader(xmlFile))) {
            String elementName = null;

            while (reader.hasNext()) {
                int type = reader.next();

                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        elementName = reader.getLocalName();
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String elementContent = reader.getText();
                        // Security-sensitive operations related to injection
                        // Here, we assume that the injection is happening by replacing all non-alphanumeric characters with '_'
                        // If injection is not needed, remove the line below
                        elementContent = elementContent.replaceAll("[^a-zA-Z0-9]", "_");

                        if ("element".equals(elementName)) {
                            System.out.println("Element content: " + elementContent);
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        elementName = null;
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}