import Model.BoatModel;
import Controller.BoatController;
import View.BoatView;
public class Main {
    public static void main(String args[])
    {
        BoatModel model = new BoatModel();
        BoatView view = new BoatView();
        BoatController controller = new BoatController(view, model);
        view.setVisible(true);
    }
}
