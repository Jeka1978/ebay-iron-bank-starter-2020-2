package com.ebayirnbank.ebayironbankstarter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Data
@ConfigurationProperties(prefix = "raven")
public class RavenProps {
    private String destination;
}
