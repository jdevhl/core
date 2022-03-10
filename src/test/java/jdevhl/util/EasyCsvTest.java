package jdevhl.util;

import jdevhl.common.ReadFiles;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EasyCsvTest {

    @Test
    public void readTest() throws FileNotFoundException {
        List<String[]> csvContent = EasyCsv.read(ReadFiles.getPath("file.csv"));
        assertEquals(3, csvContent.size());
    }

    @Test
    public void readWithSpaceTest() throws FileNotFoundException {
        List<String[]> csvContent = EasyCsv.read(ReadFiles.getPath("file_space.csv"), EasyCsv.SPACE_SEPARATOR);
        assertEquals(3, csvContent.size());
    }

    @Test
    public void readWithSemicolonTest() throws FileNotFoundException {
        List<String[]> csvContent = EasyCsv.read(ReadFiles.getPath("file_semicolon.csv"), EasyCsv.SEMICOLON_SEPARATOR);
        assertEquals(3, csvContent.size());
    }

}