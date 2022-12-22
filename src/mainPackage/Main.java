package mainPackage;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Food[] breakfast = new Food[20];
        boolean isSort = false;
        boolean isCalories = false;
        int i = 0;
        for (String arg: args) {
            switch (arg) {
                case "-sort": {
                    isSort = true;
                    break;
                }
                case "-calories": {
                    isCalories = true;
                    break;
                }
                default: {
                    String[] parts = arg.split("/");
                    switch (parts[0]) {
                        case "Cheese": {
                            breakfast[i] = new Cheese();
                            break;
                        }
                        case "Apple": {
                            breakfast[i] = new Apple(parts[1]);
                            break;
                        }
                        case "ChewingGum": {
                            breakfast[i] = new ChewingGum(parts[1]);
                            break;
                        }
                    }
                    i += 1;
                }
            }
        }
        breakfast = Arrays.copyOfRange(breakfast, 0, i);

        //Изменить объект lookup в строке ниже, чтобы изменить настройки поиска
        ChewingGum lookup = new ChewingGum("мята");
        int count = 0;
        for(Food product: breakfast) {
            if (product.equals(lookup)) count++;
            product.consume();
        }
        System.out.println("В завтраке " + count + " продуктов " + lookup);

        if (isCalories) {
            int calories = 0;
            for (Food product: breakfast) {
                if (product != null)
                    calories += product.calculateCalories();
                else break;
            }
            System.out.println("В завтраке " + calories + " калорий");
        }

        if (isSort) {
            Arrays.sort(breakfast, new FoodComparator().reversed());
            for (Food product: breakfast) {
                if (product != null)
                    System.out.print(product + " (" + product.calculateCalories() + "), ");
            }
        }
    }
}