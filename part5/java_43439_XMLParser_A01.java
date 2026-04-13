import java.io.*;   // Import Input/Output Streams, FileReader etc...   
public class java_43439_XMLParser_A01 {    
       public static void main(String[] args) throws Exception{     
              try (FileReader reader = new FileReader("invalid_xmlfile")) { 
                      int c;       
                      while ((c=reader.read()) != -1){   // Reads one character at a time    
                              System.out.print((char) c);// Print the characters to standard output   
                       }     
              } catch (FileNotFoundException e2) { 
                   System.out.println("Invalid file not found: " + e2 );   // Handles exception if File is Not Found    
                    return;         
               }      
                try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))    {     
                     String input  = null ; 
                      System.out.println("Enter your XML file name: ");   // Takes the xml filename as an command line argument    
                     while((input=br.readLine()) !=null)       {       
                              try (FileReader fr = new FileReader(input))    {     
                                      int ch;         
                                      System.out.println("Contents of XML file: ");            // Displays the contents to standard output    
                                      while((ch=fr.read()) != -1)       {             
                                               System.out.print((char)ch);          
                                        }                     
                              } catch (FileNotFoundException e3 ){            
                                       System.err.println("Invalid file not found: " +e3 );          // Handles exception if File is Not Found    
                                    return;     
                                }  
                    }}  finally {      
                          reader = null ;    try { br  = new BufferedReader(new InputStreamReader (System .in));} catch (Exception e4) {}             
                      System.out.println("Please enter the xml file name");           // Prints a prompt message to standard output      } 
                }}