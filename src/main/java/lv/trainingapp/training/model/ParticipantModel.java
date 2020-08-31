package lv.trainingapp.training.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ParticipantModel {

    private @Id
    @GeneratedValue
    int id;
    private String firstName;
    private String lastName;
    private String email;

    //constructor:
    public ParticipantModel() {

    }

    //full constructor:
    public ParticipantModel(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    //getters and setters:

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id++;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //toString:
    @Override
    public String toString() {
        return "First name = " + firstName + ", last name = " + lastName + ", e-mail = " + email;
    }
}
