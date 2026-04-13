import javafx.application.Application;  // Import the Application class java_44809_XMLParser_A01 overwrite start() method in a new MyApp Class extending from this application  

    import javax.xml.parsers.*;        // Required for XMLParser, DOM (Document Object Model) & SAX methods are used to parse xml files using Java libraries         

import org.w3c.dom.*;                   // Import the necessary classes  - Document and Element                    

public class MyApp extends Application {   // Create a new App Class extending from application   

@Override                             public void start(Stage primarystage) throws Exception{        try (FileInputStream fis =new FileInputStream("sample-file.svg"))       InputSource is= new InputSource(fis);      XMLParser xp=XMLEventFactory.createDOMParser();         //Parsing the input file to a Document object 

Document doc =  xp .parse(is );                  DocTypeDecl dt =xp.getDocTypeDecl();                    System.out.println("Root Element Name: "+doc.getElementsByTagName (0).getNodeName());                   }catch (Exception e){e.printStackTrace()}
     public static void main(String[] args) {  Application.launch((args));   }}