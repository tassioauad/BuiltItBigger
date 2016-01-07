package com.tassioauad.jokelib;

import junit.framework.TestCase;


public class JokerTest extends TestCase {

    public void testGetJoke() throws Exception {
        Joker joker = new Joker();
        assertNotNull(joker.getJoke());
    }
}