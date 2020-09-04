package no.innlevering;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueryStringTest {

    @Test
    void arbitraryTest() {
        assertEquals(1, 1);
    }

    @Test
    void returnParmeterStatus200() {
        assertEquals("200", QueryString.getParameter("Status"));
    }

    @Test
    void retunParameterStatus404(){
        assertEquals("404", QueryString.getParameter("Status"));
    }
}
