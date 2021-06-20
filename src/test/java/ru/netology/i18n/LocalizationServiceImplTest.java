package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

public class LocalizationServiceImplTest {
    @Test
    void test_LocalizationServiceImpl_locale_Russia_case() {
        Country country = Country.RUSSIA;
        String expected = "Добро пожаловать";
        LocalizationService localizationService = new LocalizationServiceImpl();
        String result = localizationService.locale(country);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test_LocalizationServiceImpl_locale_USA_case() {
        Country country = Country.USA;
        String expected = "Welcome";
        LocalizationService localizationService = new LocalizationServiceImpl();
        String result = localizationService.locale(country);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test_LocalizationServiceImpl_locale_Germany_case() {
        Country country = Country.GERMANY;
        String expected = "Welcome";
        LocalizationService localizationService = new LocalizationServiceImpl();
        String result = localizationService.locale(country);
        Assertions.assertEquals(expected, result);
    }
}
