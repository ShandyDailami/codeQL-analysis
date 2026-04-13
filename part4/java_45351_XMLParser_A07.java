import java.io.*; // for handling file I/O exceptions  
// import org library XMLUnmarshaller interface 
public class java_45351_XMLParser_A07 {   
     public static void main(String[] args) throws Exception{     
         try (FileInputStream fis = new FileInputStream("src\\studentsInfo.xml");          // Reading from file input stream        )      
             BufferedReader br =  new BufferedReader(new InputStreamReader(fis));   // Buffer reader to read the content of xml     )){           
                     XMLUnmarshaller unm = XmlBfactory.create();      // Creating instance for UnMarshallers    )       } catch (FileNotFoundException e) {                throw new RuntimeException(e);         }}