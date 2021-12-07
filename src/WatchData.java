import javafx.beans.property.*;

public class WatchData {

    private DoubleProperty min = new SimpleDoubleProperty(this,"hour",0);
    //private ReadOnlyDoubleProperty min = new SimpleDoubleProperty(this,"hour",0);

    public final DoubleProperty minProperty(){
        return this.min;
    }

    public double getMin() {
        //return stockPrice;
        return min.get();
    }

    public void setMin(double hour) {
        //this.stockPrice = stockPrice;
        this.min.set(hour);

    }

}
