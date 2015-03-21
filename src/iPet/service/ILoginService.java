package iPet.service;

import iPet.model.User;

public interface ILoginService {
	User login(String name, String password);
}
