package Model;

public class BoatModel {
    private int speed = 0;
    private String direction = "";
    private String state = "";
    private static final String STOP = "Stop";
    private static final String START = "Start";
    private static final String NORTH = "North";
    private static final String SOUTH = "South";
    private static final String EAST = "East";
    private static final String WEST = "West";
    private static final String REFILL = "Refill";
    private int fuelConsumptionTime = 0;
    private int fuel = 0;
    private static final int DISTANCE = 100;
    private double velocity = 0;
    
    private void setSpeed(int speed)
    {
        this.speed = speed;
    }
    
    public int getSpeed()
    {
        return speed;
    }
    
    private void setDirection(String direction)
    {
        this.direction = direction;
    }
    
    public String getDirection()
    {
        return direction;
    }
    
    public int getFuelConsumptionTime()
    {
        return fuelConsumptionTime;
    }
    
    public void setFuelConsumptionTime(int fuelConsumptionTime)
    {
        this.fuelConsumptionTime = fuelConsumptionTime;
    }
    
    public int getFuel()
    {
        return fuel;
    }
    
    public void setFuel(int fuel)
    {
        this.fuel = fuel;
    }
    
    private void setVelocity(double time)
    {
        velocity = DISTANCE / (time/1000);
    }
    
    public double getVelocity()
    {
        return velocity;
    }
    
    public boolean start()
    {
        if(state == "" || state == STOP && fuel>0)
        {
            setSpeed(0);
            setDirection(NORTH);
            state = START;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean stop()
    {
        if(state == START)
        {
            state = STOP;
            setSpeed(0);
            setDirection("Not Set");
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void fuelConsumptionLevels()
    {
        if(getSpeed()==110)
        {
            setFuelConsumptionTime(1000);
            setVelocity(getFuelConsumptionTime());
        }
        if(getSpeed()==100)
        {
            setFuelConsumptionTime(1500);
            setVelocity(getFuelConsumptionTime());
        }
        if(getSpeed()==90)
        {
            setFuelConsumptionTime(2000);
            setVelocity(getFuelConsumptionTime());
        }
        if(getSpeed()==80)
        {
            setFuelConsumptionTime(2500);
            setVelocity(getFuelConsumptionTime());
        }
        if(getSpeed()==70)
        {
            setFuelConsumptionTime(3000);
            setVelocity(getFuelConsumptionTime());
        }
        if(getSpeed()==60)
        {
            setFuelConsumptionTime(3500);
            setVelocity(getFuelConsumptionTime());
        }
        if(getSpeed()==50)
        {
            setFuelConsumptionTime(4000);
            setVelocity(getFuelConsumptionTime());
        }
        if(getSpeed()==40)
        {
            setFuelConsumptionTime(4500);
            setVelocity(getFuelConsumptionTime());
        }
        if(getSpeed()==30)
        {
            setFuelConsumptionTime(5000);
            setVelocity(getFuelConsumptionTime());
        }
        if(getSpeed()==20)
        {
            setFuelConsumptionTime(5500);
            setVelocity(getFuelConsumptionTime());
        }
        if(getSpeed()==10)
        {
            setFuelConsumptionTime(6000);
            setVelocity(getFuelConsumptionTime());
        }
    }
    
    public boolean IncreaseSpeed(int value)
    {
        if(state == START || state == REFILL)
        {
            setSpeed(speed + value);
            if(getSpeed()>=120)
            {
                setSpeed(0);
            }
            fuelConsumptionLevels();
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean DecreaseSpeed(int value)
    {
        if(state == START || state == REFILL)
        {
            if(value <= getSpeed())
            {
                setSpeed(speed - value);
                fuelConsumptionLevels();
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    
    public boolean Refill()
    {
        if(getFuel() < 100)
        {
            setSpeed(0);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean North()
    {
        if(state == START)
        {
            setDirection(NORTH);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean South()
    {
        if(state == START)
        {
            setDirection(SOUTH);
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    public boolean East()
    {
        if(state == START)
        {
            setDirection(EAST);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean West()
    {
        if(state == START)
        {
            setDirection(WEST);
            return true;
        }
        else
        {
            return false;
        }
    }
}
