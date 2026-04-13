import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_02154_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        int port = 5555;
        Socket socket = new Socket("localhost", port);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        String response;
        while ((response = reader.readLine()) != null) {
            System.out.println("Received: " + response);
            // For example, if the response is a command for the client to login,
            // the server will return a success message.
            if (response.startsWith("login")) {
                String username = response.substring(response.indexOf(" ") + 1);
                writer.println("loginSuccess " + username);
            } else {
                // If the response is not a command for login,
                // the server will return a failure message.
                writer.println("loginFailure");
            }
        }

        socket.close();
    }
}