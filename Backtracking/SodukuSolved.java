package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SodukuSolved { 
	public static void print1DArray(int[] A) {
		// System.out.println();
		for (int i = 0; i < 9; i++) {
			// System.out.print(A[i] + " ");
		}
		// System.out.println();
	}

	public static void print2DArray(int[][] A) {
		 System.out.println();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				 System.out.print(A[i][j] + " ");
			}
			 System.out.println();
		}
		 System.out.println();
	}

	public static int[] takeStartEndofSubGrid(int r, int c) {
		int ans[] = new int[4];
		int sRSubGrid = 0;
		int lRSubGrid = 0;
		int sCSubGrid = 0;
		int lCSubGrid = 0;
		if (r > -1 && r < 3) {
			sRSubGrid = 0;
			lRSubGrid = 3;
			if (c > -1 && c < 3) {
				sCSubGrid = 0;
				lCSubGrid = 3;
			}
			if (c > 2 && c < 6) {
				sCSubGrid = 3;
				lCSubGrid = 6;
			}
			if (c > 5 && c < 9) {
				sCSubGrid = 6;
				lCSubGrid = 9;
			}
		}
		if (r > 2 && r < 6) {
			sRSubGrid = 3;
			lRSubGrid = 6;
			if (c > -1 && c < 3) {
				sCSubGrid = 0;
				lCSubGrid = 3;
			}
			if (c > 2 && c < 6) {
				sCSubGrid = 3;
				lCSubGrid = 6;
			}
			if (c > 5 && c < 9) {
				sCSubGrid = 6;
				lCSubGrid = 9;
			}
		}
		if (r > 5 && r < 9) {
			sRSubGrid = 6;
			lRSubGrid = 9;
			if (c > -1 && c < 3) {
				sCSubGrid = 0;
				lCSubGrid = 3;
			}
			if (c > 2 && c < 6) {
				sCSubGrid = 3;
				lCSubGrid = 6;
			}
			if (c > 5 && c < 9) {
				sCSubGrid = 6;
				lCSubGrid = 9;
			}
		}
		ans[0] = sRSubGrid;
		ans[1] = lRSubGrid;
		ans[2] = sCSubGrid;
		ans[3] = lCSubGrid;
		return ans;
	}

	public static ArrayList<Integer> takeAllPossibleNumbersforVacentBox(int r, int c, int[][] GRID) {
		int[][] subGrid = new int[3][3];
		int[] Allnumbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ArrayList<Integer> Numbers = new ArrayList<Integer>();
		ArrayList<Integer> possibleNumbers = new ArrayList<Integer>();
		int sRSubGrid = 0;
		int lRSubGrid = 0;
		int sCSubGrid = 0;
		int lCSubGrid = 0;
		TreeSet<Integer> possibleNumberstoFill = new TreeSet<Integer>();
		for (int i = 0; i < r; i++) {
			// // System.out.print(GRID[i][c]+ " ");
			if (GRID[i][c] != 0)
				possibleNumberstoFill.add(GRID[i][c]);
		}
		// // System.out.print(" %% ");
		for (int i = r + 1; i < 9; i++) {
			// // System.out.print(GRID[i][c]+ " ");
			if (GRID[i][c] != 0)
				possibleNumberstoFill.add(GRID[i][c]);
		}
		// // System.out.println("\nAfter Row...");
		// // System.out.println(possibleNumberstoFill);
		// // System.out.println();
		for (int i = 0; i < c; i++) {
			// // System.out.print(GRID[r][i] + " ");
			if (GRID[r][i] != 0)
				possibleNumberstoFill.add(GRID[r][i]);
		}
		// // System.out.print(" $$ ");
		for (int i = c + 1; i < 9; i++) {
			// // System.out.print(GRID[r][i] + " ");
			if (GRID[r][i] != 0)
				possibleNumberstoFill.add(GRID[r][i]);
		}
		// // System.out.println("\nAfter Column....");
		// // System.out.println(possibleNumberstoFill);
		int ans[] = takeStartEndofSubGrid(r, c);
		sRSubGrid = ans[0];
		lRSubGrid = ans[1];
		sCSubGrid = ans[2];
		lCSubGrid = ans[3];
		// // System.out.println("Sub Grid...");
		for (int i = sRSubGrid; i < lRSubGrid; i++) {
			for (int j = sCSubGrid; j < lCSubGrid; j++) {
				// if(GRID[i][j]!=0)
				// possibleNumberstoFill.add(GRID[i][j]);
				// // System.out.print(GRID[i][j]+ " ");
			}
			// // System.out.println();
		}
		for (int i = sRSubGrid; i < lRSubGrid; i++) {
			for (int j = sCSubGrid; j < lCSubGrid; j++) {
				if (GRID[i][j] != 0)
					possibleNumberstoFill.add(GRID[i][j]);
			}
		}
		// // System.out.println(possibleNumberstoFill);
		Iterator<Integer> itr = possibleNumberstoFill.iterator();
		// print1DArray(Allnumbers);
		//
		while (itr.hasNext()) {
			Numbers.add(itr.next());
		}
		// // System.out.println(Numbers);
		// for (int i = 0; i < Numbers.size() - 1; i++) {
		//// // System.out.println(Numbers.get(i));
		// if (Numbers.get(i + 1) - Numbers.get(i) > 0) {
		// for (int j = Numbers.get(i) + 1; j < Numbers.get(i + 1); j++) {
		// possibleNumbers.add(j);
		// }
		// }
		// }
		// // System.out.println("Possible Numbers");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < Numbers.size(); j++) {
				if (Allnumbers[i] == Numbers.get(j)) {
					Allnumbers[i] = 0;
					break;
					// possibleNumbers.add(Allnumbers[i]);
				}
			}
		}
		// print1DArray(Allnumbers);
		for (int i = 0; i < 9; i++) {
			if (Allnumbers[i] != 0)
				possibleNumbers.add(Allnumbers[i]);
		}
		// // System.out.println(possibleNumbers);
		return possibleNumbers;

	}

	// public static
	public static ArrayList<Integer> takenumberfromHashMap(int r, int c,
			HashMap<String, ArrayList<Integer>> possibleNumbersforVacentbox, int subNumber) {
		ArrayList<Integer> ans = new ArrayList<>();
		Set<String> KEYS = possibleNumbersforVacentbox.keySet();
		String key = "";
		// print2DArray();
		Iterator<String> itr = KEYS.iterator();
		ArrayList<String> keysarr = new ArrayList<>();
		while (itr.hasNext()) {
			keysarr.add(itr.next());
		}
		// System.out.println("SubGrid Number = "+subNumber);
		// System.out.println("Array list keyset..."+ " r = "+r+" c = "+c);
		// System.out.println(keysarr);
		if (subNumber == 0) {
			r = r + 0;
			c = c + 0;
		}
		if (subNumber == 1) {
			r = r + 0;
			c = c + 3;
		}
		if (subNumber == 2) {
			r = r + 0;
			c = c + 6;
		}
		if (subNumber == 3) {
			r = r + 3;
			c = c + 0;
		}
		if (subNumber == 4) {
			r = r + 3;
			c = c + 3;
		}
		if (subNumber == 5) {
			r = r + 3;
			c = c + 6;
		}
		if (subNumber == 6) {
			r = r + 6;
			c = c + 0;
		}
		if (subNumber == 7) {
			r = r + 6;
			c = c + 3;
		}
		if (subNumber == 8) {
			r = r + 6;
			c = c + 6;
		}
		// System.out.println("R = "+r+" "+" C = "+c);
		for (int i = 0; i < keysarr.size(); i++) {

			if (Integer.parseInt(keysarr.get(i).substring(0, 1)) == r
					&& Integer.parseInt(keysarr.get(i).substring(1, 2)) == c) {
				key = keysarr.get(i);
				break;
			}
			// if(keysarr.get(i).substring(0, 1))
		}
		// for(int i=0;i<possibleNumbersforVacentbox.size();i++) {
		// if(possibleNumbersforVacentbox.)
		// }
		// System.out.println("Value is");
		// System.out.println(possibleNumbersforVacentbox.get(key));
		for (int i = 0; i < possibleNumbersforVacentbox.get(key).size(); i++) {
			ans.add(possibleNumbersforVacentbox.get(key).get(i));
		}
		return ans;
	}

	public static boolean isSodukoSolver(int[][] subGrid,
			HashMap<String, ArrayList<Integer>> possibleNumbersforVacentbox, int subGridNumber) {
		boolean ans = true;
		ArrayList<Integer> TotalNumberinSubGrid = new ArrayList<Integer>();
		TreeSet<Integer> vacentnumbers = new TreeSet<>();
		ArrayList<ArrayList<Integer>> alllistforSubGrid = new ArrayList<>();
//		print2DArray(subGrid);
		for (int i = 0; i < subGrid.length; i++) {
			for (int j = 0; j < subGrid[0].length; j++) {
				if (subGrid[i][j] == 0) {
					alllistforSubGrid.add(takenumberfromHashMap(i, j, possibleNumbersforVacentbox, subGridNumber));
				}
			}
		}
		// System.out.println("Final Tree set of subgrid");
		// System.out.println(alllistforSubGrid);
		for (int i = 0; i < alllistforSubGrid.size(); i++) {
			for (int j = 0; j < alllistforSubGrid.get(i).size(); j++) {
				vacentnumbers.add(alllistforSubGrid.get(i).get(j));
			}
		}
		// System.out.println(vacentnumbers);
		Iterator<Integer> itr = vacentnumbers.iterator();
		while (itr.hasNext()) {
			TotalNumberinSubGrid.add(itr.next());
		}
		for (int i = 0; i < subGrid.length; i++) {
			for (int j = 0; j < subGrid[0].length; j++) {
				if (subGrid[i][j] != 0) {
					TotalNumberinSubGrid.add(subGrid[i][j]);
				}
			}
		}
		if (TotalNumberinSubGrid.size() > 9) {
			ans = false;
		}
		// System.out.println(TotalNumberinSubGrid);
		int sum = 0;
		for (int i = 0; i < TotalNumberinSubGrid.size(); i++) {
			sum = sum + TotalNumberinSubGrid.get(i);
		}
		if (sum != 45) {
			ans = false;
		}
		return ans;
	}

	public static boolean sudokuSolver(int board[][]) {

		/*
		 * Your class should be named Solution. Don't write main() function. Don't read
		 * input, it is passed as function argument. Don't print output and return
		 * output as specified in the question.
		 */
		HashMap<String, ArrayList<Integer>> VacentwithPossibleNumber = new HashMap<String, ArrayList<Integer>>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				// GRID[i][j] = scanner.nextInt();
				if (board[i][j] == 0) {
					// // System.out.println(board[i][j] + " row = " + i + " col = " + j);
					// // System.out.println(takeAllPossibleNumbersforVacentBox(i, j, board));
					VacentwithPossibleNumber.put(Integer.toString(i) + Integer.toString(j),
							takeAllPossibleNumbersforVacentBox(i, j, board));

				}

			}
		}
		// System.out.println("\nWith Possible Numbers");
		// System.out.println(VacentwithPossibleNumber);

		int[][] subGrid = new int[3][3];
		int subGridIndexingArray[][] = { { 0, 3, 0, 3 }, { 0, 3, 3, 6 }, { 0, 3, 6, 9 },

				{ 3, 6, 0, 3 }, { 3, 6, 3, 6 }, { 3, 6, 6, 9 },

				{ 6, 9, 0, 3 }, { 6, 9, 3, 6 }, { 6, 9, 6, 9 }, };
		boolean ans = true;
		for (int i = 0; i < subGridIndexingArray.length; i++) {
			int i1 = 0;
			for (int j = subGridIndexingArray[i][0]; j < subGridIndexingArray[i][1]; j++) {
				int j1 = 0;
				for (int k = subGridIndexingArray[i][2]; k < subGridIndexingArray[i][3]; k++) {
					// // System.out.print(board[j][k]+" ");
					// // System.out.println("i1 = "+i1+" j1 = "+j1++);
					subGrid[i1][j1++] = board[j][k];
				}
				// System.out.println();
				i1++;

			}
//			print2DArray(subGrid);
			if (isSodukoSolver(subGrid, VacentwithPossibleNumber, i) == false) {
				ans = false;
				break;
			}
			// // System.out.println("");
		}

		// 9 0 0 0 2 0 7 5 0
		// 6 0 0 0 5 0 0 4 0
		// 0 2 0 4 0 0 0 1 0
		// 2 0 8 0 0 0 0 0 0
		// 0 7 0 5 0 9 0 6 0
		// 0 0 0 0 0 0 4 0 1
		// 0 1 0 0 0 5 0 8 0
		// 0 9 0 0 7 0 0 0 4
		// 0 8 2 0 4 0 0 0 6

//		 3 0 6 5 0 8 4 0 0
//		 5 2 0 0 0 0 0 0 0
//		 0 8 7 0 0 0 0 3 1
//		 0 0 3 0 1 0 0 8 0
//		 9 0 0 8 6 3 0 0 5
//		 0 5 0 0 9 0 6 0 0
//		 1 3 0 0 0 0 2 5 0
//		 0 0 0 0 0 0 0 7 4
//		 0 0 5 2 0 6 3 0 0

		// print2DArray(board);
		// int indexRnumber = 0;
		// int indexCnumber = 1;
		//
		// takeAllPossibleNumbersforVacentBox(indexRnumber, indexCnumber, board);

		return ans;
	} 
	public static boolean isExistAlreadyRowColumn(int PossibleNumber,int r,int c,int[][] board) {
		boolean ans = false;
		System.out.println();
		for(int i=0;i<board[r].length;i++) {
			System.out.print(board[r][i]+" ");
			
			if(board[r][i]==PossibleNumber) {
				ans = true;
				break;
			}
		}
		System.out.println();
		for(int i=0;i<board[c].length;i++) {
			System.out.print(board[i][c]+ " ");
			if(board[i][c]==PossibleNumber) {
				ans = true;
				break;
			}
		}
		System.out.println();
		return ans;
	}
	 public static void FillSubGrid(int r,int c,ArrayList<Integer> TotalNumberinSubGrid,int subNumber,int[][] board) {
		 
		 if (subNumber == 0) {
				r = r + 0;
				c = c + 0;
			}
			if (subNumber == 1) {
				r = r + 0;
				c = c + 3;
			}
			if (subNumber == 2) {
				r = r + 0;
				c = c + 6;
			}
			if (subNumber == 3) {
				r = r + 3;
				c = c + 0;
			}
			if (subNumber == 4) {
				r = r + 3;
				c = c + 3;
			}
			if (subNumber == 5) {
				r = r + 3;
				c = c + 6;
			}
			if (subNumber == 6) {
				r = r + 6;
				c = c + 0;
			}
			if (subNumber == 7) {
				r = r + 6;
				c = c + 3;
			}
			if (subNumber == 8) {
				r = r + 6;
				c = c + 6;
			}
			System.out.println("SubGrid = "+(subNumber+1));
			if(subNumber==0) {
				for(int i=0;i<TotalNumberinSubGrid.size();i++) {
					if(isExistAlreadyRowColumn(TotalNumberinSubGrid.get(i),r,c,board)) {
						board[r][c] = TotalNumberinSubGrid.get(i);
						TotalNumberinSubGrid.remove(i);
						break;
					}
					else {
						board[r][c] = TotalNumberinSubGrid.get(i);
						TotalNumberinSubGrid.remove(i);
						break;
					}
				}	
			}
			else {
				for(int i=0;i<TotalNumberinSubGrid.size();i++) {
					if(isExistAlreadyRowColumn(TotalNumberinSubGrid.get(i),r,c,board)) {
//						board[r][c] = TotalNumberinSubGrid.get(i);
//						TotalNumberinSubGrid.remove(i);
//						break;
					}
					else {
						board[r][c] = TotalNumberinSubGrid.get(i);
						TotalNumberinSubGrid.remove(i);
						break;
					}
				}	
			}
			
			System.out.println();
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(board[i][j]+" ");
				}
				System.out.println();
			}
			
//			if(TotalNumberinSubGrid.size()==0) {
//				 return;
//			 }
//			FillSubGrid(r, c, TotalNumberinSubGrid, subNumber, board);
			
			
//		 return board;
	 }
	 public static void FillRemainingsubGrid(int[][] subGrid,int subGnumber,ArrayList<Integer> TotalNumberinSubGrid,int[][] board) {
		 System.out.println("Remaing Subgrid");
		 for (int j = subGridIndexingArray[subGnumber][0]; j < subGridIndexingArray[subGnumber][1]; j++) {
				
				for (int k = subGridIndexingArray[subGnumber][2]; k < subGridIndexingArray[subGnumber][3]; k++) {
					System.out.print(board[j][k]+" ");
				}
				System.out.println();

			}
		 print2DArray(subGrid);
		 System.err.println(TotalNumberinSubGrid);
	 }
    public static void EachSubGridFill(int[][] subGrid,
			HashMap<String, ArrayList<Integer>> possibleNumbersforVacentbox, int subGridNumber,int[][] board) {
    	  
    		ArrayList<Integer> TotalNumberinSubGrid = new ArrayList<Integer>();
    		TreeSet<Integer> vacentnumbers = new TreeSet<>();
    		ArrayList<ArrayList<Integer>> alllistforSubGrid = new ArrayList<>();
    		print2DArray(subGrid);
    		for (int i = 0; i < subGrid.length; i++) {
    			for (int j = 0; j < subGrid[0].length; j++) {
    				if (subGrid[i][j] == 0) {
    					alllistforSubGrid.add(takenumberfromHashMap(i, j, possibleNumbersforVacentbox, subGridNumber));
    				}
    			}
    		}
    		// System.out.println("Final Tree set of subgrid");
    		// System.out.println(alllistforSubGrid);
    		for (int i = 0; i < alllistforSubGrid.size(); i++) {
    			for (int j = 0; j < alllistforSubGrid.get(i).size(); j++) {
    				vacentnumbers.add(alllistforSubGrid.get(i).get(j));
    			}
    		}
    		// System.out.println(vacentnumbers);
    		Iterator<Integer> itr = vacentnumbers.iterator();
    		while (itr.hasNext()) {
    			TotalNumberinSubGrid.add(itr.next());
    		}
    		System.out.println("Possible Numbers to SubGrid  "+TotalNumberinSubGrid);
    		for (int i = 0; i < subGrid.length; i++) {
    			for (int j = 0; j < subGrid[0].length; j++) {
    				if (subGrid[i][j] == 0) {
    					FillSubGrid(i, j, TotalNumberinSubGrid, subGridNumber,board);
    				}
    			}
    		}
    		if(TotalNumberinSubGrid.size()>0) {
    			FillRemainingsubGrid(subGrid,subGridNumber,TotalNumberinSubGrid,board);		
    		}
    	
//    		for (int i = 0; i < subGrid.length; i++) {
//    			for (int j = 0; j < subGrid[0].length; j++) {
//    				if (subGrid[i][j] != 0) {
//    					TotalNumberinSubGrid.add(subGrid[i][j]);
//    				}
//    			}
//    		}
//    		print2DArray(subGrid);
//    		System.out.println(TotalNumberinSubGrid);
    		
    		
    }
    public static int subGridIndexingArray[][] = { { 0, 3, 0, 3 }, { 0, 3, 3, 6 }, { 0, 3, 6, 9 },

			{ 3, 6, 0, 3 }, { 3, 6, 3, 6 }, { 3, 6, 6, 9 },

			{ 6, 9, 0, 3 }, { 6, 9, 3, 6 }, { 6, 9, 6, 9 }, };
	public static int[][] SolvedSoduku(int[][] board) {
		int[][] ans = new int[9][9];
		HashMap<String, ArrayList<Integer>> VacentwithPossibleNumber = new HashMap<String, ArrayList<Integer>>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == 0) {
					VacentwithPossibleNumber.put(Integer.toString(i) + Integer.toString(j),
							takeAllPossibleNumbersforVacentBox(i, j, board));

				}

			}
		}
		int[][] subGrid = new int[3][3];
		
		for (int i = 0; i < subGridIndexingArray.length; i++) {
			int i1 = 0;
			for (int j = subGridIndexingArray[i][0]; j < subGridIndexingArray[i][1]; j++) {
				int j1 = 0;
				for (int k = subGridIndexingArray[i][2]; k < subGridIndexingArray[i][3]; k++) {
					subGrid[i1][j1++] = board[j][k];
				}
				i1++;

			}
//			print2DArray(subGrid);
			 EachSubGridFill(subGrid, VacentwithPossibleNumber, i,board);
//				break;
			}
		System.out.println("Final Grid is ");
		System.out.println();
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}

		return ans;

	}
    public static int[][] GRID = new int[9][9];
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				GRID[i][j] = scanner.nextInt();
			}
		}
		if (sudokuSolver(GRID)) {
			SolvedSoduku(GRID);
		} else {
			System.out.println("You can not solve this soduku...");
		}
		scanner.close();
	}
}
