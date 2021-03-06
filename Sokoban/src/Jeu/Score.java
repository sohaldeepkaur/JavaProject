package Jeu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Personage.Personage;

public class Score implements java.io.Serializable{
	
	private Integer nombreDeplacement;
	private long timeStampDebut;
	private long timeStampFin;
	private String nom;
	private Integer level;
	
	public Integer getNombreDeplacement() {
		return nombreDeplacement;
	}
	public void setNombreDeplacement(Integer nombreDeplacement) {
		this.nombreDeplacement = nombreDeplacement;
	}
	public long getTimeStampDebut() {
		return timeStampDebut;
	}
	public void setTimeStampDebut(long timeStampDebut) {
		this.timeStampDebut = timeStampDebut;
	}
	public long getTimeStampFin() {
		return timeStampFin;
	}
	public void setTimeStampFin(long timeStampFin) {
		this.timeStampFin = timeStampFin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Score()
		{
			this.setLevel(0);
			this.setNom("");
			this.setNombreDeplacement(0);
			this.setTimeStampDebut(0);
			this.setTimeStampFin(0);
		}
	public Score(Personage joueur, Plateau plat) 
		{
			this.setLevel(joueur.getLevel());
			this.setNom(joueur.getNom());
			this.setNombreDeplacement(plat.getNombreDeplacement());
			this.setTimeStampDebut(plat.getTimeStampDebut());
			this.setTimeStampFin(plat.getTimeStampFin());
		}
	public void setScoreAPartirDuFichier () 
		{
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		long timeStamp;
		java.util.Date date= new java.util.Date();
		timeStamp=date.getTime();
		File fichier = new File("Scores\\level"+this.getLevel()+"\\"+timeStamp+".txt");
		if (fichier.exists())
			{
				try 
					{
						
						fis = new FileInputStream("Scores\\level"+this.getLevel()+"\\"+timeStamp+".txt");
						ois = new ObjectInputStream(fis);
						//try 
							//{
								//liste = (Score) ois.readObject();
							//} 
						//catch (ClassNotFoundException e) 
							//{
							
								//e.printStackTrace();
							//}
						//this.listeDesScores = liste.listeDesScores;
						
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
	public void ecritureDeScoreDansFichier()
		{
			FileOutputStream fos = null;
			ObjectOutputStream oos = null;
			try 
				{
					
					long timeStamp;
					java.util.Date date= new java.util.Date();
					timeStamp=date.getTime();
					fos = new FileOutputStream("Scores\\level"+this.getLevel()+"\\"+timeStamp+".txt");
					oos = new ObjectOutputStream(fos);
					
					
					
						
					File fichier = new File("Scores\\level"+this.getLevel()+"\\"+timeStamp+".txt");	
					
					fichier.createNewFile();
						
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
