package jdevhl.common;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFiles {

    public static String getFileString(String path) {
        String fileString = null;
        try {
            fileString = Files.readString(Constants.BASE_TEST_RESOURCES.resolve(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileString;
    }

    public static String getPath(String file) {
        return Constants.BASE_TEST_RESOURCES.resolve(Paths.get(file)).toString();
    }

}
