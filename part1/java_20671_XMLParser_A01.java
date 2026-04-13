import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class java_20671_XMLParser_A01 {

    public static void main(String[] args) {
        parseXMLFile("src/main/resources/data.xml");
    }

    public static void parseXMLFile(String fileName) {
        File file = new File(fileName);
        FileInputStream fis = null;
        XMLStreamReader reader = null;
        try {
            fis = new FileInputStream(file);
            reader = XMLStreamReader.newInstance(fis);

            System.out.println("Parsing XML file: " + fileName);

            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.println("Start Element: " + reader.getLocalName());
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        System.out.print("Characters: " + reader.getText());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        System.out.println("End Element: " + reader.getLocalName());
                        break;
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}