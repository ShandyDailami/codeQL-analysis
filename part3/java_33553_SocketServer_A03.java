import java.io.*;
import java.net.*;

public class java_33553_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();

            // Create input and output streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read from client
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);

                // Send back received data
                out.println(inputLine);
           
                if (inputLine.equals("exit")) {
                    break;
                }
            }

            socket.close();
        }
    }
}