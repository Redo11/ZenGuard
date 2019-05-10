package ru.ruscode.zenguard.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.ruscode.zenguard.utils.ChatUtil;

public class ZenGuardCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player p = (Player) sender;
        if (args.length < 1){
            p.sendMessage(" ");
            p.sendMessage(ChatUtil.fix("&4ZenGuard Protection &8[&7(&fVersion: 1.0&7)&8, &7(&fAuthor: PolskiStevek &fProgramista: h69_&7)&8]"));
            p.sendMessage(" ");
            p.sendMessage("&6/zenguard menu");
        }
        else {
            if (!p.hasPermission("zenguard.cmd")) {
                p.sendMessage(ChatUtil.fix("&8[&3ZenGuard&8] &4You don't have permission!"));
            }

        }
        return false;
    }
}
