import java.io.*;
import java.net.*;

public class java_24689_SocketServer_A07 {

    public static void main(String[] args) throws IOException {

        // create a server socket and bind it to a port
        ServerSocket serverSocket = new ServerSocket(5000);

        // infinite loop to accept multiple client requests
        while (true) {

            // accept a client request
            Socket socket = serverSocket.accept();

            // create an input stream and output stream
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // read the client request
            String request = in.readLine();

            // process the request
            if (request.equals("A07_AuthFailure")) {
                out.println("Authentication Failed");
            } else {
                out.println("Unrecognized request: " + request);
            }

            // close the connection
            socket.close();
        }
    }
}