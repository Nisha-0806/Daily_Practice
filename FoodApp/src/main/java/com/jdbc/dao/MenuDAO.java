package com.jdbc.dao;

import java.util.List;
import com.jdbc.model.Menu;
public interface MenuDAO {
	int insertMenu(Menu m);
	List<Menu>getAllRestMenu(int restaurant_id);
	Menu getMenuById(int id);
	int deleteMenuById(int id);
	int UpdateMenuById(String isavailable,int id);
	


}
