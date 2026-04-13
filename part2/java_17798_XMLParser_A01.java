import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamToken;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class java_17798_XMLParser_A01 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("src/main/resources/data.xml")) {
            XMLStreamReader reader = XMLStreamReader.newReader(fis);

            String elementName = "";
            while (reader.hasNext()) {
                XMLStreamToken token = reader.nextToken();
                if (token.isStartElement()) {
                    elementName = token.asStartElement().getLocalName();
                    System.out.println("Start Element: " + elementName);

                    while (reader.hasNext()) {
                        token = reader.nextToken();
                        if (token.isEndElement()) {
                            break;
                        } else if (token.isAttributes()) {
                            System.out.print("Attribute: ");
                            while (reader.hasNext()) {
                                token = reader.nextToken();
                                if (token.isEndElement()) {
                                    break;
                                }
                                System.out.print(token.asEndElement().getLocalName() + "=" + token.getValue() + " ");
                            }
                            System.out.println("End Element: " + elementName);
                        }
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}