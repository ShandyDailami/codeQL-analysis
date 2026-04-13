import java.io.*;
import java.net.*;
import java.util.*;

public class java_25458_SocketServer_A08 {
    private static final String CLIENT_IDENTIFIER = "A08_IntegrityFailure";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started at port 8189");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A new client connected from " + socket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientIdentifier = in.readLine();
            if (!CLIENT_IDENTIFIER.equals(clientIdentifier)) {
                System.out.println("Client identifier mismatch, closing connection");
                socket.close();
            } else {
                out.writeBytes("Connection successful\n");
            }
        }
    }
}