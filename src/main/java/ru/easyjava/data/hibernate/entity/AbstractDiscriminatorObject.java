package ru.easyjava.data.hibernate.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

import javax.persistence.MappedSuperclass;

/**
 * Base class for all discriminator based multi-tenant classes.
 */
@FilterDefs({
        @FilterDef(name = "discriminator_filter", parameters={@ParamDef( name="tenantIdValue", type="string" )} )
})
@Filters({
        @Filter(name="discriminator_filter", condition="tenantId = :tenantIdValue")
})
@MappedSuperclass
public class AbstractDiscriminatorObject extends AbstractIdentifiableObject {

    /**
     * Actual tenant id value.
     */
    @Getter
    @Setter
    private String tenantId;
}
