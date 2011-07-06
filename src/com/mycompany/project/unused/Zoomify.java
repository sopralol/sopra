package com.mycompany.project.client;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.*;
import org.apache.batik.transcoder.*;
import org.apache.batik.transcoder.image.*;

import com.google.gwt.user.client.ui.PopupPanel;

/**
 * Tut was
 * @author Philipp Hitzigrath
 *
 */
public class Zoomify extends PopupPanel {


	public Zoomify() throws IOException {


		File f = new  File("/Applications/eclipse/workspace/Image/bin/Niveau_1.svg");//Bildname
		BufferedImage img = ImageIO.read(f);//Bild einlesen

		int w = img.getWidth(); // Breite alt: x
		int h = img.getHeight();// Hhe alt: y

		//Startbild als 0-0-0.png abspeichern &
		for (int zoomstufe = 1; zoomstufe < 5; zoomstufe++) { // Ausere  Schleife fuerdie Zoomstufen

			int zerlegung = (int) Math.pow(2, zoomstufe); // Unterteilung einer Seite
			BufferedImage[][] bild = new BufferedImage[zerlegung][zerlegung];  // Fuer Namensgebung und Zugriff der Einzelteil des Bildes

			System.out.println("zerlegung: "+ zerlegung); //nur fr Testzwecke

			for (int i = 0; i < zerlegung; i++) { // Zeilenindex
				for (int j = 0; j < zerlegung; j++) {//Spaltenindex

					System.out.println("i: "+i);//nur fuer Testzwecke
					System.out.println("j: "+j);//nur fuer Testzwecke
					System.out.println(" ");
					System.out.println("1: "+ (int) (w * (j  /(double)zerlegung)));//nur fuer Testzwecke
					System.out.println("2: "+ (int) (h * (i  /(double)zerlegung)));//nur fuer Testzwecke
					System.out.println("3: "+ (int) (w /(double)zerlegung));//nur  fuer Testzwecke
					System.out.println("4: "+ (int) (h /(double)zerlegung));//nur  fuer Testzwecke
					System.out.println(" ");

					bild[i][j] = img.getSubimage((int) (w * (j /  (double)zerlegung)),(int) (h* (i / (double)zerlegung)),(int) (w /  (double)zerlegung),(int) ( h / (double)zerlegung));// Zerlegung des  Bildes
					File f1 = new File("/Applications/eclipse/workspace/Image/bin/"+  zoomstufe + "-" + j + "-" + i + ".png");// Dateiname
					ImageIO.write(bild[i][j], "png", f1);//Speichern
				}
			}
		}
	}
}
