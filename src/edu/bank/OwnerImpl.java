package edu.bank;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public class OwnerImpl implements PhysicalOwner {
    private String firstName;
    private String lastName;
    private String pesel;

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPesel() {
        return this.pesel;
    }

    public OwnerImpl(String firstName, String lastName, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
    }
}


