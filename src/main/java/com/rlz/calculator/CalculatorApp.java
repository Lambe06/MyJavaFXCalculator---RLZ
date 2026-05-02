package com.rlz.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Carica il file FXML che sta in resources/com/rlz/calculator/
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorApp.class.getResource("/com/rlz/calculator/interface.fxml"));
        // Sostituisci 350 e 500 con le dimensioni reali della tua calcolatrice
        Scene scene = new Scene(fxmlLoader.load(), 350, 500);

        stage.setTitle("MyCalculator 1.0 - RLZ");
        stage.setScene(scene);
        stage.setResizable(false); // Layout non modificabile
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}