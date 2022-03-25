// Kalrav Srivastava
// ks874
// CS 435
// Fall 2021
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class Sort
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

        System.out.println("Please specify the input file (default = f.txt ): ");
        String inFile = in.nextLine();
		if (inFile == "")
		{
			inFile = "f.txt";
		}
		System.out.println("Please specify the outputput file (default = g.txt ): ");
        String outFile = in.nextLine();
		if (outFile == "")
		{
			outFile = "g.txt";
		}

		in.close();
		
        String[] lines = new String[1000];
		BufferedReader reader;
		int i = 0;
		try
		{
			reader = new BufferedReader(new FileReader(inFile));
			String line = reader.readLine();

			while (line != null)
			{
				int len = line.length();
				if (len < 21)
				{
				    String temp = "";
				    while (len < 21)
				    {
				        temp = temp + " ";
				        len++;
				    }
				    line = temp + line;
				}
				lines[i] = line;
				line = reader.readLine();
				i++;
			}
			reader.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		int[] P = new int[i];
		int[] tmp = new int[i];
		for (int j = 0; j < i; j++)
		{
		    P[j] = j;
		}
		
		int[][] arr = new int[27][];
		
		for (int k = 0; k < 27; k++)
		{
		    arr[k] = new int[i];
		    for (int g = 0; g < i; g++)
		    {
		        arr[k][g] = -1;
		    }
		}
		
		char[] alpha = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		
		for (int k = 20; k >= 0; k--)
		{
		    int[] cnt = new int[27];
		    for (int l = 0; l < 27; l++)
		    {
		        cnt[k] = 0;
		    }
		    
		    for (int u = 0; u < i; u++)
		    {
		        for (int h = 0; h < 27; h++)
		        {
		            if (lines[P[u]].charAt(k) == alpha[h])
		            {
		                arr[h][cnt[h]] = u;
		                cnt[h]++;
		                break;
		            }
		        }
		        
		    }
		    
		    int u = 0;
		    while (u < i)
		    {
		        int row = 0;
		        while (row < 27)
		        {
		            int col = 0;
		            while(col < i)
		            {
		                if (arr[row][col] == -1)
		                {
		                    break;
		                }
		                else if (arr[row][col] < i && arr[row][col] >=0)
		                {
		                    P[u] = arr[row][col];
		                    u++;
		                    arr[row][col] = -1;
		                }
		                col++;
		            }
		            row++;
		        }
		    }
		    
		    if (k != 20)
		    {
    		    for (int j = 0; j < i; j++)
    		    {
    		        P[j] = tmp[P[j]];
    		    }
		    }
		    
		    for (int j = 0; j < i; j++)
    		{
    		    tmp[j] = P[j];
    		}
		}


		try
		{
			FileWriter myWriter = new FileWriter(outFile);

			int u = 0;
			while (u < i)
			{
		    	String hud = "";
		    	for (int y = 0; y < 21; y++)
		    	{
		    	    if(lines[P[u]].charAt(y) != ' ')
		    	    {
		    	        hud = hud + lines[P[u]].charAt(y);
		    	    }
		    	}
				
				if (u != (i - 1))
				{
		    		lines[P[u]] = hud + "\n";
				}
		    	//System.out.println(lines[P[u]]);
				myWriter.write(lines[P[u]]);
		    	u++;
			}

			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		}
		catch (IOException e)
		{
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}