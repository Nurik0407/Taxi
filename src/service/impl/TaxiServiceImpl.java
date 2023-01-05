package service.impl;

import classes.Taxi;
import dao.DateBase;
import enums.TaxiType;
import service.TaxiService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TaxiServiceImpl implements TaxiService {
    DateBase dateBase = new DateBase();

    @Override
    public StringBuilder add(Taxi taxi) {
        if (taxi.getYear().isAfter(LocalDate.of(2010, 12, 31))) {
            dateBase.getTaxisDateBase().add(taxi);
            return new StringBuilder("Taxi added successfully!");
        } else {
            return new StringBuilder("Taxi invalid!");
        }
    }

    @Override
    public StringBuilder add(List<Taxi> taxis) {
        boolean trueOrFalse = false;
        for (Taxi taxi : taxis) {
            if (taxi.getYear().isAfter(LocalDate.of(2010, 12, 31))) {
                trueOrFalse = true;
                dateBase.getTaxisDateBase().add(taxi);
            }
        }
        if (!trueOrFalse) return new StringBuilder("Taxi invalid!");
        return new StringBuilder("Taxi added successfully!");
    }

    @Override
    public List<Taxi> findByInitialLetter(String model) {
        return dateBase.getTaxisDateBase().stream().filter(taxi -> taxi.getModel().startsWith(model)).toList();
    }

    @Override
    public Map<TaxiType, List<Taxi>> grouping() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return dateBase.getTaxisDateBase().stream().collect(Collectors.groupingBy(Taxi::getTaxiType));
    }

    @Override
    public List<Taxi> filterByTaxiType(String taxiType) {
        List<Taxi> taxis = dateBase.getTaxisDateBase().stream().filter(taxi -> taxi.getTaxiType().equals(TaxiType.valueOf(taxiType))).toList();
        return taxis;
    }

    @Override
    public void update(Long id) {
        Scanner sc = new Scanner(System.in);
        List<Taxi> u = dateBase.getTaxisDateBase().stream().filter(taxi -> taxi.getId().equals(id)).toList();
        System.out.print("Current ID: ");
        u.stream().map(Taxi::getId).forEach(System.out::println);
        System.out.println("\nWrite new ID: ");
        u.forEach(taxi -> taxi.setId(sc.nextLong()));
        System.out.println("ID changed successfully");


    }
}
