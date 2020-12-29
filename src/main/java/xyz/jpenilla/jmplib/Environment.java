package xyz.jpenilla.jmplib;

import org.bukkit.Bukkit;
import org.checkerframework.checker.nullness.qual.NonNull;

public class Environment {
    private static final boolean paper;
    private static final String serverPackageName;
    private static final String serverApiVersion;
    private static final int majorMinecraftVersion;

    static {
        paper = classExists("com.destroystokyo.paper.PaperConfig");
        serverPackageName = Bukkit.getServer().getClass().getPackage().getName();
        serverApiVersion = serverPackageName.substring(serverPackageName.lastIndexOf('.') + 1);
        majorMinecraftVersion = Integer.parseInt(serverApiVersion.split("_")[1]);
    }

    public static boolean classExists(final @NonNull String fullyQualifiedName) {
        try {
            Class.forName(fullyQualifiedName);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static boolean paper() {
        return Environment.paper;
    }

    public static @NonNull String serverPackageName() {
        return Environment.serverPackageName;
    }

    public static @NonNull String serverApiVersion() {
        return Environment.serverApiVersion;
    }

    public static int majorMinecraftVersion() {
        return Environment.majorMinecraftVersion;
    }
}
