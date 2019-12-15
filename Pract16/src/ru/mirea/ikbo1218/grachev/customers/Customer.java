package ru.mirea.ikbo1218.grachev.customers;

public class Customer {
    private String firstName, secondName;
    private int age;
    private Address address;

    private static final int MATURE_AGE = 18;

    public static final Customer MATURE_UNKNOWN_CUSTOMER = new Customer("", "", MATURE_AGE, Address.EMPTY_ADDRESS);
    public static final Customer NOT_MATURE_UNKNOWN_CUSTOMER = new Customer("", "", MATURE_AGE-1, Address.EMPTY_ADDRESS);

    public Customer(int age) {
        this("", "", age, Address.EMPTY_ADDRESS);
    }

    public Customer(String firstName, String secondName, int age, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public boolean isMature(){
        return age >= MATURE_AGE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(!this.firstName.equals(MATURE_UNKNOWN_CUSTOMER.firstName)) sb.append(this.firstName).append(" ");
        if(!this.secondName.equals(MATURE_UNKNOWN_CUSTOMER.secondName)) sb.append(this.secondName).append(" ");
        if(sb.length() != 0) sb.replace(sb.length()-1, sb.length()-1, ", возраст: ").append(age);
        else sb.append("Неизвестный покупатель, возраст: ").append(age);
        return sb.toString();
    }
}
