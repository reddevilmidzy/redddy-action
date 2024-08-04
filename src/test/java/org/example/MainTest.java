package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MainTest {

    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    void setUp() {
        System.setIn(new ByteArrayInputStream("1 2".getBytes())); //TODO 여기 input.txt 파일 불러오는 방식...?
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    String output() {
        return captor.toString().trim();
    }

    @Test
    @DisplayName("덧셈")
    void add() throws IOException {
        Main.main(new String[]{});
        assertEquals("3", output());
    }
}
