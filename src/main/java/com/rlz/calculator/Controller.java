package com.rlz.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField display; 

    private double numero1 = 0;
    private String operatore = "";
    private boolean inizioNuovoNumero = true;

    @FXML
    protected void onNumberClicked(ActionEvent event) {
        String valore = ((Button)event.getSource()).getText();

        if (inizioNuovoNumero) {
            display.setText(valore);
            inizioNuovoNumero = false;
        } else {
            display.setText(display.getText() + valore);
        }
    }

    @FXML
    protected void onOperatorClicked(ActionEvent event) {
        String testoDisplay = display.getText();
        if (!testoDisplay.isEmpty() && !testoDisplay.equals("Errore")) {
            try {
                numero1 = Double.parseDouble(testoDisplay);
                operatore = ((Button)event.getSource()).getText();
                inizioNuovoNumero = true;
            } catch (NumberFormatException e) {
                display.setText("Errore");
            }
        }
    }

    @FXML
    protected void onEqualsClicked(ActionEvent event) {
        if (operatore.isEmpty() || display.getText().isEmpty() || display.getText().equals("Errore")) return;

        try {
            double numero2 = Double.parseDouble(display.getText());
            double risultato = 0;

            switch (operatore) {
                case "+" -> risultato = numero1 + numero2;
                case "-" -> risultato = numero1 - numero2;
                case "*" -> risultato = numero1 * numero2;
                case "/" -> {
                    if (numero2 != 0) { 
                        risultato = numero1 / numero2;
                    } else {
                        display.setText("Errore");
                        inizioNuovoNumero = true;
                        return;
                    }
                }
            }

            if (risultato == (long) risultato) {
                display.setText(String.format("%d", (long) risultato));
            } else {
                display.setText(String.valueOf(risultato));
            }

            operatore = "";
            inizioNuovoNumero = true;

        } catch (NumberFormatException e) {
            display.setText("Errore");
        }
    }

    @FXML
    protected void onClearClicked(ActionEvent event) {
        display.clear();
        numero1 = 0;
        operatore = "";
        inizioNuovoNumero = true;
    }

    @FXML
    protected void onDeleteClicked(ActionEvent event) {
        String testo = display.getText();
        if (!testo.isEmpty() && !testo.equals("Errore")) {
            display.setText(testo.substring(0, testo.length() - 1));
        }
    }
}
