import javax.management.*;
import java.lang.reflect.InvocationTargetException;
import sun.misc.Signal;
import sun.misc.SignalHandler;
  
public class java_46288_SessionManager_A01 {   
       static int sessionCount = 0;     // global count of active sessions     
       
       public static void main(String[] args) throws InterruptedException, MBeanException  {         
           Signal.handle(new Signal("INT"), newSignalHandler);           
        	System.out.println("\nSession Manager Started...\tCTRL+C to stop");               
             while (true){   // main program loop    if sessionCount==0 then break;      }       System.exit(-1) ; 
       	}    
          static void newSignalHandler(Signal signal){        	System.out.println("\nSession Manager Stopped...");            for (;;) {Thread.yield();}}             public class Session{              int id;    // unique identifier     
                boolean isActive = false;      			public java_46288_SessionManager_A01(int iD)     this .id=iD ;   }  static final ArrayList<Session> sessions  = new ArrayList<>() ;        	static {            try{                 System.in.read();             Signal.handle(new Signal("TERM"),   
                signal ->  {System.out.println("\nReceived Terminate Request...");     for (Object obj : SessionManager .sessions)  if ((obj instanceof   Session))          {Session session =((Session )      obj );            System.gc();session.isActive=false;   
                })} catch(Exception e){System.out.println("Caught Exception: " +     e);}                 }}            	protected void finalize() throws  Throwable{   // called when an object is about to be garbage collected      SessionManager .sessions.remove (this) ;sessionCount--;}}