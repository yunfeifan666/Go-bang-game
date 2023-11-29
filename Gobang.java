import java.util.Scanner;
public class Gobang{
	public static void main(String [ ] args) {
		new Gobang().run();		
}
	public void run() {
	//enter user's information
	    Scanner in = new Scanner(System.in);
	    System.out.println("User's pieces: x");
	    System.out.print("UserName:");
	    String nameBlack = in.nextLine();
	    System.out.println("Computer's pieces: o");
	    String nameWhite = "Computer";
	    
	//create board
		int size=15;
		int[][] table = new int[size][size];		
		printTable(table, size);
	
		  int win = 0;
		  
		  int currentPlayer = 0;
		  
		  //create Match to prevent the later move and previous move have the same position
		  int Match[][] = new int[15][15];
		  for(int i=0; i < size; ++i)
              for(int j=0; j<size; ++j)
            	  Match[i][j] = 0;
		  //user move
		  do {
			  
			  String playerName = currentPlayer == 0 ? nameBlack : nameWhite;
			  System.out.println("It's " + playerName + " 's turn.");
			
			  int x = 0, y = 0;
			  if(playerName==nameBlack)
			  {
				  //
				  int abscissaNum=0;
				  int ordinateNum=0;
				  int slopeNum1=0;
				  int slopeNum2=0;
				  int tx=0,ty=0;
				  //
			  boolean canPlace = true;
			  do {
				  if(!canPlace)
				  {
					  System.out.println("That is not a legal move, please enter a move again.");  
				  }
			          String code = in.nextLine();
			          y = code.charAt(0)-'A';
			          x = Integer.valueOf(code.substring(1))-1;
			         
			          
			          canPlace = true;
			          canPlace = canPlace && x>=0 && x<size;
			          canPlace = canPlace && y>=0 && y<size;
			          canPlace = canPlace && table[y][x] == 0;
			          
			          
			  } while(!canPlace||Match[y][x]==1||Match[y][x]==2);
			  
			  table[y][x] = currentPlayer == 0 ? 1:2;
			  currentPlayer++;
			  currentPlayer %= 2;
			  printTable(table, size);
			  
    		//restore user's move into Match  
    		  Match[y][x]=1;
    		  tx=x;
    		  ty=y;
    		//identify the number of user's pieces in column 
    			while(true)
    			{
    				if(y==14)
    					break;
    				else
    				{
    					y++;
        				if(Match[y][x]==1)
        					abscissaNum++;
        				else
        					break;
    				}    				
    			}
    			x=tx;
    			y=ty;
    			while(true)
    			{
    				if(y==0)
    					break;
    				else
    				{
    					y--;
    					if(Match[y][x]==1)
    						abscissaNum++;
    					else
    						break;
    				}
    			}
    			if(abscissaNum>4||abscissaNum==4)
    				win=1;
    			
    			
    			
    			//identify the number of user's pieces in row  
    			x=tx;
    			y=ty;
    			while(true)
    			{
    				if(x==14)
    					break;
    				else
    				{
    					x++;
        				if(Match[y][x]==1)
        					ordinateNum++;
        				else
        					break;
    				}    				
    			}
    			x=tx;
    			y=ty;
    			while(true)
    			{
    				if(x==0)
    					break;
    				else
    				{
    					x--;
    					if(Match[y][x]==1)
    						ordinateNum++;
    					else
    						break;
    				}
    			}
    			if(ordinateNum>4||ordinateNum==4)
    				win=1;
    			
    			
    			//identify the number of user's pieces from upper left to lower right
    			x=tx;
    			y=ty;
    			while(true)
    			{
    				if(x==14||y==14)
    					break;
    				else
    				{
    					y++;
    					x++;
        				if(Match[y][x]==1)
        					slopeNum1++;
        				else
        					break;
    				}    				
    			}
    			
    			x=tx;
    			y=ty;
    			while(true)
    			{
    				if(x==0||y==0)
    					break;
    				else
    				{
    					x--;
    					y--;
    					if(Match[y][x]==1)
    						slopeNum1++;
    					else
    						break;
    				}
    			}
    			if(slopeNum1>4||slopeNum1==4)
    				win=1;
    			
    			
    			//identify the number of user's pieces from upper right to lower left
    			x=tx;
    			y=ty;
    			while(true)
    			{
    				if(x==14||y==0)
    					break;
    				else
    				{
    					y--;
    					x++;
        				if(Match[y][x]==1)
        					slopeNum2++;
        				else
        					break;
    				}    				
    			}
    			
    			x=tx;
    			y=ty;
    			while(true)
    			{
    				if(x==0||y==14)
    					break;
    				else
    				{
    					x--;
    					y++;
    					if(Match[y][x]==1)
    						slopeNum2++;
    					else
    						break;
    				}
    			}
    			if(slopeNum2>4||slopeNum2==4)
    				win=1;    			
			  }
			  
			  
			  
			  
			//computer move 
			  else
			  {
				  int abscissaNum1=0;
				  int ordinateNum1=0;
				  int slopeNum11=0;
				  int slopeNum21=0;
				  int tx1=0,ty1=0;
				  do 
				 {
				  x = (int) (Math.random() * size+1);
				  y = (int) (Math.random() * size+1);
				 
				  char z = 0;
				  
				  switch(y)
				  {
				    case 1 :
				           z='A';
				            break; 
				    case 2 :
					       z='B';
					       break; 
				    case 3 :
					       z='C';
					       break; 
				    case 4 :
					       z='D';
					       break; 
				    case 5 :
					       z='E';
					       break; 
				    case 6 :
					       z='F';
					       break; 
				    case 7 :
					       z='G';
					       break; 
				    case 8 :
					       z='H';
					       break; 
				    case 9 :
					       z='I';
					       break; 
				    case 10 :
					       z='J';
					       break; 
				    case 11 :
					       z='K';
					       break; 
				    case 12 :
					       z='L';
					       break; 
				    case 13 :
					       z='M';
					       break; 
				    case 14 :
					       z='N';
					       break; 
				    case 15 :
					       z='O';
					       break; 				  
				    default :     
				  }
				  //print computer's move
				  System.out.print(z);
				  System.out.println(x);
				  
				  y=y-1;
				  x=x-1;
				 }while(Match[y][x] == 1||Match[y][x]==2);
				
				
				  table[y][x] = currentPlayer == 0 ? 1:2;
				  currentPlayer++;
				  currentPlayer %= 2; 
			      printTable (table, size); 	
			    //restore user's move into Match
			     Match[y][x]=2;
				  
			     tx1=x;
	    		  ty1=y;
	    		//identify computer's pieces in column  
	    			while(true)
	    			{
	    				if(y==14)
	    					break;
	    				else
	    				{
	    					y++;
	        				if(Match[y][x]==2)
	        					abscissaNum1++;
	        				else
	        					break;
	    				}    				
	    			}
	    			x=tx1;
	    			y=ty1;
	    			while(true)
	    			{
	    				if(y==0)
	    					break;
	    				else
	    				{
	    					y--;
	    					if(Match[y][x]==2)
	    						abscissaNum1++;
	    					else
	    						break;
	    				}
	    			}
	    			if(abscissaNum1>4||abscissaNum1==4)
	    				win=2;
	    			
	    			
	    			
	    			//identify computer's pieces in row  
	    			x=tx1;
	    			y=ty1;
	    			while(true)
	    			{
	    				if(x==14)
	    					break;
	    				else
	    				{
	    					x++;
	        				if(Match[y][x]==2)
	        					ordinateNum1++;
	        				else
	        					break;
	    				}    				
	    			}
	    			x=tx1;
	    			y=ty1;
	    			while(true)
	    			{
	    				if(x==0)
	    					break;
	    				else
	    				{
	    					x--;
	    					if(Match[y][x]==2)
	    						ordinateNum1++;
	    					else
	    						break;
	    				}
	    			}
	    			if(ordinateNum1>4||ordinateNum1==4)
	    				win=2;
	    			
	    			
	    			//identify computer's pieces in row 
	    			x=tx1;
	    			y=ty1;
	    			while(true)
	    			{
	    				if(x==14||y==14)
	    					break;
	    				else
	    				{
	    					y++;
	    					x++;
	        				if(Match[y][x]==2)
	        					slopeNum11++;
	        				else
	        					break;
	    				}    				
	    			}
	    			
	    			x=tx1;
	    			y=ty1;
	    			while(true)
	    			{
	    				if(x==0||y==0)
	    					break;
	    				else
	    				{
	    					x--;
	    					y--;
	    					if(Match[y][x]==2)
	    						slopeNum11++;
	    					else
	    						break;
	    				}
	    			}
	    			
	    			if(slopeNum11>4||slopeNum11==4)
	    				win=2;
	    			
	    			
	    			//identify computer's pieces from upper right to lower left
	    			x=tx1;
	    			y=ty1;
	    			while(true)
	    			{
	    				if(x==14||y==0)
	    					break;
	    				else
	    				{
	    					y--;
	    					x++;
	        				if(Match[y][x]==2)
	        					slopeNum21++;
	        				else
	        					break;
	    				}    				
	    			}
	    			
	    			x=tx1;
	    			y=ty1;
	    			while(true)
	    			{
	    				if(x==0||y==14)
	    					break;
	    				else
	    				{
	    					x--;
	    					y++;
	    					if(Match[y][x]==2)
	    						slopeNum21++;
	    					else
	    						break;
	    				}
	    			}
	    			
	    			if(slopeNum21>4||slopeNum21==4)
	    				win=2; 
			     
	     
			  }
			
			  
			 			  			
			  
			  
			  
		  } while (win == 0);
		  
		  //win or fail?
		  if (win == 1) {
		   System.out.println(nameBlack + "wins");
		  } else if (win == 2) {
		   System.out.println("Computer wins");
		  } 
		}
	
	//print board
	public void printTable(int[][] table, int size) {
	System.out.print("   ");
	
	for (int i = 0; i < size; i++) {
		int value = i + 1;
		System.out.print(value < 10 ? value + "  ": value + " ");
	}
	System.out.println();
	
	for (int i = 0; i < size; i++) {
		char title = (char)('A'+i);
		System.out.print(title + " ");
		
		
		for (int j =0; j < size; j++) {
			int value = table[i][j];
			char c = ' ';
			switch (value) {
			case 0: c='.'; break;
			case 1: c='x'; break;
			case 2: c='o'; break;
			}
			System.out.print(c + "  ");	
		}
		System.out.println();
	}
}
}
// My program makes these functions true:
//1. the creation of board.
//2. user's move and computer's automove.
//3. computer's pieces wouldn't be at the position where there has been a piece. 
//4. if the user's piece is at the position where there has been a piece after a move, it will show error and guide the user to enter a new position.
//5. the identification of win or fail
//the mechanism of this identification:
// when the user or computer moves, 
// the program researches the number of contiguous pieces in four directions, 
// which is in column, in row, from upper left to lower right, and  from upper right to lower left.
// if the number of contiguous pieces in any of the directions is greater than or equal to 4, it will show win.
// the program prevents array out of bounds when researching the number of contiguous pieces in four directions.  