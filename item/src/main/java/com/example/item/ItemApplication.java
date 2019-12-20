package com.example.item;

import com.example.item.controller.ItemController;
import com.example.item.model.Item;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class ItemApplication implements ExitCodeGenerator {

	private static ConfigurableApplicationContext context;

	private static ItemController itemController;

	public static void main(String[] args) {
		context = SpringApplication.run(ItemApplication.class, args);
		testApp();
	}

	private static void testApp() {
		System.out.println();
		itemController = (ItemController) context.getBean("itemController");

		// create customers
//		Pet pet1 = Pet.builder().withName("Strangles").withBirthDate(new Date()).withPetType(PetType.SNAKE).withOwner(owner1).build();
		Item item1 = Item.builder().withName("Mobile").withDescription("iPhone").withPrice(999.99).build();
		Item item2 = Item.builder().withName("Mobile").withDescription("samsung").withPrice(799.99).build();

		itemController.add(item1);
		itemController.add(item2);

		display(itemController.getAll());
	}

	private static void display(Object obj) {

		if (obj instanceof List) {

			List<?> list = (List) obj;
			for (Object o : list) {
				System.out.println("\t" + o);
			}

		} else {

			System.out.println(obj);

		}

		System.out.println();
	}

	@Override
	public int getExitCode() {
		return 42;
	}

}
