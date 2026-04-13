import java.io.*;   // for FileInputStream & PrintWriter
import javax.xml.parsers.*;    //for XMLParser Interface    
public class java_52684_XMLParser_A01 {     
private static String xmlFilePath;      
 public static void main(String[] args) throws Exception{       
 System.out.println("Enter the path of your .XML file:");         
 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));    
  try {   //Try-catch block for exception handling   
 xmlFilePath=reader.readLine();     
 FileInputStream inputStream =  null;          
 XMLParser parser=  null ;        private void parseXML() throws Exception{             if (xmlFilePath ==null){              System.out.println("Invalid file path"); return;}            try {                  //Read the content of xmlfile into a string  
     String strContent = "";               inputStream= new FileInputStream(new java.io.File(xmlFilePath));       parser =  XMLParser.newInstance();             while ((strContent =inputStreamReader .readLine()) !=  null) {                  //Parse the content of xmlfile              }                catch (Exception e){ System.out.println("Error in parsing: " +e);}           finally{ if(parser!=null ) parser.getDefaultHandler().release();  inputStreamCloseMe(inputStreamReader );}}           
   private void inputStreamCloseMe(InputStreamReader reader) {         try    //Closing the Inputstream and Printwriter          Reader in = new BufferedReader (new InputStreamReader(System.in));     for (; ; ){ System .out。println “Enter something :”; String s1=reader  
      }catch (Exception ex){}        finally { if ((inputStream)!=  null) inputstreamcloseme();}}         //Closing the Inpur Stream and Printwriter          private java_52684_XMLParser_A01(){ try     for (; ; ){ System .out。println “Enter something :”; String s1=reader }catch (Exception ex){}  
    finally { if ((inputStream) !=  null && inputstreamcloseme() == false);}}} catch(IOException e2){System.err      //Error Handling for I/O operations     System .out “Input / Output Error”;}}          try{ new Main().parseXML();}catch (Exception ex){             }          
 private boolean isNumeric(String str){         return ((str != null) &&   //Check if string contains numerics.    Strings s = "0123456789";      for ‘s’ in    `Strgins +“"');if (isAlphanumerical == false || isNumeric==false){ System .out。println("Invalid input"); return true;}}        
}