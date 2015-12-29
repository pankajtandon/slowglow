package com.nayidisha.slowglow.api;

import com.nayidisha.slowglow.domain.Gender;
import com.nayidisha.slowglow.domain.PatientAggregate;

/**
 * Determine what is needed to create a Patient. This doesn't need to mirror
 * every member variable in the corresponding Patient class. This is because
 * creation of a patient may need some collaboration with other entities and
 * after passing business rules will the patient be created. So this is a good
 * place to invoke the rules that are encapsulated in the domain class (Patient)
 * 
 * @author pankaj
 *
 */
//@EqualsAndHashCode(callSuper = false)
public class CreatePatientCommand {

    private Long id;
    private String name;
    private int age;
    private Gender gender;

    public CreatePatientCommand(String name, int age, Gender gender) {
        //A good example of a business rule is that two patients cannot have the same name, age and sex
        PatientAggregate newPatient = new PatientAggregate(name, age, gender); //Not sure?

        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public Gender getGender() {
        return this.gender;
    }
}
