import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class java_30460_SocketServer_A03 {

    private static final String CRLF = "\r\n";
    private static final String COLON = ":";
    private static final String SPACE = " ";
    private static final String AUTHENTICATION = "Basic ";
    private static final String CONTENT = "You are authenticated.";
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket();
        server.bind(new InetAddress.LoopbackAddress(), PORT);

        while (true) {
            Socket client = server.accept();
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            String request = client.getInputStream().readLine();
            StringTokenizer st = new StringTokenizer(request);

            String firstLine = st.nextToken();
            String secondLine = st.nextToken();

            if (firstLine.startsWith(AUTHENTICATION)) {
                byte[] decodedBytes = Base64.getDecoder().decode(secondLine.substring(AUTHENTICATION.length()));
                String credentials = new String(decodedBytes, StandardCharsets.UTF_8);
                String[] splitCredentials = credentials.split(COLON);
                String clientUsername = splitCredentials[0];
                String clientPassword = splitCredentials[1];

                if ("user".equals(clientUsername) && "password".equals(clientPassword)) {
                    out.write("HTTP/1.1 200 OK" + CRLF);
                    out.write("Server: JavaSocketServer" + CRLF);
                    out.write("Content-Type: text/html; charset=utf-8" + CRLF);
                    out.write(CRLF);
                    out.write(CONTENT);
                    out.write(CRLF);
                    out.write(CRLF);

                } else {
                    out.write("HTTP/1.1 401 Unauthorized" + CRLF);
                    out.write("Content-Type: text/html; charset=utf-8" + CRLF);
                    out.write(CRLF);
                    out.write("Access Denied: Invalid Credentials" + CRLF);
                    out.write(CRLF);
                }
            } else {
                out.write("HTTP/1.1 401 Unauthorized" + CRLF);
                out.write("Content-Type: text/html; charset=utf-8" + CRLF);
                out.write(CRLF);
                out.write("Access Denied: Invalid Request" + CRLF);
                out.write(CRLF);
            }

            out.close();
        }
    }
}