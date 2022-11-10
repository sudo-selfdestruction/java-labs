package src;

import java.text.DecimalFormat;

public class Triangle{
    private int dotQty = 3;
    private Dot[] dots = new Dot[dotQty];
    private String triangleType;
    private double area;
    private double perimeter;
    private double edgeSizes[] = new double[3];
    private enum TriangleSides {
        AB,
        AC,
        BC,
    }

    public Triangle() {
        for(int i = 0; i < dotQty; i++) {
            dots[i] = new Dot((Math.random() * 9 + 1),
                              (Math.random() * 9 + 1));
        }
        edgeSizes[0] = calcEdge(dots[0], dots[1]);
        edgeSizes[1] = calcEdge(dots[0], dots[2]);
        edgeSizes[2] = calcEdge(dots[1], dots[2]);
        area = calcArea();
        perimeter = calcPerimeter();
        triangleType = typeChecker();
    }
    public Triangle(Dot dotOne, Dot dotTwo, Dot dotThree) {
        dots[0] = dotOne;
        dots[1] = dotTwo;
        dots[2] = dotThree;
        edgeSizes[0] = calcEdge(dots[0], dots[1]);
        edgeSizes[1] = calcEdge(dots[0], dots[2]);
        edgeSizes[2] = calcEdge(dots[1], dots[2]);
        area = calcArea();
        perimeter = calcPerimeter();
        triangleType = typeChecker();
    }
    public String getTriangleType() {
        return triangleType;
    }
    public double getArea() {
        return area;
    }
    public double getPerimeter(){
        return perimeter;
    }

    public double calcPerimeter() {
        double perimeter = 0;
        perimeter += edgeSizes[TriangleSides.AB.ordinal()] +
                     edgeSizes[TriangleSides.AC.ordinal()] +
                     edgeSizes[TriangleSides.BC.ordinal()];
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
    public String toString() {
        DecimalFormat dF = new DecimalFormat( "#.###" );
        return "1st dot: (" + dF.format(dots[0].getXPos()) + ", " + dF.format(dots[0].getYPos()) + ")\n" +
               "2nd dot: (" + dF.format(dots[1].getXPos()) + ", " + dF.format(dots[1].getYPos()) + ")\n" +
               "3rd dot: (" + dF.format(dots[2].getXPos()) + ", " + dF.format(dots[2].getYPos()) + ")\n" +
               "Perimeter: " + dF.format(perimeter) + "\n" +
               "Area: " + dF.format(area) + "\n" +
               "TriangleType: " + triangleType + ".\n";
    }
    public String typeChecker() {
        if(main.isEqual(edgeSizes[TriangleSides.AB.ordinal()],
                        edgeSizes[TriangleSides.BC.ordinal()]) &&
           main.isEqual(edgeSizes[TriangleSides.AC.ordinal()],
                        edgeSizes[TriangleSides.AB.ordinal()])) {
            return "equilateral triangle";
        }
        else if(main.isEqual(Math.pow(edgeSizes[TriangleSides.AB.ordinal()], 2) +
                             Math.pow(edgeSizes[TriangleSides.AC.ordinal()], 2),
                             Math.pow(edgeSizes[TriangleSides.BC.ordinal()], 2)) ||
                main.isEqual(Math.pow(edgeSizes[TriangleSides.AB.ordinal()], 2) +
                             Math.pow(edgeSizes[TriangleSides.BC.ordinal()], 2),
                             Math.pow(edgeSizes[TriangleSides.AC.ordinal()], 2)) ||
                main.isEqual(Math.pow(edgeSizes[TriangleSides.AC.ordinal()], 2) +
                             Math.pow(edgeSizes[TriangleSides.BC.ordinal()], 2),
                             Math.pow(edgeSizes[TriangleSides.AB.ordinal()], 2)))  {
            return "square corner triangle";
        }
        else if(main.isEqual(edgeSizes[TriangleSides.AB.ordinal()], edgeSizes[TriangleSides.AC.ordinal()]) ||
                main.isEqual(edgeSizes[TriangleSides.AB.ordinal()], edgeSizes[TriangleSides.BC.ordinal()]) ||
                main.isEqual(edgeSizes[TriangleSides.AC.ordinal()], edgeSizes[TriangleSides.BC.ordinal()])) {
            return "isosceles triangle";
        }
        else {
            return "arbitrary triangle";
        }
    }
}
