package ro.ase.acs.cts.logger;

import java.io.*;
import java.util.Date;

public class LoggerSingleton {
    private static LoggerSingleton instance = null;

    private String fileName;

    private LoggerSingleton() {
        fileName = "Log.txt";
    }

    private LoggerSingleton(String fileName) {
        this.fileName = fileName;
    }

    public void log(String message) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
            OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write(String.valueOf(new Date()) + " ");
            bufferedWriter.write(message);
            bufferedWriter.write(System.lineSeparator());

            bufferedWriter.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized LoggerSingleton getInstance() {
        if (instance == null) {
            instance = new LoggerSingleton();
        }
        return instance;
    }

    public static synchronized LoggerSingleton getInstance(String fileName) {
        if (instance == null) {
            instance = new LoggerSingleton(fileName);
        }else{
            System.out.println("Default logger already created!");
        }
        return instance;
    }
}
