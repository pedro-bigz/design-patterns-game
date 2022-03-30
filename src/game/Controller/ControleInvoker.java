/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Controller;

import game.Controller.Commands.Command;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ControleInvoker
{
    private ArrayList<Command> commands = new ArrayList<>();
    private ArrayList<Command> logs = new ArrayList<>();

    public ArrayList<Command> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<Command> commands) {
        this.commands = commands;
    }

    public void addCommand(Command command) {
        this.commands.add(command);
    }

    public void setCommand(int n, Command command) {
        this.commands.set(n, command);
    }
    
    public void executeCommand(int n) {
        this.commands.get(n).execute();
        this.logs.add(this.commands.get(n));
    }    
}
