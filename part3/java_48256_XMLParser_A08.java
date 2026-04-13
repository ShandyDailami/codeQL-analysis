import java.io.*;   // Import necessary classes   
implements Serializable{    
public static void main(String[] args) throws Exception {      
try     
{         Console console = new Console();       
console .readFile("testfile"); }          catch (Exception e){            System outprintln ("IOException occurred: " +e);   }}  //print exception if any occur     finally    {}                });              public classConsole implements Serializable {       private static final long serialVersionUID = 1L;         @Overridepublic void readFile(String fileName) throws Exception{
                  FileInputStream fis = new FileInputStream("D:\\test.xml");      BufferedReader br          =new          Buffered Reader (fis);     String strCurrentLine ;   int count    =0            while ((strCurrentLine  =br .readline())!=null){        System outprintln (" Line # "+(count++) +" :\t"   
              +  strcurrent line ); } br.close();  }}                    });