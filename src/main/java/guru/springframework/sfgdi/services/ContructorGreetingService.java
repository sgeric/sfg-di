package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Service;

public class ContructorGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello world - Contructor";
    }
}
