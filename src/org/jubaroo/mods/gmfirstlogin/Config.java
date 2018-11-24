
package org.jubaroo.mods.gmfirstlogin;

import com.wurmonline.server.items.ItemList;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.jubaroo.mods.gmfirstlogin.Constants.*;
import static org.jubaroo.mods.gmfirstlogin.Initiator.jDebug;

class Config {
    private static Logger logger;
    
    static void doConfig(Properties properties) {
        Constants.playerName0 = String.valueOf(properties.getProperty("playerName0", String.valueOf(Constants.playerName0)));
        Constants.playerName1 = String.valueOf(properties.getProperty("playerName1", String.valueOf(Constants.playerName1)));
        Constants.playerName2 = String.valueOf(properties.getProperty("playerName2", String.valueOf(Constants.playerName2)));
        Constants.playerName3 = String.valueOf(properties.getProperty("playerName3", String.valueOf(Constants.playerName3)));
        Constants.playerName4 = String.valueOf(properties.getProperty("playerName4", String.valueOf(Constants.playerName4)));
        Constants.playerName5 = String.valueOf(properties.getProperty("playerName5", String.valueOf(Constants.playerName5)));
        Constants.playerName6 = String.valueOf(properties.getProperty("playerName6", String.valueOf(Constants.playerName6)));
        Constants.playerName7 = String.valueOf(properties.getProperty("playerName7", String.valueOf(Constants.playerName7)));
        Constants.playerName8 = String.valueOf(properties.getProperty("playerName8", String.valueOf(Constants.playerName8)));
        Constants.playerName9 = String.valueOf(properties.getProperty("playerName9", String.valueOf(Constants.playerName9)));
        Constants.enableAPlayers = Boolean.parseBoolean(properties.getProperty("enableAPlayers", String.valueOf(Constants.enableAPlayers)));
        Constants.skillBoost = Boolean.parseBoolean(properties.getProperty("skillBoost", String.valueOf(Constants.skillBoost)));
        Constants.skillBoostValue = Double.valueOf(properties.getProperty("skillBoostValue", String.valueOf(Constants.skillBoostValue)));
        Constants.gmPowerToSet = Byte.parseByte(properties.getProperty("gmPowerToSet", String.valueOf(Constants.gmPowerToSet)));
        Constants.equipmentEnchants = Boolean.parseBoolean(properties.getProperty("equipmentEnchants", String.valueOf(Constants.equipmentEnchants)));
        Constants.giveWeapon = Boolean.parseBoolean(properties.getProperty("giveWeapon", String.valueOf(Constants.giveWeapon)));
        Constants.weapon = Integer.parseInt(properties.getProperty("weapon", String.valueOf(Constants.weapon)));
        Constants.weaponColorRed = Integer.parseInt(properties.getProperty("weaponColorRed", String.valueOf(Constants.weaponColorRed)));
        Constants.weaponColorGreen = Integer.parseInt(properties.getProperty("weaponColorGreen", String.valueOf(Constants.weaponColorGreen)));
        Constants.weaponColorBlue = Integer.parseInt(properties.getProperty("weaponColorBlue", String.valueOf(Constants.weaponColorBlue)));
        Constants.giveCap = Boolean.parseBoolean(properties.getProperty("giveCap", String.valueOf(Constants.giveCap)));
        Constants.cap = Integer.parseInt(properties.getProperty("cap", String.valueOf(Constants.cap)));
        Constants.capColorRed = Integer.parseInt(properties.getProperty("capColorRed", String.valueOf(Constants.capColorRed)));
        Constants.capColorGreen = Integer.parseInt(properties.getProperty("capColorGreen", String.valueOf(Constants.capColorGreen)));
        Constants.capColorBlue = Integer.parseInt(properties.getProperty("capColorBlue", String.valueOf(Constants.capColorBlue)));
        Constants.capColorRed1 = Integer.parseInt(properties.getProperty("capColorRed1", String.valueOf(Constants.capColorRed1)));
        Constants.capColorGreen1 = Integer.parseInt(properties.getProperty("capColorGreen1", String.valueOf(Constants.capColorGreen1)));
        Constants.capColorBlue1 = Integer.parseInt(properties.getProperty("capColorBlue1", String.valueOf(Constants.capColorBlue1)));
        Constants.giveChest = Boolean.parseBoolean(properties.getProperty("giveChest", String.valueOf(Constants.giveChest)));
        Constants.chest = Integer.parseInt(properties.getProperty("chest", String.valueOf(Constants.chest)));
        Constants.chestColorRed = Integer.parseInt(properties.getProperty("chestColorRed", String.valueOf(Constants.chestColorRed)));
        Constants.chestColorGreen = Integer.parseInt(properties.getProperty("chestColorGreen", String.valueOf(Constants.chestColorGreen)));
        Constants.chestColorBlue = Integer.parseInt(properties.getProperty("chestColorBlue", String.valueOf(Constants.chestColorBlue)));
        Constants.chestColorRed1 = Integer.parseInt(properties.getProperty("chestColorRed1", String.valueOf(Constants.chestColorRed1)));
        Constants.chestColorGreen1 = Integer.parseInt(properties.getProperty("chestColorGreen1", String.valueOf(Constants.chestColorGreen1)));
        Constants.chestColorBlue1 = Integer.parseInt(properties.getProperty("chestColorBlue1", String.valueOf(Constants.chestColorBlue1)));
        Constants.giveSleeve = Boolean.parseBoolean(properties.getProperty("giveSleeve", String.valueOf(Constants.giveSleeve)));
        Constants.sleeve = Integer.parseInt(properties.getProperty("sleeve", String.valueOf(Constants.sleeve)));
        Constants.sleeveColorRed = Integer.parseInt(properties.getProperty("sleeveColorRed", String.valueOf(Constants.sleeveColorRed)));
        Constants.sleeveColorGreen = Integer.parseInt(properties.getProperty("sleeveColorGreen", String.valueOf(Constants.sleeveColorGreen)));
        Constants.sleeveColorBlue = Integer.parseInt(properties.getProperty("sleeveColorBlue", String.valueOf(Constants.sleeveColorBlue)));
        Constants.sleeveColorRed1 = Integer.parseInt(properties.getProperty("sleeveColorRed1", String.valueOf(Constants.sleeveColorRed1)));
        Constants.sleeveColorGreen1 = Integer.parseInt(properties.getProperty("sleeveColorGreen1", String.valueOf(Constants.sleeveColorGreen1)));
        Constants.sleeveColorBlue1 = Integer.parseInt(properties.getProperty("sleeveColorBlue1", String.valueOf(Constants.sleeveColorBlue1)));
        Constants.giveGauntlet = Boolean.parseBoolean(properties.getProperty("giveGauntlet", String.valueOf(Constants.giveGauntlet)));
        Constants.gauntlet = Integer.parseInt(properties.getProperty("gauntlet", String.valueOf(Constants.gauntlet)));
        Constants.gauntletColorRed = Integer.parseInt(properties.getProperty("gauntletColorRed", String.valueOf(Constants.gauntletColorRed)));
        Constants.gauntletColorGreen = Integer.parseInt(properties.getProperty("gauntletColorGreen", String.valueOf(Constants.gauntletColorGreen)));
        Constants.gauntletColorBlue = Integer.parseInt(properties.getProperty("gauntletColorBlue", String.valueOf(Constants.gauntletColorBlue)));
        Constants.gauntletColorRed1 = Integer.parseInt(properties.getProperty("gauntletColorRed1", String.valueOf(Constants.gauntletColorRed1)));
        Constants.gauntletColorGreen1 = Integer.parseInt(properties.getProperty("gauntletColorGreen1", String.valueOf(Constants.gauntletColorGreen1)));
        Constants.gauntletColorBlue1 = Integer.parseInt(properties.getProperty("gauntletColorBlue1", String.valueOf(Constants.gauntletColorBlue1)));
        Constants.giveLegs = Boolean.parseBoolean(properties.getProperty("giveLegs", String.valueOf(Constants.giveLegs)));
        Constants.legs = Integer.parseInt(properties.getProperty("legs", String.valueOf(Constants.legs)));
        Constants.legsColorRed = Integer.parseInt(properties.getProperty("legsColorRed", String.valueOf(Constants.legsColorRed)));
        Constants.legsColorGreen = Integer.parseInt(properties.getProperty("legsColorGreen", String.valueOf(Constants.legsColorGreen)));
        Constants.legsColorBlue = Integer.parseInt(properties.getProperty("legsColorBlue", String.valueOf(Constants.legsColorBlue)));
        Constants.legsColorRed1 = Integer.parseInt(properties.getProperty("legsColorRed1", String.valueOf(Constants.legsColorRed1)));
        Constants.legsColorGreen1 = Integer.parseInt(properties.getProperty("legsColorGreen1", String.valueOf(Constants.legsColorGreen1)));
        Constants.legsColorBlue1 = Integer.parseInt(properties.getProperty("legsColorBlue1", String.valueOf(Constants.legsColorBlue1)));
        Constants.giveBoots = Boolean.parseBoolean(properties.getProperty("giveBoots", String.valueOf(Constants.giveBoots)));
        Constants.boot = Integer.parseInt(properties.getProperty("boot", String.valueOf(Constants.boot)));
        Constants.bootColorRed = Integer.parseInt(properties.getProperty("bootColorRed", String.valueOf(Constants.bootColorRed)));
        Constants.bootColorGreen = Integer.parseInt(properties.getProperty("bootColorGreen", String.valueOf(Constants.bootColorGreen)));
        Constants.bootColorBlue = Integer.parseInt(properties.getProperty("bootColorBlue", String.valueOf(Constants.bootColorBlue)));
        bootColorRed1 = Integer.parseInt(properties.getProperty("bootColorRed1", String.valueOf(bootColorRed1)));
        bootColorGreen1 = Integer.parseInt(properties.getProperty("bootColorGreen1", String.valueOf(bootColorGreen1)));
        bootColorBlue1 = Integer.parseInt(properties.getProperty("bootColorBlue1", String.valueOf(bootColorBlue1)));
        Constants.debug = Boolean.parseBoolean(properties.getProperty("debug", String.valueOf(Constants.debug)));
        logger.log(Level.INFO, "========================== GM First Login Mod Settings =============================");
        if (!enableAPlayers) {
            jDebug("Player names to receive power:");
            if (!playerName0.equals("$NO_NAME$")) {
                jDebug(String.format("%s", playerName0));
            }
            if (!playerName1.equals("$NO_NAME$")) {
                jDebug(String.format("%s", playerName1));
            }
            if (!playerName2.equals("$NO_NAME$")) {
                jDebug(String.format("%s", playerName2));
            }
            if (!playerName3.equals("$NO_NAME$")) {
                jDebug(String.format("%s", playerName3));
            }
            if (!playerName4.equals("$NO_NAME$")) {
                jDebug(String.format("%s", playerName4));
            }
            if (!playerName5.equals("$NO_NAME$")) {
                jDebug(String.format("%s", playerName5));
            }
            if (!playerName6.equals("$NO_NAME$")) {
                jDebug(String.format("%s", playerName6));
            }
            if (!playerName7.equals("$NO_NAME$")) {
                jDebug(String.format("%s", playerName7));
            }
            if (!playerName8.equals("$NO_NAME$")) {
                jDebug(String.format("%s", playerName8));
            }
            if (!playerName9.equals("$NO_NAME$")) {
                jDebug(String.format("%s", playerName9));
            }
        } else jDebug("All player given GM at login: Enabled");
        jDebug("=============================================");
        if (Constants.skillBoost) {
            jDebug(String.format("GM skill boost to %s: Enabled", skillBoostValue));
        } else {
            jDebug(String.format("GM skill boost to %s: Disabled", skillBoostValue));
        }
        jDebug("=============================================");
        jDebug(String.format("Power level to set new GM: %s", gmPowerToSet));
        if (Constants.equipmentEnchants) {
            jDebug("Enchant armor and weapons: True");
        } else {
            jDebug("Enchant armor and weapons: False");
        }
        jDebug("=============================================");
        if (Constants.giveWeapon) {
            jDebug("Give weapon to new GM's: True");
        } else {
            jDebug("Give weapon to new GM's: False");
        }
        jDebug("Weapon to be given: " + weapon);
        jDebug(String.format("Weapon RGB value: %s, %s, %s", weaponColorRed, weaponColorGreen, weaponColorBlue));
        jDebug("=============================================");
        if (Constants.giveCap) {
            jDebug("Give helmet to new GM's: True");
        } else {
            jDebug("Give helmet to new GM's: False");
        }
        jDebug("Helmet to be given: " + cap);
        jDebug(String.format("Helmet RGB value0: %s, %s, %s", capColorRed, capColorGreen, capColorBlue));
        jDebug(String.format("Helmet RGB value1: %s, %s, %s", capColorRed1, capColorGreen1, capColorBlue1));
        jDebug("=============================================");
        if (Constants.giveChest) {
            jDebug("Give chest to new GM's: True");
        } else {
            jDebug("Give chest to new GM's: False");
        }
        jDebug("Chest to be given: " + chest);
        if (Constants.chest == ItemList.dragonScaleJacket | Constants.chest == ItemList.dragonLeatherJacket | Constants.chest == ItemList.leatherJacket | Constants.chest == ItemList.studdedLeatherJacket) {
            GmFirstLogin.material = 16;
        } else if (Constants.chest == ItemList.chainJacket | Constants.chest == ItemList.plateJacket) {
            GmFirstLogin.material = 67;
        } else GmFirstLogin.material = 17;
        jDebug(String.format("Chest RGB value0: %s, %s, %s", chestColorRed, chestColorGreen, chestColorBlue));
        jDebug(String.format("Chest RGB value1: %s, %s, %s", chestColorRed1, chestColorGreen1, chestColorBlue1));
        jDebug("=============================================");
        if (Constants.giveSleeve) {
            jDebug("Give sleeves to new GM's: True");
        } else {
            jDebug("Give sleeves to new GM's: False");
        }
        jDebug("Sleeve to be given: " + sleeve);
        jDebug(String.format("Sleeve RGB value0: %s, %s, %s", sleeveColorRed, sleeveColorGreen, sleeveColorBlue));
        jDebug(String.format("Sleeve RGB value1: %s, %s, %s", sleeveColorRed1, sleeveColorGreen1, sleeveColorBlue1));
        jDebug("=============================================");
        if (Constants.giveGauntlet) {
            jDebug("Give gauntlets to new GM's: True");
        } else {
            jDebug("Give gauntlets to new GM's: False");
        }
        jDebug("Gauntlet to be given: " + gauntlet);
        jDebug(String.format("Gauntlet RGB value0: %s, %s, %s", gauntletColorRed, gauntletColorGreen, gauntletColorBlue));
        jDebug(String.format("Gauntlet RGB value1: %s, %s, %s", gauntletColorRed1, gauntletColorGreen1, gauntletColorBlue1));
        jDebug("=============================================");
        if (Constants.giveLegs) {
            jDebug("Give leggings to new GM's: True");
        } else {
            jDebug("Give leggings to new GM's: False");
        }
        jDebug("Legs to be given: " + legs);
        jDebug(String.format("Legs RGB value0: %s, %s, %s", legsColorRed, legsColorGreen, legsColorBlue));
        jDebug(String.format("Legs RGB value1: %s, %s, %s", legsColorRed1, legsColorGreen1, legsColorBlue1));
        jDebug("=============================================");
        if (Constants.giveBoots) {
            jDebug("Give boots to new GM's: True");
        } else {
            jDebug("Give boots to new GM's: False");
        }
        jDebug("Boot to be given: " + boot);
        jDebug(String.format("Boot RGB value0: %s, %s, %s", bootColorRed, bootColorGreen, bootColorBlue));
        jDebug(String.format("Boot RGB value1: %s, %s, %s", bootColorRed1, bootColorGreen1, bootColorBlue1));
        jDebug("=============================================");
        if (Constants.debug) {
            jDebug("Mod Logging: Enabled");
        } else {
            jDebug("Mod Logging: Disabled");
        }
        logger.log(Level.INFO, "========================== GM First Login Mod Settings =============================");
    }

    static {
        logger = Logger.getLogger(Config.class.getName());

    }

}
