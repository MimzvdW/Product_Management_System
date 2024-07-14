/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.product_management_system;

import static com.mycompany.product_management_system.ProductManagement.get_Valid_Double_Input;
import static com.mycompany.product_management_system.ProductManagement.get_Valid_Int_Input;
import static com.mycompany.product_management_system.ProductManagement.get_Valid_String_Input;
import java.util.ArrayList;
import java.util.Scanner;



// Product class - Representing the variables for the products
class Product
{
    private static int nextID = 1; // Initialize the ID counter
    private int ProductID;
    private String ProductName;
    private double ProductPrice;
    private int ProductQuantity;
    
    //Product class constructor
    public Product(String ProductName, double ProductPrice, int ProductQuantity)
    {
        this.ProductID = nextID++; // Assign the next available ID
        this.ProductName = ProductName;
        this.ProductPrice = ProductPrice;
        this.ProductQuantity = ProductQuantity;
    }
    
     // Getters and setters for each variable
    // We want the product ID to be generator automatically, therefor we will not great a setter
    public int getProductID() 
    {
        return ProductID;
    }
     //Name methods
    public String getProductName() 
    {
        return ProductName;
    }

    public void setProductName(String ProductName) 
    {
        this.ProductName = ProductName;
    }

    //Price methods
    public double getProductPrice() 
    {
        return ProductPrice;
    }

    public void setProductPrice(double ProductPrice) 
    {
        this.ProductPrice = ProductPrice;
    }
    
    //Quantity methods
     public int getProductQuantity() 
    {
        return ProductQuantity;
    }

    public void setProductQuantity(int ProductQuantity) 
    {
        this.ProductQuantity = ProductQuantity;
    }
    
     // Convert the product details to a string
        @Override
    public String toString() 
    {
       return "Product ID: P" + ProductID + " , Product Name: " + ProductName + " , Product Price R " + ProductPrice + " , Product Quantity : " + ProductQuantity;
    }
}

// Product management - This will contain the array and all methods that will use the array's data
class ProductManagement
{                                                    // ArrayList to store products
    private ArrayList<Product> products;            // ArrayList is perfect because the array can size itself as needed
    
    public ProductManagement()
    {
        this.products = new ArrayList<>(); 
    }
                      
    // Method to add a new product
    public void addProduct(String ProductName, double ProductPrice, int ProductQuantity) 
    {
        Product newProduct = new Product(ProductName, ProductPrice, ProductQuantity);
        products.add(newProduct);
        System.out.println("Product added successfully: " + newProduct);
    }

    // Method to edit an existing product
    public void editProduct(int ProductID, String ProductName, double ProductPrice, int ProductQuantity)
    {
        for (Product product : products) 
        {
            if(product.getProductID() == ProductID)
            {
                product.setProductName(ProductName);
                product.setProductPrice(ProductPrice);
                product.setProductQuantity(ProductQuantity);
                
                System.out.println("Product data has been updated successfully.");
                return; // Stop searching once product is found and updated
            }
        }
        System.out.println("Product with ID " + ProductID + " not found. No changes were made.");
    }
    
    // Method to remove a product
    public void removeProduct(int ProductID) 
    {
        for (Product product : products) 
        {
            if (product.getProductID() == ProductID) 
            {
                products.remove(product);
                System.out.println("Product with ID " + ProductID + " has been removed successfully.");
                return; // Stop searching once product is found and removed
            }
        }
        System.out.println("Product with ID " + ProductID + " not found. No changes were made.");
    }
    
    // Method to view all products
    public void viewProducts() 
    {
        if (products.isEmpty()) 
        {
            System.out.println("No products available.");
        } 
        else 
        {
            System.out.println("List of all products:");
            for (Product product : products) 
            {
                System.out.println(product); // Calls the overridden toString() method of Product
            }   
        }
    }
    
    // Exception handling for valid string input
    static String get_Valid_String_Input(String prompt)
    {
        while(true)
        {
            Scanner scan = new Scanner(System.in);
            try
            {
                System.out.println(prompt);
                String input = scan.nextLine();
                if (input.matches(".*\\d+.*")) 
                {
                    throw new NumberFormatException();
                }
                return input;
            }
            catch (NumberFormatException err)
            {
                System.out.println("ERROR: Invalid input. Please do not enter a number") ;
            }
        }
    }
    
    // Exception handling for valid double input
    static double get_Valid_Double_Input(String prompt)
    {
        while(true)
        {
            Scanner scan = new Scanner(System.in);
            try
            {
                System.out.println(prompt);
                return Double.parseDouble(scan.nextLine());
            }
            catch (NumberFormatException err)
            {
                System.out.println("ERROR: Invalid input. Please enter a decimal number using dot (.) as decimal separator");
            }
        }
    }
    
    // Exception handling for valid integer input
    static int get_Valid_Int_Input(String prompt)
    {
        while(true)
        {
            Scanner scan = new Scanner(System.in);
            try
            {
                System.out.println(prompt);
                return Integer.parseInt(scan.next());
            }
            catch (NumberFormatException err)
            {
                System.out.println("ERROR: Invalid input. Please enter a number)");
            }
        }
    }
}

public class Product_Management_System {
    // Main Class and method
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        ProductManagement productManage = new ProductManagement();
        
        System.out.println("+-----------------------+");
        System.out.println("| Product Manage System |");
        System.out.println("+-----------------------+");
        
        while (true) 
        {
            System.out.println(" ");
            System.out.println("1. Add Product");
            System.out.println("2. Edit Product");
            System.out.println("3. Remove Product");
            System.out.println("4. View Product");
            System.out.println("5. Exit");
            //System.out.println("Please enter your option: ");
                
            int option = get_Valid_Int_Input("Please enter your option: ");
            
            switch (option) {
                case 1:
                    String addProductName = get_Valid_String_Input("Enter the name of the product: ");
                    System.out.println(" ");
                    double addProductPrice = get_Valid_Double_Input("Enter the price of the product : ");
                    System.out.println(" ");
                    int addProductQuantity = get_Valid_Int_Input("Enter the quantity of the product : ");
                    System.out.println(" ");
                    
                    //Calls the add method
                    productManage.addProduct(addProductName, addProductPrice, addProductQuantity);
                    break;
                
                case 2:
                    int ProductID_to_Edit = get_Valid_Int_Input("Enter the ID number of the product you wish to edit");                    
                    String newProductName = get_Valid_String_Input("Enter the name of the product: ");
                    System.out.println(" ");
                    double newProductPrice = get_Valid_Double_Input("Enter the price of the product : ");
                    System.out.println(" ");
                    int newProductQuantity = get_Valid_Int_Input("Enter the quantity of the product : ");
                    System.out.println(" ");
                    
                    //Calls the edit method
                    productManage.editProduct(ProductID_to_Edit, newProductName, newProductPrice, newProductQuantity);
                    break;
                
                case 3:
                    int ProductID_to_delet = get_Valid_Int_Input("Enter the ID number of the product you wish to delete"); 
                    
                    //Calls the remove method
                    productManage.removeProduct(ProductID_to_delet);
                    break;
                
                case 4:
                    //Calls the view method
                    productManage.viewProducts();
                    break;
                
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Please enter a number between 1 and 5");
            }
        }
    }
}


