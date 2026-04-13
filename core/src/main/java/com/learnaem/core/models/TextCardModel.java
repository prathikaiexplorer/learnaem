package com.learnaem.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

/**
 * Sling Model for the TextCard component.
 *
 * Demonstrates:
 * - @Model annotation with adaptables = SlingHttpServletRequest
 * - @ValueMapValue injection from the component's JCR node
 * - @Default for fallback values
 * - DefaultInjectionStrategy.OPTIONAL to avoid null-check failures
 */
@Model(
    adaptables = SlingHttpServletRequest.class,
    adapters = {TextCardModel.class, ComponentExporter.class},
    resourceType = TextCardModel.RESOURCE_TYPE,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(
    name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
    extensions = ExporterConstants.SLING_MODEL_EXTENSION
)
public class TextCardModel implements ComponentExporter {

    /** Sling resource type — must match the component node in ui.apps */
    public static final String RESOURCE_TYPE = "learnaem/components/textcard";

    @ValueMapValue
    @Default(values = "Default Title")
    private String title;

    @ValueMapValue
    @Default(values = "Default description text. Edit this component to add your own content.")
    private String description;

    @ValueMapValue
    @Default(values = "Learn More")
    private String linkText;

    @ValueMapValue
    @Default(values = "#")
    private String linkUrl;

    /**
     * @return The card title entered by the author in the dialog.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return The card description text.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return The CTA link label.
     */
    public String getLinkText() {
        return linkText;
    }

    /**
     * @return The CTA link URL (href).
     */
    public String getLinkUrl() {
        return linkUrl;
    }

    /**
     * Required by ComponentExporter for JSON model export.
     */
    @Override
    public String getExportedType() {
        return RESOURCE_TYPE;
    }
}
