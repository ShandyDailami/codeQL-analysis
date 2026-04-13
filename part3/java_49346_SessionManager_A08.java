import javax.management.*;
import java.lang.reflect.InvocationTargetException;

public class java_49346_SessionManager_A08 {
    private static final String MBean_NAME = "org.example:type=Session"; // Replace this with your own mbean name or type for real applications, you should use a unique one per application instance and match it in configuration files/xmls of the dependent systems too. 
    
    public void checkSessions() {  
        try{            
            MBeanServerConnection server = connectToMBeanserver();          
                    
            // Obtain an attribute to get a list (array) with active sessions...      
            ListAttributes attrs;         
            ObjectName name=new StringObjectName(MBean_NAME);        
                                                      
             /* Invoke the MBean method. */ 
                      if((attrs = new ListAttributes()) !=  null){                //get list attributes of active sessions    
                        server.queryNames(null,name , attrs,(short)10 );        /**/     
                    }         else{                             System.out.println("No Sessions found");}            return;   /* exit early */    case MBeanConstructionCallback :  // Notification: construction of a new instance has been called     (optional). The constructor parameters can be null for the initial object and not used here in this sample code, only if defined by JMX specification.
                }         catch(InstanceAlreadyExistsException e){               System.out.println("Session MBean already exists");}             case NotCompliantMBeanException:  //Not compliant with specified interfaces/attributes exception (optional). Only when you are implementing a non-default constructor mbean, not in simple use cases
                    {System. out . println (" Error during InstanceCreation : MBeandoesnotsupportinitialization " );}            case ExceptionMBeanException:  //Error with the management of this instance (optional).   Only when you are implementing a non-default constructor mbean, not in simple use cases
                    {System.out .println (" Error during InstanceCreation : Unable to obtain connection MBeanserver " );}       } catch(MBeanException e){  System out . println("Error handling of the Jmx Interface: Please check your configuration");   return;         /* end error catching */    case NotCompliantRegisteredMBeanException://The mbean is not compliant with its registered interfaces and attributes exception (optional). This should be only used when you are implementing a non-default constructor MBeanserver.
                    {System out . println (" Error during InstanceCreation : The interface or attribute of the Jmx Interface doesnotmatch " );}   return;       /* end error catching */          case MultiErrorInfo: //Multiple Errors, all in one notifier (optional) This should be only used when you are implementing a non-default constructor MBeanserver.
                    {System out . println (" Error during InstanceCreation : More than One instance of the Jmx Interface found " );}         return;       /* end error catching */  }   finally{    //close connection and release resources (optional) If you have used a 'server' object for managing mbeans, don’t forget to close it here.
        catch(Exception ex){System out . println("Error handling the Jmx Interface: Please check your configuration");}            return;       /* end error catching */  }   System.out .println (" End of checking active sessions... ");}}}, MBeanServerConnection { //notifier (optional). You can implement this in any way to let others know when a session is created or destroyed, depending on how you are going around the JMX communication and what kind notifications/updates will be needed.