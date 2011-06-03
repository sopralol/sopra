package com.mycompany.project.server;

import java.sql.*;
import com.mycompany.project.client.Kante;
import com.mycompany.project.client.Knoten;
import com.mycompany.project.client.Person;

public abstract class DBconn {
	
	public static Connection getConnection(){
		try{
			return DriverManager.getConnection(DBconnHelper.connection);
		} catch (Exception e) {
			return null;
		}
		
	}
	public static void saveKnoten(Knoten a){
		try {
			 Connection conn = getConnection();
			 String insert=a.lat+","+a.lng+","+a.typ+","+a.niveau;
			 String query="insert into knoten (lat,lng,typ,niveau) values ("+insert+");";
			 Statement stmt=conn.createStatement();
			 stmt.executeUpdate(query);
       } catch (SQLException ex) {
           System.out.println("SQLException: " + ex.getMessage());
           System.out.println("SQLState: " + ex.getSQLState());
           System.out.println("VendorError: " + ex.getErrorCode());
       }
	}
	public static void deleteKnoten(double lat, double lng){
		try {
			 Connection conn = getConnection();
			 String query="delete from knoten where lat="+lat+"and lng="+lng+";";
			 Statement stmt=conn.createStatement();
			 stmt.executeUpdate(query);
			 query="delete from kanten where lat1="+lat+"and lng1="+lng+";";
			 stmt.executeUpdate(query);
			 query="delete from kanten where lat2="+lat+"and lng2="+lng+";";
			 stmt.executeUpdate(query);
       } catch (SQLException ex) {
           System.out.println("SQLException: " + ex.getMessage());
           System.out.println("SQLState: " + ex.getSQLState());
           System.out.println("VendorError: " + ex.getErrorCode());
       }
	}
	
	public static Knoten[] readKnoten(int niveau){
		try {
			 Connection conn = getConnection();
			 String query="select * from knoten where niveau=\""+niveau+"\"";
			 Statement stmt=conn.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 rs.last();
             int size = rs.getRow();
             rs.beforeFirst();
             Knoten[] knoten = new Knoten[size];
             int i=0;
			 while (rs.next()) {
				knoten[i] = new Knoten(rs.getDouble(2), rs.getDouble(3), rs.getInt(4), rs.getInt(5));
				i++;
			}
			 return knoten;
      } catch (SQLException ex) {
          System.out.println("SQLException: " + ex.getMessage());
          System.out.println("SQLState: " + ex.getSQLState());
          System.out.println("VendorError: " + ex.getErrorCode());
          return null;
      
      }
	}
	public static Knoten[] readKnotennot(int niveau,double lat, double lng){
		try {
			 Connection conn = getConnection();
			 String query="select * from knoten where niveau=\""+niveau+"\" AND lat<>"+lat+" AND lng<>"+lng+"";
			 Statement stmt=conn.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 rs.last();
             int size = rs.getRow();
             rs.beforeFirst();
             Knoten[] knoten = new Knoten[size];
             int i=0;
			 while (rs.next()) {
				knoten[i] = new Knoten(rs.getDouble(2), rs.getDouble(3), rs.getInt(4), rs.getInt(5));
				i++;
			}
			 return knoten;
      } catch (SQLException ex) {
          System.out.println("SQLException: " + ex.getMessage());
          System.out.println("SQLState: " + ex.getSQLState());
          System.out.println("VendorError: " + ex.getErrorCode());
          return null;
      
      }
	}
	
	public static void saveKante(Kante a){
	try {
			 Connection conn = getConnection();
			 String insert=	a.lat1+","+a.lng1+","+a.lat2+","+a.lng2+","
			 				+a.gewicht+","
			 				+a.niveau;
			 String query="insert into kanten (lat1,lng1,lat2,lng2,gewicht,niveau) values ("+insert+");";
			 Statement stmt=conn.createStatement();
			 stmt.executeUpdate(query);
      } catch (SQLException ex) {
          System.out.println("SQLException: " + ex.getMessage());
          System.out.println("SQLState: " + ex.getSQLState());
          System.out.println("VendorError: " + ex.getErrorCode());
      
      }

	}
	
	public static Kante[] readKantenot(int niveau,double lat, double lng){
		try {
			 Connection conn = getConnection();
			 String query="select * from kanten where niveau=\""+niveau+"\" AND ((lat1<>"+lat+" AND lng1<>"+lng+" )AND (lat2<>"+lat+" AND lng2<>"+lng+"));";
			 Statement stmt=conn.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 rs.last();
             int size = rs.getRow();
             rs.beforeFirst();
             Kante[] kanten = new Kante[size];
             int i=0;
			 while (rs.next()) {
				kanten[i] = new Kante(rs.getDouble(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getInt(6), rs.getInt(7));
				i++;
			}
			 return kanten;
      } catch (SQLException ex) {
          System.out.println("SQLException: " + ex.getMessage());
          System.out.println("SQLState: " + ex.getSQLState());
          System.out.println("VendorError: " + ex.getErrorCode());
          return null;
      }
	}
	public static Kante[] readKante(int niveau){
		try {
			 Connection conn = getConnection();
			 String query="select * from kanten where niveau=\""+niveau+"\"";
			 Statement stmt=conn.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 rs.last();
             int size = rs.getRow();
             rs.beforeFirst();
             Kante[] kanten = new Kante[size];
             int i=0;
			 while (rs.next()) {
				kanten[i] = new Kante(rs.getDouble(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getInt(6), rs.getInt(7));
				i++;
			}
			 return kanten;
      } catch (SQLException ex) {
          System.out.println("SQLException: " + ex.getMessage());
          System.out.println("SQLState: " + ex.getSQLState());
          System.out.println("VendorError: " + ex.getErrorCode());
          return null;
      }
	}
	public static void deleteKante(double lat1, double lng1, double lat2, double lng2) {
		try {
			 Connection conn = getConnection();
			 String query="delete from kanten where lat1="+lat1+"and lng1="+lng1+"and lat2="+lat2+"and lng2="+lng2+";";
			 Statement stmt=conn.createStatement();
			 stmt.executeUpdate(query);
      } catch (SQLException ex) {
          System.out.println("SQLException: " + ex.getMessage());
          System.out.println("SQLState: " + ex.getSQLState());
          System.out.println("VendorError: " + ex.getErrorCode());
      }

	}
	public static void insertPerson(String vorname,String nachname,String email,String telefon,String institut,String titel){
		try {
			 Connection conn = getConnection();
			 String insert="'"+vorname+"','"+nachname+"','"+email+"','"+telefon+"','"+institut+"','"+titel+"'";
			 String query="insert into personen (vorname,nachname,email,telefon,institut,titel) values ("+insert+");";
			 Statement stmt=conn.createStatement();
			 stmt.executeUpdate(query);
      } catch (SQLException ex) {
          System.out.println("SQLException: " + ex.getMessage());
          System.out.println("SQLState: " + ex.getSQLState());
          System.out.println("VendorError: " + ex.getErrorCode());
      }
	}
	public static Person[] searchPerson(String vorname,String nachname,String institut,String titel){
		try {
			
			Connection conn = getConnection();
			String clause = "";
			boolean toggle = false;
			if (!"".equals(vorname)){
				clause+="vorname = '"+vorname+"' ";
				toggle = true;
			}
			if (!"".equals(nachname)){
				if (toggle){
					clause += " AND ";
				}
				clause+="nachname = '"+nachname+"' ";
				toggle = true;
			} 
			if (!"".equals(institut)){
				if (toggle){
					clause += " AND ";
				}
				clause+="institut = '"+institut+"' ";
				toggle = true;
			}
			if (!"".equals(titel)){
				if (toggle){
					clause += " AND ";
				}
				clause+="titel = '"+titel+"' ";
				toggle = true;
			}
			String query="select * from personen where ("+clause+");";
			System.out.println(clause);
			Statement stmt=conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.last();
			Person[] result = new Person[rs.getRow()];
			rs.beforeFirst();
			int i=0;
			while(rs.next()){
				result[i]= new Person(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
				i++;
			}
			return result;
			
      } catch (SQLException ex) {
          System.out.println("SQLException: " + ex.getMessage());
          System.out.println("SQLState: " + ex.getSQLState());
          System.out.println("VendorError: " + ex.getErrorCode());
          return null;
      }
	}
	public static void deletePerson(String id){
		try {
			 Connection conn = getConnection();
			 String query="delete from personen where id ="+id+";";
			 Statement stmt=conn.createStatement();
			 stmt.executeUpdate(query);
      } catch (SQLException ex) {
          System.out.println("SQLException: " + ex.getMessage());
          System.out.println("SQLState: " + ex.getSQLState());
          System.out.println("VendorError: " + ex.getErrorCode());
      }
	}
	public static void updatePerson(String pid,String vorname,String nachname,String email,String telefon,String institut,String titel){
		try {
			 Connection conn = getConnection();
			 String insert="vorname='"+vorname+"',nachname='"+nachname+"',email='"+email+"',telefon='"+telefon+"',institut='"+institut+"',titel='"+titel+"'";
			 String query="update personen set "+insert+" where id="+pid+";";
			 Statement stmt=conn.createStatement();
			 stmt.executeUpdate(query);
      } catch (SQLException ex) {
          System.out.println("SQLException: " + ex.getMessage());
          System.out.println("SQLState: " + ex.getSQLState());
          System.out.println("VendorError: " + ex.getErrorCode());
      }
	}

}
