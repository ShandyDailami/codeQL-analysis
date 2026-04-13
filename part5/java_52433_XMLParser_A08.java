import java.io.*;
public class java_52433_XMLParser_A08 {    //defining the main Class as 'XMLparser'    
private String xmlFile;          //declaring a member variable for filename 
static boolean flag = true ;      //creating static Boolean to check integrity failures in our parser program . Set default value of Flag ==true.  
public java_52433_XMLParser_A08(String file) {    //constructor method that takes the File Name as parameter    
xmlFile=file;        //storing passed filename into xmlfiledefining it here is for security reasons only 
}              //end Constructor Method .     
private void parse() throws IOException{   ///method to do parsing of XML document. No Parameters in this method   
BufferedReader read = new BufferedReader(new FileReader (xmlFile));     //create buffering reading a file line by Line  then process that lines using try-catch block...      if you encounter any problem while processing the xml it will be caught here and flag set to false.         } finally {           
if(!flag) printMsg("Error : XML parsing failed due integrity failure.");   //print Error message when error detected .       else 
else     print ("XML Parsing Completed Successfully....");    ///finally block always executed          }}//end of parse method.      private void PrintMesssage(String msg){        System..println (msg); } EndMethod}   //End Main Class}}; end file and here is how it starts with a `