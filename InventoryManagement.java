import java.util.*;
import java.io.*;


public class InventoryManagement {
	
	public static ArrayList<Inventory> inventory = new ArrayList<Inventory>();
	public static ArrayList<Product> prodList = new ArrayList<Product>();
	public ArrayList<Product> getProdList() {
		return prodList;
	}

	public static ArrayList<Inventory> getInventory() {
		return inventory;
	}

	public static void loadProducts() throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader("product.csv"));
		// read file line by line
		String line = null;
		Scanner scanner = null;
		int index = 0;

		while ((line = reader.readLine()) != null) {
			Product prodDetails = new Product();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String data = scanner.next();
				if (index == 0)
					prodDetails.setProductID(Integer.parseInt(data));
				else if (index == 1)
					prodDetails.setProductName(data);
				else if (index == 2)
					prodDetails.setProductModel(data);
				else if (index == 3)
					prodDetails.setProductManufacturer(data);
				else if (index == 4)
					prodDetails.setProductPrice(Double.parseDouble(data));
				else if (index == 5)
					prodDetails.setProductQuat(Integer.parseInt(data));
				else if (index == 6)
					prodDetails.setProductLocation((data));
				else if (index == 7)
					prodDetails.setProductType(data);
				else
					System.out.println("invalid data::" + data);
				index++;
			}
			index = 0;
			prodList.add(prodDetails);
		}
		// close reader
		reader.close();
	}

	public static void loadInventory() throws IOException {
		BufferedReader invReader = new BufferedReader(new FileReader("inventory.csv"));
		// read file line by line
		String line = null;
		int index = 0;
		while ((line = invReader.readLine()) != null) {
			Inventory inventoryData = new Inventory();
			Scanner scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String data = scanner.next();
				if (index == 0)
					inventoryData.setProductType(data);
				else if (index == 1)
					inventoryData.setQuantity(Integer.parseInt(data));

				else
					System.out.println("invalid data::" + data);
				index++;
			}
			index = 0;
			inventory.add(inventoryData);
		}
		// close reader
		invReader.close();
	}

	public static ArrayList<Product> showProductsTable() {
		System.out.println("The Products available are:");

		System.out.printf("%10s %15s %15s %15s %10s %8s %12s %15s", "ProductID", "ProductName", "ProductModel",
				"Manufacturer", "Price", "Quantity", "Location", "ProductType\n");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < prodList.size(); i++) {
			System.out.format("%10d %15s %15s %15s %10.2f %5d %15s %15s", prodList.get(i).getProductID(),
					prodList.get(i).getProductName(), prodList.get(i).getProductModel(),
					prodList.get(i).getProductManufacturer(), prodList.get(i).getProductPrice(),
					prodList.get(i).getProductQuant(), prodList.get(i).getProductLocation(),
					prodList.get(i).getProductType());
			System.out.println("");
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------");
		return prodList;
	}

	// This method displays the entire inventory with the products count
	public static void showInventoryTable() {
		System.out.println("The inventory details are:");
		System.out.printf("%20s %5s", "ProductType", " Quantity\n");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < inventory.size(); i++) {
			System.out.format("%20s %5d", inventory.get(i).getProductType(), 
					inventory.get(i).getQuantity());
			System.out.println("");
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	// Method to display all Manufacturers available in the inventory
	public static void getManufacturerList() {
		Set<String> uniqManufacturers = new HashSet<String>();
		System.out.println("Manufacturers available are:");
		for (int i = 0; i < prodList.size(); i++) {
			uniqManufacturers.add(prodList.get(i).getProductManufacturer());
		}
		System.out.println(uniqManufacturers);
	}

	public static void getProductNameList() {
		Set<String> uniqProductName = new HashSet<String>();
		System.out.println("Products available are:");
		for (int i = 0; i < prodList.size(); i++) {
			uniqProductName.add(prodList.get(i).getProductName());
		}
		System.out.println(uniqProductName);
	}

	public static void getProductProductType() {
		Set<String> uniqProductName = new HashSet<String>();
		System.out.println("Products available are:");
		for (int i = 0; i < prodList.size(); i++) {
			uniqProductName.add(prodList.get(i).getProductType());
		}
		System.out.println(uniqProductName);
	}

	public static void getProductLocation() {
		Set<String> uniqProductLocation = new HashSet<String>();
		System.out.println("Currently products available in below locations:");
		for (int i = 0; i < prodList.size(); i++) {
			uniqProductLocation.add(prodList.get(i).getProductLocation());
		}
		System.out.println(uniqProductLocation);
	}

	public static void getProductQuantity() {
		Set<Integer> uniqProductQuantity = new HashSet<Integer>();
		System.out.println("Currently products available in below quantities:");
		for (int i = 0; i < prodList.size(); i++) {
			uniqProductQuantity.add(prodList.get(i).getProductQuant());
		}
		System.out.println(uniqProductQuantity);
	}


	// This method displays the Products details based on the Manufacturer
	public static ArrayList<Product> displayBasedonManufacturer(String manufacturer) {
		ArrayList<Product> prodManuf = new ArrayList<Product>();
		System.out.println("Products available from  " + manufacturer + " are:");
		System.out.printf("%10s %15s %15s %15s %5s %5s %7s %15s", "ProductID", "ProductName", "ProductModel",
				"Manufacturer", "Price", "Quantity", "Location", "ProductType\n");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < prodList.size(); i++) {
			if (prodList.get(i).getProductManufacturer().toLowerCase().contains(manufacturer.toLowerCase())) {
				prodManuf.add(prodList.get(i));
				System.out.format("%10d %15s %15s %15s %10.2f %5d %10s %15s", prodList.get(i).getProductID(),
						prodList.get(i).getProductName(), prodList.get(i).getProductModel(),
						prodList.get(i).getProductManufacturer(), prodList.get(i).getProductPrice(),
						prodList.get(i).getProductQuant(), prodList.get(i).getProductLocation(),
						prodList.get(i).getProductType());
				System.out.println("");
			}
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------");
	return prodManuf;
	}
	
// This method displays the Products details based on the ProductName
	public static void displayBasedonProductName(String productname) {
		System.out.println("Products available from  " + productname + " are:");
		System.out.printf("%10s %15s %15s %15s %10s %10s %7s %15s", "ProductID", "ProductName", "ProductModel",
				"Manufacturer", "     Price    ", "Quantity", "Location", "ProductType\n");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < prodList.size(); i++) {
			if (prodList.get(i).getProductName().toLowerCase().contains(productname.toLowerCase())) {
				System.out.format("%10d %15s %15s %15s %10.2f %5d %10s %15s", prodList.get(i).getProductID(),
						prodList.get(i).getProductName(), prodList.get(i).getProductModel(),
						prodList.get(i).getProductManufacturer(), prodList.get(i).getProductPrice(),
						prodList.get(i).getProductQuant(), prodList.get(i).getProductLocation(),
						prodList.get(i).getProductType());
				System.out.println("");
			}
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	// This method displays the Products details based on the ProductType
	public static void displayBasedonProductType(String productType) {
		System.out.println("Products available under Category " + productType + " are:");
		System.out.printf("%10s %15s %15s %15s %10s %10s %7s %15s", "ProductID", "ProductName", "ProductModel",
				"Manufacturer", "     Price    ", "Quantity", "Location", "ProductType\n");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < prodList.size(); i++) {
			if (prodList.get(i).getProductType().toLowerCase().contains(productType.toLowerCase())) {
				System.out.format("%10d %15s %15s %15s %10.2f %5d %10s %15s", prodList.get(i).getProductID(),
						prodList.get(i).getProductName(), prodList.get(i).getProductModel(),
						prodList.get(i).getProductManufacturer(), prodList.get(i).getProductPrice(),
						prodList.get(i).getProductQuant(), prodList.get(i).getProductLocation(),
						prodList.get(i).getProductType());
				System.out.println("");
			}
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------");
	}
	//Display products based on Product Type
	public static ArrayList<Product> displayBasedontype(String pType) {
		ArrayList<Product> prodType = new ArrayList<Product>();
		System.out.println("Products available from  " + pType + " are:");
		System.out.printf("%10s %15s %15s %15s %5s %5s %7s %15s", "ProductID", "ProductName", "ProductModel",
				"Manufacturer", "Price", "Quantity", "Location", "ProductType\n");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < prodList.size(); i++) {
			if (prodList.get(i).getProductType().toLowerCase().contains(pType.toLowerCase())) {
				prodType.add(prodList.get(i));
				System.out.format("%10d %15s %15s %15s %10.2f %5d %10s %15s", prodList.get(i).getProductID(),
						prodList.get(i).getProductName(), prodList.get(i).getProductModel(),
						prodList.get(i).getProductManufacturer(), prodList.get(i).getProductPrice(),
						prodList.get(i).getProductQuant(), prodList.get(i).getProductLocation(),
						prodList.get(i).getProductType());
				System.out.println("");
			}
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------");
	return prodType;
	}
	// This method displays the Products details based on the Product Location zip
	// code
	public static ArrayList<Product> displayBasedonLocation(String location) {
		ArrayList<Product> prodLocation = new ArrayList<Product>();
		System.out.println("Products available in the location zip code " + location + " are:");
		System.out.printf("%10s %15s %15s %15s %5s %5s %7s %15s", "ProductID", "ProductName", "ProductModel",
				"Manufacturer", "     Price    ", "Quantity", "Location", "ProductType\n");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < prodList.size(); i++) {
			if (prodList.get(i).getProductLocation().toLowerCase().contains(location.toLowerCase())) {
				prodLocation.add(prodList.get(i));
				System.out.format("%10d %15s %15s %15s %10.2f %5d %10s %15s", prodList.get(i).getProductID(),
						prodList.get(i).getProductName(), prodList.get(i).getProductModel(),
						prodList.get(i).getProductManufacturer(), prodList.get(i).getProductPrice(),
						prodList.get(i).getProductQuant(), prodList.get(i).getProductLocation(),
						prodList.get(i).getProductType());
				System.out.println("");
			}
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------");
		return prodLocation;
	}

	public static ArrayList<Product> displayBasedonQuantity(int quantity) {
		ArrayList<Product> prodQuantity = new ArrayList<Product>();
		System.out.println("Products available in the location zip code " + quantity + " are:");
		System.out.printf("%10s %15s %15s %15s %5s %5s %7s %15s", "ProductID", "ProductName", "ProductModel",
				"Manufacturer", "     Price    ", "Quantity", "Location", "ProductType\n");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < prodList.size(); i++) {
			
			if (prodList.get(i).getProductQuant() == quantity) {
				prodQuantity.add(prodList.get(i));
				System.out.format("%10d %15s %15s %15s %10.2f %5d %10s %15s", prodList.get(i).getProductID(),
						prodList.get(i).getProductName(), prodList.get(i).getProductModel(),
						prodList.get(i).getProductManufacturer(), prodList.get(i).getProductPrice(),
						prodList.get(i).getProductQuant(), prodList.get(i).getProductLocation(),
						prodList.get(i).getProductType());
				System.out.println("");
			}
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------");
		return prodQuantity;
	}


	// This methods deletes the record of the given Product ID in the Products table
	public static void deleteRecord(int prodID) {
		String getProductType = null;
		int getProductQuant = 0;
		for (int i = 0; i < prodList.size(); i++) {
			if (prodList.get(i).getProductID() == prodID) {
				getProductType = prodList.get(i).getProductType();
				getProductQuant = prodList.get(i).getProductQuant();
				prodList.remove(i);
			}
		}
		// Reduce the count of the product(quantity) from inventory table of the
		// particular product
		for (int i = 0; i < inventory.size(); i++) {
			//if (getProductType.equalsIgnoreCase(inventory.get(i).getProductType())) {
			if (getProductType.contains(inventory.get(i).getProductType())) {
				inventory.get(i).setQuantity(inventory.get(i).getQuantity() - getProductQuant);
			}
		}
		System.out.println("The product has been removed from the inventory!");
		// displayAllProducts();
	}

	// This method updates the Price of a given product
	public static void updateProdPrice(int id, Double price) {
		int getIndex = 0;

		for (int i = 0; i < prodList.size(); i++) {
			if (prodList.get(i).getProductID() == id) {
				getIndex = i;
				prodList.get(i).setProductPrice(price);
			}
		}
		System.out.println("getIndex " + getIndex);
		System.out.println(
				"Product with ID " + id + " is updated with the latest price. Updated Product details are below:");
		System.out.println("Product -" + prodList.get(getIndex).getProductName() + ", updated price is "
				+ prodList.get(getIndex).getProductPrice());
	}
	
	public static void updateProdLocation(int id, String location) {
		int getIndex = 0;

		for (int i = 0; i < prodList.size(); i++) {
			if (prodList.get(i).getProductID() == id) {
				getIndex = i;
				prodList.get(i).setProductLocation(location);
			}
		}
		System.out.println("getIndex " + getIndex);
		System.out.println(
				"Product with ID " + id + " is updated with the latest price. Updated Product details are below:");
		System.out.println("Product -" + prodList.get(getIndex).getProductName() + ", updated price is "
				+ prodList.get(getIndex).getProductPrice());
	}
	
	public static void updateProdQuan(int id, int quan) {
		int getIndex = 0;
		String getProductType = null;
		int getProductQuant = 0;
		System.out.println("Hello in Update Product");
		for (int i = 0; i < prodList.size(); i++) {
			if (prodList.get(i).getProductID() == id) {
				getIndex = i;
				prodList.get(i).setProductQuat(quan);
				getProductType = prodList.get(i).getProductType();
				getProductQuant = prodList.get(i).getProductQuant();
			}
		}
		System.out.println("getIndex " + getIndex);
		System.out.println(
				"Product with ID " + id + " is updated with the latest quantity. ");
		
		
	}

	// The below method adds a new record into the Product inventory
	public static Boolean addNewRecord(String[] details, ArrayList<Product> prodsList) throws IOException {
		int prodQuant = 0;
		Boolean exists = false;
		prodQuant = Integer.parseInt(details[5]);
		Product prodDetails = new Product();
		// String[] detailArr = details.split(",");
		for(int i =0; i<prodsList.size(); i++) {
			if(prodsList.get(i).getProductID() == Integer.parseInt(details[0])) {
				System.out.println("Product ID alrady exists!");
				exists = true;
			}
		}
		if(!exists) {
			prodDetails.setProductID(Integer.parseInt(details[0]));
			prodDetails.setProductName(details[1]);
			prodDetails.setProductModel(details[2]);
			prodDetails.setProductManufacturer(details[3]);
			prodDetails.setProductPrice(Double.parseDouble(details[4]));
			prodDetails.setProductQuat(Integer.parseInt(details[5]));
			prodDetails.setProductLocation(details[6]);
			prodDetails.setProductType(details[7]);
			prodList.add(prodDetails);
			String getProductType = details[7];
			// //Update the count of the product in the inventory table
			for (int i = 0; i < inventory.size(); i++) {
				if (getProductType.equalsIgnoreCase(inventory.get(i).getProductType())) {
					inventory.get(i).setQuantity(inventory.get(i).getQuantity() + Integer.parseInt(details[5]));
				}
			}
			System.out.println("New product is added into the products list");
			// inventory after adding the product
			System.out.println("Inventory after adding the product:");
			showProductsTable();
			showInventoryTable();
		}
		return exists;
	}

	public static void main(String[] args) {
		try {
			loadProducts();
			loadInventory();
		} catch (IOException e2) {
			System.out.println("Some exception occured while loading CSV files");
		}
	}

	

	

	



	

	
}
