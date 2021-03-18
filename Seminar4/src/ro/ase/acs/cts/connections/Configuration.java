package ro.ase.acs.cts.connections;

import java.io.*;

public class Configuration {

    public static String readConfiguration() {
        BufferedReader reader = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("config.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            reader = new BufferedReader(inputStreamReader);
            return reader.readLine();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
