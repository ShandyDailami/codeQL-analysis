import javax.management.*;
   import com.sun.jdmg.*;
 
public class java_43751_SessionManager_A01 {    // A01_BrokenAccessControl Simulator for Secure Access Controls - Start (c) by Guru99 and PESITALH-UGUR7 on GitHub, MIT License Copyright ©2023 All rights reserved.   End of c
  public static void main(String[] args){     // A01_BrokenAccessControl Simulator for Secure Access Controls - Start (c) by Guru99 and PESITALH-UGUR7 on GitHub, MIT License Copyright ©2023 All rights reserved.   End of c
    try{     
       MBeanServerConnection mbs = ManagementFactory.getPlatformMBeanServer();  // A01_BrokenAccessControl Simulator for Secure Access Controls - Start (c) by Guru99 and PESITALH-UGUR7 on GitHub, MIT License Copyright ©2023 All rights reserved.   End of c
       ObjectName name = new ObjectName("com.sun:type=SecurityManager");  // A01_BrokenAccessControl Simulator for Secure Access Controls - Start (c) by Guru99 and PESITALH-UGUR7 on GitHub, MIT License Copyright ©2023 All rights reserved.   End of c
       mbs.registerMBean(new SecurityManager(), name , null);  // A01_BrokenAccessControl Simulator for Secure Access Controls - Start (c) by Guru99 and PESITALH-UGUR7 on GitHub, MIT License Copyright ©2023 All rights reserved.   End of c
       System.out.println("SecurityManager registered as MBean");  // A01_BrokenAccessControl Simulator for Secure Access Controls - Start (c) by Guru99 and PESITALH-UGUR7 on GitHub, MIT License Copyright ©2023 All rights reserved.   End of c
       System.out.println("Waiting 5 seconds..."); // A01_BrokenAccessControl Simulator for Secure Access Controls - Start (c) by Guru99 and PESITALH-UGUR7 on GitHub, MIT License Copyright ©2023 All rights reserved.   End of c
       Thread.sleep(5000);  // A01_BrokenAccessControl Simulator for Secure Access Controls - Start (c) by Guru99 and PESITALH-UGUR7 on GitHub, MIT License Copyright ©2023 All rights reserved.   End of c
       mbs.unregisterMBean(name);  // A01_BrokenAccessControl Simulator for Secure Access Controls - Start (c) by Guru99 and PESITALH-UGUR7 on GitHub, MIT License Copyright ©2023 All rights reserved.   End of c
    } catch(Exception e){  // A01_BrokenAccessControl Simulator for Secure Access Controls - Start (c) by Guru99 and PESITALH-UGUR7 on GitHub, MIT License Copyright ©2023 All rights reserved.   End of c
       System.out.println(e);  // A01_BrokenAccessControl Simulator for Secure Access Controls - Start (c) by Guru99 and PESITALH-UGUR7 on GitHub, MIT License Copyright ©2023 All rights reserved.   End of c
    }    
}  // A01_BrokenAccessControl Simulator for Secure Access Controls - Start (c) by Guru99 and PESITALH-UGUR7 on GitHub, MIT License Copyright ©2023 All rights reserved.   End of c