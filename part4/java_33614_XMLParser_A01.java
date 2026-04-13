import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamTokenizer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class java_33614_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            FileInputStream fis = new FileInputStream(inputFile);
            XMLStreamReader reader = new XMLStreamReader(fis);
            XMLStreamTokenizer tokenizer = new XMLStreamTokenizer(reader);

            String elementName = null;
            while (tokenizer.nextToken() != XMLStreamTokenizer.END_DOCUMENT) {
                switch (tokenizer.getTokenId()) {
                    case XMLStreamTokenizer.START_ELEMENT:
                        elementName = tokenizer.getLocalName();
                        break;
                    case XMLStreamTokenizer.CHARREFS:
                        if (tokenizer.getText().equals("security-sensitive-operation")) {
                            System.out.println("Attempted security sensitive operation on element: " + elementName);
                        }
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