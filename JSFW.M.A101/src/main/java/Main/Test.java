package Main;

import java.util.ArrayList;
import java.util.List;

import entities.Pet;
import service.IOService;

public class Test {
    private IOService iOService;

    public Test() {
        iOService = new IOService();
    }

    public static void main(String[] args) {
        Test test = new Test();

        // Create a list of pets
        List<Pet> petList = new ArrayList<>();
        petList.add(new Pet("Mèo Báo", "cat", 3));
        petList.add(new Pet("Vàng", "dog", 5));
        petList.add(new Pet("Bông", "rabbit", 2));

        // Lưu danh sách thú cưng vào file
        IOService.savePets(petList);

        // Lấy thú cưng đã lưu từ file
        List<Pet> savedPets = IOService.getPets();

        // Lặp lại danh sách thú cưng đã lưu và gọi phương thức makeNoise()
        for (Pet pet : savedPets) {
            pet.makeNoise();
        }
    }
}