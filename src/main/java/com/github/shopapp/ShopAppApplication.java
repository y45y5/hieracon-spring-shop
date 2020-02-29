package com.github.shopapp;

import com.github.shopapp.model.product.Product;
import com.github.shopapp.model.product.ProductDaoImp;
import com.github.shopapp.model.user.BasicRole;
import com.github.shopapp.model.user.BasicRoleDaoImp;
import com.github.shopapp.model.user.BasicUser;
import com.github.shopapp.model.user.BasicUserDaoImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ShopAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopAppApplication.class, args);
		fillProducts();
		addRoles();
		addAdmin();
		System.out.println("----------------- Ready -----------------");
	}

	private static void addRoles(){
		BasicRoleDaoImp basicRoleDaoImp = new BasicRoleDaoImp();
		basicRoleDaoImp.save(new BasicRole("USER"));
		basicRoleDaoImp.save(new BasicRole("ADMIN"));
	}

	private static void addAdmin(){
		BasicRoleDaoImp basicRoleDaoImp = new BasicRoleDaoImp();
		ProductDaoImp productDaoImp = new ProductDaoImp();
		BasicUserDaoImp basicUserDaoImp = new BasicUserDaoImp();
		BasicUser basicUser = new BasicUser("admin", new BCryptPasswordEncoder().encode("admin"), true, "admin@email", basicRoleDaoImp.getFullList().get(1));

		Product product = productDaoImp.getFullList().get(0);
		basicUser.addProduct(product);
		basicUserDaoImp.save(basicUser);
		basicUser.getCartOrder().getProducts().remove(product);
		basicUserDaoImp.update(basicUser);
	}

	private static void fillProducts() {
		ProductDaoImp productDaoImp = new ProductDaoImp();
		String about = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin id lobortis tortor. Nullam semper leo et neque aliquet, id malesuada diam dictum. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin id lobortis tortor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin id lobortis tortor.";
		String cobalt = "cobaltseries.svg";
		String titan = "titanseries.svg";
		String night = "nightseries.svg";
		String jseries = "jseries.svg";
		String qseries = "qseries.svg";

		productDaoImp.save(new Product("Hieracon J", 120, about, jseries));
		productDaoImp.save(new Product("Hieracon J2", 159, about, jseries));
		productDaoImp.save(new Product("Hieracon J3", 180, about, jseries));
		productDaoImp.save(new Product("Hieracon J3+", 196, about, jseries));
		productDaoImp.save(new Product("Hieracon J4", 196, about, jseries));
		productDaoImp.save(new Product("Hieracon J4+", 210, about, jseries));
		productDaoImp.save(new Product("Hieracon Titan", 199, about, titan));
		productDaoImp.save(new Product("Hieracon Titan+", 220, about, titan));
		productDaoImp.save(new Product("Hieracon Titan 2", 235, about, titan));
		productDaoImp.save(new Product("Hieracon Titan 2+", 255, about, titan));
		productDaoImp.save(new Product("Hieracon Titan 3", 279, about, titan));
		productDaoImp.save(new Product("Hieracon Q", 190, about, qseries));
		productDaoImp.save(new Product("Hieracon Q Ultimate", 210, about, qseries));
		productDaoImp.save(new Product("Hieracon Cobalt", 200, about, cobalt));
		productDaoImp.save(new Product("Hieracon Cobalt Ultimate", 220, about, cobalt));
		productDaoImp.save(new Product("Hieracon Cobalt 2", 250, about, cobalt));
		productDaoImp.save(new Product("Hieracon Night", 180, about, night));
		productDaoImp.save(new Product("Hieracon Night 2", 200, about, night));
		productDaoImp.save(new Product("Hieracon Night 3", 235, about, night));
		productDaoImp.save(new Product("Hieracon Night 3+", 255, about, night));
	}

}
