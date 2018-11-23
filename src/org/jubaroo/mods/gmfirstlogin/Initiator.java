
package org.jubaroo.mods.gmfirstlogin;

import com.wurmonline.server.items.WurmColor;
import com.wurmonline.server.players.Player;
import org.gotti.wurmunlimited.modloader.interfaces.Configurable;
import org.gotti.wurmunlimited.modloader.interfaces.PlayerLoginListener;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.wurmonline.server.items.ItemList.*;

public class Initiator implements WurmServerMod, PlayerLoginListener, Configurable {
    private static Logger logger;
    static String playerNames;
    static boolean equipmentEnchants;
    static boolean giveWeapon;
    static boolean giveCap;
    static boolean giveChest;
    static boolean giveSleeve;
    static boolean giveGauntlet;
    static boolean giveLegs;
    static boolean giveBoots;
    static int weapon;
    static int cap;
    static int chest;
    static int sleeve;
    static int gauntlet;
    static int legs;
    static int boot;
    private static int armorColorRed;
    private static int armorColorGreen;
    private static int armorColorBlue;
    static int armorColor;
    static byte gmPowerToSet;
    private static boolean debug;

    static {
        logger = Logger.getLogger(Initiator.class.getName());
        playerNames = "";
        equipmentEnchants = true;
        giveWeapon = true;
        giveCap = true;
        giveChest = true;
        giveSleeve = true;
        giveGauntlet = true;
        giveLegs = true;
        giveBoots = true;
        weapon = swordTwoHander;
        cap = dragonLeatherCap;
        chest = dragonScaleJacket;
        sleeve = dragonScaleSleeve;
        gauntlet = dragonScaleGauntlet;
        legs = dragonScaleHose;
        boot = dragonScaleBoot;
        armorColorRed = 255;
        armorColorGreen = 255;
        armorColorBlue = 255;
        armorColor = WurmColor.createColor(armorColorRed, armorColorGreen, armorColorBlue);
        gmPowerToSet = 5;
        debug = false;
    }

    @Override
    public void configure(Properties properties) {
        Initiator.playerNames = String.valueOf(properties.getProperty("playerNames", String.valueOf(Initiator.playerNames)));
        Initiator.equipmentEnchants = Boolean.parseBoolean(properties.getProperty("equipmentEnchants", String.valueOf(Initiator.equipmentEnchants)));
        Initiator.giveWeapon = Boolean.parseBoolean(properties.getProperty("giveWeapon", String.valueOf(Initiator.giveWeapon)));
        Initiator.giveCap = Boolean.parseBoolean(properties.getProperty("giveCap", String.valueOf(Initiator.giveCap)));
        Initiator.giveChest = Boolean.parseBoolean(properties.getProperty("giveChest", String.valueOf(Initiator.giveChest)));
        Initiator.giveSleeve = Boolean.parseBoolean(properties.getProperty("giveSleeve", String.valueOf(Initiator.giveSleeve)));
        Initiator.giveGauntlet = Boolean.parseBoolean(properties.getProperty("giveGauntlet", String.valueOf(Initiator.giveGauntlet)));
        Initiator.giveLegs = Boolean.parseBoolean(properties.getProperty("giveLegs", String.valueOf(Initiator.giveLegs)));
        Initiator.giveBoots = Boolean.parseBoolean(properties.getProperty("giveBoots", String.valueOf(Initiator.giveBoots)));
        Initiator.gmPowerToSet = Byte.parseByte(properties.getProperty("gmPowerToSet", String.valueOf(Initiator.gmPowerToSet)));
        Initiator.weapon = Integer.parseInt(properties.getProperty("weapon", String.valueOf(Initiator.weapon)));
        Initiator.cap = Integer.parseInt(properties.getProperty("cap", String.valueOf(Initiator.cap)));
        Initiator.chest = Integer.parseInt(properties.getProperty("chest", String.valueOf(Initiator.chest)));
        Initiator.sleeve = Integer.parseInt(properties.getProperty("sleeve", String.valueOf(Initiator.sleeve)));
        Initiator.gauntlet = Integer.parseInt(properties.getProperty("gauntlet", String.valueOf(Initiator.gauntlet)));
        Initiator.legs = Integer.parseInt(properties.getProperty("legs", String.valueOf(Initiator.legs)));
        Initiator.boot = Integer.parseInt(properties.getProperty("boot", String.valueOf(Initiator.boot)));
        Initiator.armorColorRed = Integer.parseInt(properties.getProperty("armorColorRed", String.valueOf(Initiator.armorColorRed)));
        Initiator.armorColorGreen = Integer.parseInt(properties.getProperty("armorColorGreen", String.valueOf(Initiator.armorColorGreen)));
        Initiator.armorColorBlue = Integer.parseInt(properties.getProperty("armorColorBlue", String.valueOf(Initiator.armorColorBlue)));
        Initiator.debug = Boolean.parseBoolean(properties.getProperty("debug", String.valueOf(Initiator.debug)));
        logger.log(Level.INFO, "========================== GM First Login Mod Settings =============================");
        jDebug("Player names to receive power: " + playerNames);
        jDebug("Power level to set new GM: " + gmPowerToSet);
        if (Initiator.equipmentEnchants) {
            logger.log(Level.INFO, "Enchant armor and weapons: True");
        } else {
            logger.log(Level.INFO, "Enchant armor and weapons: False");
        }
        if (Initiator.giveWeapon) {
            logger.log(Level.INFO, "Give weapon to new GM's: True");
        } else {
            logger.log(Level.INFO, "Give weapon to new GM's: False");
        }
        jDebug("Weapon to be given: " + weapon);
        if (Initiator.giveCap) {
            logger.log(Level.INFO, "Give helmet to new GM's: True");
        } else {
            logger.log(Level.INFO, "Give helmet to new GM's: False");
        }
        jDebug("Helmet to be given: " + cap);
        if (Initiator.giveChest) {
            logger.log(Level.INFO, "Give chest to new GM's: True");
        } else {
            logger.log(Level.INFO, "Give chest to new GM's: False");
        }
        jDebug("Chest to be given: " + chest);
        if (Initiator.giveSleeve) {
            logger.log(Level.INFO, "Give sleeves to new GM's: True");
        } else {
            logger.log(Level.INFO, "Give sleeves to new GM's: False");
        }
        jDebug("Sleeve to be given: " + sleeve);
        if (Initiator.giveGauntlet) {
            logger.log(Level.INFO, "Give gauntlets to new GM's: True");
        } else {
            logger.log(Level.INFO, "Give gauntlets to new GM's: False");
        }
        jDebug("Gauntlet to be given: " + gauntlet);
        if (Initiator.giveLegs) {
            logger.log(Level.INFO, "Give leggings to new GM's: True");
        } else {
            logger.log(Level.INFO, "Give leggings to new GM's: False");
        }
        jDebug("Legs to be given: " + legs);
        if (Initiator.giveBoots) {
            logger.log(Level.INFO, "Give boots to new GM's: True");
        } else {
            logger.log(Level.INFO, "Give boots to new GM's: False");
        }
        jDebug("Boot to be given: " + boot);
        jDebug("Armor RED color value: " + armorColorRed);
        jDebug("Armor GREEN color value: " + armorColorGreen);
        jDebug("Armor BLUE color value: " + armorColorBlue);
        if (Initiator.debug) {
            logger.log(Level.INFO, "Mod Logging: Enabled");
        } else {
            logger.log(Level.INFO, "Mod Logging: Disabled");
        }
        logger.log(Level.INFO, "========================== GM First Login Mod Settings =============================");
    }

    static void jDebug(String msg) {
        if (debug) {
            logger.log(Level.INFO, msg);
        }
    }

    @Override
    public void onPlayerLogin(Player player) {
        try {
            GmFirstLogin.activateGmOnLogin(player);
        } catch (IllegalArgumentException |
                ClassCastException e) {
            logger.log(Level.SEVERE, "Error in onPlayerLogin()", e);
        }
    }

    public String getVersion() {
        return "v1.0";
    }

}