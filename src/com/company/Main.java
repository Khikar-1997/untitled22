package com.company;

import com.company.controller.MovieController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        MovieController movieController = new MovieController();
        movieController.printMenu();

    }
}

