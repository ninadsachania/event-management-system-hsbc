package com.demo.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.demo.exceptions.InvalidNumberOfPeopleException;
import com.demo.exceptions.PlannedDateException;
import com.demo.models.Packages;
import com.demo.models.PlanRequest;
import com.demo.models.Quotation;
import com.demo.models.User;
import com.demo.models.Vendor;
import com.demo.service.AdminService;
import com.demo.service.AdminServiceImpl;
import com.demo.service.UserService;
import com.demo.service.UserServiceImpl;
import com.demo.service.VendorService;
import com.demo.service.VendorServiceImpl;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		AdminService adminService = new AdminServiceImpl();
		UserService userService = new UserServiceImpl();
		VendorService vendorService = new VendorServiceImpl();

		while (true) {
			System.out.println("Main Menu:");
			System.out.println("1. Admin");
			System.out.println("2. Vendor");
			System.out.println("3. User");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				// adminActions(adminService, userService, vendorService);
				break;
			case 2:
					vendorActions(vendorService);
				break;
			case 3:
				//userActions(userService);
				break;
			case 4:
				scanner.close();
				System.out.println("Exiting...");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

//	private static void adminActions(AdminService adminService, UserService userService, VendorService vendorService)
//			throws SQLException {
//		// Implement admin actions here
//		System.out.println("Admin Actions:");
//		System.out.println("0. Login");
//		System.out.println("1. Add Vendor");
//		System.out.println("2. View Vendors");
//		System.out.println("3. View Users Registrations");
//		System.out.println("4. Update User Status");
//		System.out.println("5. Back to Main Menu");
//		System.out.print("Enter your choice: ");
//
//		int choice = scanner.nextInt();
//		switch (choice) {
//		case 0:
//			break;
//		case 1:
//
//			// Implement add vendor
//			break;
//		case 2:
//			List<Vendor> vendors = adminService.viewVendors();
//
//			for (Vendor vendor : vendors) {
//				System.out.println(vendor);
//			}
//			break;
//		case 3:
//			// Implement view users
//			List<User> users = adminService.viewUsers();
//			for (User user : users) {
//				System.out.println(user);
//			}
//			break;
//		case 4:
//
//			break;
//		case 5:
//			return;
//		default:
//			System.out.println("Invalid choice. Please try again.");
//		}
//	}


    private static void vendorActions(VendorService vendorService) {
        // Implement vendor actions here
        System.out.println("Vendor Actions:");
        System.out.println("1. Validate Login Details");
        System.out.println("2. Add Package");
        System.out.println("3. View Plan Requests");
        System.out.println("4. Create Quotation");
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
            	//validate vendor detail
            	System.out.println("Enter vendor id");
            	int vid = scanner.nextInt();
                System.out.println("Enter the username");
                String uname = scanner.next();
                System.out.println("Enter passward");
                String pass = scanner.next();
                Vendor v = new Vendor(vid,uname,pass);
				try {
					if(vendorService.validateVendor(v)) {
	                	System.out.println("vendor login sucessfully!!");
	                }
				} catch (SQLException e) {
					e.printStackTrace();
				}
                break;
            case 2:
                // Implement add package
            	System.out.println("Enter package id");
            	int pid = scanner.nextInt();
            	System.out.println("Enter package type");
            	String ptype = scanner.next();
            	System.out.println("Enter vendor id");
            	double pamt = scanner.nextDouble();
            	System.out.println("Enter vendor id");
            	int venid = scanner.nextInt();
            	Packages p = new Packages(pid,ptype,pamt,venid);
				try {
					if(vendorService.addPackage(p)) {
						System.out.println("package entered successfully");
					}
	                break;
				} catch (SQLException e) {
					e.printStackTrace();
				}
            case 3:
                // Implement view plan requests
            	List<PlanRequest> lst;
				try {
					lst = vendorService.viewUserRequest();
					for(PlanRequest planRq:lst) {
						System.out.println(planRq);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
                break;
            case 4:
                // Implement create quotation
            	System.out.println("Enter quotation id");
            	int qid = scanner.nextInt();
            	System.out.println("Enter vendor id");
            	int vendorid = scanner.nextInt();
            	System.out.println("Enter user id");
            	int uid = scanner.nextInt();
            	System.out.println("Enter request id");
            	int rid = scanner.nextInt();
            	System.out.println("Enter package type");
            	String packtype = scanner.next();
            	System.out.println("Enter quotation status");
            	String qstatus = scanner.next();
            	System.out.println("Enter estimated amount");
            	double estamt = scanner.nextDouble();
            	Quotation Q = new Quotation(qid,vendorid,uid,rid,packtype,qstatus,estamt);
				try {
					if(vendorService.createQuotation(Q)) {
						System.out.println("Quotation created sucessfully");
					}
	            	
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

//	private static void userActions(UserService userService) {
//		try {
//			System.out.println("1. Register\n2. Login\nEnter:");
//			int ch = scanner.nextInt();
//			if (ch == 1) {
//				User u = UserService.getUser();
//				if (userService.registerUser(u)) {
//					System.out.println("Successfully registered");
//				} else {
//					System.out.println("Cannot register");
//				}
//			} else {
//				System.out.println("Enter userId");
//				int id = scanner.nextInt();
//				System.out.println("Enter username:");
//				String uname = scanner.next();
//				System.out.println("Enter Password");
//				String passwd = scanner.next();
//				User us = new User(id, uname, passwd);
//				if (userService.validateUser(us)) {
//					System.out.println("User Actions:");
//					System.out.println("1. Insert Plan Request");
//					System.out.println("2. View Quotations");
//					System.out.println("3. Update Quotations status");
//					System.out.println("4. Update Password");
//					System.out.println("5. View User");
//					System.out.println("6. Back to Main Menu");
//					System.out.print("Enter your choice: ");
//
//					int choice = scanner.nextInt();
//					switch (choice) {
//					case 1:
//						PlanRequest preq = UserService.getPlanRequestDetails();
//						if (userService.addPlanRequest(preq)) {
//							System.out.println("Plan request added successfully");
//						} else {
//							System.out.println("Cannot add plan request record");
//						}
//						break;
//					case 2:
//						System.out.println("Enter user id:");
//						int uid = scanner.nextInt();
//						List<Quotation> quotations = userService.viewQuotation(uid);
//						for (Quotation quot : quotations) {
//							System.out.println(quot);
//						}
//						break;
//					case 3:
//						System.out.println("Enter quotation id:");
//						int quotid = scanner.nextInt();
//						System.out.println("Enter quotation status(Accepted/Rejected):");
//						String status = scanner.next();
//						if (userService.updateQuotationStatus(quotid, status)) {
//							System.out.println("Quotation status updated successfully");
//						} else {
//							System.out.println("cannot update Quotation status");
//						}
//						break;
//					case 4:
//						System.out.println("Enter user id:");
//						int userid = scanner.nextInt();
//						System.out.println("Enter new password:");
//						String pswd = scanner.next();
//						if (userService.updatePassword(userid, passwd)) {
//							System.out.println("password updated successfuly");
//						} else {
//							System.out.println("Cannot update password");
//						}
//						break;
//					case 5:
//						System.out.println("Enter user id:");
//						userid = scanner.nextInt();
//						User user1 = userService.findById(userid);
//						System.out.println(user1);
//						break;
//					case 6:
//						userService.closeConnection();
//						return;
//					default:
//						System.out.println("Invalid choice. Please try again.");
//						return;
//					}
//				}
//			}
//		} catch (InvalidNumberOfPeopleException e1) {
//			System.out.println(e1.getMessage());
//		} catch (PlannedDateException e) {
//			System.out.println(e.getMessage());
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		} catch (InputMismatchException e) {
//			System.out.println("please enter valid inputs");
//		} catch (Exception e) {
//			System.out.println("Something went wrong....");
//		}
//	}
}
