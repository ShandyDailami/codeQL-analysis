import javafx.scene.control.*;    // For Dialogs, TextFields...etc  
      import sigma.*;            // Main SIGMA classes and interfaces    
       public static void main(String[] args) {        
           ApplicationContext context = new DefaultApplicationContext("res/sigma_config-test142.xml");    SystemGraph graph;  try{graph=context.getSystemGraph();} catch (SigmaException e){e.printStackTrace();return;}   // Starts the Sigma application with a specific configuration file    
       }