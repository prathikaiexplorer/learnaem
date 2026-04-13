package com.learnaem.core.models;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Unit tests for TextCardModel.
 * Uses wcm.io AEM Mocks (JUnit 5) for in-memory Sling/JCR context.
 */
@ExtendWith(AemContextExtension.class)
class TextCardModelTest {

    private final AemContext ctx = new AemContext();

    @BeforeEach
    void setUp() {
        ctx.addModelsForClasses(TextCardModel.class);
        ctx.load().json("/com/learnaem/core/models/TextCardModelTest.json", "/content");
    }

    @Test
    void testGetTitle() {
        ctx.currentResource("/content/textcard");
        TextCardModel model = ctx.request().adaptTo(TextCardModel.class);
        assertNotNull(model);
        assertEquals("Test Title", model.getTitle());
    }

    @Test
    void testGetDescription() {
        ctx.currentResource("/content/textcard");
        TextCardModel model = ctx.request().adaptTo(TextCardModel.class);
        assertNotNull(model);
        assertEquals("Test description.", model.getDescription());
    }

    @Test
    void testGetLinkText() {
        ctx.currentResource("/content/textcard");
        TextCardModel model = ctx.request().adaptTo(TextCardModel.class);
        assertNotNull(model);
        assertEquals("Click Here", model.getLinkText());
    }

    @Test
    void testDefaultFallback() {
        ctx.currentResource("/content/empty");
        TextCardModel model = ctx.request().adaptTo(TextCardModel.class);
        assertNotNull(model);
        assertEquals("Default Title", model.getTitle());
    }
}
