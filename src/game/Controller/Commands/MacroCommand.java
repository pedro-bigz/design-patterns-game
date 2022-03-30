/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Controller.Commands;

import game.Helpers.DateTime;
import game.Models.Game;
import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class MacroCommand implements Command
{
    private ArrayList<Command> macro = new ArrayList<>();
    private Game game;
    private String name;

    public MacroCommand(Game game)
    {
        this.game = game;
    }
    
    public void setCommands(ArrayList<Command> commands)
    {
        macro = commands;
    } 
    
    public void setCommand(int n, Command command)
    {
        macro.set(n, command);
    } 
    
    public void addCommand(Command command)
    {
        macro.add(command);
    } 
    
    @Override
    public void execute()
    {
        executeMacro();
    }
    
    public void executeMacro()
    {
        macro.forEach(command -> {
            command.execute();
        });
    }  

    @Override
    public String toString()
    {
        return "Combo -> " + DateTime.now() + "\n";
    } 
}
