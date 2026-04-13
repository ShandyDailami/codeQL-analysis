import java.io.File;
import java.io.IOException;

public class java_13880_XMLParser_A01 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        try {
            parseFile(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void parseFile(File inputFile) throws IOException {
        FileUtils.readFileToString(inputFile, "UTF-8");
        System.out.println("Parsing the XML file...");

        XMLStreamConstants type;
        String elementName;

        // Start reading the XML file
        XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(inputFile);

        while (reader.hasNext()) {
            type = reader.next();

            switch (type) {
                case START_DOCUMENT:
                    System.out.println("Start of XML document.");
                    break;

                case END_DOCUMENT:
                    System.out.println("End of XML document.");
                    break;

                case START_ELEMENT:
                    elementName = reader.getLocalName();
                    System.out.print("Start of element: " + elementName);
                    break;

                case END_ELEMENT:
                    elementName = reader.getLocalName();
                    System.out.println("End of element: " + elementName);
                    break;

                case CHARACTERS:
                    String characterData = reader.getText();
                    if (characterData.trim().isEmpty()) {
                        System.out.println("Empty element data.");
                    } else {
                        System.out.println("Element data: " + characterData);
                    }
                    break;

                default:
                    break;
            }
        }

        reader.close();
    }
}