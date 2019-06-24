package myk.Javafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ListViewDemo extends Application {

    private javafx.scene.control.Label response;

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        launch(args);
    }

    @Override
    public void start(Stage myStage) {
        //start方法是运行在子线程中的（JavaFX Application Thread）
        System.out.println(Thread.currentThread().getName());
        myStage.setTitle("ListView Demo");

        //创建根节点
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        //创建场景
        Scene myScene = new Scene(rootNode, 300, 300);
        myStage.setScene(myScene);
        response = new Label("Select Computer Type");
        ObservableList<String> computerType = FXCollections.observableArrayList("SmartPhone", "Tablet", "NoteBook", "Desktop");
        ListView<String> lvComputer = new ListView<>(computerType);
        //listView 的size
        lvComputer.setPrefSize(100, 70);

        MultipleSelectionModel<String> lvSelModel = lvComputer.getSelectionModel();
        //添加事件监听
        lvSelModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            //oldValue为上一次被选中的值
            System.out.println("Computer selected oldValue " + oldValue);
            response.setText("Computer selected is " + newValue);
        });

        rootNode.getChildren().addAll(response, lvComputer);
        myStage.show();
    }
}
