package com.example.task5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class HelloController {

    public TextField resultField;
    @FXML
    private Button btnSearchQueue;

    @FXML
    private Button btnView;

    @FXML
    private TableColumn<PassengerCons, String> firstNametbl1;

    @FXML
    private TableColumn<PassengerCons, Integer> litres;

    @FXML
    private TableView<PassengerCons> pump1;

    @FXML
    private TableColumn<PassengerCons, Integer> pumpNumtbl1;

    @FXML
    private TextField searchField;

    @FXML
    private TableColumn<PassengerCons, String> secondName;

    @FXML
    private TableColumn<PassengerCons, String> vehicleNum;

    @FXML
    public void showPassengerTable(){
        showPassenger();
    }


    public Connection getConnection(){
        Connection con;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuel_queue_management_system", "root", "SeniruHasith");
            return con;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void getSearchedValues(){
        //creating db connection
        //waiting list update
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        Connection con;
        try{
            String firstName = null;
            String secondName = null;
            String vehicleNum = null;
            int litres;
            int pumpNum;
            ResultSet rs;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuel_queue_management_system", "root", "Vinujawedamulla2001");
            String sql= "SELECT * FROM customer  WHERE `firstName` = '"+ searchField.getText() +"' ";
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                firstName = rs.getString("firstName");
                secondName = rs.getString("secondName");
                vehicleNum = rs.getString("vehicleNum");
                litres = rs.getInt("liter_count");
                pumpNum = rs.getInt("pump_num");
                resultField.setText(firstName+ " " + secondName + " / "+ vehicleNum+ " / "+ pumpNum+ " / "+litres );
            }
            con.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public ObservableList<PassengerCons> getPassengerList(){
        ObservableList<PassengerCons> passengers = FXCollections.observableArrayList();
        Connection con = getConnection();
        String sql = "SELECT * FROM customer";
        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            PassengerCons passenger;
            while (rs.next()){
                passenger = new PassengerCons(rs.getString("firstName"),
                        rs.getString("secondName"),rs.getString("vehicleNum"),
                        rs.getInt("liter_count"),rs.getInt("pump_num"));
                passengers.add(passenger);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return passengers;
    }

    public void showPassenger(){
        ObservableList<PassengerCons> passengerConsObservableList = getPassengerList();
        firstNametbl1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        secondName.setCellValueFactory(new PropertyValueFactory<>("secondName"));
        vehicleNum.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        litres.setCellValueFactory(new PropertyValueFactory<>("numOfLitresReq"));
        pumpNumtbl1.setCellValueFactory(new PropertyValueFactory<>("pumpNum"));

        pump1.setItems(passengerConsObservableList);
    }

}