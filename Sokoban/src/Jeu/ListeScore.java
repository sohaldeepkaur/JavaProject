package Jeu;

import java.io.*; 

import Personage.Personage;

public class ListeScore {
	private Score [] listeDesScores;
	private Integer level;

	public Score[] getListeDesScores() 
		{
			return listeDesScores;
		}

	public void setListeDesScores(Score[] listeDesScores) 
		{
			this.listeDesScores = listeDesScores;
		}
	
	public Integer getLevel() 
		{
			return level;
		}

	public void setLevel(Integer level) 
		{
			this.level = level;
		}

	public ListeScore ()
		{
			this.initialisationListe();
		}
	public void initialisationListe()
		{
			Score liste[]= new Score [0];
			this.setListeDesScores(liste);
		}
	public void genererListeAPartirDuFichier(Integer level)
		{
			this.setLevel(level);
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			File fichier = new File("Scores\\level"+this.getLevel()+".txt");
			if (fichier.exists())
				{
					try 
						{
							ListeScore liste= new ListeScore();
							fis = new FileInputStream("Scores\\level"+level+".txt");
							ois = new ObjectInputStream(fis);
							try 
								{
									liste = (ListeScore) ois.readObject();
								} 
							catch (ClassNotFoundException e) 
								{
								
									e.printStackTrace();
								}
							this.listeDesScores = liste.listeDesScores;
							
						} 
					catch (IOException e) 
						{
							System.out.println(e.toString());
						} 
					finally 
						{ 
							try
								{
									fis.close();
									ois.close();
								}
							catch (IOException e) 
								{
									System.out.println(e.toString());
								}
							
							
						}
				}
			

		}
	public void miseAJourDesScores(Personage joueur, Plateau plat)
		{
			//pr�paration de l'objet liste
			this.genererListeAPartirDuFichier(joueur.getLevel());
			
			if (this.getListeDesScores().length==0)
				{
					Score[] liste= new Score [1];
					for (Integer i=0; i<1; i++)
					{
						Score scNull = new Score();
						liste[i]=scNull;
					}
					System.out.println(liste[0].getLevel());
					liste[0].setLevel(joueur.getLevel());
					liste[0].setNom(joueur.getNom());
					liste[0].setNombreDeplacement(plat.getNombreDeplacement());
					liste[0].setTimeStampDebut(plat.getTimeStampDebut());
					liste[0].setTimeStampFin(plat.getTimeStampFin());
				}
			else
				{
					Score[] liste= new Score [(this.getListeDesScores().length)+1];
					for (Integer i=0; i<this.getListeDesScores().length; i++)
						{
							liste[i]=this.getListeDesScores()[i];		
						}
					liste[this.getListeDesScores().length].setLevel(joueur.getLevel());
					liste[this.getListeDesScores().length].setNom(joueur.getNom());
					liste[this.getListeDesScores().length].setNombreDeplacement(plat.getNombreDeplacement());
					liste[this.getListeDesScores().length].setTimeStampDebut(plat.getTimeStampDebut());
					liste[this.getListeDesScores().length].setTimeStampFin(plat.getTimeStampFin());
					
				}
			
			
			//stocage de l'objet liste dans un fichier
			FileOutputStream fos = null;
			ObjectOutputStream oos = null;
			try 
				{
					
			
					fos = new FileOutputStream("Scores\\level"+this.getLevel()+".txt");
					oos = new ObjectOutputStream(fos);
					//cr�ation du fichier si il n'existe pas
					File fichier = new File("Scores\\level"+this.getLevel()+".txt");	
					if (! fichier.exists())
						{
						  fichier.createNewFile();
						}
					//�criture de l'objet dans le fichier
					oos.writeObject(this); 	// Serialization
				} 
			catch (IOException e)
				{
					System.out.println(e.toString());
				}
			finally 
				{
					try
						{
						   fos.close();
						   oos.close();
						}
					catch (IOException e)
						{
							System.out.println(e.toString());
						}
					
				}
			
		}
}
