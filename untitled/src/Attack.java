public class Attack {

    // Attack info

    int speed;

    int power;

    // Constructors

    public Attack(int speed, int power) {
        this.speed = speed;
        this.power = power;
    }

    // setters

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setPower(int power) {
        this.power = power;
    }

    // getters

    public int getSpeed() {
        return speed;
    }

    public int getPower() {
        return power;
    }
}
