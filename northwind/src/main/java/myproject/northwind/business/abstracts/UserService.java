package myproject.northwind.business.abstracts;

import myproject.northwind.core.entities.User;
import myproject.northwind.core.utilities.results.DataResult;
import myproject.northwind.core.utilities.results.Result;

public interface UserService {
	
	Result add(User user);
	DataResult<User> findByEmail(String email);
}
