package service.impl;

import classes.Client;
import classes.Taxi;
import dao.DateBase;
import enums.TaxiType;
import service.ClientService;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ClientServiceImpl implements ClientService {

    DateBase dateBase = new DateBase();

    @Override
    public String addClient(Client client) {

        dateBase.getClientsDateBase().add(client);

        return "Client successfully added";
    }

    @Override
    public String addClient(List<Client> clients) {

        dateBase.getClientsDateBase().addAll(clients);

        return "Clients successfully added";
    }

    @Override
    public List<Client> getClientByName(String name) {

        return dateBase.getClientsDateBase().stream().filter(s -> s.getFullName().endsWith(name)).toList();
    }

    @Override
    public Client removeClientById(Long id) {
        for (Client client : dateBase.getClientsDateBase()) {
            if (client.getId().equals(id)) {
                dateBase.getClientsDateBase().remove(client);
                System.out.println("Client successfully deleted!");
                return client;
            }
        }
        return null;
    }

    @Override
    public Taxi orderTaxi(Long clientId, String taxiType) throws Exception {

        boolean clientTrueOrFalse = false;
        for (Client client : dateBase.getClientsDateBase()) {
            if (client.getId().equals(clientId)) {
                clientTrueOrFalse = true;
                for (Taxi taxi : dateBase.getTaxisDateBase()) {
                    if (taxi.getTaxiType().name().equals(taxiType.toUpperCase())) {
                        client.setMoney(client.getMoney().subtract(taxi.getTaxiType().getPriceForLanding().add(taxi.getTaxiType().getPricePerKm())));
                        return taxi;
                    }
                }
            }
        }
        if (!clientTrueOrFalse) throw new Exception("Client not found!");
        return null;
    }

    @Override
    public Map<Integer, Client> getClientAge() {
        Map<Integer, Client> clientMap = new LinkedHashMap<>();
        for (Client client : dateBase.getClientsDateBase()) {
            clientMap.put(LocalDate.now().minusYears(client.getDateOfBirth().getYear()).getYear(), client);
        }
        return clientMap;
    }

    @Override
    public void universalSorting(String word) {
        switch (word.toLowerCase()) {

            case "id" -> {
                System.out.println("Ascending or decnending?");
                String ascendingOrDescending = new Scanner(System.in).nextLine();
                if (ascendingOrDescending.toLowerCase().equals("ascending")) {
                    dateBase.getClientsDateBase().stream().sorted(Comparator.comparing(Client::getId)).forEach(System.out::println);
                }
                if (ascendingOrDescending.toLowerCase().equals("descending")) {
                    dateBase.getClientsDateBase().stream().sorted(Comparator.comparing(Client::getId).reversed()).forEach(System.out::println);
                }
            }

            case "fullname" -> {
                System.out.println("Ascending or decnending?");
                String asOrDes = new Scanner(System.in).nextLine();
                if (asOrDes.toLowerCase().equals("ascending")) {
                    dateBase.getClientsDateBase().stream().sorted(Comparator.comparing(Client::getFullName)).forEach(System.out::println);
                }
                if (asOrDes.toLowerCase().equals("descending")) {
                    dateBase.getClientsDateBase().stream().sorted(Comparator.comparing(Client::getFullName).reversed()).forEach(System.out::println);
                }
            }

            case "dateofbirth" -> {
                System.out.println("Ascending or decnending?");
                String asOrDes = new Scanner(System.in).nextLine();
                if (asOrDes.toLowerCase().equals("ascending")) {
                    dateBase.getClientsDateBase().stream().sorted(Comparator.comparing(Client::getDateOfBirth)).forEach(System.out::println);
                }
                if (asOrDes.toLowerCase().equals("descending")) {
                    dateBase.getClientsDateBase().stream().sorted(Comparator.comparing(Client::getDateOfBirth).reversed()).forEach(System.out::println);
                }
            }

            case "phonenumber" -> {
                System.out.println("Ascending or decnending?");
                String asOrDes = new Scanner(System.in).nextLine();
                if (asOrDes.toLowerCase().equals("ascending")) {
                    dateBase.getClientsDateBase().stream().sorted(Comparator.comparing(Client::getPhoneNumber)).forEach(System.out::println);
                }
                if (asOrDes.toLowerCase().equals("descending")) {
                    dateBase.getClientsDateBase().stream().sorted(Comparator.comparing(Client::getPhoneNumber).reversed()).forEach(System.out::println);
                }
            }

            case "money" -> {
                System.out.println("Ascending or decnending?");
                String asOrDes = new Scanner(System.in).nextLine();
                if (asOrDes.toLowerCase().equals("ascending")) {
                    dateBase.getClientsDateBase().stream().sorted(Comparator.comparing(Client::getMoney)).forEach(System.out::println);
                }
                if (asOrDes.toLowerCase().equals("descending")) {
                    dateBase.getClientsDateBase().stream().sorted(Comparator.comparing(Client::getMoney).reversed()).forEach(System.out::println);
                }
            }
        }
    }
}
