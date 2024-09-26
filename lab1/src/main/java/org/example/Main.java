package org.example;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            long[][] matrix1 = {
                    {15, 42, 20},
                    {31, -5, 0},
                    {5, 8, -1},
                    {24, 0, 5}
            };
            long constant1 = 3;

            long[][] matrix2 = {
                    {406, 245, 315},
                    {124, 94, 24},
                    {57, -25, 0},

            };
            long constant2 = -4;

            long[][] matrix3 = {
                    {406, 245, 315, 234},
                    {124, 94, 24},
                    {57, -25, 0},

            };
            long constant3 = -2;

            matrixOperations(matrix1,constant1);
            matrixOperations(matrix2,constant2);
            matrixOperations(matrix3,constant3);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Leaving array.");
        }
        catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
        finally {
            System.out.println(" Press 'Enter' to finish...");
            scanner.nextLine();
            scanner.close();
        }
    }

    // Виконавчий метод
    public static void matrixOperations (long[][] matrixB, long constant){
        System.out.println("Given matrix with element types 'long':");
        printMatrix(matrixB);
        System.out.println("Constant 'a' for multiplication: " + constant);

        long[][] resultMatrix = multiplyMatrixByConstant(matrixB, constant);
        System.out.println("The result of multiplying the matrix by the constant 'a':");
        printMatrix(resultMatrix);

        long sumMaxElements = sumMaxElementsInRows(resultMatrix);
        System.out.println("Sum of the largest elements of each row of matrix C: " + sumMaxElements + "\n");
    }

    // Метод для виведення матриці
    public static void printMatrix(long[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Метод для обчислення першої операції: a * B
    public static long[][] multiplyMatrixByConstant(long[][] matrix, long constant) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        long[][] result = new long[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] * constant;
            }
        }
        return result;
    }

    // Метод для обчислення суми найбільших елементів кожного рядка
    public static long sumMaxElementsInRows(long[][] matrix) {
        long sum = 0;
        for (long[] row : matrix) {
            long max = row[0];
            for (long value : row) {
                if (value > max) {
                    max = value;
                }
            }
            sum += max;
        }
        return sum;
    }
}
