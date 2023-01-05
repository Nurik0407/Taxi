package dao;

import classes.Client;
import classes.Driver;
import classes.Taxi;

import java.util.LinkedHashSet;
import java.util.Set;

public class DateBase {
    private Set<Client> clientsDateBase = new LinkedHashSet<>();
    private Set<Driver> driversDateBase = new LinkedHashSet<>();
    private Set<Taxi> taxisDateBase = new LinkedHashSet<>();

    public Set<Client> getClientsDateBase() {
        return clientsDateBase;
    }

    public void setClientsDateBase(Set<Client> clientsDateBase) {
        this.clientsDateBase = clientsDateBase;
    }

    public Set<Driver> getDriversDateBase() {
        return driversDateBase;
    }

    public void setDriversDateBase(Set<Driver> driversDateBase) {
        this.driversDateBase = driversDateBase;
    }

    public Set<Taxi> getTaxisDateBase() {
        return taxisDateBase;
    }

    public void setTaxisDateBase(Set<Taxi> taxisDateBase) {
        this.taxisDateBase = taxisDateBase;
    }
}
