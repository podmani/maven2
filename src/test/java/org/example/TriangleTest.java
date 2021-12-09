package org.example;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    public void triangleExist() {

        Triangle triangle = new Triangle(4, 4, 6);
        triangle.squTriangle();
        Assert.assertTrue(true);

    }

    @Test
    public void triangleNoExist() {

        Triangle triangle = new Triangle(-1, 1, 6);
        triangle.squTriangle();
        Assert.assertEquals("NaN", "треугольника не существует");

    }
}