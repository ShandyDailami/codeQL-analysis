import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
public class java_52134_XMLParser_A08 {    
    public static void main(String[] args){        
        File inputFile = new File("inputfile.xml");  // specify your xml file path here            
        DocumentBuilderFactory dbFactory = 
            DocumentBuilderFactory.newInstance();  
        DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();          
       try {               
          Document doc = dBuilder.parse( inputFile );              
                  
          parseDataFromXmlDocuement(doc);                      
                   
         } catch (Exception e) {            
            System.out.println("Error in parsing XML " +e);  
        }}  //end of main function     
    
       private static void parseDataFromXmlDocument(Document doc){                  
           String sheetname=doc.getElementsByTagName("Students").item(0).getTextContent();                
          System.out.println("\n\t Student Information:\n");                 
               for (int i = 1;i<= 25 ; ++i ){                          //assuming there are total of 'student'   with id ranging from   1 to    30                    
                      String studentId=doc.getElementsByTagName("Students").item(i).getTextContent();                  
                       System.out.println("\t\tID:  "+studentId);                           //printing Student ID                        
                }           for (int i = 1;  ++i <=25 ; ++j ){                  ###assuming there are total of 'subjects' with id ranging from   0 to    4              if(doc.getElementsByTagName("SubjectId").item(m) != null){
                      String subjectID = doc . getElementbyid (" Subject Id " + m).getTextContent();                    //printing the subjects                         }                     else {   System.out.println("\t\t No Data Found");}  }}               if (doc... more code, same as above comments for integrity failure