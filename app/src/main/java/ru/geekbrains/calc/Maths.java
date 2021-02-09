package ru.geekbrains.calc;

import java.io.Serializable;

public class Maths implements Serializable {

    private double a;
    private double b;
    private double c;
    private int sign;       // 1-+; 2--; 3-*; 4-/;

    public Maths() {
        a = 0;
        b = 0;
        c = 0;
        sign = 0;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    public void answer() {
        switch (sign) {
            case 1:
                c = a + b;
                break;
            case 2:
                c = a - b;
                break;
            case 3:
                c = a * b;
                break;
            case 4:
                c = a / b;
                break;
        }
        sign = 0;
    }

    public void option(double x) {
        if (sign == 0) {
            setA(x);
        } else {
            setB(x);
        }
    }

}
