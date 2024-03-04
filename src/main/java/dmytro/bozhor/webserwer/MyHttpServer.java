package dmytro.bozhor.webserwer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyHttpServer {

    private Integer port;

    public MyHttpServer(Integer port) {
        this.port = port;
    }

    public void run() {
        try (var serverSocket = new ServerSocket(port);
             var socket = serverSocket.accept()) {

            process(socket);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void process(Socket socket) throws IOException {
        try (var dataInputStream = new DataInputStream(socket.getInputStream());
             var dataOutputStream = new DataOutputStream(socket.getOutputStream())) {

            var request = dataInputStream.readNBytes(512);
            System.out.println(new String(request));

//            var startingLine = "HTTP/1.1 200 OK".getBytes();
            var body = """
                    {
                        "id": 12,
                        "firstName": Ban,
                        "secondName": Robinzon,
                        "age": 41
                    }
                    """.getBytes();
            var headers = """
                    HTTP/1.1 200 OK".getBytes()
                    Content-Type: application/json
                    Content-Length: %s
                    """.formatted(body.length).getBytes();

//            dataOutputStream.write(startingLine);
            dataOutputStream.write(headers);
            dataOutputStream.write(System.lineSeparator().getBytes());
            dataOutputStream.write(body);
        }
    }

}
