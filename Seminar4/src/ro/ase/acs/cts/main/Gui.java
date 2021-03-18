package ro.ase.acs.cts.main;

import ro.ase.acs.cts.logger.Logger;
import ro.ase.acs.cts.logger.LoggerSingleton;
import ro.ase.acs.cts.logger.LoggerSingletonV2;
import ro.ase.acs.cts.logger.LoggerSingletonWithEnum;

public class Gui {
    public static void main(String[] args) {
//        Logger logger  = new Logger();
//
//        logger.log("GUI opened!");

        LoggerSingleton logger = LoggerSingleton.getInstance("Logger.txt");
        logger.log("GUI opened!");
        logger = LoggerSingleton.getInstance();
        logger.log("Gui closed!");

        LoggerSingletonWithEnum.INSTANCE.log("Enum!");

        LoggerSingletonV2.instance.log("Static!");
    }
}
