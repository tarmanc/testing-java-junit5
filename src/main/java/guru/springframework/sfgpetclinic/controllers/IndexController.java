package guru.springframework.sfgpetclinic.controllers;

public class IndexController {

    public String index() {

        return "index";
    }

    public void oupsHandler() {
        throw new RuntimeException();
    }
}
