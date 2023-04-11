package org.example;

import org.example.wiseSaying.App;
import org.example.wiseSaying.Container;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Container.init();

        App app = new App();
        app.run();

        Container.close();
    }
}