package com.jdbc.Main;

import java.util.ArrayList;
import java.util.List;

import com.jdbc.DAOimpl.MenuDAOImpl;
import com.jdbc.dao.MenuDAO;
import com.jdbc.model.Menu;
import com.jdbc.model.Restaurant;

public class Main_Menu {

    public static void main(String[] args) {
        // Interface and its implementing class
        MenuDAO menuDAO = new MenuDAOImpl();

        // 1. Insert a new menu item
        /*
         Menu m= new Menu(1, "Chicken Biryani", "Spicy and delicious chicken biryani", 150.0, true, "chicken_biryani.jpg");
        int insertStatus = menuDAO.insertMenu(m);
        

        // 2. Fetch all menu items for a restaurant (assuming restaurant ID 1)
        List<Menu> menuList = menuDAO.getAllRestMenu(1);
        for (Menu menu : menuList) {
            System.out.println(menu);
        }

        // 3. Fetch a specific menu item by ID
        Menu specificMenu = menuDAO.getMenuById(1);  // Fetching the menu item with ID = 1
        System.out.println(specificMenu);
        */
  
        // 4. Delete a menu item by ID (Uncomment to test)
        
        int deleteStatus = menuDAO.deleteMenuById(2);  // Deleting the menu item with ID = 1
        System.out.println("Delete Status: " + deleteStatus);
        

        // 5. Update the availability status of a menu item by ID 
        /*
        int updateStatus = menuDAO.UpdateMenuById("false", 1);  // Updating availability status for menu item with ID = 1
         System.out.println("Update Status: " + updateStatus);
        */
    }
}
