import java.util.Scanner;

public class num1 {

	// hide and seek
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		Scanner keyboard = new Scanner(System.in);
		String m = keyboard.next();
		String n = keyboard.next();
		String your_position = keyboard.next();
		String furniture = keyboard.next();
		String seekers = keyboard.next();
		
		/*System.out.println(m);
		System.out.println(n);
		System.out.println(your_position);
		System.out.println(furniture);
		System.out.println(seekers);*/
				
		int matrix[][] = new int[Integer.parseInt(m)][Integer.parseInt(n)];
		int pos_a = Integer.parseInt(your_position.substring(1,2));
		int pos_b = Integer.parseInt(your_position.substring(3,4));
		
		String split_furniture[] = furniture.split("]");
		for(int i=0 ; i<split_furniture.length ; i++) { 
			split_furniture[i] = split_furniture[i].substring(2);
		}
		int furniture_pos[][] = new int[split_furniture.length][2];
		String[] array1 = new String[split_furniture.length];
		for(int i=0 ; i<split_furniture.length ; i++) {
			for(int j=0 ; j<2 ; j++) {
				array1 = split_furniture[i].split(",");
				furniture_pos[i][j] = Integer.parseInt(array1[j]);
			}
		}
		
		String split_seekers[] = seekers.split("]");
		for(int i=0 ; i<split_seekers.length ; i++) { 
			split_seekers[i] = split_seekers[i].substring(2);
		}
		int seeker_pos[][] = new int[split_seekers.length][2];
		String[] array2 = new String[split_seekers.length];
		for(int i=0 ; i<split_seekers.length ; i++) {
			for(int j=0 ; j<2 ; j++) {
				array2 = split_seekers[i].split(",");
				seeker_pos[i][j] = Integer.parseInt(array2[j]);
			}
		}
		
		//ALGORITHM
		//assign all pos to true
		for(int i=0 ; i<Integer.parseInt(m) ; i++) {
			for(int j=0 ; j<Integer.parseInt(n) ; j++) {
				 matrix[i][j] = 1;
			}
		}
		
		//make the post of the furniture to false
		for(int i=0 ; i<split_furniture.length ; i++) {
			matrix[furniture_pos[i][0]][furniture_pos[i][1]] = 2;
		}
		
		//seeker
		for(int i=0 ; i<split_seekers.length ; i++) {
			matrix[seeker_pos[i][0]][seeker_pos[i][1]] = 0;
			int poscol = seeker_pos[i][1];
			int posrow = seeker_pos[i][0];
			//moving right
			for(int j=poscol+1 ; j<Integer.parseInt(n) ; j++) {
				if (matrix[posrow][j] == 2) {
					break;
				}
				matrix[posrow][j] = 0;
			}
			//moving left
			for(int j=poscol-1 ; j>=0 ; j--) {
				if (matrix[posrow][j] == 2) {
					break;
				}
				matrix[posrow][j] = 0;
			}
			//moving up
			for(int j=posrow-1 ; j>=0 ; j--) {
				if (matrix[j][poscol] == 2) {
					break;
				}
				matrix[j][poscol] = 0;
			}
			//moving down
			for(int j=posrow+1 ; j<Integer.parseInt(m) ; j++) {
				if (matrix[j][poscol] == 2) {
					break;
				}
				matrix[j][poscol] = 0;
			}
		}
		
		// print matrix
		/*for(int i=0 ; i<Integer.parseInt(m) ; i++) {
			for(int j=0 ; j<Integer.parseInt(n) ; j++) {
				if(j==Integer.parseInt(n)-1)
					System.out.println(matrix[i][j]);
				else
					System.out.print(matrix[i][j] + " ");
				 matrix[i][j] = 1;
			}
		}*/
		
		if(matrix[pos_a][pos_b] == 1) {
			System.out.println("false");
		}else {
			System.out.println("true");
		}
	}

}


