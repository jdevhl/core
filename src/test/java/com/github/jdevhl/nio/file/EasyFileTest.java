package com.github.jdevhl.nio.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EasyFileTest {

    public String resourcesPath = "src/test/resources";

    @Test
    public void getFilesFromDirTest() throws Exception {
        List<String> list = EasyFile.getFileNames(resourcesPath.concat("//dir"));
        assertEquals(3, list.size());
        assertEquals("src/test/resources/dir/file1.txt", list.get(0));
    }

    @Test
    public void isCorrectFileTest() throws Exception {
        assertEquals(false, EasyFile.isCorrect(resourcesPath.concat("//fakeFile.txt")));
        assertEquals(false, EasyFile.isCorrect(resourcesPath.concat("//dir//empty.txt")));
        assertEquals(true, EasyFile.isCorrect(resourcesPath.concat("//dir//file1.txt")));
    }

    private static String getAbsolutePathTestResources(String path) {
        File file = new File(path);
        return file.getAbsolutePath();
    }

    private String getFile(String fileName) {
        return getAbsolutePathTestResources(resourcesPath).concat("\\").concat(fileName);
    }

}