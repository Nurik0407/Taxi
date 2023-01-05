import classes.Taxi;
import dao.DateBase;
import enums.TaxiType;
import service.impl.TaxiServiceImpl;

import java.time.LocalDate;
import java.util.*;

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

//        TaxiServiceImpl taxiService = new TaxiServiceImpl();
//
//        List<Taxi> taxis = new ArrayList<>(Arrays.asList(
//                new Taxi(1L,"BMV","08KG456AGC","RED", LocalDate.of(2019,5,6), TaxiType.COMFORT),
//                new Taxi(2L,"LEXUS","08KG456AGC","BLACK", LocalDate.of(2016,7,6), TaxiType.BUSINESS),
//                new Taxi(3L,"AUDI","08KG456AGC","WHITE", LocalDate.of(2006,6,6), TaxiType.STANDART),
//                new Taxi(4L,"KIA","08KG456AGC","YELLOW", LocalDate.of(2013,4,6), TaxiType.BUSINESS),
//                new Taxi(5L,"TOYOTA","08KG456AGC","BLUE", LocalDate.of(2014,2,6), TaxiType.COMFORT)
//        ));
//
//
//        System.out.println(taxiService.add(taxis));
//        System.out.println(taxiService.add(new Taxi(6L, "AUDI", "08KG765DFG", "RED", LocalDate.of(2016, 5, 4), TaxiType.COMFORT)));
//
//        System.out.println(taxiService.grouping());
//        System.out.println("Write taxi ID: ");
//        long id=new Scanner(System.in).nextLong();
//        taxiService.update(id);
//        System.out.println(taxiService.grouping());
//        System.out.println("Write letter:");
//        String letter=new Scanner(System.in).next();
//        System.out.println(taxiService.findByInitialLetter(letter));
//        System.out.println("Write taxi type: ");
//        String type=new Scanner(System.in).next().toUpperCase();
//        System.out.println(taxiService.filterByTaxiType(type));

    }

}