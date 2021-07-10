package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerDatabase {
    List<Player> list = new ArrayList<>();

    public Player searchByName(String query) {
        for (Player p: list) {
            if (p.getName().equalsIgnoreCase(query)) {
                return p;
            }
        }
        return null;
    }

    public List<Player> searchByClubAndCountry(String country, String club) {
        List<Player> queryResponse = new ArrayList<>();

        for (Player p: list) {
            if (p.getCountry().equalsIgnoreCase(country) && ((club.equalsIgnoreCase("ANY")) || (club.equalsIgnoreCase(p.getPlayerClub())))) {
                queryResponse.add(p);
            }
        }
        return queryResponse;
    }

    public List<Player> searchByPosition(String query) {
        List<Player> queryResponse = new ArrayList<>();

        for (Player p: list) {
            if (p.getPosition().equalsIgnoreCase(query)) {
                queryResponse.add(p);
            }
        }
        return queryResponse;
    }

    public List<Player> searchBySalaryRange(double low, double high) {
        List<Player> queryResponse = new ArrayList<>();

        for (Player p: list) {
            if (p.getWeeklySalary() >= low && p.getWeeklySalary() <= high) {
                queryResponse.add(p);
            }
        }

        return queryResponse;
    }

    public Map<String, Integer> countryCount() {
        Map<String,Integer> countryFrequency = new HashMap<String,Integer>();

        for (Player p: list) {
            Integer count = countryFrequency.get(p.getCountry());
            if (count == null) {
                countryFrequency.put(p.getCountry(), 1);
            } else {
                countryFrequency.put(p.getCountry(), count+1);
            }
        }

        return countryFrequency;
    }

    public List<Player> playerWithMaxSalaryInClub(String club) {
        boolean found = false;
        double mx = 0;
        List<Player> queryResponse = new ArrayList<>();

        for (Player p: list) {
            if (p.getPlayerClub().equalsIgnoreCase(club)) {
                found = true;
                if (p.getWeeklySalary() > mx) {
                    mx = p.getWeeklySalary();
                }
            }
        }
        if (!found) {
            return queryResponse;
        } else {
            for (Player p: list) {
                if (p.getPlayerClub().equalsIgnoreCase(club) && p.getWeeklySalary() == mx) {
                    queryResponse.add(p);
                }
            }
        }

        return queryResponse;
    }

    public List<Player> playerWithMaxAgeInClub(String club) {
        boolean found = false;
        int mx = 0;
        List<Player> queryResponse = new ArrayList<>();

        for (Player p: list) {
            if (p.getPlayerClub().equalsIgnoreCase(club)) {
                found = true;
                if (p.getAge() > mx) {
                    mx = p.getAge();
                }
            }
        }
        if (!found) {
            return queryResponse;
        } else {
            for (Player p: list) {
                if (p.getPlayerClub().equalsIgnoreCase(club) && p.getAge() == mx) {
                    queryResponse.add(p);
                }
            }
        }

        return queryResponse;
    }

    public List<Player> playerWithMaxHeightInClub(String club) {
        boolean found = false;
        double mx = 0;
        List<Player> queryResponse = new ArrayList<>();

        for (Player p: list) {
            if (p.getPlayerClub().equalsIgnoreCase(club)) {
                found = true;
                if (p.getHeight() > mx) {
                    mx = p.getHeight();
                }
            }
        }
        if (!found) {
            return queryResponse;
        } else {
            for (Player p: list) {
                if (p.getPlayerClub().equalsIgnoreCase(club) && p.getHeight() == mx) {
                    queryResponse.add(p);
                }
            }
        }

        return queryResponse;
    }

    public double totalYearlySalaryOfClub(String club) {
        boolean found = false;
        double total = 0;

        for (Player p: list) {
            if (p.getPlayerClub().equalsIgnoreCase(club)) {
                found = true;
                total += p.getWeeklySalary()*52;
            }
        }
        if (!found) {
            return -1;
        } else {
            return total;
        }
    }

    public int addPlayerToDatabase(Player p) {
        for (Player player: list) {
            if (player.getName().equalsIgnoreCase(p.getName())) {
                //System.out.println("A player with this name already exists.");
                return -1;
            }
        }
        int playerCountInClub = 0;
        for (Player player: list) {
            if (player.getPlayerClub().equalsIgnoreCase(p.getPlayerClub())) {
                playerCountInClub++;
            }
        }
        if (playerCountInClub >= 7) {
            //System.out.println("Already 7 players exist in this club");
            return -2;
        }
        try {
            FileOperation.writeToFile(p);
            list.add(p);
            //success
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -3;
        }
    }
}

