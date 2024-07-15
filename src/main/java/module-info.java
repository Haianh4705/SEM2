module com.hung.do_an {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
    opens com.hung.do_an to javafx.fxml;
    exports com.hung.do_an;
}
