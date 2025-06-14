package org.example.b3stocks.model;

public class DataBovespa implements Comparable<DataBovespa>
 {

    private int index;
    private String dateTime;
    private String ticker;
    private double open;
    private double close;
    private double high;
    private double low;
    private double volume;

    public DataBovespa(int index, String dateTime, String ticker, double open, double close, double high, double low, double volume) {
        this.index = index;
        this.dateTime = dateTime;
        this.ticker = ticker;
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

    public String getTicker() {
        return ticker;
    }

    public void setTicket(String ticket) {
        this.ticker = ticket;
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

    public double getFlutuacao() {
        return this.high - this.low;
    }

    public String[] toCSV() {
        return new String[] {
                dateTime,
                ticker,
                String.valueOf(open),
                String.valueOf(close),
                String.valueOf(high),
                String.valueOf(low),
                String.valueOf(volume)
        };
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        DataBovespa that = (DataBovespa) obj;
        return dateTime != null && dateTime.equals(that.dateTime);
    }

    @Override
    public int hashCode() {
        return dateTime != null ? dateTime.hashCode() : 0;
    }

     @Override
     public int compareTo(DataBovespa outro) {
         return this.dateTime.compareTo(outro.dateTime); // usa a data para ordenação natural
     }



 }
