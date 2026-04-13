import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_22837_XMLParser_A08 {
    public static void main(String[] args) {
        String xml = "<person>\n" +
                "  <name>John Doe</name>\n" +
                "  <age>30</age>\n" +
                "  <city>New York</city>\n" +
                "</person>";
        
        XMLReader reader = SAXParser.newInstance().createXMLReader();
        DefaultHandler handler = new DefaultHandler();
        reader.setContentHandler(handler);
        reader.parse(new InputSource(new StringReader(xml)));
   
        // Output parsed data
        System.out.println("Name: " + handler.getCharacterDataHandler().getCurrentElement().getTagName());
        System.out.println("Age: " + handler.getCharacterDataHandler().getElementByTagName("age").getCharacterData().getData());
        System.out.println("City: " + handler.getCharacterDataHandler().getElementByTagName("city").getCharacterData().getData());
    }
}