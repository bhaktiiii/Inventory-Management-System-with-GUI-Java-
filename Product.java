public class Product {

	int productID;
	String product_Name;
	String product_Model;
	String product_Manufacturer;
	Double product_Price;
	int quantity;
	String location;
	String product_Type;

	// Getter and setter methods for Product details
	public int getProductID() {
		return productID;
	}

	public void setProductID(int ID) {
		productID = ID;
	}

	public String getProductName() {
		return product_Name;
	}

	public void setProductName(String prodName) {
		product_Name = prodName;
	}

	public String getProductModel() {
		return product_Model;
	}

	public void setProductModel(String prodModel) {
		product_Model = prodModel;
	}

	public String getProductManufacturer() {
		return product_Manufacturer;
	}

	public void setProductManufacturer(String prodManufacturer) {
		product_Manufacturer = prodManufacturer;
	}

	public Double getProductPrice() {
		return product_Price;
	}

	public void setProductPrice(Double prodPrice) {
		product_Price = prodPrice;
	}

	public int getProductQuant() {
		return quantity;
	}

	public void setProductQuat(int prodQuant) {
		quantity = prodQuant;
	}

	public String getProductLocation() {
		return location;
	}

	public void setProductLocation(String prodLoca) {
		location = prodLoca;
	}

	public String getProductType() {
		return product_Type;
	}

	public void setProductType(String prodType) {
		product_Type = prodType;
	}
}