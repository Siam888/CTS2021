package ro.ase.acs.main;

import ro.ase.acs.contracts.Readable;
import ro.ase.acs.readers.Reader;
import ro.ase.acs.writers.ConsoleWriter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        IoC ioc = new IoC();
        ioc.register(Readable.class,Reader.class);
        ioc.resolve();

        Orchestrator orchestrator = new Orchestrator(new Reader() , new ConsoleWriter());
        orchestrator.execute();
    }
}
