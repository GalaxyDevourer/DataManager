package chmnu.project.utils;

import javafx.scene.control.Alert;

public class MenuDisplayer {
    public void dialogWarningMessage(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
    }
}
