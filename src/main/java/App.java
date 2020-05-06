import java.awt.*;

class App extends Frame {
    App() {
        this.setTitle("Kursach");
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setVisible(true);

        addWindowListener(new MyWindowAdapter());
    }

    void start() {
    }
}
//TODO: solve 100% problem
//TODO: add interface Paintable
//TODO: refactor method paint() in Column class