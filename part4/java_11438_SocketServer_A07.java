import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_11438_SocketServer_A07 {

    // Start the server
    public static void main(String[] args) throws IOException {
        System.out.println("Starting server on port 4445");
        ServerThread st = new ServerThread();
        st.start();
    }

    // Server thread
    static class ServerThread extends Thread {
        Socket socket;
        BufferedReader in;
        PrintWriter out;

        @Override
        public void run() {
            try {
                // Accept a new socket
                socket = new Socket("localhost", 4445);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                // Send a welcome message
                out.println("Welcome to the authentication server!");

                // Receive and respond to the client's request
                while (true) {
                    String request = in.readLine();
                    if (request.equals("AuthFailure")) {
                        // Authentication failed, close the connection
                        out.println("AuthFailure");
                        out.close();
                        in.close();
                        socket.close();
                        break;
                    } else {
                        // No authentication failed, continue the request
                        out.println("Successfully processed the request!");
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}