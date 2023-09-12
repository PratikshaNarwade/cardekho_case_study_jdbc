package com.jspiders.cardekho_case_study.caroperations;

import java.io.FileInputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import com.jspiders.cardekho_case_study.main.Menu;
import com.jspiders.cardekho_case_study.entity.Car;

public class Operations {
	
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static PreparedStatement preparedStatement;
	private static String query;
	private static int result;
	private static Properties properties = new Properties();
	private static FileInputStream file;
	private static String filePath = "E://WEJA2//cardekho_case_study_jdbc//resources//db_info.properties";
	
	Scanner sc = new Scanner(System.in);
	
	//ADD CAR DETAILS
	public  void addCarDetails() {
		
		try {
			openConnection();
			System.out.println("How Many Car Details You Want To Add?");
			int val = sc.nextInt();
			
			System.out.println("Already Present Car ID's in App : ");
			query = "select * from car_details";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.print(resultSet.getString(1) + "  ");
			}
			System.out.println();
			for(int i = 0; i<val; i++) {
				Car car = new Car();
				System.out.println("Enter Car Id : ");
				car.setCarID(sc.nextInt());
				System.out.println("Enter Car Name : ");
				car.setName(sc.next());
				System.out.println("Enter Car Model : ");
				car.setModel(sc.next());
				System.out.println("Enter Car Brand : ");
				car.setBrand(sc.next());
				System.out.println("Enter Car Fuel Type : ");
				car.setFuelType(sc.next());
				System.out.println("Enter Car Price : ");
				car.setPrice(sc.nextDouble());
				query = "insert into car_details values(?,?,?,?,?,?)";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1,car.getCarID());
				preparedStatement.setString(2,car.getName());
				preparedStatement.setString(3, car.getModel());
				preparedStatement.setString(4, car.getBrand());
				preparedStatement.setString(5, car.getFuelType());
				preparedStatement.setDouble(6, car.getPrice());
				result = preparedStatement.executeUpdate();
				System.out.println("Query OK, " + result + "rows(1) affected");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}
	
	//SEARCH CAR DETAILS
	public void searchCarDetails() {
		
		try {
			openConnection();
			System.out.println("Search Car By \n1.Name\n2.Brand\n3.Fuel Type\n4.Go Back To Main Menu");
			System.out.println("Enter Your Choice : ");
			int ch = sc.nextInt();
			
			switch (ch) {
			case 1:
				query = "select count(carId) from car_details";
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				resultSet.next();
				int rowCount1  = resultSet.getInt(1);
				//System.out.println(rowCount);
				
				if(rowCount1 == 0) {
					System.out.println("No Car Details Available!");
				}else {
					System.out.println("Enter Car Name: ");
					String name = sc.next();
					query = "select * from car_details where name = ?";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, name);
					resultSet = preparedStatement.executeQuery();
					while(resultSet.next()) {
						System.out.println(resultSet.getString(1) + "  | "
										 + resultSet.getString(2) + "  | "
										 + resultSet.getString(3) + "  | "
										 + resultSet.getString(4) + "  | "
										 + resultSet.getString(5) + "  | "
										 + resultSet.getString(6) + "  | ");
					}
				}
				break;
				
			case 2:
				
//				try {
//					openConnection();
				
					query = "select count(carId) from car_details";
					preparedStatement = connection.prepareStatement(query);
					resultSet = preparedStatement.executeQuery();
					resultSet.next();
					int rowCount2  = resultSet.getInt(1);
				
					if(rowCount2 == 0) {
						System.out.println("No Car Details Available!");
					} else {
						System.out.println("Enter Car Brand: ");
						String brand = sc.next();
						query = "select * from car_details where brand = ?";
						preparedStatement = connection.prepareStatement(query);
						preparedStatement.setString(1, brand);
						resultSet = preparedStatement.executeQuery();
						while(resultSet.next()) {
							System.out.println(resultSet.getString(1) + "  | "
										 	+ resultSet.getString(2) + "  | "
										 	+ resultSet.getString(3) + "  | "
										 	+ resultSet.getString(4) + "  | "
										 	+ resultSet.getString(5) + "  | "
										 	+ resultSet.getString(6) + "  | ");
						}
					}
					
//				} catch (Exception e) {
//					e.printStackTrace();
//				} finally {
//					closeConnection();
//				}
				break;
				
			case 3:
//				try {
//					openConnection();
					query = "select count(carId) from car_details";
					preparedStatement = connection.prepareStatement(query);
					resultSet = preparedStatement.executeQuery();
					resultSet.next();
					int rowCount3  = resultSet.getInt(1);
					if(rowCount3 == 0) {
						System.out.println("No Car Details Available!");
					} else {
						System.out.println("Enter Car Fuel Type: ");
						String fuel = sc.next();
						query = "select * from car_details where fuelType = ?";
						preparedStatement = connection.prepareStatement(query);
						preparedStatement.setString(1, fuel);
						resultSet = preparedStatement.executeQuery();
						while(resultSet.next()) {
							System.out.println(resultSet.getString(1) + "  | "
										 	+ resultSet.getString(2) + "  | "
										 	+ resultSet.getString(3) + "  | "
										 	+ resultSet.getString(4) + "  | "
										 	+ resultSet.getString(5) + "  | "
										 	+ resultSet.getString(6) + "  | ");
						}
					}
					
//				} catch (Exception e) {
//					e.printStackTrace();
//				} finally {
//					closeConnection();
//				}
				break;
			
			case 4:
				Menu.MenuOptions();
				break;
			
			default:
				System.out.println("Invalid Input!!Try Again");
			break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}
	
		public void getCarDetails() {
			
			try {
				//openConnection();
				
				query = "select count(carId) from car_details";
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				resultSet.next();
				int rowCount  = resultSet.getInt(1);
				//System.out.println(rowCount);
				if(rowCount == 0) {
					//System.out.println("Total No of Available Car : " + rowCount);
					System.out.println("No Car Details Available!");
				} else {
				
				query = "select * from car_details";
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				System.out.println("Total No of Available Car : " + rowCount);
				while(resultSet.next()) {
//					System.out.println(resultSet.getString(1) + "  | "
//									 + resultSet.getString(2) + "  | "
//									 + resultSet.getString(3) + "  | "
//									 + resultSet.getString(4) + "  | "
//									 + resultSet.getString(5) + "  | "
//									 + resultSet.getString(6) + "  | ");
					Car car = new Car();
					car.setCarID(resultSet.getInt(1));
					car.setName(resultSet.getString(2));
					car.setModel(resultSet.getString(3));
					car.setBrand(resultSet.getString(4));
					car.setFuelType(resultSet.getString(5));
					car.setPrice(resultSet.getDouble(6));
					//System.out.println("Total No of Available Car : " + rowCount);
					System.out.println(car);
				}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
//			finally {
//				closeConnection();
//			}
	}
	
	//UPDATE CAR DETAILS
	public void updateCarDetails() {
		
		
		try {
			openConnection();
			getCarDetails();
			System.out.println("\nUpdate Car Details By \n1.Name\n2.Brand\n3.Fuel Type\n4.Go Back To Main Menu");
			System.out.println("Enter Your Choice : ");
			int ch = sc.nextInt();
			
			switch(ch) {
			case 1:
				query = "select count(carId) from car_details";
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				resultSet.next();
				int rowCount1  = resultSet.getInt(1);
				if(rowCount1 == 0) {
					System.out.println("No Car Details Available!");
				}else {
				System.out.println("Enter Car ID :");
				int val = sc.nextInt();
				System.out.println("Enter New Car Name :");
				String name1 = sc.next();				
				query = "update car_details set name = ? where carId = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, name1);
				preparedStatement.setInt(2, val);
				result = preparedStatement.executeUpdate();
				System.out.println("Query OK, " + result + " rows(s) affected");
				}
				break;
				
			case 2:
				query = "select count(carId) from car_details";
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				resultSet.next();
				int rowCount2  = resultSet.getInt(1);
				if(rowCount2 == 0) {
					System.out.println("No Car Details Available!");
				} else {
				System.out.println("Enter Car ID :");
				int val1 = sc.nextInt();
				System.out.println("Enter New Car Brand :");
				String brand1 = sc.next();
				query = "update car_details set brand = ? where carId = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, brand1);
				preparedStatement.setInt(2, val1);
				result = preparedStatement.executeUpdate();
				System.out.println("Query OK, " + result + " rows(s) affected");
				}
				break;
				
			case 3:
				query = "select count(carId) from car_details";
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				resultSet.next();
				int rowCount3  = resultSet.getInt(1);
				if(rowCount3 == 0) {
					System.out.println("No Car Details Available!");
				} else {
				System.out.println("Enter Car ID :");
				int val2 = sc.nextInt();
				System.out.println("Enter New Fuel Type :");
				String fuelType1 = sc.next();
				query = "update car_details set fuelType = ? where carId = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, fuelType1);
				preparedStatement.setInt(2, val2);
				result = preparedStatement.executeUpdate();
				System.out.println("Query OK, " + result + " rows(s) affected");
				}
				break;
				
			case 4:
				Menu.MenuOptions();
				break;
			
			default:
				System.out.println("Invalid Input!!Try Again");
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		
	}
		
	//REMOVE CAR DETAILS
    public void removeCarDetails() {
    	try {
    		openConnection();
    		query = "select count(carId) from car_details";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int rowCount  = resultSet.getInt(1);
			if(rowCount == 0) {
				System.out.println("No Car Details Available!");
			} else {
    		System.out.println("Enter Car ID :");
        	int id = sc.nextInt();
        	query = "delete from car_details where carId = ?";
        	preparedStatement = connection.prepareStatement(query);
        	preparedStatement.setInt(1, id);
        	result = preparedStatement.executeUpdate();
        	System.out.println("Query OK, " + result + " rows(s) affected");
			}
			
		} catch (Exception e) {
			e.printStackTrace();	
		} finally {
			closeConnection();
		}
    }
    
    public void openConnection() {
    	try {
    		file = new FileInputStream(filePath);
    		properties.load(file);
    		connection = DriverManager.getConnection(properties.getProperty("dburl"),properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void closeConnection() {
    	try {
    		if(connection != null) {
    			connection.close();
    		}
    		if(statement != null) {
    			statement.close();
    		}
    		if(file != null) {
    			file.close();
    		}
    		if(result != 0) {
    			result = 0;
    		}
    		if(preparedStatement != null) {
    			preparedStatement.close();
    		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}

//Create a method of it or declare outside the switch 
//query = "select count(carId) from car_details";
//preparedStatement = connection.prepareStatement(query);
//resultSet = preparedStatement.executeQuery();
//resultSet.next();
//int rowCount  = resultSet.getInt(1);
//	
		
