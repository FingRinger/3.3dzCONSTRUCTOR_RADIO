package ru.netology.domain;

public class Radio {
    private int currentStation;
    private int maxStation = 9;
    private int minStation = 0;
    private int currentVolume;
    private int maxVolume = 10;
    private int minVolume = 0;

    public int getCurrentVolume() {

        return currentVolume;
    }


    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
    }


    public void plusVolume() {
        if (currentVolume >= maxVolume) {
            return;
        }
        this.currentVolume = currentVolume + 1;
    }


    public void minusVolume() {
        if (currentVolume == minVolume) {
            return;
        }
        this.currentVolume = currentVolume - 1;
    }


    public int getCurrentStation() {

        return currentStation;
    }

    public void nextStation() {
        if (currentStation >= maxStation) {
            currentStation = 0;
        }
        else {
            this.currentStation = currentStation + 1;
        }
    }

    public void prevStation() {
        if (currentStation <= minStation) {
            currentStation = 9;
        }
        else {
            this.currentStation = currentStation - 1;
        }
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation > maxStation) {
            return;
        }
        if (currentStation < minStation) {
            return;
        }
        this.currentStation = currentStation;
    }

}
