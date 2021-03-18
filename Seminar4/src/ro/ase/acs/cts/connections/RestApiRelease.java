package ro.ase.acs.cts.connections;

public class RestApiRelease implements RestService{

    public RestApiRelease() {
        System.out.println("RELEASE SERVER");
    }

    @Override
    public void connect(){
        System.out.println("Connected succesfully!");
    }
}
