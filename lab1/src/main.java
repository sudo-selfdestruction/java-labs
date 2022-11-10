package src;

import java.util.ArrayList;

public class main {
    public static void main (String[] args) {
        Triangle triangles[] = new Triangle[8];
        for(int i = 0; i < 8; i++) {
            triangles[i] = new Triangle();
            triangles[i].triangleOutPut();
        }
        ArrayList<Triangle> threeEqualSides = new ArrayList<>();
        ArrayList<Triangle> twoEqualSides = new ArrayList<>();
        ArrayList<Triangle> squareCorners = new ArrayList<>();
        ArrayList<Triangle> others = new ArrayList<>();
        Dot dot1 = new Dot(0, 1);
        Dot dot2 = new Dot(1, 0);
        Dot dot3 = new Dot(0, 0);
        Triangle squareCorner = new Triangle(dot1, dot2, dot3);
        for(int i = 0; i < 8; i++) {
            if(triangles[i].getTriangleType() == 1) {
                threeEqualSides.add(triangle[i]);
            }
            else if(triangles[i].getTriangleType() == 2) {
                twoEqualSides.add(triangle[i]);
            }
            else if(triangles[i].getTriangleType() == 3) {
                squareCorners.add(triangle[i]);
            }
            else {
                other.add(triangle[i]);
            }
        }
        
    }
    public static boolean isEqual(double x, double y){
        final double EPS = 1e-9;
        return Math.abs(x-y) < EPS;
    }
}
