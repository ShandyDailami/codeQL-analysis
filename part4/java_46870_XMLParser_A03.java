import java.io.*;  // Importing InputStream and PrintWriter for reading file from disk & writing on console (optional)
  
public class java_46870_XMLParser_A03 {    
    public static void main(String[] args){        
        try{            
            FileInputStream fstream = new FileInputStream("example_filepath");// Create a input stream to read the XML data into it  // Replace example file path with your actual xml location.   Example: "inputXMLFile"          
                BufferedReader br =new BufferedReader(new InputStreamReader(fstream));      
            String strLine;         
             while ((strLine=br.readLine()) != null) {               // Reads each line of the XML file and store it into string 'a'  Example: a =  new char[1024];         int len = fstream .available();      Arrays.fill(a, (int)(len/3));      
                System.out.println("Text read from File : " + strLine);        // Prints each line of the XML file on console Example:   printWriter ("Hello World!"+i)  } catch {}; finally {}     fstream .close();          }}// This code reads an entire xml document and stores it in string