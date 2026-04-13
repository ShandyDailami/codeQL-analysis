import java.io.*; // Import necessary classes for file handling, etc 
class java_42368_FileScanner_A03 {  
    public static void main(String[] args) throws IOException{    
        FileScanner scan = new FileScanner("C:/Users/YourUsername/Desktop", "txt");     
         }      
}          
          class FileScanner implements AutoCloseable, Iterator<File> {   // Implementing the necessary interfaces. 
              private String directoryPath;    // Directory to scan for .text files and their contents...       
                List<String>  fileList = new ArrayList<>();     /* ...and store them in this list */            File[] initialdirfilelist ;      Dir dirobj=null；  
                  publicFileScanner(final String s, final “.txt”) {    // Constructor with arguments...          super（s，新FilenameFilter对象{@Overridepublic boolean accept (finally FilenameF…/new )});         }        @ Override默认方法以确保正确的方法签名并提供迭代器和关闭的实现 */
  public Iterator<File> iterator() {     // Implementing the necessary methods...    return this；   /* ...and returning an instance of my class as a File list.*/ } @ Override默认方法以确保正确的方法签名并提供迭代器和关闭的实现 */
  public void close(){/*Do nothing, it's only needed to follow the iterator protocol and doesn’t need any closing operations in this case。It should not be used elsewhere.*/} }}}}}} // Your code here! Remove if unused or comment out as per your requirement for minimist style coded program