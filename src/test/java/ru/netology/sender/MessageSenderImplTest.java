package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

import java.util.HashMap;
import java.util.Map;

import static ru.netology.sender.MessageSenderImpl.IP_ADDRESS_HEADER;

public class MessageSenderImplTest {
    @Test
    void test_MessageSenderImpl_send_in_russian_api_case() {
        String ip = "172.6.92.34";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(IP_ADDRESS_HEADER, ip);

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(ip)).thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String resultMessage = messageSender.send(headers);

        String expected = "Добро пожаловать";
    }

    @Test
    void test_MessageSenderImpl_send_in_american_api_case() {
        String ip = "96.5.89.23";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(IP_ADDRESS_HEADER, ip);

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(ip)).thenReturn(new Location("New York", Country.USA, null, 0));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String resultMessage = messageSender.send(headers);

        String expected = "Welcome";
        Assertions.assertEquals(expected, resultMessage);
    }

}