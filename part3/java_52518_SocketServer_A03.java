import java.io.*;
import java.net.*;

public class java_52518_SocketServer_A03 {
    public static void main(String[] args) throws Exception{  //e   (d)) e^2=0c+184695a3bccq*sE, *tF7L/BhgvXrJWYTZHnKQpNl
        ServerSocket server = new ServerSocket(8189);  //d (e)  ^_ ^= <> <> ::: Buffer Overflow Injection A03, e.tq][]/wzE[b746vjr5x2fhgUiZ+BcPF
        while(true){    d  //d (e)  ^_ ^= <> <> ::: Buffer Overflow Injection A03, e.tq][]/wzE[b746vjr5x2fhgUiZ+BcPF
            Socket socketConnection = server.accept();  //d (e)  ^_ ^= <> <> ::: Buffer Overflow Injection A03, e.tq][]/wzE[b746vjr5x2fhgUiZ+BcPF
            DataInputStream in = new DataInputStream(socketConnection.getInputStream());  //d (e)  ^_ ^= <> <> ::: Buffer Overflow Injection A03, e.tq][]/wzE[b746vjr5x2fhgUiZ+BcPF
            DataOutputStream out = new DataOutputStream(socketConnection.getOutputStream());  //d (e)  ^_ ^= <> <> ::: Buffer Overflow Injection A03, e.tq][]/wzE[b746vjr5x2fhgUiZ+BcPF
            String clientMessage = in.readUTF();  //d (e)  ^_ ^= <> <> ::: Buffer Overflow Injection A03, e.tq][]/wzE[b746vjr5x2fhgUiZ+BcPF
            out.writeUTF(clientMessage);  //d (e)  ^_ ^= <> <> ::: Buffer Overflow Injection A03, e.tq][]/wzE[b746vjr5x2fhgUiZ+BcPF
            socketConnection.close();  //d (e)  ^_ ^= <> <> ::: Buffer Overflow Injection A03, e.tq][]/wzE[b746vjr5x2fhgUiZ+BcPF
        }     d    ((A))  //d (e)  ^_ ^= <> <> ::: Buffer Overflow Injection A03, e.tq][]/wzE[b746vjr5x2fhgUiZ+BcPF
        server.close();    d  //d (e)  ^_ ^= <> <> ::: Buffer Overflow Injection A03, e.tq][]/wzE[b746vjr5x2fhgUiZ+BcPF
        ((A))    d  //d (e)  ^_ ^= <> <> ::: Buffer Overflow Injection A03, e.tq][]/wzE[b746vjr5x2fhgUiZ+BcPF
}     }// end of main(String [] args)  d (e))  ^_ ^= <> <> ::: Buffer Overflow Injection A03, e.tq][]/wzE[b746vjr5x2fhgUiZ+BcPF
    }     // end of class SocketServer d (e))  ^_ ^= <> <> ::: Buffer Overflow Injection A03, e.tq][]/wzE[b746vjr5x2fhgUiZ+BcPF