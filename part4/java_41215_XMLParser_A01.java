import java.io.FileInputStream;
import java.io.InputStream;
import java.xml.XMLStreamException;
import java.xml.stream.XMLStreamReader;

public class java_41215_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            InputStream input = new FileInputStream("sample.xml");
            XMLStreamReader streamReader = XMLStreamReader.newReader(input);

            while(streamReader.hasNext()){
                int type = streamReader.next();

                switch(type){
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.println("Start Element : "+streamReader.getLocalName());
                        break;
                    case XMLStreamConstants.COMMENT:
                        System.out.println("Comment: " + streamReader.getComment());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        System.out.println("End Element: "+streamReader.getLocalName());
                        break;
                    default:
                        break;
                }
            }

            streamReader.close();

        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}