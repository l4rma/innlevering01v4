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
        QueryString a = new QueryString("status=200");
        assertEquals("200", a.getParameter("status"));
    }
    @Test
    void returnParameterStatus404() {
        QueryString a = new QueryString("status=404");
        assertEquals("404", a.getParameter("status"));
    }

    @Test
    void returnBodyValue () {
        QueryString a = new QueryString("status=200&body=Hei");
        assertEquals("200", a.getParameter("status"));
    }

    @Test
    void returnBodyFromQueryString() {
        QueryString testQuery = new QueryString("status=200&body=hei");
       assertEquals("hei", testQuery.getParameter("body"));
    }

    @Test
    void addParameter() {
        QueryString q = new QueryString("status=200");
        // add "body=hei" test for body value = hei
        q.addParameter("body", "hei");
        assertEquals("hei", q.getParameter("body"));
    }
}
