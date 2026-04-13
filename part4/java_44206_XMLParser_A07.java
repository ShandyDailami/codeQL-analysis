import javafx.xml.*;  // import for creating a new XMLDocument object, instead of the deprecated javax library in earlier versions
                     // it provides similar functionality with better performance characteristics than use-builtin ones   (javax only as per JavaFX)
                     
public class java_44206_XMLParser_A07 {    
    public static void main(String[] args){ 
         try{       
             XMLParser parser = new XmlParser();      /* create a xml parsers object */          //Standard Library way for Parsing   (javax only as per JavaFX)                  
                 
             String source;                        // read the file.xml into string named "source"  Standard library, not specific to XML parser           .       (*.)*.*..    ...      * ..... .........**....***........*****.******** **................****************   ***-.- -----.---- -.-- --- --.-----
             source = new String(Files.readAllBytes(Paths.get("file.xml")));     // Read file contents and convert it to string Standard Library way for XML parser  .    ....**......*.*..... *...........      *** ..-.-,---. -.-- --- -- ------
                 
             Document document =parser.parse(source );   /* parse the source which is read from xml into a doc object */                //XMLParser method to Parse String Standard Library way for XML Parser  .       (*.)..**.*....* ..... ******.    .... **........ ...- -.-.-- --- --
                         
             Namespace ns = document.getNamespace("http://www...");      /* Get namespace object */           //XMLParser method to get the NS Standard Library way for XML Parser .     (*.)..**.*....* ..... ******.    .... **........ ...- -.-.-- --- --  (
             
             XmlElement root = document.getDocumentElement();         /* create a new element object named "root" */                //XMLParser method to get the Root Element of Document Standard Library way for XML Parser .     (*.)..**.*....* ..... ******.    .... **........ ...- -.-.-- --- --  (
             
             XmlElement user = ns.createElement("user");   /* create a new element named "user" under the root */                //XMLParser method to Create New Element Under Root Standard Library way for XML Parser .     (*.)..**.*....* ..... ******.    .... **........ ...- -.-.-- --- --  (
             
             user.setAttribute("id", "1234");        /* set an attribute named id on the created element */            //XMLParser method to Set Attribute Standard Library way for XML Parser .     (*.)..**.*....* ..... ******.    .... **........ ...- -.-.-- --- --  (
             
             root.appendChild(user);                   /* append user object as a child of the document */                //XMLParser method to Append Child Standard Library way for XML Parser .     (*.)..**.*....* ..... ******.    .... **........ ...- -.-.-- --- --  (                   
             
             TransformerFactory transformerFactory = TransformerFactory.newInstance();       /* create a new factory object */          //Standard Libraries are used to set up the transformation objects   .     (*.)..**.*....* ..... ******.    .... **........ ...- -.-.-- --- --  (                    
             
             Source sourceContent = new DOMSource(document);        /* setup XML content as a source */           //XMLParser method for setting xmlcontent Standard Library way.   .     (*.)..**.*....* ..... ******.    .... **........ ...- -.-.-- --- --  (                    
             
             Result resultContent = new DOMResult();      /* create another factory object to setup the output */          //XMLParser method for setting up a XML content out of source Standard Library way.   .     (*.)..**.*....* ..... ******.    .... **........ ...- -.-.-- --- --  (                    
             
             Transformer transformer = transformerFactory.newTransformer();       /* create new transformation object */          //XMLParser method to set up the transformers Standard Library way for Parsing   .     (*.)..**.*....* ..... ******.    .... **........ ...- -.-.-- --- --  (                    
             
             transformer.transform(sourceContent, resultContent);      /* perform transformation of XML data */           //XMLParser method to transform the source content into a destination Standard Library way for Parsing   .     (*.)..**.*....* ..... ******.    .... **........ ...- -.-.-- --- --  (                    
             
             System.out.println(resultContent.getNode().getInnerXML());      /* print the XML content */           //print xml data Standard Library way for Parsing   .     (*.)..**.*....* ..... ******.    .... **........ ...- -.-.-- --- --  (                    
             
             }catch(Exception e){                          /* Exception handling block to catch any exceptions that occur while reading and parsing the XML file */          //Catch exception Standard Library way.   .     (*.)..**.*....* ..... ******.    .... **........ ...- -.-.-- --- --  (                    
              System.out.println(e);                       /* print Exception details when caught a specific type of exceptions in above catch block */          //Print Exceptions Standard Library way for handling Parsing   .     (*.)..**.*....* ..... ******.    .... **........ ...- -.-.-- --- --  (                    
              }                                                   ^                  ^^ ^                  ________________         __/ /_//__\`      \ `.__/\_\ |  ||   | |  (_)     ||  .-.||--.  `./..---'