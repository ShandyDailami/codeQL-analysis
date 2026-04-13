import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.output.*;

public class java_40280_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Load XML document
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new StringInputSource(new String("<root><child1>Content1</child1><child2>Content2</child2></root>"));
            Document doc = builder.build(is);

            // Write XML document to console
            Marshaller marshaller = JDOMFactory.makeMarshaller(doc);
            marshaller.setProperty(Marshaller.JDOM_FORMAT, Boolean.TRUE);
            marshaller.marshal(doc, System.out);

            // Add integrity failure
            Element root = doc.getRootElement();
            root.addChild("failingChild", "Failing content");
            marshaller.marshal(doc, System.out);

        } catch (JDOMException e) {
            e.printStackTrace();
        }
    }
}