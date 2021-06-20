package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class GeoServiceImplTest {
    @Test
    void test_GeoServiceImpl_byIp_MOSCOW_IP_case() {
        String ip = "172.0.32.11";
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        GeoService geoService = new GeoServiceImpl();
        Location result = geoService.byIp(ip);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_GeoServiceImpl_byIp_nullArgument_ThrowsException() {
        GeoService geoService = new GeoServiceImpl();
        assertThrows(NullPointerException.class, () -> {
            geoService.byIp(null);
        });
    }
}
