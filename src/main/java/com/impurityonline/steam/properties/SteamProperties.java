package com.impurityonline.steam.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author impurity
 */
@Data
@Component
@ConfigurationProperties(prefix = "steam")
public class SteamProperties {
    private String key;
}
