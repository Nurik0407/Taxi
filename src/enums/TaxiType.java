package enums;

import java.math.BigDecimal;

public enum TaxiType {
    STANDART(BigDecimal.valueOf(15),BigDecimal.valueOf(30)),
    COMFORT(BigDecimal.valueOf(25),BigDecimal.valueOf(40)),
    BUSINESS(BigDecimal.valueOf(35),BigDecimal.valueOf(50));

    BigDecimal pricePerKm;
    BigDecimal priceForLanding;

    TaxiType(BigDecimal pricePerKm, BigDecimal priceForLanding) {
        this.pricePerKm = pricePerKm;
        this.priceForLanding = priceForLanding;
    }

    public BigDecimal getPricePerKm() {
        return pricePerKm;
    }

    public void setPricePerKm(BigDecimal pricePerKm) {
        this.pricePerKm = pricePerKm;
    }

    public BigDecimal getPriceForLanding() {
        return priceForLanding;
    }

    public void setPriceForLanding(BigDecimal priceForLanding) {
        this.priceForLanding = priceForLanding;
    }
}
