package ch.puzzle.workshop.springboot;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class NamesUtils {

    public static List<String> getNames(String fileName) throws IOException {
        ClassPathResource resource = new ClassPathResource(fileName);
        return Files.lines(Paths.get(resource.getFile().getAbsolutePath())).collect(Collectors.toList());
    }
}
