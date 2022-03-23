package Lab3_2;

import java.lang.Math;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.Spring;


public class Dispatcher {

	static Scanner scan = new Scanner(System.in);

	static public class Note
	{
	    public String name;
	    public String last_name;
	    public String telephone;
	    public int day;
	    public int month;
	    public int year;

	    public Note(String name, String last_name, String telephone, int day, int month, int year)
	    {
	    	this.name = name;
	    	this.last_name = last_name;
	    	this.telephone = telephone;
     		this.day = day;
	    	this.month = month;
     		this.year = year;
	    }
	    public void setName(String name_str) {
	    	name = name_str;
	    }
	    public void setLastName(String last_name_str) {
	    	last_name = last_name_str;
	    }
	    public void setAge(String telephone_str) {
	    	telephone = telephone_str;
	    }
	    public void setDay(int day_str) {
	    	day = day;
	    }
	    public void setMonth(int month_str) {
	    	month = month_str;
	    }
	    public void setYear(int year_str) {
	    	year = year_str;
	    }
	}

	public static void main(String[] args) {
        int N;
        System.out.print("Insert N: ");
        N = scan.nextInt();
        Note[] n = new Note[N];

        for (int i = 0; i < N; i++) {
        	n[i] = new Note("", "", "", 0, 0, 0);
        }

        Create(n, N);
        Print(n, N);
        Menu(n, N);
	}

	static void Create(Note[] n, int N)
	{
	    for (int i = 0; i < N; i++)
	    {
	    	System.out.println("Person ¹ " + (i + 1));
	    	System.out.print(" Name : ");
	    	n[i].name = scan.nextLine();
	    	n[i].name = scan.nextLine();
	        System.out.print(" Last Name : ");
	        n[i].last_name = scan.nextLine();
	        System.out.print(" Telephone : ");
	        n[i].telephone = scan.nextLine();
	        System.out.print(" Birthday Day : ");
	        n[i].day = scan.nextInt();
	        System.out.print(" Birthday Month : ");
	        n[i].month = scan.nextInt();
	        System.out.print(" Birthday Year : ");
	        n[i].year = scan.nextInt();
	        System.out.println("");
	    }
	}
	static void Print(Note[] n, int N)
	{
		System.out.println("=============================================================================");
		System.out.println("| ¹ | Name | Last Name | Telephone | Day | Month | Year |");
		System.out.println("-----------------------------------------------------------------------------");
	    for (int i = 0; i < N; i++) {
	    	String str_1 = String.format("|%-3d|", i+1);
			String str_2 = String.format("%-6s|", n[i].name);
			String str_3 = String.format("%-11s|", n[i].last_name);
			String str_4 = String.format("%-11s|", n[i].telephone);
			String str_5 = String.format("%-5d|", n[i].day);
			String str_6 = String.format("%-7d|", n[i].month);
			String str_7 = String.format("%-6d|", n[i].year);
	    	System.out.println(str_1 + str_2 + str_3 + str_4 + str_5 + str_6 + str_7);
	    }
	    System.out.println("=============================================================================");
	    System.out.println("");
	}
	static void Menu(Note[] n, int N)
	{
	    int choice;
	    do
	    {
	    	System.out.println("--------------------------");
	    	System.out.println("Main Menu");
	    	System.out.println("Please make your selection");
	        System.out.println("1 - Sort");
	        System.out.println("2 - Search");
	        System.out.println("3 - Quit");
	        System.out.println("--------------------------");
	        System.out.println("Selection: ");
	        choice = scan.nextInt();
	        switch (choice)
	        {
	            case 1:
	            	System.out.println("You Chosen 1 - Sort:");
	                Sort(n, N);
	                Print(n, N);
	                break;
	            case 2:
	            	System.out.println("You Chosen 2 - Binary Search:");
	                String btelephone = "";
	                int found;
	                System.out.println("Enter Keys For Search:");
	                System.out.print(" Telephone: ");
	                btelephone = scan.nextLine();
	                btelephone = scan.nextLine();
	                if ((found = Search(n, N, btelephone)) != -1)
	                {
	                	System.out.println("Student Found On Position: " + (found + 1));
	                }
	                else
	                {
	                	System.out.println("Student Not Found");
	                }
	                break;
	            case 3:
	            	System.out.println("Goodbye! See Ya Later, Aligator!!!");
	                break;
	            default:
	            	System.out.println("--------------------------");
	            	System.out.println("Main Menu");
	            	System.out.println("Please make your selection");
	                System.out.println("1 - Sort");
	                System.out.println("2 - Search");
	                System.out.println("3 - Quit");
	                System.out.println("--------------------------");
	                System.out.print("Selection: ");
	                choice = scan.nextInt();
	                break;
	        }
	    } while (choice != 3);
	}
	static void Sort(Note[] n, int N)
	{
	    Note tmp;
	    for (int i0 = 0; i0 < N - 1; i0++) {
	        for (int i1 = 0; i1 < N - i0 - 1; i1++) {
	            if (n[i1].year < n[i1 + 1].year) {
	                tmp = n[i1];
	                n[i1] = n[i1 + 1];
	                n[i1 + 1] = tmp;
	            }
	            else if (n[i1].year == n[i1 + 1].year)
	            {
	                if (n[i1].month < n[i1 + 1].month) {
	                    tmp = n[i1];
	                    n[i1] = n[i1 + 1];
	                    n[i1 + 1] = tmp;
	                }
	                else if (n[i1].month == n[i1 + 1].month)
	                {
	                    if (n[i1].day < n[i1 + 1].day) {
	                        tmp = n[i1];
	                        n[i1] = n[i1 + 1];
	                        n[i1 + 1] = tmp;
	                    }
	                }
	            }
	        }
	    }
	}
	static int Search(Note[] n, int N, String btelephone)
	{
	    for (int i = 0; i < N; i++)
	    {
	        if(btelephone.equals(n[i].telephone))
	        {
	            return i;
	        }
	    }
	    return -1;
	}
}
