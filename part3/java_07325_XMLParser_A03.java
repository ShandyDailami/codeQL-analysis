import java.util.XML;
import java.io.File;
import java.io.IOException;

public class java_07325_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        XML.Parser parser = XML.newParser();

        try {
            for (Object event = parser.next(); event != null; event = parser.next()) {
                if (event instanceof XML.StartElement) {
                    XML.StartElement se = (XML.StartElement) event;
                    System.out.println("Start element: " + se.getName().getLocalPart());
                } else if (event instanceof XML.Attribute) {
                    XML.Attribute att = (XML.Attribute) event;
                    System.out.println("Attribute: " + att.getName().getLocalPart() + "=" + att.getValue());
                } else if (event instanceof XML.EndElement) {
                    XML.EndElement ee = (XML.EndElement) event;
                    System.out.println("End element: " + ee.getName().getLocalPart());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}