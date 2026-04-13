import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class java_26473_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            XMLStreamReader reader = createXMLStreamReader();
            while (reader.hasNext()){
                int type = reader.next();
                switch (type){
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.println("Start element: " + reader.getLocalName());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        System.out.println("End element: " + reader.getLocalName());
                        break;
                    case XMLStreamConstants.CHARS:
                        System.out.println("Characters: " + reader.getText());
                        break;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static XMLStreamReader createXMLStreamReader() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("src/main/resources/example.xml");
        return XMLStreamReader.newInstance(fis);
    }
}

class AuthFailureException extends Exception {
    public java_26473_XMLParser_A07(String message) {
        super(message);
    }
}