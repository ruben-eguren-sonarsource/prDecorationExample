package com.example.prdecoration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void greetingReturnsExpectedMessage() {
        assertEquals("Hello from prDecorationExample 2!", new App().greeting());
    }
}
