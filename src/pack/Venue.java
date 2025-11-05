package pack;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Venue {
	public Seat[][] seat;
	public Venue(int row, int col, double price) throws IOException{
		seat = new Seat[row][col];
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				seat[i][j] = new Seat(false, "G", 50.0);
				seat[i][j].setPrice(price);
			}
		}
	}
	
	public boolean buyTicket(int row, int col) {
		if (seat[row][col].getSold() == true) {
			return false;
		}
		seat[row][col].setSold(true);
		return true;
	}
	private boolean isAvailable(int row, int col) {
		if (seat[row][col].getSold() == true) {
			return false;
		}
		return true;
	}
	public void setPremium(int row, double price) {
		for (int i = 0; i < seat[row].length; i++) {
			seat[row][i].setType("P");
			seat[row][i].setPrice(price);
		}
	}
	public void setPremium(int row, int colStart, int colEnd, double price) {
		for (int j = 0; j < colEnd-colStart; j++) {
			for (int i = 0; i < seat.length; i++) {
				seat[j+colStart][i].setType("P");
				seat[j+colStart][i].setPrice(price);
			}
		}
	}
	public void setGA(int row, double price) {
		for (int i = 0; i < seat[row].length; i++) {
			seat[row][i].setType("G");
			seat[row][i].setPrice(price);
		}
	}
	
	public boolean importTickets(String filename) throws IOException{
		File file = new File(filename);
		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			String name = sc.nextLine();
			String[] locations = name.split(",");
			seat[Integer.parseInt(locations[0])][Integer.parseInt(locations[1])].setSold(true);
		}
		return true;
	}
	public double totalRevenue() {
		double sum = 0;
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				if(isAvailable(i, j) == false) {
					sum += seat[i][j].getPrice();
				}
			}
		}
		return sum;
	}
	public double totalRevenue(int col) {
		double sum = 0;
		for (int i = 0; i < seat.length; i++) {
			if(isAvailable(i, col) == false) {
				sum+= seat[i][col].getPrice();
			}
		}
		return sum;
	}
	public int totalSold() {
		int count = 0;
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				if(isAvailable(i, j) == false) {
					count++;
				}
			}
		}
		return count;
	}
	public int totalSold(int row) {
		int count = 0;
		for (int i = 0; i < seat[row].length; i++) {
			if(isAvailable(row, i) == false) {
				count++;
			}
		}
		return count;
	}
	public void printVenue() {
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				if (seat[i][j].getSold() == true) {
					System.out.print("S ");
				}
				else{
					System.out.print("N ");
				}
			}
			System.out.println();
		}
	}
	
	public void printVenueType() {
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				System.out.print(seat[i][j].getType() + " ");
			}
			System.out.println();
		}
	}
	public void printVenuePrice() {
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				System.out.print(seat[i][j].getPrice() + " ");
			}
			System.out.println();
		}
	}
	
	public double maxPrice(int rowStart, int rowEnd, int colStart, int colEnd) {
		double max = 0;
		for (int i = 0; i <= rowEnd-rowStart; i++) {
			for (int j = 0; j <= colEnd-colStart; j++) {
				if (seat[i+rowStart][j+colStart].getPrice() > max) {
					max = seat[i+rowStart][j+colStart].getPrice();
				}
			}
		}
		return max;
	}
	public boolean containsGA(int row) {
		boolean contain = true;
		for (int i = 0; i < seat[row].length; i++) {
			if (!(seat[row][i].getType().equals("G"))) {
				contain = false;
			}
		}
		return contain;
	}
	public boolean allPremium(int col) {
		boolean contain = true;
		for (int i = 0; i < seat.length; i++) {
			if (!(seat[i][col].getType().equals("P"))) {
				contain = false;
			}
		}
		return contain;
	}
}
