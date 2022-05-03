package main;

import java.util.Observable;

import domain.Person;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		
		Application.launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		
		// создаём список объектов
		ObservableList<Person> people = FXCollections.observableArrayList(
				
				new Person("Tom", 25),
				new Person("Nick", 35),
				new Person("Andy", 45)
				);
		
		Label label = new Label();
		
		// определяем таблицу и устанавливаем данные
		TableView<Person> table = new TableView<Person>(people);
		table.setPrefHeight(200);
		table.setPrefWidth(250);
		
		///////// Name /////////////
		// столбец для вывода имени
		TableColumn<Person, String> nameColumn = new TableColumn<Person, String>("Name");
		// определяем фабрику для столбца с привязкой к свойству name
		nameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
		// добавляем столбец 
		table.getColumns().add(nameColumn);
		
		///////// Age /////////////
		// столбец для вывода имени
		TableColumn<Person, Integer> ageColumn = new TableColumn<Person, Integer>("Age");
		// определяем фабрику для столбца с привязкой к свойству age
		ageColumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));
		// добавляем столбец
		table.getColumns().add(ageColumn);
		
		TableView.TableViewSelectionModel<Person> selectionModel = table.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(new ChangeListener<Person>(){
             
            public void changed(ObservableValue<? extends Person> val, Person oldVal, Person newVal){
                if(newVal != null) label.setText("Selected: " + newVal.getName());
            }
        });
		
        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, label, table);
		
		Scene scene = new Scene(root, 300, 250);
		
		stage.setScene(scene);
		stage.setTitle("Table in JavaFX");
		stage.show();
	}

}
