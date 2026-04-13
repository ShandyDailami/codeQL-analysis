import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_36418_XMLParser_A03 {

    public static void main(String[] args) {
        String xml = "<notes><note id='1'><to>Alex</to><from>John</from><heading>Reunion</heading><body>See you tomorrow</body></note><note id='2'><to>Alex</to><from>John</from><heading>Business meeting</heading><body>See also tomorrow</body></note></notes>";
        parseNotes(xml);
    }

    public static void parseNotes(String xml) {
        try {
            XMLStreamReader streamReader = new XMLStreamReader(new StringReader(xml));

            List<Note> notes = new ArrayList<>();

            while (streamReader.hasNext()) {
                int type = streamReader.next();

                switch (type) {
                    case XMLStreamReader.START_ELEMENT:
                        String name = streamReader.getLocalName();
                        if (name.equals("note")) {
                            Note note = new Note();
                            parseNote(streamReader, note);
                            notes.add(note);
                        }
                        break;
                }
            }

            streamReader.close();

            // print notes
            for (Note note : notes) {
                System.out.println(note);
            }

        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static void parseNote(XMLStreamReader streamReader, Note note) throws XMLStreamException {
        String elementName;

        while (streamReader.hasNext()) {
            elementName = streamReader.nextName();

            switch (elementName) {
                case "to":
                    note.setTo(streamReader.getElementText());
                    break;
                case "from":
                    note.setFrom(streamReader.getElementText());
                    break;
                case "heading":
                    note.setHeading(streamReader.getElementText());
                    break;
                case "body":
                    note.setBody(streamReader.getElementText());
                    break;
            }
        }
    }
}

class Note {
    private String to;
    private String from;
    private String heading;
    private String body;

    public void setTo(String to) {
        this.to = to;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Note [to=" + to + ", from=" + from + ", heading=" + heading + ", body=" + body + "]";
    }
}