import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_02305_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        int port = 8080;
        Socket socket = new Socket("localhost", port);

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        String request;
        while ((request = reader.readLine()) != null) {
            if ("exit".equals(request)) {
                break;
            }
            String response = "Server says: " + request;
            writer.println(response);
        }

        socket.close();
    }
}