import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;

public class java_21659_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("*");
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println(nodeList.item(i).getNodeName());
           
                if(nodeList.item(i).getNodeType() == Node.ELEMENT_NODE){
                    XMLSerializer serializer = new XMLSerializer();
                    serializer.outputContent = new StringWriter();
                    OutputFormat format = new OutputFormat("", true, false, "UTF-8", true);
                    serializer.setup(format, null);
                    serializer.startDocument("UTF-8", true);
                    serializer.startElement("", nodeList.item(i).getNodeName(), "");
                    serializer.text(nodeList.item(i).getTextContent());
                    serializer.endElement("", nodeList.item(i).getNodeName(), "");
                    serializer.endDocument();
                    System.out.println(serializer.getOutput().toString());
                }
            }
            builder = null;
            factory = null;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}