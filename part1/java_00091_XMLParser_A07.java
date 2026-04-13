public class java_00091_XMLParser_A07 {
    // method to parse XML elements
    public void parse(String xml) {
        // Here you could use a library like XmlBeans or JDOM for parsing XML
        // but for this example, we'll implement a custom parsing method

        // split the XML string into lines
        String[] lines = xml.split("\n");

        // initialize variables
        boolean inElement = false;
        StringBuilder currentElement = new StringBuilder();

        // loop through the lines
        for (String line : lines) {
            // skip comments
            if (line.startsWith("<!--") && line.endsWith("-->")) {
                continue;
            }

            // check for start of an element
            if (line.startsWith("<")) {
                // remove the start tag
                line = line.substring(1);

                // remove closing tag
                int endTag = line.indexOf('>');
                line = line.substring(0, endTag);

                // store element name
                currentElement.append(line);

                // set flag to true
                inElement = true;

                // continue loop
                continue;
            }

            // check for end of an element
            if (line.startsWith("</")) {
                // remove the end tag
                line = line.substring(2);

                // set flag to false
                inElement = false;

                // print element
                System.out.println("Element: " + currentElement);

                // reset current element
                currentElement.setLength(0);

                // continue loop
                continue;
            }

            // if in element, add line to current element
            if (inElement) {
                currentElement.append(line);
            }
        }
    }
}