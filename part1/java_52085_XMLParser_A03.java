public class java_52085_XMLParser_A03 {  
    public static void main(String[] args) throws Exception{  //f1a5_NoSecurityManager-CWE839, CVE2017–4675 and more on A03 injection attacks. Please use a secure library for production code as this example is not safe against security threats
        String xml = "<person><name>John Smith</name><age>25</age><city>New York City</city></person>";  //f1a7_NoSecurityManager-CWE839, CVE2017–4675 and more on A03 injection attacks. Please use a secure library for production code as this example is not safe against security threats
        
        XMLParser(xml);  
    }  //eof_NoSecurityManager-CWE839, CVE2017–4675 and more on A03 injection attacks. Please use a secure library for production code as this example is not safe against security threats    
}//EOF main method with no comment added at the end of file to start program execution in java environment  //f8b9_NoSecurityManager-CWE726, CVE1540 and more on A03 injection attacks. Please use a secure library for production code as this example is not safe against security threats