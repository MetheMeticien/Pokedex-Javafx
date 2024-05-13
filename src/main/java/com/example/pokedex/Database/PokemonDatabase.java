package com.example.pokedex.Database;
import com.example.pokedex.models.Pokemon;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokemonDatabase {

    String tableName = "POKEMONDATA";

    List<String> pokemonNames = new ArrayList<>();


    public static void main(String[] args) throws SQLException {

        PokemonDatabase pokemons = new PokemonDatabase();
        pokemons.initialize();


        try{
            List<Pokemon> matching = pokemons.searchType("fire");
            for (Pokemon pokemon : matching) {
                String name =  pokemon.getName();
                List<String> moves = pokemon.getMoves();
                List<String> evols = pokemon.getNextEvolutions();

                System.out.println("Name: " + name);

//                for (String move : moves) {
//                    System.out.println("Move: " + move);
//                }
                System.out.println(moves);
                System.out.println(evols);
                for(String evol : evols) {
                    System.out.println("Evol: " + evol);
                }



            }



        }
        catch(SQLException e){
            e.printStackTrace();
        }


    }

    public void initialize() throws SQLException {
        fetchNames();


    }


    private Connection makeConnection() throws SQLException {
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/pokemons",
                    "root",
                    "password"
            );
            return connection;

        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet execute_query(String query) throws SQLException {
        Connection connection;
        try{
            connection = makeConnection();
        }
        catch(Exception e){
            connection = null;
            e.printStackTrace();
        }
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(query);

        return resultset;
    }


    public List<Pokemon> fetchAll() throws SQLException {
        List<Pokemon> pokemonList = new ArrayList<>();
        String query = "SELECT * FROM " + tableName;

        try{
            ResultSet resultSet = execute_query(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                Pokemon pokemon = new Pokemon();
                pokemon.mapResultSetToPokemon(resultSet);
                pokemonList.add(pokemon);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return pokemonList;
    }

    public void fetchNames() throws SQLException {
        String query = "SELECT Name FROM " + tableName;

        try{
            ResultSet resultSet = execute_query(query);
            ResultSetMetaData metaData = resultSet.getMetaData();

            while (resultSet.next()) {
                pokemonNames.add(resultSet.getString("Name"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }


    public Pokemon searchName(String name) throws SQLException {
        Pokemon pokemon = new Pokemon();
        String query = "SELECT * FROM " + tableName + " WHERE name = '" + name +"';";
//        System.out.println(query);
        try{
            ResultSet resultSet = execute_query(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                pokemon.mapResultSetToPokemon(resultSet);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return pokemon;
    }

    public List<Pokemon> searchPrefixDB(String name) throws SQLException {
        List<Pokemon> pokemonList = new ArrayList<>();

        String query = "SELECT * FROM " + tableName + " WHERE name like '" + name +"%';";

        System.out.println(query);
        try{
            ResultSet resultSet = execute_query(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                Pokemon pokemon = new Pokemon();
                pokemon.mapResultSetToPokemon(resultSet);
                pokemonList.add(pokemon);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return pokemonList;
    }

    public List<String> searchPrefix(String prefix) {
        List<String> matchingNames = new ArrayList<>();
        for (String name : pokemonNames) {
            if (name.toLowerCase().startsWith(prefix.toLowerCase())) {
                matchingNames.add(name);
            }
        }
        return matchingNames;
    }


    public List<Pokemon> searchType(String type) throws SQLException {
        List<Pokemon> pokemonList = new ArrayList<>();

        String query = "SELECT * FROM " + tableName + " WHERE types like '%" + type +"%';";

        System.out.println(query);
        try{
            ResultSet resultSet = execute_query(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                Pokemon pokemon = new Pokemon();
                pokemon.mapResultSetToPokemon(resultSet);
                pokemonList.add(pokemon);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return pokemonList;
    }
}
