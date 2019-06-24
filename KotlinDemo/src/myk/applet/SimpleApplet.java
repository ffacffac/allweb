package myk.applet;

import java.applet.Applet;
import java.awt.*;

public class SimpleApplet extends Applet {

    //region 生命周期
    @Override
    public void init() {
        super.init();
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
    //endregion 生命周期

    //region私有方法

    //endregion 私有方法

    //region 重写方法@Override
    @Override
    public void paint(Graphics graphics) {
        graphics.drawString("Java makes applets easy.", 20, 20);
    }

    //endregion重写方法@Override
}
