package guru.springframework.sfgdi.contollers;

import guru.springframework.sfgdi.services.ContructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetterInjectionedControllerTest {

    SetterInjectionedController controller;

    @BeforeEach
    void setUp() {
        controller = new SetterInjectionedController();

        controller.setGreetingService(new ContructorGreetingService());
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}