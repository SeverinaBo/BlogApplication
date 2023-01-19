package com.severina.BlogApp.account.databaseTests;

import com.severina.BlogApp.BlogApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.testng.annotations.Test;

@Test
public class Configuration {

    public void whenPropertiesConfig_thenInsertSucceeds() {
        SpringApplicationBuilder app = new SpringApplicationBuilder(BlogApplication.class);
        app.run();

        assertInsertSucceeds(app.context());
    }

    private void assertInsertSucceeds(ConfigurableApplicationContext context) {
    }

}
