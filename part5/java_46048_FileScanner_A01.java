import java.io.*; // Import required classes for file handling, streams etc.   
public class java_46048_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{       
         File folder = new File(".");         
            
         String [] listOfPasswordFiles =  folder.list(new FilenameFilter()  //List all text files in the current directory  
              {                  
                  @Override     
                 public boolean accept(File dir, String name)    //We only want .txt file                   
                     return name.endsWith(".txt");             });    
          for (String filename : listOfPasswordFiles){           
               try{                        
                FileReader fr = new FileReader("passwords/"+filename);  //Open the passwords files        
                  BufferedReader br =  new BufferedReader(fr) ;      //Buffering reader to read from file          
                    String line;                          
                        while((line=br.readLine())!=null){                        
                            System.out.println("Passwords in "+filename +":\n"  +  "\t-" +  (new java.util.regex.Pattern(line).matcher(new java.lang.StringBuilder()).replaceAll(".*"));                }                      br.close();            }}                   catch (Exception e){                     System.out.println("\ncan't open file");}}            
    private static class FileMatchFinder extends Filter {                  @Override        public String convert(File dir, String name)  //Filter out lines that do not match the pattern         return super.convert("passwords/" + (new java.util.regex.Pattern(".+")).matcher((super.toString())));}}}