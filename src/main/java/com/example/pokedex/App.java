package com.example.pokedex;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("views/dashboard.fxml"));
//        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("views/pokemonCard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1315, 810);
        stage.setTitle("Pokedex");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}