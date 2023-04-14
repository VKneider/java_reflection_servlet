package es.mypackage.servlet.test;
import java.util.Random;


public class Messages {

	    private Random random;

	    public Messages() {
	        this.random = new Random();
	    }

	    public String getGreeting() {
	        String[] greetings = {
	            "Hello!", "Hi!", "Hey there!", "Greetings!", "Good morning!",
	            "Good afternoon!", "Good evening!"
	        };
	        return greetings[random.nextInt(greetings.length)];
	    }

	    public String getFarewell() {
	        String[] farewells = {
	            "Goodbye!", "Farewell!", "Bye!", "See you later!", "Take care!",
	            "Have a good day!", "Have a good one!"
	        };
	        return farewells[random.nextInt(farewells.length)];
	    }

	    public String getCompliment() {
	        String[] compliments = {
	            "You look great today!", "Nice work!", "You're doing a great job!",
	            "You're the best!", "Keep it up!", "I'm impressed!", "You're amazing!"
	        };
	        return compliments[random.nextInt(compliments.length)];
	    }
	
	
}
