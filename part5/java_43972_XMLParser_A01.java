import java.util.*;  // Importing List, Queue from collections library for our xml parser and a stack to handle exception cases   

   import javax.xml.parsers.* ;    

public class java_43972_XMLParser_A01 {       

           private static Stack<String> tagsStack = new Stack<>();     

               public void parse(List < String > nodes) throws Exception{             // Main function to call the parsing method         

                     try    /* Try block for exception handling */     {             

                                XMLParser xpp = new XMLParserImpl() ;         // Initializing our xml parser with an instance of implementation class     

                                        List<String> openTags=new ArrayList<>();   // Create a list to store the opening tags that are not matched in closing tag         

                                         String currentTag;             // To hold each element from input XML            while ( xpp.next() != 0 ) {     /* While there is more content*/      if(xpp instanceof StartElement)    {                    try{                /** Inside the start of an xml node */        openTags.add((currentTag=xpp.getCurrentToken().toString()).substring(5));                        tagsStack.push ( currentTag );                     }catch(Exception e){                           // Catch and handle exceptions that occur due to incorrect XML formatting    

                                                                                                        throw new Exception("Error parsing tag: "+ openTags +" in line : "+  xpp .getCurrentLineNumber() ,e);      }}                if (xpp instanceof EndElement) {            /* Inside the end of an xml node */                          try{              /** Inside closing a XML Node*/                         String top = tagsStack.pop();                     // Remove from openTags list 

                                                                                                        assert(top.equals("start"));                                   } catch (Exception e){                            throw new Exception ("Error parsing tag: " +openTags+" in line : " +  xpp .getCurrentLineNumber() ,e);      }}        if (!xpp instanceof Comment) {           /* Inside text of xml node */                        try{                                  //Try block to handle exceptions that occur due access control violation    

                                                                                                        throw new Exception("Access denied for tag:  " + openTags  +" in line : " +  xpp .getCurrentLineNumber() ,e);      }}            }catch (Exception e){                           /* Catch and Handle exception */          System.out.println(x pp._currentToken().toString());                  // Print the current token, if an error occurs it will print out that which tag caused a failure    

                   };  finally {                                                                        /**Finally block to clean up resources when done*/    tagsStack = null;         xpp  =null;}          }       public interface XMLParser{                                           String getCurrentToken() ;      int next(); /* Indicator for end of file */   }}                 //Interface implementation class

public  abstract     class xmlparserImpl implements        XmlParsetor {startElement (String name, Attributes attributes) throws javax.xml .parsers    exceptions .....} }                  ]]> to the code window because it is a multi-line comment in Java syntax[[[