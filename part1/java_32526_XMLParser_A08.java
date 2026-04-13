import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32526_XMLParser_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name:");
        String fileName = scanner.next();
        scanner.close();

        try (FileInputStream fis = new FileInputStream(fileName)) {
            XMLStreamReader reader = XMLStreamReader.newReader(fis);
            parse(reader);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (XMLStreamException e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
        }
    }

    public static void parse(XMLStreamReader reader) throws XMLStreamException {
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    System.out.print("Start element: " + name);
                    break;

                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText();
                    System.out.print("Text: " + text);
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    System.out.println("End element: " + name);
                    break;

                case XMLStreamConstants.COMMENT:
                    String comment = reader.getComment();
                    System.out.println("Comment: " + comment);
                    break;

                case XMLStreamConstants.DOCUMENT:
                    System.out.println("Document root element: " + reader.getLocalName());
                    break;
            }
        }
    }
}