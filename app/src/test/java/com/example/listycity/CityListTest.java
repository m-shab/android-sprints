package com.example.listycity;
import org.junit.Test;
import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCity() {
        CityList cityList = new CityList();
        City city = mockCity();
        //testing non existence
        assertFalse(cityList.hasCity(city));
        //testing existence
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
    }

    @Test
    public void testDeleteCity() {
        CityList cityList = new CityList();
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        //test to see if removes
        cityList.delete(city);
        assertFalse(cityList.hasCity(city));

        //test to see if exception thrown
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    @Test
    public void testCountCities() {
        CityList cityList = new CityList();

        //tests no cities in list
        assertEquals(0, cityList.countCities());

        cityList.add(mockCity());
        //test 1 city
        assertEquals(1, cityList.countCities());

        //test 2 cities
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(2, cityList.countCities());

        //test after 1 deletion
        cityList.delete(mockCity());
        assertEquals(1, cityList.countCities());

        //test after complete deletion
        cityList.delete(city);
        assertEquals(0, cityList.countCities());
    }
}