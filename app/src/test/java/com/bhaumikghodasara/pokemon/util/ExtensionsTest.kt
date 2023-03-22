package com.bhaumikghodasara.pokemon.util

import org.junit.Assert
import org.junit.Test

class ExtensionsTest {
    @Test
    fun `GIVEN string WHEN called isLetters THEN return true`() {
        val input = "HelloWorld"
        Assert.assertTrue(input.isLetters())
    }

    @Test
    fun `GIVEN string WHEN called isLetters THEN return false`() {
        val input = "HelloWorld123"
        Assert.assertFalse(input.isLetters())
    }

    @Test
    fun `GIVEN string WHEN called capitalizeFirstCharacter THEN return string with first letter capital`(){
        val input = "hello"
        Assert.assertEquals("Hello", input.capitalizeFirstCharacter())
        val input1 = "hello world"
        Assert.assertEquals("Hello world", input1.capitalizeFirstCharacter())
    }
}