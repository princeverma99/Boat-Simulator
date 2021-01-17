package Controller;
import Model.BoatModel;
import View.BoatView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
public class BoatController {
    private BoatModel model;
    private BoatView view;
    
    public BoatController(BoatView view, BoatModel model)
    {
        this.view = view;
        this.model = model;
        this.view.btnStartListener(new StartListener());
        this.view.btnStopListener(new StopListener());
        this.view.btnIncreaseSpeedListener(new IncreaseSpeedListener());
        this.view.btnDecreaseSpeedListener(new DecreaseSpeedListener());
        this.view.btnNorthListener(new NorthListener());
        this.view.btnSouthListener(new SouthListener());
        this.view.btnEastListener(new EastListener());
        this.view.btnWestListener(new WestListener());
        this.view.btnRefuel(new RefuelListener());
        this.view.btnExit(new ExitListener());
    }
    int fuelConsumptionTime = 1000;
    int fuel = 100;
    Timer fuelLevel = new Timer(fuelConsumptionTime, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    view.displayFuelLevel(fuel);
                    if(fuel == 0)
                    {
                        StopListener stop = new StopListener();
                        stop.actionPerformed(e);
                        view.displayState("Boat has Stopped");
                        model.setFuel(fuel);
                    }
                    else
                    {
                        fuel--;
                        model.setFuel(fuel);
                    }
                }
            });
    int counter = 0;
    Timer Refuel = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(counter <10)
            {
                view.activateRefuel(false);
            }
            else if(counter>10)
            {
                view.activateRefuel(true);
                if(counter == 15)
                {
                    counter = 0;
                }
            }
            counter++;
        }
    });
    
    class StartListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(model.start())
            {
                view.setSpeed(model.getSpeed());
                view.displayState("Boat Started");
                view.setDirection(model.getDirection());
                model.setFuel(fuel);
            }
            else
            {
                if(model.getFuel() == 0)
                {
                    view.displayWarning("Fuel is Empty, Boat Cannot be Started");
                }
                else
                {
                    view.displayWarning("Boat Cannot be Started");
                }
            }
        }
    }
    
    class StopListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(model.stop())
            {
                view.setSpeed(model.getSpeed());
                view.displayState("Boat Stopped");
                view.setDirection(model.getDirection());
                fuelLevel.stop();
                Refuel.stop();
                view.setVelocity(0);
            }
            else
            {
                view.displayWarning("Boat Cannot be Stopped");
            }
        }
        
    }
    
    class IncreaseSpeedListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(model.IncreaseSpeed(10))
            {
                if(model.getSpeed()>=100)
                {
                    view.displayWarning("Dangeroud Speed");
                }
                if(model.getSpeed() == 0)
                {
                    view.displayWarning("Boat Capsized and sink");
                    System.exit(0);
                }
                view.setSpeed(model.getSpeed());
                view.displayState("Speed Increased");
                fuelConsumptionTime = model.getFuelConsumptionTime();
                view.setVelocity(model.getVelocity());
                fuelLevel.stop();
                fuelLevel.setDelay(fuelConsumptionTime);
                fuelLevel.start();
                Refuel.start();
            }
            else
            {
                view.displayWarning("Speed cannot be Increased");
            }
        }
    }
    
    class DecreaseSpeedListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(model.DecreaseSpeed(10))
            {
                view.setSpeed(model.getSpeed());
                view.displayState("Speed Decrease");
                fuelConsumptionTime = model.getFuelConsumptionTime();
                view.setVelocity(model.getVelocity());
                fuelLevel.stop();
                fuelLevel.setDelay(fuelConsumptionTime);
                fuelLevel.start();
                if(model.getSpeed() == 0)
                {
                    //model.Stop();
                    StopListener stop = new StopListener();
                    stop.actionPerformed(e);
                    view.displayState("Boat has Stopped");
                    view.setDirection(model.getDirection());
                }
            }
            else
            {
                view.displayWarning("Speed cannot be Decreased");
            }
        }
    }
    
    class NorthListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(model.North())
            {
                view.setDirection(model.getDirection());
                view.displayState("Going in North Direction");
            }
            else
            {
                view.displayWarning("Direction cannot be changed");
            }
        }
    }
    
    class SouthListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(model.South())
            {
                view.setDirection(model.getDirection());
                view.displayState("Going in South Direction");
            }
            else
            {
                view.displayWarning("Direction cannot be changed");
            }
        }
    }
    
    class EastListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(model.East())
            {
                view.setDirection(model.getDirection());
                view.displayState("Going in East Direction");
            }
            else
            {
                view.displayWarning("Direction cannot be changed");
            }
        }
    }
    
    class WestListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(model.West())
            {
                view.setDirection(model.getDirection());
                view.displayState("Going in West Direction");
            }
            else
            {
                view.displayWarning("Direction cannot be changed");
            }
        }
    }
    
    class RefuelListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(model.Refill())
            {
                fuel = 100;
                view.displayFuelLevel(fuel);
                view.setSpeed(model.getSpeed());
                StopListener stop = new StopListener();
                stop.actionPerformed(e);
                view.displayState("Boat Stopped to Refill Fuel");
            }
            else
            {
                view.displayWarning("Fuel is already Full");
            }
        }
    }
    
    class ExitListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
