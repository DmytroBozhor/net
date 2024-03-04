package dmytro.bozhor.webserwer;

public class MyHttpServerRunner {

    public static void main(String[] args) {
        var myHttpServer = new MyHttpServer(7777);
        myHttpServer.run();

    }
}
