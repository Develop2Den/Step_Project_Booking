package entity.enums;

public enum AviaCompany {
    AerosvitUkrainianAirlines("AU"),
    AtlasGlobalUkraine("AG"),
    BukovynaAirlines("BA"),
    DniproAvia("DA"),
    DonbassAero("DS"),
    CremiaAir("CA"),
    Euroline("EL"),
    IcarAirlines("IA"),
    KharkivAirlines("KA"),
    LuganskAirlines("LA"),
    LvivAirlines("LV"),
    SouthAirlines("SA"),
    WizzAirUkraine("WA");


    String code;
    AviaCompany(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }

}
