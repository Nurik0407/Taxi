package service.impl;

import classes.Driver;
import classes.Taxi;
import dao.DateBase;
import service.DriverService;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

import static javax.swing.text.html.parser.DTDConstants.ID;

public class DriverServiceImpl implements DriverService {
    DateBase dateBase = new DateBase();


    @Override
    public Driver add(Driver driver) {
        dateBase.getDriversDateBase().add(driver);
        return driver;
    }

    @Override
    public List<Driver> add(List<Driver> drivers) {
        dateBase.getDriversDateBase().addAll(drivers);
        return drivers;
    }

    @Override
    public Driver findById(Long id) {
        Driver driver1 = dateBase.getDriversDateBase().stream().filter(driver -> driver.getID().equals(id)).findAny().get();
        return driver1;
    }

    @Override
    public List<Driver> findByName(String name) {
        return dateBase.getDriversDateBase().stream().filter(driver -> driver.getName().equals(name)).toList();
    }

    @Override
    public String assignTaxiToDriver(String taxiName, Long driverId) {
        Taxi activeTaxi = null;
        for (Taxi taxi : dateBase.getTaxisDateBase()) {
            System.out.println(taxi);
            if (taxi.getModel().equals(taxiName)) {
                activeTaxi = taxi;
            }
        }
        for (Driver driver : dateBase.getDriversDateBase()) {
            if (Objects.equals(driver.getID(), driverId)) {
                driver.setTaxi(activeTaxi);
            }
        }
        return "successfully assigned";
    }

    @Override
    public String changeTaxiOrDriver(Long driverId, Long taxiId) {
        Driver d = null;
        for (Driver driver : dateBase.getDriversDateBase()) {
            if (driver.getID().equals(driverId)) {
                d = driver;
            }
        }
        Taxi taxi = dateBase.getTaxisDateBase().stream().filter(x -> x.getId().equals(taxiId)).findAny().get();
        if (d.getTaxi() == null) {
            return "not found taxi";
        } else {
            for (Driver driver : dateBase.getDriversDateBase()) {
                if (driver.getTaxi().equals(taxi)) {
                    return "taxi is busy";
                } else {
                    d.setTaxi(taxi);
                    return "Taxi successfully changed";
                }
            }
        }

        return "";
    }

    @Override
    public List<Driver> getDriverByTaxiModel(String model) {
        return dateBase.getDriversDateBase().stream().filter(driver -> driver.getTaxi().getModel().equals(model)).toList();

    }

    @Override
    public void update(String driverName) {
        Scanner scanner = new Scanner(System.in);
        List<Driver> u = dateBase.getDriversDateBase().stream().filter(driver -> driver.getName().equals(driverName)).toList();
        System.out.print("Current Name:  ");
        u.stream().map(Driver::getName).forEach(System.out::println);
        System.out.println("Write new name ");
        u.forEach(driver -> driver.setName(scanner.next()));
        System.out.println("Name update successfully");
    }
}
