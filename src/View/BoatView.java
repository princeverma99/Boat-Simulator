package View;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.border.Border;
public class BoatView extends JFrame{
    private JLabel lblSpeed = new JLabel("Speed is : 0km/h", SwingConstants.CENTER);
    private JLabel lblState = new JLabel("Boat is Ready to Start", SwingConstants.CENTER);
    private JLabel lblDirection = new JLabel("Direction : Not Set", SwingConstants.CENTER);
    private JButton btnStart = new JButton("Start");
    private JButton btnStop = new JButton("Stop");
    private JButton btnIncreaseSpeed = new JButton("Increase Speed");
    private JButton btnDecreaseSpeed = new JButton("Decrease Speed");
    private JLabel lblDirectionInfo = new JLabel("Change Direction : ", SwingConstants.CENTER);
    private JButton btnNorth = new JButton("North");
    private JButton btnSouth = new JButton("South");
    private JButton btnEast = new JButton("East");
    private JButton btnWest = new JButton("West");
    private JLabel lblFuelCapacity = new JLabel("Fuel Capacity : 20 Litres", SwingConstants.CENTER);
    private JLabel lblFuelLevel = new JLabel("Fuel Level : 100%", SwingConstants.CENTER);
    private JButton btnRefuel = new JButton("Shore Arrived - Refill Fuel");
    private JButton btnExit = new JButton("Exit Application");
    private JLabel lblVelocity = new JLabel("Velocity : 0m/s", SwingConstants.CENTER);
    private static DecimalFormat df = new DecimalFormat("0.00");
    public BoatView()
    {
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350,800);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
        lblState.setBorder(border);
        panel.add(lblSpeed);
        panel.add(lblState);
        panel.add(lblDirection);
        panel.add(lblFuelLevel);
        panel.add(lblFuelCapacity);
        panel.add(lblVelocity);
        panel.add(btnStart);
        panel.add(btnIncreaseSpeed);
        panel.add(btnDecreaseSpeed);
        panel.add(lblDirectionInfo);
        panel.add(btnNorth);
        panel.add(btnSouth);
        panel.add(btnEast);
        panel.add(btnWest);
        panel.add(btnRefuel);
        panel.add(btnStop);
        panel.add(btnExit);
        btnStart.setPreferredSize(new Dimension(40, 40));
        btnStop.setPreferredSize(new Dimension(40, 40));
        panel.setLayout(new GridLayout(17,1,20,10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        this.add(panel);
    }
    
    public void setSpeed(int speed)
    {
        lblSpeed.setText("Speed is : " + Integer.toString(speed) + "km/h");
    }
    
    public void setDirection(String direction)
    {
        lblDirection.setText("Direction : " + direction);
    }
    
    public void displayWarning(String warning)
    {
        JOptionPane.showMessageDialog(this, warning);
    }
    
    public void displayState(String state)
    {
        lblState.setText(state);
    }
    
    public void displayFuelLevel(int fuel)
    {
        lblFuelLevel.setText("Fuel Level : " + Integer.toString(fuel) + "%");
    }
    
    public void activateRefuel(boolean state)
    {
        btnRefuel.setEnabled(state);
    }
    
    public void setVelocity(double velocity)
    {
        lblVelocity.setText("Velocity : " + df.format(velocity) + "m/s");
    }
    
    public void btnStartListener(ActionListener listenforStart)
    {
        btnStart.addActionListener(listenforStart);
    }
    
    public void btnStopListener(ActionListener listenforStop)
    {
        btnStop.addActionListener(listenforStop);
    }
    
    public void btnIncreaseSpeedListener(ActionListener listenforIncrease)
    {
        btnIncreaseSpeed.addActionListener(listenforIncrease);
    }
    
    public void btnDecreaseSpeedListener(ActionListener listerforDecrease)
    {
        btnDecreaseSpeed.addActionListener(listerforDecrease);
    }
    
    public void btnNorthListener(ActionListener listenforNorth)
    {
        btnNorth.addActionListener(listenforNorth);
    }
    
    public void btnSouthListener(ActionListener listenforSouth)
    {
        btnSouth.addActionListener(listenforSouth);
    }
        
    public void btnEastListener(ActionListener listenforEast)
    {
        btnEast.addActionListener(listenforEast);
    }
            
    public void btnWestListener(ActionListener listenforWest)
    {
        btnWest.addActionListener(listenforWest);
    }
    
    public void btnRefuel(ActionListener listenforRefuel)
    {
        btnRefuel.addActionListener(listenforRefuel);
    }
    
    public void btnExit(ActionListener listerforExit)
    {
        btnExit.addActionListener(listerforExit);
    }
}
