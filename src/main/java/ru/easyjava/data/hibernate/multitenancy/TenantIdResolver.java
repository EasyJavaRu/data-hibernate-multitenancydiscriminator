package ru.easyjava.data.hibernate.multitenancy;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

/**
 * ThreadLocal based tenant storage.
 */
public class TenantIdResolver implements CurrentTenantIdentifierResolver  {
    /**
     * Tenant id value storage.
     */
    private static ThreadLocal<String> tenantId = new ThreadLocal<>();

    public final void setCurrentTenantIdentifier(final String value) {
        tenantId.set(value);
    }

    @Override
    public String resolveCurrentTenantIdentifier() {
        return tenantId.get();
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return false;
    }
}
