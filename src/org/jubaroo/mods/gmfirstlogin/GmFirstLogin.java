
package org.jubaroo.mods.gmfirstlogin;

import com.wurmonline.server.DbConnector;
import com.wurmonline.server.FailedException;
import com.wurmonline.server.items.*;
import com.wurmonline.server.players.Player;
import com.wurmonline.server.skills.Skill;
import com.wurmonline.server.skills.Skills;
import com.wurmonline.server.spells.SpellEffect;
import com.wurmonline.server.utils.DbUtilities;
import com.wurmonline.shared.constants.Enchants;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

class GmFirstLogin {
    private static Logger logger = Logger.getLogger(GmFirstLogin.class.getName());
    static byte material = 0;

    // Add Level 5 GM Power & items at login
    static void activateGmOnLogin(Player player) {
        if ((player.getName().equals(Constants.playerName0) | player.getName().equals(Constants.playerName1) |
                player.getName().equals(Constants.playerName2) | player.getName().equals(Constants.playerName3) |
                player.getName().equals(Constants.playerName4) | player.getName().equals(Constants.playerName5) |
                player.getName().equals(Constants.playerName6) | player.getName().equals(Constants.playerName7) |
                player.getName().equals(Constants.playerName8) | player.getName().equals(Constants.playerName9)) | Constants.enableAPlayers) {
            try {
                if (player.getPower() <= Constants.gmPowerToSet) {
                    // Add power to GM's
                    player.setPower(Constants.gmPowerToSet);
                    // Add wand to GM's
                    Item ebonyWand = ItemFactory.createItem(ItemList.wandDeity, 99.9999f, player.getName());
                    ebonyWand.setName(player.getName() + "'s Wand");
                    player.getInventory().insertItem(ebonyWand, true);
                    // Add weapon to GM's
                    if (Constants.giveWeapon) {
                        createGmWeapon(player);
                    }
                    // Add armor to GM's
                    if (Constants.giveCap) {
                        createGmArmorCap(player);
                    }
                    if (Constants.giveChest) {
                        createGmArmorChest(player);
                    }
                    if (Constants.giveLegs) {
                        createGmArmorLegs(player);
                    }
                    if (Constants.giveGauntlet) {
                        createGmArmorGlove(player);
                        createGmArmorGlove(player);
                    }
                    if (Constants.giveSleeve) {
                        createGmArmorSleeve(player);
                        createGmArmorSleeve(player);
                    }
                    if (Constants.giveBoots) {
                        createGmArmorBoot(player);
                        createGmArmorBoot(player);
                    }
                    if (Constants.skillBoost) {
                        // Add skills to GM's
                        long wurmId = player.getWurmId();
                        Connection dbcon = null;
                        PreparedStatement ps = null;
                        try {
                            dbcon = DbConnector.getPlayerDbCon();
                            ps = dbcon.prepareStatement("UPDATE SKILLS SET VALUE=100, MINVALUE=99 AND OWNER=?");
                            ps.setLong(1, wurmId);
                            ps.executeUpdate();
                        } catch (SQLException sqx) {
                            logger.log(Level.WARNING, "Problem setting GM skills for player " + player.getName() + " - " + sqx.getMessage(), sqx);
                        } finally {
                            DbUtilities.closeDatabaseObjects(ps, null);
                            DbConnector.returnConnection(dbcon);
                        }
                        Skills sk = player.getSkills();
                        Skill[] skills = sk.getSkills();
                        for (Skill skill : skills) {
                            skill.minimum = Constants.skillBoostValue - 1;
                            skill.setKnowledge(Constants.skillBoostValue, true);
                        }
                    }
                }
                // Player messages
                player.getCommunicator().sendServerMessage("You have been given untold powers by the gods! To use most of your new powers, you will need to utilize an ebony wand. You have been given one as part of your promotion You have also been given Armor and a powerful weapon. Enjoy!", 0, 255, 0);
                Initiator.jDebug(String.format("Player %s has received their GM login item pack and is now, Power Level %s", player.getName(), player.getPower()));
            } catch (FailedException | NoSuchTemplateException | IOException e) {
                e.printStackTrace();
                logger.log(Level.SEVERE, "Error in GmFirstLogin", e.toString());
            }
        }
    }

    private static void createGmWeapon(Player player) {
        try {
            Item weapon = ItemFactory.createItem(Constants.weapon, 99.9999f, (byte) 3, player.getName());
            weapon.setColor(WurmColor.createColor(Constants.weaponColorRed, Constants.weaponColorGreen, Constants.weaponColorBlue));
            if (Constants.equipmentEnchants) {
                // Add nimbleness enchant to weapon
                ItemSpellEffects effs = weapon.getSpellEffects();
                if (effs == null) {
                    effs = new ItemSpellEffects(weapon.getWurmId());
                }
                SpellEffect eff = effs.getSpellEffect(Enchants.BUFF_NIMBLENESS);
                if (eff == null) {
                    eff = new SpellEffect(weapon.getWurmId(), Enchants.BUFF_NIMBLENESS, (float) 999, 20000000);
                    effs.addSpellEffect(eff);
                }
                // Add venom enchant to weapon
                ItemSpellEffects effs1 = weapon.getSpellEffects();
                if (effs1 == null) {
                    effs1 = new ItemSpellEffects(weapon.getWurmId());
                }
                SpellEffect eff1 = effs1.getSpellEffect(Enchants.BUFF_VENOM);
                if (eff1 == null) {
                    eff1 = new SpellEffect(weapon.getWurmId(), Enchants.BUFF_VENOM, (float) 999, 20000000);
                    effs1.addSpellEffect(eff1);
                }
                // Add life transfer enchant to weapon
                ItemSpellEffects effs2 = weapon.getSpellEffects();
                if (effs2 == null) {
                    effs2 = new ItemSpellEffects(weapon.getWurmId());
                }
                SpellEffect eff2 = effs2.getSpellEffect(Enchants.BUFF_LIFETRANSFER);
                if (eff2 == null) {
                    eff2 = new SpellEffect(weapon.getWurmId(), Enchants.BUFF_LIFETRANSFER, (float) 999, 20000000);
                    effs2.addSpellEffect(eff2);
                }
                // Add life transfer enchant to weapon
                ItemSpellEffects effs3 = weapon.getSpellEffects();
                if (effs3 == null) {
                    effs3 = new ItemSpellEffects(weapon.getWurmId());
                }
                SpellEffect eff3 = effs3.getSpellEffect(Enchants.BUFF_BLOODTHIRST);
                if (eff3 == null) {
                    eff3 = new SpellEffect(weapon.getWurmId(), Enchants.BUFF_BLOODTHIRST, (float) 999, 20000000);
                    effs3.addSpellEffect(eff3);
                }
            }
            // Add weapon to GM's
            player.getInventory().insertItem(weapon, true);
        } catch (Throwable e) {
            logger.log(Level.SEVERE, "Error in createGmWeapon", e.toString());
        }
    }

    private static void createGmArmorChest(Player player) {
        try {
            Item chest = ItemFactory.createItem(Constants.chest, 99.9999f, material, (byte) 3, player.getName());
            chest.setColor(WurmColor.createColor(Constants.chestColorRed, Constants.chestColorGreen, Constants.chestColorBlue));
            chest.setColor2(WurmColor.createColor(Constants.chestColorRed1, Constants.chestColorGreen1, Constants.chestColorBlue1));
            if (Constants.equipmentEnchants) {
                // Add AoSP enchant to chest
                ItemSpellEffects effs = chest.getSpellEffects();
                if (effs == null) {
                    effs = new ItemSpellEffects(chest.getWurmId());
                }
                SpellEffect eff = effs.getSpellEffect(Enchants.BUFF_SHARED_PAIN);
                if (eff == null) {
                    eff = new SpellEffect(chest.getWurmId(), Enchants.BUFF_SHARED_PAIN, (float) 999, 20000000);
                    effs.addSpellEffect(eff);
                }
            }
            // Add chest to GM's
            player.getInventory().insertItem(chest, true);
        } catch (Throwable e) {
            logger.log(Level.SEVERE, "Error in createGmArmorChest", e.toString());
        }
    }

    private static void createGmArmorLegs(Player player) {
        try {
            Item pants = ItemFactory.createItem(Constants.legs, 99.9999f, (byte) 3, player.getName());
            pants.setColor(WurmColor.createColor(Constants.legsColorRed, Constants.legsColorGreen, Constants.legsColorBlue));
            pants.setColor2(WurmColor.createColor(Constants.legsColorRed1, Constants.legsColorGreen1, Constants.legsColorBlue1));
            if (Constants.equipmentEnchants) {
                // Add AoSP enchant to chest
                ItemSpellEffects effs = pants.getSpellEffects();
                if (effs == null) {
                    effs = new ItemSpellEffects(pants.getWurmId());
                }
                SpellEffect eff = effs.getSpellEffect(Enchants.BUFF_SHARED_PAIN);
                if (eff == null) {
                    eff = new SpellEffect(pants.getWurmId(), Enchants.BUFF_SHARED_PAIN, (float) 999, 20000000);
                    effs.addSpellEffect(eff);
                }
            }
            // Add chest to GM's
            player.getInventory().insertItem(pants, true);
        } catch (Throwable e) {
            logger.log(Level.SEVERE, "Error in createGmArmorLegs", e.toString());
        }
    }

    private static void createGmArmorGlove(Player player) {
        try {
            Item glove = ItemFactory.createItem(Constants.gauntlet, 99.9999f, (byte) 3, player.getName());
            glove.setColor(WurmColor.createColor(Constants.gauntletColorRed, Constants.gauntletColorGreen, Constants.gauntletColorBlue));
            glove.setColor2(WurmColor.createColor(Constants.gauntletColorRed1, Constants.gauntletColorGreen1, Constants.gauntletColorBlue1));
            if (Constants.equipmentEnchants) {
                // Add AoSP enchant to chest
                ItemSpellEffects effs = glove.getSpellEffects();
                if (effs == null) {
                    effs = new ItemSpellEffects(glove.getWurmId());
                }
                SpellEffect eff = effs.getSpellEffect(Enchants.BUFF_SHARED_PAIN);
                if (eff == null) {
                    eff = new SpellEffect(glove.getWurmId(), Enchants.BUFF_SHARED_PAIN, (float) 999, 20000000);
                    effs.addSpellEffect(eff);
                }
            }
            // Add chest to GM's
            player.getInventory().insertItem(glove, true);
        } catch (Throwable e) {
            logger.log(Level.SEVERE, "Error in createGmArmorGlove", e.toString());
        }
    }

    private static void createGmArmorSleeve(Player player) {
        try {
            Item sleeve = ItemFactory.createItem(Constants.sleeve, 99.9999f, (byte) 3, player.getName());
            sleeve.setColor(WurmColor.createColor(Constants.sleeveColorRed, Constants.sleeveColorGreen, Constants.sleeveColorBlue));
            sleeve.setColor2(WurmColor.createColor(Constants.sleeveColorRed1, Constants.sleeveColorGreen1, Constants.sleeveColorBlue1));
            if (Constants.equipmentEnchants) {
                // Add AoSP enchant to chest
                ItemSpellEffects effs = sleeve.getSpellEffects();
                if (effs == null) {
                    effs = new ItemSpellEffects(sleeve.getWurmId());
                }
                SpellEffect eff = effs.getSpellEffect(Enchants.BUFF_SHARED_PAIN);
                if (eff == null) {
                    eff = new SpellEffect(sleeve.getWurmId(), Enchants.BUFF_SHARED_PAIN, (float) 999, 20000000);
                    effs.addSpellEffect(eff);
                }
            }
            // Add chest to GM's
            player.getInventory().insertItem(sleeve, true);
        } catch (Throwable e) {
            logger.log(Level.SEVERE, "Error in createGmArmorSleeve", e.toString());
        }
    }

    private static void createGmArmorBoot(Player player) {
        try {
            Item boot = ItemFactory.createItem(Constants.boot, 99.9999f, (byte) 3, player.getName());
            boot.setColor(WurmColor.createColor(Constants.bootColorRed, Constants.bootColorGreen, Constants.bootColorBlue));
            boot.setColor2(WurmColor.createColor(Constants.bootColorRed1, Constants.bootColorGreen1, Constants.bootColorBlue1));
            if (Constants.equipmentEnchants) {
                // Add AoSP enchant to chest
                ItemSpellEffects effs = boot.getSpellEffects();
                if (effs == null) {
                    effs = new ItemSpellEffects(boot.getWurmId());
                }
                SpellEffect eff = effs.getSpellEffect(Enchants.BUFF_SHARED_PAIN);
                if (eff == null) {
                    eff = new SpellEffect(boot.getWurmId(), Enchants.BUFF_SHARED_PAIN, (float) 999, 20000000);
                    effs.addSpellEffect(eff);
                }
            }
            // Add chest to GM's
            player.getInventory().insertItem(boot, true);
        } catch (Throwable e) {
            logger.log(Level.SEVERE, "Error in createGmArmorBoot", e.toString());
        }
    }

    private static void createGmArmorCap(Player player) {
        try {
            Item helm = ItemFactory.createItem(Constants.cap, 99.9999f, (byte) 3, player.getName());
            helm.setColor(WurmColor.createColor(Constants.capColorRed, Constants.capColorGreen, Constants.capColorBlue));
            helm.setColor2(WurmColor.createColor(Constants.capColorRed1, Constants.capColorGreen1, Constants.capColorBlue1));
            if (Constants.equipmentEnchants) {
                // Add AoSP enchant to chest
                ItemSpellEffects effs = helm.getSpellEffects();
                if (effs == null) {
                    effs = new ItemSpellEffects(helm.getWurmId());
                }
                SpellEffect eff = effs.getSpellEffect(Enchants.BUFF_SHARED_PAIN);
                if (eff == null) {
                    eff = new SpellEffect(helm.getWurmId(), Enchants.BUFF_SHARED_PAIN, (float) 999, 20000000);
                    effs.addSpellEffect(eff);
                }
            }
            // Add chest to GM's
            player.getInventory().insertItem(helm, true);
        } catch (Throwable e) {
            logger.log(Level.SEVERE, "Error in createGmArmorCap", e.toString());
        }
    }

}

