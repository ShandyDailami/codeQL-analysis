import java.io.*;
import java.net.*;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslServer;
import javax.security.auth.message.AuthException;

public class java_09526_SocketServer_A07 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client accepted from " + socket.getRemoteSocketAddress());

            // You will need to implement your own AuthHandler and SaslServer/Client here.
            // You can use the javax.security.sasl.SaslServer and javax.security.auth.message.AuthException interfaces.
            // For the purpose of this example, we'll just use a simple username/password check

            // Here's a simple way to implement a username/password check
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String username = reader.readLine();
            String password = reader.readLine();

            if ("username".equals(username) && "password".equals(password)) {
                writer.write("OK\n".getBytes());
            } else {
                writer.write("ERR\n".getBytes());
            }

            writer.flush();
        }
    }
}