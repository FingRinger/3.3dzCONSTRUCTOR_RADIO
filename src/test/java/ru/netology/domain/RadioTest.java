package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {


    @Test
    public void shouldInputStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(3); //валидная станция
        assertEquals(3,radio.getCurrentStation());
    }
    @Test
    public void shouldInputWrongStation() {
        Radio radio =new Radio();
        radio.setCurrentStation(4); //валидная станция
        assertEquals(4,radio.getCurrentStation());
        radio.setCurrentStation(15); //невалидная станция
        assertEquals(4,radio.getCurrentStation());
    }


    @Test // следующая станция после 9-ой - 0-ая
    public void shouldZeroStationIfNine() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }


    @Test // станция перед 0-ой - 9-ая
    public void shouldNineAfterMinStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(9,radio.getCurrentStation());
    }

    @Test //
    public void shouldNineAfterLessMinStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(-63);
        radio.prevStation();
        assertEquals(9,radio.getCurrentStation());
    }

    @Test
    public void shouldPrevStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(3);
        radio.prevStation();
        assertEquals(2,radio.getCurrentStation());
    }

    @Test
    public void shouldNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(3);
        radio.nextStation();
        assertEquals(4,radio.getCurrentStation());
    }

    @Test
    public void shouldIncreaseVolume(){
        Radio radio = new Radio();
        radio.setCurrentVolume(9);
        radio.plusVolume();
        assertEquals(10,radio.getCurrentVolume());
    }

    @Test
    public void shouldNotIncreaseVolumeIfAlreadyMax(){
        Radio radio = new Radio();
        radio.setCurrentVolume(10);
        radio.plusVolume();
        assertEquals(10,radio.getCurrentVolume());
    }

    @Test
    public void shouldTurnDownVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(6);
        radio.minusVolume();
        assertEquals(5,radio.getCurrentVolume());
    }

    @Test
    public void shouldNotTurnDownVolumeIfAlreadyMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.minusVolume();
        assertEquals(0,radio.getCurrentVolume());
    }
}