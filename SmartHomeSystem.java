
interface Device {
    void turnOn();
    void turnOff();
    void setTimer(int minutes);
}


class Light implements Device {
    public void turnOn() { System.out.println("Light ON"); }
    public void turnOff() { System.out.println("Light OFF"); }
    public void setTimer(int minutes) {
        System.out.println("Light will turn off after " + minutes + " minutes");
    }
}


class Fan implements Device {
    public void turnOn() { System.out.println("Fan ON"); }
    public void turnOff() { System.out.println("Fan OFF"); }
    public void setTimer(int minutes) {
        System.out.println("Fan will stop after " + minutes + " minutes");
    }
}


class Thermostat implements Device {
    public void turnOn() { System.out.println("Thermostat ON"); }
    public void turnOff() { System.out.println("Thermostat OFF"); }
    public void setTimer(int minutes) {
        System.out.println("Thermostat running for " + minutes + " minutes");
    }
}


class DoorLock implements Device {
    public void turnOn() { System.out.println("Door Locked"); }
    public void turnOff() { System.out.println("Door Unlocked"); }
    public void setTimer(int minutes) {
        System.out.println("Door auto-lock after " + minutes + " minutes");
    }
}


class SmartHub {

    Light light;
    Fan fan;
    Thermostat thermostat;
    DoorLock door;

    public void registerDevices(Light l, Fan f, Thermostat t, DoorLock d) {
        light = l;
        fan = f;
        thermostat = t;
        door = d;
    }

    public void turnOnAll() {
        light.turnOn();
        fan.turnOn();
        thermostat.turnOn();
        door.turnOn();
    }

    public void turnOffAll() {
        light.turnOff();
        fan.turnOff();
        thermostat.turnOff();
        door.turnOff();
    }

    public void setTimerAll(int minutes) {
        light.setTimer(minutes);
        fan.setTimer(minutes);
        thermostat.setTimer(minutes);
        door.setTimer(minutes);
    }
}


public class SmartHomeSystem {
    public static void main(String[] args) {

        SmartHub hub = new SmartHub();

        Light light = new Light();
        Fan fan = new Fan();
        Thermostat thermostat = new Thermostat();
        DoorLock door = new DoorLock();

        hub.registerDevices(light, fan, thermostat, door);

        hub.turnOnAll();
        hub.setTimerAll(10);
        hub.turnOffAll();
    }
}