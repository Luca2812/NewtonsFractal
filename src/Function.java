public class Function {
    public ComplexNumber[] coefficients;

    public Function(ComplexNumber[] coefficients) {
        this.coefficients=coefficients.clone();
    }

    public ComplexNumber value(ComplexNumber c) {
        ComplexNumber ret=new ComplexNumber(0, 0);
        for(int i = 0; i<coefficients.length; i++) {
            ret=ret.add(coefficients[i].multiply(c.pow(i)));
        }
        return ret;
    }
    public Function derivative() {
        ComplexNumber[] ret=new ComplexNumber[coefficients.length-1];
        for(int i = 0; i<ret.length; i++) {
            ret[i]=coefficients[i+1].multiply(new ComplexNumber(i+1, 0));
        }
        return new Function(ret);
    }
    public Function addZero(ComplexNumber c) {
        ComplexNumber[] ret=new ComplexNumber[coefficients.length+1];
        for(int i = 0; i<ret.length; i++) {
            ret[i]=new ComplexNumber(0, 0);
        }
        for(int i = 0; i<coefficients.length; i++) {
            ret[i]=ret[i].subtract(coefficients[i].multiply(c));
            ret[i+1]=ret[i+1].add(coefficients[i]);
        }
        return new Function(ret);
    }
    public ComplexNumber newtonsMethod(ComplexNumber start) {
        ComplexNumber n=start;
        ComplexNumber k=null;
        int i=0;
        while(!n.equals(k) && i<20) {
            k=n;
            n=n.subtract(value(n).divide(derivative().value(n)));
            i++;
        }
        return n;
    }
    @Override
    public String toString() {
        String ret="0";
        if(coefficients.length>0) {
            ret="("+coefficients[0]+")";
            if(coefficients.length>1) {
                ret=ret+" + ("+coefficients[1]+")x";
                if(coefficients.length>2) {
                    for(int i = 2; i<coefficients.length; i++) {
                        ret=ret+" + ("+coefficients[i]+")x^"+i;
                    }
                }
            }
        }
        return ret;
    }
}