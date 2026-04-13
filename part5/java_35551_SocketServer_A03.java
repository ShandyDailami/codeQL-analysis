import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_35551_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        // create server socket
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            // accept client connection
            Socket socket = serverSocket.accept();

            // create input and output stream
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // read from client
            String message = in.readLine();

            // process the message (this is not secure, but for demonstration purposes)
            String response = processMessage(message);

            // send response back to client
            out.println(response);
        }
    }

    private static String processMessage(String message) {
        // here you can use your own logic to secure the message
        // for example, you can replace every character with its ASCII code
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            sb.append((int) c);
        }
        return sb.toString();
    }
}