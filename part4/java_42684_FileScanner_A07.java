import javafx.scene.control.*; // Importing necessary JavaFX controls for the file dialogs in Minimalist style   
    
public class java_42684_FileScanner_A07 {      
      public static void main(String[] args) {            
          TextInputDialog input = new TextInputDialog();   // Create an instance of a textinputdialog        
          
          /*  Get the directory path from user */              
          String dirPath="";               
                   if (Platform.isFxAvailable())                  Platform.runLater(new Runnable() {                    public void run(){ input.setHeaderText("Enter Directory Path:");input.showAndWait();}  });                 else   System.out.println ("Not a FX application.");               
          dirPath = (String) input.getEditor().getTextField().getText();                  if(dirPath==null || "".equalsIgnoreCase(dirPath)) {System.out.println("Invalid path entered by user"); return;}               File file=new java.io.File((InputDialog)); // Create a new instance of the Java's I/O FILE           
          try{             System.out.print("\n Scanning directory: "+file);      if(!dirPath .endsWith ("/")) dirPath += '/';    File[] files= file.listFiles();if(files==null) return;                for(File f :   files){                   //Checking every single element of the array 
                      String name =f.getName() ;            boolean condition1 =  !name .equals ("") && ( (! ".".equalsIgnoreCase (.replaceAll("\\s","").substring(.length()-4,"".concat(".txt")))))    if(!condition) continue;                // Checking for a specific file extension
                   }                  catch(Exception e){System.out.println("\n Error: File not found.");return;}             System.out.print ("\n Scanning Finished");  }}               });