package no.innlevering;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueryStringTest {
    @Test
    void arbitraryTest() {
        assertEquals(1, 1);
    }

    @Test
    void returnParameterStatus200() {

        assertEquals("200", QueryString.getParameter("status","status=200"));
    }
    @Test
    void returnParameterStatus404() {

        assertEquals("404", QueryString.getParameter("status","status=404"));
    }

    @Test
    void returnBodyValue () {
        assertEquals("Hei", QueryString.getParameter("body", "status=200&body=Hei"));
    }

    // Skjønner du hva jeg prøver å få til?
    //@Test
    //void returnBodyfromQueryString() {
    //   assertEquals("hei", new QueryString("status=200&body=Hei").getParameter("status"));
    //}
}
