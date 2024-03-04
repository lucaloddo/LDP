package it.unimib.easydefence.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MainControllerTest {

    @InjectMocks
    MainController mainController;

    @Test
    void testHomeBeforeDetect() {
        assertEquals("homeBeforeDetect", mainController.homeBeforeDetect());
    }
}