package quantitymesurement;

public class Length {

    public Unit unit;

    public final double value;

    public Length(Unit unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    public boolean compare(Length that) {
            return unit.compare(this,that);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;
        return Double.compare(length.value, value) == 0 && unit == length.unit;
    }


    public double add(Length that) throws QuantityMesurementException {
        if((this.unit != Unit.FAHRENHEIT && that.unit != Unit.CELSIUS) || (this.unit != Unit.CELSIUS && that.unit != Unit.FAHRENHEIT))
            return unit.add(this, that);
        throw new QuantityMesurementException("Method does not exist", QuantityMesurementException.ExceptionType.NO_SUCH_METHOD);
    }

}
