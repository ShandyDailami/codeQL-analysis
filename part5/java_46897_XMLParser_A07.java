import javafx.application.*;

import org.xml.sax.*;

import javax.xml.parsers.*;

public class java_46897_XMLParser_A07 extends Application {    

    public static void main(String args[]){        

        launch(args);      }  

@Override 

public void start(Stage stage) throws Exception{      

XMLReader reader=null;          try {             //create a new SAXParser factory.            XMLReader obj = ...//initialize the object using createSAXParser() method    read();     case1: Start Element -> Display tag name and value of element for which it was found, if no attributes then skip to next event handler; 

case2 : End elements— display endElement with full path from root document.          } catch (ParsingException e) {             System.out.println(e);     }}   finally{         reader.close();    //end Document and close the connection, if successful then return true otherwise false; 

}}}