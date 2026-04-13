import java.io.*; // Import Input/Output Streams and File I/O Exceptions  
public class java_52302_XMLParser_A03 {   
     public static void main(String[] args) throws Exception{         
             String filePath = "path_to_your_file";  /* Insert your path here */     
               try (FileInputStream fis = new FileInputStream(new File(filePath));       // Step a: Use InputStream       
                      BufferedReader br =  new BufferedReader(new InputStreamReader(fis))) {   // Steps b and c - Commented out for demonstration purpose   
                        String line;    
                            while ((line = br.readLine()) != null)  {              /* Step e */       
                                System.out.println("Read content: " + line);             /**/     
                             }                                                    // Don't use the above code for real-world applications      
                   } catch (IOException ex){                 
                          throw new Exception("Error in reading file",ex);              /* Error handling */ 
                           }) ;    };     }}// Step f - Closing {} brackets.