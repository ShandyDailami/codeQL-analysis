import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.Element;
import org.jdom2.Text;

import java.io.IOException;

public class java_19485_XMLParser_A08 {
    public static void main(String[] args) {
        SAXBuilder builder = new SAXBuilder();
        try {
            Document document = builder.build("sample.xml");
            Element root = document.getRootElement();
            parseElement(root);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseElement(Element element) {
        System.out.println("Element: " + element.getName());
        for (int i = 0; i < element.getChildSize(); i++) {
            Element child = element.getChild(i);
            if (child instanceof Text) {
                System.out.println("Text: " + child.getValue());
            } else {
                parseElement((Element) child);
            }
        }
    }
}