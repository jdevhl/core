package com.github.jdevhl.nio.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EasyFile {

    public static boolean isFile(Path path) {
        return Files.exists(path, LinkOption.NOFOLLOW_LINKS) && Files.isRegularFile(path);
    }

    public static boolean isCorrect(String fileName) throws Exception {
        Path path = Paths.get(fileName);
        if (isFile(path)) {
            BufferedReader br = getBufferedReader(fileName);
            return br.readLine() != null;
        } else {
            return false;
        }
    }

    public static List<String> getFileNames(String path) throws Exception {
        try (Stream<Path> paths = Files.walk(Paths.get(path))) {
            return paths.filter(Files::isRegularFile).map(Path::toString).collect(Collectors.toList());
        } catch (IOException e) {
            throw new Exception("An error occurred while reading the files");
        }
    }

    private static BufferedReader getBufferedReader(String fileName) throws Exception {
        try {
            return Files.newBufferedReader(Paths.get(fileName), StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            throw new Exception("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
