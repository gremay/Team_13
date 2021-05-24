package com.team13.dealmymeal

import com.team13.dealmymeal.core.NotEnoughMealsException
import com.team13.dealmymeal.core.PlanGenerator
import com.team13.dealmymeal.data.Category
import com.team13.dealmymeal.data.Meal
import org.junit.BeforeClass
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class PlanGeneratorTest {
    private lateinit var mealList: List<Meal>

    @Before
    fun fillList() {
        val meal1 = Meal("MealMeat1", listOf(Category.MEAT.category), 1.0f)
        val meal2 = Meal("MealMeat2", listOf(Category.MEAT.category), 2.0f)
        val meal3 = Meal("MealMeatSpecial", listOf(Category.MEAT.category, Category.SPECIAL.category), 3.0f)
        val meal4 = Meal("MealVegetarian1", listOf(Category.VEGETARIAN.category), 4.0f)
        val meal5 = Meal("MealVegetarian2", listOf(Category.VEGETARIAN.category), 5.0f)
        val meal6 = Meal("MealVegetarianSpecial", listOf(Category.VEGETARIAN.category, Category.SPECIAL.category), 5.0f)
        mealList = listOf(meal1, meal2, meal3, meal4, meal5, meal6)
    }

    @Test
    fun planNotPossibleToManyDays() {
        assertThrows(NotEnoughMealsException::class.java) {
            PlanGenerator.generatePlan(7, 1, 2, 2, 2)
        }
    }

    @Test
    fun planNotPossibleToManyMealsPerDay() {
        assertThrows(NotEnoughMealsException::class.java) {
            PlanGenerator.generatePlan(3, 2, 2, 2, 2)
        }
    }
}