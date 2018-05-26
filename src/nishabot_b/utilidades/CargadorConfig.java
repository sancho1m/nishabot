package nishabot_b.utilidades;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CargadorConfig {

    public static Properties cargar(String ruta) {
        try {
            Properties config = new Properties();
            config.loadFromXML(new FileInputStream(ruta));
            return config;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
