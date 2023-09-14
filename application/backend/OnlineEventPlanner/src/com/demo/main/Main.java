package com.demo.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.demo.models.Admin;
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

	static void printHeading(String msg) {
		int length = msg.length();

		for (int i = 0; i < length + 4; i += 1) {
			System.out.print("-");
		}
		System.out.println();

		System.out.println("  " + msg);

		for (int i = 0; i < length + 4; i += 1) {
			System.out.print("-");
		}
		System.out.println();

	}

	public static void main(String[] args) {
		AdminService adminService = new AdminServiceImpl();
		UserService userService = new UserServiceImpl();
		VendorService vendorService = new VendorServiceImpl();

		while (true) {
			try {
				System.out.println("Main Menu:");
				System.out.println("1. Admin");
				System.out.println("2. Vendor");
				System.out.println("3. User");
				System.out.println("4. Exit");
				System.out.print("Enter your choice: ");

				int choice = Integer.parseInt(scanner.nextLine());
//				scanner.nextLine();

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
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	private static void adminActions(AdminService adminService, UserService userService, VendorService vendorService)
			throws SQLException {

		boolean isLoggedIn = false;

		while (!isLoggedIn) {
			System.out.println("Please log in first...");
			System.out.print("Username: ");
			String username = scanner.nextLine().trim();
			System.out.print("Password: ");
			String password = scanner.nextLine().trim();
			if (adminService.validateAdmin(new Admin(username, password))) {
				System.out.println("Successfully logged in.");
				break;
			}

			System.out.println("Wrong username/password. Try again");
		}
		// Implement admin actions here
		while (true) {
			System.out.println("Admin Actions:");
			System.out.println("1. Add Vendor");
			System.out.println("2. View Vendors");
			System.out.println("3. View Users Registrations");
			System.out.println("4. Update User Status");
			System.out.println("5. Back to Main Menu");
			System.out.print("Enter your choice: ");

			int choice = Integer.parseInt(scanner.nextLine());
			switch (choice) {
			case 1:
				// Add a new vendor
				printHeading("Add a Vendor");
				adminService.addVendor(VendorService.addNewVendor());
				break;
			case 2:
				printHeading("View Vendor");
				List<Vendor> vendors = adminService.viewVendors();

				for (Vendor vendor : vendors) {
					System.out.println(vendor);
				}
				break;
			case 3:
				// Implement view users
				printHeading("View Users");
				List<User> users = adminService.viewUsers();
				for (User user : users) {
					System.out.println(user);
				}
				break;
			case 4:
				printHeading("Update User Status");
				System.out.print("Enter user id: ");
				scanner.nextLine();
				int uid = Integer.parseInt(scanner.nextLine());

				System.out.print("Enter the status: ");
				String status = scanner.nextLine();

				adminService.updateUserStatus(uid, status);
				break;
			case 5:
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
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
