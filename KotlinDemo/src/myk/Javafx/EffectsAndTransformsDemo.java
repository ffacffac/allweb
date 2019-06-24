package myk.Javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.FlowPane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class EffectsAndTransformsDemo extends Application {

    //region 成员变量
    private double angle = 0.0;
    private double scaleFactor = 1.0;
    private double blurVal = 1.0;

    private Reflection reflection = new Reflection();
    /**
     * 设置模糊效果
     * width和height：指定模糊区域的大小，0~255内
     * iterations：模糊次数，0~3
     */
    private BoxBlur blur = new BoxBlur(1.0, 1.0, 1);
    private Rotate rotate = new Rotate();
    private Scale scale = new Scale(scaleFactor, scaleFactor);

    private Button btnRotate = new Button("Rotate");
    private Button btnBlur = new Button("Blur off");
    private Button btnScale = new Button("Scale");
    private Label reflect = new Label("Reflection Adds Visual Sparkle");
    //endregion

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage myStage) {
        myStage.setTitle("Effects and Transforms Demo");

        FlowPane rootNode = new FlowPane(20, 20);
        rootNode.setAlignment(Pos.CENTER);

        Scene scene = new Scene(rootNode, 300, 120);
        myStage.setScene(scene);
        //添加旋转效果
        btnRotate.getTransforms().add(rotate);
        //添加缩放效果
        btnScale.getTransforms().add(scale);

        //为 reflect（Label）标签设置倒影效果
        //设置顶部的不透明度
        reflection.setTopOpacity(0.7);
        //设置底部的不透明度
        reflection.setBottomOpacity(0.3);
        reflect.setEffect(reflection);

        btnRotate.setOnAction(ae -> {
            angle += 15.0;
            rotate.setAngle(angle);
            rotate.setPivotX(btnRotate.getWidth() / 2);
            rotate.setPivotY(btnRotate.getHeight() / 2);
        });
        btnScale.setOnAction(ae -> {
            scaleFactor += 0.1;
            if (scaleFactor > 2.0) scaleFactor = 1.0;
            scale.setX(scaleFactor);
            scale.setY(scaleFactor);
        });
        btnBlur.setOnAction(as -> {
            if (blurVal == 10.0) {
                blurVal = 1.0;
                //删除btnBlur的模糊效果
                btnBlur.setEffect(null);
                btnBlur.setText("Blur off");
            } else {
                blurVal++;
                //模糊效果
                btnBlur.setEffect(blur);
                btnBlur.setText("Blur on");
            }
            blur.setWidth(blurVal);
            blur.setHeight(blurVal);
        });
        rootNode.getChildren().addAll(btnRotate, btnScale, btnBlur, reflect);
        myStage.show();
    }
}
