import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_24186_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        int port = 8080; // default port

        // create server socket
        Socket socket = new Socket("localhost", port);

        // get input and output streams
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // send request
        out.println("GET / HTTP/1.1");

        // read response
        String response = in.readLine();
        System.out.println(response);

        // close resources
        in.close();
        out.close();
        socket.close();
    }
}