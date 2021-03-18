package ro.ase.acs.cts.main;

import ro.ase.acs.cts.connections.*;

public class Program {
    public static void main(String[] args) {
//        Logger logger = new Logger();
//        logger.log("Main ended!");

//        LoggerSingleton logger = LoggerSingleton.getInstance();
//        logger.log("Main started!");
//        logger = LoggerSingleton.getInstance("Logger.txt");
//        logger.log("Main ended!");

//        RestApiRelease rest = new RestApiRelease();
//        rest.connect();

        RestService rest = SimpleFactory.createConnection(ServerType.DEVELOPMENT);
        rest.connect();

        RestServiceV2 restV2 = SimpleFactoryV2.createConnection(
                Configuration.readConfiguration(),"https:./.");
        restV2.connect();
    }
}
