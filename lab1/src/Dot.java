package src;

public class Dot {
    double xPos, yPos ;

    Dot(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void setXPos(double xPos) {
        xPos = this.xPos;
    }
    public void setYPos(double yPos) {
        yPos = this.yPos;
    }
    public double getXPos() {
        return this.xPos;
    }
    public double getYPos() {
        return this.yPos;
    }
}
