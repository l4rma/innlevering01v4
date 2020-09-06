package no.innlevering;

import org.junit.jupiter.api.Test;

import javax.management.Query;
import javax.management.QueryExp;

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

    @Test
    void addingMultipleParameters() {
        QueryString q = new QueryString("status=200");
        q.addParameter("body", "hei");
        q.addParameter("para", "dududu");
        assertEquals("dududu", q.getParameter("para"));
    }

    @Test
    void getQueryStringAsString() {
        QueryString q = new QueryString("status=500&body=Hello");
        assertEquals("status=500&body=Hello", q.getQueryString());
    }

    @Test
    void getParameterSpace() {
        QueryString q = new QueryString("body=Hello%20world!");
        assertEquals("Hello world!", q.getParameter("body"));
    }

    @Test
    void returnParameterNonCaseSensitive() {
        QueryString q = new QueryString("status=666");
        assertEquals("666", q.getParameter("sTaTuS"));
    }

    @Test
    void addParameterTilTomQueryString() {
        QueryString q = new QueryString();
        q.addParameter("status", "200");
        assertEquals("200", q.getParameter("status"));

    }

    @Test
    void handleÆØÅ() {
        // skjønner ikke helt hva oppgaven ber om her,
        // men tolker det som at "aa" = "å", "oe" = "ø" og "ae" = "æ"
        QueryString q = new QueryString("status=301&body=det%20er%20låv%20å%20bruke%20æøå");
        assertEquals("det er låv å bruke æøå", q.getParameter("body"));
    }
}
