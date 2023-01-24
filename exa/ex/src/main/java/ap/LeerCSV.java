package ap;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LeerCSV {
    static List leerCSV(String csv) {
        BufferedReader bufferLectura = null;
        try {
            bufferLectura = Files.newBufferedReader(Paths.get(csv + ".csv").toAbsolutePath());
        } catch (IOException e) {
            System.err.println("No se encuentra el archivo");
        }
        Stream<String> filas = bufferLectura.lines();
        List data = new ArrayList<>();
        filas.forEach(f -> {
            String[] campo = f.split(",");

            if (csv.equalsIgnoreCase("asignatura")) {
                    data.add(new Asignatura(Integer.parseInt(campo[0]), (campo[1]), Integer.parseInt(campo[2])));
            } else if (csv.equalsIgnoreCase("ciclo")) {
                    data.add(new Ciclo(Integer.parseInt(campo[0]), (campo[1])));
            }
        });
        return data;

    }
}
