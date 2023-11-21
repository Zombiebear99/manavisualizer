package org.zombie.manavisualizer;

import net.minecraft.network.chat.Component;

import java.text.DecimalFormat;

public final class ManaNumberFormatting {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###.##");

    private static String numericalDisplay(int mana) {
        return String.format("%,d", mana);
    }

    private static String shortenedNumericalDisplay(int mana) {
        String abbreviation;
        double shortenedMana = mana;
        if (mana >= 1000000000) {
            abbreviation = "B";
            shortenedMana /= 1000000000;
        } else if (mana >= 1000000) {
            abbreviation = "M";
            shortenedMana /= 1000000;
        } else if (mana >= 1000) {
            abbreviation = "K";
            shortenedMana /= 1000;
        } else {
            return Integer.toString(mana);
        }
        return DECIMAL_FORMAT.format(shortenedMana) + abbreviation;
    }

    public static String amount(int mana) {
        return numericalDisplay(mana);
    }

    private static String percentageDisplay(int mana, int maxMana) {
        return DECIMAL_FORMAT.format(((double) mana / maxMana) * 100);
    }

    public static String percentage(int mana, int maxMana) {
        return percentageDisplay(mana, maxMana);
    }

    public static String capacity(int mana, int maxMana) {
        return String.format(
                "Mana: %s/%s (%s%%)",
                shortenedNumericalDisplay(mana),
                shortenedNumericalDisplay(maxMana),
                percentageDisplay(mana, maxMana)
        );
    }

    public static Component manaLevel(int current, int max) {
        return Component.translatable("item.manareader.info", shortenedNumericalDisplay(current), shortenedNumericalDisplay(max));
    }
}
