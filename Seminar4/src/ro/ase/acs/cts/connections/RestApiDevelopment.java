package ro.ase.acs.cts.connections;

public class RestApiDevelopment implements RestService{

    public RestApiDevelopment() {
        System.out.println("Development Server!");
    }

    @Override
    public void connect() {
        System.out.println("Connected succesfully!");
    }
}
