package jdevhl.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for use of CSV Files.
 *
 * @author Oscar Montes
 * @since 1.0.0
 */
@Slf4j
public class EasyCsv {

    public static final String COMMA_SEPARATOR = ",";
    public static final String SPACE_SEPARATOR = " ";
    public static final String SEMICOLON_SEPARATOR = ";";

    public static List<String[]> read(String pathFile) throws FileNotFoundException {
        return read(pathFile, COMMA_SEPARATOR);
    }

    public static List<String[]> read(String pathFile, String separator) throws FileNotFoundException {
        List<String[]> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(pathFile));
        String text = null;
        try {
            while ((text = br.readLine()) != null) {
                list.add(text.split(separator));
            }
        } catch (IOException e) {
            log.error("Error parsing csv {}", e.getMessage());
        }
        return list;
    }
}
