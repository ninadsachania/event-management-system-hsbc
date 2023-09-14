package com.demo.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.demo.dao.AdminDao;
import com.demo.dao.UserDao;
import com.demo.dao.VendorDao;
import com.demo.dao.impls.AdminDaoImpl;
import com.demo.dao.impls.UserDaoImpl;
import com.demo.dao.impls.VendorDaoImpl;
import com.demo.dao.util.DBUtil;
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
				adminActions(adminService, userService, vendorService);
				break;
//                    case 2:
//                        vendorActions(vendorService);
//                        break;
//                    case 3:
//                        userActions(userService, vendorService);
//                        break;
//                    case 4:
//                        System.out.println("Exiting...");
//                        DBUtil.closeConnection();
//                        System.exit(0);
//                        break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void adminActions(AdminService adminService, UserService userService, VendorService vendorService)
			throws SQLException {
		// Implement admin actions here
		System.out.println("Admin Actions:");
		System.out.println("0. Login");
		System.out.println("1. Add Vendor");
		System.out.println("2. View Vendors");
		System.out.println("3. View Users Registrations");
		System.out.println("4. Update User Status");
		System.out.println("5. Back to Main Menu");
		System.out.print("Enter your choice: ");
		
		
		

		int choice = scanner.nextInt();
		switch (choice) {
		case 0:
			break;
		case 1:
			
			// Implement add vendor
			break;
		case 2:
			List<Vendor> vendors = adminService.viewVendors();

			for (Vendor vendor : vendors) {
				System.out.println(vendor);
			}
			break;
		case 3:
			// Implement view users
			List<User> users = adminService.viewUsers();
			for (User user : users) {
				System.out.println(user);
			}
			break;
		case 4:
			
			break;
		case 5:
			return;
		default:
			System.out.println("Invalid choice. Please try again.");
		}
	}
//
//    private static void vendorActions(VendorService vendorService) {
//        // Implement vendor actions here
//        System.out.println("Vendor Actions:");
//        System.out.println("1. Validate Login Details");
//        System.out.println("2. Add Package");
//        System.out.println("3. View Plan Requests");
//        System.out.println("4. Create Quotation");
//        System.out.println("5. Back to Main Menu");
//        System.out.print("Enter your choice: ");
//
//        int choice = scanner.nextInt();
//        switch (choice) {
//            case 1:
//                // Implement validate login details
//                break;
//            case 2:
//                // Implement add package
//                break;
//            case 3:
//                // Implement view plan requests
//                break;
//            case 4:
//                // Implement create quotation
//                break;
//            case 5:
//                // Back to Main Menu
//                break;
//            default:
//                System.out.println("Invalid choice. Please try again.");
//        }
//    }
//
//    private static void userActions(UserService userService, VendorService vendorService) {
	// Implement user actions here
//        System.out.println("User Actions:");
//        System.out.println("1. Insert Plan Request");
//        System.out.println("2. View Quotations");
//        System.out.println("3. User Registration");
//        System.out.println("4. Update Quotations");
//        System.out.println("5. Back to Main Menu");
//        System.out.print("Enter your choice: ");
//
//        int choice = scanner.nextInt();
//        switch (choice) {
//        case 1:
//            // Implement insert plan request
//            break;
//        case 2:
//            // Implement view quotations
//            break;
//        case 3:
//            // Implement user registration
//            break;
//        case 4:
//            // Implement update quotations
//            break;
//        case 5:
//            // Back to Main Menu
//            break;
//        default:
//            System.out.println("Invalid choice. Please try again.");
//    }
//}
}
