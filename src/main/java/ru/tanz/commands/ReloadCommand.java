package ru.tanz.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import ru.tanz.StaffChat;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("tstaffchat.use")){
            return true;
        }
        if(args[0].equalsIgnoreCase("reload")){
            sender.sendMessage("Вы успешно перезагрузили конфигурацию.");
            StaffChat.getInstance().reloadConfig();
            StaffChat.getInstance().registerChats();
        }else {
            return true;
        }
        return false;
    }
}
