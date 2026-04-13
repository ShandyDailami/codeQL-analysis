// Importing necessary libraries (Cookies and URL)  
import javax.swing.*; // for JFrame, JOptionPane   
import java.net.URL;    
import java.util.HashMap;     
         
class java_43365_SessionManager_A07 {      
static HashMap<String , String> map = new HashMap<>(); 
public static void main(final String[] args) throws Exception   //Main function          
{       
    createCookie("username", "JohnDoe");    
}             
private static boolean authenticateUser() {      //Authentication Function      
String name= getParameterByName("name"), pwd =getPassword(); 
if(map.containsKey(name) && map.get(name).equalsIgnoreCase(pwd)){        return true; }    else{return false;}  
}         
private static void createCookie (final String cname, final String cdirection){         //Create Cookies Function          
JTextField tf = new JTextField();      setDefaultCloseOperation     WindowConstants.EXIT_ON_CLOSE;       System.out.println("Enter Password");    JOptionPane.showMessageDialog(null,"Username: "+cname);          String userPwd=tf .getText ( );          
if ("".equalsIgnoreCase ​(userPwd)) {            setVisible     false;}         Cookie c = new   Cookie     ​​[CNAME,CDIRECTION]       ;        //creating a cookie with name and direction         
c [0 ] =  Cname;    c‌ .setDomain (cdirection);  createCookiemonth();           setVisible(true)         } else {            JOptionPane.showMessageDialog  ​     ​​null, "You entered wrong password" ;}     //if not authenticated       
private static void getPassword()              throws Exception    if("".equalsIgnoreCase (userPwd))  throw new IOException (" User canceled");           userPass =tf .getText();          setVisible(false)         }             else {            JOptionPane.showMessageDialog  ​     ​​null, "You entered wrong password" ;}     //if not authenticated       
public static void main (String[] args){       if (!authenticateUser()  ){           System .out‌ing ("Access Denied");          } else {             setVisible(true);         }}