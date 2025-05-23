package com.dgtic.unam.configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton para la configuración de la aplicación.
 * Este singleton se utiliza para almacenar configuraciones de la aplicación
 * que pueden ser accedidas desde cualquier parte del código.
 */
public class AppConfigSingleton {
    private static AppConfigSingleton instance;
    private final Map<String, String> configurations;

    /**
     * Constructor privado para evitar la instanciación externa.
     * Inicializa las configuraciones por defecto.
     */
    private AppConfigSingleton() {
        // Constructor privado para evitar la instanciación externa
        configurations = new HashMap<>();
        // Cargar configuraciones por defecto
        configurations.put("stock.max", "100");
        configurations.put("stock.min", "1");
        configurations.put("stock.default", "10");
        configurations.put("auth.user", "admin");
        configurations.put("auth.password", "admin");
        configurations.put("auth.token", "abcd123=");
        configurations.put("auth.token.expiration", "3600");
        configurations.put("static.imagesUrl", "http://localhost:8080/images");
    }

    /**
     * Método para obtener la instancia única de AppConfigSingleton.
     * Si la instancia no existe, se crea una nueva.
     *
     * @return La instancia única de AppConfigSingleton.
     */
    public static AppConfigSingleton getInstance() {
        if (instance == null) {
            instance = new AppConfigSingleton();
        }
        return instance;
    }

    /**
     * Método para obtener una configuración específica.
     *
     * @param key La clave de la configuración que se desea obtener.
     * @return El valor de la configuración correspondiente a la clave proporcionada.
     */
    public Map<String, String> getConfigurations() {
        return configurations;
    }
}
