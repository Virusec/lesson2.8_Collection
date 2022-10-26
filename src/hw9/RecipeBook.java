package hw9;

import java.util.HashSet;
import java.util.Set;

public class RecipeBook {
    public static Set<Recipe> recipes = new HashSet<>();

    public static void addRecipe(Recipe recipe) {
        if (recipes.contains(recipe)) {
            throw new IllegalArgumentException("Рецепт с данным названием уже есть в списке!");
        }
        recipes.add(recipe);
    }
}
