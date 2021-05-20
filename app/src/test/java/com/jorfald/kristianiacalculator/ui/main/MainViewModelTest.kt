package com.jorfald.kristianiacalculator.ui.main

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test

class MainViewModelTest {

    private lateinit var viewModel: MainViewModel
    private val errorString = "Error! - "

    @Before
    fun setUp() {
        viewModel = MainViewModel()
    }

    @Test
    fun plusAddsNumbersAndReturnsCorrectString() {
        // Given
        val num1 = 5
        val num2 = 7
        viewModel.typeNumber(num1)
        viewModel.typeExpression("+")
        viewModel.typeNumber(num2)

        // When
        val result = viewModel.plus()

        // Then
        assertEquals(result, "12.0")
    }

    @Test
    fun typeNumberDoesNotReturnWrongNumber() {
        // Given
        val num1 = 42
        val num2 = -5

        // When
        val result1 = viewModel.typeNumber(num1)
        val result2 = viewModel.typeNumber(num2)

        // Then
        assertNotEquals(result1, "42.0")
        assertNotEquals(result1, "42")
        assertNotEquals(result2, "-5")
        assertNotEquals(result2, "-5.0")
    }

    @Test
    fun plusReturnsErrorTextIfNumberCannotBeParsed() {
        // Given
        val num = 5
        viewModel.typeNumber(num)

        // When
        val result = viewModel.plus()

        // Then
        assertEquals(result, errorString + "Could not add")
    }

    @Test
    fun getErrorGivesCorrectString() {
        // Given
        val testString = "Test"

        // When
        val result = viewModel.getError(testString)

        // Then
        assertEquals(result, errorString + "Test")
    }
}