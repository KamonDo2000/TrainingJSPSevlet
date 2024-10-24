package service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import entities.Pet;

public class IOService {
    public static void savePets(List<Pet> pets) {
	try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("pets.txt"))) {
	    oos.writeObject(pets);
	    System.out.println("Lưu Pets Thành Công.");
	} catch (IOException e) {
	    System.out.println("Lỗi Đọc file: " + e.getMessage());
	}
    }

    @SuppressWarnings("unchecked")
    public static List<Pet> getPets() {
	List<Pet> pets = new ArrayList<>();
	try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pets.txt"))) {
	    pets = (List<Pet>) ois.readObject();
	} catch (IOException | ClassNotFoundException e) {
	    System.out.println("Lỗi Đọc file: " + e.getMessage());
	}
	return pets;
    }
}