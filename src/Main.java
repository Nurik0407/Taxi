import classes.Client;
import classes.Taxi;
import dao.DateBase;
import enums.TaxiType;
import service.impl.ClientServiceImpl;
import service.impl.TaxiServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Main {
    static ClientServiceImpl client = new ClientServiceImpl();
    static TaxiServiceImpl taxi = new TaxiServiceImpl();

    public static void main(String[] args) throws Exception {

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

        List<Taxi> taxis = new ArrayList<>(Arrays.asList(
                new Taxi(1L, "BMV", "08KG456AGC", "RED", LocalDate.of(2019, 5, 6), TaxiType.COMFORT),
                new Taxi(2L, "LEXUS", "08KG456AGC", "BLACK", LocalDate.of(2016, 7, 6), TaxiType.BUSINESS),
                new Taxi(3L, "AUDI", "08KG456AGC", "WHITE", LocalDate.of(2006, 6, 6), TaxiType.STANDART),
                new Taxi(4L, "KIA", "08KG456AGC", "YELLOW", LocalDate.of(2013, 4, 6), TaxiType.BUSINESS),
                new Taxi(5L, "TOYOTA", "08KG456AGC", "BLUE", LocalDate.of(2014, 2, 6), TaxiType.COMFORT)
        ));
        Taxi taxi1 = new Taxi(6L, "AUDI", "08KG765DFG", "RED", LocalDate.of(2016, 5, 4), TaxiType.COMFORT);


//         System.out.println(taxiService.grouping());
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


        Client client1 = new Client(1L, "Saskaraeva Meerim", LocalDate.of(1995, 2, 5), "0500322332", BigDecimal.valueOf(500));

        List<Client> clients = new ArrayList<>(Arrays.asList(
                new Client(2L, "Koichubaev Bakas", LocalDate.of(1995, 4, 6), "0708627482", BigDecimal.valueOf(700))
        ));


        while (true) {
            System.out.println("""
                    1-Client command
                    2-Driver command
                    3-Taxi command       
                           """);
            int i = new Scanner(System.in).nextInt();
            switch (i) {
                case 1 -> {
                    System.out.println("""
                            1-added client
                            2-added clients
                            3-get client by name
                            4-remove client by id
                            5-order taxi
                            6-get client age
                            7-universal sorting      
                                  """);
                    int t = new Scanner(System.in).nextInt();
                    switch (t) {
                        case 1 -> System.out.println(client.addClient(client1));
                        case 2 -> System.out.println(client.addClient(clients));
                        case 3 -> {
                            System.out.println("Enter client name: ");
                            String name = new Scanner(System.in).nextLine();
                            client.getClientByName(name);
                        }
                        case 4 -> {
                            System.out.println("Enter client ID: ");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println(client.removeClientById(id));
                        }
                        case 5 -> {
                            System.out.println("Enter client ID: ");
                            Long clientId = new Scanner(System.in).nextLong();
                            System.out.println("Enter taxi type: ");
                            String taxiType = new Scanner(System.in).nextLine();
                            System.out.println(client.orderTaxi(clientId, taxiType));
                        }
                        case 6 -> System.out.println(client.getClientAge());
                        case 7 -> {
                            System.out.println("How will you sort: ");
                            System.out.println("""
                                    Id
                                    fullName
                                    DateOfBirth
                                    PhoneNumber
                                    Money
                                    """);
                            String word = new Scanner(System.in).nextLine();
                            client.universalSorting(word);
                        }
                    }
                }
                case 2 -> {
                    System.out.println("""
                            1-added  taxi
                            2-added taxis
                            3-find by initial  letter
                            4-grouping
                            5-filter by taxi type
                            6-ubdate
                            """);
                    int l = new Scanner(System.in).nextInt();
                    switch (l) {
                        case 1 -> System.out.println(taxi.add(taxi1));
                        case 2 -> System.out.println(taxi.add(taxis));
                        case 3 -> {
                            System.out.println("Enter letter: ");
                            String model = new Scanner(System.in).nextLine();
                            System.out.println(taxi.findByInitialLetter(model));
                        }
                        case 4 -> System.out.println(taxi.grouping());
                        case 5 -> {
                            System.out.println("Enter type taxi: ");
                            String typeTaxi = new Scanner(System.in).nextLine();
                            System.out.println(taxi.filterByTaxiType(typeTaxi));
                        }
                        case 6 -> {
                            System.out.println("Enter taxi ID: ");
                            Long id = new Scanner(System.in).nextLong();
                            taxi.update(id);
                        }
                    }
                }

            }


        }

    }

}