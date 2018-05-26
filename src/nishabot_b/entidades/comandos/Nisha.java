package nishabot_b.entidades.comandos;

import net.dv8tion.jda.core.entities.MessageChannel;
import java.io.File;
import java.util.Random;

public class Nisha {

    private static File[] arrFotos = cargarFotos("res/imagenes/nishafotos");
    private int numeroRandom;

    public Nisha() {
        numeroRandom = generarNumeroRandom();
    }

    public int getNumeroRandom() {
        return numeroRandom;
    }

    public static File[] getArrFotos() {
        return arrFotos;
    }

    public void enviarFoto(MessageChannel mc) {
        mc.sendFile(arrFotos[numeroRandom]).queue();
    }

    private int generarNumeroRandom() {
        return new Random().nextInt(arrFotos.length);
    }

    private static File[] cargarFotos(String ruta) {
        return new File(ruta).listFiles();
    }
}
