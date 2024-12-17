package com.destination;

import java.util.Scanner;

	// Class to hold candidate details (name)
	class CandidateDetail {
	    String name;

	    // Constructor to initialize candidate's name
	    CandidateDetail(String name) {
	        this.name = name;
	    }
	}

	public class QuizeGameProject {
	    static int prizeMoney = 0; // Variable to keep track of the prize money
	    static int lifelineCount = 2; // Lifelines available to the player

	    // Static arrays for the questions, options, and correct answers
	    static String[] questions = {
	        "What is the capital of France?",
	        "Who wrote 'Romeo and Juliet'?",
	        "What is the largest planet in our solar system?",
	        "Which element does 'O' represent on the periodic table?",
	        "What is the speed of light in m/s?"
	    };

	    static String[][] options = {
	        {"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"},
	        {"1. Charles Dickens", "2. J.K. Rowling", "3. William Shakespeare", "4. Mark Twain"},
	        {"1. Earth", "2. Jupiter", "3. Mars", "4. Venus"},
	        {"1. Hydrogen", "2. Oxygen", "3. Nitrogen", "4. Carbon"},
	        {"1. 3 x 10^8 m/s", "2. 3 x 10^5 m/s", "3. 3 x 10^6 m/s", "4. 3 x 10^7 m/s"}
	    };

	    // Indices of correct answers for each question
	    static int[] correctAnswers = {3, 3, 2, 2, 1};

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        // Getting the candidate's name
	        System.out.print("Enter your name: ");
	        String candidateName = sc.nextLine();
	        CandidateDetail candidate = new CandidateDetail(candidateName);

	        // Starting the game
	        boolean continueGame = true;
	        int questionNumber = 0;

	        System.out.println("Welcome " + candidate.name + " to the Quiz Game!");

	        // Game loop: Iterate through the questions until the game is over
	        while (questionNumber < questions.length && continueGame) {
	            // Displaying the question
	            System.out.println("\nQuestion " + (questionNumber + 1) + ": " + questions[questionNumber]);

	            // Displaying the options for the current question
	            for (String option : options[questionNumber]) {
	                System.out.println(option);
	            }

	            // Option for lifeline
	            System.out.println("5. Lifeline Option");

	            // Asking the player for an answer
	            System.out.print("Enter your choice: ");
	            int choice = sc.nextInt();

	            // Handling different choices (1 to 5)
	            switch (choice) {
	                case 1:
	                case 2:
	                case 3:
	                case 4:
	                    // Checking if the answer is correct
	                    if (choice == correctAnswers[questionNumber]) {
	                        prizeMoney += 1000; // Adding money for the correct answer
	                        System.out.println("Correct! You won " + prizeMoney + " rupees.");
	                    } else {
	                        System.out.println("Wrong answer! Game over.");
	                        continueGame = false; // Ending the game if answer is incorrect
	                    }
	                    break;
	                case 5:
	                    // If the player chooses a lifeline
	                    if (lifelineCount > 0) {
	                        lifelineCount--; // Using one lifeline
	                        System.out.println("Choose a lifeline:");
	                        System.out.println("1. Audience Phone");
	                        System.out.println("2. 50-50");

	                        int lifelineChoice = sc.nextInt();
	                        if (lifelineChoice == 1) {
	                            // Audience Phone lifeline
	                            System.out.println("Audience Phone selected. They suggest Option " + correctAnswers[questionNumber] + ".");
	                        } else if (lifelineChoice == 2) {
	                            // 50-50 lifeline (removing incorrect options)
	                            System.out.println("50-50 selected. Two incorrect options removed.");
	                            System.out.println("Remaining options: " + options[questionNumber][correctAnswers[questionNumber] - 1] + " and one incorrect option.");
	                        } else {
	                            System.out.println("Invalid lifeline choice.");
	                        }

	                        // Asking for the final answer after using lifeline
	                        System.out.print("Enter your final answer: ");
	                        int finalAnswer = sc.nextInt();
	                        if (finalAnswer == correctAnswers[questionNumber]) {
	                            prizeMoney += 1000; // Adding money for the correct final answer
	                            System.out.println("Correct! You won " + prizeMoney + " rupees.");
	                        } else {
	                            System.out.println("Wrong answer! Game over.");
	                            continueGame = false; // Ending the game if the final answer is incorrect
	                        }
	                    } else {
	                        System.out.println("No lifelines remaining.");
	                    }
	                    break;
	                default:
	                    // Handling invalid input
	                    System.out.println("Invalid choice. Try again.");
	                    break;
	            }

	            // Moving to the next question if the game continues
	            if (continueGame) {
	                questionNumber++;
	            }
	        }

	        // Game over message
	        System.out.println("\nGame Over! You won a total of " + prizeMoney + " rupees.");
	        sc.close();
	    }
	}
