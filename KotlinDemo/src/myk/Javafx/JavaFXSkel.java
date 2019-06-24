package myk.Javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class JavaFXSkel extends Application {


    public static void main(String[] args) {
        //启动程序
        launch(args);
    }

    //region 生命周期

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("JavaFXSkel.init");
    }

    @Override
    public void start(Stage myStage) {
        System.out.println("JavaFXSkel.start");
        myStage.setTitle("JavaFX Skeleton");

        //创建根节点，参数：两个元素之间的垂直和水平间隙，不然两个元素会紧紧挨着
        FlowPane rootNode = new FlowPane(10, 10);
        //指定元素对其方式
        rootNode.setAlignment(Pos.CENTER);
        //创建场景
        Scene myScene = new Scene(rootNode, 200, 200);
        //设置舞台场景
        myStage.setScene(myScene);

        //添加Label展示区域
        Label label = new Label("JavaFx is a powerful GUI");
        //将标签添加到场景中
        rootNode.getChildren().add(label);

        //添加Button
        Button btnDown = new Button("Down");
        Button btnUp = new Button("Up");
        btnDown.setOnAction(event -> System.out.println("Click Down"));
        btnUp.setOnAction(event -> System.out.println("Click Up"));
        rootNode.getChildren().add(btnDown);
        rootNode.getChildren().add(btnUp);

        //添加文本
        TextField tf = new TextField();
        //设置提示语
        tf.setPromptText("Please Enter text!");
        //设置列宽
        tf.setPrefColumnCount(10);
        tf.setOnAction(event -> System.out.println("text is ==" + tf.getText()));
        rootNode.getChildren().add(tf);

        //显示场景
        myStage.show();
    }

    @Override
    public void stop() {
        System.out.println("JavaFXSkel.stop");
    }
    //endregion
}
