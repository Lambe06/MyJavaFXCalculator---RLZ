module com.rlz.calculator {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.rlz.calculator to javafx.fxml;
    exports com.rlz.calculator;
}