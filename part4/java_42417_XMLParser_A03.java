import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;   // for SAX parsing error handling 

public class java_42417_XMLParser_A03 {   
     public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException{        	      		         	     	 			                 				                					                                                                      }        /*Remove Comment Starts Here*/   //Include the xml file here and pass it into parser.parse() for parsing
    public static void parse(Document document){  printTagsRecursive("",document);}}             private static class TagInfo {            String tagName;              int occurrenceCount=0,maxOccurrence = 1;}   /*Declare a new Class 'Taginfo'*/          //For storing data about each unique xml element.
                                                                                           public java_42417_XMLParser_A03() {}  protected void printTagsRecursive(String indentation, Document document) {         for (int i=0;i<document.getElements().length();++).           TagInfo tag = new TAGINFO(){    setTagName("");      //Initialize the NEW Object
                     }else{             PUT THIS IN THE FOR LOOP HERE}          if(tagOccurrenceMap .containsKey (TAG)){            Occurs at least one time?              int occursAtLeastOnce= tag.getOcurrences()+1;                setTagName       ("");     //Set the NEW Object
                     }else{             SET THIS IF ELSE STATEMENT HERE}           if(occursAtleaSotOne){            addToTotalCount (Occurs at least one time?);    }}  /*Declare a new Class 'taginfo'*/          private void parseDocument() {       //Include the XML file passed into parser.parse(). For parsing