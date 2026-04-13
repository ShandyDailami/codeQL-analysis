import java.util.XML.*;

public class java_20750_XMLParser_A07 {

    public static void main(String[] args) {

        //Create an XMLFactory
        XMLStreamReaderFactory xsrff = XMLStreamReaderFactory.newInstance();

        //Create a Parser
        XMLStreamReader xsr = xsrff.createXMLStreamReader(new File("input.xml"));

        //Parse XML
        while (xsr.hasNext()) {
            int event = xsr.nextEvent();
            switch (event) {
            case XMLStreamConstants.START_ELEMENT:
                System.out.println("Start element: " + xsr.getLocalName());
                break;
            case XMLStreamConstants.END_ELEMENT:
                System.out.println("End element: " + xsr.getLocalName());
                break;
            case XMLStreamConstants.CHARACTERS:
                System.out.print("Character data: " + xsr.getText());
                break;
            }
        }

        //Close the parser
        xsr.close();
    }

}