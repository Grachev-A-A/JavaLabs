package ru.mirea.ikbo1218.grachev.customers;

public class Address {
    private String cityName, streetName;
    private int zipCode, buildingNumber, apartmentNumber;
    private char buildingLetter;
    public static final Address EMPTY_ADDRESS = new Address("", 0, "", 0, 0);

    public Address(String cityName, int zipCode, String streetName, int buildingNumber, int apartmentNumber){
        this(cityName, zipCode, streetName, buildingNumber, ' ', apartmentNumber);
    }

    public Address(String cityName, int zipCode, String streetName, int buildingNumber, char buildingLetter, int apartmentNumber) {
        this.cityName = cityName;
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.buildingNumber = buildingNumber;
        this.apartmentNumber = apartmentNumber;
        this.buildingLetter = buildingLetter;
    }

    public String getCityName() {
        return cityName;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public char getBuildingLetter() {
        return buildingLetter;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(zipCode != 0) sb.append(zipCode);
        if(!cityName.equals("")){
            if(sb.length() == 0) sb.append(cityName);
            else sb.append(", ").append(cityName);
        }
        if(!streetName.equals("")) {
            if (sb.length() == 0) sb.append("Ул. ").append(streetName);
            else sb.append(", ул. ").append(streetName);
        }
        if(buildingNumber != 0){
            if (sb.length() == 0) sb.append("Дом ").append(buildingNumber);
            else sb.append(", дом ").append(buildingNumber);
        }
        if(buildingLetter!=' ') sb.append("-").append(buildingLetter);
        if(apartmentNumber != 0) sb.append(", кв. ").append(apartmentNumber);

        return sb.toString();
    }
}
