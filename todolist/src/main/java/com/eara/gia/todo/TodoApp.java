package com.eara.gia.todo;

import com.eara.gia.todo.utils.CommandLineInputHandler;


/**
 * This class prints the application's options on the console,
 * reads the user's input from the prompt, translates the one-letter input
 * into a command object, and handles it accordingly.
 *
 * @author Ernesto A. Rodriguez Acosta
 */
public class TodoApp {

    public static final char DEFAULT_INPUT = '\u0000';

    public static void main(String[] args) {
        CommandLineInputHandler commandLineInputHandler = new CommandLineInputHandler();
        char command = DEFAULT_INPUT;
/**
        // Application runs as long as user enters exit command
        while(CommandLineInput.EXIT.getShortCmd() != command) {
            commandLineInputHandler.printOptions();

            String input = commandLineInputHandler.readInput();
            //char [] inputChars = input.length() == 1 ? input.toCharArray() : new char [] {DEFAULT_INPUT};
            //command = inputChars[0];
            command = CharUtils.toChar(input, DEFAULT_INPUT);

            // Mapping between one-letter prompt input and a command object
            CommandLineInput commandLineInput = CommandLineInput.getCommandLineInputForInput(command);

            // Executes CRUD command
            commandLineInputHandler.processInput(commandLineInput);
        }
 */
    }
}
