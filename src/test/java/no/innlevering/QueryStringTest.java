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
        QueryString a = new QueryString("status=200&body=Hei");
        assertEquals("200", a.getParameter("status"));
    }
    @Test
    void returnParameterStatus404() {
        QueryString a = new QueryString("status=404&body=Hei");
        assertEquals("404", a.getParameter("status"));
    }

    @Test
    void returnBodyValue () {
        QueryString a = new QueryString("status=200&body=Hei");
        assertEquals("Hei", a.getParameter("body"));
    }

    @Test
    void returnBodyFromQueryString() {
        QueryString testQuery = new QueryString("status=200&body=hei");
       assertEquals("hei", testQuery.getParameter("body"));
    }
}
