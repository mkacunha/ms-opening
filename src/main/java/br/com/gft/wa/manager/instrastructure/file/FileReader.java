package br.com.gft.wa.manager.instrastructure.file;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class FileReader {

    public static String readAsString(String path) {
        try {
            var resource = new ClassPathResource(path).getInputStream();
            var reader = new BufferedReader(new InputStreamReader(resource));
            return reader.lines()
                    .collect(Collectors.joining("\n"));
        } catch (Exception e) {
            throw new RuntimeException("Could not read file $path.", e);
        }
    }


}
