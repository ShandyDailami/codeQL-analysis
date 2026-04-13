import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_21516_XMLParser_A01 extends DefaultHandler {
    private boolean bItem = false;
    private String sItemName = null;
    private String sItemPrice = null;

    private List<Item> itemList = new ArrayList<>();

    public class Item {
        public String id, name, price;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("item")) {
            bItem = true;
            Item item = new Item();
            itemList.add(item);
        } else if (bItem) {
            if (localName.equalsIgnoreCase("name")) {
                sItemName = attributes.getValue("name");
            } else if (localName.equalsIgnoreCase("price")) {
                sItemPrice = attributes.getValue("price");
            }
            bItem = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("item")) {
            Item item = new Item();
            item.name = sItemName;
            item.price = sItemPrice;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bItem) {
            sItemName = new String(ch, start, length);
        }
    }
}