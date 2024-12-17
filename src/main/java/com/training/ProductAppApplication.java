package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.training.ui.ProductConsoleUI;

@SpringBootApplication
public class ProductAppApplication {

	public static void main(String[] args) {
		ApplicationContext springContainer = 
				SpringApplication.run(ProductAppApplication.class, args);
		
		ProductConsoleUI ui = springContainer.getBean(ProductConsoleUI.class);
		//ProductConsoleUI ui2 = springContainer.getBean(ProductConsoleUI.class);
		//System.out.println(ui == ui2);
		ui.createProductWithUI();
	}

}
