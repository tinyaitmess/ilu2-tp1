package Exceptions;

public class VillageSansChefException extends Exception {
	public VillageSansChefException() {
		System.out.println("Il n'y a pas de chef dans ce village.");
	}

}
