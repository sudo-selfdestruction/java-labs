package src;

import java.util.ArrayList;

public class main {
    public static void main (String[] args) {
        Triangle triangles[] = new Triangle[8];
        for(int i = 0; i < 8; i++) {
            triangles[i] = new Triangle();
            System.out.println(triangles[i].toString());
        }
        ArrayList<Triangle> threeEqualSides = new ArrayList<>();
        ArrayList<Triangle> twoEqualSides = new ArrayList<>();
        ArrayList<Triangle> squareCorners = new ArrayList<>();
        ArrayList<Triangle> others = new ArrayList<>();
        Dot dotOne = new Dot(0, 1);
        Dot dotTwo = new Dot(1, 0);
        Dot dotThree = new Dot(0, 0);
        Triangle squareCorner = new Triangle(dotOne, dotTwo, dotThree);
        System.out.println(squareCorner.toString());
        for(int i = 0; i < 8; i++) {
            if(triangles[i].getTriangleType() == "equilateral triangle") {
                threeEqualSides.add(triangles[i]);
            }
            else if(triangles[i].getTriangleType() ==
                    "square corner triangle") {
                twoEqualSides.add(triangles[i]);
            }
            else if(triangles[i].getTriangleType() ==
                    "isosceles triangle") {
                squareCorners.add(triangles[i]);
            }
            else {
                others.add(triangles[i]);
            }
        }
        System.out.println("\nThe minimal arrea of arbitrary triangles is: " +
                           others.get(minAreaFinder(others)).getArea() +
                           "\n\nThis triangle specs:\n\n" +
                           others.get(minAreaFinder(others)).toString());
    }
    public static boolean isEqual(double x, double y){
        final double EPS = 1e-9;
        return Math.abs(x-y) < EPS;
    }
    public static int minAreaFinder(ArrayList<Triangle> someTypeTriangle) {
        double minArea = someTypeTriangle.get(0).getArea();
        int tempIter = 0;
        for(int i = 0; i < someTypeTriangle.size(); i++) {
            if(someTypeTriangle.get(i).getArea() < minArea) {
                minArea = someTypeTriangle.get(i).getArea();
                tempIter = i;
            }
        }
        return tempIter;
    }
}
