package ro.ase.acs.main;

import ro.ase.acs.contracts.Readable;
import ro.ase.acs.readers.Reader;
import ro.ase.acs.writers.ConsoleWriter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        IoC ioc = new IoC();
        ioc.register(Readable.class,Reader.class);
        Readable readable =  ioc.resolve(Readable.class);

        Orchestrator orchestrator = new Orchestrator(readable , new ConsoleWriter());
        orchestrator.execute();
    }
}
