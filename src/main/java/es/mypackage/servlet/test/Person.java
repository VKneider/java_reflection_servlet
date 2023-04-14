package es.mypackage.servlet.test;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Person {
    private String name;
    private int age;
    private String occupation;
    private LocalDate birthday;
    
	 public Person() {
	    	
	  }
    
    
    public Person(String name, Integer age, String occupation, Integer year, Integer month, Integer day) {
    	System.out.println(name);
        this.name = name;
        this.age = age;
        this.birthday = this.createLocalDate(year,month,day);
        this.occupation = occupation;
    }
    

 
    public String getName() {
        return name;
    }
    
    public LocalDate createLocalDate(Integer year, Integer month, Integer day) {
    	 LocalDate date = LocalDate.of(year, month, day);
		return date;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public String getOccupation() {
        return occupation;
    }
    
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    
    public void celebrateBirthday() {
        age++;
    }
    
    public boolean isRetired() {
        return age >= 65;
    }
    
    public boolean isWorking() {
        return occupation != null && !occupation.isEmpty();
    }
    
    public String introduceYourself() {
        return "Hi, my name is " + name + ", I'm " + age + " years old, and I work as a " + occupation + ".";
    }
    
    public String wishHappyBirthday() {
        return "Happy birthday, " + name + "!";
    }
    
    public String congratulateOnRetirement() {
        return "Congratulations on your retirement, " + name + "!";
    }
    
    public LocalDate getBirthday() {
        return this.birthday;
    }

    public boolean isBirthday() {
        LocalDate today = LocalDate.now();
        return today.getDayOfMonth() == birthday.getDayOfMonth() && today.getMonth() == birthday.getMonth();
    }

    public int daysUntilBirthday() {
        LocalDate today = LocalDate.now();
        LocalDate nextBirthday = this.birthday.withYear(today.getYear());

        if (nextBirthday.isBefore(today) || nextBirthday.isEqual(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }

        return (int) ChronoUnit.DAYS.between(today, nextBirthday);
    }
}
