package ru.ruscode.zenguard.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.ruscode.zenguard.Main;
import ru.ruscode.zenguard.utils.ChatUtil;
import ru.ruscode.zenguard.utils.ConfigUtils;
import ru.ruscode.zenguard.utils.GuiUtil;

public class ZenGuardCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player p = (Player) sender;
        if (args.length < 1){
            p.sendMessage(" ");
            p.sendMessage(ChatUtil.fix("&4ZenGuard Protection &8[&7(&fVersion: " + Main.getInstance().getDescription().getVersion() + "&7)&8, &7(&fAuthor[s]: xThunderek, 0xygenOfficial&7)&8]"));
            p.sendMessage(" ");
            p.sendMessage(ChatUtil.fix("&6/zenguard menu"));
            p.sendMessage(ChatUtil.fix("&6/zenguard reload"));
        }
        else {
            if (args[0].equalsIgnoreCase("menu")) {
                if (!p.hasPermission(ConfigUtils.getString("general.permission"))) {
                    p.sendMessage(ChatUtil.fix("&8[&3ZenGuard&8] " + ConfigUtils.getString("messages.no-permission")));
                }
                GuiUtil.mainGui(p);
            }
            else if (args[0].equalsIgnoreCase("reload")){
                Main.getInstance().reloadConfig();
                p.sendMessage(ChatUtil.fix(ConfigUtils.getString("messages.reload")));
            }
            else {
                p.sendMessage(ChatUtil.fix(ConfigUtils.getString("messages.unknown-cmd")));
            }
            return false;
        }
        return false;
    }
}
