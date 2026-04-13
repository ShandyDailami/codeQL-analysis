import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamTokenizer;
import java.io.FileReader;
import java.io.IOException;

public class java_07036_XMLParser_A01 {

    public void parse(String filePath) {
        XMLStreamReader reader = null;
        XMLStreamTokenizer tokenizer = null;

        try {
            reader = new XMLStreamReader(new FileReader(filePath));
            tokenizer = new XMLStreamTokenizer(reader);

            while (tokenizer.hasNext()) {
                int event = tokenizer.nextToken();

                if (event == XMLStreamTokenizer.START_DOCUMENT) {
                    System.out.println("Start of document");
                } else if (event == XMLStreamTokenizer.START_ELEMENT) {
                    String elementName = tokenizer.getLocalName();
                    System.out.println("Start of " + elementName);
                } else if (event == XMLStreamTokenizer.CHARREFS) {
                    System.out.println("Characters: " + tokenizer.getText());
                } else if (event == XMLStreamTokenizer.END_ELEMENT) {
                    System.out.println("End of " + tokenizer.getLocalName());
                } else if (event == XMLStreamTokenizer.COMMENT) {
                    System.out.println("Comment: " + tokenizer.getComment());
                }
            }

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}