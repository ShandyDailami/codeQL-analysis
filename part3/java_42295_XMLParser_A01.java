import java.io.*;    // Import of FileReader, BufferedReader etc...    
public class java_42295_XMLParser_A01 {  
       public static void main(String args[]) throws Exception{       
              try (BufferedReader br = new BufferedReader(new FileReader("sampleFile"))){           
                     String line;            
                     while((line=br.readLine()) != null )  {                            
                            System.out.println("\nParsing XML in Legacy Style :");                        
                                    // Parses the xml string and display it out print          
                           }         
                  br.close();       
              } catch (IOException e)                      {                       
                     e.printStackTrace();     
               }                  
       }}