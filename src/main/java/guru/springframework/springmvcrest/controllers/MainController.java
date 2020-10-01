package guru.springframework.springmvcrest.controllers;

import guru.springframework.springmvcrest.services.WolfService;

public class MainController {
    protected final WolfService wolfService;

    public MainController(WolfService wolfService) {
        this.wolfService = wolfService;
    }
}
