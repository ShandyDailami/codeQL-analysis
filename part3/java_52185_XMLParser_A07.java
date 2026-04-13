import java.io.*; // For InputStream, OutputStream... etc..  
public class java_52185_XMLParser_A07 {   
     public static void main(String[] args){     
           try{            
                parseXML("src/data1234567890_secureTokenFile");  /*Your Secure Token File */         
            }catch (Exception e)      
        {                 
                 System.out.println ("Error in parsing the XML file: " +e);         // Handle exception here            
                return;                   
           }}     public static void parseXML(String xmlFilePath){    /*Input File Path */ 
          try{            InputStream input = new FileInputStream (xmlFilePath );        BufferedReader reader =  new BufferedReader ((InputStreamReader)input);               String line ;             while((line=reader.readLine())!=null ) {println(line)};           }catch (Exception e){System .out.print ("Error in Reading the file: "+e, e );}  }}