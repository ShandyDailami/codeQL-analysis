public class java_51031_FileScanner_A08 {             
             private static void printFiles(String path) throws IOException{       
                 File file = new File(path);           
                  if (file.isDirectory()){               
                       for (File subfile: file.listFiles())                    
                           printFiles(subfile.getPath());       }                      else {         // It's a normal non-directory file                    try{              
                                  BufferedReader reader = new BufferedReader     (new FileReader   (path));                  String line;                       while ((line=reader .readLine())! - null)                     System. out      .println(file + " says: \""+       line  +"\"");                      } catch    Exception e{               // Catch any exception that may have happened}
                            }}   public static void main (String[] args){              String homeDir = Sys     tem.getHomeDirectory(); System. out .println("Scanning " +      home Dir); printFiles(home dir );}}}  }