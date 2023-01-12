package Security;

import CarMart.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * This class SecurityCypher is for encrypt and decrypt data for/from CarMart. I created this security coding for secure txt file data.
 * I created list named "allCharacters" with all lowercase, uppercase letters in the alphabet and numbers from 0-9.
 * Variable cypherKey is for encrypt or decrypt data from txtFile. The cypherKey value is moving characters in allCharacters list.
 * SecurityCypher class has 2 methods that are used in LoadCarsFromTxtFileService and SaveCarsToTxtFileService.
 */
public class SecurityCypher {

    Character[] allCharacters = {'s', 'L', 'r', 'e', 'u', 'H', 'N', 'c', '1', 'O', '4', 'o', 'D', '0', 'B', 'Y', 'd', 'q', 'C', 'I', 'G', 'z', 't', '8', 'n', 'm', 'W', 'M', 'l', 'a', 'p', 'X', 'b', 'f', 'A', 'y', 'U', 'h', 'g', 'P', 'i', 'R', '2', '5', 'k', 'x', 'V', '7', 'T', '6', 'Q', '3', 'K', '9', 'Z', 'v', 'w', 'S', 'J', 'E', 'F', 'j'};
    private int cypherKey = 3 * 3;

    //This method is for encrypting data, when program is writing new added cars to txt file to keep them "safe".
    public String encryptCarMartData(List<Car> listOfCars) {
        StringBuilder stringBuilderForEncrypt = new StringBuilder();

        //For loop that goes through listOfCars and loading all car's data to stringBuilderForEncrypt.
        for (Car car : listOfCars) {
            stringBuilderForEncrypt.append(car.getId() + ", " + car.getBrand() + ", " + car.getType() + ", " + car.getAge() + ", " + car.getPrice() + ", " + car.getKm());
        }

        //For loop with data variable to load all characters of car's data and load them to listOfAllDataCharacters.
        String data = stringBuilderForEncrypt.toString();
        List<Character> listOfAllCarDataCharacters = new ArrayList<>();
        for (char characters : data.toCharArray()) {
            listOfAllCarDataCharacters.add(characters);
        }

        //Removing empty spaces ' ' from listOfAllCarDataCharacters.
        int i = 0;
        while (i < listOfAllCarDataCharacters.size()) {
            if (listOfAllCarDataCharacters.get(i) == ' ') {
                listOfAllCarDataCharacters.remove(i);

            } else {
                i++;
            }
        }

        //For loop through the list again and for each character, it looks for the index in the array "allCharacters".
        for (i = 0; i < listOfAllCarDataCharacters.size(); i++) {
            int index = -1;
            for (int j = 0; j < allCharacters.length; j++) {
                if (listOfAllCarDataCharacters.get(i).equals(allCharacters[j])) {
                    index = j;
                    break;
                }
            }

            //Program gets the new index by calculating (index + cypherKey) % allCharacters.length.
            //The new character is then replaced with the character at the new index in the "allCharacters" array.
            if (index != -1) {
                int newIndex = (index + cypherKey) % allCharacters.length;
                listOfAllCarDataCharacters.set(i, allCharacters[newIndex]);
            }
        }

        //For loop goes through the list "listOfAllCarDataCharacters" and adds each character to the "stringBuilderForEncrypt".
        stringBuilderForEncrypt = new StringBuilder();
        for (Character ch : listOfAllCarDataCharacters) {
            stringBuilderForEncrypt.append(ch);
        }

        //Returning encrypted data of cars.
        return stringBuilderForEncrypt.toString();
    }

    //This method is for decrypting cyphered data in txt file. Method named loadCarsFromTxtFile using this method first for decrypt data.
    public String decryptCarMartData(String data) {
        List<Character> listOfAllCarDataCharacters = new ArrayList<>();

        //For loop that loading characters of data with toCharArray() to listOfAllCarDataCharacters.
        for (char characters : data.toCharArray()) {
            listOfAllCarDataCharacters.add(characters);
        }

        //Removing empty spaces ' ' from listOfAllCarDataCharacters.
        int i = 0;
        while (i < listOfAllCarDataCharacters.size()) {
            if (listOfAllCarDataCharacters.get(i) == ' ') {
                listOfAllCarDataCharacters.remove(i);
            } else {
                i++;
            }
        }

        //For loop through the list again and for each character, it looks for the index in the array "allCharacters".
        for (i = 0; i < listOfAllCarDataCharacters.size(); i++) {
            int index = -1;
            for (int j = 0; j < allCharacters.length; j++) {
                if (listOfAllCarDataCharacters.get(i).equals(allCharacters[j])) {
                    index = j;
                    break;
                }
            }

            //Program gets the new index by calculating (index + cypherKey) % allCharacters.length.
            //The new character is then replaced with the character at the new index in the "allCharacters" array.
            if (index != -1) {
                int newIndex = (index - cypherKey + allCharacters.length) % allCharacters.length;
                listOfAllCarDataCharacters.set(i, allCharacters[newIndex]);
            }
        }

        //For loop goes through the list "listOfAllCarDataCharacters" and adds each character to the stringBuilderWithDecryptedText.
        StringBuilder stringBuilderWithDecryptedText = new StringBuilder();
        for (Character Characters : listOfAllCarDataCharacters) {
            stringBuilderWithDecryptedText.append(Characters);
        }

        //Returning decrypted data of cars.
        return stringBuilderWithDecryptedText.toString();
    }
}



