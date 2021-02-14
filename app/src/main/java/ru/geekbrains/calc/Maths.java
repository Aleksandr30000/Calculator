package ru.geekbrains.calc;

import android.os.Parcel;
import android.os.Parcelable;

public class Maths implements Parcelable {

    private double a;
    private double b;
    private double c;
    private int sign;       // 1 это +; 2 это -; 3 это *; 4 это /;
    private boolean point;

    public Maths() {
        a = 0;
        b = 0;
        c = 0;
        sign = 0;
        point = false;
    }

    protected Maths(Parcel in) {
        a = in.readDouble();
        b = in.readDouble();
        c = in.readDouble();
        sign = in.readInt();
        point = in.readByte() != 0;
    }

    public static final Creator<Maths> CREATOR = new Creator<Maths>() {
        @Override
        public Maths createFromParcel(Parcel in) {
            return new Maths(in);
        }

        @Override
        public Maths[] newArray(int size) {
            return new Maths[size];
        }
    };

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public int getSign() {
        return sign;
    }

    public boolean getPoint() {
        return point;
    }

    public void setPoint(boolean point) {
        this.point = point;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(a);
        dest.writeDouble(b);
        dest.writeDouble(c);
        dest.writeInt(sign);
        dest.writeByte((byte) (point ? 1 : 0));
    }
}
