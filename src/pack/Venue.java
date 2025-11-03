package pack;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Venue {
	private int[][] Seat;
	public Venue(int row, int col, double price) throws IOException{
		Seat.length = row;
		Seat[].length = col;
	}
	
	public boolean buyTicket(int row, int col) {
		if (Seat[row][col].getSold() == true) {
			return false;
		}
		Seat[row][col].setSold(true);
		return true;
	}
	private boolean isAvailable(int row, int col) {
		if (Seat[row][col].getSold() == true) {
			return false;
		}
		return true;
	}
	public void setPremium(int row, double price) {
		for (int i = 0; i < Seat[row].length; i++) {
			Seat[row][i].setType("P");
			Seat[row][i].setPrice()
		}
	}
}
