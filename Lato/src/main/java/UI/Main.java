package UI;

import com.mycompany.lato.query.Init;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new Init().initializeApp();

        Login login = new Login();
        login.init();
    }
}
