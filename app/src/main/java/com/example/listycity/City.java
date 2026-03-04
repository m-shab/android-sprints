package com.example.listycity;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<Object>{
    /**
     * These are the attributes that define a city.
     * city - String name of city
     * province - String name of province of city
     */
    private String city;
    private String province;

    /**
     * This is a constructor that creates a city Object
     * @param city
     *      This is the city name
     * @param province
     *      This is the province name
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * This returns the city name
     * @return
     *      Return the city name
     */
    public String getCityName() {
        return this.city;
    }

    /**
     * This returns the province name
     * @return
     *      Return the province name
     */
    public String getProvinceName() {
        return this.province;
    }

    /**
     * This overrides the compare operation for City object
     * @return
     *      Return an integer representing object sorted position
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }

    /**
     * This overrides the equals operation for City object
     * @return
     *      Return an boolean representing object equality
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        City city = (City) o;
        boolean cond = this.city.equals(city.getCityName()) && this.province.equals(city.getProvinceName());
        return cond;
    }
}

