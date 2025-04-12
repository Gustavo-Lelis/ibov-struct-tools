package org.example.b3stocks.model;

public class DataBovespa {

    private int index;
    private String dateTime;
    private String ticket;
    private double open;
    private double close;
    private double high;
    private double low;
    private double volume;

    public DataBovespa(int index, String dateTime, String ticket, double open, double close, double high, double low, double volume) {
        this.index = index;
        this.dateTime = dateTime;
        this.ticket = ticket;
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
        this.volume = volume;
    }

    public DataBovespa() {}

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String[] toCSV() {
        return new String[] {
                dateTime,
                ticket,
                String.valueOf(open),
                String.valueOf(close),
                String.valueOf(high),
                String.valueOf(low),
                String.valueOf(volume)
        };
    }

}
