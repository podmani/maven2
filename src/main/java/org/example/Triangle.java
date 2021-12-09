package org.example;

public class Triangle {

    public static int a, b, c;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static float squTriangle ()

    {
    float p = (a + b + c) / 2.f;
    float s = (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));
        System.out.println("Площадь треугольника:"+s);
        return s;
    }
}
