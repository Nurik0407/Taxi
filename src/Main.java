import classes.Driver;
import classes.License;
import classes.Taxi;
import enums.Gender;
import enums.TaxiType;
import service.impl.DriverServiceImpl;

import java.math.BigDecimal;
import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

/**  * Жаны проект ачып ичине томондогу класстарды тузунуз:
 * 1. Client (Long id, String fullName, LocalDate dateOfBirth, String phoneNumber, BigDecimal money);
 * 2. Driver (Long id, String name, String surname, Gender gender,
 *    String phoneNumber, License license, BigDecimal money, Taxi taxi);
 * 3. Taxi (Long id, String model, String number, String colour, LocalDate year, TaxiType taxiType);
 * 4. License (Long id, LocalDate dateOfIssue, LocalDate expirationDate;)
 *
 * Gender(MALE, FEMALE) жана TaxiType(STANDART, COMFORT, BUSINESS) enum болуусу керек.
 * TaxiType enum дын ичинде  BigDecimal pricePerKm, BigDecimal priceForLanding деген эки полеси болсун;
 *
 * Database деген класс ачып, ичинде бардык маалыматтарды уникалдуу сактаган маалымат структурасы болсун.
 *
 * ClientService:    String addClient(Client client);
 *                   String addClient(List<Client> clients);
 *                   List<Client> getClientByName(String name);
 *                   Client removeClientById(Long id);
 *                   Taxi orderTaxi(Long clientId, String taxiType);
 *                   Map<Integer, Client> getClientAge();
 *                   void universalSorting(String word);
 *
 * DriverService:    Driver add(Driver driver);
 *                   List<Driver>add(List<Driver>drivers);
 *                   Driver findById(Long id);
 *                   List<Driver> findByName(String name);
 *                   String assignTaxiToDriver(String taxiName,Long driverId);
 *                   String changeTaxiOrDriver(Long driverId, Long taxiId);
 *                   List<Driver> getDriverByTaxiModel(String model);
 *                   void update(String driverName);
 *
 * TaxiService:      StringBuilder add(Taxi taxi);
 *                   StringBuilder add(List<Taxi> taxis);
 *                   List<Taxi> findByInitialLetter(String model);
 *                   Map<TaxiType, List<Taxi>> grouping();
 *                   List<Taxi> filterByTaxiType(String taxiType);
 *                   void update(Long id);
 *
 *
 *
 *  Жогорудагы берилген маалыматтарды колдонуп такси чакыруучу бир проект тузунуздор.
 *  Клиент бир такси чакырса, чакырган таксинин классына жараша акчасы эсептелип,
 *  клиенттин акчасынан кемип, айдоочунун акчасына кошулуусу керек.
 *
 *  1-Taxi классын сактап жатканда 2010 жылдан кийин чыккан машиналар гана такси дата базасына сакталышы керек.
 *  2-Бир айдоочу бир эле таксини башкара алат, бирок айдоочунун таксисин, таксинин айдоочусун алмаштырса болот.
 *  3-Андан сырткары жоргоруда берилген методдорду ишке ашыргыла.
 *  4-Бардык класстар оздоруно тийешелуу пакеттерде болуусу керек.
 *
 *  P.S. Жогорудагы берилген методдорду озгортууго болбойт, бирок кошумча метод кошсонуздар болот. **/

        DriverServiceImpl d = new DriverServiceImpl();
        List<Driver> driverList = new ArrayList<>(Arrays.asList(
                new Driver(1L, "Azat", "Asanov", Gender.MAlE, "65468574", new License(13L, LocalDate.of(2015, 12, 15),
                        LocalDate.of(2020, 01, 02)), BigDecimal.valueOf(12563), new Taxi(1L, "BMW", "21985416", "red",
                        LocalDate.of(2020, 12, 2), TaxiType.BUSINESS)),
                new Driver(5L, "Asan", "Azatov", Gender.MAlE, "7846", new License(13L, LocalDate.of(2015, 12, 15),
                        LocalDate.of(2020, 01, 02)), BigDecimal.valueOf(12563), new Taxi(1L, "BMW", "21985416", "red",
                        LocalDate.of(2020, 12, 2), TaxiType.BUSINESS)),
                new Driver(6L, "Uson", "Usonov", Gender.MAlE, "65468574", new License(13L, LocalDate.of(2015, 12, 15),
                        LocalDate.of(2020, 01, 02)), BigDecimal.valueOf(12563), new Taxi(1L, "BMW", "21985416", "red",
                        LocalDate.of(2020, 12, 2), TaxiType.BUSINESS))

        ));
        Driver driver = new Driver(9L, "Uson", "Usonov", Gender.MAlE, "65468574", new License(13L, LocalDate.of(2015, 12, 15),
                LocalDate.of(2020, 01, 02)), BigDecimal.valueOf(12563), new Taxi(9L, "BMW", "21985416", "red",
                LocalDate.of(2020, 12, 2), TaxiType.BUSINESS));

        System.out.println(d.add(driverList));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(d.add(driver));
        System.out.println("Write name: ");
        String name = new Scanner(System.in).next();
        System.out.println(d.findByName(name));
        System.out.println("Write id: ");
        long id=new Scanner(System.in).nextLong();
        System.out.println(d.findById(id));
        System.out.println("Write TAXI NAME: ");
        String model = new Scanner(System.in).next();
        System.out.println("Write driver id: ");
        long idDriver=new Scanner(System.in).nextLong();
        System.out.println(d.assignTaxiToDriver(model, idDriver));
        System.out.println(d.add(driver));



    }
}