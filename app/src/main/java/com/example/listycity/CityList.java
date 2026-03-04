package com.example.listycity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     *      This is a candidate city to add
     * @throws IllegalArgumentException
     *      Throws exception upon addition of duplicate city
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This checks if a city exists in the list
     * @param city
     *      This is the city existence to check
     * @return
     *      Return a bool indicating city existence
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * This deletes a city from the list if the city does exist
     * @param city
     *      This is a candidate city to remove
     * @throws IllegalArgumentException
     *      Throws exception upon deletion of a non-existent city
     */
    public void delete(City city) {
        if (hasCity(city)) {
            cities.remove(city);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This returns the number of cities in the list
     * @return
     *      Return the number of cities
     */
    public int countCities() {
        return cities.size();
    }
}