package src;

import java.util.Arrays;
import java.text.DecimalFormat;

public class Triangle{
    public int dotQty = 3;
    public Dot[] dots = new Dot[dotQty];

    public Triangle() {
        for(int i = 0; i < dotQty; i++) {
            dots[i] = new Dot((Math.random() * 9 + 1),
                              (Math.random() * 9 + 1));
        }
    }

    public double calcPerimeter() {
        double perimeter = 0;
        perimeter += calcEdge(dots[0], dots[1]) +
                calcEdge(dots[1], dots[2]) +
                calcEdge(dots[0], dots[2]);
        return perimeter;
    }
    public double calcEdge(Dot dot1, Dot dot2) {
        double edge = 0;
        edge += Math.sqrt(Math.pow(dot1.getXPos() - dot2.getXPos(), 2) +
                    Math.pow(dot1.getYPos() - dot2.getYPos(), 2));
        return edge;
    }
    public double calcArea() {
        double area = 0;
        double semiPerim = calcPerimeter() / 2;
        area += Math.sqrt(semiPerim * (semiPerim - calcEdge(dots[0], dots[1])) *
                     (semiPerim - calcEdge(dots[1], dots[2])) *
                     (semiPerim - calcEdge(dots[0], dots[2]))
        );
        return area;
    }
    public void triangleOutPut() {
        DecimalFormat dF = new DecimalFormat( "#.###" );
        System.out.println(
                "1st dot: " + dF.format(dots[0].getXPos()) + " " + dF.format(dots[0].getYPos()) + "\n" +
                "2nd dot: " + dF.format(dots[1].getXPos()) + " " + dF.format(dots[1].getYPos()) + "\n" +
                "3rd dot: " + dF.format(dots[2].getXPos()) + " " + dF.format(dots[2].getYPos()) + "\n" +
                "Perimeter: " + dF.format(calcPerimeter()) + "\n" +
                "Area: " + dF.format(calcArea())
        );
    }
}
