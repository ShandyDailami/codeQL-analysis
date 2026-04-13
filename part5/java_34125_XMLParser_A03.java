import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamTokenizer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class java_34125_XMLParser_A03 {

    public static void parse(String filename) {
        XMLStreamReader reader = null;
        XMLStreamTokenizer tokenizer = new XMLStreamTokenizer(new XMLStreamReader(new FileInputStream(filename)));

        try {
            while (tokenizer.nextToken() != XMLStreamTokenizer.END_DOCUMENT) {
                switch (tokenizer.getToken()) {
                    case XMLStreamTokenizer.START_ELEMENT:
                        System.out.println("Start of element: " + tokenizer.getName());
                        break;
                    case XMLStreamTokenizer.CHARREFS:
                        System.out.println("Characters: " + tokenizer.getText());
                        break;
                    case XMLStreamTokenizer.END_ELEMENT:
                        System.out.println("End of element: " + tokenizer.getName());
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        parse("test.xml");
    }
}