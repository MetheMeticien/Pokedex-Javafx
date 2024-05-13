package com.example.pokedex.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DashboardController {

    @FXML
    private Button favButton;

    @FXML
    private HBox largePokemonCard;

    @FXML
    private GridPane pokemonGrid;

    @FXML
    private VBox pokemonName;

    @FXML
    private ScrollPane pokemonScroll;

    @FXML
    private TextArea searchBox;

    @FXML
    private Button searchButton;

    @FXML
    private HBox titleBox;

    @FXML
    private Label titleLabel;

}
