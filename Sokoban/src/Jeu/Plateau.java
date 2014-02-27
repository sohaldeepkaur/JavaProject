package Jeu;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.io.*; 

public class Plateau {
	
	private Case tabCases [][];

	public Case getTabCases(Integer x, Integer y) 
		{
			return tabCases[x][y];
		}

	//x et y représentent les dimentions du tableau
	public void setTabCases(Integer x, Integer y)
		{
			this.tabCases = new Case [y][x];
			for (int i = 0; i < y; i++) { //verticale
				for (int j = 0; j < x; j++) { //horizontale
					
					tabCases[i][j] = new Case(" ");
				}
			}
			this.tabCases = tabCases;
		}
	public void setTabCasesAvecValeur(Integer x, Integer y, String lettre)
		{
			
					
					this.tabCases[x][y].setEtat(lettre);
				
			
		}
	public Plateau()
		{
			
		}
	public Plateau(String fichier)
		{
			Integer i=0;
			Integer j=0;
			Integer x=0;
			Integer y=0;
			Integer xMax=0;
			
			 Scanner sc = null;
			 try
				 {
					 sc = new Scanner(new File(fichier));
					 while (sc.hasNextLine()) 
		             {
						 y++;
						 x=0;
		                 for (char c : sc.next().toCharArray()) 
			                 {
		                	 	x++;
			                 }
		                 if (x>xMax)
			                 {
			                	xMax=x; 
			                 }
		             }
					
					 this.setTabCases(xMax, y);
					 sc.close();
					 sc = new Scanner(new File(fichier));
					 
			         while (sc.hasNextLine()) 
			             {
			        	 	
			        	 	j=0;
			                 for (char c : sc.next().toCharArray()) 
				                 {
			                	 	String s = Character.toString(c);
			                	 	//System.out.println(s);
			                	 	setTabCasesAvecValeur(i, j, s);
			                	 	j++;
				                 }
			                 for (Integer n=j; i==xMax ; i++)
				                 {
			                	 	setTabCasesAvecValeur(n, j, ".");
				                 }
			                 i++;
			             }
			         sc.close();
				 }
			 catch (Exception e)
				{
					System.out.println(e.toString());
				}
		}
	
	public void chargerPlateauDepuisFichier(String fichier)
		{
			
			Integer i=0;
			Integer j=0;
			Integer x=0;
			Integer y=0;
			Integer xMax=0;
			
			 Scanner sc = null;
			 try
				 {
					 sc = new Scanner(new File(fichier));
					 while (sc.hasNextLine()) 
		             {
						 y++;
						 x=0;
		                 for (char c : sc.next().toCharArray()) 
			                 {
		                	 	x++;
			                 }
		                 if (x>xMax)
			                 {
			                	xMax=x; 
			                 }
		             }
					
					 this.setTabCases(xMax, y);
					 sc.close();
					 sc = new Scanner(new File(fichier));
					 
			         while (sc.hasNextLine()) 
			             {
			        	 	
			        	 	j=0;
			                 for (char c : sc.next().toCharArray()) 
				                 {
			                	 	String s = Character.toString(c);
			                	 	//System.out.println(s);
			                	 	setTabCasesAvecValeur(i, j, s);
			                	 	j++;
				                 }
			                 for (Integer n=j; i==xMax ; i++)
				                 {
			                	 	setTabCasesAvecValeur(n, j, ".");
				                 }
			                 i++;
			             }
			         sc.close();
				 }
			 catch (Exception e)
				{
					System.out.println(e.toString());
				}
			
		}
	// renvoie un array avec en [0] y et en [1] x
	public Integer[] dimentionDeTabCases()
		{
			Integer retour[] = null;
			retour[0]=this.tabCases.length;
			retour[1]=0;
			for (Integer i=0; i==retour[0]; i++)
				{
					if (retour[1]<this.tabCases[i].length)
						{
							retour[1]=this.tabCases[i].length;
						}
				}
			
			return retour;
		}
	public void afficherPlateau()
		{
			Integer[] dimention = this.dimentionDeTabCases();
		}
	

}
