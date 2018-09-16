package org.prezydium.caching.model;


import javax.persistence.*;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "DEVELOPERS")
public class Developer {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "SALARY")
    private int salary;

    @Column(name = "GENDER")
    private Gender gender;

    @Column(name = "LANGUAGES")
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "LANGUAGES"
            , joinColumns = @JoinColumn(name = "id"))
    private Set<ProgrammingLanguages> knownLanguages;

    public Developer() {
    }

    public Developer(String firstName, String lastName, int salary, Gender gender, EnumSet<ProgrammingLanguages> knownLanguages) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.gender = gender;
        this.knownLanguages = knownLanguages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Set<ProgrammingLanguages> getKnownLanguages() {
        return knownLanguages;
    }

    public void setKnownLanguages(EnumSet<ProgrammingLanguages> knownLanguages) {
        this.knownLanguages = knownLanguages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return salary == developer.salary &&
                Objects.equals(id, developer.id) &&
                Objects.equals(firstName, developer.firstName) &&
                Objects.equals(lastName, developer.lastName) &&
                gender == developer.gender &&
                Objects.equals(knownLanguages, developer.knownLanguages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, salary, gender, knownLanguages);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Developer{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", gender=").append(gender);
        sb.append(", knownLanguages=").append(knownLanguages);
        sb.append('}');
        return sb.toString();
    }
}
