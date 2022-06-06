public class ComplexNumber {
    public double real;
    public double imag;

    public ComplexNumber(double real, double imag) {
        this.real=real;
        this.imag=imag;
    }
    public ComplexNumber(ComplexNumber c) {
        real=c.real;
        imag=c.imag;
    }
    public ComplexNumber() {
        real=0;
        imag=0;
    }

    public ComplexNumber add(ComplexNumber c) {
        double r=real+c.real;
        double i=imag+c.imag;
        return new ComplexNumber(r, i);
    }
    public ComplexNumber subtract(ComplexNumber c) {
        double r=real-c.real;
        double i=imag-c.imag;
        return new ComplexNumber(r, i);
    }
    public ComplexNumber multiply(ComplexNumber c) {
        double r=real*c.real-imag*c.imag;
        double i=real*c.imag+imag*c.real;
        return new ComplexNumber(r, i);
    }
    public ComplexNumber divide(ComplexNumber c) {
        if(c.real*c.real+c.imag*c.imag==0) return this;
        double r=(real*c.real+imag*c.imag)/(c.real*c.real+c.imag*c.imag);
        double i=(imag*c.real-real*c.imag)/(c.real*c.real+c.imag*c.imag);
        return new ComplexNumber(r, i);
    }
    public ComplexNumber pow(int e) {
        ComplexNumber ret=new ComplexNumber(1, 0);
        if(e!=0) {
            for(int i = 0; i<e; i++) {
                ret=ret.multiply(this);
            }
            if(e<0) {
                ret=new ComplexNumber(1, 0).divide(ret);
            }
        }
        return ret;
    }

    public double length() {
        return Math.sqrt(real*real+imag*imag);
    }
    public double angle() {
        return Math.atan2(imag, real);
    }

    @Override
    public boolean equals(Object o) {
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;

        ComplexNumber that = (ComplexNumber)o;

        if(Double.compare(that.real, real)!=0) return false;
        return Double.compare(that.imag, imag)==0;
    }
    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(real);
        result = (int)(temp^(temp >>> 32));
        temp = Double.doubleToLongBits(imag);
        result = 31*result + (int)(temp^(temp >>> 32));
        return result;
    }
    @Override
    public String toString() {
        return real+" + "+imag+"i";
    }
}