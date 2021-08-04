package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    @Test
    public void defaultAmountOfStations() {
        Radio radio = new Radio();
        assertEquals(10,radio.getAmountOfStation());

    }

    @Test
    public void maxStationIfAmountOfStationMoreThenTen () {
        Radio radio = new Radio(11);
        assertEquals(10,radio.getMaxStation());
    }

    @Test
    public void maxStationIfAmountOfStationLessThenTen () {
        Radio radio = new Radio(4);
        assertEquals(3,radio.getMaxStation());
    }
    @Test
    public void shouldInputStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(3);
        assertEquals(3, radio.getCurrentStation());
    }

    @Test
    public void shouldInputWrongStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(4); //валидная станция
        assertEquals(4, radio.getCurrentStation());
        radio.setCurrentStation(15); //невалидная станция
        assertEquals(4, radio.getCurrentStation());
    }


    @Test // следующая станция после Max-ой - 0-ая
    public void shouldZeroStationIfMax() {
        Radio radio = new Radio(1000);
        radio.setCurrentStation(999);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldZeroStationIfMaxDefault() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test // станция перед 0-ой - 9-ая
    public void shouldMaxAfterMinStation() {
        Radio radio = new Radio(783);
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(782, radio.getCurrentStation());
    }

    @Test //
    public void shouldMaxAfterLessMinStation() {
        Radio radio = new Radio(3000);
        radio.setCurrentStation(-6300);
        radio.prevStation();
        assertEquals(2999, radio.getCurrentStation());
    }

    @Test
    public void shouldPrevStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(3);
        radio.prevStation();
        assertEquals(2, radio.getCurrentStation());
    }

    @Test
    public void shouldNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(3);
        radio.nextStation();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(99);
        radio.plusVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotIncreaseVolumeIfAlreadyMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.plusVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldTurnDownVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(86);
        radio.minusVolume();
        assertEquals(85, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotTurnDownVolumeIfAlreadyMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.minusVolume();
        assertEquals(0, radio.getCurrentVolume());
    }
}